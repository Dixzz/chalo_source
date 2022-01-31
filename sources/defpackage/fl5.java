package defpackage;

import android.content.Context;
import defpackage.ik5;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import server.zophop.Constants;

/* renamed from: fl5  reason: default package */
/* compiled from: Analytics */
public class fl5 extends oj5 {
    public final wl5 e;
    public final ql5 f;
    public final xl5 g;
    public final kq5 h;
    public final kp5 i;
    public final Executor j;
    public final ku5 k;
    public final ik5 l;
    public final List<hl5> m = new CopyOnWriteArrayList();
    public final List<e> n = new CopyOnWriteArrayList();
    public final List<d> o = new CopyOnWriteArrayList();
    public final Object p = new Object();
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public long v;
    public final List<String> w = new ArrayList();

    /* renamed from: fl5$a */
    /* compiled from: Analytics */
    public class a implements mp5 {
        public a() {
        }

        @Override // defpackage.mp5
        public void a(String str) {
            fl5 fl5 = fl5.this;
            if (fl5.l.d(16)) {
                fl5.f.b(10, TimeUnit.SECONDS);
            }
        }

        @Override // defpackage.mp5
        public void b(String str) {
        }
    }

    /* renamed from: fl5$b */
    /* compiled from: Analytics */
    public class b implements ik5.a {
        public b() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            if (!fl5.this.l.d(16)) {
                fl5 fl5 = fl5.this;
                fl5.j.execute(new gl5(fl5));
                synchronized (fl5.this.p) {
                    fl5.this.f2698a.l("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS");
                }
            }
        }
    }

    /* renamed from: fl5$c */
    /* compiled from: Analytics */
    public class c implements Runnable {
        public final /* synthetic */ ll5 f;

        public c(ll5 ll5) {
            this.f = ll5;
        }

        public void run() {
            fl5 fl5 = fl5.this;
            ql5 ql5 = fl5.f;
            ll5 ll5 = this.f;
            String str = fl5.q;
            synchronized (ql5.g) {
                ql5.d.h(ll5, str);
                ql5.d.i(ql5.f2960a.c("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", 5242880));
            }
            int e = ll5.e();
            if (e == 1) {
                ql5.b(Math.max(ql5.a(), (long) Constants.THRESHOLD_TIMESTAMP), TimeUnit.MILLISECONDS);
            } else if (e == 2) {
                ql5.b(0, TimeUnit.MILLISECONDS);
            } else if (ql5.c.d()) {
                ql5.b(Math.max(ql5.a(), 30000L), TimeUnit.MILLISECONDS);
            } else {
                ql5.b(Math.max(Math.max(ql5.f.b.q - (System.currentTimeMillis() - ql5.f2960a.e("com.urbanairship.analytics.LAST_SEND", 0)), ql5.a()), 30000L), TimeUnit.MILLISECONDS);
            }
        }
    }

    /* renamed from: fl5$d */
    /* compiled from: Analytics */
    public interface d {
        Map<String, String> a();
    }

    /* renamed from: fl5$e */
    /* compiled from: Analytics */
    public interface e {
        void a(ll5 ll5, String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fl5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, kp5 kp5, ku5 ku5) {
        super(context, hk5);
        bm5 f2 = bm5.f(context);
        Executor a2 = pj5.a();
        ql5 ql5 = new ql5(context, hk5, kq5);
        this.h = kq5;
        this.l = ik5;
        this.i = kp5;
        this.e = f2;
        this.k = ku5;
        this.j = a2;
        this.f = ql5;
        this.q = UUID.randomUUID().toString();
        this.g = new el5(this);
    }

    @Override // defpackage.oj5
    public int a() {
        return 1;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        this.e.a(this.g);
        if (this.e.d()) {
            k(System.currentTimeMillis());
        }
        kp5 kp5 = this.i;
        kp5.j.add(new a());
        ik5 ik5 = this.l;
        ik5.b.add(new b());
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0192  */
    @Override // defpackage.oj5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(com.urbanairship.UAirship r12, defpackage.rt5 r13) {
        /*
        // Method dump skipped, instructions count: 710
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fl5.g(com.urbanairship.UAirship, rt5):int");
    }

    public void i(ll5 ll5) {
        if (!ll5.g()) {
            yj5.c("Analytics - Invalid event: %s", ll5);
        } else if (!j()) {
            yj5.a("Disabled ignoring event: %s", ll5.f());
        } else {
            yj5.h("Adding event: %s", ll5.f());
            this.j.execute(new c(ll5));
            for (e eVar : this.n) {
                eVar.a(ll5, this.q);
            }
            for (hl5 hl5 : this.m) {
                String f2 = ll5.f();
                f2.hashCode();
                if (!f2.equals("region_event")) {
                    if (f2.equals("enhanced_custom_event") && (ll5 instanceof kl5)) {
                        hl5.c((kl5) ll5);
                    }
                } else if (ll5 instanceof ul5) {
                    hl5.b((ul5) ll5);
                }
            }
        }
    }

    public boolean j() {
        if (c() && this.h.b.p) {
            if (this.l.d(16)) {
                return true;
            }
        }
        return false;
    }

    public void k(long j2) {
        String uuid = UUID.randomUUID().toString();
        this.q = uuid;
        yj5.a("New session: %s", uuid);
        if (this.t == null) {
            l(this.u);
        }
        i(new jl5(j2));
    }

    public void l(String str) {
        String str2 = this.t;
        if (str2 == null || !str2.equals(str)) {
            String str3 = this.t;
            if (str3 != null) {
                ol5 ol5 = new ol5(str3, this.u, this.v, System.currentTimeMillis());
                this.u = this.t;
                i(ol5);
            }
            this.t = str;
            if (str != null) {
                for (hl5 hl5 : this.m) {
                    hl5.a(str);
                }
            }
            this.v = System.currentTimeMillis();
        }
    }
}
