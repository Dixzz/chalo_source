package app.zophop.models;

import app.zophop.models.Route;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class TripRoute extends Route {
    private final List<TripInfo> _trips;

    public TripRoute(String str, String str2, TransitMode transitMode, List<Stop> list, Stop stop, List<TripInfo> list2, List<Route.RouteTiming> list3, String str3, boolean z, boolean z2, boolean z3, boolean z4, String str4, List<SPECIAL_FEATURE> list4, List<String> list5) {
        super(str, str2, transitMode, list, stop, list3, str3, z, z2, z3, z4, str4, list4, list5);
        this._trips = list2;
    }

    public List<TripInfo> getTrips() {
        return this._trips;
    }
}
