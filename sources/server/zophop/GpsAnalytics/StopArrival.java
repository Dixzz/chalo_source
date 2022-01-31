package server.zophop.GpsAnalytics;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.Stop;
import server.zophop.utils.DistanceUtils;

public class StopArrival {
    private static DataContainer _container;
    private static StopUtils _stopUtils;

    public StopArrival() {
        _stopUtils = StopUtils.getInstance();
        _container = DataContainer.getDataContainer();
    }

    public static void main(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (Route route : _container.getAllBusRoutes("indore")) {
            for (String str : route.getStopSequence()) {
                arrayList.contains(str);
            }
        }
    }

    private boolean pointHasNoise(Point point, Point point2, double d) {
        return (d * 3.6d) / ((double) hj1.C0(point2, point.getTime(), 1000)) > 100.0d;
    }

    public List<GroupedStopArrivals> getAllApproxStopwiseArrivals(String str, String str2, String str3, List<Point> list) {
        Exception e;
        try {
            HashMap hashMap = new HashMap();
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            for (int i = 1; i < list.size(); i++) {
                Point point = list.get(i);
                Point point2 = list.get(i - 1);
                double straightDistance = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), point2.getLatitude(), point2.getLongitude());
                try {
                    if (!pointHasNoise(point, point2, straightDistance)) {
                        double d2 = d + straightDistance;
                        Map<String, Stop> fetchStops = _stopUtils.fetchStops(str2);
                        for (String str4 : fetchStops.keySet()) {
                            Stop stop = fetchStops.get(str4);
                            mapPointsToNearestStops(hashMap, point, stop, DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon()), d2);
                            fetchStops = fetchStops;
                        }
                        d = d2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return null;
                }
            }
            new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                List list2 = (List) entry.getValue();
                ArrayList arrayList2 = new ArrayList();
                if (list2.size() == 1) {
                    arrayList2.add(list2.get(0));
                    arrayList.add(new GroupedStopArrivals(((NearbyStopPoints) arrayList2.get(0)).getStop(), arrayList2, ((NearbyStopPoints) arrayList2.get(0)).getTimestamp()));
                    arrayList2 = new ArrayList();
                }
                int i2 = 0;
                while (i2 < list2.size() - 1) {
                    NearbyStopPoints nearbyStopPoints = (NearbyStopPoints) list2.get(i2);
                    int i3 = i2 + 1;
                    arrayList2.add(nearbyStopPoints);
                    if (((NearbyStopPoints) list2.get(i3)).getTimestamp() - nearbyStopPoints.getTimestamp() > DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL || i2 == list2.size() - 2) {
                        arrayList.add(new GroupedStopArrivals(((NearbyStopPoints) arrayList2.get(0)).getStop(), arrayList2, ((NearbyStopPoints) arrayList2.get(0)).getTimestamp()));
                        arrayList2 = new ArrayList();
                    }
                    i2 = i3;
                }
            }
            Collections.sort(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupedStopArrivals groupedStopArrivals = (GroupedStopArrivals) it.next();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }

    public List<RouteAccuracy> getPredictedRoutes(String str, Map<String, GroupedStopArrivals> map, List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<Route> allBusRoutes = _container.getAllBusRoutes(str);
        if (!str.equalsIgnoreCase("kochi")) {
            for (Route route : allBusRoutes) {
                int i = 0;
                for (String str2 : route.getStopSequence()) {
                    if (map.containsKey(str2)) {
                        i++;
                    }
                }
                int size = (i * 100) / route.getStopSequence().size();
                if (size > 80) {
                    PrintStream printStream = System.out;
                    printStream.println(route.getName() + "  " + route.getId() + "  " + size);
                    arrayList.add(new RouteAccuracy(route, size));
                }
                Collections.sort(arrayList);
            }
        }
        if (arrayList.size() == 0) {
            for (String str3 : list) {
                for (Route route2 : allBusRoutes) {
                    if (route2.getId().equalsIgnoreCase(str3)) {
                        arrayList.add(new RouteAccuracy(route2, 100));
                    }
                }
            }
        }
        return arrayList;
    }

    public void mapPointsToNearestStops(Map<String, List<NearbyStopPoints>> map, Point point, Stop stop, double d, double d2) {
        if (d >= 100.0d) {
            return;
        }
        if (map.containsKey(stop.getId())) {
            List<NearbyStopPoints> list = map.get(stop.getId());
            list.add(new NearbyStopPoints(stop, point, point.getTime(), d, d2));
            map.put(stop.getId(), list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NearbyStopPoints(stop, point, point.getTime(), d, d2));
        map.put(stop.getId(), arrayList);
    }

    public void printAccurracy(Map<String, List<RouteAccuracy>> map) {
        Iterator<Map.Entry<String, List<RouteAccuracy>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            while (it.hasNext()) {
                Map.Entry<String, List<RouteAccuracy>> next = it.next();
                System.out.println((Object) next.getKey());
                for (RouteAccuracy routeAccuracy : next.getValue()) {
                    System.out.println(routeAccuracy.toString());
                }
            }
        }
    }
}
