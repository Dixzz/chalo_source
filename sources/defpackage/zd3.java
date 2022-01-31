package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import defpackage.de3;
import java.util.Objects;

/* renamed from: zd3  reason: default package */
public final class zd3<T extends Context & de3> {
    public static Boolean c;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f4160a = new ne3();
    public final T b;

    public zd3(T t) {
        this.b = t;
    }

    public static boolean c(Context context) {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                z = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        c = Boolean.valueOf(z);
        return z;
    }

    public final int a(Intent intent, int i) {
        try {
            synchronized (yd3.f4032a) {
                oi4 oi4 = yd3.b;
                if (oi4 != null && oi4.b.isHeld()) {
                    oi4.b();
                }
            }
        } catch (SecurityException unused) {
        }
        sd3 c2 = ac3.b(this.b).c();
        if (intent == null) {
            c2.T("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c2.j(2, "Local AnalyticsService called. startId, action", Integer.valueOf(i), action, null);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            b(new ae3(this, i, c2));
        }
        return 2;
    }

    public final void b(Runnable runnable) {
        sb3 e = ac3.b(this.b).e();
        ce3 ce3 = new ce3(this, runnable);
        e.g0();
        e.w().b(new vb3(e, ce3));
    }
}
