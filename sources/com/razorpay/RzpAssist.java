package com.razorpay;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.razorpay.AnalyticsProperty;
import java.util.HashMap;
import org.json.JSONObject;

public final class RzpAssist implements SmsAgentInterface {
    private Activity activity;
    private String currentLoadingUrl = "";
    private K$$z$ elfData;
    private boolean hasOtpPermission = false;
    private boolean isMagic = false;
    private boolean isRazorpayOtpReceived = false;
    private boolean isRzpAssistEnabled = false;
    private boolean jsInsertedInCurrentPage = false;
    public String lastSms;
    private String lastURL = "";
    private String merchantKey;
    private JSONObject otpElfPreferences = new JSONObject();
    private boolean otpRead = false;
    private long pageStartTime;
    private JSONObject paymentData = new JSONObject();
    private String paymentId;
    private String sdkType = "standalone";
    private int sdkVersionCode;
    private N$$J$ smsAgent;
    private WebView webview;

    public RzpAssist(String str, Activity activity2, WebView webView, String str2, int i, String str3) {
        if (g__v_.a().isOTPElfEnabled().booleanValue()) {
            if (str == null || str.isEmpty()) {
                throw new RuntimeException("merchantKey cannot be null or empty");
            }
            this.sdkType = str2;
            this.sdkVersionCode = i;
            if (str2.equals("standalone")) {
                AnalyticsUtil.setup(activity2, str, str2, i, str3);
            }
            this.webview = webView;
            this.merchantKey = str;
            this.activity = activity2;
            K$$z$ k$$z$ = new K$$z$(activity2);
            this.elfData = k$$z$;
            T__j$.a(g__v_.a().getOtpElfVersionUrl(), new B_$q$(k$$z$));
            setup();
            AnalyticsUtil.addProperty("OTPElf Version", new AnalyticsProperty(BaseUtils.getLocalVersion(activity2, K$$z$.b), AnalyticsProperty.Scope.ORDER));
        }
    }

    private void handleJsInsertion() {
        try {
            JSONObject oTPElfSettings = g__v_.a().getOTPElfSettings();
            oTPElfSettings.put(AnalyticsConstants.MERCHANT_KEY, this.merchantKey);
            oTPElfSettings.put("otp_permission", this.hasOtpPermission);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.sdkType);
            jSONObject.put("version_code", this.sdkVersionCode);
            oTPElfSettings.put(AnalyticsConstants.SDK, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            if (!this.isMagic) {
                jSONObject2.put("type", AnalyticsConstants.RZPASSIST);
                jSONObject2.put("version_code", L__R$.b.intValue());
            } else {
                jSONObject2.put("type", AnalyticsConstants.MAGIC);
                jSONObject2.put("version_code", L__R$.c.intValue());
            }
            oTPElfSettings.put("plugin", jSONObject2);
            oTPElfSettings.put("payment_data", this.paymentData);
            oTPElfSettings.put(AnalyticsConstants.PREFERENCES, this.otpElfPreferences);
            injectJs("window.__rzp_options = " + oTPElfSettings.toString());
        } catch (Exception e) {
            d__1_.a("Unable to load otpelf settings", e);
        }
        injectJs(this.elfData.a());
        String str = this.lastSms;
        if (str != null) {
            injectJs(String.format("OTPElf.elfBridge.setSms(%s)", str));
            this.lastSms = null;
        }
    }

    private void injectJs(String str) {
        this.webview.loadUrl(String.format("javascript: %s", str));
    }

    private void postStatsToAPI() {
        try {
            String constructBasicAuth = BaseUtils.constructBasicAuth(this.merchantKey);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", "Basic " + constructBasicAuth);
            hashMap.put("Content-Type", "application/json");
            if (this.paymentId != null) {
                JSONObject a2 = B$$W$.a(this.otpRead);
                a2.toString();
                T__j$.a(BaseConstants.RZP_PAYMENTS_ENDPOINT + this.paymentId + "/metadata", a2.toString(), hashMap, new C__D$(this));
            }
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
        }
    }

