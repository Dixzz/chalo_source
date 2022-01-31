package zophop.models.mTicketing;

public class SingleTicket {
    public String _agency;
    public long _bookingTime;
    public String _endStop;
    public long _expiryTime;
    public int _fare;
    public PassengerType _passengerType;
    public String _routeId;
    public String _routeName;
    public String _startStop;
    public String _ticketId;
    public String _userId;

    public SingleTicket(String str, String str2, long j, long j2, String str3, String str4, String str5, String str6, String str7, PassengerType passengerType, int i) {
        this._ticketId = str;
        this._userId = str2;
        this._bookingTime = j;
        this._expiryTime = j2;
        this._routeName = str3;
        this._routeId = str4;
        this._agency = str5;
        this._startStop = str6;
        this._endStop = str7;
        this._passengerType = passengerType;
        this._fare = i;
    }

    public String getAgency() {
        return this._agency;
    }

    public long getBookingTime() {
        return this._bookingTime;
    }

    public String getEndStop() {
        return this._endStop;
    }

    public long getExpiryTime() {
        return this._expiryTime;
    }

    public int getFare() {
        return this._fare;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public String getStartStop() {
        return this._startStop;
    }

    public String getTicketId() {
        return this._ticketId;
    }

    public String getUserId() {
        return this._userId;
    }
}
