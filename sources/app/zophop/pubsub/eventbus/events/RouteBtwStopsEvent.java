package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Route;
import java.util.List;

public class RouteBtwStopsEvent {
    private ad1 _responseType;
    private List<Route> _routeList;

    public RouteBtwStopsEvent(ad1 ad1, List<Route> list) {
        this._responseType = ad1;
        this._routeList = list;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public List<Route> get_routeList() {
        return this._routeList;
    }

    public void set_responseType(ad1 ad1) {
        this._responseType = ad1;
    }

    public void set_routeList(List<Route> list) {
        this._routeList = list;
    }
}
