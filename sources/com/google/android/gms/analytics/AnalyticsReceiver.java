package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class AnalyticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public yd3 f602a;

    public final void onReceive(Context context, Intent intent) {
        if (this.f602a == null) {
            this.f602a = new yd3();
        }
        Object obj = yd3.f4032a;
        sd3 c = ac3.b(context).c();
        if (intent == null) {
            c.T("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        c.k("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean c2 = zd3.c(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (yd3.f4032a) {
                context.startService(intent2);
                if (c2) {
                    try {
                        if (yd3.b == null) {
                            oi4 oi4 = new oi4(context, 1, "Analytics WakeLock");
                            yd3.b = oi4;
                            oi4.b.setReferenceCounted(false);
                            oi4.g = false;
                        }
                        yd3.b.a(1000);
                    } catch (SecurityException unused) {
                        c.T("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
