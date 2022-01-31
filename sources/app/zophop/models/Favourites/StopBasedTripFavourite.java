package app.zophop.models.Favourites;

import app.zophop.models.Stop;
import app.zophop.models.TransitMode;

public class StopBasedTripFavourite extends Favourite {
    public Stop _destinationStop;
    public Stop _originStop;

    public StopBasedTripFavourite(FavType favType, String str, TransitMode transitMode, long j, RouteStoreType routeStoreType, Stop stop, Stop stop2) {
        super(favType, str, transitMode, j, routeStoreType);
        this._originStop = stop;
        this._destinationStop = stop2;
    }

    public Stop getDestinationStop() {
        return this._destinationStop;
    }

    public Stop getOriginStop() {
        return this._originStop;
    }

    public boolean match(StopBasedTripFavourite stopBasedTripFavourite) {
        Stop stop;
        if (stopBasedTripFavourite == null || stopBasedTripFavourite.getOriginStop() == null || stopBasedTripFavourite.getDestinationStop() == null || (stop = this._originStop) == null || this._destinationStop == null || !stop.equals(stopBasedTripFavourite.getOriginStop()) || !this._destinationStop.equals(stopBasedTripFavourite.getDestinationStop())) {
            return false;
        }
        return true;
    }
}
