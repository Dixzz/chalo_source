package app.zophop.pubsub.eventbus.events;

public class WifiMessageSent {
    private final String _reqId;
    private final ad1 _responseType;

    public WifiMessageSent(String str, ad1 ad1) {
        this._responseType = ad1;
        this._reqId = str;
    }

    public String getReqId() {
        return this._reqId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
