package app.zophop.pubsub.eventbus.events;

public class CabDestinationUpdatedEvent {
    private final CabDestinationStatus _cabDestinationStatus;
    private final mf1 _destination;
    private final ad1 _responseType;

    public enum CabDestinationStatus {
        GEOCODE_FAILURE,
        GEOCODE_OUT_OF_BOUNDS,
        CAB_RESULT
    }

    public CabDestinationUpdatedEvent(ad1 ad1, mf1 mf1, CabDestinationStatus cabDestinationStatus) {
        this._responseType = ad1;
        this._destination = mf1;
        this._cabDestinationStatus = cabDestinationStatus;
    }

    public CabDestinationStatus getCabDestinationStatus() {
        return this._cabDestinationStatus;
    }

    public mf1 getDestination() {
        return this._destination;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
