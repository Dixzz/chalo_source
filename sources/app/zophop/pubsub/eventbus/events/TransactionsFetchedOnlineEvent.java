package app.zophop.pubsub.eventbus.events;

public class TransactionsFetchedOnlineEvent {
    private final String _errorMessage;
    private final ad1 _responseType;
    private final String _userId;

    public TransactionsFetchedOnlineEvent(ad1 ad1, String str, String str2) {
        this._responseType = ad1;
        this._errorMessage = str;
        this._userId = str2;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public String getUserId() {
        return this._userId;
    }
}
