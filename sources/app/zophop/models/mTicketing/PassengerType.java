package app.zophop.models.mTicketing;

import app.zophop.R;

public enum PassengerType {
    GENERAL_PASSENGER("GENERAL", R.string.indore_general_passenger),
    ADULT("adult", R.string.general_passenger),
    STUDENT("STUDENT", R.string.student_passenger_pass),
    SENIOR_CITIZEN("SENIOR_CITIZEN", R.string.senior_citizen),
    CHILD("child", R.string.child_passenger),
    HC("HC", R.string.handicapped_passenger),
    IMCRagpickers("IMC_RAGPICKERS", R.string.imc_rag_pickers),
    Suburban("Suburban", R.string.suburban_passenger),
    WOMEN("WOMEN", R.string.woman),
    MUNICIPALITY_EMPLOYEE("MUNICIPALITY_EMPLOYEE", R.string.municipality_employee),
    GOVT_AUTH_PERSON("GOVT_AUTH_PERSON", R.string.gov_auth_person),
    JOURNALIST("JOURNALIST", R.string.journalist),
    STATE_GOVT_EMPLOYEE("STATE_GOVT_EMPLOYEE", R.string.state_gov_employee),
    DAY_PASS("DAY_PASS", R.string.indore_general_passenger),
    GENERAL_AC("GENERAL_AC", R.string.general_ac),
    GENERAL_NON_AC("GENERAL_NON_AC", R.string.general_non_ac);
    
    private final int _resId;
    private final String _value;

    private PassengerType(String str, int i) {
        this._value = str;
        this._resId = i;
    }

    public static PassengerType fromString(String str) {
        if (str == null) {
            return null;
        }
        PassengerType[] values = values();
        for (int i = 0; i < 16; i++) {
            PassengerType passengerType = values[i];
            if (str.equalsIgnoreCase(passengerType.toString()) || str.equals(passengerType.name())) {
                return passengerType;
            }
        }
        return null;
    }

    public int getResId() {
        return this._resId;
    }

    public String toString() {
        return this._value;
    }
}
