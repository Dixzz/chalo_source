package server.zophop.utils;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import com.firebase.client.ServerValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.Indexable;
import com.google.maps.model.LatLng;
import com.rabbitmq.client.ConnectionFactory;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.GpsAnalytics.Agency;
import server.zophop.GpsAnalytics.ConfigSettings;
import server.zophop.GpsAnalytics.RouteAccuracy;
import server.zophop.GpsAnalytics.StopArrivals;
import server.zophop.GpsAnalytics.Trip;
import server.zophop.GpsAnalytics.TripType;
import server.zophop.TaskType;
import server.zophop.gpsIntegration.FeedExtrapolator;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.CheckOutType;
import server.zophop.models.ETA;
import server.zophop.models.HaltState;
import server.zophop.models.Pair;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.models.Stream;
import server.zophop.models.StreamMeta;
import server.zophop.models.StreamStatus;
import server.zophop.queue.TaskKeys;

public class DataMapCreator {
    public static Map<String, Object> createEtaObject(Stream stream, Route route, List<Pair<String, ETA>> list) {
        HashMap hashMap = new HashMap();
        for (Pair<String, ETA> pair : list) {
            StringBuilder i0 = hj1.i0("/eta/");
            i0.append(stream.getCity().toUpperCase());
            i0.append(ConnectionFactory.DEFAULT_VHOST);
            i0.append((String) pair.first);
            i0.append(ConnectionFactory.DEFAULT_VHOST);
            i0.append(route.getId());
            i0.append(ConnectionFactory.DEFAULT_VHOST);
            i0.append(stream.getStreamId());
            hashMap.put(i0.toString(), pair.second.toMap());
        }
        return hashMap;
    }

    public static Map<String, Object> createRouteObject(Stream stream, Point point, String str, int i, String str2, boolean z, boolean z2) {
        StringBuilder i0 = hj1.i0("/routes/");
        i0.append(stream.getCity().toUpperCase());
        i0.append(ConnectionFactory.DEFAULT_VHOST);
        i0.append(str2);
        i0.append(ConnectionFactory.DEFAULT_VHOST);
        i0.append(stream.getStreamId());
        i0.append(ConnectionFactory.DEFAULT_VHOST);
        String sb = i0.toString();
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_latitude", point.getLatitude());
        jSONObject.put("_longitude", point.getLongitude());
        jSONObject.put("_time", point.getTime());
        jSONObject.put("_speed", point.getSpeed());
        jSONObject.put("_isHalted", z2);
        jSONObject.put("_accuracy", point.getAccuracy());
        jSONObject.put("_stopId", str);
        if (z) {
            jSONObject.put("_eta", i);
        } else {
            jSONObject.put("_eta", stream.getNextStopEta());
        }
        jSONObject.put("_vehicleNumber", stream.getUserId());
        hashMap.put(sb, jSONObject.toString());
        return hashMap;
    }

