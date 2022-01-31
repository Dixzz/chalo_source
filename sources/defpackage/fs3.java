package defpackage;

import android.net.Uri;

/* renamed from: fs3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class fs3 {

    /* renamed from: a  reason: collision with root package name */
    public static final n2<String, Uri> f1167a = new n2<>();

    public static synchronized Uri a(String str) {
        Uri orDefault;
        synchronized (fs3.class) {
            n2<String, Uri> n2Var = f1167a;
            orDefault = n2Var.getOrDefault(str, null);
            if (orDefault == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                orDefault = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                n2Var.put(str, orDefault);
            }
        }
        return orDefault;
    }
}
