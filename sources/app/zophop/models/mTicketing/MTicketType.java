package app.zophop.models.mTicketing;

public enum MTicketType {
    SINGLE_JOURNEY_TICKET;
    
    private final String _value = "ticket";

    private MTicketType() {
    }

    public static MTicketType fromString(String str) {
        if (str != null) {
            MTicketType[] values = values();
            for (int i = 0; i < 1; i++) {
                MTicketType mTicketType = values[i];
                if (str.equalsIgnoreCase(mTicketType.toString())) {
                    return mTicketType;
                }
            }
        }
        return SINGLE_JOURNEY_TICKET;
    }

    public String toString() {
        return this._value;
    }
}
