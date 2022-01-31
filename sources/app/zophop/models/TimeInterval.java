package app.zophop.models;

import android.util.Pair;

public class TimeInterval extends Pair<Integer, Integer> {
    public TimeInterval(Integer num, Integer num2) {
        super(num, num2);
    }

    public boolean containsTime(int i) {
        return i >= ((Integer) ((Pair) this).first).intValue() && i <= ((Integer) ((Pair) this).second).intValue();
    }

    public int getHigh() {
        return ((Integer) ((Pair) this).second).intValue();
    }

    public int getLow() {
        return ((Integer) ((Pair) this).first).intValue();
    }
}
