package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.City;
import defpackage.xt;
import java.util.List;

public class WebViewActivity extends wt {
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public k00 p;
    public ProgressBar q;

    public class a extends WebChromeClient {
        public a() {
        }

        public void onProgressChanged(WebView webView, int i) {
            WebViewActivity.this.q.setProgress(i);
            if (i == 100) {
                WebViewActivity.this.q.setVisibility(8);
            }
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebViewActivity.this.q.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return false;
        }
    }

    public static void h0(Context context, String str, String str2, boolean z, boolean z2) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.setFlags(536870912);
        intent.putExtra("extra:url", str);
        intent.putExtra("extra:name", str2);
        intent.putExtra("extra:image_mode", z);
        intent.putExtra("extra:action_bar", z2);
        context.startActivity(intent);
    }

    public static Intent i0(Context context, String str, String str2, boolean z, boolean z2) {
        Intent N0 = hj1.N0(context, WebViewActivity.class, "extra:url", str);
        N0.putExtra("extra:name", str2);
        N0.putExtra("extra:image_mode", z);
        N0.putExtra("extra:action_bar", z2);
        return N0;
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        xt.t1 t1Var = xt.f3961a;
        this.p = t1Var.y();
        g30 g30 = new g30(getIntent());
        if (!g30.a()) {
            this.l = getIntent().getStringExtra("extra:url");
            this.m = getIntent().getStringExtra("extra:name");
            this.n = getIntent().getBooleanExtra("extra:image_mode", false);
            this.o = getIntent().getBooleanExtra("extra:action_bar", false);
        } else if ("linemap".equalsIgnoreCase(g30.c)) {
            List<City.LineMap> lineMaps = t1Var.k().d().getLineMaps();
            if (lineMaps.size() > 0) {
                this.l = lineMaps.get(0).getUrl();
                j0(g30, lineMaps.get(0).getName());
                this.n = true;
                this.o = false;
                if (g30.f1208a.containsKey("source")) {
                    this.p.a("lineMapScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
                }
            }
        } else {
            String uri = g30.d.toString();
            if (URLUtil.isHttpUrl(uri) || URLUtil.isHttpsUrl(uri)) {
                this.l = uri;
            } else {
                this.l = "http://blog.zophop.com/";
            }
            j0(g30, "blog");
            this.n = false;
            this.o = false;
            if (g30.f1208a.containsKey("source")) {
                this.p.a("blogScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
            }
        }
        setContentView(R.layout.activity_webview);
        if (this.o && getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        WebView webView = (WebView) findViewById(R.id.webview);
        this.q = (ProgressBar) findViewById(R.id.progressBar);
        if (this.n) {
            webView.loadData(hj1.a0(hj1.i0("<html><meta name=\"viewport\" content=\"width=device-width,height=device-height, user-scalable=yes\" /><body ><img id=\"resizeImage\" src=\""), this.l, "\" width=\"100%\" alt=\"\" align=\"middle\" /></body></html>"), "text/html; charset=UTF-8", null);
            ProgressBar progressBar = this.q;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } else {
            webView.loadUrl(this.l);
            webView.getSettings().setJavaScriptEnabled(true);
            k0(webView);
        }
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.setInitialScale(1);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().z(this.m);
        getWindow().setStatusBarColor(-16777216);
    }

    public final void j0(g30 g30, String str) {
        if (g30.f1208a.containsKey("name")) {
            this.m = g30.f1208a.get("name");
        } else {
            this.m = str;
        }
    }

    public void k0(WebView webView) {
        webView.setWebChromeClient(new a());
        webView.setWebViewClient(new b());
    }
}
