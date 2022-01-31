package server.zophop.Scripts;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.LiveData;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.Stream;
import server.zophop.utils.DistanceUtils;
import server.zophop.utils.SortUtils;

public class SessionAnalyser {
    private static final long TIME_FILTER = 10800000;
    public static DataContainer _container = DataContainer.getDataContainer();
    public static SessionData sessionData = new SessionData();

    private static Map<String, Object> generateSessionStat(List<Point> list, Route route, Stream stream) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Map overSpeedingBuckets = getOverSpeedingBuckets(list, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, route, stream);
        Hashtable hashtable = new Hashtable();
        if (list.size() > 1) {
            long time = list.get(0).getTime();
            d2 = 0.0d;
            long j = time;
            for (int i = 0; i < list.size(); i++) {
                Point point = list.get(i);
                if (d2 < point.getSpeed()) {
                    d2 = point.getSpeed();
                }
                if (time < point.getTime() && point.getTime() - time < TIME_FILTER) {
                    time = point.getTime();
                }
                if (j > point.getTime() && j - point.getTime() < TIME_FILTER) {
                    j = point.getTime();
                }
            }
            d = ((double) (time - j)) / 3600000.0d;
            d5 = ((double) (((Point) hj1.u(list, 1)).getTime() - list.get(0).getTime())) / 3600000.0d;
            double filteredDistanceCoveredByPoints = DistanceUtils.getFilteredDistanceCoveredByPoints(list) / 1000.0d;
            double filteredDistanceCoveredByPoints2 = DistanceUtils.getFilteredDistanceCoveredByPoints(SortUtils.sortPoints(list)) / 1000.0d;
            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d6 = filteredDistanceCoveredByPoints / d;
            }
            hashtable.put(LoggingConstants.SESSION_START_TIME, Long.valueOf(j));
            hashtable.put(LoggingConstants.SESSION_END_TIME, Long.valueOf(time));
            d3 = filteredDistanceCoveredByPoints;
            d4 = filteredDistanceCoveredByPoints2;
        } else {
            d5 = 0.0d;
            d4 = 0.0d;
            d3 = 0.0d;
            d2 = 0.0d;
            d = 0.0d;
        }
        hashtable.put(LoggingConstants.SPEED, Double.valueOf(d6));
        hashtable.put(LoggingConstants.MAX_SPEED, Double.valueOf(d2));
        hashtable.put("time", Double.valueOf(d));
        hashtable.put(LoggingConstants.ORDERED_TIME, Double.valueOf(d5));
        hashtable.putAll(overSpeedingBuckets);
        hashtable.put(LoggingConstants.ORDERED_DISTANCE, Double.valueOf(d4));
        hashtable.put(LoggingConstants.SEQUENCE_DISTANCE, Double.valueOf(d3));
        hashtable.put(LoggingConstants.DISTANCE, Double.valueOf(Math.min(d4, d3)));
        return hashtable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        if (r8 < r0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009d, code lost:
        if (r2 == (r26.size() - 2)) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map getOverSpeedingBuckets(java.util.List<server.zophop.models.Point> r26, double r27, server.zophop.models.Route r29, server.zophop.models.Stream r30) {
        /*
        // Method dump skipped, instructions count: 348
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.Scripts.SessionAnalyser.getOverSpeedingBuckets(java.util.List, double, server.zophop.models.Route, server.zophop.models.Stream):java.util.Map");
    }

    public static Map getSessionData(Map map) {
        String str = (String) map.get("streamId");
        Stream stream = SessionData.getStream(str, (String) map.get("city"));
        Route route = _container.getRoute(stream.getCity(), stream.getStationType(), stream.getRouteId());
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
        str2.equalsIgnoreCase("autoRouteDeviation");
        map.put("source", stream.getSource());
        if (!userId.matches(".*[a-zA-Z].*") && userId.length() == 10) {
            map.put("source", LoggingConstants.CONDUCTOR);
        }
        map.put(Constants.CHECKOUT_TYPE, str2);
        return map;
    }

    public static void main(String[] strArr) {
        HashMap n0 = hj1.n0("streamId", "-LlVEV50m02tBL3IstTc", "city", "indore");
        n0.put(Constants.CHECKOUT_TYPE, "overspeed");
        System.out.println(n0);
        getSessionData(n0);
    }
}
