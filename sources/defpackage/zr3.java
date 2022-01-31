package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import javax.annotation.Nullable;

/* renamed from: zr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zr3 implements yr3 {
    public static zr3 c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Context f4204a;
    @Nullable
    public final ContentObserver b;

    public zr3(Context context) {
        this.f4204a = context;
        cs3 cs3 = new cs3();
        this.b = cs3;
        context.getContentResolver().registerContentObserver(rr3.f3121a, true, cs3);
    }

    public static zr3 a(Context context) {
        zr3 zr3;
        synchronized (zr3.class) {
            if (c == null) {
                c = h.q(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zr3(context) : new zr3();
            }
            zr3 = c;
        }
        return zr3;
    }

    @Override // defpackage.yr3
    public final Object zza(String str) {
        if (this.f4204a == null) {
            return null;
        }
        try {
            return (String) hd3.B3(new ds3(this, str));
        } catch (IllegalStateException | SecurityException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Unable to read GServices for: ".concat(valueOf);
                return null;
            }
            new String("Unable to read GServices for: ");
            return null;
        }
    }

    public zr3() {
        this.f4204a = null;
        this.b = null;
    }
}
