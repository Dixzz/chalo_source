package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.ProductFareMapping;
import java.util.List;
import java.util.Map;

public class FareFetchRoutePassEvent {
    private final String _errorMessage;
    private final String _requestId;
    private final ad1 _responseType;
    private final Map<String, List<ProductFareMapping>> fareMapping;

    public FareFetchRoutePassEvent(String str, ad1 ad1, String str2, Map<String, List<ProductFareMapping>> map) {
        this._requestId = str;
        this._responseType = ad1;
        this._errorMessage = str2;
        this.fareMapping = map;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public Map<String, List<ProductFareMapping>> getFareMapping() {
        return this.fareMapping;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
