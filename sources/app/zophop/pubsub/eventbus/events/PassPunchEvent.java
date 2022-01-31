package app.zophop.pubsub.eventbus.events;

import app.zophop.pubsub.eventbus.events.PunchEvent;

public class PassPunchEvent<T> extends PunchEvent {
    private final T _bookingPass;

    public PassPunchEvent(ad1 ad1, PunchEvent.PUNCH_FAILURE_REASON punch_failure_reason, T t) {
        super(ad1, punch_failure_reason);
        this._bookingPass = t;
    }

    public T getPunchedPass() {
        return this._bookingPass;
    }
}
