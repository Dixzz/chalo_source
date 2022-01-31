package app.zophop.pubsub.eventbus.events;

public class ReferralTrackingFailureEvent {
    private final String _errorCode;
    private final String _errorMessage;
    private final String _referralCode;

    public ReferralTrackingFailureEvent(String str, String str2, String str3) {
        this._referralCode = str;
        this._errorCode = str2;
        this._errorMessage = str3;
    }

    public String getErrorCode() {
        return this._errorCode;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public String getReferralCode() {
        return this._referralCode;
    }
}
