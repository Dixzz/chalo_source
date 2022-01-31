package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

public final class b_$A$ {
    public static void b(String str, String str2, int i, PaymentCompleteInternalCallback paymentCompleteInternalCallback) {
        T__j$.a(a(str, str2), new B$$J$(paymentCompleteInternalCallback, i, str, str2));
    }

    public static int c(String str) {
        if (f$_G$.a().g().has(str.toLowerCase())) {
            try {
                return f$_G$.a().g().getInt(str.toLowerCase());
            } catch (Exception e) {
                AnalyticsUtil.reportError(e, AnalyticsConstants.ERROR_EXCEPTION, e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                sb.append("\\f");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"' || charAt == '/' || charAt == '\\') {
                sb.append('\\');
                sb.append(charAt);
            } else {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                    case '\n':
                        sb.append("\\n");
                        continue;
                    default:
                        if (charAt > 31) {
                            sb.append(charAt);
                            break;
                        } else {
                            sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                            continue;
                        }
                }
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        JSONObject f = f$_G$.a().f();
        if (str == null || str.length() < 6) {
            return "unknown";
        }
        Iterator<String> keys = f.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                if (str.matches(f.getString(next) + ".*")) {
                    return next;
                }
            } catch (Exception e) {
                AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        return "unknown";
    }

    public static void a(JSONObject jSONObject, Activity activity, String str, PaymentCompleteInternalCallback paymentCompleteInternalCallback) {
        String a2 = I$_n_.a(activity, BaseRazorpay.RAZORPAY_PAYMENT_ID);
        if (a2 != null && !TextUtils.isEmpty(a2)) {
            String optString = jSONObject.optString("txnId");
            if (optString == null || TextUtils.isEmpty(optString)) {
                T__j$.a(BaseConstants.RZP_PAYMENTS_ENDPOINT + a2 + "/cancel?key_id=" + str, new L$$C_(a2, str, paymentCompleteInternalCallback));
                return;
            }
            b(a2, str, 0, paymentCompleteInternalCallback);
        }
    }

    public static void a(Activity activity, String str, PaymentCompleteInternalCallback paymentCompleteInternalCallback) {
        String a2 = I$_n_.a(activity, BaseRazorpay.RAZORPAY_PAYMENT_ID);
        if (a2 != null && !TextUtils.isEmpty(a2)) {
            b(a2, str, 0, paymentCompleteInternalCallback);
        }
    }

    private static String a(String str, String str2) {
        return BaseConstants.RZP_PAYMENTS_ENDPOINT + str + "/status?key_id=" + str2;
    }

    public static void a(Context context, boolean z) {
        I$_n_.b(context).putBoolean("rzp_last_payment_status", z).apply();
    }
}
