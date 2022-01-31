package defpackage;

import android.os.Build;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.push.PushProvider;

/* renamed from: kq5  reason: default package */
/* compiled from: AirshipRuntimeConfig */
public class kq5 {

    /* renamed from: a  reason: collision with root package name */
    public final mq5 f2106a;
    public final AirshipConfigOptions b;
    public final wj5 c;

    public kq5(wj5 wj5, AirshipConfigOptions airshipConfigOptions, mq5 mq5) {
        this.c = wj5;
        this.b = airshipConfigOptions;
        this.f2106a = mq5;
    }

    public int a() {
        PushProvider pushProvider;
        wj5 wj5 = this.c;
        int i = -1;
        int c2 = wj5.f3792a.c("com.urbanairship.application.device.PLATFORM", -1);
        int i2 = c2 != 1 ? c2 != 2 ? -1 : 2 : 1;
        if (i2 != -1) {
            return i2;
        }
        if (!wj5.c.c()) {
            return -1;
        }
        jk5 jk5 = wj5.b.get();
        if (!jk5.b.isEmpty()) {
            pushProvider = jk5.b.get(0);
        } else {
            pushProvider = !jk5.f1949a.isEmpty() ? jk5.f1949a.get(0) : null;
        }
        String str = "amazon";
        if (pushProvider != null) {
            int platform = pushProvider.getPlatform();
            if (platform == 1) {
                i = 1;
            } else if (platform == 2) {
                i = 2;
            }
            Object[] objArr = new Object[2];
            if (i != 1) {
                str = i != 2 ? "unknown" : "android";
            }
            objArr[0] = str;
            objArr[1] = pushProvider;
            yj5.f("Setting platform to %s for push provider: %s", objArr);
        } else {
            if (pq5.b(wj5.d)) {
                yj5.f("Google Play Store available. Setting platform to Android.", new Object[0]);
            } else if (str.equalsIgnoreCase(Build.MANUFACTURER)) {
                yj5.f("Build.MANUFACTURER is AMAZON. Setting platform to Amazon.", new Object[0]);
                i = 1;
            } else {
                yj5.f("Defaulting platform to Android.", new Object[0]);
            }
            i = 2;
        }
        wj5.f3792a.f("com.urbanairship.application.device.PLATFORM").b(String.valueOf(i));
        return i;
    }

    public lq5 b() {
        lq5 lq5;
        nq5 nq5 = (nq5) this.f2106a;
        synchronized (nq5.c) {
            if (nq5.e == null) {
                nq5.c(sx5.a(nq5.f2596a.d("com.urbanairship.config.REMOTE_CONFIG_KEY")));
            }
            lq5 = nq5.e;
        }
        return lq5;
    }
}
