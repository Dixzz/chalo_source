package app.zophop.models.Favourites;

import app.zophop.models.TransitMode;
import java.util.List;

public class BusFavourite extends Favourite {
    private final String _agency;
    private final String _endStopName;
    private final boolean _isFreeRideAvailable;
    private final String _routeId;
    private final String _routeName;
    private final List<String> _spfList;
    private final String _startStopName;

    public BusFavourite(String str, String str2, String str3, String str4, String str5, long j, RouteStoreType routeStoreType, String str6, List<String> list, boolean z) {
        super(FavType.LINE, str5, TransitMode.bus, j, routeStoreType);
        this._routeId = str;
        this._routeName = str2;
        this._startStopName = str3;
        this._endStopName = str4;
        this._agency = str6;
        this._spfList = list;
        this._isFreeRideAvailable = z;
    }

    public String getAgency() {
        return this._agency;
    }

    public String getEndStopName() {
        return this._endStopName;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public String getStartStopName() {
        return this._startStopName;
    }

    public List<String> get_spfList() {
        return this._spfList;
    }

    public boolean is_isFreeRideAvailable() {
        return this._isFreeRideAvailable;
    }

    public boolean match(String str) {
        if (str == null) {
            return false;
        }
        return this._routeId.equals(str);
    }
}
