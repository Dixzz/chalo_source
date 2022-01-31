package app.zophop.models.Favourites;

import app.zophop.models.TransitMode;

public abstract class Favourite {
    public int _accessCount;
    public final String _id;
    public final TransitMode _mode;
    private RouteStoreType _routeStoreType;
    private long _time;
    public final FavType _type;

    public Favourite(FavType favType, String str, TransitMode transitMode, long j, RouteStoreType routeStoreType) {
        this._type = favType;
        this._id = str;
        this._mode = transitMode;
        this._time = j;
        this._routeStoreType = routeStoreType;
    }

    public int getAccessCount() {
        return this._accessCount;
    }

    public String getId() {
        return this._id;
    }

    public TransitMode getMode() {
        return this._mode;
    }

    public RouteStoreType getRouteStoreType() {
        return this._routeStoreType;
    }

    public long getTime() {
        return this._time;
    }

    public FavType getType() {
        return this._type;
    }

    public int hashCode() {
        int hashCode = this._type.hashCode();
        return this._mode.hashCode() + hj1.r0(this._id, (hashCode + (this._accessCount * 31)) * 31, 31);
    }

    public void increaseAccessCount() {
        this._accessCount++;
    }

    public void setRouteStoreType(RouteStoreType routeStoreType) {
        this._routeStoreType = routeStoreType;
    }

    public void setTime(long j) {
        this._time = j;
    }
}
