package app.zophop.models.Favourites;

public enum FavType {
    TRIP("Trip"),
    LINE("Line"),
    STOP("Stop"),
    STOP_BASED_TRIP("StopBasedTrip");
    
    private final String _typeValue;

    private FavType(String str) {
        this._typeValue = str;
    }

    public String getType() {
        return this._typeValue;
    }

    public String toString() {
        return this._typeValue;
    }
}
