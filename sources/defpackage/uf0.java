package defpackage;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: uf0  reason: default package */
/* compiled from: SuggestNextCityActivity.kt */
public final class uf0 extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        n86.e(webView, "view");
        n86.e(str, "url");
        webView.loadUrl(str);
        return false;
    }
}
