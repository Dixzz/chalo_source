package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Stop;

public class CheckInDestinationUpdated {
    private final Stop _updatedDestinationStop;

    public CheckInDestinationUpdated(Stop stop) {
        this._updatedDestinationStop = stop;
    }

    public Stop getUpdatedDestination() {
        return this._updatedDestinationStop;
    }
}
