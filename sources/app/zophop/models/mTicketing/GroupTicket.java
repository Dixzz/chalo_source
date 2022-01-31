package app.zophop.models.mTicketing;

import java.util.List;

public class GroupTicket {
    private final String _agency;
    private long _bookingTime;
    private final String _emailId;
    private final String _endStopId;
    private final String _endStopName;
    private long _expiryTime;
    private final double _fare;
    private String _groupId;
    private long _punchingTime;
    private final BookingPassRouteInfo _routeInfo;
    private final List<SingleTicket> _singleTickets;
    private final String _startStopId;
    private final String _startStopName;
    private TicketStatus _ticketStatus = TicketStatus.UNUSED;
    private String _transactionId;

    public GroupTicket(String str, BookingPassRouteInfo bookingPassRouteInfo, String str2, String str3, String str4, String str5, String str6, List<SingleTicket> list, double d) {
        this._emailId = str;
        this._routeInfo = bookingPassRouteInfo;
        this._agency = str2;
        this._startStopName = str3;
        this._startStopId = str4;
        this._endStopName = str5;
        this._endStopId = str6;
        this._singleTickets = list;
        this._fare = d;
    }

    public String getAgency() {
        return this._agency;
    }

    public long getBookingTime() {
        return this._bookingTime;
    }

    public String getEmailId() {
        return this._emailId;
    }

    public String getEndStopId() {
        return this._endStopId;
    }

    public String getEndStopName() {
        return this._endStopName;
    }

    public long getExpiryTime() {
        return this._expiryTime;
    }

    public double getFare() {
        return this._fare;
    }

    public String getGroupId() {
        return this._groupId;
    }

    public long getPunchingTime() {
        return this._punchingTime;
    }

    public String getRouteId() {
        return this._routeInfo.getRouteId();
    }

    public BookingPassRouteInfo getRouteInfo() {
        return this._routeInfo;
    }

    public String getRouteName() {
        return this._routeInfo.getRouteName();
    }

    public List<SingleTicket> getSingleTickets() {
        return this._singleTickets;
    }

    public String getStartStopId() {
        return this._startStopId;
    }

    public String getStartStopName() {
        return this._startStopName;
    }

    public TicketStatus getTicketStatus() {
        return this._ticketStatus;
    }

    public String getTransactionId() {
        return this._transactionId;
    }

    public void setBookingTime(long j) {
        this._bookingTime = j;
    }

    public void setExpiryTime(long j) {
        this._expiryTime = j;
    }

    public void setGroupId(String str) {
        this._groupId = str;
    }

    public void setPunchingTime(long j) {
        this._punchingTime = j;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this._ticketStatus = ticketStatus;
    }

    public void setTransactionId(String str) {
        this._transactionId = str;
    }
}
