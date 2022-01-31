package server.zophop.gpsIntegration;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.models.Stream;
import server.zophop.utils.DistanceUtils;

public class FeedExtrapolator {
    private FeedValidator _validator = new FeedValidator();
    public String city = null;

    private long extrapolateEta(double d, Point point, int i, List<Stop> list) {
        int i2 = i;
        int size = list.size();
        double straightDistance = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), list.get(i2).getLat(), list.get(i2).getLon());
        while (i2 < size - 1) {
            i2++;
            straightDistance += DistanceUtils.straightDistance(list.get(i2).getLat(), list.get(i2).getLon(), list.get(i2).getLat(), list.get(i2).getLon());
        }
        return (long) (straightDistance / d);
    }

    private Map extrapolateMeta(String str, String str2, String str3, Point point, Route route, DataContainer dataContainer) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str4 : route.getStopSequence()) {
            arrayList.add(dataContainer.getStop(str, str2, str4));
        }
        double extrapolateSpeed = extrapolateSpeed(str3, point);
        int closestStopIdx = getClosestStopIdx(point, arrayList);
        long extrapolateEta = extrapolateEta(extrapolateSpeed, point, closestStopIdx, arrayList);
        hashMap.put("nextStopId", route.getStopSequence().get(closestStopIdx));
        int i = closestStopIdx - 1;
        hashMap.put("previousStopId", route.getStopSequence().get(i));
        hashMap.put(LoggingConstants.SPEED, Double.valueOf(extrapolateSpeed));
        hashMap.put("destinationEta", Long.valueOf(extrapolateEta));
        SimpleLogger.info("nextStopId: " + route.getStopSequence().get(closestStopIdx) + " | previousStopId: " + route.getStopSequence().get(i) + " | speed: " + extrapolateSpeed + " | destinationEta" + extrapolateEta);
        return hashMap;
    }

    private double extrapolateSpeed(String str, Point point) {
        return 8.5d;
    }

    private List<Stop> getStopSequence(String str, Route route, DataContainer dataContainer) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : route.getStopSequence()) {
            arrayList.add(dataContainer.getStop(str, route.getStationType(), str2));
        }
        return arrayList;
    }

    private int max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    public int getClosestStopIdx(Point point, List<Stop> list) {
        int size = list.size();
        int i = -1;
        double d = Double.MAX_VALUE;
        double d2 = Double.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            Stop stop = list.get(i3);
            double straightDistance = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon());
            if (straightDistance < d2 && straightDistance < d) {
                i = i3;
                d2 = straightDistance;
            } else if (straightDistance > d2 && straightDistance < d) {
                i2 = i3;
                d = straightDistance;
            }
        }
        return max(i, i2);
    }

    public Map getMetaMap(String str, String str2, Point point, DataContainer dataContainer) {
        if (SessionData.getStream(str2, this.city) == null) {
            return null;
        }
        throw null;
    }

    public Map getStreamMetaMap(String str, String str2, Map map, Point point, DataContainer dataContainer) {
        Stream stream = SessionData.getStream(str2, this.city);
        if (stream == null) {
            return null;
        }
        String str3 = (String) map.get("city");
        String str4 = (String) map.get("mode");
        return extrapolateMeta(str3, str4, str2, point, dataContainer.getRoute(str3, str4, stream.getRouteId()), dataContainer);
    }

    public String[] predictRouteIdAndLastCoveredStopId(String str, List<Point> list, List<Route> list2, DataContainer dataContainer) {
        String[] strArr = new String[2];
        String str2 = "";
        int i = RtlSpacingHelper.UNDEFINED;
        int i2 = -1;
        int i3 = 0;
        for (Route route : list2) {
            List<Stop> stopSequence = getStopSequence(str, route, dataContainer);
            ArrayList arrayList = new ArrayList();
            for (Point point : list) {
                arrayList.add(Integer.valueOf(getClosestStopIdx(point, stopSequence)));
            }
            StringBuilder i0 = hj1.i0("routeId: ");
            i0.append(route.getId());
            i0.append(" | ");
            i0.append(arrayList);
            SimpleLogger.debug(i0.toString());
            List<Integer> checkPolyline = this._validator.checkPolyline(arrayList);
            if (checkPolyline != null && checkPolyline.size() > 2 && checkPolyline.size() > i) {
                int size = checkPolyline.size();
                i2 = i3;
                i = size;
                str2 = stopSequence.get(checkPolyline.get(1).intValue()).getId();
            }
            i3++;
        }
        if (i2 == -1) {
            return null;
        }
        strArr[0] = list2.get(i2).getId();
        strArr[1] = str2;
        return strArr;
    }
}
