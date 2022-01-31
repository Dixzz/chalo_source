package defpackage;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import com.urbanairship.UAirship;
import com.urbanairship.automation.storage.AutomationDatabase;
import com.urbanairship.json.JsonValue;
import defpackage.bz5;
import defpackage.gm5;
import defpackage.q5;
import defpackage.vo5;
import defpackage.wl;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: mm5  reason: default package */
/* compiled from: AutomationEngine */
public class mm5 {
    public final xy5 A = new o();

    /* renamed from: a  reason: collision with root package name */
    public long f2399a = 1000;
    public final List<Integer> b = Arrays.asList(9, 10);
    public final Comparator<so5> c = new a(this);
    public final wl5 d;
    public gm5 e;
    public final fl5 f;
    public final xn5 g;
    public volatile boolean h;
    public Handler i;
    public final Handler j;
    public s k;
    public final AtomicBoolean l = new AtomicBoolean(false);
    public final vo5 m;
    public long n;
    public final SparseArray<Long> o = new SparseArray<>();
    public kn5 p;
    public HandlerThread q;
    public final List<t> r = new ArrayList();
    public String s;
    public String t;
    public lx5<v> u;
    public ix5 v;
    public final oo5 w;
    public final xl5 x = new g();
    public final vl5 y = new m();
    public final hl5 z = new n();

