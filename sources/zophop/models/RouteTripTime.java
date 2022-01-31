package zophop.models;

public class RouteTripTime implements Comparable<RouteTripTime> {
    public boolean extrapolated;
    public FrequencyTuple frequency_tuple;
    public boolean isFrequency;
    public Integer start_time;

    public int compareTo(RouteTripTime routeTripTime) {
        boolean z = routeTripTime.isFrequency;
        if (!z && !this.isFrequency) {
            return this.start_time.intValue() - routeTripTime.start_time.intValue();
        }
        boolean z2 = this.isFrequency;
        if (!z2 || z) {
            if (!z2 || !z) {
                if (!z2 && z) {
                    if (this.start_time.intValue() < routeTripTime.frequency_tuple.start_time) {
                        return -1;
                    }
                    if (this.start_time.intValue() > routeTripTime.frequency_tuple.end_time) {
                        return 1;
                    }
                }
                return 0;
            }
            FrequencyTuple frequencyTuple = this.frequency_tuple;
            int i = frequencyTuple.end_time;
            FrequencyTuple frequencyTuple2 = routeTripTime.frequency_tuple;
            if (i < frequencyTuple2.start_time) {
                return -1;
            }
            return frequencyTuple.start_time > frequencyTuple2.end_time ? 1 : 0;
        } else if (routeTripTime.start_time.intValue() < this.frequency_tuple.start_time) {
            return 1;
        } else {
            return routeTripTime.start_time.intValue() > this.frequency_tuple.end_time ? -1 : 0;
        }
    }
}
