package app.zophop.pubsub.eventbus.events;

import app.zophop.models.RouteInfo;

public class FreeRidesCountEvent {
    private int _count;
    private String _errorMessage;
    private final ad1 _responseType;
    private final RouteInfo _routeInfo;

    public FreeRidesCountEvent(ad1 ad1, int i, RouteInfo routeInfo) {
        this._responseType = ad1;
        this._count = i;
        this._routeInfo = routeInfo;
    }

    public int getCount() {
        return this._count;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public RouteInfo getRouteInfo() {
        return this._routeInfo;
    }

    public FreeRidesCountEvent(ad1 ad1, String str, RouteInfo routeInfo) {
        this._responseType = ad1;
        this._errorMessage = str;
        this._routeInfo = routeInfo;
    }
}
