package app.zophop.pubsub.eventbus.events;

public class SubscriptionEvent {
    private boolean _isAdded;
    private String _routeId;

    public SubscriptionEvent() {
    }

    public String getRouteId() {
        return this._routeId;
    }

    public boolean isAdded() {
        return this._isAdded;
    }

    public void setIsAdded(boolean z) {
        this._isAdded = z;
    }

    public void setRouteId(String str) {
        this._routeId = str;
    }

    public SubscriptionEvent(String str, boolean z) {
        this._routeId = str;
        this._isAdded = z;
    }
}
