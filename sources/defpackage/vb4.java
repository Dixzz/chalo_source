package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: vb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class vb4 implements uc4 {
    public static volatile vb4 H;
    public volatile Boolean A;
    public Boolean B;
    public Boolean C;
    public volatile boolean D;
    public int E;
    public AtomicInteger F = new AtomicInteger(0);
    public final long G;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3627a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final hh4 f;
    public final d64 g;
    public final eb4 h;
    public final ra4 i;
    public final sb4 j;
    public final xf4 k;
    public final ug4 l;
    public final pa4 m;
    public final cb2 n;
    public final ie4 o;
    public final dd4 p;
    public final b64 q;
    public final ee4 r;
    public na4 s;
    public re4 t;
    public k64 u;
    public oa4 v;
    public nb4 w;
    public boolean x = false;
    public Boolean y;
    public long z;

    public vb4(zc4 zc4) {
        long j2;
        Context context;
        Bundle bundle;
        boolean z2 = false;
        Context context2 = zc4.f4156a;
        hh4 hh4 = new hh4();
        this.f = hh4;
        hd3.b = hh4;
        this.f3627a = context2;
        this.b = zc4.b;
        this.c = zc4.c;
        this.d = zc4.d;
        this.e = zc4.h;
        this.A = zc4.e;
        this.D = true;
        zzae zzae = zc4.g;
        if (!(zzae == null || (bundle = zzae.l) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzae.l.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        synchronized (is3.g) {
            qs3 qs3 = is3.h;
            Context applicationContext = context2.getApplicationContext();
            applicationContext = applicationContext == null ? context2 : applicationContext;
            if (qs3 == null || qs3.a() != applicationContext) {
                vr3.c();
                ps3.b();
                synchronized (zr3.class) {
                    zr3 zr3 = zr3.c;
                    if (!(zr3 == null || (context = zr3.f4204a) == null || zr3.b == null)) {
                        context.getContentResolver().unregisterContentObserver(zr3.c.b);
                    }
                    zr3.c = null;
                }
                is3.h = new sr3(applicationContext, hd3.x3(new hs3(applicationContext)));
                is3.j.incrementAndGet();
            }
        }
        this.n = db2.f817a;
        Long l2 = zc4.i;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = System.currentTimeMillis();
        }
        this.G = j2;
        this.g = new d64(this);
        eb4 eb4 = new eb4(this);
        eb4.n();
        this.h = eb4;
        ra4 ra4 = new ra4(this);
        ra4.n();
        this.i = ra4;
        ug4 ug4 = new ug4(this);
        ug4.n();
        this.l = ug4;
        pa4 pa4 = new pa4(this);
        pa4.n();
        this.m = pa4;
        this.q = new b64(this);
        ie4 ie4 = new ie4(this);
        ie4.t();
        this.o = ie4;
        dd4 dd4 = new dd4(this);
        dd4.t();
        this.p = dd4;
        xf4 xf4 = new xf4(this);
        xf4.t();
        this.k = xf4;
        ee4 ee4 = new ee4(this);
        ee4.n();
        this.r = ee4;
        sb4 sb4 = new sb4(this);
        sb4.n();
        this.j = sb4;
        zzae zzae2 = zc4.g;
        if (!(zzae2 == null || zzae2.g == 0)) {
            z2 = true;
        }
        boolean z3 = !z2;
        if (context2.getApplicationContext() instanceof Application) {
            dd4 s2 = s();
            if (s2.f3331a.f3627a.getApplicationContext() instanceof Application) {
                Application application = (Application) s2.f3331a.f3627a.getApplicationContext();
                if (s2.c == null) {
                    s2.c = new zd4(s2, null);
                }
                if (z3) {
                    application.unregisterActivityLifecycleCallbacks(s2.c);
                    application.registerActivityLifecycleCallbacks(s2.c);
                    s2.g().n.a("Registered activity lifecycle callback");
                }
            }
        } else {
            g().i.a("Application context is not an Application");
        }
        sb4.u(new xb4(this, zc4));
    }

    public static vb4 b(Context context, zzae zzae, Long l2) {
        Bundle bundle;
        if (zzae != null && (zzae.j == null || zzae.k == null)) {
            zzae = new zzae(zzae.f, zzae.g, zzae.h, zzae.i, null, null, zzae.l);
        }
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (H == null) {
            synchronized (vb4.class) {
                if (H == null) {
                    H = new vb4(new zc4(context, zzae, l2));
                }
            }
        } else if (!(zzae == null || (bundle = zzae.l) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            H.A = Boolean.valueOf(zzae.l.getBoolean("dataCollectionDefaultEnabled"));
        }
        return H;
    }

    public static void c(tc4 tc4) {
        if (tc4 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static void o(bc4 bc4) {
        if (bc4 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!bc4.b) {
            String valueOf = String.valueOf(bc4.getClass());
            throw new IllegalStateException(hj1.x(valueOf.length() + 27, "Component not initialized: ", valueOf));
        }
    }

    public static void p(sc4 sc4) {
        if (sc4 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!sc4.k()) {
            String valueOf = String.valueOf(sc4.getClass());
            throw new IllegalStateException(hj1.x(valueOf.length() + 27, "Component not initialized: ", valueOf));
        }
    }

    public final b64 A() {
        b64 b64 = this.q;
        if (b64 != null) {
            return b64;
        }
        throw new IllegalStateException("Component not created");
    }

    public final boolean B() {
        return this.A != null && this.A.booleanValue();
    }

    public final d64 a() {
        return this.g;
    }

    public final boolean d() {
        return h() == 0;
    }

    @Override // defpackage.uc4
    public final cb2 e() {
        return this.n;
    }

    @Override // defpackage.uc4
    public final sb4 f() {
        p(this.j);
        return this.j;
    }

    @Override // defpackage.uc4
    public final ra4 g() {
        p(this.i);
        return this.i;
    }

    public final int h() {
        f().b();
        if (this.g.w()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (uy3.a() && this.g.l(q64.H0) && !i()) {
            return 8;
        }
        Boolean w2 = n().w();
        if (w2 == null) {
            Boolean v2 = this.g.v("firebase_analytics_collection_enabled");
            if (v2 == null) {
                Boolean bool2 = this.B;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (p32.a("isMeasurementExplicitlyDisabled").c) {
                    return 6;
                } else {
                    if (!this.g.l(q64.S) || this.A == null || this.A.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (v2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (w2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    public final boolean i() {
        f().b();
        return this.D;
    }

    public final void j() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c1, code lost:
        if (android.text.TextUtils.isEmpty(r0.l) == false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - r6.z) > 1000) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k() {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vb4.k():boolean");
    }

    public final ee4 l() {
        p(this.r);
        return this.r;
    }

    @Override // defpackage.uc4
    public final Context m() {
        return this.f3627a;
    }

    public final eb4 n() {
        c(this.h);
        return this.h;
    }

    public final xf4 q() {
        o(this.k);
        return this.k;
    }

    @Override // defpackage.uc4
    public final hh4 r() {
        return this.f;
    }

    public final dd4 s() {
        o(this.p);
        return this.p;
    }

    public final ug4 t() {
        c(this.l);
        return this.l;
    }

    public final pa4 u() {
        c(this.m);
        return this.m;
    }

    public final boolean v() {
        return TextUtils.isEmpty(this.b);
    }

    public final ie4 w() {
        o(this.o);
        return this.o;
    }

    public final re4 x() {
        o(this.t);
        return this.t;
    }

    public final k64 y() {
        p(this.u);
        return this.u;
    }

    public final oa4 z() {
        o(this.v);
        return this.v;
    }
}
