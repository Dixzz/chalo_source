package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import defpackage.kp5;
import defpackage.kv5;
import defpackage.rt5;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: qu5  reason: default package */
/* compiled from: Inbox */
public class qu5 {
    public static final e x = new e();
    public static final Object y = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List<vu5> f2993a = new CopyOnWriteArrayList();
    public final Set<String> b = new HashSet();
    public final Map<String, wu5> c = new HashMap();
    public final Map<String, wu5> d = new HashMap();
    public final Map<String, wu5> e = new HashMap();
    public final bv5 f;
    public final kv5 g;
    public final Executor h;
    public final Context i;
    public final Handler j = new Handler(Looper.getMainLooper());
    public final hk5 k;
    public final qt5 l;
    public final xl5 m;
    public final mp5 n;
    public final kp5.d o;
    public final kv5.a p;
    public final wl5 q;
    public final kp5 r;
    public boolean s = false;
    public uu5 t;
    public final AtomicBoolean u = new AtomicBoolean(false);
    public final AtomicBoolean v = new AtomicBoolean(false);
    public final List<d> w = new ArrayList();

    /* renamed from: qu5$a */
    /* compiled from: Inbox */
    public class a implements Runnable {
        public final /* synthetic */ Set f;

        public a(Set set) {
            this.f = set;
        }

        public void run() {
            bv5 bv5 = qu5.this.f;
            Set<String> set = this.f;
            Objects.requireNonNull(bv5);
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread", Boolean.FALSE);
            bv5.h(set, contentValues);
        }
    }

    /* renamed from: qu5$b */
    /* compiled from: Inbox */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            for (vu5 vu5 : qu5.this.f2993a) {
                vu5.a();
            }
        }
    }

    /* renamed from: qu5$c */
    /* compiled from: Inbox */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: qu5$d */
    /* compiled from: Inbox */
    public static class d extends uj5 {
        public final c m;
        public boolean n;

        public d(c cVar, Looper looper) {
            super(looper);
            this.m = cVar;
        }

        @Override // defpackage.uj5
        public void d() {
            c cVar = this.m;
            if (cVar != null) {
                cVar.a(this.n);
            }
        }
    }

    /* renamed from: qu5$e */
    /* compiled from: Inbox */
    public static class e implements Comparator<wu5>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(wu5 wu5, wu5 wu52) {
            wu5 wu53 = wu5;
            wu5 wu54 = wu52;
            long j = wu54.h;
            if (j == wu53.h) {
                return wu53.j.compareTo(wu54.j);
            }
            return Long.valueOf(j).compareTo(Long.valueOf(wu53.h));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<wu5> reversed() {
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
        public /* synthetic */ java.util.Comparator<wu5> thenComparing(java.util.Comparator<? super wu5> comparator) {
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

    public qu5(Context context, hk5 hk5, kp5 kp5) {
        qt5 c2 = qt5.c(context);
        kv5 kv5 = new kv5(hk5, kp5);
        bv5 bv5 = new bv5(context);
        Executor a2 = pj5.a();
        bm5 f2 = bm5.f(context);
        this.i = context.getApplicationContext();
        this.k = hk5;
        this.g = kv5;
        this.f = bv5;
        this.h = a2;
        this.l = c2;
        this.r = kp5;
        this.m = new mu5(this, c2);
        this.n = new nu5(this);
        this.o = new ou5(this);
        this.p = new pu5(this);
        this.q = f2;
    }

    public void a(boolean z) {
        yj5.a("Updating user.", new Object[0]);
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_RICH_PUSH_USER_UPDATE";
        a2.b(yu5.class);
        a2.e = zt5.s().g("EXTRA_FORCEFULLY", z).a();
        this.l.a(a2.a());
    }

    public tj5 b(Looper looper, c cVar) {
        d dVar = new d(cVar, null);
        synchronized (this.w) {
            this.w.add(dVar);
            if (!this.s) {
                rt5.b a2 = rt5.a();
                a2.f3130a = "ACTION_RICH_PUSH_MESSAGES_UPDATE";
                a2.b(yu5.class);
                this.l.a(a2.a());
            }
            this.s = true;
        }
        return dVar;
    }

    public final Collection<wu5> c(Collection<wu5> collection, dk5<wu5> dk5) {
        ArrayList arrayList = new ArrayList();
        if (dk5 == null) {
            return collection;
        }
        for (wu5 wu5 : collection) {
            if (dk5.apply(wu5)) {
                arrayList.add(wu5);
            }
        }
        return arrayList;
    }

    public wu5 d(String str) {
        if (str == null) {
            return null;
        }
        synchronized (y) {
            if (this.c.containsKey(str)) {
                return this.c.get(str);
            }
            return this.d.get(str);
        }
    }

    public List<wu5> e(dk5<wu5> dk5) {
        ArrayList arrayList;
        synchronized (y) {
            arrayList = new ArrayList();
            arrayList.addAll(c(this.c.values(), dk5));
            arrayList.addAll(c(this.d.values(), dk5));
            Collections.sort(arrayList, x);
        }
        return arrayList;
    }

    public void f(Set<String> set) {
        this.h.execute(new a(set));
        synchronized (y) {
            for (String str : set) {
                wu5 wu5 = this.c.get(str);
                if (wu5 != null) {
                    wu5.r = false;
                    this.c.remove(str);
                    this.d.put(str, wu5);
                }
            }
            g();
        }
    }

    public final void g() {
        this.j.post(new b());
    }

    public void h(boolean z) {
        synchronized (this.w) {
            for (d dVar : this.w) {
                dVar.n = z;
                dVar.run();
            }
            this.s = false;
            this.w.clear();
        }
    }

    public void i(boolean z) {
        bv5 bv5 = this.f;
        Collection<wu5> f2 = bv5.f(bv5.c(bv5.b, null, null, null, null));
        synchronized (y) {
            HashSet hashSet = new HashSet(this.c.keySet());
            HashSet hashSet2 = new HashSet(this.d.keySet());
            HashSet hashSet3 = new HashSet(this.b);
            this.c.clear();
            this.d.clear();
            this.e.clear();
            Iterator it = ((ArrayList) f2).iterator();
            while (it.hasNext()) {
                wu5 wu5 = (wu5) it.next();
                if (wu5.q || hashSet3.contains(wu5.j)) {
                    this.b.add(wu5.j);
                } else if (wu5.c()) {
                    this.b.add(wu5.j);
                } else {
                    this.e.put(wu5.l, wu5);
                    if (hashSet.contains(wu5.j)) {
                        wu5.r = true;
                        this.c.put(wu5.j, wu5);
                    } else if (hashSet2.contains(wu5.j)) {
                        wu5.r = false;
                        this.d.put(wu5.j, wu5);
                    } else if (wu5.r) {
                        this.c.put(wu5.j, wu5);
                    } else {
                        this.d.put(wu5.j, wu5);
                    }
                }
            }
        }
        if (z) {
            g();
        }
    }

    public void j() {
        this.q.b(this.m);
        kp5 kp5 = this.r;
        kp5.j.remove(this.n);
        kp5 kp52 = this.r;
        kp52.k.remove(this.o);
        kv5 kv5 = this.g;
        kv5.f2125a.remove(this.p);
        this.v.set(false);
    }
}
