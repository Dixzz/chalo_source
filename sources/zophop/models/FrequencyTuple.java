package zophop.models;

import java.io.Serializable;

public class FrequencyTuple implements Serializable {
    private static final long serialVersionUID = 1;
    public int end_time;
    public int frequency;
    public int start_time;

    public boolean equals(FrequencyTuple frequencyTuple) {
        if (frequencyTuple.start_time == this.start_time && frequencyTuple.end_time == this.end_time && frequencyTuple.frequency == this.frequency) {
            return true;
        }
        return false;
    }
}
