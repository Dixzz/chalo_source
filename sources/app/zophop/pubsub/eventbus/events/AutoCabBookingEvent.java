package app.zophop.pubsub.eventbus.events;

import app.zophop.models.autoCabBooking.BookingCode;
import app.zophop.models.autoCabBooking.BookingDetails;

public class AutoCabBookingEvent {
    public final BookingDetails _bookingDetails;
    public final BookingCode _code;

    public AutoCabBookingEvent(BookingCode bookingCode, BookingDetails bookingDetails) {
        this._code = bookingCode;
        this._bookingDetails = bookingDetails;
    }

    public BookingDetails getBookingDetails() {
        return this._bookingDetails;
    }

    public BookingCode getCode() {
        return this._code;
    }
}
