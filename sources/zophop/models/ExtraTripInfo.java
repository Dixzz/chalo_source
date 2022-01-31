package zophop.models;

import java.util.ArrayList;

public class ExtraTripInfo implements Comparable<ExtraTripInfo> {
    public int arrival_time;
    public boolean frequency_trip;
    public FrequencyTuple frequency_tuple;
    public String from_stop_name;
    public String platform;
    public String route_id;
    public String route_name;
    public ArrayList<SPECIAL_FEATURE> special_features;
    public String to_stop_name;
    public String trip_id;

    public int compareTo(ExtraTripInfo extraTripInfo) {
        int i;
        int i2;
        boolean z = this.frequency_trip;
        if (!z && !extraTripInfo.frequency_trip) {
            i = this.arrival_time;
            i2 = extraTripInfo.arrival_time;
        } else if (!z && extraTripInfo.frequency_trip) {
            i = this.arrival_time;
            i2 = extraTripInfo.frequency_tuple.start_time;
        } else if (z && !extraTripInfo.frequency_trip) {
            i = this.frequency_tuple.start_time;
            i2 = extraTripInfo.arrival_time;
        } else if (!z || !extraTripInfo.frequency_trip) {
            return 0;
        } else {
            i = this.frequency_tuple.start_time;
            i2 = extraTripInfo.frequency_tuple.start_time;
        }
        return i - i2;
    }
}
