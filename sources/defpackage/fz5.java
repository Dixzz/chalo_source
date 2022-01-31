package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.urbanairship.R;
import com.urbanairship.UAirship;
import defpackage.lt5;
import defpackage.ot5;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* renamed from: fz5  reason: default package */
/* compiled from: AirshipWebViewClient */
public class fz5 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f1191a = new HashMap();
    public final Map<WebView, tj5> b = new WeakHashMap();
    public final ot5 c;

    /* renamed from: fz5$a */
    /* compiled from: AirshipWebViewClient */
    public class a implements uk5 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebView f1192a;

        public a(WebView webView) {
            this.f1192a = webView;
        }
    }

    /* renamed from: fz5$b */
    /* compiled from: AirshipWebViewClient */
    public class b implements ot5.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebView f1193a;

        public b(WebView webView) {
            this.f1193a = webView;
        }
    }

    /* renamed from: fz5$c */
    /* compiled from: AirshipWebViewClient */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f1194a;
        public final String b;

        public c(String str, String str2) {
            this.f1194a = str;
            this.b = str2;
        }
    }

    public fz5() {
        ot5 ot5 = new ot5(new vk5());
        this.c = ot5;
    }

    public tk5 a(tk5 tk5, WebView webView) {
        return tk5;
    }

    public lt5.b b(lt5.b bVar, WebView webView) {
        bVar.b("getDeviceModel", Build.MODEL);
        bVar.b("getChannelId", UAirship.l().j.l());
        bVar.b("getAppKey", UAirship.l().e.f711a);
        bVar.b("getNamedUser", UAirship.l().o.j());
        return bVar;
    }

    public final WebResourceResponse c(WebView webView) {
        try {
            return new WebResourceResponse("image/png", null, new BufferedInputStream(webView.getContext().getResources().openRawResource(R.raw.ua_blank_favicon)));
        } catch (Exception e) {
            yj5.e(e, "Failed to read blank favicon with IOException.", new Object[0]);
            return null;
        }
    }

    public final boolean d(WebView webView, String str) {
        if (!UAirship.l().k.d(webView.getUrl(), 1)) {
            return false;
        }
        return this.c.b(str, new gz5(webView), new a(webView), new b(webView));
    }

    public void e(WebView webView, String str, Uri uri) {
    }

    public void onLoadResource(WebView webView, String str) {
        d(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (webView != null) {
            if (!UAirship.l().k.d(str, 1)) {
                yj5.a("%s is not an allowed URL. Airship Javascript interface will not be accessible.", str);
                return;
            }
            lt5.b b2 = b(new lt5.b(null), webView);
            ot5 ot5 = this.c;
            Context context = webView.getContext();
            Objects.requireNonNull(b2);
            lt5 lt5 = new lt5(b2, null);
            gz5 gz5 = new gz5(webView);
            Objects.requireNonNull(ot5);
            yj5.f("Loading Airship Javascript interface.", new Object[0]);
            ck5 ck5 = new ck5();
            ck5.a(Looper.myLooper(), new mt5(ot5, gz5));
            ot5.f2729a.execute(new nt5(ot5, ck5, lt5, context));
            this.b.put(webView, ck5);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        tj5 tj5 = this.b.get(webView);
        if (tj5 != null) {
            tj5.cancel();
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        c cVar = this.f1191a.get(str);
        if (cVar != null) {
            httpAuthHandler.proceed(cVar.f1194a, cVar.b);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str.toLowerCase().endsWith("/favicon.ico")) {
            return c(webView);
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (d(webView, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String path;
        if (webResourceRequest.isForMainFrame() || (path = webResourceRequest.getUrl().getPath()) == null || !path.endsWith("/favicon.ico")) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return c(webView);
    }
}
