package app.zophop.models;

import java.util.List;

public class RouteWithoutTimings {
    public final TransitMode _mode;
    public final String _routeId;
    public final String _routeName;
    public final List<Stop> _stopSequence;

    public RouteWithoutTimings(String str, String str2, TransitMode transitMode, List<Stop> list) {
        this._routeId = str;
        this._routeName = str2;
        this._stopSequence = list;
        this._mode = transitMode;
    }

    public TransitMode getMode() {
        return this._mode;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public List<Stop> getStopSequence() {
        return this._stopSequence;
    }

    public RouteWithoutTimings(String str, String str2, TransitMode transitMode, List<Stop> list, String str3) {
        this._routeId = str;
        this._routeName = str2;
        this._stopSequence = list;
        this._mode = transitMode;
    }
}
