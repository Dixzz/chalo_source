package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import javax.annotation.Nullable;

/* renamed from: qf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class qf3 implements pf3 {
    public static qf3 c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Context f2939a;
    @Nullable
    public final ContentObserver b;

    public qf3(Context context) {
        this.f2939a = context;
        sf3 sf3 = new sf3();
        this.b = sf3;
        context.getContentResolver().registerContentObserver(hf3.f1365a, true, sf3);
    }

    public static qf3 b(Context context) {
        qf3 qf3;
        synchronized (qf3.class) {
            if (c == null) {
                c = h.q(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new qf3(context) : new qf3();
            }
            qf3 = c;
        }
        return qf3;
    }

    @Override // defpackage.pf3
    public final Object a(String str) {
        if (this.f2939a == null) {
            return null;
        }
        try {
            return (String) hd3.A3(new tf3(this, str));
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

    public qf3() {
        this.f2939a = null;
        this.b = null;
    }
}
