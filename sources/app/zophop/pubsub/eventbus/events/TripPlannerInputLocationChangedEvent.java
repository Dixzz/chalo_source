package app.zophop.pubsub.eventbus.events;

import app.zophop.models.TripRequest;

public class TripPlannerInputLocationChangedEvent {
    private final RESPONSE_TYPE _response;
    private final TripRequest _tripRequest;

    public enum RESPONSE_TYPE {
        LOCATION_UPDATE,
        TRIP_REQUEST,
        LOCATION_UPDATE_FAILED
    }

    public TripPlannerInputLocationChangedEvent(RESPONSE_TYPE response_type, TripRequest tripRequest) {
        this._response = response_type;
        this._tripRequest = tripRequest;
    }

    public RESPONSE_TYPE gerResponse() {
        return this._response;
    }

    public TripRequest getTripRequest() {
        return this._tripRequest;
    }
}
