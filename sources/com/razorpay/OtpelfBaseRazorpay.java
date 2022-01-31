package com.razorpay;

import android.app.Activity;
import android.webkit.WebView;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class OtpelfBaseRazorpay extends BaseRazorpay {
    public boolean isRzpAssistEnabled = true;
    private RzpAssist rzpAssist;

    public OtpelfBaseRazorpay(Activity activity, String str) {
        super(activity, str);
    }

    @Override // com.razorpay.BaseRazorpay
    public final void finish() {
        RzpAssist rzpAssist2 = this.rzpAssist;
        if (rzpAssist2 != null && this.isRzpAssistEnabled) {
            rzpAssist2.reset();
            this.rzpAssist.paymentFlowEnd();
        }
        super.finish();
    }

    @Override // com.razorpay.BaseRazorpay
    public void onPageFinished(WebView webView, String str) {
        RzpAssist rzpAssist2;
        if (this.isRzpAssistEnabled && (rzpAssist2 = this.rzpAssist) != null) {
            rzpAssist2.onPageFinished(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    @Override // com.razorpay.BaseRazorpay
    public void onPageStarted(WebView webView, String str) {
        RzpAssist rzpAssist2;
        super.onPageStarted(webView, str);
        if (this.isRzpAssistEnabled && (rzpAssist2 = this.rzpAssist) != null) {
            rzpAssist2.onPageStarted(webView, str);
        }
    }

    @Override // com.razorpay.BaseRazorpay
    public void onProgressChanged(WebView webView, int i) {
        RzpAssist rzpAssist2;
        super.onProgressChanged(webView, i);
        if (this.isRzpAssistEnabled && (rzpAssist2 = this.rzpAssist) != null) {
            rzpAssist2.onProgressChanged(i);
        }
    }

    @Override // com.razorpay.BaseRazorpay
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        RzpAssist rzpAssist2;
        if (this.isRzpAssistEnabled && (rzpAssist2 = this.rzpAssist) != null) {
            rzpAssist2.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.razorpay.BaseRazorpay
    public void setPaymentIdInAddon(String str) {
        RzpAssist rzpAssist2;
        if (this.isRzpAssistEnabled && (rzpAssist2 = this.rzpAssist) != null) {
            rzpAssist2.setPaymentId(str);
        }
    }

    @Override // com.razorpay.BaseRazorpay
    public void setUpAddon(JSONObject jSONObject) {
        try {
            if (AnalyticsConstants.UPI.equalsIgnoreCase(jSONObject.getString("method"))) {
                this.isRzpAssistEnabled = false;
            } else {
                this.isRzpAssistEnabled = true;
            }
        } catch (Exception unused) {
        }
        if (this.isRzpAssistEnabled) {
            RzpAssist rzpAssist2 = new RzpAssist(this.apiKey, this.activity, this.webview, f$_G$.f694a, f$_G$.c, f$_G$.b);
            this.rzpAssist = rzpAssist2;
            rzpAssist2.setRzpAssistEnabled(true);
            this.rzpAssist.setPaymentData(jSONObject);
        }
    }

    @Override // com.razorpay.BaseRazorpay
    public void trackBackPress() {
        RzpAssist rzpAssist2;
        HashMap hashMap = new HashMap();
        if (this.isRzpAssistEnabled && (rzpAssist2 = this.rzpAssist) != null) {
            hashMap.put("current_loading_url", rzpAssist2.getCurrentLoadingUrl());
            hashMap.put("last_loaded_url", this.rzpAssist.getLastLoadedUrl());
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_BACK_PRESSED_SOFT, hashMap);
    }

    public OtpelfBaseRazorpay(Activity activity) {
        super(activity);
    }
}
