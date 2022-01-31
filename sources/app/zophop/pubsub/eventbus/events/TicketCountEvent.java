package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.PassengerType;
import java.util.List;

public class TicketCountEvent {
    private final List<PassengerType> _passengerTypeList;
    private final List<Integer> _ticketCountList;

    public TicketCountEvent(List<PassengerType> list, List<Integer> list2) {
        this._passengerTypeList = list;
        this._ticketCountList = list2;
    }

    public List<PassengerType> getPassengerTypeList() {
        return this._passengerTypeList;
    }

    public List<Integer> getTicketCountList() {
        return this._ticketCountList;
    }
}
