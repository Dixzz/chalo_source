package app.zophop.models.Favourites;

import app.zophop.models.Stop;
import app.zophop.models.TransitMode;

public class RailFavourite extends Favourite {
    private final Stop _fromStop;
    private final Stop _toStop;

    public RailFavourite(Stop stop, Stop stop2, String str, TransitMode transitMode, long j, RouteStoreType routeStoreType) {
        super(FavType.TRIP, str, transitMode, j, routeStoreType);
        this._fromStop = stop;
        this._toStop = stop2;
    }

    public Stop getFromStop() {
        return this._fromStop;
    }

    public Stop getToStop() {
        return this._toStop;
    }

    public boolean match(Stop stop, Stop stop2) {
        return stop != null && stop2 != null && this._fromStop.equals(stop) && this._toStop.equals(stop2);
    }
}
