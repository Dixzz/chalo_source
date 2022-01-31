package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import app.zophop.models.City;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.ReportProblemImpl;
import app.zophop.room.DigitalTripReceiptRepository;
import app.zophop.room.OnlineCardRechargeRepository;
import app.zophop.room.SuperPassRepository;
import com.crashlytics.android.answers.SessionEventTransform;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.TimeZone;
import org.json.JSONArray;

/* renamed from: xt  reason: default package */
/* compiled from: DependencyFactory.kt */
public final class xt {
    public static final j56<t20> A = hd3.a2(n0.f);
    public static final j56<d20> B = hd3.a2(d.f);
    public static final j56<v40> C = hd3.a2(x0.f);
    public static final j56<u00> D = hd3.a2(h.f);
    public static final j56<n10> E = hd3.a2(u.f);
    public static final j56<x50> F = hd3.a2(q1.f);
    public static final j56<y10> G = hd3.a2(x.f);
    public static final j56<z10> H = hd3.a2(y.f);
    public static final j56<f40> I = hd3.a2(q0.f);
    public static final j56<q50> J = hd3.a2(o1.f);
    public static final j56<j40> K = hd3.a2(s0.f);
    public static final j56<y30> L = hd3.a2(o0.f);
    public static final j56<e10> M = hd3.a2(l.f);
    public static final j56<c80> N = hd3.a2(s.f);
    public static final j56<z30> O = hd3.a2(p0.f);
    public static final j56<u50> P = hd3.a2(p1.f);
    public static final j56<i40> Q = hd3.a2(r0.f);
    public static final j56<s30> R = hd3.a2(k0.f);
    public static final j56<l00> S = hd3.a2(c.f);
    public static final j56<b60> T = hd3.a2(a1.f);
    public static final j56<k00> U = hd3.a2(z.f);
    public static final j56<r30> V = hd3.a2(i0.f);
    public static final j56<t00> W = hd3.a2(g.f);
    public static final j56<g50> X = hd3.a2(d1.f);
    public static final j56<o30> Y = hd3.a2(e0.f);
    public static final j56<l80> Z = hd3.a2(f1.f);

    /* renamed from: a  reason: collision with root package name */
    public static final t1 f3961a = new t1(null);
    public static final j56<n80> a0 = hd3.a2(m1.f);
    public static Context b;
    public static final j56<l10> b0 = hd3.a2(t.f);
    public static final j56<sd1> c = hd3.a2(v.f);
    public static final j56<o10> c0 = hd3.a2(j0.f);
    public static final j56<b80> d = hd3.a2(m.f);
    public static final j56<xd1> d0 = hd3.a2(a0.f);
    public static final j56<sf1> e = hd3.a2(n.f);
    public static final j56<k80> e0 = hd3.a2(z0.f);
    public static final j56<sf1> f = hd3.a2(j.f);
    public static final j56<u30> f0 = hd3.a2(m0.f);
    public static final j56<sf1> g = hd3.a2(k.f);
    public static final j56<a80> g0 = hd3.a2(e.f);
    public static final j56<sf1> h = hd3.a2(y0.f);
    public static final j56<ReportProblemImpl> h0 = hd3.a2(t0.f);
    public static final j56<sf1> i = hd3.a2(g1.f);
    public static final j56<r00> i0 = hd3.a2(f.f);
    public static final j56<h30> j = hd3.a2(b0.f);
    public static final j56<g10> j0 = hd3.a2(p.f);
    public static final j56<d10> k = hd3.a2(i.f);
    public static final j56<j50> k0 = hd3.a2(k1.f);
    public static final j56<m80> l = hd3.a2(i1.f);
    public static final j56<e50> l0 = hd3.a2(c1.f);
    public static final j56<p30> m = hd3.a2(f0.f);
    public static final j56<q30> m0 = hd3.a2(h0.f);
    public static final j56<Integer> n = hd3.a2(r1.f);
    public static final j56<k40> n0 = hd3.a2(u0.f);
    public static final j56<bu> o = hd3.a2(o.f);
    public static final j56<k10> o0 = hd3.a2(j1.f);
    public static boolean p = true;
    public static final j56<y50> p0 = hd3.a2(s1.f);
    public static final j56<nc5> q = hd3.a2(d0.f);
    public static final j56<h10> q0 = hd3.a2(q.f);
    public static final j56<i90> r = hd3.a2(g0.f);
    public static final j56<SuperPassRepository> r0 = hd3.a2(h1.f);
    public static final j56<gv> s = hd3.a2(b.f);
    public static final j56<OnlineCardRechargeRepository> s0 = hd3.a2(l0.f);
    public static final j56<j00> t = hd3.a2(a.f);
    public static final j56<DigitalTripReceiptRepository> t0 = hd3.a2(r.f);
    public static final j56<xj1> u = hd3.a2(w0.f);
    public static i30 u0;
    public static final j56<xj1> v = hd3.a2(v0.f);
    public static o20 v0;
    public static final j56<w40> w = hd3.a2(b1.f);
    public static final j56<tz> w0 = hd3.a2(e1.f);
    public static final j56<a60> x = hd3.a2(c0.f);
    public static final j56<f60> x0 = hd3.a2(n1.f);
    public static final j56<u10> y = hd3.a2(w.f);
    public static boolean y0;
    public static final j56<l50> z = hd3.a2(l1.f);
    public static int z0;

