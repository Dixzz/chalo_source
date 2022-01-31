package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.BookingTransaction;

public class CashPaymentEvent {
    public double _amount;
    public BookingTransaction _bookingTransaction;
    public String _failureReason;
    public String _referenceId;
    public ad1 _responseType;
    public String _userId;

    public CashPaymentEvent(String str, String str2, double d, BookingTransaction bookingTransaction) {
        this._userId = str;
        this._referenceId = str2;
        this._amount = d;
        this._bookingTransaction = bookingTransaction;
    }

    public double getAmount() {
        return this._amount;
    }

    public BookingTransaction getBookingTransaction() {
        return this._bookingTransaction;
    }

    public String getFailureReason() {
        return this._failureReason;
    }

    public String getReferenceId() {
        return this._referenceId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public String getUserId() {
        return this._userId;
    }

    public void setFailureReason(String str) {
        this._failureReason = str;
    }

    public void setResponse(ad1 ad1) {
        this._responseType = ad1;
    }

    public CashPaymentEvent() {
    }
}
