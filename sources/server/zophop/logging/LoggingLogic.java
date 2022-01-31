package server.zophop.logging;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import server.zophop.CS;
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.LiveData;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.Stream;
import server.zophop.utils.DistanceUtils;
import server.zophop.utils.SortUtils;

public class LoggingLogic {
    private static final long TIME_FILTER = 10800000;
    private DataContainer _container;
    private ElasticHandler _elasticHandler = new ElasticHandler();
    private CS cs = new CS();

    public LoggingLogic() {
        CS.ENVIRONMENT.valueOf("production");
        this._container = DataContainer.getDataContainer();
    }

    private void forwardOverspeedAlertToElastic(Route route, Stream stream, Point point, double d) {
        JSONObject jSONObject = new JSONObject();
        JSONObject put = new JSONObject().put(Constants.LATITUDE, point.getLatitude()).put(Constants.LONGITUDE, point.getLongitude());
        jSONObject.put(LoggingConstants.SPEED, d);
        jSONObject.put("timestamp", point.getTime());
        jSONObject.put(FirebaseAnalytics.Param.LOCATION, put);
        jSONObject.put("type", "overspeed");
        jSONObject.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stream.getFilteredUserId());
        jSONObject.put("streamId", stream.getStreamId());
        jSONObject.put(LoggingConstants.ROUTE_ID, route.getId());
        jSONObject.put("routeName", route.getName());
        jSONObject.put(DigitalTripReceiptJsonKeys.KEY_END_STOP, route.getLastStop());
        jSONObject.put("agency", stream.getAgency().toLowerCase());
        jSONObject.put("city", stream.getCity());
        if (stream.getOperator() != null) {
            jSONObject.put(LoggingConstants.OPERATOR, stream.getOperator());
        } else {
            jSONObject.put(LoggingConstants.OPERATOR, "unknown");
        }
        try {
            this._elasticHandler.execute(jSONObject, "alert", "type");
        } catch (Exception unused) {
        }
    }

    private void forwardRouteDeviationAlertToElastic(List<Point> list, Route route, Stream stream) {
        JSONObject jSONObject = new JSONObject();
        Point point = (Point) hj1.t(list, -1);
        JSONObject put = new JSONObject().put(Constants.LATITUDE, point.getLatitude()).put(Constants.LONGITUDE, point.getLongitude());
        jSONObject.put("timestamp", point.getTime());
        jSONObject.put(LoggingConstants.SPEED, point.getSpeed());
        jSONObject.put(FirebaseAnalytics.Param.LOCATION, put);
        jSONObject.put("type", "routeDeviation");
        jSONObject.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stream.getFilteredUserId());
        jSONObject.put("streamId", stream.getStreamId());
        jSONObject.put(LoggingConstants.ROUTE_ID, route.getId());
        jSONObject.put("routeName", route.getName());
        jSONObject.put(DigitalTripReceiptJsonKeys.KEY_END_STOP, route.getLastStop());
        jSONObject.put("agency", stream.getAgency().toLowerCase());
        jSONObject.put("city", stream.getCity());
        if (stream.getOperator() != null) {
            jSONObject.put(LoggingConstants.OPERATOR, stream.getOperator());
        } else {
            jSONObject.put(LoggingConstants.OPERATOR, "unknown");
        }
        try {
            this._elasticHandler.execute(jSONObject, "alert", "type");
        } catch (Exception unused) {
        }
    }

    private Map<String, Object> generateSessionStat(List<Point> list, Route route, Stream stream) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        Map overSpeedingBuckets = getOverSpeedingBuckets(list, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, route, stream);
        Hashtable hashtable = new Hashtable();
        if (list.size() > 1) {
            long time = list.get(0).getTime();
            long j = time;
            d5 = 0.0d;
            for (int i = 0; i < list.size(); i++) {
                Point point = list.get(i);
                if (d5 < point.getSpeed()) {
                    d5 = point.getSpeed();
                }
                if (time < point.getTime()) {
                    if (point.getTime() - time < TIME_FILTER) {
                        time = point.getTime();
                    } else {
                        System.out.println(time + " " + point.getTime());
                        PrintStream printStream = System.out;
                        StringBuilder i0 = hj1.i0("fitlered Data --");
                        i0.append(point.getTime());
                        printStream.println(i0.toString());
                    }
                }
                if (j > point.getTime()) {
                    if (j - point.getTime() < TIME_FILTER) {
                        j = point.getTime();
                    } else {
                        System.out.println(time + " " + point.getTime());
                        PrintStream printStream2 = System.out;
                        StringBuilder i02 = hj1.i0("fitlered Data");
                        i02.append(point.getTime());
                        printStream2.println(i02.toString());
                    }
                }
            }
            d4 = ((double) (time - j)) / 3600000.0d;
            d2 = ((double) (((Point) hj1.u(list, 1)).getTime() - list.get(0).getTime())) / 3600000.0d;
            d3 = DistanceUtils.getFilteredDistanceCoveredByPoints(list) / 1000.0d;
            d6 = DistanceUtils.getFilteredDistanceCoveredByPoints(SortUtils.sortPoints(list)) / 1000.0d;
            d = d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? d3 / d4 : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            hashtable.put(LoggingConstants.SESSION_START_TIME, Long.valueOf(j));
            hashtable.put(LoggingConstants.SESSION_END_TIME, Long.valueOf(time));
        } else {
            d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            d6 = 0.0d;
            d4 = 0.0d;
            d3 = 0.0d;
            d2 = 0.0d;
        }
        hashtable.put(LoggingConstants.SPEED, Double.valueOf(d));
        hashtable.put(LoggingConstants.MAX_SPEED, Double.valueOf(d5));
        hashtable.put("time", Double.valueOf(d4));
        hashtable.put(LoggingConstants.ORDERED_TIME, Double.valueOf(d2));
        hashtable.putAll(overSpeedingBuckets);
        hashtable.put(LoggingConstants.ORDERED_DISTANCE, Double.valueOf(d6));
        hashtable.put(LoggingConstants.SEQUENCE_DISTANCE, Double.valueOf(d3));
        hashtable.put(LoggingConstants.DISTANCE, Double.valueOf(Math.min(d6, d3)));
        return hashtable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map getOverSpeedingBuckets(java.util.List<server.zophop.models.Point> r26, double r27, server.zophop.models.Route r29, server.zophop.models.Stream r30) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.logging.LoggingLogic.getOverSpeedingBuckets(java.util.List, double, server.zophop.models.Route, server.zophop.models.Stream):java.util.Map");
    }

    public Map getSessionData(Map map) {
        String str = (String) map.get("streamId");
        Stream stream = SessionData.getStream(str, (String) map.get("city"));
        Route route = this._container.getRoute(stream.getCity(), stream.getStationType(), stream.getRouteId());
        List<Point> pointsForStream = LiveData.getPointsForStream(str, stream.getCity());
        String userId = stream.getUserId();
        map.put("city", stream.getCity());
        map.put("agency", route.getAgency().toLowerCase());
        map.put("mode", route.getStationType());
        map.put("userId", stream.getUserId());
        map.put("streamId", str);
        map.put(LoggingConstants.ROUTE_ID, stream.getRouteId());
        map.put("routeName", route.getName());
        map.put(LoggingConstants.FIRST_STOP, route.getFirstStop());
        map.put(LoggingConstants.LAST_STOP, route.getLastStop());
        map.put(LoggingConstants.OPERATOR, stream.getOperator());
        map.putAll(generateSessionStat(pointsForStream, route, stream));
        String str2 = (String) map.get(Constants.CHECKOUT_TYPE);
        if (str2.equalsIgnoreCase("autoRouteDeviation")) {
            forwardRouteDeviationAlertToElastic(pointsForStream, route, stream);
        }
        map.put("source", stream.getSource());
        if (!userId.matches(".*[a-zA-Z].*") && userId.length() == 10) {
            map.put("source", LoggingConstants.CONDUCTOR);
        }
        map.put(Constants.CHECKOUT_TYPE, str2);
        return map;
    }
}
