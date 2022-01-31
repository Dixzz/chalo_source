package com.razorpay;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class RazorpayWebChromeClient extends WebChromeClient {
    private BaseRazorpay razorpay;

    public RazorpayWebChromeClient(BaseRazorpay baseRazorpay) {
        this.razorpay = baseRazorpay;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.razorpay.onProgressChanged(webView, i);
    }
}
