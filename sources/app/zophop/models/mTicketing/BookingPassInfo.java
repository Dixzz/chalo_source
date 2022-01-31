package app.zophop.models.mTicketing;

import java.util.List;

public class BookingPassInfo {
    private final BookingPassType _bookingPassType;
    private final List<Integer> _noOfDays;
    private final int _noOfPunches;

    public BookingPassInfo(BookingPassType bookingPassType, int i, List<Integer> list) {
        this._bookingPassType = bookingPassType;
        this._noOfPunches = i;
        this._noOfDays = list;
    }

    public BookingPassType getBookingPassType() {
        return this._bookingPassType;
    }

    public List<Integer> getNoOfDays() {
        return this._noOfDays;
    }

    public int getNoOfPunches() {
        return this._noOfPunches;
    }
}
