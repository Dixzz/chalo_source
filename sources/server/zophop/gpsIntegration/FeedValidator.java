package server.zophop.gpsIntegration;

import java.util.List;
import java.util.Map;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.models.GpsCheckinStatus;

public class FeedValidator {
    private RoutePredictor _routePredictor = new RoutePredictor();
    private String city = "";

    private long mod(long j) {
        return j < 0 ? -j : j;
    }

    public Boolean checkForStreamExpiry(Map map) {
        if (((Long) ((Map) map.get("meta")).get("destinationEta")).longValue() < 10) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean checkForStreamPresence(String str) {
        if (SessionData.getStream(str, this.city) == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<Integer> checkPolyline(List<Integer> list) {
        List<Integer> extractUiqueValidIdxs = this._routePredictor.extractUiqueValidIdxs(list);
        int intValue = extractUiqueValidIdxs.get(0).intValue();
        int size = extractUiqueValidIdxs.size();
        for (int i = 1; i < size; i++) {
            if (extractUiqueValidIdxs.get(i).intValue() < intValue) {
                return null;
            }
            intValue = extractUiqueValidIdxs.get(i).intValue();
        }
        return extractUiqueValidIdxs;
    }

    public Boolean ifDeviceIdRecordExists(FeedContainer feedContainer, String str) {
        Map<String, String> deviceIdVehicleNoMap = feedContainer.getDeviceIdVehicleNoMap();
        if (deviceIdVehicleNoMap == null || !deviceIdVehicleNoMap.containsKey(str)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean validatingGpsPoint(FeedContainer feedContainer, String str) {
        Boolean bool = Boolean.FALSE;
        Map<String, String> deviceIdVehicleNoMap = feedContainer.getDeviceIdVehicleNoMap();
        if (deviceIdVehicleNoMap != null && deviceIdVehicleNoMap.containsKey(str)) {
            String str2 = deviceIdVehicleNoMap.get(str);
            Map<String, String> vehicleNoRouteIdMap = feedContainer.getVehicleNoRouteIdMap();
            if (vehicleNoRouteIdMap != null && vehicleNoRouteIdMap.containsKey(str2)) {
                GpsCheckinStatus gpsCheckinStatus = feedContainer.getDeviceIdCheckinStatusMap().get(str);
                if (!gpsCheckinStatus.equals(GpsCheckinStatus.WAITING) && !gpsCheckinStatus.equals(GpsCheckinStatus.NOT_CHECKED_IN) && !gpsCheckinStatus.equals(GpsCheckinStatus.ABOUT_TO_START)) {
                    return Boolean.TRUE;
                }
            }
        }
        return bool;
    }
}
