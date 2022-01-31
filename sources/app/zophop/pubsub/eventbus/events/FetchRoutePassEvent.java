package app.zophop.pubsub.eventbus.events;

import app.zophop.models.RouteInfo;
import java.util.List;

public class FetchRoutePassEvent {
    private final String _cityName;
    private final String _errorMessage;
    private final ad1 _responseType;
    private final List<RouteInfo> _routeInfoList;

    public FetchRoutePassEvent(ad1 ad1, String str, List<RouteInfo> list, String str2) {
        this._responseType = ad1;
        this._errorMessage = str;
        this._routeInfoList = list;
        this._cityName = str2;
    }

    public String getCityName() {
        return this._cityName;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public List<RouteInfo> getRouteInfoList() {
        return this._routeInfoList;
    }
}
