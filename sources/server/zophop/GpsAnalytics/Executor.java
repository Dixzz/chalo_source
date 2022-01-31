package server.zophop.GpsAnalytics;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.models.FirebaseRef;
import server.zophop.models.Point;
import server.zophop.queue.BasicTask;
import server.zophop.queue.RabbitMQ;
import server.zophop.utils.DataMapCreator;

public class Executor {
    private RabbitMQ _rabbitMQLogger;
    private final TripsAnalyzer tripsAnalyzer = new TripsAnalyzer();

    private Executor() {
        RabbitMQ rabbitMQ = new RabbitMQ(5, Constants.getExchange(), TaskCategory.LOGGING);
        this._rabbitMQLogger = rabbitMQ;
        rabbitMQ.init();
    }

    private void addEta(Trip trip) {
        int i = 0;
        while (i < trip.get_stopSeq().size() - 1) {
            StopArrivals stopArrivals = trip.get_stopSeq().get(i);
            i++;
            StopArrivals stopArrivals2 = trip.get_stopSeq().get(i);
            if (stopArrivals2.get_stopSeqNum() - stopArrivals.get_stopSeqNum() == 1) {
                this._rabbitMQLogger.addTask(new BasicTask("1234", TaskType.ETA, DataMapCreator.etaMap(stopArrivals, stopArrivals2)));
            }
        }
    }

    private void addRoutePredicction(ConfigSettings configSettings, List<RouteAccuracy> list, String str, Agency agency) {
        for (RouteAccuracy routeAccuracy : list) {
            this._rabbitMQLogger.addTask(new BasicTask("1234", TaskType.ROUTE_PREDICTION, DataMapCreator.getRoutePredictionMap(configSettings, str, agency, routeAccuracy)));
        }
    }

    private void addStopArrival(Trip trip) {
        HashMap hashMap = new HashMap();
        hashMap.put("stops", DataMapCreator.mapStopArrivalData(trip.get_stopSeq(), trip.getTripType()));
        new Gson().toJson(hashMap);
        BasicTask basicTask = new BasicTask("1234", TaskType.STOP_ARRIVAL, hashMap);
        System.out.println(hashMap.toString());
        this._rabbitMQLogger.addTask(basicTask);
    }

    private void addTrip(Map map, String str, TaskType taskType) {
        this._rabbitMQLogger.addTask(new BasicTask(str, taskType, map));
    }

    private void execute() {
        UnirestException e;
        Exception e2;
        final ConfigSettings configSettings = new ConfigSettings();
        StopArrival stopArrival = new StopArrival();
        for (final Agency agency : Arrays.asList(Agency.values())) {
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
            Iterator<String> it = getVehiclesList(agency).iterator();
            while (it.hasNext()) {
                final String next = it.next();
                try {
                    ElasticGpsFetcher elasticGpsFetcher = new ElasticGpsFetcher();
                    List<Point> list = (List) elasticGpsFetcher.parse((Object) elasticGpsFetcher.fetch(agency.getCity(), agency.getAgency(), "bus", next, configSettings));
                    ElasticDispatchFetcher elasticDispatchFetcher = new ElasticDispatchFetcher();
                    List<String> list2 = (List) elasticDispatchFetcher.parse((Object) elasticDispatchFetcher.fetch(agency.getCity(), agency.getAgency(), "bus", next, configSettings));
                    List<GroupedStopArrivals> allApproxStopwiseArrivals = stopArrival.getAllApproxStopwiseArrivals(next, agency.getCity(), agency.getAgency(), list);
                    HashMap hashMap = new HashMap();
                    for (GroupedStopArrivals groupedStopArrivals : allApproxStopwiseArrivals) {
                        hashMap.put(groupedStopArrivals.getStop().getId(), groupedStopArrivals);
                    }
                    final List<RouteAccuracy> predictedRoutes = stopArrival.getPredictedRoutes(agency.getCity(), hashMap, list2);
                    if (predictedRoutes.size() > 2) {
                        for (RouteAccuracy routeAccuracy : predictedRoutes) {
                            if (list2.contains(routeAccuracy.getRoute().getId())) {
                                routeAccuracy.setAccuracy(routeAccuracy.getAccuracy() + 30);
                            }
                        }
                        Collections.sort(predictedRoutes);
                    }
                    if (predictedRoutes.size() != 0) {
                        try {
                            final Map<String, List<Trip>> discoverTrips = this.tripsAnalyzer.discoverTrips(agency, next, allApproxStopwiseArrivals, predictedRoutes, predictedRoutes.size() <= 2);
                            newFixedThreadPool.submit(new Callable<Void>() {
                                /* class server.zophop.GpsAnalytics.Executor.AnonymousClass1 */

                                @Override // java.util.concurrent.Callable
                                public Void call() {
                                    Executor.this.forwardToRabbit(discoverTrips, configSettings, predictedRoutes, next, agency);
                                    return null;
                                }
                            });
                        } catch (UnirestException e3) {
                            e = e3;
                        } catch (Exception e4) {
                            e2 = e4;
                            e2.printStackTrace();
                        }
                    }
                } catch (UnirestException e5) {
                    e = e5;
                    e.printStackTrace();
                } catch (Exception e6) {
                    e2 = e6;
                    e2.printStackTrace();
                }
            }
            newFixedThreadPool.shutdown();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void forwardToRabbit(Map<String, List<Trip>> map, ConfigSettings configSettings, List<RouteAccuracy> list, String str, Agency agency) {
        addRoutePredicction(configSettings, list, str, agency);
        for (Map.Entry<String, List<Trip>> entry : map.entrySet()) {
            for (Trip trip : entry.getValue()) {
                addTrip(DataMapCreator.mapTripData(trip), trip.get_tripId(), TaskType.TRIP);
                if (trip.getTripType().equals(TripType.complete)) {
                    addEta(trip);
                    addStopArrival(trip);
                }
            }
        }
    }

    private static ArrayList<String> getVehiclesList(Agency agency) {
        Firebase vehiclesRef = FirebaseRef.getInstance().getVehiclesRef(agency.getCity());
        ArrayList<String> arrayList = new ArrayList<>();
        for (DataSnapshot dataSnapshot : FirebaseUtils.getSynchronizedDataSnapshot(vehiclesRef.child(agency.getCity().toLowerCase()).child("bus").child(agency.getAgency().toLowerCase()).child("locations")).getChildren()) {
            if (!dataSnapshot.getKey().equalsIgnoreCase("unknown")) {
                arrayList.add(dataSnapshot.getKey());
            }
        }
        return arrayList;
    }

    public static void main(String[] strArr) {
        try {
            new Executor().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
