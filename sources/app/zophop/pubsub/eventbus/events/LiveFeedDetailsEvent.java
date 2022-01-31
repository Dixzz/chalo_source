package app.zophop.pubsub.eventbus.events;

import app.zophop.models.LiveFeed;

public class LiveFeedDetailsEvent {
    private final LiveFeed _liveFeed;
    private final ad1 _responseType;
    private final String _routeId;

    public LiveFeedDetailsEvent(String str, LiveFeed liveFeed, ad1 ad1) {
        this._routeId = str;
        this._liveFeed = liveFeed;
        this._responseType = ad1;
    }

    public LiveFeed getLiveFeed() {
        return this._liveFeed;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public String getRouteId() {
        return this._routeId;
    }
}
