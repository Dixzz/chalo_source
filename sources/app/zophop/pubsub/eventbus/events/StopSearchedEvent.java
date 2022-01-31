package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Stop;

public class StopSearchedEvent {
    private final String _routeId;
    private final Stop _stop;

    public StopSearchedEvent(Stop stop, String str) {
        this._stop = stop;
        this._routeId = str;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public Stop getStop() {
        return this._stop;
    }
}
