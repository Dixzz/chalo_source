package zophop.models;

import java.io.Serializable;

public enum SPECIAL_FEATURE implements Serializable {
    FAST,
    AC,
    BOGGIE_12,
    BOGGIE_9,
    BOGGIE_15,
    LADIES_ONLY;

    public static SPECIAL_FEATURE getSpecialFeature(String str) {
        SPECIAL_FEATURE[] values = values();
        for (int i = 0; i < 6; i++) {
            SPECIAL_FEATURE special_feature = values[i];
            if (special_feature.toString().toLowerCase().equals(str.toLowerCase())) {
                return special_feature;
            }
        }
        return null;
    }
}