    /* renamed from: xt$a */
    /* compiled from: DependencyFactory.kt */
    public static final class a extends o86 implements h76<j00> {
        public static final a f = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public j00 invoke() {
            return new j00(xt.f3961a.C());
        }
    }

    /* renamed from: xt$a0 */
    /* compiled from: DependencyFactory.kt */
    public static final class a0 extends o86 implements h76<xd1> {
        public static final a0 f = new a0();

        public a0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public xd1 invoke() {
            return new xd1(xt.f3961a.m());
        }
    }

    /* renamed from: xt$a1 */
    /* compiled from: DependencyFactory.kt */
    public static final class a1 extends o86 implements h76<b60> {
        public static final a1 f = new a1();

        public a1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public b60 invoke() {
            t1 t1Var = xt.f3961a;
            return new b60(t1Var.m().getApplicationContext(), t1Var.k().d(), t1Var.B());
        }
    }

    /* renamed from: xt$b */
    /* compiled from: DependencyFactory.kt */
    public static final class b extends o86 implements h76<gv> {
        public static final b f = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gv invoke() {
            t1 t1Var = xt.f3961a;
            kd1 kd1 = new kd1(t1Var.C(), t1Var.n(), ut.f);
            id1 id1 = new id1(t1Var.m(), t1Var.n());
            Context m = t1Var.m();
            t1Var.m();
            hd1[] hd1Arr = {new jd1(t1Var.C(), t1Var.n(), ut.f), id1, new fd1(), kd1, new gd1(t1Var.m())};
            n86.e(hd1Arr, "elements");
            return new gv(m, y56.a(hd1Arr));
        }
    }

    /* renamed from: xt$b0 */
    /* compiled from: DependencyFactory.kt */
    public static final class b0 extends o86 implements h76<h30> {
        public static final b0 f = new b0();

        public b0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public h30 invoke() {
            return new h30(xt.f3961a.m());
        }
    }

    /* renamed from: xt$b1 */
    /* compiled from: DependencyFactory.kt */
    public static final class b1 extends o86 implements h76<w40> {
        public static final b1 f = new b1();

        public b1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public w40 invoke() {
            t1 t1Var = xt.f3961a;
            return new w40(t1Var.S(), t1Var.m());
        }
    }

    /* renamed from: xt$c */
    /* compiled from: DependencyFactory.kt */
    public static final class c extends o86 implements h76<l00> {
        public static final c f = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public l00 invoke() {
            t1 t1Var = xt.f3961a;
            t1Var.m();
            return new l00(t1Var.A());
        }
    }

    /* renamed from: xt$c0 */
    /* compiled from: DependencyFactory.kt */
    public static final class c0 extends o86 implements h76<a60> {
        public static final c0 f = new c0();

        public c0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public a60 invoke() {
            t1 t1Var = xt.f3961a;
            return new a60(t1Var.m(), t1Var.S(), ut.C);
        }
    }

    /* renamed from: xt$c1 */
    /* compiled from: DependencyFactory.kt */
    public static final class c1 extends o86 implements h76<e50> {
        public static final c1 f = new c1();

        public c1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public e50 invoke() {
            return new e50(xt.f3961a.m());
        }
    }

    /* renamed from: xt$d */
    /* compiled from: DependencyFactory.kt */
    public static final class d extends o86 implements h76<d20> {
        public static final d f = new d();

        public d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public d20 invoke() {
            Object obj;
            ClassLoader classLoader = d20.class.getClassLoader();
            if (classLoader == null) {
                obj = null;
            } else {
                t1 t1Var = xt.f3961a;
                obj = Proxy.newProxyInstance(classLoader, new Class[]{d20.class}, new d60(t1Var.m(), new n00(t1Var.m(), t1Var.S(), t1Var.m0())));
                n86.d(obj, "newProxyInstance(\n      …xt, target)\n            )");
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type app.zophop.features.IBookingFeature");
            return (d20) obj;
        }
    }

    /* renamed from: xt$d0 */
    /* compiled from: DependencyFactory.kt */
    public static final class d0 extends o86 implements h76<nc5> {
        public static final d0 f = new d0();

        public d0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public nc5 invoke() {
            return nc5.k(xt.f3961a.m().getApplicationContext(), ut.e);
        }
    }

    /* renamed from: xt$d1 */
    /* compiled from: DependencyFactory.kt */
    public static final class d1 extends o86 implements h76<g50> {
        public static final d1 f = new d1();

