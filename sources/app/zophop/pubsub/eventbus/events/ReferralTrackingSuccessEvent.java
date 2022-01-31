package app.zophop.pubsub.eventbus.events;

public class ReferralTrackingSuccessEvent {
    private final String _referralCode;

    public ReferralTrackingSuccessEvent(String str) {
        this._referralCode = str;
    }

    public String getReferralCode() {
        return this._referralCode;
    }
}
