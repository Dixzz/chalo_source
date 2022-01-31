package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Objects;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* renamed from: bc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class bc2 {

    /* renamed from: a  reason: collision with root package name */
    public static final zb2 f410a = new vb2(xb2.L("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));
    public static final zb2 b = new wb2(xb2.L("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));
    public static volatile z92 c;
    public static final Object d = new Object();
    public static Context e;

    static {
        new tb2(xb2.L("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
        new ub2(xb2.L("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    }

    public static void a() throws DynamiteModule.a {
        z92 z92;
        if (c == null) {
            Objects.requireNonNull(e, "null reference");
            synchronized (d) {
                try {
                    if (c == null) {
                        IBinder b2 = DynamiteModule.c(e, DynamiteModule.d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                        int i = y92.f;
                        if (b2 == null) {
                            z92 = null;
                        } else {
                            IInterface queryLocalInterface = b2.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                            if (queryLocalInterface instanceof z92) {
                                z92 = (z92) queryLocalInterface;
                            } else {
                                z92 = new x92(b2);
                            }
                        }
                        c = z92;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static gc2 b(String str, xb2 xb2, boolean z, boolean z2) {
        String str2;
        try {
            a();
            Objects.requireNonNull(e, "null reference");
            try {
                if (c.P1(new zzs(str, xb2, z, z2), new kc2(e.getPackageManager()))) {
                    return gc2.d;
                }
                return new fc2(new sb2(z, str, xb2));
            } catch (RemoteException e2) {
                return gc2.c("module call", e2);
            }
        } catch (DynamiteModule.a e3) {
            String valueOf = String.valueOf(e3.getMessage());
            if (valueOf.length() != 0) {
                str2 = "module init: ".concat(valueOf);
            } else {
                str2 = new String("module init: ");
            }
            return gc2.c(str2, e3);
        }
    }
}
