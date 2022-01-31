package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: g63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class g63 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1219a;
    public final String b;

    public g63(Context context, String str) {
        gj1.j(str);
        this.f1219a = str;
        try {
            byte[] a2 = ab2.a(context, str);
            if (a2 == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "single cert required: ".concat(valueOf);
                } else {
                    new String("single cert required: ");
                }
                this.b = null;
                return;
            }
            this.b = eb2.a(a2, false);
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                "no pkg: ".concat(valueOf2);
            } else {
                new String("no pkg: ");
            }
            this.b = null;
        }
    }
}
