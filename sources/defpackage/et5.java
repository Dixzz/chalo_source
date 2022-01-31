package defpackage;

import android.webkit.WebView;
import com.rabbitmq.client.StringRpcServer;
import com.urbanairship.iam.view.MediaView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* renamed from: et5  reason: default package */
/* compiled from: MediaView */
public class et5 implements Runnable {
    public final /* synthetic */ WeakReference f;
    public final /* synthetic */ vr5 g;

    public et5(MediaView mediaView, WeakReference weakReference, vr5 vr5) {
        this.f = weakReference;
        this.g = vr5;
    }

    public void run() {
        WebView webView = (WebView) this.f.get();
        if (webView != null) {
            if ("video".equals(this.g.h)) {
                webView.loadData(String.format(Locale.ROOT, "<body style=\"margin:0\"><video playsinline controls height=\"100%%\" width=\"100%%\" src=\"%s\"></video></body>", this.g.f), "text/html", StringRpcServer.STRING_ENCODING);
                return;
            }
            webView.loadUrl(this.g.f);
        }
    }
}
