package app.zophop.models.mTicketing;

public class SingleTicket {
    private final double _fare;
    private final PassengerType _passengerType;
    private final String _ticketId;

    public SingleTicket(String str, PassengerType passengerType, double d) {
        this._ticketId = str;
        this._passengerType = passengerType;
        this._fare = d;
    }

    public double getFare() {
        return this._fare;
    }

    public PassengerType getPassengerType() {
        return this._passengerType;
    }

    public String getTicketId() {
        return this._ticketId;
    }
}
