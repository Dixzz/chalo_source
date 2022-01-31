package app.zophop.models.mTicketing;

import app.zophop.R;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;

public enum BookingPassType {
    PUNCHABLE("punchable", R.string.punchable_pass),
    NON_PUNCHABLE("non_punchable", R.string.non_punchable_pass),
    MAGIC(AnalyticsConstants.MAGIC, R.string.magic_pass);
    
    private final int _resId;
    private final String _value;

    private BookingPassType(String str, int i) {
        this._value = str;
        this._resId = i;
    }

    public static BookingPassType fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (BookingPassType) hj1.s(str, BookingPassType.class);
    }

    public static BookingPassType fromString(String str) {
        if (str != null) {
            BookingPassType[] values = values();
            for (int i = 0; i < 3; i++) {
                BookingPassType bookingPassType = values[i];
                if (str.equalsIgnoreCase(bookingPassType.toString())) {
                    return bookingPassType;
                }
            }
        }
        return PUNCHABLE;
    }

    public int getResId() {
        return this._resId;
    }

    public String toString() {
        return this._value;
    }

    public static String toString(BookingPassType bookingPassType) {
        if (bookingPassType == null) {
            return null;
        }
        return new Gson().toJson(bookingPassType);
    }
}