        public d1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public g50 invoke() {
            return new g50(xt.f3961a.m());
        }
    }

    /* renamed from: xt$e */
    /* compiled from: DependencyFactory.kt */
    public static final class e extends o86 implements h76<a80> {
        public static final e f = new e();

        public e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public a80 invoke() {
            t1 t1Var = xt.f3961a;
            return new a80(t1Var.m(), t1Var.k().d());
        }
    }

    /* renamed from: xt$e0 */
    /* compiled from: DependencyFactory.kt */
    public static final class e0 extends o86 implements h76<o30> {
        public static final e0 f = new e0();

        public e0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public o30 invoke() {
            return new o30(xt.f3961a.m());
        }
    }

    /* renamed from: xt$e1 */
    /* compiled from: DependencyFactory.kt */
    public static final class e1 extends o86 implements h76<tz> {
        public static final e1 f = new e1();

        public e1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public tz invoke() {
            return new tz(xt.f3961a.m(), "keySoundFeature");
        }
    }

    /* renamed from: xt$f */
    /* compiled from: DependencyFactory.kt */
    public static final class f extends o86 implements h76<r00> {
        public static final f f = new f();

        public f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public r00 invoke() {
            return new r00(xt.f3961a.m());
        }
    }

    /* renamed from: xt$f0 */
    /* compiled from: DependencyFactory.kt */
    public static final class f0 extends o86 implements h76<p30> {
        public static final f0 f = new f0();

        public f0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public p30 invoke() {
            return new p30(xt.f3961a.m());
        }
    }

    /* renamed from: xt$f1 */
    /* compiled from: DependencyFactory.kt */
    public static final class f1 extends o86 implements h76<l80> {
        public static final f1 f = new f1();

        public f1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public l80 invoke() {
            t1 t1Var = xt.f3961a;
            return new l80(t1Var.m(), t1Var.k().d());
        }
    }

    /* renamed from: xt$g */
    /* compiled from: DependencyFactory.kt */
    public static final class g extends o86 implements h76<t00> {
        public static final g f = new g();

        public g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public t00 invoke() {
            return new t00(xt.f3961a.m());
        }
    }

    /* renamed from: xt$g0 */
    /* compiled from: DependencyFactory.kt */
    public static final class g0 extends o86 implements h76<i90> {
        public static final g0 f = new g0();

        public g0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public i90 invoke() {
            nc5 C = xt.f3961a.C();
            i90 i90 = new i90(C);
            C.e.a(C.j());
            return i90;
        }
    }

    /* renamed from: xt$g1 */
    /* compiled from: DependencyFactory.kt */
    public static final class g1 extends o86 implements h76<sf1> {
        public static final g1 f = new g1();

        public g1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public sf1 invoke() {
            return new sf1(xt.f3961a.m().getSharedPreferences("superPassActivationTimestampsMap", 0), "superPassActivationTimestamps_map");
        }
    }

    /* renamed from: xt$h */
    /* compiled from: DependencyFactory.kt */
    public static final class h extends o86 implements h76<u00> {
        public static final h f = new h();

        public h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public u00 invoke() {
            t1 t1Var = xt.f3961a;
            Context m = t1Var.m();
            xj1 T = t1Var.T();
            t1Var.k();
            return new u00(m, T);
        }
    }

    /* renamed from: xt$h0 */
    /* compiled from: DependencyFactory.kt */
    public static final class h0 extends o86 implements h76<q30> {
        public static final h0 f = new h0();

        public h0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public q30 invoke() {
            return new q30(xt.f3961a.m());
        }
    }

    /* renamed from: xt$h1 */
    /* compiled from: DependencyFactory.kt */
    public static final class h1 extends o86 implements h76<SuperPassRepository> {
        public static final h1 f = new h1();

        public h1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public SuperPassRepository invoke() {
            return new SuperPassRepository(xt.f3961a.m());
        }
    }

    /* renamed from: xt$i */
    /* compiled from: DependencyFactory.kt */
    public static final class i extends o86 implements h76<d10> {
        public static final i f = new i();

        public i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public d10 invoke() {
            Context m = xt.f3961a.m();
            if (d10.f777a == null) {
                d10.f777a = new d10(m);
            }
            d10 d10 = d10.f777a;
            d10.n();
            return d10;
        }
    }

    /* renamed from: xt$i0 */
    /* compiled from: DependencyFactory.kt */
    public static final class i0 extends o86 implements h76<r30> {
        public static final i0 f = new i0();

        public i0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public r30 invoke() {
            return new r30(xt.f3961a.m());
        }
    }

    /* renamed from: xt$i1 */
    /* compiled from: DependencyFactory.kt */
    public static final class i1 extends o86 implements h76<m80> {
        public static final i1 f = new i1();

        public i1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public m80 invoke() {
            return new m80(xt.f3961a.m());
        }
    }

