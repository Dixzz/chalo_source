package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Route;
import java.util.List;

public class LiveRouteDetailsListEvent {
    private String _requestId;
    private ad1 _responseType;
    private List<Route> _routeList;

    public LiveRouteDetailsListEvent(String str, ad1 ad1, List<Route> list) {
        this._requestId = str;
        this._responseType = ad1;
        this._routeList = list;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public List<Route> getRouteList() {
        return this._routeList;
    }

    public void setRequestId(String str) {
        this._requestId = str;
    }

    public void setResponseType(ad1 ad1) {
        this._responseType = ad1;
    }

    public void setRouteList(List<Route> list) {
        this._routeList = list;
    }
}
