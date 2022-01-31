package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.GroupTicket;
import app.zophop.pubsub.eventbus.events.PunchEvent;

public class TicketPunchEvent extends PunchEvent {
    private final GroupTicket _punchedJourneyTicket;

    public TicketPunchEvent(ad1 ad1, PunchEvent.PUNCH_FAILURE_REASON punch_failure_reason, GroupTicket groupTicket) {
        super(ad1, punch_failure_reason);
        this._punchedJourneyTicket = groupTicket;
    }

    public GroupTicket getPunchedJourneyTicket() {
        return this._punchedJourneyTicket;
    }
}