    /* renamed from: xt$j */
    /* compiled from: DependencyFactory.kt */
    public static final class j extends o86 implements h76<sf1> {
        public static final j f = new j();

        public j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public sf1 invoke() {
            return new sf1(xt.f3961a.m().getSharedPreferences("chaloConfig", 0), "chaloConfig_properties");
        }
    }

    /* renamed from: xt$j0 */
    /* compiled from: DependencyFactory.kt */
    public static final class j0 extends o86 implements h76<o10> {
        public static final j0 f = new j0();

        public j0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public o10 invoke() {
            return new o10(xt.f3961a.m());
        }
    }

    /* renamed from: xt$j1 */
    /* compiled from: DependencyFactory.kt */
    public static final class j1 extends o86 implements h76<k10> {
        public static final j1 f = new j1();

        public j1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public k10 invoke() {
            return new k10(xt.f3961a.m());
        }
    }

    /* renamed from: xt$k */
    /* compiled from: DependencyFactory.kt */
    public static final class k extends o86 implements h76<sf1> {
        public static final k f = new k();

        public k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public sf1 invoke() {
            return new sf1(xt.f3961a.m().getSharedPreferences("chaloConfigMetadata", 0), "chaloConfig_metaProperties");
        }
    }

    /* renamed from: xt$k0 */
    /* compiled from: DependencyFactory.kt */
    public static final class k0 extends o86 implements h76<s30> {
        public static final k0 f = new k0();

        public k0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public s30 invoke() {
            return new s30();
        }
    }

    /* renamed from: xt$k1 */
    /* compiled from: DependencyFactory.kt */
    public static final class k1 extends o86 implements h76<j50> {
        public static final k1 f = new k1();

        public k1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public j50 invoke() {
            return new j50(xt.f3961a.m());
        }
    }

    /* renamed from: xt$l */
    /* compiled from: DependencyFactory.kt */
    public static final class l extends o86 implements h76<e10> {
        public static final l f = new l();

        public l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public e10 invoke() {
            return new e10(xt.f3961a.m());
        }
    }

    /* renamed from: xt$l0 */
    /* compiled from: DependencyFactory.kt */
    public static final class l0 extends o86 implements h76<OnlineCardRechargeRepository> {
        public static final l0 f = new l0();

        public l0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public OnlineCardRechargeRepository invoke() {
            return new OnlineCardRechargeRepository(xt.f3961a.m());
        }
    }

    /* renamed from: xt$l1 */
    /* compiled from: DependencyFactory.kt */
    public static final class l1 extends o86 implements h76<l50> {
        public static final l1 f = new l1();

        public l1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public l50 invoke() {
            t1 t1Var = xt.f3961a;
            return new l50(t1Var.m(), t1Var.S(), t1Var.k());
        }
    }

    /* renamed from: xt$m */
    /* compiled from: DependencyFactory.kt */
    public static final class m extends o86 implements h76<b80> {
        public static final m f = new m();

        public m() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public b80 invoke() {
            return new b80(xt.f3961a.m());
        }
    }

    /* renamed from: xt$m0 */
    /* compiled from: DependencyFactory.kt */
    public static final class m0 extends o86 implements h76<u30> {
        public static final m0 f = new m0();

        public m0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public u30 invoke() {
            return new u30();
        }
    }

    /* renamed from: xt$m1 */
    /* compiled from: DependencyFactory.kt */
    public static final class m1 extends o86 implements h76<n80> {
        public static final m1 f = new m1();

        public m1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public n80 invoke() {
            t1 t1Var = xt.f3961a;
            return new n80(t1Var.m(), t1Var.k().d());
        }
    }

    /* renamed from: xt$n */
    /* compiled from: DependencyFactory.kt */
    public static final class n extends o86 implements h76<sf1> {
        public static final n f = new n();

        public n() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public sf1 invoke() {
            return new sf1(xt.f3961a.m().getSharedPreferences("config", 0), "config_properties");
        }
    }

    /* renamed from: xt$n0 */
    /* compiled from: DependencyFactory.kt */
    public static final class n0 extends o86 implements h76<t20> {
        public static final n0 f = new n0();

        public n0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public t20 invoke() {
            Object obj;
            ClassLoader classLoader = t20.class.getClassLoader();
            if (classLoader == null) {
                obj = null;
            } else {
                t1 t1Var = xt.f3961a;
                obj = Proxy.newProxyInstance(classLoader, new Class[]{t20.class}, new d60(t1Var.m(), new v30(t1Var.m(), t1Var.S())));
                n86.d(obj, "newProxyInstance(\n      …xt, target)\n            )");
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type app.zophop.features.IProfileFeature");
            return (t20) obj;
        }
    }

    /* renamed from: xt$n1 */
    /* compiled from: DependencyFactory.kt */
    public static final class n1 extends o86 implements h76<f60> {
        public static final n1 f = new n1();

        public n1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public f60 invoke() {
            return new f60();
        }
    }

