package com.urbanairship.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.urbanairship.UAirship;
import java.util.Objects;

public class EnableFeatureAction extends nk5 {

    /* renamed from: a  reason: collision with root package name */
    public final zy5 f719a;
    public final jp5<UAirship> b;

    public class a implements zy5 {
    }

    public class b implements jp5<UAirship> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.jp5
        public UAirship get() {
            return UAirship.l();
        }
    }

    public class c implements Runnable {
        public c(EnableFeatureAction enableFeatureAction) {
        }

        public void run() {
            Context d = UAirship.d();
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    d.startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", UAirship.g()).addFlags(268435456));
                    return;
                } catch (ActivityNotFoundException e) {
                    yj5.b(e, "Failed to launch notification settings.", new Object[0]);
                }
            }
            try {
                d.startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("app_package", UAirship.g()).addFlags(268435456).putExtra("app_uid", UAirship.a().uid));
            } catch (ActivityNotFoundException e2) {
                yj5.b(e2, "Failed to launch notification settings.", new Object[0]);
                Intent addFlags = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").addCategory("android.intent.category.DEFAULT").addFlags(268435456);
                StringBuilder i0 = hj1.i0("package:");
                i0.append(UAirship.g());
                try {
                    d.startActivity(addFlags.setData(Uri.parse(i0.toString())));
                } catch (ActivityNotFoundException e3) {
                    yj5.e(e3, "Unable to launch settings activity.", new Object[0]);
                }
            }
        }
    }

    public EnableFeatureAction() {
        a aVar = new a();
        b bVar = new b();
        this.f719a = aVar;
        this.b = bVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r6.equals(com.google.firebase.analytics.FirebaseAnalytics.Param.LOCATION) == false) goto L_0x0024;
     */
    @Override // defpackage.nk5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(defpackage.ok5 r6) {
        /*
            r5 = this;
            int r0 = r6.f2706a
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x0012
            r3 = 6
            if (r0 == r3) goto L_0x0012
            if (r0 == r1) goto L_0x0012
            r3 = 3
            if (r0 == r3) goto L_0x0012
            r3 = 4
            if (r0 == r3) goto L_0x0012
            return r2
        L_0x0012:
            com.urbanairship.actions.ActionValue r6 = r6.b
            java.lang.String r6 = r6.d()
            if (r6 != 0) goto L_0x001b
            return r2
        L_0x001b:
            r0 = -1
            int r3 = r6.hashCode()
            r4 = 1
            switch(r3) {
                case 845239156: goto L_0x003a;
                case 954101670: goto L_0x002f;
                case 1901043637: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            r1 = -1
            goto L_0x0044
        L_0x0026:
            java.lang.String r3 = "location"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0044
            goto L_0x0024
        L_0x002f:
            java.lang.String r1 = "background_location"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0038
            goto L_0x0024
        L_0x0038:
            r1 = 1
            goto L_0x0044
        L_0x003a:
            java.lang.String r1 = "user_notifications"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0043
            goto L_0x0024
        L_0x0043:
            r1 = 0
        L_0x0044:
            switch(r1) {
                case 0: goto L_0x0048;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                default: goto L_0x0047;
            }
        L_0x0047:
            return r2
        L_0x0048:
            return r4
            switch-data {845239156->0x003a, 954101670->0x002f, 1901043637->0x0026, }
            switch-data {0->0x0048, 1->0x0048, 2->0x0048, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.actions.EnableFeatureAction.a(ok5):boolean");
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        String d = ok5.b.d();
        hd3.E(d, "Missing feature.");
        Objects.requireNonNull(this.b.get());
        ik5 ik5 = this.b.get().s;
        char c2 = 65535;
        switch (d.hashCode()) {
            case 845239156:
                if (d.equals("user_notifications")) {
                    c2 = 0;
                    break;
                }
                break;
            case 954101670:
                if (d.equals("background_location")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1901043637:
                if (d.equals(FirebaseAnalytics.Param.LOCATION)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                vv5 vv5 = this.b.get().i;
                vv5.k.f("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED").b(String.valueOf(true));
                vv5.v.s();
                int i = ik5.d;
                ik5.f(ik5.a(4) | i);
                if (!new l5(UAirship.d()).a()) {
                    new Handler(Looper.getMainLooper()).post(new c(this));
                }
                return rk5.d(ActionValue.e(true));
            case 1:
                return rk5.a();
            case 2:
                return rk5.a();
            default:
                return rk5.d(ActionValue.e(false));
        }
    }
}
