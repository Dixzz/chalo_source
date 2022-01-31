package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.RouteStopsInfo;
import java.util.Map;

public class FaresFetchedEvent {
    private final String _errorMessage;
    private final Map<String, MTicketPassengerInfo> _fareMap;
    private final String _requestId;
    private final ad1 _responseType;
    private final RouteStopsInfo _stageRouteStopsInfo;

    public FaresFetchedEvent(String str, ad1 ad1, String str2, Map<String, MTicketPassengerInfo> map, RouteStopsInfo routeStopsInfo) {
        this._requestId = str;
        this._responseType = ad1;
        this._errorMessage = str2;
        this._fareMap = map;
        this._stageRouteStopsInfo = routeStopsInfo;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public Map<String, MTicketPassengerInfo> getFareMap() {
        return this._fareMap;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public RouteStopsInfo getStageRouteStopsInfo() {
        return this._stageRouteStopsInfo;
    }
}
