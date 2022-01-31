package app.zophop.models.Favourites;

import app.zophop.models.Stop;

public class StopFavourite extends Favourite {
    private final Stop _stop;

    public StopFavourite(Stop stop, String str, long j, RouteStoreType routeStoreType) {
        super(FavType.STOP, str, stop.getMode(), j, routeStoreType);
        this._stop = stop;
    }

    public Stop getStop() {
        return this._stop;
    }

    public boolean match(String str) {
        if (str == null) {
            return false;
        }
        return this._stop.getId().equals(str);
    }
}
