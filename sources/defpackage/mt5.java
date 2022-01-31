package defpackage;

import android.webkit.WebView;

/* renamed from: mt5  reason: default package */
/* compiled from: NativeBridge */
public class mt5 implements kk5<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ gz5 f2445a;

    public mt5(ot5 ot5, gz5 gz5) {
        this.f2445a = gz5;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.kk5
    public void a(String str) {
        WebView webView;
        String str2 = str;
        if (str2 != null && (webView = this.f2445a.f1321a.get()) != null) {
            webView.evaluateJavascript(str2, null);
        }
    }
}
