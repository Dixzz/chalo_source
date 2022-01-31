package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: pq5  reason: default package */
/* compiled from: PlayServicesUtils */
public class pq5 {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f2842a;
    public static Boolean b;

    public static boolean a() {
        if (f2842a == null) {
            try {
                Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                f2842a = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f2842a = Boolean.FALSE;
            }
        }
        return f2842a.booleanValue();
    }

    public static boolean b(Context context) {
        boolean z;
        boolean z2;
        if (b == null) {
            boolean z3 = true;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
                z = false;
            }
            if (!z) {
                try {
                    context.getPackageManager().getPackageInfo("com.google.market", 0);
                    z2 = true;
                } catch (PackageManager.NameNotFoundException unused2) {
                    z2 = false;
                }
                if (!z2) {
                    z3 = false;
                }
            }
            b = Boolean.valueOf(z3);
        }
        return b.booleanValue();
    }
}
