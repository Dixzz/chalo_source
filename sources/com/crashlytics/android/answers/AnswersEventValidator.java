package com.crashlytics.android.answers;

import java.util.Locale;
import java.util.Map;

public class AnswersEventValidator {
    public boolean failFast;
    public final int maxNumAttributes;
    public final int maxStringLength;

    public AnswersEventValidator(int i, int i2, boolean z) {
        this.maxNumAttributes = i;
        this.maxStringLength = i2;
        this.failFast = z;
    }

    private void logOrThrowException(RuntimeException runtimeException) {
        if (this.failFast) {
            throw runtimeException;
        }
    }

    public boolean isFullMap(Map<String, Object> map, String str) {
        if (map.size() < this.maxNumAttributes || map.containsKey(str)) {
            return false;
        }
        logOrThrowException(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", Integer.valueOf(this.maxNumAttributes))));
        return true;
    }

    public boolean isNull(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        logOrThrowException(new NullPointerException(hj1.S(str, " must not be null")));
        return true;
    }

    public String limitStringLength(String str) {
        int length = str.length();
        int i = this.maxStringLength;
        if (length <= i) {
            return str;
        }
        logOrThrowException(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", Integer.valueOf(i))));
        return str.substring(0, this.maxStringLength);
    }
}
