package com.urbanairship.iam.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class MediaView extends FrameLayout {
    public WebView f;
    public WebChromeClient g;

    public static abstract class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f732a;
        public boolean b = false;
        public long c = 1000;

        public a(Runnable runnable, et5 et5) {
            this.f732a = runnable;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.b) {
                webView.postDelayed(this.f732a, this.c);
                this.c *= 2;
            } else {
                webView.setVisibility(0);
                ((ft5) this).d.setVisibility(8);
            }
            this.b = false;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            this.b = true;
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void setChromeClient(WebChromeClient webChromeClient) {
        this.g = webChromeClient;
        WebView webView = this.f;
        if (webView != null) {
            webView.setWebChromeClient(webChromeClient);
        }
    }
}
