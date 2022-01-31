package app.zophop.models.autoCabBooking;

public enum BookingCode {
    PROCESSING,
    ACCEPTED,
    IN_PROGRESS,
    SUCCESS,
    DRIVER_CANCELED,
    RIDER_CANCELED,
    COMPLETED,
    USER_ACCOUNT_ISSUE,
    NO_DRIVERS_AVAILABLE,
    SURGE,
    RETRY_REQUEST,
    OTHER_ERRORS,
    UPDATED_DESTINATION,
    TRIP_NOT_FOUND,
    NETWORK_ERROR,
    PAYMENT_ISSUE,
    USER_BLOCKED_ISSUE,
    INVALID_TOKEN;

    public static BookingCode getBookingCode(String str) {
        return valueOf(str);
    }
}
