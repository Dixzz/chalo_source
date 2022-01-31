package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.BookingPassRouteInfo;
import java.util.List;
import java.util.Map;

public class RoutesAndFaresForPassEvent {
    private final String _errorMessage;
    private final String _requestId;
    private final ad1 _responseType;
    private final Map<Double, List<BookingPassRouteInfo>> _setOfRoutesWithFaresMap;

    public RoutesAndFaresForPassEvent(String str, ad1 ad1, String str2, Map<Double, List<BookingPassRouteInfo>> map) {
        this._requestId = str;
        this._responseType = ad1;
        this._errorMessage = str2;
        this._setOfRoutesWithFaresMap = map;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public Map<Double, List<BookingPassRouteInfo>> getSetOfRoutesWithFaresMap() {
        return this._setOfRoutesWithFaresMap;
    }
}