    /* renamed from: xt$o */
    /* compiled from: DependencyFactory.kt */
    public static final class o extends o86 implements h76<bu> {
        public static final o f = new o();

        public o() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public bu invoke() {
            t1 t1Var = xt.f3961a;
            return new bu(t1Var.m(), t1Var.l());
        }
    }

    /* renamed from: xt$o0 */
    /* compiled from: DependencyFactory.kt */
    public static final class o0 extends o86 implements h76<y30> {
        public static final o0 f = new o0();

        public o0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public y30 invoke() {
            return new y30(xt.f3961a.m());
        }
    }

    /* renamed from: xt$o1 */
    /* compiled from: DependencyFactory.kt */
    public static final class o1 extends o86 implements h76<q50> {
        public static final o1 f = new o1();

        public o1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public q50 invoke() {
            t1 t1Var = xt.f3961a;
            return new q50(t1Var.m(), t1Var.S());
        }
    }

    /* renamed from: xt$p */
    /* compiled from: DependencyFactory.kt */
    public static final class p extends o86 implements h76<g10> {
        public static final p f = new p();

        public p() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public g10 invoke() {
            xt.f3961a.m();
            return new g10();
        }
    }

    /* renamed from: xt$p0 */
    /* compiled from: DependencyFactory.kt */
    public static final class p0 extends o86 implements h76<z30> {
        public static final p0 f = new p0();

        public p0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public z30 invoke() {
            t1 t1Var = xt.f3961a;
            return new z30(t1Var.m(), t1Var.m0());
        }
    }

    /* renamed from: xt$p1 */
    /* compiled from: DependencyFactory.kt */
    public static final class p1 extends o86 implements h76<u50> {
        public static final p1 f = new p1();

        public p1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public u50 invoke() {
            return new u50(xt.f3961a.m());
        }
    }

    /* renamed from: xt$q */
    /* compiled from: DependencyFactory.kt */
    public static final class q extends o86 implements h76<h10> {
        public static final q f = new q();

        public q() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public h10 invoke() {
            return new h10(xt.f3961a.m());
        }
    }

    /* renamed from: xt$q0 */
    /* compiled from: DependencyFactory.kt */
    public static final class q0 extends o86 implements h76<f40> {
        public static final q0 f = new q0();

        public q0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public f40 invoke() {
            t1 t1Var = xt.f3961a;
            f40 f40 = new f40(t1Var.m(), t1Var.T());
            if (t1Var.k().d() == null) {
                xt.p = true;
            } else if (xt.p) {
                City d = t1Var.k().d();
                f40.j(d == null ? null : d.getName());
            }
            return f40;
        }
    }

    /* renamed from: xt$q1 */
    /* compiled from: DependencyFactory.kt */
    public static final class q1 extends o86 implements h76<x50> {
        public static final q1 f = new q1();

        public q1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public x50 invoke() {
            return new x50(xt.f3961a.T());
        }
    }

    /* renamed from: xt$r */
    /* compiled from: DependencyFactory.kt */
    public static final class r extends o86 implements h76<DigitalTripReceiptRepository> {
        public static final r f = new r();

        public r() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public DigitalTripReceiptRepository invoke() {
            return new DigitalTripReceiptRepository(xt.f3961a.m());
        }
    }

    /* renamed from: xt$r0 */
    /* compiled from: DependencyFactory.kt */
    public static final class r0 extends o86 implements h76<i40> {
        public static final r0 f = new r0();

        public r0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public i40 invoke() {
            return new i40(xt.f3961a.m());
        }
    }

    /* renamed from: xt$r1 */
    /* compiled from: DependencyFactory.kt */
    public static final class r1 extends o86 implements h76<Integer> {
        public static final r1 f = new r1();

        public r1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Integer invoke() {
            int i = 0;
            try {
                t1 t1Var = xt.f3961a;
                i = (int) h.O(t1Var.m().getPackageManager().getPackageInfo(t1Var.m().getPackageName(), 0));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return Integer.valueOf(i);
        }
    }

    /* renamed from: xt$s */
    /* compiled from: DependencyFactory.kt */
    public static final class s extends o86 implements h76<c80> {
        public static final s f = new s();

        public s() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public c80 invoke() {
            t1 t1Var = xt.f3961a;
            return new c80(t1Var.m(), t1Var.k().d());
        }
    }

    /* renamed from: xt$s0 */
    /* compiled from: DependencyFactory.kt */
    public static final class s0 extends o86 implements h76<j40> {
        public static final s0 f = new s0();

        public s0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public j40 invoke() {
            t1 t1Var = xt.f3961a;
            return new j40(t1Var.m(), t1Var.S());
        }
    }

    /* renamed from: xt$s1 */
    /* compiled from: DependencyFactory.kt */
    public static final class s1 extends o86 implements h76<y50> {
        public static final s1 f = new s1();

        public s1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public y50 invoke() {
            return new y50(xt.f3961a.m());
        }
    }

