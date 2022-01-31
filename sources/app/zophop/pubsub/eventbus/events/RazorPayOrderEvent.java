package app.zophop.pubsub.eventbus.events;

public class RazorPayOrderEvent {
    private final double _amount;
    private final String _orderId;
    private String _receiptId;
    private final ad1 _responseType;
    private final String _transactionId;

    public RazorPayOrderEvent(ad1 ad1, double d, String str, String str2) {
        this._responseType = ad1;
        this._amount = d;
        this._orderId = str;
        this._transactionId = str2;
    }

    public double get_amount() {
        return this._amount;
    }

    public String get_orderId() {
        return this._orderId;
    }

    public String get_receiptId() {
        return this._receiptId;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public String get_transactionId() {
        return this._transactionId;
    }
}
