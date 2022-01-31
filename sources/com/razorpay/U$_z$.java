package com.razorpay;

import com.razorpay.AnalyticsProperty;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: RzpAssist */
public final class U$_z$ implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f689a;
    private /* synthetic */ RzpAssist b;

    public U$_z$(RzpAssist rzpAssist, String str) {
        this.b = rzpAssist;
        this.f689a = str;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject(this.f689a);
            OTP otp = new OTP(jSONObject.getString(AnalyticsConstants.OTP), jSONObject.getString(AnalyticsConstants.SENDER), jSONObject.getString(AnalyticsConstants.BANK));
            HashMap hashMap = new HashMap();
            hashMap.put(AnalyticsConstants.SENDER, otp.f682a);
            if (otp.f682a.contains("RZRPAY")) {
                this.b.isRazorpayOtpReceived = true;
                hashMap.put(AnalyticsConstants.RAZORPAY_OTP, Boolean.TRUE);
            } else {
                hashMap.put(AnalyticsConstants.RAZORPAY_OTP, Boolean.FALSE);
                this.b.otpRead = true;
                AnalyticsUtil.addProperty("payment_otp_received", new AnalyticsProperty(true, AnalyticsProperty.Scope.PAYMENT));
            }
            AnalyticsUtil.trackEvent(AnalyticsEvent.OTP_RECEIVED, hashMap);
        } catch (Exception e) {
            d__1_.a("Error in parsing json", e);
        }
    }
}
