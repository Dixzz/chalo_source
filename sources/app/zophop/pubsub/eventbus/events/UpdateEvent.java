package app.zophop.pubsub.eventbus.events;

public class UpdateEvent {
    private boolean _forceUpdate;
    private String _reason;
    private boolean _recommendedUpdate;
    private ad1 _status;

    public String getReason() {
        return this._reason;
    }

    public ad1 getStatus() {
        return this._status;
    }

    public boolean isForceUpdate() {
        return this._forceUpdate;
    }

    public boolean isRecommendedUpdate() {
        return this._recommendedUpdate;
    }

    public void setForceUpdate(boolean z) {
        this._forceUpdate = z;
    }

    public void setReason(String str) {
        this._reason = str;
    }

    public void setRecommendedUpdate(boolean z) {
        this._recommendedUpdate = z;
    }

    public void setStatus(ad1 ad1) {
        this._status = ad1;
    }
}