    /* renamed from: xt$t */
    /* compiled from: DependencyFactory.kt */
    public static final class t extends o86 implements h76<l10> {
        public static final t f = new t();

        public t() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public l10 invoke() {
            t1 t1Var = xt.f3961a;
            return new l10(t1Var.m(), t1Var.k().d());
        }
    }

    /* renamed from: xt$t0 */
    /* compiled from: DependencyFactory.kt */
    public static final class t0 extends o86 implements h76<ReportProblemImpl> {
        public static final t0 f = new t0();

        public t0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ReportProblemImpl invoke() {
            return new ReportProblemImpl(xt.f3961a.m());
        }
    }

    /* renamed from: xt$t1 */
    /* compiled from: DependencyFactory.kt */
    public static final class t1 {
        public t1(j86 j86) {
        }

        public final i30 A() {
            i30 i30 = xt.u0;
            if (i30 != null) {
                return i30;
            }
            n86.l("localDataManager");
            throw null;
        }

        public final je1 B() {
            return xt.x.getValue();
        }

        public final nc5 C() {
            nc5 value = xt.q.getValue();
            n86.d(value, "<get-mixpanelAPI>(...)");
            return value;
        }

        public final String D() {
            return C().j();
        }

        public final o30 E() {
            return xt.Y.getValue();
        }

        public final p30 F() {
            return xt.m.getValue();
        }

        public final q30 G() {
            return xt.m0.getValue();
        }

        public final p20 H() {
            return xt.V.getValue();
        }

        public final q20 I() {
            return xt.c0.getValue();
        }

        public final s30 J() {
            return xt.R.getValue();
        }

        public final OnlineCardRechargeRepository K() {
            return xt.s0.getValue();
        }

        public final t20 L() {
            return xt.A.getValue();
        }

        public final u20 M() {
            return xt.L.getValue();
        }

        public final z30 N() {
            return xt.O.getValue();
        }

        public final f40 O() {
            return xt.I.getValue();
        }

        public final v20 P() {
            return xt.Q.getValue();
        }

        public final x20 Q() {
            return xt.h0.getValue();
        }

        public final y20 R() {
            return xt.n0.getValue();
        }

        public final xj1 S() {
            return xt.v.getValue();
        }

        public final xj1 T() {
            xj1 value = xt.u.getValue();
            n86.d(value, "<get-requestQueueWithoutSSLPinning>(...)");
            return value;
        }

        public final v40 U() {
            return xt.C.getValue();
        }

        public final sf1 V() {
            return xt.h.getValue();
        }

        public final String W(String str) {
            if (str == null) {
                return new String();
            }
            String lowerCase = str.toLowerCase();
            n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            return n86.j(lowerCase, "citySpecificAvailabilityInfo");
        }

        public final g80 X() {
            return xt.e0.getValue();
        }

        public final b60 Y() {
            return xt.T.getValue();
        }

        public final z20 Z() {
            return xt.l0.getValue();
        }

        public final gv a() {
            return xt.s.getValue();
        }

        public final a30 a0() {
            return xt.X.getValue();
        }

        public final l00 b() {
            return xt.S.getValue();
        }

        public final h80 b0() {
            return xt.Z.getValue();
        }

        public final d20 c() {
            return xt.B.getValue();
        }

        public final w40 c0() {
            return xt.w.getValue();
        }

        public final d80 d() {
            return xt.g0.getValue();
        }

        public final sf1 d0() {
            return xt.i.getValue();
        }

        public final e20 e() {
            return xt.i0.getValue();
        }

        public final SuperPassRepository e0() {
            return xt.r0.getValue();
        }

        public final t00 f() {
            return xt.W.getValue();
        }

        public final i80 f0() {
            return xt.l.getValue();
        }

        public final u00 g() {
            return xt.D.getValue();
        }

        public final b30 g0() {
            return xt.k0.getValue();
        }

        public final sf1 h() {
            return xt.f.getValue();
        }

        public final c30 h0() {
            return xt.z.getValue();
        }

        public final sf1 i() {
            return xt.g.getValue();
        }

        public final j80 i0() {
            return xt.a0.getValue();
        }

        public final g20 j() {
            return xt.M.getValue();
        }

        public final q50 j0() {
            return xt.J.getValue();
        }

        public final e80 k() {
            return xt.d.getValue();
        }

        public final d30 k0() {
            return xt.P.getValue();
        }

        public final sf1 l() {
            return xt.e.getValue();
        }

        public final r20 l0() {
            return xt.F.getValue();
        }

        public final Context m() {
            Context context = xt.b;
            if (context != null) {
                return context;
            }
            n86.l(AnalyticsConstants.CONTEXT);
            throw null;
        }

        public final String m0() {
            if (L().m()) {
                return L().getUserId();
            }
            return C().j();
        }

        public final zc1 n() {
            return xt.o.getValue();
        }

