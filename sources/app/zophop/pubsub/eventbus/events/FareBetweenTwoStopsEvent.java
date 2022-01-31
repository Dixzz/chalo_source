package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.PassengerType;
import java.util.Map;

public class FareBetweenTwoStopsEvent {
    private final String _errorMessage;
    private final Map<PassengerType, Double> _fareMap;
    private final String _requestId;
    private final ad1 _responseType;

    public FareBetweenTwoStopsEvent(String str, ad1 ad1, String str2, Map<PassengerType, Double> map) {
        this._requestId = str;
        this._responseType = ad1;
        this._errorMessage = str2;
        this._fareMap = map;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public Map<PassengerType, Double> getFareMap() {
        return this._fareMap;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
