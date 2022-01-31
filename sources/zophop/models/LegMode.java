package zophop.models;

import java.io.Serializable;

public enum LegMode implements Serializable {
    MONORAIL,
    METRO,
    AUTO,
    TAXI,
    WALK,
    RAILWAY,
    BUS,
    FERRY;

    public static LegMode getMode(StationType stationType) {
        LegMode[] values = values();
        for (int i = 0; i < 8; i++) {
            LegMode legMode = values[i];
            if (legMode.toString().toLowerCase().equals(stationType.toString().toLowerCase())) {
                return legMode;
            }
        }
        return null;
    }

    public static TravelMode getTravelMode(LegMode legMode) {
        if (legMode.equals(METRO) || legMode.equals(MONORAIL) || legMode.equals(RAILWAY)) {
            return TravelMode.TRAINISH;
        }
        if (legMode.equals(BUS)) {
            return TravelMode.BUSISH;
        }
        if (legMode.equals(FERRY)) {
            return TravelMode.FERRY;
        }
        return TravelMode.TRANSIT;
    }

    public static boolean isHiredTransit(LegMode legMode) {
        return legMode.equals(WALK) || legMode.equals(AUTO) || legMode.equals(TAXI);
    }

    public static boolean isTaxish(LegMode legMode) {
        return legMode.equals(AUTO) || legMode.equals(TAXI);
    }

    public static boolean isTrainish(LegMode legMode) {
        return legMode.equals(METRO) || legMode.equals(MONORAIL) || legMode.equals(RAILWAY);
    }
}
