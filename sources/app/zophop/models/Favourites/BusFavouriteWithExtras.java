package app.zophop.models.Favourites;

import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class BusFavouriteWithExtras extends BusFavourite {
    private final boolean _isFreeRide;
    private final List<SPECIAL_FEATURE> _specialFeatures;

    public BusFavouriteWithExtras(String str, String str2, String str3, String str4, String str5, long j, RouteStoreType routeStoreType, String str6, List<SPECIAL_FEATURE> list, List<String> list2, boolean z) {
        super(str, str2, str3, str4, str5, j, routeStoreType, str6, list2, z);
        this._specialFeatures = list;
        this._isFreeRide = z;
    }

    public List<SPECIAL_FEATURE> getSpecialFeatures() {
        return this._specialFeatures;
    }

    public boolean isFreeRide() {
        return this._isFreeRide;
    }
}
