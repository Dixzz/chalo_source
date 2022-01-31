package com.razorpay;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RazorpayWebViewClient extends WebViewClient {
    private BaseRazorpay razorpay;

    public RazorpayWebViewClient(BaseRazorpay baseRazorpay) {
        this.razorpay = baseRazorpay;
    }

    public void onPageFinished(WebView webView, String str) {
        this.razorpay.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.razorpay.onPageStarted(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.razorpay.onError(2, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
