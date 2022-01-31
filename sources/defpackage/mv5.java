package defpackage;

import android.os.Bundle;
import android.webkit.WebView;
import com.urbanairship.json.JsonValue;
import defpackage.lt5;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/* renamed from: mv5  reason: default package */
/* compiled from: MessageWebViewClient */
public class mv5 extends fz5 {
    public static SimpleDateFormat d;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
        d = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
    }

    @Override // defpackage.fz5
    public tk5 a(tk5 tk5, WebView webView) {
        Bundle bundle = new Bundle();
        wu5 f = f(webView);
        if (f != null) {
            bundle.putString("com.urbanairship.RICH_PUSH_ID_METADATA", f.j);
        }
        tk5.d = bundle;
        return tk5;
    }

    @Override // defpackage.fz5
    public lt5.b b(lt5.b bVar, WebView webView) {
        wu5 f = f(webView);
        zt5 zt5 = zt5.g;
        if (f != null) {
            zt5 = JsonValue.x(f.g).n();
        }
        super.b(bVar, webView);
        bVar.a("getMessageSentDateMS", JsonValue.x(Long.valueOf(f != null ? f.h : -1)));
        String str = null;
        bVar.b("getMessageId", f != null ? f.j : null);
        bVar.b("getMessageTitle", f != null ? f.o : null);
        if (f != null) {
            str = d.format(new Date(f.h));
        }
        bVar.b("getMessageSentDate", str);
        bVar.b("getUserId", yu5.j().g.g.b());
        bVar.a("getMessageExtras", zt5);
        return bVar;
    }

    public final wu5 f(WebView webView) {
        wu5 wu5;
        qu5 qu5 = yu5.j().g;
        String url = webView.getUrl();
        Objects.requireNonNull(qu5);
        if (url == null) {
            return null;
        }
        synchronized (qu5.y) {
            wu5 = qu5.e.get(url);
        }
        return wu5;
    }
}
