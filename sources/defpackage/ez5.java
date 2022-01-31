package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* renamed from: ez5  reason: default package */
/* compiled from: AirshipWebChromeClient */
public class ez5 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Activity> f1049a;
    public View b;

    /* renamed from: ez5$a */
    /* compiled from: AirshipWebChromeClient */
    public class a extends WebViewClient {
        public a(ez5 ez5) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", qy5.f(str));
            intent.addFlags(268435456);
            webView.getContext().startActivity(intent);
            return true;
        }
    }

    public ez5(Activity activity) {
        this.f1049a = new WeakReference<>(activity);
    }

    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(new int[]{0}, 1, 1, Bitmap.Config.ARGB_8888);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (!z2 || message == null || !(message.obj instanceof WebView.WebViewTransport)) {
            return false;
        }
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(new a(this));
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public void onHideCustomView() {
        Activity activity = this.f1049a.get();
        if (activity != null && this.b != null) {
            activity.getWindow().clearFlags(1024);
            ((ViewGroup) this.b.getParent()).removeView(this.b);
            this.b = null;
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.f1049a.get();
        if (activity != null) {
            View view2 = this.b;
            if (view2 != null) {
                ((ViewGroup) view2.getParent()).removeView(this.b);
            }
            this.b = view;
            view.setBackgroundColor(-16777216);
            activity.getWindow().setFlags(1024, 1024);
            activity.getWindow().addContentView(this.b, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }
}
