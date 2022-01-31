package app.zophop.models.mTicketing;

import app.zophop.R;
import com.google.gson.Gson;

public enum TicketStatus {
    UNUSED("unused", R.string.unused_ticket),
    USED("used", R.string.used_ticket),
    EXPIRED("expired", R.string.expired_ticket);
    
    private final int _resId;
    private final String _value;

    private TicketStatus(String str, int i) {
        this._value = str;
        this._resId = i;
    }

    public static TicketStatus fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (TicketStatus) hj1.s(str, TicketStatus.class);
    }

    public static TicketStatus fromString(String str) {
        if (str != null) {
            TicketStatus[] values = values();
            for (int i = 0; i < 3; i++) {
                TicketStatus ticketStatus = values[i];
                if (str.equalsIgnoreCase(ticketStatus.toString())) {
                    return ticketStatus;
                }
            }
        }
        return EXPIRED;
    }

    public static String toConverterString(TicketStatus ticketStatus) {
        if (ticketStatus == null) {
            return null;
        }
        return new Gson().toJson(ticketStatus);
    }

    public int getResId() {
        return this._resId;
    }

    public String toString() {
        return this._value;
    }
}
