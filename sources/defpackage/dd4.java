package defpackage;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: dd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class dd4 extends bc4 {
    public zd4 c;
    public xc4 d;
    public final Set<ad4> e = new CopyOnWriteArraySet();
    public boolean f;
    public final AtomicReference<String> g = new AtomicReference<>();
    public final Object h = new Object();
    public e64 i = new e64(null, null);
    public int j = 100;
    public final AtomicLong k = new AtomicLong(0);
    public long l = -1;
    public int m = 100;
    public final zg4 n;
    public boolean o = true;
    public final wg4 p = new rd4(this);

    public dd4(vb4 vb4) {
        super(vb4);
        this.n = new zg4(vb4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void B(defpackage.dd4 r4, defpackage.e64 r5, int r6, long r7, boolean r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd4.B(dd4, e64, int, long, boolean, boolean):void");
    }

    public final void A(xc4 xc4) {
        xc4 xc42;
        b();
        s();
        if (!(xc4 == null || xc4 == (xc42 = this.d))) {
            gj1.o(xc42 == null, "EventInterceptor already set.");
        }
        this.d = xc4;
    }

    public final void C(Boolean bool, boolean z) {
        b();
        s();
        g().m.b("Setting app measurement enabled (FE)", bool);
        i().q(bool);
        if (uy3.a() && this.f3331a.g.l(q64.H0) && z) {
            eb4 i2 = i();
            Objects.requireNonNull(i2);
            if (uy3.a() && i2.f3331a.g.l(q64.H0)) {
                i2.b();
                SharedPreferences.Editor edit = i2.v().edit();
                if (bool != null) {
                    edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    edit.remove("measurement_enabled_from_api");
                }
                edit.apply();
            }
        }
        if (!uy3.a() || !this.f3331a.g.l(q64.H0) || this.f3331a.i() || !bool.booleanValue()) {
            O();
        }
    }

    public final void D(String str, String str2, long j2, Bundle bundle) {
        b();
        E(str, str2, j2, bundle, true, this.d == null || ug4.q0(str2), false, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(java.lang.String r29, java.lang.String r30, long r31, android.os.Bundle r33, boolean r34, boolean r35, boolean r36, java.lang.String r37) {
        /*
        // Method dump skipped, instructions count: 1352
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd4.E(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void F(String str, String str2, long j2, Object obj) {
        f().u(new kd4(this, str, str2, obj, j2));
    }

    public final void G(String str, String str2, Bundle bundle) {
        Objects.requireNonNull((db2) this.f3331a.n);
        H(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        r2 = r1.g().n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        if (r13 != null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0101, code lost:
        r4 = com.razorpay.AnalyticsConstants.NULL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0104, code lost:
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0105, code lost:
        if (r14 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0107, code lost:
        r5 = com.razorpay.AnalyticsConstants.NULL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010a, code lost:
        r5 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010b, code lost:
        r2.c("Logging screen view with name, class", r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0110, code lost:
        if (r1.c != null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0112, code lost:
        r2 = r1.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0115, code lost:
        r2 = r1.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0117, code lost:
        r3 = new defpackage.je4(r13, r14, r1.h().s0(), true, r26);
        r1.c = r3;
        r1.d = r2;
        r1.i = r3;
        java.util.Objects.requireNonNull((defpackage.db2) r1.f3331a.n);
        r1.f().u(new defpackage.le4(r1, r0, r3, r2, android.os.SystemClock.elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25, long r26) {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd4.H(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void I(String str, String str2, Object obj) {
        Objects.requireNonNull((db2) this.f3331a.n);
        K(str, str2, obj, true, System.currentTimeMillis());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void J(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd4.J(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void K(String str, String str2, Object obj, boolean z, long j2) {
        int i2;
        int i3;
        if (str == null) {
            str = SettingsJsonConstants.APP_KEY;
        }
        if (z) {
            i2 = h().g0(str2);
        } else {
            ug4 h2 = h();
            if (h2.Z("user property", str2)) {
                if (!h2.e0("user property", yc4.f4031a, null, str2)) {
                    i2 = 15;
                } else if (h2.Y("user property", 24, str2)) {
                    i2 = 0;
                }
            }
            i2 = 6;
        }
        if (i2 != 0) {
            h();
            this.f3331a.t().Q(this.p, i2, "_ev", ug4.D(str2, 24, true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int h0 = h().h0(str2, obj);
            if (h0 != 0) {
                h();
                String D = ug4.D(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i3 = String.valueOf(obj).length();
                } else {
                    i3 = 0;
                }
                this.f3331a.t().Q(this.p, h0, "_ev", D, i3);
                return;
            }
            Object m0 = h().m0(str2, obj);
            if (m0 != null) {
                F(str, str2, j2, m0);
            }
        } else {
            F(str, str2, j2, null);
        }
    }

    public final void L() {
        if (this.f3331a.f3627a.getApplicationContext() instanceof Application) {
            ((Application) this.f3331a.f3627a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.c);
        }
    }

    public final void M() {
        b();
        s();
        if (this.f3331a.k()) {
            if (this.f3331a.g.l(q64.d0)) {
                Boolean v = this.f3331a.g.v("google_analytics_deferred_deep_link_enabled");
                if (v != null && v.booleanValue()) {
                    g().m.a("Deferred Deep Link feature enabled.");
                    f().u(new fd4(this));
                }
            }
            re4 n2 = n();
            n2.b();
            n2.s();
            zzn H = n2.H(true);
            n2.p().w(3, new byte[0]);
            n2.y(new ye4(n2, H));
            this.o = false;
            eb4 i2 = i();
            i2.b();
            String string = i2.v().getString("previous_os_version", null);
            i2.c().l();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = i2.v().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                c().l();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    G("auto", "_ou", bundle);
                }
            }
        }
    }

    public final String N() {
        vb4 vb4 = this.f3331a;
        String str = vb4.b;
        if (str != null) {
            return str;
        }
        try {
            return hd3.D3(vb4.f3627a, "google_app_id");
        } catch (IllegalStateException e2) {
            this.f3331a.g().f.b("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    public final void O() {
        b();
        String a2 = i().s.a();
        if (a2 != null) {
            if ("unset".equals(a2)) {
                Objects.requireNonNull((db2) this.f3331a.n);
                J(SettingsJsonConstants.APP_KEY, "_npa", null, System.currentTimeMillis());
            } else {
                Long valueOf = Long.valueOf("true".equals(a2) ? 1 : 0);
                Objects.requireNonNull((db2) this.f3331a.n);
                J(SettingsJsonConstants.APP_KEY, "_npa", valueOf, System.currentTimeMillis());
            }
        }
        boolean z = true;
        if (!this.f3331a.d() || !this.o) {
            g().m.a("Updating Scion state (FE)");
            re4 n2 = n();
            n2.b();
            n2.s();
            n2.y(new cf4(n2, n2.H(true)));
            return;
        }
        g().m.a("Recording app launch after enabling measurement for the first time (FE)");
        M();
        if (sz3.a() && this.f3331a.g.l(q64.q0)) {
            q().d.a();
        }
        if (((kz3) hz3.g.zza()).zza() && this.f3331a.g.l(q64.t0)) {
            if (this.f3331a.w.f2532a.n().k.a() <= 0) {
                z = false;
            }
            if (!z) {
                nb4 nb4 = this.f3331a.w;
                nb4.a(nb4.f2532a.f3627a.getPackageName());
            }
        }
        if (this.f3331a.g.l(q64.D0)) {
            f().u(new gd4(this));
        }
    }

    public final void P(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        f().u(new ld4(this, str, str2, j2, bundle2, z, z2, z3, null));
    }

    public final void Q(String str, String str2, Bundle bundle) {
        Objects.requireNonNull((db2) this.f3331a.n);
        long currentTimeMillis = System.currentTimeMillis();
        gj1.j(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        f().u(new qd4(this, bundle2));
    }

    @Override // defpackage.bc4
    public final boolean u() {
        return false;
    }

    public final void v(long j2, boolean z) {
        b();
        s();
        g().m.a("Resetting analytics data (FE)");
        xf4 q = q();
        q.b();
        eg4 eg4 = q.e;
        eg4.c.c();
        eg4.f969a = 0;
        eg4.b = 0;
        boolean d2 = this.f3331a.d();
        eb4 i2 = i();
        i2.j.b(j2);
        if (!TextUtils.isEmpty(i2.i().z.a())) {
            i2.z.b(null);
        }
        if (sz3.a() && i2.f3331a.g.l(q64.q0)) {
            i2.u.b(0);
        }
        if (!i2.f3331a.g.w()) {
            i2.u(!d2);
        }
        i2.A.b(null);
        i2.B.b(0);
        i2.C.b(null);
        if (z) {
            re4 n2 = n();
            n2.b();
            n2.s();
            zzn H = n2.H(false);
            n2.p().x();
            n2.y(new ue4(n2, H));
        }
        if (sz3.a() && this.f3331a.g.l(q64.q0)) {
            q().d.a();
        }
        this.o = !d2;
    }

    public final void w(Bundle bundle, int i2, long j2) {
        if (uy3.a() && this.f3331a.g.l(q64.H0)) {
            s();
            String string = bundle.getString("ad_storage");
            if ((string == null || e64.i(string) != null) && ((string = bundle.getString("analytics_storage")) == null || e64.i(string) != null)) {
                string = null;
            }
            if (string != null) {
                g().k.b("Ignoring invalid consent setting", string);
                g().k.a("Valid consent values are 'granted', 'denied'");
            }
            z(e64.g(bundle), i2, j2);
        }
    }

    public final void x(Bundle bundle, long j2) {
        Objects.requireNonNull(bundle, "null reference");
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            g().i.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        hd3.z3(bundle2, "app_id", String.class, null);
        hd3.z3(bundle2, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        hd3.z3(bundle2, "name", String.class, null);
        hd3.z3(bundle2, FirebaseAnalytics.Param.VALUE, Object.class, null);
        hd3.z3(bundle2, "trigger_event_name", String.class, null);
        hd3.z3(bundle2, "trigger_timeout", Long.class, 0L);
        hd3.z3(bundle2, "timed_out_event_name", String.class, null);
        hd3.z3(bundle2, "timed_out_event_params", Bundle.class, null);
        hd3.z3(bundle2, "triggered_event_name", String.class, null);
        hd3.z3(bundle2, "triggered_event_params", Bundle.class, null);
        hd3.z3(bundle2, "time_to_live", Long.class, 0L);
        hd3.z3(bundle2, "expired_event_name", String.class, null);
        hd3.z3(bundle2, "expired_event_params", Bundle.class, null);
        gj1.j(bundle2.getString("name"));
        gj1.j(bundle2.getString(FirebaseAnalytics.Param.ORIGIN));
        Objects.requireNonNull(bundle2.get(FirebaseAnalytics.Param.VALUE), "null reference");
        bundle2.putLong("creation_timestamp", j2);
        String string = bundle2.getString("name");
        Object obj = bundle2.get(FirebaseAnalytics.Param.VALUE);
        if (h().g0(string) != 0) {
            g().f.b("Invalid conditional user property name", d().x(string));
        } else if (h().h0(string, obj) != 0) {
            g().f.c("Invalid conditional user property value", d().x(string), obj);
        } else {
            Object m0 = h().m0(string, obj);
            if (m0 == null) {
                g().f.c("Unable to normalize conditional user property value", d().x(string), obj);
                return;
            }
            hd3.L3(bundle2, m0);
            long j3 = bundle2.getLong("trigger_timeout");
            if (TextUtils.isEmpty(bundle2.getString("trigger_event_name")) || (j3 <= 15552000000L && j3 >= 1)) {
                long j4 = bundle2.getLong("time_to_live");
                if (j4 > 15552000000L || j4 < 1) {
                    g().f.c("Invalid conditional user property time to live", d().x(string), Long.valueOf(j4));
                } else {
                    f().u(new od4(this, bundle2));
                }
            } else {
                g().f.c("Invalid conditional user property timeout", d().x(string), Long.valueOf(j3));
            }
        }
    }

    public final void y(e64 e64) {
        Boolean bool;
        b();
        boolean z = (e64.k() && e64.j()) || n().D();
        if (z != this.f3331a.i()) {
            vb4 vb4 = this.f3331a;
            vb4.f().b();
            vb4.D = z;
            eb4 i2 = i();
            Objects.requireNonNull(i2);
            if (uy3.a() && i2.f3331a.g.l(q64.H0)) {
                i2.b();
                if (i2.v().contains("measurement_enabled_from_api")) {
                    bool = Boolean.valueOf(i2.v().getBoolean("measurement_enabled_from_api", true));
                    if (z || bool == null || bool.booleanValue()) {
                        C(Boolean.valueOf(z), false);
                    }
                    return;
                }
            }
            bool = null;
            if (z) {
            }
            C(Boolean.valueOf(z), false);
        }
    }

    public final void z(e64 e64, int i2, long j2) {
        boolean z;
        boolean z2;
        e64 e642;
        boolean z3;
        if (uy3.a() && this.f3331a.g.l(q64.H0)) {
            s();
            if ((!this.f3331a.g.l(q64.I0) || i2 != 20) && e64.f931a == null && e64.b == null) {
                g().k.a("Discarding empty consent settings");
                return;
            }
            synchronized (this.h) {
                z = false;
                if (e64.e(i2, this.j)) {
                    z3 = e64.f(this.i);
                    if (e64.k() && !this.i.k()) {
                        z = true;
                    }
                    e64 e643 = this.i;
                    Boolean bool = e64.f931a;
                    if (bool == null) {
                        bool = e643.f931a;
                    }
                    Boolean bool2 = e64.b;
                    if (bool2 == null) {
                        bool2 = e643.b;
                    }
                    e64 e644 = new e64(bool, bool2);
                    this.i = e644;
                    this.j = i2;
                    z2 = z;
                    e642 = e644;
                    z = true;
                } else {
                    e642 = e64;
                    z2 = false;
                    z3 = false;
                }
            }
            if (!z) {
                g().l.b("Ignoring lower-priority consent settings, proposed settings", e642);
                return;
            }
            long andIncrement = this.k.getAndIncrement();
            if (z3) {
                this.g.set(null);
                f().v(new yd4(this, e642, j2, i2, andIncrement, z2));
            } else if (!this.f3331a.g.l(q64.I0) || !(i2 == 40 || i2 == 20)) {
                f().u(new ae4(this, e642, i2, andIncrement, z2));
            } else {
                f().v(new xd4(this, e642, i2, andIncrement, z2));
            }
        }
    }
}
