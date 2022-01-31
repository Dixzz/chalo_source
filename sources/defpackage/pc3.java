package defpackage;

import android.content.Context;

/* renamed from: pc3  reason: default package */
public final class pc3 implements Runnable {
    public final /* synthetic */ mc3 f;

    public pc3(mc3 mc3) {
        this.f = mc3;
    }

    public final void run() {
        boolean z;
        mc3 mc3 = this.f;
        mc3.g0();
        jz1.c();
        Context context = mc3.f.f146a;
        if (!yd3.a(context)) {
            mc3.T("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zd3.c(context)) {
            mc3.V("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        Boolean bool = ty1.f3421a;
        Boolean bool2 = ty1.f3421a;
        if (bool2 != null) {
            z = bool2.booleanValue();
        } else {
            z = ie3.d(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
            ty1.f3421a = Boolean.valueOf(z);
        }
        if (!z) {
            mc3.T("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        mc3.E().i0();
        if (!mc3.z0("android.permission.ACCESS_NETWORK_STATE")) {
            mc3.V("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            mc3.g0();
            jz1.c();
            mc3.r = true;
            mc3.l.i0();
            mc3.q0();
        }
        if (!mc3.z0("android.permission.INTERNET")) {
            mc3.V("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            mc3.g0();
            jz1.c();
            mc3.r = true;
            mc3.l.i0();
            mc3.q0();
        }
        if (zd3.c(mc3.f.f146a)) {
            mc3.M("AnalyticsService registered in the app manifest and enabled");
        } else {
            mc3.T("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!mc3.r && !mc3.i.j0()) {
            mc3.m0();
        }
        mc3.q0();
    }
}
