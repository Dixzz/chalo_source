package zophop.models;

import java.io.Serializable;

public enum TravelMode implements Serializable {
    TRAINISH,
    BUSISH,
    TRANSIT,
    FERRY;

    public static TravelMode getTravelMode(String str) {
        String lowerCase = str.toLowerCase();
        TravelMode[] values = values();
        for (int i = 0; i < 4; i++) {
            TravelMode travelMode = values[i];
            if (travelMode.toString().toLowerCase().equals(lowerCase)) {
                return travelMode;
            }
        }
        return null;
    }
}
