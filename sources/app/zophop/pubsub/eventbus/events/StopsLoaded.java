package app.zophop.pubsub.eventbus.events;

public class StopsLoaded {
    private final boolean _success;

    public StopsLoaded(boolean z) {
        this._success = z;
    }

    public boolean isSuccess() {
        return this._success;
    }
}
