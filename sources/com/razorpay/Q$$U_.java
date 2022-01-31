package com.razorpay;

import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Razorpay */
public final class Q$$U_ implements RzpInternalCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Razorpay f683a;

    public Q$$U_(Razorpay razorpay) {
        this.f683a = razorpay;
    }

    @Override // com.razorpay.RzpInternalCallback
    public final void onPaymentError(int i, String str) {
        HashMap m0 = hj1.m0("response", str);
        m0.put("code", Integer.valueOf(i));
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOMUI_INTERNAL_CALLBACK_ERROR, m0);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("sdk_error_code", i);
            this.f683a.oncomplete(jSONObject.toString());
        } catch (Exception e) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOMUI_INTERNAL_CALLBACK_ERROR_EXCEPTION);
            e.printStackTrace();
            this.f683a.oncomplete(str);
        }
    }

    @Override // com.razorpay.RzpInternalCallback
    public final void onPaymentSuccess(String str) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOMUI_INTERNAL_CALLBACK_SUCCESS, hj1.m0("response", str));
        this.f683a.oncomplete(str);
    }
}
