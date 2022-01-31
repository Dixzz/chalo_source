package com.urbanairship.webkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.urbanairship.R;
import com.urbanairship.UAirship;
import java.io.File;
import java.util.Map;

public class AirshipWebView extends WebView {
    public WebViewClient f;
    public String g;

    public AirshipWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842885);
        if (!isInEditMode()) {
            WebSettings settings = getSettings();
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(getCachePath());
            settings.setDomStorageEnabled(true);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AirshipWebView, 16842885, 0);
                try {
                    settings.setMixedContentMode(obtainStyledAttributes.getInteger(R.styleable.AirshipWebView_mixed_content_mode, 2));
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
            settings.setAllowFileAccess(true);
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            if (hd3.P2()) {
                yj5.h("Application contains metadata to enable local storage", new Object[0]);
                settings.setDomStorageEnabled(true);
                settings.setDatabaseEnabled(true);
            }
        }
    }

    private String getCachePath() {
        File file = new File(UAirship.d().getCacheDir(), "urbanairship");
        if (!file.exists() && !file.mkdirs()) {
            yj5.c("Failed to create the web cache directory.", new Object[0]);
        }
        return file.getAbsolutePath();
    }

    @SuppressLint({"NewApi"})
    public void a() {
        if (getWebViewClientCompat() == null) {
            yj5.a("No web view client set, setting a default AirshipWebViewClient for landing page view.", new Object[0]);
            setWebViewClient(new fz5());
        }
        if (this.g != null && getWebViewClientCompat() != null && (getWebViewClientCompat() instanceof fz5)) {
            ((fz5) getWebViewClientCompat()).f1191a.remove(this.g);
            this.g = null;
        }
    }

    public WebViewClient getWebViewClientCompat() {
        return this.f;
    }

    public void loadData(String str, String str2, String str3) {
        a();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        a();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        a();
        super.loadUrl(str);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null && !(webViewClient instanceof fz5)) {
            yj5.i("The web view client should extend AirshipWebViewClient to support Airship url overrides and triggering actions from.", new Object[0]);
        }
        this.f = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        a();
        super.loadUrl(str, map);
    }
}
