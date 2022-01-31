package app.zophop.pubsub.eventbus.events;

import app.zophop.models.TripRequest;
import zophop.models.TripPlannerResponse;

public class TripPlannerEvent {
    private final String _rawResponse;
    private final TripRequest _request;
    private final String _requestId;
    private final TripPlannerResponse _response;
    private final ResponseType _responseType;

    public enum ResponseType {
        SUCCESS,
        FAILED,
        OUTSIDE_CITY
    }

    public TripPlannerEvent(TripRequest tripRequest, String str, TripPlannerResponse tripPlannerResponse, ResponseType responseType, String str2) {
        this._request = tripRequest;
        this._response = tripPlannerResponse;
        this._responseType = responseType;
        this._rawResponse = str;
        this._requestId = str2;
    }

    public String getRawResponse() {
        return this._rawResponse;
    }

    public TripRequest getRequest() {
        return this._request;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public TripPlannerResponse getResponse() {
        return this._response;
    }

    public ResponseType getResponseType() {
        return this._responseType;
    }
}
