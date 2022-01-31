package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Route;

public class RouteDetailsEvent {
    private final ad1 _responseType;
    private final Route _route;
    private final String _routeId;

    public RouteDetailsEvent(ad1 ad1, String str, Route route) {
        this._responseType = ad1;
        this._routeId = str;
        this._route = route;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public Route getRoute() {
        return this._route;
    }

    public String getRouteId() {
        return this._routeId;
    }
}