    /* renamed from: mm5$a */
    /* compiled from: AutomationEngine */
    public class a implements Comparator<so5>, j$.util.Comparator {
        public a(mm5 mm5) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(so5 so5, so5 so52) {
            int i = so5.f3238a.f;
            int i2 = so52.f3238a.f;
            if (i == i2) {
                return 0;
            }
            return i > i2 ? 1 : -1;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<so5> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<so5> thenComparing(java.util.Comparator<? super so5> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: mm5$b */
    /* compiled from: AutomationEngine */
    public class b extends mx5<v> {
        public b() {
        }

        @Override // defpackage.hx5
        public void b(Object obj) {
            mm5.this.u.b((v) obj);
        }
    }

    /* renamed from: mm5$c */
    /* compiled from: AutomationEngine */
    public class c implements qw5<Integer, sw5<v>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ so5 f2401a;

        public c(so5 so5) {
            this.f2401a = so5;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.qw5
        public sw5<v> apply(Integer num) {
            sw5 sw5;
            Integer num2 = num;
            mm5 mm5 = mm5.this;
            int intValue = num2.intValue();
            Objects.requireNonNull(mm5);
            if (intValue == 9) {
                sw5 sw52 = new sw5(new qn5(mm5.d));
                if (hd3.f == null) {
                    hd3.f = new jx5(Looper.getMainLooper());
                }
                sw5 = sw52.h(hd3.f);
            } else if (intValue != 10) {
                sw5 = sw5.c();
            } else {
                sw5 = new sw5(new zw5(new un5()));
            }
            sw5 f = sw5.f(mm5.this.v);
            return f.d(new dx5(f, new pm5(this, num2)));
        }
    }

    /* renamed from: mm5$d */
    /* compiled from: AutomationEngine */
    public class d implements dk5<Integer> {
        public final /* synthetic */ long f;
        public final /* synthetic */ so5 g;

        public d(long j, so5 so5) {
            this.f = j;
            this.g = so5;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.dk5
        public boolean apply(Integer num) {
            Integer num2 = num;
            if (mm5.this.o.get(num2.intValue(), Long.valueOf(mm5.this.n)).longValue() <= this.f) {
                return false;
            }
            for (xo5 xo5 : this.g.b) {
                if (xo5.b == num2.intValue()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: mm5$e */
    /* compiled from: AutomationEngine */
    public class e implements Runnable {
        public e() {
        }

        public void run() {
            List<so5> l = mm5.this.w.l(1);
            if (!l.isEmpty()) {
                mm5.this.r(l);
                for (so5 so5 : l) {
                    mm5.e(mm5.this, so5);
                }
            }
        }
    }

    /* renamed from: mm5$f */
    /* compiled from: AutomationEngine */
    public class f implements gm5.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2402a;

        /* renamed from: mm5$f$a */
        /* compiled from: AutomationEngine */
        public class a implements Runnable {
            public final /* synthetic */ int f;

            public a(int i) {
                this.f = i;
            }

            public void run() {
                f fVar = f.this;
                so5 f2 = mm5.this.w.f(fVar.f2402a);
                if (f2 != null && f2.f3238a.n == 6) {
                    if (mm5.this.k(f2)) {
                        mm5.this.j(f2);
                        return;
                    }
                    int i = this.f;
                    if (i == 0) {
                        mm5.this.u(f2, 1);
                        mm5.this.w.p(f2);
                        mm5.e(mm5.this, f2);
                    } else if (i == 1) {
                        oo5 oo5 = mm5.this.w;
                        Objects.requireNonNull(oo5);
                        oo5.a(f2.f3238a);
                        mm5.c(mm5.this, Collections.singleton(f2));
                    } else if (i == 2) {
                        mm5.this.n(f2);
                    } else if (i == 3) {
                        mm5.this.u(f2, 0);
                        mm5.this.w.p(f2);
                    } else if (i == 4) {
                        mm5.this.o(Collections.singletonList(f2));
                    }
                }
            }
        }

        public f(String str) {
            this.f2402a = str;
        }

        @Override // defpackage.gm5.b
        public void a(int i) {
            mm5.this.i.post(new a(i));
        }
    }

    /* renamed from: mm5$g */
    /* compiled from: AutomationEngine */
    public class g implements xl5 {
        public g() {
        }

        @Override // defpackage.xl5
        public void a(long j) {
            mm5.a(mm5.this, JsonValue.g, 1, 1.0d);
            mm5.this.m();
        }

        @Override // defpackage.xl5
        public void b(long j) {
            mm5.a(mm5.this, JsonValue.g, 2, 1.0d);
            mm5.this.m();
        }
    }

    /* renamed from: mm5$h */
    /* compiled from: AutomationEngine */
    public class h implements Runnable {
        public final /* synthetic */ Collection f;
        public final /* synthetic */ q g;

        public h(Collection collection, q qVar) {
            this.f = collection;
            this.g = qVar;
        }

        public void run() {
            for (ln5<? extends mn5> ln5 : this.f) {
                s sVar = mm5.this.k;
                if (sVar != null) {
                    this.g.a(sVar, ln5);
                }
            }
        }
    }

    /* renamed from: mm5$i */
    /* compiled from: AutomationEngine */
    public class i extends t {
        public i(String str, String str2) {
            super(mm5.this, str, str2);
        }

        @Override // defpackage.uj5
        public void d() {
            so5 f = mm5.this.w.f(this.m);
            if (f != null && f.f3238a.n == 5) {
                if (mm5.this.k(f)) {
                    mm5.this.j(f);
                    return;
                }
                mm5.this.u(f, 6);
                mm5.this.w.p(f);
                mm5.this.o(Collections.singletonList(f));
            }
        }
    }

    /* renamed from: mm5$j */
    /* compiled from: AutomationEngine */
    public class j implements Runnable {
        public final /* synthetic */ t f;

        public j(t tVar) {
            this.f = tVar;
        }

        public void run() {
            mm5.this.r.remove(this.f);
        }
    }

    /* renamed from: mm5$k */
    /* compiled from: AutomationEngine */
    public class k extends t {
        public k(String str, String str2) {
            super(mm5.this, str, str2);
        }

        @Override // defpackage.uj5
        public void d() {
            so5 f = mm5.this.w.f(this.m);
            if (f != null && f.f3238a.n == 3) {
                if (mm5.this.k(f)) {
                    mm5.this.j(f);
                    return;
                }
                long j = f.f3238a.o;
                mm5.this.u(f, 0);
                mm5.this.w.p(f);
                mm5.this.t(f, j);
            }
        }
    }

    /* renamed from: mm5$l */
    /* compiled from: AutomationEngine */
    public class l implements Runnable {
        public final /* synthetic */ t f;

        public l(t tVar) {
            this.f = tVar;
        }

        public void run() {
            mm5.this.r.remove(this.f);
        }
    }

    /* renamed from: mm5$m */
    /* compiled from: AutomationEngine */
    public class m extends cm5 {
        public m() {
        }

        public void onActivityResumed(Activity activity) {
            mm5.this.m();
        }
    }

    /* renamed from: mm5$n */
    /* compiled from: AutomationEngine */
    public class n implements hl5 {
        public n() {
        }

        @Override // defpackage.hl5
        public void a(String str) {
            mm5 mm5 = mm5.this;
            mm5.s = str;
            mm5.a(mm5, JsonValue.x(str), 7, 1.0d);
            mm5.this.m();
        }

        @Override // defpackage.hl5
        public void b(ul5 ul5) {
            mm5.this.t = ul5.b().n().u("region_id").i();
            mm5.a(mm5.this, ul5.b(), 4, 1.0d);
            mm5.this.m();
        }

        @Override // defpackage.hl5
        public void c(kl5 kl5) {
            mm5.a(mm5.this, kl5.b(), 5, 1.0d);
            BigDecimal bigDecimal = kl5.i;
            if (bigDecimal != null) {
                mm5.a(mm5.this, kl5.b(), 6, bigDecimal.doubleValue());
            }
        }
    }

    /* renamed from: mm5$o */
    /* compiled from: AutomationEngine */
    public class o implements xy5 {
        public o() {
        }
    }

    /* renamed from: mm5$p */
    /* compiled from: AutomationEngine */
    public class p implements Runnable {
        public p() {
        }

        public void run() {
            mm5 mm5 = mm5.this;
            vo5 vo5 = mm5.m;
            oo5 oo5 = mm5.w;
            to5 to5 = new to5(vo5.f3669a, vo5.b.b.f711a, "ua_automation.db");
            if (to5.b(vo5.f3669a)) {
                yj5.h("Migrating actions automation database.", new Object[0]);
                vo5.c(to5, new uo5(vo5, oo5));
            }
            to5 to52 = new to5(vo5.f3669a, vo5.b.b.f711a, "in-app");
            if (to52.b(vo5.f3669a)) {
                yj5.h("Migrating in-app message database.", new Object[0]);
                vo5.c(to52, new vo5.a(oo5, vo5.c.d("com.urbanairship.iam.data.SCHEDULED_MESSAGES").n().f.keySet(), null));
                vo5.c.l("com.urbanairship.iam.data.SCHEDULED_MESSAGES");
            }
            mm5 mm52 = mm5.this;
            for (so5 so5 : mm52.w.l(2)) {
                gm5 gm5 = mm52.e;
                ln5<? extends mn5> g = mm52.g(so5);
                dn5 dn5 = dn5.this;
                Objects.requireNonNull(dn5);
                yj5.h("onScheduleExecutionInterrupted schedule: %s", g.f2243a);
                nn5<? extends mn5> k = dn5.k(g);
                if (k != null) {
                    k.a(g);
                }
                mm52.n(so5);
            }
            mm5.f(mm5.this);
            mm5 mm53 = mm5.this;
            List<so5> l = mm53.w.l(1);
            if (!l.isEmpty()) {
                for (so5 so52 : l) {
                    mm53.u(so52, 6);
                }
                mm53.w.r(l);
                yj5.h("AutomationEngine: Schedules reset state to STATE_PREPARING_SCHEDULE: %s", l);
            }
            mm5 mm54 = mm5.this;
            List<so5> l2 = mm54.w.l(5);
            if (!l2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (so5 so53 : l2) {
                    long j = so53.f3238a.s;
                    if (j != 0) {
                        long min = Math.min(TimeUnit.SECONDS.toMillis(j), System.currentTimeMillis() - so53.f3238a.o);
                        if (min <= 0) {
                            mm54.u(so53, 6);
                            arrayList.add(so53);
                        } else {
                            mm54.p(so53, min);
                        }
                    }
                }
                mm54.w.r(arrayList);
            }
            mm5 mm55 = mm5.this;
            List<so5> l3 = mm55.w.l(3);
            if (!l3.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (so5 so54 : l3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    wo5 wo5 = so54.f3238a;
                    long j2 = wo5.j - (currentTimeMillis - wo5.o);
                    if (j2 > 0) {
                        mm55.q(so54, j2);
                    } else {
                        mm55.u(so54, 0);
                        arrayList2.add(so54);
                    }
                }
                mm55.w.r(arrayList2);
            }
            mm5 mm56 = mm5.this;
            mm56.o(mm56.w.l(6));
        }
    }

    /* renamed from: mm5$q */
    /* compiled from: AutomationEngine */
    public interface q {
        void a(s sVar, ln5<? extends mn5> ln5);
    }

    /* renamed from: mm5$r */
    /* compiled from: AutomationEngine */
    public class r implements gm5.a {

        /* renamed from: a  reason: collision with root package name */
        public final String f2406a;

        /* renamed from: mm5$r$a */
        /* compiled from: AutomationEngine */
        public class a implements Runnable {
            public a() {
            }

            public void run() {
                r rVar = r.this;
                mm5 mm5 = mm5.this;
                mm5.n(mm5.w.f(rVar.f2406a));
            }
        }

        public r(String str) {
            this.f2406a = str;
        }

        @Override // defpackage.gm5.a
        public void a() {
            mm5.this.i.post(new a());
        }
    }

    /* renamed from: mm5$s */
    /* compiled from: AutomationEngine */
    public interface s {
    }

    /* renamed from: mm5$t */
    /* compiled from: AutomationEngine */
    public class t extends uj5 {
        public final String m;
        public final String n;

        public t(mm5 mm5, String str, String str2) {
            super(mm5.i.getLooper());
            this.m = str;
            this.n = str2;
        }
    }

    /* renamed from: mm5$u */
    /* compiled from: AutomationEngine */
    public static abstract class u<T> implements Runnable {
        public T f;
        public Exception g;

        public u(String str, String str2) {
        }
    }

    /* renamed from: mm5$v */
    /* compiled from: AutomationEngine */
    public static class v {

        /* renamed from: a  reason: collision with root package name */
        public final List<xo5> f2407a;
        public final cu5 b;
        public final double c;

        public v(List<xo5> list, cu5 cu5, double d) {
            this.f2407a = list;
            this.b = cu5;
            this.c = d;
        }
    }

    public mm5(Context context, kq5 kq5, fl5 fl5, hk5 hk5) {
        er5 f2 = er5.f(context);
        wn5 c2 = wn5.c(context);
        fm fmVar = AutomationDatabase.f727a;
        String a0 = hj1.a0(new StringBuilder(), kq5.b.f711a, "_in-app-automation");
        Object obj = q5.f2896a;
        wl.a C = h.C(context, AutomationDatabase.class, new File(q5.c.c(context), a0).getAbsolutePath());
        C.a(AutomationDatabase.f727a, AutomationDatabase.b);
        C.c();
        po5 po5 = new po5(((AutomationDatabase) C.b()).a());
        vo5 vo5 = new vo5(context, kq5, hk5);
        this.f = fl5;
        this.d = f2;
        this.g = c2;
        this.j = new Handler(Looper.getMainLooper());
        this.w = po5;
        this.m = vo5;
    }

    public static void a(mm5 mm5, cu5 cu5, int i2, double d2) {
        mm5.i.post(new qm5(mm5, i2, cu5, d2));
    }

    public static void b(mm5 mm5, List list) {
        mm5.r(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            mm5.t((so5) it.next(), -1);
        }
    }

    public static void c(mm5 mm5, Collection collection) {
        mm5.l(mm5.h(collection), new um5(mm5));
    }

    public static void d(mm5 mm5, Collection collection) {
        Objects.requireNonNull(mm5);
        Iterator it = new ArrayList(mm5.r).iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (collection.contains(tVar.m)) {
                tVar.cancel();
                mm5.r.remove(tVar);
            }
        }
    }

    public static void e(mm5 mm5, so5 so5) {
        Objects.requireNonNull(mm5);
        int i2 = so5.f3238a.n;
        if (i2 != 1) {
            yj5.c("Unable to execute schedule when state is %s scheduleID: %s", Integer.valueOf(i2), so5.f3238a.b);
        } else if (mm5.k(so5)) {
            mm5.j(so5);
        } else {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            wo5 wo5 = so5.f3238a;
            sm5 sm5 = new sm5(mm5, wo5.b, wo5.c, so5, countDownLatch);
            mm5.j.post(sm5);
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                yj5.e(e2, "Failed to execute schedule. ", new Object[0]);
                Thread.currentThread().interrupt();
            }
            if (sm5.g != null) {
                yj5.c("Failed to check conditions. Deleting schedule: %s", so5.f3238a.b);
                oo5 oo5 = mm5.w;
                Objects.requireNonNull(oo5);
                oo5.a(so5.f3238a);
                mm5.l(mm5.h(Collections.singleton(so5)), new um5(mm5));
                return;
            }
            T t2 = sm5.f;
            int intValue = t2 == null ? 0 : t2.intValue();
            if (intValue == -1) {
                yj5.h("Schedule invalidated: %s", so5.f3238a.b);
                mm5.u(so5, 6);
                mm5.w.p(so5);
                mm5.o(Collections.singletonList(mm5.w.f(so5.f3238a.b)));
            } else if (intValue == 0) {
                yj5.h("Schedule not ready for execution: %s", so5.f3238a.b);
            } else if (intValue == 1) {
                yj5.h("Schedule executing: %s", so5.f3238a.b);
                mm5.u(so5, 2);
                mm5.w.p(so5);
            } else if (intValue == 2) {
                yj5.h("Schedule execution skipped: %s", so5.f3238a.b);
                mm5.u(so5, 0);
                mm5.w.p(so5);
            }
        }
    }

    public static void f(mm5 mm5) {
        long j2;
        List<so5> c2 = mm5.w.c();
        List<so5> l2 = mm5.w.l(4);
        mm5.i(c2);
        HashSet hashSet = new HashSet();
        for (so5 so5 : l2) {
            wo5 wo5 = so5.f3238a;
            long j3 = wo5.i;
            if (j3 == 0) {
                j2 = wo5.o;
            } else {
                long j4 = wo5.h;
                if (j4 >= 0) {
                    j2 = j3 + j4;
                }
            }
            if (System.currentTimeMillis() >= j2) {
                hashSet.add(so5);
            }
        }
        if (!hashSet.isEmpty()) {
            yj5.h("Deleting finished schedules: %s", hashSet);
            mm5.w.b(hashSet);
        }
    }

    public final <T extends mn5> ln5<T> g(so5 so5) {
        if (so5 == null) {
            return null;
        }
        try {
            return hd3.O(so5);
        } catch (ClassCastException e2) {
            yj5.e(e2, "Exception converting entity to schedule %s", so5.f3238a.b);
            return null;
        } catch (Exception e3) {
            yj5.e(e3, "Exception converting entity to schedule %s. Cancelling.", so5.f3238a.b);
            this.i.post(new zm5(this, Collections.singleton(so5.f3238a.b), new ck5()));
            return null;
        }
    }

    public final Collection<ln5<? extends mn5>> h(Collection<so5> collection) {
        ArrayList arrayList = new ArrayList();
        for (so5 so5 : collection) {
            ln5 g2 = g(so5);
            if (g2 != null) {
                arrayList.add(g2);
            }
        }
        return arrayList;
    }

    public final void i(Collection<so5> collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (so5 so5 : collection) {
                u(so5, 4);
                if (so5.f3238a.i > 0) {
                    arrayList2.add(so5);
                } else {
                    arrayList.add(so5);
                }
            }
            this.w.r(arrayList2);
            this.w.b(arrayList);
            l(h(collection), new tm5(this));
        }
    }

    public final void j(so5 so5) {
        i(Collections.singleton(so5));
    }

    public final boolean k(so5 so5) {
        long j2 = so5.f3238a.h;
        return j2 >= 0 && j2 < System.currentTimeMillis();
    }

    public final void l(Collection<ln5<? extends mn5>> collection, q qVar) {
        if (this.k != null && !collection.isEmpty()) {
            this.j.post(new h(collection, qVar));
        }
    }

    public final void m() {
        this.i.post(new e());
    }

    public final void n(so5 so5) {
        if (so5 != null) {
            boolean z2 = true;
            yj5.h("Schedule finished: %s", so5.f3238a.b);
            wo5 wo5 = so5.f3238a;
            int i2 = wo5.m + 1;
            wo5.m = i2;
            int i3 = wo5.e;
            if (i3 <= 0 || i2 < i3) {
                z2 = false;
            }
            if (k(so5)) {
                j(so5);
                return;
            }
            if (z2) {
                u(so5, 4);
                l(h(Collections.singleton(so5)), new vm5(this));
                if (so5.f3238a.i <= 0) {
                    oo5 oo5 = this.w;
                    Objects.requireNonNull(oo5);
                    oo5.a(so5.f3238a);
                    return;
                }
            } else if (so5.f3238a.j > 0) {
                u(so5, 3);
                q(so5, so5.f3238a.j);
            } else {
                u(so5, 0);
            }
            this.w.p(so5);
        }
    }

    public final void o(List<so5> list) {
        if (!(list == null || list.isEmpty())) {
            r(list);
            for (so5 so5 : list) {
                ln5<? extends mn5> g2 = g(so5);
                if (g2 != null) {
                    String str = g2.f2243a;
                    gm5 gm5 = this.e;
                    pn5 pn5 = so5.f3238a.p;
                    f fVar = new f(str);
                    dn5 dn5 = dn5.this;
                    Objects.requireNonNull(dn5);
                    yj5.h("onPrepareSchedule schedule: %s, trigger context: %s", g2.f2243a, pn5);
                    en5 en5 = new en5(dn5, g2, fVar);
                    if (dn5.n(g2)) {
                        dn5.f.post(new fn5(dn5, en5));
                    } else {
                        gn5 gn5 = new gn5(dn5, g2, en5);
                        an5 an5 = new an5(dn5, g2, en5);
                        bn5 bn5 = new bn5(dn5, g2, pn5, en5);
                        bz5 bz5 = dn5.k;
                        Objects.requireNonNull(bz5);
                        bz5.g.execute(new cz5(bz5, new bz5.b(Arrays.asList(gn5, an5, bn5)), 30000));
                    }
                }
            }
        }
    }

    public final void p(so5 so5, long j2) {
        wo5 wo5 = so5.f3238a;
        i iVar = new i(wo5.b, wo5.c);
        iVar.a(new j(iVar));
        this.r.add(iVar);
        ((wn5) this.g).a(j2, iVar);
    }

    public final void q(so5 so5, long j2) {
        wo5 wo5 = so5.f3238a;
        k kVar = new k(wo5.b, wo5.c);
        kVar.a(new l(kVar));
        this.r.add(kVar);
        ((wn5) this.g).a(j2, kVar);
    }

    public final void r(List<so5> list) {
        if (list.size() > 1) {
            Collections.sort(list, this.c);
        }
    }

    public void s(gm5 gm5) {
        sw5 sw5;
        if (!this.h) {
            this.e = gm5;
            this.n = System.currentTimeMillis();
            ey5 ey5 = new ey5("automation");
            this.q = ey5;
            ey5.start();
            this.i = new Handler(this.q.getLooper());
            this.v = new jx5(this.q.getLooper());
            kn5 kn5 = new kn5();
            this.p = kn5;
            kn5.f2088a = this.A;
            ConnectivityManager connectivityManager = (ConnectivityManager) UAirship.d().getSystemService("connectivity");
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    connectivityManager.registerDefaultNetworkCallback(kn5.b);
                } else {
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), kn5.b);
                }
            } catch (SecurityException e2) {
                yj5.j(e2, "NetworkMonitor failed to register network callback!", new Object[0]);
            }
            this.d.a(this.x);
            this.d.e(this.y);
            fl5 fl5 = this.f;
            fl5.m.add(this.z);
            this.i.post(new p());
            ArrayList arrayList = new ArrayList();
            for (Integer num : this.b) {
                int intValue = num.intValue();
                if (intValue != 9) {
                    sw5 = sw5.c();
                } else {
                    sw5 sw52 = new sw5(new tn5(this.d));
                    if (hd3.f == null) {
                        hd3.f = new jx5(Looper.getMainLooper());
                    }
                    sw5 = sw52.h(hd3.f);
                }
                sw5 f2 = sw5.f(this.v);
                arrayList.add(f2.d(new dx5(f2, new lm5(this, intValue))));
            }
            sw5 c2 = sw5.c();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c2 = new sw5(new vw5(c2, (sw5) it.next()));
            }
            lx5<v> lx5 = new lx5<>();
            this.u = lx5;
            new vw5(c2, lx5).apply(new nm5(this));
            this.i.post(new om5(this));
            this.i.post(new qm5(this, 8, JsonValue.g, 1.0d));
            this.h = true;
            m();
        }
    }

    public final void t(so5 so5, long j2) {
        sw5 sw5 = new sw5(new cx5(this.b));
        sw5.d(new ex5(sw5, new d(j2, so5))).d(new c(so5)).g(new b());
    }

    public final void u(so5 so5, int i2) {
        wo5 wo5 = so5.f3238a;
        if (wo5.n != i2) {
            wo5.n = i2;
            wo5.o = System.currentTimeMillis();
        }
    }
}
