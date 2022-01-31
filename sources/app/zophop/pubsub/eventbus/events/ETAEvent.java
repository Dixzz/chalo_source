package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Stop;

public class ETAEvent {
    public Stop destination;
    public int eta;
    public Stop nextStop;
    public Stop origin;
}
