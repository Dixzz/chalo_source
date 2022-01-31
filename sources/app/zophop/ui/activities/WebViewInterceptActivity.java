package app.zophop.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import app.zophop.R;

public class WebViewInterceptActivity extends WebViewActivity {
    public static Context s;
    public String r;

    public class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f307a;

        public a(Context context) {
            this.f307a = context;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = WebViewInterceptActivity.this.r;
            if (str2 == null || !str.startsWith(str2)) {
                Toast.makeText(this.f307a, WebViewInterceptActivity.this.getString(R.string.cab_please_wait_loading), 1).show();
                webView.loadUrl(str);
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("webview_result", str);
            WebViewInterceptActivity.this.setResult(-1, intent);
            WebViewInterceptActivity.this.finish();
            return true;
        }
    }

    public static void l0(Context context, String str, String str2, boolean z, boolean z2, String str3, int i) {
        Activity activity;
        Intent N0 = hj1.N0(context, WebViewInterceptActivity.class, "extra:url", str);
        N0.putExtra("extra:name", str2);
        N0.putExtra("extra:image_mode", z);
        N0.putExtra("extra:action_bar", z2);
        N0.putExtra("intercepted_uri", str3);
        s = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else if (context instanceof Activity) {
                activity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        activity.startActivityForResult(N0, i);
    }

    @Override // app.zophop.ui.activities.WebViewActivity, defpackage.tf1
    public void e(Bundle bundle) {
        super.e(bundle);
        this.r = getIntent().getStringExtra("intercepted_uri");
        getIntent().getStringExtra("extra:provider");
    }

    @Override // app.zophop.ui.activities.WebViewActivity
    public void k0(WebView webView) {
        webView.setWebViewClient(new a(this));
    }
}