        public final e30 n0() {
            return xt.p0.getValue();
        }

        public final i20 o() {
            return xt.j0.getValue();
        }

        public final void o0() {
            xt.z0++;
        }

        public final j20 p() {
            return xt.q0.getValue();
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void p0(java.lang.String r8) {
            /*
                r7 = this;
                r0 = 0
                r1 = 1
                if (r8 == 0) goto L_0x0044
                ut$a r2 = defpackage.ut.f3552a
                f20 r2 = r7.t()
                java.lang.String r3 = "cityListForSocketConnectionDisabled"
                java.lang.String r2 = r2.f(r3)
                if (r2 == 0) goto L_0x0044
                org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x003a }
                r3.<init>(r2)     // Catch:{ Exception -> 0x003a }
                int r2 = r3.length()     // Catch:{ Exception -> 0x003a }
                if (r2 <= 0) goto L_0x0044
                r4 = 0
            L_0x001e:
                int r5 = r4 + 1
                java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x003a }
                if (r4 == 0) goto L_0x0035
                boolean r6 = defpackage.ea6.f(r4, r8, r1)     // Catch:{ Exception -> 0x003a }
                if (r6 != 0) goto L_0x0045
                java.lang.String r6 = "all"
                boolean r4 = defpackage.ea6.f(r4, r6, r1)     // Catch:{ Exception -> 0x003a }
                if (r4 == 0) goto L_0x0035
                goto L_0x0045
            L_0x0035:
                if (r5 < r2) goto L_0x0038
                goto L_0x0044
            L_0x0038:
                r4 = r5
                goto L_0x001e
            L_0x003a:
                r8 = move-exception
                b00 r0 = defpackage.b00.f358a
                c00 r0 = defpackage.b00.a()
                r0.b(r8)
            L_0x0044:
                r0 = 1
            L_0x0045:
                defpackage.xt.p = r0
                sd1 r8 = r7.v()
                boolean r8 = r8.f
                if (r8 == 0) goto L_0x005f
                ed1 r8 = new ed1
                r0 = -9223372036854775808
                java.lang.String r2 = "crts is socket connected"
                r8.<init>(r2, r0)
                boolean r0 = defpackage.xt.p
                java.lang.String r1 = "connection status"
                defpackage.hj1.d(r0, r8, r1, r8)
            L_0x005f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.xt.t1.p0(java.lang.String):void");
        }

        public final DigitalTripReceiptRepository q() {
            return xt.t0.getValue();
        }

        public final void q0() {
            z10 z10;
            String name;
            xt.y0 = true;
            if (!t().b("useFirebaseForGeospatialData")) {
                int i = 0;
                xt.y0 = false;
                City d = k().d();
                if (d != null && (name = d.getName()) != null) {
                    String f = t().f("cityListForGeoSpatialNoPolling");
                    if (!TextUtils.isEmpty(f)) {
                        try {
                            JSONArray jSONArray = new JSONArray(f);
                            int length = jSONArray.length();
                            if (length > 0) {
                                while (true) {
                                    int i2 = i + 1;
                                    String string = jSONArray.getString(i);
                                    if (string != null && ea6.f(string, name, true)) {
                                        xt.y0 = true;
                                        break;
                                    } else if (i2 >= length) {
                                        break;
                                    } else {
                                        i = i2;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.getMessage();
                            b00 b00 = b00.f358a;
                            b00.a().b(e);
                        }
                    }
                }
            }
            if (xt.y0) {
                z10 = xt.G.getValue();
            } else {
                z10 = xt.H.getValue();
            }
            xt.v0 = z10;
        }

        public final c80 r() {
            return xt.N.getValue();
        }

        public final void r0(City city) {
            gv a2 = a();
            Objects.requireNonNull(a2);
            String name = city.getName();
            HashMap hashMap = new HashMap();
            hashMap.put("selectedCity", name);
            a2.b(hashMap);
            a2.a(hashMap);
            try {
                HashMap hashMap2 = new HashMap();
                c80 r = r();
                Objects.requireNonNull(r);
                hashMap2.put("favCount", String.valueOf(((ArrayList) r.f(RouteStoreType.FAVORITE)).size()));
                hashMap2.put(SessionEventTransform.APP_VERSION_CODE_KEY, String.valueOf(xt.n.getValue().intValue()));
                String b = z().b();
                if (b == null) {
                    b = "";
                }
                hashMap2.put("selected language", b);
                hashMap2.put("time zone", TimeZone.getDefault().getID().toString());
                a().b(hashMap2);
                a().a(hashMap2);
            } catch (Exception unused) {
            }
        }

        public final l20 s() {
            return xt.b0.getValue();
        }

        public final f20 t() {
            d10 value = xt.k.getValue();
            n86.d(value, "<get-chaloConfig>(...)");
            return value;
        }

        public final m20 u() {
            return xt.E.getValue();
        }

        public final sd1 v() {
            sd1 value = xt.c.getValue();
            n86.d(value, "<get-foreground>(...)");
            return value;
        }

        public final n20 w() {
            return xt.y.getValue();
        }

        public final o20 x() {
            o20 o20 = xt.v0;
            if (o20 != null) {
                return o20;
            }
            n86.l("geoSpatialFeature");
            throw null;
        }

        public final k00 y() {
            return xt.U.getValue();
        }

        public final h30 z() {
            return xt.j.getValue();
        }
    }

    /* renamed from: xt$u */
    /* compiled from: DependencyFactory.kt */
    public static final class u extends o86 implements h76<n10> {
        public static final u f = new u();

        public u() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public n10 invoke() {
            t1 t1Var = xt.f3961a;
            t1Var.m();
            return new n10(t1Var.T());
        }
    }

    /* renamed from: xt$u0 */
    /* compiled from: DependencyFactory.kt */
    public static final class u0 extends o86 implements h76<k40> {
        public static final u0 f = new u0();

        public u0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public k40 invoke() {
            return new k40(xt.f3961a.m());
        }
    }

    /* renamed from: xt$v */
    /* compiled from: DependencyFactory.kt */
    public static final class v extends o86 implements h76<sd1> {
        public static final v f = new v();

        public v() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public sd1 invoke() {
            Context m = xt.f3961a.m();
            if (sd1.l == null) {
                Context applicationContext = m.getApplicationContext();
                if (applicationContext instanceof Application) {
                    Application application = (Application) applicationContext;
                    if (sd1.l == null) {
                        sd1 sd1 = new sd1();
                        sd1.l = sd1;
                        application.registerActivityLifecycleCallbacks(sd1);
                    }
                } else {
                    throw new IllegalStateException("Foreground is not initialised and cannot obtain the Application object");
                }
            }
            return sd1.l;
        }
    }

    /* renamed from: xt$v0 */
    /* compiled from: DependencyFactory.kt */
    public static final class v0 extends o86 implements h76<xj1> {
        public static final v0 f = new v0();

        public v0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public xj1 invoke() {
            return xt.f3961a.T();
        }
    }

    /* renamed from: xt$w */
    /* compiled from: DependencyFactory.kt */
    public static final class w extends o86 implements h76<u10> {
        public static final w f = new w();

        public w() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public u10 invoke() {
            t1 t1Var = xt.f3961a;
            return new u10(t1Var.m(), t1Var.B());
        }
    }

    /* renamed from: xt$w0 */
    /* compiled from: DependencyFactory.kt */
    public static final class w0 extends o86 implements h76<xj1> {
        public static final w0 f = new w0();

        public w0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public xj1 invoke() {
            return gj1.V(xt.f3961a.m(), new zt());
        }
    }

    /* renamed from: xt$x */
    /* compiled from: DependencyFactory.kt */
    public static final class x extends o86 implements h76<y10> {
        public static final x f = new x();

        public x() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public y10 invoke() {
            t1 t1Var = xt.f3961a;
            return new y10(t1Var.m(), t1Var.S());
        }
    }

    /* renamed from: xt$x0 */
    /* compiled from: DependencyFactory.kt */
    public static final class x0 extends o86 implements h76<v40> {
        public static final x0 f = new x0();

        public x0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public v40 invoke() {
            t1 t1Var = xt.f3961a;
            sf1 sf1 = new sf1(t1Var.m().getSharedPreferences("route", 0), "route_info");
            xj1 S = t1Var.S();
            t1Var.m();
            return new v40(S, sf1);
        }
    }

    /* renamed from: xt$y */
    /* compiled from: DependencyFactory.kt */
    public static final class y extends o86 implements h76<z10> {
        public static final y f = new y();

        public y() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public z10 invoke() {
            t1 t1Var = xt.f3961a;
            return new z10(t1Var.m(), t1Var.S());
        }
    }

    /* renamed from: xt$y0 */
    /* compiled from: DependencyFactory.kt */
    public static final class y0 extends o86 implements h76<sf1> {
        public static final y0 f = new y0();

        public y0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public sf1 invoke() {
            return new sf1(xt.f3961a.m().getSharedPreferences("routeScreenDisruptionBannerMap", 0), "routeScreenDisruptionBanner_map");
        }
    }

    /* renamed from: xt$z */
    /* compiled from: DependencyFactory.kt */
    public static final class z extends o86 implements h76<k00> {
        public static final z f = new z();

        public z() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public k00 invoke() {
            t1 t1Var = xt.f3961a;
            return new k00(t1Var.m(), t1Var.k());
        }
    }

    /* renamed from: xt$z0 */
    /* compiled from: DependencyFactory.kt */
    public static final class z0 extends o86 implements h76<k80> {
        public static final z0 f = new z0();

        public z0() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public k80 invoke() {
            t1 t1Var = xt.f3961a;
            return new k80(t1Var.m(), t1Var.k().d());
        }
    }
}
