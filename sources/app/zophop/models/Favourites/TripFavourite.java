package app.zophop.models.Favourites;

import app.zophop.models.TransitMode;

public class TripFavourite extends Favourite {
    public static final String MY_LOCATION = "My Location";
    private final mf1 _from;
    private final mf1 _to;

    public TripFavourite(FavType favType, mf1 mf1, mf1 mf12, String str, TransitMode transitMode, long j, RouteStoreType routeStoreType) {
        super(favType, str, transitMode, j, routeStoreType);
        this._from = mf1;
        this._to = mf12;
    }

    public mf1 getFrom() {
        return this._from;
    }

    public mf1 getTo() {
        return this._to;
    }

    public boolean isFromMyLocation() {
        return (getFrom() == null || getFrom().c == null || !getFrom().c.equals(MY_LOCATION)) ? false : true;
    }

    public boolean match(TripFavourite tripFavourite) {
        if (tripFavourite == null || tripFavourite.getFrom() == null || tripFavourite.getTo() == null || this._from == null || this._to == null) {
            return false;
        }
        boolean isFromMyLocation = isFromMyLocation();
        boolean isFromMyLocation2 = tripFavourite.isFromMyLocation();
        boolean equals = (isFromMyLocation || isFromMyLocation2) ? isFromMyLocation && isFromMyLocation2 : tripFavourite.getFrom().equals(getFrom());
        boolean equals2 = tripFavourite.getTo().equals(getTo());
        if (!equals || !equals2) {
            return false;
        }
        return true;
    }
}
