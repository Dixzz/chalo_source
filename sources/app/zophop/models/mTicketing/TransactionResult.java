package app.zophop.models.mTicketing;

import app.zophop.pubsub.eventbus.events.TripPlannerEvent;

public class TransactionResult {
    private final String _errorMessage;
    private final String _payUId;
    private final TripPlannerEvent.ResponseType _responseType;
    private final float _transactionAmount;
    private final String _transactionId;

    public TransactionResult(TripPlannerEvent.ResponseType responseType, String str, String str2, float f, String str3) {
        this._responseType = responseType;
        this._transactionId = str;
        this._payUId = str2;
        this._transactionAmount = f;
        this._errorMessage = str3;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public String getPayUId() {
        return this._payUId;
    }

    public TripPlannerEvent.ResponseType getResponseType() {
        return this._responseType;
    }

    public String getTransactionId() {
        return this._transactionId;
    }

    public float get_transactionAmount() {
        return this._transactionAmount;
    }
}
