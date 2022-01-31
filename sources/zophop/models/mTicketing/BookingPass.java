package zophop.models.mTicketing;

import java.util.List;

public class BookingPass {
    public String _agency;
    public String _bookingPassId;
    public BookingPassType _bookingPassType;
    public long _bookingTime;
    public String _endStop;
    public long _expiryTime;
    public int _fare;
    public int _noOfDays;
    public List<Long> _punchingTimes;
    public List<String> _routeIds;
    public List<String> _routeNames;
    public String _startStop;
    public String _userId;

    public BookingPass(String str, String str2, long j, long j2, BookingPassType bookingPassType, List<String> list, List<String> list2, String str3, String str4, String str5, int i, int i2) {
        this._bookingPassId = str;
        this._userId = str2;
        this._bookingTime = j;
        this._expiryTime = j2;
        this._bookingPassType = bookingPassType;
        this._routeNames = list;
        this._routeIds = list2;
        this._agency = str3;
        this._startStop = str4;
        this._endStop = str5;
        this._noOfDays = i;
        this._fare = i2;
    }

    public String getAgency() {
        return this._agency;
    }

    public BookingPassType getBookingPassType() {
        return this._bookingPassType;
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

    public int getNoOfDays() {
        return this._noOfDays;
    }

    public List<Long> getPunchingTimes() {
        return this._punchingTimes;
    }

    public List<String> getRouteIds() {
        return this._routeIds;
    }

    public List<String> getRouteNames() {
        return this._routeNames;
    }

    public String getStartStop() {
        return this._startStop;
    }

    public String getTicketId() {
        return this._bookingPassId;
    }

    public String getUserId() {
        return this._userId;
    }

    public void setPunchingTimes(List<Long> list) {
        this._punchingTimes = list;
    }
}
