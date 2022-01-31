package app.zophop.models.mTicketing;

import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class BookingPassRouteInfo {
    private final String _routeId;
    private final String _routeName;
    private final List<SPECIAL_FEATURE> _specialFeatures;

    public BookingPassRouteInfo(String str, String str2, List<SPECIAL_FEATURE> list) {
        this._routeId = str;
        this._routeName = str2;
        this._specialFeatures = list;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public List<SPECIAL_FEATURE> getSpecialFeatures() {
        return this._specialFeatures;
    }
}
