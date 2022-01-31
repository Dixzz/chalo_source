package defpackage;

import android.net.Uri;
import android.webkit.WebView;
import com.rabbitmq.client.ConnectionFactory;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.html.HtmlActivity;
import com.urbanairship.json.JsonValue;
import defpackage.lt5;

/* renamed from: ts5  reason: default package */
/* compiled from: HtmlWebViewClient */
public abstract class ts5 extends fz5 {
    public final InAppMessage d;

    public ts5(InAppMessage inAppMessage) {
        this.d = inAppMessage;
    }

    @Override // defpackage.fz5
    public lt5.b b(lt5.b bVar, WebView webView) {
        zt5 zt5 = this.d.g;
        super.b(bVar, webView);
        bVar.a("getMessageExtras", zt5);
        return bVar;
    }

    @Override // defpackage.fz5
    public void e(WebView webView, String str, Uri uri) {
        if (str.equals("dismiss")) {
            String encodedPath = uri.getEncodedPath();
            if (encodedPath != null) {
                String[] split = encodedPath.split(ConnectionFactory.DEFAULT_VHOST);
                if (split.length > 1) {
                    try {
                        HtmlActivity.b bVar = (HtmlActivity.b) this;
                        try {
                            xr5 d2 = xr5.d(JsonValue.p(Uri.decode(split[1])));
                            HtmlActivity htmlActivity = HtmlActivity.this;
                            int i = HtmlActivity.r;
                            DisplayHandler displayHandler = htmlActivity.h;
                            if (displayHandler != null) {
                                displayHandler.a(d2, htmlActivity.d0());
                            }
                            HtmlActivity.this.finish();
                        } catch (xt5 e) {
                            yj5.c("Unable to parse message resolution JSON", e);
                        }
                    } catch (xt5 e2) {
                        yj5.c("Unable to decode message resolution from JSON.", e2);
                    }
                } else {
                    yj5.c("Unable to decode message resolution, invalid path", new Object[0]);
                }
            } else {
                yj5.c("Unable to decode message resolution, missing path", new Object[0]);
            }
        }
    }
}
