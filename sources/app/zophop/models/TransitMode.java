package app.zophop.models;

import app.zophop.R;

public enum TransitMode {
    train("railway", 0, R.string.train),
    bus("bus", 1, R.string.bus),
    metro("metro", 2, R.string.metro),
    monorail("monorail", 3, R.string.monorail),
    cab("cab", 5, R.string.cab),
    ferry("ferry", 6, R.string.ferry),
    ALL("transit", 4, R.string.transit);
    
    private final int _priority;
    private final int _resId;
    private final String _value;

    private TransitMode(String str, int i, int i2) {
        this._value = str;
        this._priority = i;
        this._resId = i2;
    }

    public static TransitMode getTransitMode(String str) {
        TransitMode[] values = values();
        for (int i = 0; i < 7; i++) {
            TransitMode transitMode = values[i];
            if (transitMode._value.equalsIgnoreCase(str)) {
                return transitMode;
            }
        }
        return train;
    }

    public int getPriority() {
        return this._priority;
    }

    public int get_resId() {
        return this._resId;
    }

    public String toString() {
        return this._value;
    }
}
