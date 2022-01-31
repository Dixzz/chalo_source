package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: ie4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ie4 extends bc4 {
    public volatile je4 c;
    public je4 d;
    public je4 e;
    public final Map<Activity, je4> f = new ConcurrentHashMap();
    public Activity g;
    public volatile boolean h;
    public volatile je4 i;
    public je4 j;
    public boolean k;
    public final Object l = new Object();
    public String m;

    public ie4(vb4 vb4) {
        super(vb4);
    }

    public static String w(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    public static void z(je4 je4, Bundle bundle, boolean z) {
        if (je4 != null && (!bundle.containsKey("_sc") || z)) {
            String str = je4.f1911a;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            String str2 = je4.b;
            if (str2 != null) {
                bundle.putString("_sc", str2);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", je4.c);
        } else if (je4 == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(defpackage.je4 r9, defpackage.je4 r10, long r11, boolean r13, android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 369
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ie4.A(je4, je4, long, boolean, android.os.Bundle):void");
    }

    public final void B(je4 je4, boolean z, long j2) {
        b64 j3 = j();
        Objects.requireNonNull((db2) this.f3331a.n);
        j3.s(SystemClock.elapsedRealtime());
        if (q().v(je4 != null && je4.d, z, j2) && je4 != null) {
            je4.d = false;
        }
    }

    public final void C(String str, je4 je4) {
        b();
        synchronized (this) {
            String str2 = this.m;
            if (str2 == null || str2.equals(str)) {
                this.m = str;
            }
        }
    }

    public final je4 D(Activity activity) {
        Objects.requireNonNull(activity, "null reference");
        je4 je4 = this.f.get(activity);
        if (je4 == null) {
            je4 je42 = new je4(null, w(activity.getClass().getCanonicalName()), h().s0());
            this.f.put(activity, je42);
            je4 = je42;
        }
        return (this.f3331a.g.l(q64.v0) && this.i != null) ? this.i : je4;
    }

    @Override // defpackage.bc4
    public final boolean u() {
        return false;
    }

    public final je4 v(boolean z) {
        s();
        b();
        if (!this.f3331a.g.l(q64.v0) || !z) {
            return this.e;
        }
        je4 je4 = this.e;
        return je4 != null ? je4 : this.j;
    }

    public final void x(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.f3331a.g.y().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f.put(activity, new je4(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void y(Activity activity, je4 je4, boolean z) {
        je4 je42;
        je4 je43 = this.c == null ? this.d : this.c;
        if (je4.b == null) {
            je42 = new je4(je4.f1911a, activity != null ? w(activity.getClass().getCanonicalName()) : null, je4.c, je4.e, je4.f);
        } else {
            je42 = je4;
        }
        this.d = this.c;
        this.c = je42;
        Objects.requireNonNull((db2) this.f3331a.n);
        f().u(new ke4(this, je42, je43, SystemClock.elapsedRealtime(), z));
    }
}
