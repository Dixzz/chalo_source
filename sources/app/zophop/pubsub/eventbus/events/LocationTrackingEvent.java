package app.zophop.pubsub.eventbus.events;

import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;

public class LocationTrackingEvent {
    private final ACTION _action;
    private Stop _destination;
    private double _distanceCovered;
    private boolean _isVerified;
    private Stop _origin;
    private RouteWithoutTimings _route;
    private String _streamId;
    private long _totalTime;

    public enum ACTION {
        START,
        STOP
    }

    public LocationTrackingEvent(ACTION action) {
        this._action = action;
    }

    public ACTION getAction() {
        return this._action;
    }

    public Stop getDestination() {
        return this._destination;
    }

    public double getDistanceCovered() {
        return this._distanceCovered;
    }

    public Stop getOrigin() {
        return this._origin;
    }

    public RouteWithoutTimings getRouteWithoutTimings() {
        return this._route;
    }

    public String getStreamId() {
        return this._streamId;
    }

    public long getTotalTime() {
        return this._totalTime;
    }

    public boolean isVerified() {
        return this._isVerified;
    }

    public void setDistanceCovered(double d) {
        this._distanceCovered = d;
    }

    public void setStreamId(String str) {
        this._streamId = str;
    }

    public void setTotalTime(long j) {
        this._totalTime = j;
    }

    public void setVerified(boolean z) {
        this._isVerified = z;
    }

    public LocationTrackingEvent(ACTION action, RouteWithoutTimings routeWithoutTimings, Stop stop, Stop stop2) {
        this._action = action;
        this._route = routeWithoutTimings;
        this._origin = stop;
        this._destination = stop2;
        this._isVerified = false;
    }
}
