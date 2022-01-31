package app.zophop.models;

import app.zophop.models.Route;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class FrequencyRoute extends Route {
    private final FrequencyTripInfo _frequencyTripInfo;

    public FrequencyRoute(String str, String str2, TransitMode transitMode, List<Stop> list, Stop stop, FrequencyTripInfo frequencyTripInfo, List<Route.RouteTiming> list2, String str3, boolean z, boolean z2, boolean z3, boolean z4, String str4, List<SPECIAL_FEATURE> list3, List<String> list4) {
        super(str, str2, transitMode, list, stop, list2, str3, z, z2, z3, z4, str4, list3, list4);
        this._frequencyTripInfo = frequencyTripInfo;
    }

    public int getCurrentFrequency() {
        return this._frequencyTripInfo.getCurrentFrequency();
    }

    public int getFrequencyAtTime(int i) {
        return this._frequencyTripInfo.getFrequencyAtTime(i);
    }

    public FrequencyTripInfo getFrequencyTripInfo() {
        return this._frequencyTripInfo;
    }
}
