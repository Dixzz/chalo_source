package app.zophop.pubsub.eventbus.events;

public class OauthEvent {
    private final String _provider;
    private final ad1 _responseType;

    public OauthEvent(ad1 ad1, String str) {
        this._provider = str;
        this._responseType = ad1;
    }

    public String getProvider() {
        return this._provider;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
