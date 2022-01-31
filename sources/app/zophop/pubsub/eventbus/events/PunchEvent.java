package app.zophop.pubsub.eventbus.events;

public abstract class PunchEvent {
    private final PUNCH_FAILURE_REASON _punchFailureReason;
    private final ad1 _responseType;

    public enum PUNCH_FAILURE_REASON {
        INVALID_CODE,
        NETWORK_ERROR,
        JSON_ERROR
    }

    public PunchEvent(ad1 ad1, PUNCH_FAILURE_REASON punch_failure_reason) {
        this._responseType = ad1;
        this._punchFailureReason = punch_failure_reason;
    }

    public PUNCH_FAILURE_REASON getPunchFailureReason() {
        return this._punchFailureReason;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