    public static Map etaMap(StopArrivals stopArrivals, StopArrivals stopArrivals2) {
        HashMap hashMap = new HashMap();
        hashMap.put("agency", stopArrivals.get_agency());
        hashMap.put("city", stopArrivals.get_city());
        hashMap.put("mode", stopArrivals.get_mode());
        hashMap.put("stopId1", stopArrivals.get_stop().getId());
        hashMap.put("stopName1", stopArrivals.get_stop().getName());
        hashMap.put("stopId2", stopArrivals2.get_stop().getId());
        hashMap.put("stopName2", stopArrivals2.get_stop().getName());
        hashMap.put("routeName", stopArrivals.get_route().getName());
        hashMap.put(LoggingConstants.ROUTE_ID, stopArrivals.get_route().getId());
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stopArrivals.get_vehicleNo());
        hashMap.put("stop1ArrivalTime", Long.valueOf(stopArrivals.get_arrivalTime()));
        hashMap.put("stop1ArrivalTime", Long.valueOf(stopArrivals.get_departureTime()));
        hashMap.put("stop2ArrivalTime", Long.valueOf(stopArrivals2.get_arrivalTime()));
        hashMap.put("stop2ArrivalTime", Long.valueOf(stopArrivals2.get_departureTime()));
        hashMap.put("tripId", stopArrivals2.get_tripId());
        hashMap.put("createdAt", Long.valueOf(stopArrivals.get_createdAt()));
        hashMap.put("eta", Long.valueOf(stopArrivals2.get_arrivalTime() - stopArrivals.get_departureTime()));
        hashMap.put("stop1WaitTime", Long.valueOf(stopArrivals.get_departureTime() - stopArrivals.get_arrivalTime()));
        hashMap.put("stop2WaitTime", Long.valueOf(stopArrivals2.get_departureTime() - stopArrivals2.get_arrivalTime()));
        return hashMap;
    }

    public static Map getCheckInMap(Stream stream, long j, double d, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(LoggingConstants.DISTANCE, Double.valueOf(d));
        hashMap.put(LoggingConstants.ROUTE_ID, stream.getRouteId());
        hashMap.put("routeName", stream.getRouteName());
        hashMap.put("time", Long.valueOf(j));
        if (j2 != -1) {
            hashMap.put("timestamp", Long.valueOf(j2));
        }
        if (stream.get_meta() != null) {
            hashMap.put("meta", stream.get_meta());
        }
        hashMap.put(str, Long.valueOf(stream.getLastUpdated()));
        return hashMap;
    }

    public static Map getEtaPredictionMap(Point point, Stream stream, Route route, Stop stop, ETA eta, int i, Stop stop2, ETA eta2, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("city", stream.getCity());
        hashMap.put("agency", stream.getAgency());
        hashMap.put("mode", stream.getStationType());
        hashMap.put(LoggingConstants.DISTANCE, Long.valueOf((long) DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop2.getLat(), stop2.getLon())));
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stream.getUserId());
        hashMap.put(LoggingConstants.ROUTE_ID, route.getId());
        hashMap.put("routeName", route.getName());
        hashMap.put("stopA", stop.getName());
        hashMap.put("stopAId", stop.getId());
        hashMap.put("stopAIndex", Integer.valueOf(i));
        hashMap.put("stopB", stop2.getName());
        hashMap.put("stopBId", stop2.getId());
        hashMap.put("stopBIndex", Integer.valueOf(i2));
        hashMap.put("id", stop.getId() + "-" + stop2.getId());
        hashMap.put("eta", Integer.valueOf(eta2._eta.intValue() - eta._eta.intValue()));
        hashMap.put("stopAtime", Long.valueOf(eta._timeStamp.longValue() + ((long) (eta._eta.intValue() * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL))));
        hashMap.put("stopBtime", Long.valueOf(eta._timeStamp.longValue() + ((long) (eta2._eta.intValue() * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL))));
        hashMap.put("createdAt", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("lastUpdatedAt", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("streamId", stream.getStreamId());
        return hashMap;
    }

    public static Map getEtaPredictionMapOld(Stream stream, Stop stop, Route route, ETA eta, int i, Point point, int i2, Stop stop2) {
        HashMap hashMap = new HashMap();
        hashMap.put("city", stream.getCity());
        hashMap.put("agency", stream.getAgency());
        hashMap.put("mode", stream.getStationType());
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stream.getUserId());
        hashMap.put(LoggingConstants.ROUTE_ID, route.getId());
        hashMap.put("routeName", route.getName());
        hashMap.put(Constants.LATITUDE, Double.valueOf(point.getLatitude()));
        hashMap.put(Constants.LONGITUDE, Double.valueOf(point.getLongitude()));
        hashMap.put("stopId", stop.getId());
        hashMap.put("stopName", stop.getName());
        hashMap.put("stopLatitude", Double.valueOf(stop.getLat()));
        hashMap.put("stopLongitude", Double.valueOf(stop.getLon()));
        hashMap.put("stopIndex", Integer.valueOf(i));
        hashMap.put(LoggingConstants.DISTANCE, Double.valueOf(eta._distance));
        hashMap.put("interStops", Integer.valueOf(i - i2));
        hashMap.put("predictionTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("lastVisitedStopId", stop2.getId());
        hashMap.put("streamId", stream.getStreamId());
        hashMap.put("lastVisitedStopName", stop2.getName());
        hashMap.put(LoggingConstants.SPEED, Double.valueOf(point.getSpeed()));
        hashMap.put("eta", eta._eta);
        return hashMap;
    }

    public static Map getGeoFireMap(String str, String str2, long j, Point point) {
        HashMap hashMap = new HashMap();
        hashMap.put("nextStopEta", Long.valueOf(j));
        hashMap.put("nextStopId", str);
        hashMap.put("nextStopName", str2);
        hashMap.put("time", Long.valueOf(point.getTime()));
        return hashMap;
    }

    private static Map getLatLon(double d, double d2) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.LATITUDE, Double.valueOf(d));
        hashMap.put(Constants.LONGITUDE, Double.valueOf(d2));
        return hashMap;
    }

    private static Map getNextStopMap(Stop stop) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", stop.getId());
        hashMap.put("name", stop.getName());
        hashMap.put("mode", stop.getStationType());
        hashMap.put("latlon", getLatLon(stop.getLat(), stop.getLon()));
        return hashMap;
    }

    public static Map getRouteDeviationCheckoutMap(String str, String str2, Point point, Route route, int i) {
        HashMap m0 = hj1.m0(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, str);
        m0.put(LoggingConstants.ROUTE_ID, route.getId());
        m0.put("streamId", str2);
        m0.put(FirebaseAnalytics.Param.LOCATION, new j$.util.Map(point) {
            /* class server.zophop.utils.DataMapCreator.AnonymousClass1 */
            public final /* synthetic */ Point val$point;

            {
                this.val$point = r3;
                put("lat", Double.valueOf(r3.getLatitude()));
                put("lon", Double.valueOf(r3.getLongitude()));
            }

            @Override // j$.util.Map
            public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
                return Map.CC.$default$compute(this, obj, biFunction);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
                return Map.CC.$default$computeIfAbsent(this, obj, function);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
                return Map.CC.$default$computeIfPresent(this, obj, biFunction);
            }

            @Override // j$.util.Map
            public /* synthetic */ void forEach(BiConsumer biConsumer) {
                Map.CC.$default$forEach(this, biConsumer);
            }

            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return Map.CC.$default$getOrDefault(this, obj, obj2);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
                return Map.CC.$default$merge(this, obj, obj2, biFunction);
            }

            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
                return Map.CC.$default$putIfAbsent(this, obj, obj2);
            }

            @Override // j$.util.Map
            public /* synthetic */ boolean remove(Object obj, Object obj2) {
                return Map.CC.$default$remove(this, obj, obj2);
            }

            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ Object replace(Object obj, Object obj2) {
                return Map.CC.$default$replace(this, obj, obj2);
            }

            @Override // java.util.Map, j$.util.Map, java.util.HashMap
            public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
                return Map.CC.$default$replace(this, obj, obj2, obj3);
            }

            @Override // j$.util.Map
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map.CC.$default$replaceAll(this, biFunction);
            }
        });
        m0.put("routeName", route.getName());
        m0.put("agency", route.getAgency());
        m0.put("deviatedDist", Integer.valueOf(i));
        m0.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        m0.put(LoggingConstants.SPEED, Double.valueOf(point.getSpeed()));
        return m0;
    }

    public static java.util.Map getRoutePredictionMap(ConfigSettings configSettings, String str, Agency agency, RouteAccuracy routeAccuracy) {
        HashMap m0 = hj1.m0(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, str);
        m0.put("agency", agency.getAgency());
        m0.put("city", agency.getCity());
        m0.put("routeName", routeAccuracy.getRoute().getName());
        m0.put(LoggingConstants.ROUTE_ID, routeAccuracy.getRoute().getId());
        m0.put(LoggingConstants.FIRST_STOP, routeAccuracy.getRoute().getFirstStop());
        m0.put(LoggingConstants.LAST_STOP, routeAccuracy.getRoute().getLastStop());
        m0.put("timestamp", Long.valueOf(configSettings.getStartTime()));
        m0.put("accuracy", Integer.valueOf(routeAccuracy.getAccuracy()));
        return m0;
    }

    public static java.util.Map getStopArrivalMap(Stream stream, Stop stop, Route route, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("busNumber", stream.getUserId());
        hashMap.put("streamId", stream.getStreamId());
        hashMap.put(LoggingConstants.ROUTE_ID, route.getId());
        hashMap.put("routeName", route.getName());
        hashMap.put("agency", stream.getAgency());
        hashMap.put("city", stream.getCity());
        hashMap.put("stopId", stop.getId());
        hashMap.put("stopName", stop.getName());
        hashMap.put("stopLatitude", Double.valueOf(stop.getLat()));
        hashMap.put("stopLongitude", Double.valueOf(stop.getLon()));
        hashMap.put("stopIndex", Integer.valueOf(i));
        hashMap.put("arrivalTime", Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    public static java.util.Map getStoreStreamMap(String str, String str2) {
        HashMap m0 = hj1.m0("status", str);
        if (str.equalsIgnoreCase("closed")) {
            m0.put("pointStatus", StreamStatus.CLOSED.name());
            m0.put("closingState", str2);
        }
        return m0;
    }

    public static java.util.Map getStreamDestinationChangeMap(String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("destinationStopEta", Long.valueOf(j));
        hashMap.put("destinationStopId", str);
        return hashMap;
    }

    public static java.util.Map getStreamMetaMap(Stream stream, StreamMeta streamMeta, Stop stop, int i, long j, long j2, double d, double d2, int i2, boolean z) {
        if (j > new Date().getTime()) {
            SimpleLogger.severe("Current date time is greater than given");
        }
        StringBuilder i0 = hj1.i0("/sessions/");
        i0.append(stream.getStreamId());
        i0.append(ConnectionFactory.DEFAULT_VHOST);
        String sb = i0.toString();
        HashMap hashMap = new HashMap();
        hashMap.put(hj1.S(sb, "destinationStopEta"), Integer.valueOf(i));
        hashMap.put(sb + "nextStopId", streamMeta.getStopId());
        hashMap.put(sb + LoggingConstants.SPEED, Double.valueOf(streamMeta.getSpeed()));
        hashMap.put(sb + "previousStopId", streamMeta.getPrevStopId());
        hashMap.put(sb + "lastUpdated", Long.valueOf(j));
        hashMap.put(sb + "lastStopVisitTime", Long.valueOf(j2));
        hashMap.put(sb + "cLat", Double.valueOf(d));
        hashMap.put(sb + "cLon", Double.valueOf(d2));
        if (z) {
            hashMap.put(hj1.S(sb, "nextStopEta"), Integer.valueOf(i2));
            hashMap.put(sb + "lastEtaUpdated", Long.valueOf(System.currentTimeMillis()));
        }
        PrintStream printStream = System.out;
        StringBuilder i02 = hj1.i0("stream.getHalt() : ");
        i02.append(stream.getHalt());
        printStream.println(i02.toString());
        if (stream.getHalt() != null) {
            hashMap.put(hj1.S(sb, "halt"), stream.getHalt().toMap());
        } else {
            hashMap.put(sb + "halt", null);
        }
        return hashMap;
    }

    public static List<java.util.Map> mapStopArrivalData(List<StopArrivals> list, TripType tripType) {
        ArrayList arrayList = new ArrayList();
        for (StopArrivals stopArrivals : list) {
            HashMap hashMap = new HashMap();
            hashMap.put("agency", stopArrivals.get_agency());
            hashMap.put("city", stopArrivals.get_city());
            hashMap.put("mode", stopArrivals.get_mode());
            hashMap.put("tripId", stopArrivals.get_tripId());
            hashMap.put("routeName", stopArrivals.get_route().getName());
            hashMap.put(LoggingConstants.ROUTE_ID, stopArrivals.get_route().getId());
            hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stopArrivals.get_vehicleNo());
            hashMap.put("deviceId", stopArrivals.get_deviceId());
            hashMap.put("createdAt", Long.valueOf(stopArrivals.get_createdAt()));
            hashMap.put("arrivalTime", Long.valueOf(stopArrivals.get_arrivalTime()));
            hashMap.put("departureTime", Long.valueOf(stopArrivals.get_departureTime()));
            hashMap.put("stopId", stopArrivals.get_stop().getId());
            hashMap.put("stopName", stopArrivals.get_stop().getName());
            hashMap.put("seqNum", Integer.valueOf(stopArrivals.get_stopSeqNum()));
            hashMap.put("tripType", tripType.toString());
            hashMap.put("stopWaitTime", Long.valueOf(stopArrivals.get_departureTime() - stopArrivals.get_arrivalTime()));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public static java.util.Map mapTripData(Trip trip) {
        HashMap hashMap = new HashMap();
        hashMap.put("tripId", trip.get_tripId());
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, trip.get_vehicleNo());
        hashMap.put("agency", trip.get_agency());
        hashMap.put("city", trip.get_city());
        hashMap.put(LoggingConstants.ROUTE_ID, trip.get_route().getId());
        hashMap.put("routeName", trip.get_route().getName());
        hashMap.put("tripStartTime", Long.valueOf(trip.get_tripStartTime()));
        hashMap.put("tripEndTime", Long.valueOf(trip.get_tripEndTime()));
        hashMap.put("createdAt", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("firstVisitedStop", trip.get_stopSeq().get(0).get_stop().getName());
        hashMap.put("lastVisitedStop", trip.get_stopSeq().get(trip.get_stopSeq().size() - 1).get_stop().getName());
        hashMap.put("accuracy", Integer.valueOf(trip.get_accuracy()));
        hashMap.put("status", trip.getTripType().toString());
        hashMap.put("totalStops", Integer.valueOf(trip.get_route().getStopSequence().size()));
        hashMap.put("visitedStops", Integer.valueOf(trip.get_stopSeq().size()));
        hashMap.put("tripTravelTime", Long.valueOf(trip.get_tripEndTime() - trip.get_tripEndTime()));
        return hashMap;
    }

    public java.util.Map autoRouteDeviationMap(String str, String str2, String str3, String str4, String str5, boolean z, long j, String str6, Point point, String str7, String str8, String str9) {
        HashMap n0 = hj1.n0(Constants.END_STOP_STOP_NAME, str3, "routeName", str4);
        n0.put("source", str5);
        n0.put(Constants.END_STOP_STOP_NAME, Boolean.valueOf(z));
        n0.put(Constants.VEHICLE_ID, str6);
        n0.put("timeStamp", Long.valueOf(point.getTime()));
        n0.put(Constants.LONGITUDE, Double.valueOf(point.getLongitude()));
        n0.put(Constants.LATITUDE, Double.valueOf(point.getLongitude()));
        n0.put("city", str7);
        n0.put("agency", str8);
        n0.put(Constants.PREVIOUS_STREAM_ID, str9);
        return n0;
    }

    public java.util.Map getBasicTaskMap(String str, TaskType taskType, java.util.Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put(TaskKeys.RECEIVED_AT, ServerValue.TIMESTAMP);
        hashMap.put(TaskKeys.LOCKED_AT, ServerValue.TIMESTAMP);
        hashMap.put("timeStamp", ServerValue.TIMESTAMP);
        hashMap.put("event", taskType);
        hashMap.put("userId", str);
        hashMap.put("data", map);
        return hashMap;
    }

    public java.util.Map getChangeStreamMap(String str, StreamStatus streamStatus, CheckOutType checkOutType, String str2) {
        HashMap m0 = hj1.m0("streamId", str);
        m0.put(LoggingConstants.STREAM_STATUS, streamStatus.name());
        m0.put("city", str2);
        if (streamStatus.equals(StreamStatus.CLOSED) || streamStatus.equals(StreamStatus.TERMINATED)) {
            m0.put(Constants.CHECKOUT_TYPE, checkOutType.toString());
        }
        return m0;
    }

    public java.util.Map getConductorProfileMap(boolean z, long j, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("active", Boolean.valueOf(z));
        if (j != -1) {
            hashMap.put("lastCheckin", Long.valueOf(j));
            hashMap.put("agency", str);
            hashMap.put("city", str2);
        }
        return hashMap;
    }

    public java.util.Map getGpsHaltMap(HaltState haltState) {
        HashMap hashMap = new HashMap();
        hashMap.put("haltStartPoint", getTaskPointMap(haltState.getHaltPoint()));
        hashMap.put("haltStatus", haltState.getHaltStatus().toString());
        return hashMap;
    }

    public java.util.Map getMetaMapForPoint(String str, java.util.Map map, Point point, DataContainer dataContainer, FeedExtrapolator feedExtrapolator) {
        HashMap hashMap = new HashMap();
        String str2 = (String) map.get("streamId");
        java.util.Map metaMap = feedExtrapolator.getMetaMap(str, str2, point, dataContainer);
        if (metaMap == null) {
            return null;
        }
        hashMap.put("point", getTaskPointMap(point));
        hashMap.put("streamId", str2);
        hashMap.put("meta", metaMap);
        return hashMap;
    }

    public java.util.Map getPointMap(Point point) {
        HashMap hashMap = new HashMap();
        hashMap.put("accuracy", Double.valueOf(point.getAccuracy()));
        hashMap.put("lat", Double.valueOf(point.getLatitude()));
        hashMap.put("lon", Double.valueOf(point.getLongitude()));
        hashMap.put(LoggingConstants.SPEED, Double.valueOf(point.getSpeed()));
        hashMap.put("time", Long.valueOf(point.getTime()));
        return hashMap;
    }

    public java.util.Map getStreamMap(Stream stream, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("city", stream.getCity());
        hashMap.put("agency", stream.getAgency());
        hashMap.put("destinationStopId", stream.getDestinationStopId());
        hashMap.put(LoggingConstants.ROUTE_ID, stream.getRouteId());
        hashMap.put("previousStopId", stream.getLastStopId());
        hashMap.put("routeName", stream.getRouteName());
        hashMap.put("status", "OPEN");
        hashMap.put("stopId", stream.getSourceStopId());
        hashMap.put("userId", stream.getUserId());
        hashMap.put("verified", Boolean.valueOf(z));
        hashMap.put("stationType", stream.getStationType());
        hashMap.put("lastUpdated", Long.valueOf(stream.getLastUpdated()));
        hashMap.put("lastStopVisitTime", Long.valueOf(stream.getLastValidStopIdVisitTime()));
        hashMap.put("lastEtaUpdated", Long.valueOf(stream.getLastEtaUpdated()));
        hashMap.put("isQueueBased", Boolean.TRUE);
        hashMap.put("createdAt", Long.valueOf(stream.getCreatedAt()));
        hashMap.put(LoggingConstants.OPERATOR, stream.getOperator());
        if (stream.getSource() != null) {
            hashMap.put("source", stream.getSource());
        }
        return hashMap;
    }

    public java.util.Map getStreamMetaMapForPoint(String str, java.util.Map map, Point point, DataContainer dataContainer, FeedExtrapolator feedExtrapolator) {
        HashMap hashMap = new HashMap();
        String str2 = (String) map.get("streamId");
        java.util.Map streamMetaMap = feedExtrapolator.getStreamMetaMap(str, str2, map, point, dataContainer);
        if (streamMetaMap == null) {
            return null;
        }
        hashMap.put("point", getTaskPointMap(point));
        hashMap.put("streamId", str2);
        hashMap.put("meta", streamMetaMap);
        return hashMap;
    }

    public java.util.Map getTaskPointMap(Point point) {
        HashMap hashMap = new HashMap();
        hashMap.put("accuracy", Double.valueOf(point.getAccuracy()));
        hashMap.put(Constants.LATITUDE, Double.valueOf(point.getLatitude()));
        hashMap.put(Constants.LONGITUDE, Double.valueOf(point.getLongitude()));
        hashMap.put("pointSpeed", Double.valueOf(point.getSpeed()));
        hashMap.put("timeStamp", Long.valueOf(point.getTime()));
        return hashMap;
    }

    public java.util.Map getTaskPolylinePointMap(LatLng latLng) {
        HashMap hashMap = new HashMap();
        if (latLng == null) {
            hashMap.put(Constants.LATITUDE, 0);
            hashMap.put(Constants.LONGITUDE, 0);
        } else {
            hashMap.put(Constants.LATITUDE, Double.valueOf(latLng.lat));
            hashMap.put(Constants.LONGITUDE, Double.valueOf(latLng.lng));
        }
        return hashMap;
    }

    public java.util.Map getTaskStreamMap(String str, Stream stream) {
        HashMap hashMap = new HashMap();
        hashMap.put("city", stream.getCity());
        hashMap.put("agency", stream.getAgency());
        hashMap.put("destinationStopId", stream.getDestinationStopId());
        hashMap.put("isVerified", Boolean.TRUE);
        hashMap.put("mode", stream.getStationType());
        hashMap.put(LoggingConstants.ROUTE_ID, stream.getRouteId());
        hashMap.put("routeName", stream.getRouteName());
        hashMap.put("sourceStopId", stream.getSourceStopId());
        hashMap.put("streamId", stream.getStreamId());
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("userId", str);
        hashMap.put("source", stream.getSource());
        hashMap.put(LoggingConstants.OPERATOR, stream.getOperator());
        return hashMap;
    }

    public java.util.Map getVehicleMap(VehicleGPSInfo vehicleGPSInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", vehicleGPSInfo.getDeviceId());
        hashMap.put("city", vehicleGPSInfo.getCity());
        hashMap.put("mode", vehicleGPSInfo.getMode());
        hashMap.put("lastPoint", getTaskPointMap(vehicleGPSInfo.getLastPoint()));
        hashMap.put("haltState", getGpsHaltMap(vehicleGPSInfo.getHaltState()));
        hashMap.put(LoggingConstants.SPEED, Double.valueOf(vehicleGPSInfo.getLastSpeed()));
        hashMap.put("agency", vehicleGPSInfo.getAgency());
        hashMap.put("alias", vehicleGPSInfo.getAlias());
        hashMap.put("lastVisitedStopId", vehicleGPSInfo.getLastVisitedStopId());
        hashMap.put("lastVisitedStopName", vehicleGPSInfo.getLastVisitedStopName());
        hashMap.put("deviationCount", Integer.valueOf(vehicleGPSInfo.getDeviationCount()));
        hashMap.put("reversalCount", Integer.valueOf(vehicleGPSInfo.getReversalCount()));
        hashMap.put("lastVisitedPolylinePoint", getTaskPolylinePointMap(vehicleGPSInfo.getLastVisitedPolylinePoint()));
        return hashMap;
    }
}
