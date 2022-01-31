package server.zophop.gpsIntegration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.zophop.models.GpsCheckinStatus;
import server.zophop.models.Route;

public class FeedContainer {
    private Map<String, GpsCheckinStatus> _deviceIdCheckinStatusMap;
    private Map<String, Integer> _deviceIdFirstStopCheckinStartCountMap;
    private Map<String, Integer> _deviceIdLastStopCheckinStopCountMap;
    private Map<String, String> _deviceIdLastStopCoveredIdMap;
    private Map<String, Long> _deviceIdLastStopCoveredTimeMap;
    private Map<String, Integer> _deviceIdMidWayCheckinStartCountMap;
    private Map<String, Integer> _deviceIdRouteDeviationCountMap;
    private Map<String, String> _deviceIdVehicleNoMap = new HashMap();
    private Map<String, Route> _routeIdRouteDetailsMap;
    private Map<String, List<String>> _routeNameUpDownRouteIdsMap;
    private Map<String, String> _vehicleNoRouteIdMap;

    public FeedContainer() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1071");
        arrayList.add("1138");
        addRouteNameUpDownRouteIdsToMap("AS 2", arrayList);
    }

    private void setDeviceIdVehicleNoMap(Map<String, String> map) {
        this._deviceIdVehicleNoMap = map;
    }

    private void setRouteIdRouteDetailsMap(Map<String, Route> map) {
        this._routeIdRouteDetailsMap = map;
    }

    private void setRouteNameUpDownRouteIdsMap(Map<String, List<String>> map) {
        this._routeNameUpDownRouteIdsMap = map;
    }

    private void setVehicleNoRouteIdMap(Map<String, String> map) {
        this._vehicleNoRouteIdMap = map;
    }

    public void addDeviceIdCheckinStatusToMap(String str, GpsCheckinStatus gpsCheckinStatus) {
        Map<String, GpsCheckinStatus> deviceIdCheckinStatusMap = getDeviceIdCheckinStatusMap();
        if (deviceIdCheckinStatusMap == null) {
            deviceIdCheckinStatusMap = new HashMap<>();
        }
        deviceIdCheckinStatusMap.put(str, gpsCheckinStatus);
        setDeviceIdCheckinStatusMap(deviceIdCheckinStatusMap);
    }

    public void addDeviceIdFirstStopCheckinStartCountToMap(String str, int i) {
        Map<String, Integer> deviceIdFirstStopCheckinStartCountMap = getDeviceIdFirstStopCheckinStartCountMap();
        if (deviceIdFirstStopCheckinStartCountMap == null) {
            deviceIdFirstStopCheckinStartCountMap = new HashMap<>();
        }
        deviceIdFirstStopCheckinStartCountMap.put(str, Integer.valueOf(i));
        setDeviceIdFirstStopCheckinStartCountMap(deviceIdFirstStopCheckinStartCountMap);
    }

    public void addDeviceIdLastStopCheckinStopCountToMap(String str, int i) {
        Map<String, Integer> deviceIdLastStopCheckinStopCountMap = getDeviceIdLastStopCheckinStopCountMap();
        if (deviceIdLastStopCheckinStopCountMap == null) {
            deviceIdLastStopCheckinStopCountMap = new HashMap<>();
        }
        deviceIdLastStopCheckinStopCountMap.put(str, Integer.valueOf(i));
        setDeviceIdLastStopCheckinStopCountMap(deviceIdLastStopCheckinStopCountMap);
    }

    public void addDeviceIdLastStopCoveredIdToMap(String str, String str2) {
        Map<String, String> deviceIdLastStopCoveredIdMap = getDeviceIdLastStopCoveredIdMap();
        if (deviceIdLastStopCoveredIdMap == null) {
            deviceIdLastStopCoveredIdMap = new HashMap<>();
        }
        deviceIdLastStopCoveredIdMap.put(str, str2);
        setDeviceIdLastStopCoveredIdMap(deviceIdLastStopCoveredIdMap);
    }

    public void addDeviceIdLastStopCoveredTimeToMap(String str, long j) {
        Map<String, Long> deviceIdLastStopCoveredTimeMap = getDeviceIdLastStopCoveredTimeMap();
        if (deviceIdLastStopCoveredTimeMap == null) {
            deviceIdLastStopCoveredTimeMap = new HashMap<>();
        }
        deviceIdLastStopCoveredTimeMap.put(str, Long.valueOf(j));
        setDeviceIdLastStopCoveredTimeMap(deviceIdLastStopCoveredTimeMap);
    }

    public void addDeviceIdMidWayCheckinStartCountToMap(String str, int i) {
        Map<String, Integer> deviceIdMidWayCheckinStartCountMap = getDeviceIdMidWayCheckinStartCountMap();
        if (deviceIdMidWayCheckinStartCountMap == null) {
            deviceIdMidWayCheckinStartCountMap = new HashMap<>();
        }
        deviceIdMidWayCheckinStartCountMap.put(str, Integer.valueOf(i));
        setDeviceIdMidWayCheckinStartCountMap(deviceIdMidWayCheckinStartCountMap);
    }

    public void addDeviceIdRouteDeviationCountToMap(String str, int i) {
        Map<String, Integer> deviceIdRouteDeviationCountMap = getDeviceIdRouteDeviationCountMap();
        if (deviceIdRouteDeviationCountMap == null) {
            deviceIdRouteDeviationCountMap = new HashMap<>();
        }
        deviceIdRouteDeviationCountMap.put(str, Integer.valueOf(i));
        setDeviceIdRouteDeviationCountMap(deviceIdRouteDeviationCountMap);
    }

    public void addDeviceIdVehicleNoToMap(String str, String str2) {
        Map<String, String> deviceIdVehicleNoMap = getDeviceIdVehicleNoMap();
        if (deviceIdVehicleNoMap == null) {
            deviceIdVehicleNoMap = new HashMap<>();
        }
        deviceIdVehicleNoMap.put(str, str2);
        setDeviceIdVehicleNoMap(deviceIdVehicleNoMap);
    }

    public void addRouteIdRouteDetailsToMap(String str, Route route) {
        Map<String, Route> routeIdRouteDetailsMap = getRouteIdRouteDetailsMap();
        if (routeIdRouteDetailsMap == null) {
            routeIdRouteDetailsMap = new HashMap<>();
        }
        routeIdRouteDetailsMap.put(str, route);
        setRouteIdRouteDetailsMap(routeIdRouteDetailsMap);
    }

    public void addRouteNameUpDownRouteIdsToMap(String str, List<String> list) {
        Map<String, List<String>> routeNameUpDownRouteIdsMap = getRouteNameUpDownRouteIdsMap();
        if (routeNameUpDownRouteIdsMap == null) {
            routeNameUpDownRouteIdsMap = new HashMap<>();
        }
        routeNameUpDownRouteIdsMap.put(str, list);
        setRouteNameUpDownRouteIdsMap(routeNameUpDownRouteIdsMap);
    }

    public void addVehicleNoRouteIdToMap(String str, String str2) {
        Map<String, String> vehicleNoRouteIdMap = getVehicleNoRouteIdMap();
        if (vehicleNoRouteIdMap == null) {
            vehicleNoRouteIdMap = new HashMap<>();
        }
        vehicleNoRouteIdMap.put(str, str2);
        setVehicleNoRouteIdMap(vehicleNoRouteIdMap);
    }

    public Map<String, GpsCheckinStatus> getDeviceIdCheckinStatusMap() {
        return this._deviceIdCheckinStatusMap;
    }

    public Map<String, Integer> getDeviceIdFirstStopCheckinStartCountMap() {
        return this._deviceIdFirstStopCheckinStartCountMap;
    }

    public Map<String, Integer> getDeviceIdLastStopCheckinStopCountMap() {
        return this._deviceIdLastStopCheckinStopCountMap;
    }

    public Map<String, String> getDeviceIdLastStopCoveredIdMap() {
        return this._deviceIdLastStopCoveredIdMap;
    }

    public Map<String, Long> getDeviceIdLastStopCoveredTimeMap() {
        return this._deviceIdLastStopCoveredTimeMap;
    }

    public Map<String, Integer> getDeviceIdMidWayCheckinStartCountMap() {
        return this._deviceIdMidWayCheckinStartCountMap;
    }

    public Map<String, Integer> getDeviceIdRouteDeviationCountMap() {
        return this._deviceIdRouteDeviationCountMap;
    }

    public Map<String, String> getDeviceIdVehicleNoMap() {
        return this._deviceIdVehicleNoMap;
    }

    public Map<String, Route> getRouteIdRouteDetailsMap() {
        return this._routeIdRouteDetailsMap;
    }

    public Map<String, List<String>> getRouteNameUpDownRouteIdsMap() {
        return this._routeNameUpDownRouteIdsMap;
    }

    public Map<String, String> getVehicleNoRouteIdMap() {
        return this._vehicleNoRouteIdMap;
    }

    public void setDeviceIdCheckinStatusMap(Map<String, GpsCheckinStatus> map) {
        this._deviceIdCheckinStatusMap = map;
    }

    public void setDeviceIdFirstStopCheckinStartCountMap(Map<String, Integer> map) {
        this._deviceIdFirstStopCheckinStartCountMap = map;
    }

    public void setDeviceIdLastStopCheckinStopCountMap(Map<String, Integer> map) {
        this._deviceIdLastStopCheckinStopCountMap = map;
    }

    public void setDeviceIdLastStopCoveredIdMap(Map<String, String> map) {
        this._deviceIdLastStopCoveredIdMap = map;
    }

    public void setDeviceIdLastStopCoveredTimeMap(Map<String, Long> map) {
        this._deviceIdLastStopCoveredTimeMap = map;
    }

    public void setDeviceIdMidWayCheckinStartCountMap(Map<String, Integer> map) {
        this._deviceIdMidWayCheckinStartCountMap = map;
    }

    public void setDeviceIdRouteDeviationCountMap(Map<String, Integer> map) {
        this._deviceIdRouteDeviationCountMap = map;
    }
}
