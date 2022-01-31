package app.zophop.pubsub.eventbus.events;

import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;

/* compiled from: CheckedinEvent.kt */
public final class CheckedinEvent {
    public Stop destinationStop;
    public RouteWithoutTimings route;
    public Stop startStop;
    public STATE state;
    public STOP_SOURCE stopSource;

    /* compiled from: CheckedinEvent.kt */
    public enum STATE {
        START,
        STOP,
        WAITING
    }

    /* compiled from: CheckedinEvent.kt */
    public enum STOP_SOURCE {
        SERVER,
        USER,
        PROXIMITY
    }
}
