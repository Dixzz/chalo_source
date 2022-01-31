package defpackage;

import android.net.Uri;

/* renamed from: oq5  reason: default package */
/* compiled from: UrlBuilder */
public class oq5 {

    /* renamed from: a  reason: collision with root package name */
    public Uri.Builder f2724a;

    public oq5(String str) {
        if (str != null) {
            this.f2724a = Uri.parse(str).buildUpon();
        }
    }

    public oq5 a(String str) {
        Uri.Builder builder = this.f2724a;
        if (builder != null) {
            builder.appendEncodedPath(str);
        }
        return this;
    }

    public Uri b() {
        Uri.Builder builder = this.f2724a;
        if (builder == null) {
            return null;
        }
        return builder.build();
    }
}
