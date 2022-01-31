package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Stop;
import app.zophop.models.TransitMode;

public class SchedulerInputEvent {
    private final Stop _fromStop;
    private final TransitMode _mode;
    private final Stop _toStop;

    public SchedulerInputEvent(TransitMode transitMode, Stop stop, Stop stop2) {
        this._mode = transitMode;
        this._fromStop = stop;
        this._toStop = stop2;
    }

    public Stop getFromStop() {
        return this._fromStop;
    }

    public TransitMode getMode() {
        return this._mode;
    }

    public Stop getToStop() {
        return this._toStop;
    }
}
