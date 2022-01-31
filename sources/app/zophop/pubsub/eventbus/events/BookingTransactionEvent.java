package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.BookingTransaction;
import app.zophop.models.mTicketing.PayuUser;

public class BookingTransactionEvent {
    private final BookingTransaction _bookingTransaction;
    private final String _errorMessage;
    private final String _jsonPayLoad;
    private final String _paymentHash;
    private final String _productInfo;
    private final RazorPayOrderData _razorPayOrderData;
    private final ad1 _responseType;
    private String _statusCode;
    private final PayuUser _user;
    private final String _webServiceHash;

    public BookingTransactionEvent(ad1 ad1, String str, BookingTransaction bookingTransaction, String str2, String str3, String str4, String str5, PayuUser payuUser, RazorPayOrderData razorPayOrderData) {
        this._responseType = ad1;
        this._errorMessage = str;
        this._bookingTransaction = bookingTransaction;
        this._paymentHash = str2;
        this._webServiceHash = str3;
        this._jsonPayLoad = str4;
        this._productInfo = str5;
        this._user = payuUser;
        this._razorPayOrderData = razorPayOrderData;
    }

    public BookingTransaction getBookingTransaction() {
        return this._bookingTransaction;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public String getJsonPayLoad() {
        return this._jsonPayLoad;
    }

    public String getPaymentHash() {
        return this._paymentHash;
    }

    public String getProductInfo() {
        return this._productInfo;
    }

    public RazorPayOrderData getRazorPayOrderData() {
        return this._razorPayOrderData;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public String getStatusCode() {
        return this._statusCode;
    }

    public PayuUser getUser() {
        return this._user;
    }

    public String getWebServiceHash() {
        return this._webServiceHash;
    }

    public void setStatusCode(String str) {
        this._statusCode = str;
    }
}
