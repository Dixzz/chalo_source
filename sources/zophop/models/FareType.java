package zophop.models;

import java.io.Serializable;

public enum FareType implements Serializable {
    ADULT_AC,
    ADULT_ORDINARY,
    CHILD_AC,
    CHILD_ORDINARY,
    GENERAL,
    FIRST_CLASS,
    CHILD_FIRST_CLASS,
    AUTO,
    TAXI,
    SENIOR_CITIZEN,
    ADULT,
    CHILD;

    public static FareType getFareType(String str) {
        FareType[] values = values();
        for (int i = 0; i < 12; i++) {
            FareType fareType = values[i];
            if (str.toUpperCase().equals(fareType.toString().toUpperCase())) {
                return fareType;
            }
        }
        return null;
    }
}
