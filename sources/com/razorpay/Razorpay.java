package com.razorpay;

import android.app.Activity;
import java.util.HashMap;
import org.json.JSONObject;

public class Razorpay extends OtpelfBaseRazorpay {
    private RzpInternalCallback rzpInternalCallback = new Q$$U_(this);

    public Razorpay(Activity activity, String str) {
        super(activity, str);
    }

    @Override // com.razorpay.BaseRazorpay
    public void openCheckout(JSONObject jSONObject, PaymentResultListener paymentResultListener) {
        this.paymentResultListener = paymentResultListener;
        this.extActiveRzpPluginInstance = null;
        super.setup(jSONObject);
        super.openCheckout(jSONObject);
    }

    @Override // com.razorpay.BaseRazorpay
    public void submit(JSONObject jSONObject, PaymentResultListener paymentResultListener) {
        this.paymentResultListener = paymentResultListener;
        submit(jSONObject);
    }

    public Razorpay(Activity activity) {
        super(activity);
    }

    @Override // com.razorpay.BaseRazorpay
    public void submit(JSONObject jSONObject, PaymentResultWithDataListener paymentResultWithDataListener) {
        this.paymentResultWithDataListener = paymentResultWithDataListener;
        submit(jSONObject);
    }

    @Override // com.razorpay.BaseRazorpay
    public void openCheckout(JSONObject jSONObject, PaymentResultWithDataListener paymentResultWithDataListener) {
        this.paymentResultWithDataListener = paymentResultWithDataListener;
        this.extActiveRzpPluginInstance = null;
        super.setup(jSONObject);
        super.openCheckout(jSONObject);
    }

    @Override // com.razorpay.BaseRazorpay
    public void submit(JSONObject jSONObject) {
        HashMap<String, String> allPluginsFromManifest = BaseUtils.getAllPluginsFromManifest(this.activity);
        if (allPluginsFromManifest == null || allPluginsFromManifest.size() == 0 || jSONObject.getString("method").equalsIgnoreCase(AnalyticsConstants.UPI) || jSONObject.has(AnalyticsConstants.UPI_APP_PACKAGE_NAME)) {
            this.isExtRzpPluginActive = false;
            this.extActiveRzpPluginInstance = null;
            super.setup(jSONObject);
            super.submit(jSONObject);
            return;
        }
        for (String str : allPluginsFromManifest.values()) {
            try {
                RzpPlugin rzpPlugin = (RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(str).newInstance();
                RzpPluginCompatibilityResponse isCompatible = rzpPlugin.isCompatible(f$_G$.f694a, f$_G$.c, f$_G$.b);
                if (!isCompatible.isCompatible()) {
                    onError(-1, isCompatible.getErrorMessage());
                    return;
                }
                rzpPlugin.isRegistered(this.activity, new I$_e_(this));
                if (rzpPlugin.doesHandlePayload(this.apiKey, jSONObject, this.activity)) {
                    this.isExtRzpPluginActive = true;
                    this.extActiveRzpPluginInstance = rzpPlugin;
                    super.setup(jSONObject);
                    String replace = "<html><head><title>Processing, Please Wait...</title><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/><meta http-equiv=\"pragma\" content=\"no-cache\"><meta http-equiv=\"cache-control\" content=\"no-cache\"><style><style> html, body { width: 100%; } #content { width: 88%; max-width: 520px; text-align: center; position: absolute; transform: translate(-50%, -50%); top: 50%; left: 50%; } #title { color: #528ff0; font-size: 22px; } #ldr { width: 100%; height: 1px; position: relative; background: #e1e1e1; } #lding { height: 3px; top: -1px; background: #528ff0; position: absolute; animation: spin 20s cubic-bezier(0,0.1,0,1) forwards; animation-delay: 10; } @-webkit-keyframes spin { 0% { width: 0; } 100% { width: 90%; } } @keyframes spin { 0% { width: 0; } 100% { width: 90%; } } #desc { font-size: 16px; color: #8a8a8a; } #content > div { margin-bottom: 20px; } form { display: none; } .hide { display: none; }</style></head><body onload=\"document.forms[0].submit()\"><div id=\"content\"> <div id=\"title\">Processing Payment</div> <div id=\"ldr\"> <div id=\"lding\"></div> </div> <div id=\"desc\">Please wait while we fetch your transaction details and process your payment</div> <img id=\"rzplogo\" style=\"width:160px;margin-top:80px\" src=\"data:image/png;base64,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\"/>{{form}}</div></body><script></script></html>".replace("{{form}}", "");
                    if (!this.mShouldDisplayLogo) {
                        replace = replace.replace("<script></script>", "<script>document.getElementById('rzplogo').className = 'hide';</script>");
                    }
                    this.webview.loadData(replace, "text/html", null);
                    rzpPlugin.processPayment(this.apiKey, jSONObject, this.activity, this.rzpInternalCallback);
                    return;
                }
            } catch (Exception e) {
                this.isExtRzpPluginActive = false;
                this.extActiveRzpPluginInstance = null;
                super.setup(jSONObject);
                super.submit(jSONObject);
                e.printStackTrace();
                AnalyticsUtil.reportError(e, "error", e.getMessage());
            }
        }
        this.extActiveRzpPluginInstance = null;
        super.setup(jSONObject);
        super.submit(jSONObject);
    }
}
