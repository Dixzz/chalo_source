package defpackage;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;

/* renamed from: mb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class mb2 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f2350a;
    public static Boolean b;

    public static synchronized boolean a(@RecentlyNonNull Context context) {
        Boolean bool;
        synchronized (mb2.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f2350a;
            if (!(context2 == null || (bool = b) == null)) {
                if (context2 == applicationContext) {
                    return bool.booleanValue();
                }
            }
            b = null;
            if (gj1.N()) {
                b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    b = Boolean.FALSE;
                }
            }
            f2350a = applicationContext;
            return b.booleanValue();
        }
    }
}