    private void setup() {
        N$$J$ a2 = N$$J$.a();
        this.smsAgent = a2;
        a2.f681a.add(this);
        N$$J$ n$$j$ = this.smsAgent;
        Activity activity2 = this.activity;
        if (q5.a(activity2, "android.permission.RECEIVE_SMS") == 0) {
            n$$j$.a(true);
            n$$j$.a(activity2);
            AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_ALREADY_GRANTED);
        } else {
            AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_ALREADY_NOT_GRANTED);
        }
        this.webview.addJavascriptInterface(this, "OTPElfBridge");
        this.webview.getSettings().setUseWideViewPort(true);
    }

    @JavascriptInterface
    public final void copyToClipboard(String str) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("rzp_clip_data", str));
    }

    public final void enableMagic() {
        this.isMagic = true;
    }

    public final String getCurrentLoadingUrl() {
        return this.currentLoadingUrl;
    }

    public final String getLastLoadedUrl() {
        return this.lastURL;
    }

    public final boolean isRazorpayOtpReceived() {
        return this.isRazorpayOtpReceived;
    }

    @JavascriptInterface
    public final void onOtpParsed(String str) {
        this.activity.runOnUiThread(new U$_z$(this, str));
    }

    public final void onPageFinished(WebView webView, String str) {
        AnalyticsUtil.trackPageLoadEnd(str, System.nanoTime() - this.pageStartTime);
        this.lastURL = str;
        this.currentLoadingUrl = "";
        if (g__v_.a().isOTPElfEnabled().booleanValue() && !this.jsInsertedInCurrentPage) {
            handleJsInsertion();
            this.jsInsertedInCurrentPage = true;
        }
    }

    public final void onPageStarted(WebView webView, String str) {
        AnalyticsUtil.trackPageLoadStart(str);
        this.pageStartTime = System.nanoTime();
        this.currentLoadingUrl = str;
        this.jsInsertedInCurrentPage = false;
    }

    public final void onProgressChanged(int i) {
        if (!g__v_.a().isOTPElfEnabled().booleanValue()) {
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        N$$J$ n$$j$ = this.smsAgent;
        Activity activity2 = this.activity;
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                n$$j$.a(false);
                AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_NOW_DENIED);
                return;
            }
            n$$j$.a(true);
            n$$j$.a(activity2);
            AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_NOW_GRANTED);
        }
    }

    @JavascriptInterface
    public final void openKeyboard() {
        this.activity.runOnUiThread(new t_$J_(this));
    }

    public final void paymentFlowEnd() {
        if (this.sdkType.equals("standalone")) {
            AnalyticsUtil.postData();
        }
        if (g__v_.a().isOTPElfEnabled().booleanValue()) {
            this.smsAgent.b(this.activity);
            try {
                this.smsAgent.f681a.remove(this);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.razorpay.SmsAgentInterface
    public final void postSms(String str, String str2) {
        if (this.isRzpAssistEnabled) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AnalyticsConstants.SENDER, str);
                jSONObject.put("message", str2);
                String jSONObject2 = jSONObject.toString();
                this.lastSms = jSONObject2;
                injectJs(String.format("OTPElf.elfBridge.setSms(%s)", jSONObject2));
            } catch (Exception e) {
                d__1_.a("Exception", e);
            }
        }
    }

    public final void reset() {
        postStatsToAPI();
        this.lastURL = "";
        this.currentLoadingUrl = "";
        this.otpRead = false;
    }

    public final void setOTPEnabled(boolean z) {
        this.hasOtpPermission = z;
        AnalyticsUtil.addProperty("otp_autoreading_access", new AnalyticsProperty(z, AnalyticsProperty.Scope.ORDER));
    }

    public final void setOtpElfPreferences(JSONObject jSONObject) {
        this.otpElfPreferences = jSONObject;
    }

    public final void setPaymentData(JSONObject jSONObject) {
        this.paymentData = jSONObject;
    }

    public final void setPaymentId(String str) {
        this.paymentId = str;
    }

    public final void setRzpAssistEnabled(boolean z) {
        this.isRzpAssistEnabled = z;
    }

    @Override // com.razorpay.SmsAgentInterface
    public final void setSmsPermission(boolean z) {
        setOTPEnabled(z);
    }

    @JavascriptInterface
    public final void setUseWideViewPort(boolean z) {
        this.activity.runOnUiThread(new Q__v$(this, z));
    }

    @JavascriptInterface
    public final void toast(String str) {
        this.activity.runOnUiThread(new y$_O_(this, str));
    }

    @JavascriptInterface
    public final void trackEvent(String str, String str2) {
        try {
            AnalyticsEvent analyticsEvent = AnalyticsEvent.JS_EVENT;
            analyticsEvent.setEventName(str);
            AnalyticsUtil.trackEvent(analyticsEvent, new JSONObject(str2));
        } catch (Exception e) {
            d__1_.a("Error in tracking JS Event", e);
        }
    }

    @JavascriptInterface
    public final void trackEvent(String str) {
        AnalyticsEvent analyticsEvent = AnalyticsEvent.JS_EVENT;
        analyticsEvent.setEventName(str);
        AnalyticsUtil.trackEvent(analyticsEvent);
    }
}
