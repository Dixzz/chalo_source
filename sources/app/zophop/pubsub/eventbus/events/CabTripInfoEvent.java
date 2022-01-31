package app.zophop.pubsub.eventbus.events;

import app.zophop.models.AutoCabResponse;

public class CabTripInfoEvent {
    public final String _requestId;
    public final AutoCabResponse _response;
    public final ad1 _responseType;

    public CabTripInfoEvent(AutoCabResponse autoCabResponse, ad1 ad1, String str) {
        this._response = autoCabResponse;
        this._responseType = ad1;
        this._requestId = str;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public AutoCabResponse getResponse() {
        return this._response;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
