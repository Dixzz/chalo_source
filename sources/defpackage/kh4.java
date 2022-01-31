package defpackage;

import android.net.Uri;
import defpackage.x22;

/* renamed from: kh4  reason: default package */
public final class kh4 {

    /* renamed from: a  reason: collision with root package name */
    public static final x22.g<m24> f2060a;
    public static final x22.a<m24, x22.d.c> b;

    static {
        x22.g<m24> gVar = new x22.g<>();
        f2060a = gVar;
        mh4 mh4 = new mh4();
        b = mh4;
        gj1.l(mh4, "Cannot construct an Api with a null ClientBuilder");
        gj1.l(gVar, "Cannot construct an Api with a null ClientKey");
    }

    public static Uri a(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
