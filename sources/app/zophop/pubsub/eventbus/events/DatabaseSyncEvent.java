package app.zophop.pubsub.eventbus.events;

import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.firebase.database.DataSnapshot;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class DatabaseSyncEvent {
    private final String _cityName;
    private List<RouteInfo> _routeInfoForMode;
    private final STATUS _status;
    private HashMap<String, HashSet<String>> _stopRouteMap;
    private Map<TransitMode, HashMap<String, Stop>> _stopsMap;
    private Map<TransitMode, HashMap<String, JSONObject>> _trips;
    private Map<TransitMode, HashMap<String, DataSnapshot>> _tripsSnapshot;
    private boolean isFirstTime;
    private List<RouteInfo> routeInfos;
    private DataSnapshot routeSnapshot;

    public enum STATUS {
        STARTED,
        STOPS_DONE,
        DONE,
        FAILURE
    }

    public DatabaseSyncEvent(STATUS status, String str) {
        this._status = status;
        this._cityName = str;
    }

    public String getCityName() {
        return this._cityName;
    }

    public List<RouteInfo> getRouteInfoForMode() {
        return this._routeInfoForMode;
    }

    public List<RouteInfo> getRouteInfos() {
        return this.routeInfos;
    }

    public STATUS getStatus() {
        return this._status;
    }

    public HashMap<String, HashSet<String>> getStopRouteMap() {
        return this._stopRouteMap;
    }

    public Map<TransitMode, HashMap<String, Stop>> getStops() {
        return this._stopsMap;
    }

    public Map<TransitMode, HashMap<String, JSONObject>> getTrips() {
        return this._trips;
    }

    public Map<TransitMode, HashMap<String, DataSnapshot>> getTripsSnapshot() {
        return this._tripsSnapshot;
    }

    public boolean isFirstTimeSync() {
        return this.isFirstTime;
    }

    public void setIsFirstTime(boolean z) {
        this.isFirstTime = z;
    }

    public void setRouteForMode(List<RouteInfo> list) {
        this._routeInfoForMode = list;
    }

    public void setRouteInfos(List<RouteInfo> list) {
        this.routeInfos = list;
    }

    public void setStopRouteMap(HashMap<String, HashSet<String>> hashMap) {
        this._stopRouteMap = hashMap;
    }

    public void setStops(Map<TransitMode, HashMap<String, Stop>> map) {
        this._stopsMap = map;
    }

    public void setTripsObj(Map<TransitMode, HashMap<String, JSONObject>> map) {
        this._trips = map;
    }

    public void setTripsSnapshot(Map<TransitMode, HashMap<String, DataSnapshot>> map) {
        this._tripsSnapshot = map;
    }
}
