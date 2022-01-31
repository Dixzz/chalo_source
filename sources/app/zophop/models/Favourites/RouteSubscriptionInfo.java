package app.zophop.models.Favourites;

public class RouteSubscriptionInfo {
    private boolean _isAutoSubscriptionDialogShown;
    private long _routeDetailsLastSeen;
    private int _routeDetailsViewCount;
    private String _routeId;

    public long getRouteDetailsLastSeen() {
        return this._routeDetailsLastSeen;
    }

    public int getRouteDetailsViewCount() {
        return this._routeDetailsViewCount;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public boolean isIsAutoSubscriptionDialogShown() {
        return this._isAutoSubscriptionDialogShown;
    }

    public void setIsAutoSubscriptionDialogShown(boolean z) {
        this._isAutoSubscriptionDialogShown = z;
    }

    public void setRouteDetailsLastSeen(long j) {
        this._routeDetailsLastSeen = j;
    }

    public void setRouteDetailsViewCount(int i) {
        this._routeDetailsViewCount = i;
    }

    public void setRouteId(String str) {
        this._routeId = str;
    }
}
