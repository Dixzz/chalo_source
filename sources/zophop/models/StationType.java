package zophop.models;

import java.io.Serializable;

public enum StationType implements Serializable {
    METRO,
    RAILWAY,
    BUS,
    MONORAIL,
    FERRY;

    public static StationType getStationType(String str) {
        StationType[] values = values();
        for (int i = 0; i < 5; i++) {
            StationType stationType = values[i];
            if (stationType.toString().toLowerCase().equals(str.toLowerCase())) {
                return stationType;
            }
        }
        return null;
    }

    public static TravelMode getTravelMode(StationType stationType) {
        if (stationType.equals(METRO) || stationType.equals(MONORAIL) || stationType.equals(RAILWAY)) {
            return TravelMode.TRAINISH;
        }
        if (stationType.equals(BUS)) {
            return TravelMode.BUSISH;
        }
        if (stationType.equals(FERRY)) {
            return TravelMode.FERRY;
        }
        return null;
    }
}
