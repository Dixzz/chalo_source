package app.zophop.models;

import android.util.Pair;
import java.util.List;

public class FrequencyTripInfo extends TripInfo {
    private final List<Pair<TimeInterval, Integer>> _frequencyList;

    public FrequencyTripInfo(String str, boolean z, List<Pair<TimeInterval, Integer>> list) {
        super(str, 0, 0, 0, z);
        this._frequencyList = list;
    }

    public int getCurrentFrequency() {
        return getFrequencyAtTime(ui1.N());
    }

    public int getFrequencyAtTime(int i) {
        for (Pair<TimeInterval, Integer> pair : this._frequencyList) {
            if (((TimeInterval) pair.first).containsTime(i)) {
                return ((Integer) pair.second).intValue();
            }
        }
        return -1;
    }

    public List<Pair<TimeInterval, Integer>> getFrequencyList() {
        return this._frequencyList;
    }
}
