package com.crashlytics.android.answers;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONObject;

public class AnswersAttributes {
    public final Map<String, Object> attributes = new ConcurrentHashMap();
    public final AnswersEventValidator validator;

    public AnswersAttributes(AnswersEventValidator answersEventValidator) {
        this.validator = answersEventValidator;
    }

    public void put(String str, String str2) {
        if (!this.validator.isNull(str, AnalyticsConstants.KEY) && !this.validator.isNull(str2, FirebaseAnalytics.Param.VALUE)) {
            putAttribute(this.validator.limitStringLength(str), this.validator.limitStringLength(str2));
        }
    }

    public void putAttribute(String str, Object obj) {
        if (!this.validator.isFullMap(this.attributes, str)) {
            this.attributes.put(str, obj);
        }
    }

    public String toString() {
        return new JSONObject(this.attributes).toString();
    }

    public void put(String str, Number number) {
        if (!this.validator.isNull(str, AnalyticsConstants.KEY) && !this.validator.isNull(number, FirebaseAnalytics.Param.VALUE)) {
            putAttribute(this.validator.limitStringLength(str), number);
        }
    }
}
