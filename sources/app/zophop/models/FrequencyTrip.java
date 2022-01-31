package app.zophop.models;

import java.util.List;
import java.util.Map;
import zophop.models.SPECIAL_FEATURE;

public class FrequencyTrip extends Trip {
    private final Map<TimeInterval, Integer> _frequencyMap;

    public FrequencyTrip(String str, TransitMode transitMode, List<TripLeg> list, Map<TimeInterval, Integer> map, List<SPECIAL_FEATURE> list2) {
        super(str, transitMode, list, list2);
        this._frequencyMap = map;
    }

    public int getCurrentFrequency() {
        return getFrequencyAtTime(ui1.N());
    }

    public int getFrequencyAtTime(int i) {
        for (TimeInterval timeInterval : this._frequencyMap.keySet()) {
            if (timeInterval.containsTime(i)) {
                return this._frequencyMap.get(timeInterval).intValue();
            }
        }
        return -1;
    }
}
