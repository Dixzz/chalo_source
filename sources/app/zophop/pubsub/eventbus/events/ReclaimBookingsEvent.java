package app.zophop.pubsub.eventbus.events;

public class ReclaimBookingsEvent {
    private final String _source;

    public ReclaimBookingsEvent(String str) {
        this._source = str;
    }

    public String getSource() {
        return this._source;
    }
}
