package com.razorpay;

import org.json.JSONObject;

/* compiled from: AutoOtpUtils */
public final class B$$W$ {
    public static JSONObject a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("otp_read", z ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
            return null;
        }
    }
}
