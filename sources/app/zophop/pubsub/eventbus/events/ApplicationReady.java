package app.zophop.pubsub.eventbus.events;

public class ApplicationReady {
    private final boolean _ready;

    public ApplicationReady(boolean z) {
        this._ready = z;
    }

    public boolean isApplicationReady() {
        return this._ready;
    }
}
