package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import defpackage.en1;
import defpackage.hn1;
import defpackage.st1;
import defpackage.vt1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/* renamed from: ts1  reason: default package */
/* compiled from: SingleRequest */
public final class ts1<R> implements os1, bt1, ss1, st1.d {
    public static final v7<ts1<?>> C = st1.a(150, new a());
    public static boolean D = true;
    public int A;
    public int B;
    public final String f = String.valueOf(hashCode());
    public final vt1 g = new vt1.b();
    public us1 h;
    public il1 i;
    public Object j;
    public Class<R> k;
    public rs1 l;
    public int m;
    public int n;
    public kl1 o;
    public ct1<R> p;
    public qs1<R> q;
    public hn1 r;
    public gt1<? super R> s;
    public rn1<R> t;
    public hn1.d u;
    public long v;
    public b w;
    public Drawable x;
    public Drawable y;
    public Drawable z;

    /* renamed from: ts1$a */
    /* compiled from: SingleRequest */
    public static class a implements st1.b<ts1<?>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.st1.b
        public ts1<?> a() {
            return new ts1();
        }
    }

    /* renamed from: ts1$b */
    /* compiled from: SingleRequest */
    public enum b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    @Override // defpackage.os1
    public void a() {
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.q = null;
        this.h = null;
        this.s = null;
        this.u = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = -1;
        this.B = -1;
        C.a(this);
    }

    @Override // defpackage.ss1
    public void b(nn1 nn1) {
        m(nn1, 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: rn1<?> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: qs1<R> */
    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: ct1<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ss1
    public void c(rn1<?> rn1, xl1 xl1) {
        this.g.a();
        this.u = null;
        if (rn1 == 0) {
            StringBuilder i0 = hj1.i0("Expected to receive a Resource<R> with an object of ");
            i0.append(this.k);
            i0.append(" inside, but instead got null.");
            m(new nn1(i0.toString()), 5);
            return;
        }
        Object obj = rn1.get();
        if (obj == null || !this.k.isAssignableFrom(obj.getClass())) {
            n(rn1);
            StringBuilder i02 = hj1.i0("Expected to receive an object of ");
            i02.append(this.k);
            i02.append(" but instead got ");
            String str = "";
            i02.append(obj != null ? obj.getClass() : str);
            i02.append("{");
            i02.append(obj);
            i02.append("} inside Resource{");
            i02.append(rn1);
            i02.append("}.");
            String str2 = str;
            if (obj == null) {
                str2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            i02.append(str2);
            m(new nn1(i02.toString()), 5);
            return;
        }
        us1 us1 = this.h;
        if (!(us1 == null || us1.c(this))) {
            n(rn1);
            this.w = b.COMPLETE;
            return;
        }
        us1 us12 = this.h;
        boolean z2 = us12 == null || !us12.d();
        this.w = b.COMPLETE;
        this.t = rn1;
        if (this.i.g <= 3) {
            StringBuilder i03 = hj1.i0("Finished loading ");
            i03.append(obj.getClass().getSimpleName());
            i03.append(" from ");
            i03.append(xl1);
            i03.append(" for ");
            i03.append(this.j);
            i03.append(" with size [");
            i03.append(this.A);
            i03.append("x");
            i03.append(this.B);
            i03.append("] in ");
            i03.append(nt1.a(this.v));
            i03.append(" ms");
            i03.toString();
        }
        qs1<R> qs1 = this.q;
        if (qs1 == 0 || !qs1.b(obj, this.j, this.p, xl1, z2)) {
            Objects.requireNonNull(this.s);
            this.p.b(obj, et1.f1027a);
        }
        us1 us13 = this.h;
        if (us13 != null) {
            us13.g(this);
        }
    }

    @Override // defpackage.os1
    public void clear() {
        rt1.a();
        b bVar = this.w;
        b bVar2 = b.CLEARED;
        if (bVar != bVar2) {
            this.g.a();
            this.p.a(this);
            this.w = b.CANCELLED;
            hn1.d dVar = this.u;
            if (dVar != null) {
                in1<?> in1 = dVar.f1396a;
                ss1 ss1 = dVar.b;
                Objects.requireNonNull(in1);
                rt1.a();
                in1.g.a();
                if (in1.s || in1.u) {
                    if (in1.v == null) {
                        in1.v = new ArrayList(2);
                    }
                    if (!in1.v.contains(ss1)) {
                        in1.v.add(ss1);
                    }
                } else {
                    in1.f.remove(ss1);
                    if (in1.f.isEmpty() && !in1.u && !in1.s && !in1.y) {
                        in1.y = true;
                        en1<R> en1 = in1.x;
                        en1.I = true;
                        cn1 cn1 = en1.G;
                        if (cn1 != null) {
                            cn1.cancel();
                        }
                        ((hn1) in1.j).c(in1, in1.n);
                    }
                }
                this.u = null;
            }
            rn1<R> rn1 = this.t;
            if (rn1 != null) {
                n(rn1);
            }
            if (h()) {
                this.p.h(j());
            }
            this.w = bVar2;
        }
    }

    @Override // defpackage.bt1
    public void d(int i2, int i3) {
        int i4;
        kn1 kn1;
        Y y2;
        ts1 ts1;
        mn1<?> mn1;
        vo1 vo1;
        hn1.d dVar;
        WeakReference<mn1<?>> weakReference;
        Y remove;
        int i5 = i2;
        this.g.a();
        if (Log.isLoggable("Request", 2)) {
            nt1.a(this.v);
        }
        if (this.w == b.WAITING_FOR_SIZE) {
            this.w = b.RUNNING;
            float f2 = this.l.g;
            if (i5 != Integer.MIN_VALUE) {
                i5 = Math.round(((float) i5) * f2);
            }
            this.A = i5;
            if (i3 == Integer.MIN_VALUE) {
                i4 = i3;
            } else {
                i4 = Math.round(f2 * ((float) i3));
            }
            this.B = i4;
            if (Log.isLoggable("Request", 2)) {
                nt1.a(this.v);
            }
            hn1 hn1 = this.r;
            il1 il1 = this.i;
            Object obj = this.j;
            rs1 rs1 = this.l;
            dm1 dm1 = rs1.q;
            int i6 = this.A;
            int i7 = this.B;
            Class<?> cls = rs1.x;
            Class cls2 = (Class<R>) this.k;
            kl1 kl1 = this.o;
            gn1 gn1 = rs1.h;
            Map<Class<?>, im1<?>> map = rs1.w;
            boolean z2 = rs1.r;
            boolean z3 = rs1.D;
            fm1 fm1 = rs1.v;
            boolean z4 = rs1.n;
            boolean z5 = rs1.B;
            boolean z6 = rs1.C;
            Objects.requireNonNull(hn1);
            rt1.a();
            int i8 = nt1.b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Objects.requireNonNull(hn1.b);
            kn1 kn12 = new kn1(obj, dm1, i6, i7, map, cls, cls2, fm1);
            hn1.d dVar2 = null;
            if (!z4) {
                y2 = null;
                kn1 = kn12;
            } else {
                qo1 qo1 = (qo1) hn1.c;
                synchronized (qo1) {
                    kn1 = kn12;
                    remove = qo1.f2727a.remove(kn1);
                    if (remove != null) {
                        qo1.c -= qo1.b(remove);
                    }
                }
                Y y3 = remove;
                if (y3 == null) {
                    y2 = null;
                } else if (y3 instanceof mn1) {
                    y2 = y3;
                } else {
                    y2 = new mn1(y3, true);
                }
                if (y2 != null) {
                    y2.d();
                    hn1.e.put(kn1, new hn1.f(kn1, y2, hn1.a()));
                }
            }
            if (y2 != null) {
                ts1 = this;
                ts1.c(y2, xl1.MEMORY_CACHE);
                if (Log.isLoggable("Engine", 2)) {
                    hn1.b("Loaded resource from cache", elapsedRealtimeNanos, kn1);
                }
            } else {
                ts1 = this;
                if (z4 && (weakReference = hn1.e.get(kn1)) != null) {
                    mn1 = weakReference.get();
                    if (mn1 != null) {
                        mn1.d();
                    } else {
                        hn1.e.remove(kn1);
                    }
                } else {
                    mn1 = null;
                }
                if (mn1 != null) {
                    ts1.c(mn1, xl1.MEMORY_CACHE);
                    if (Log.isLoggable("Engine", 2)) {
                        hn1.b("Loaded resource from active resources", elapsedRealtimeNanos, kn1);
                    }
                } else {
                    in1<?> in1 = hn1.f1390a.get(kn1);
                    if (in1 != null) {
                        in1.a(ts1);
                        if (Log.isLoggable("Engine", 2)) {
                            hn1.b("Added to existing load", elapsedRealtimeNanos, kn1);
                        }
                        dVar = new hn1.d(ts1, in1);
                    } else {
                        in1<?> b2 = hn1.d.e.b();
                        b2.n = kn1;
                        b2.o = z4;
                        b2.p = z5;
                        hn1.a aVar = hn1.h;
                        en1<R> en1 = (en1<R>) aVar.b.b();
                        int i9 = aVar.c;
                        aVar.c = i9 + 1;
                        dn1<R> dn1 = en1.f;
                        en1.d dVar3 = en1.i;
                        dn1.c = il1;
                        dn1.d = obj;
                        dn1.n = dm1;
                        dn1.e = i6;
                        dn1.f = i7;
                        dn1.p = gn1;
                        dn1.g = cls;
                        dn1.h = dVar3;
                        dn1.k = cls2;
                        dn1.o = kl1;
                        dn1.i = fm1;
                        dn1.j = map;
                        dn1.q = z2;
                        dn1.r = z3;
                        en1.m = il1;
                        en1.n = dm1;
                        en1.o = kl1;
                        en1.p = kn1;
                        en1.q = i6;
                        en1.r = i7;
                        en1.s = gn1;
                        en1.z = z6;
                        en1.t = fm1;
                        en1.u = b2;
                        en1.v = i9;
                        en1.x = en1.f.INITIALIZE;
                        hn1.f1390a.put(kn1, b2);
                        b2.a(ts1);
                        b2.x = en1;
                        en1.g l2 = en1.l(en1.g.INITIALIZE);
                        if (l2 == en1.g.RESOURCE_CACHE || l2 == en1.g.DATA_CACHE) {
                            vo1 = b2.k;
                        } else {
                            vo1 = b2.p ? b2.m : b2.l;
                        }
                        vo1.execute(en1);
                        if (Log.isLoggable("Engine", 2)) {
                            hn1.b("Started new load", elapsedRealtimeNanos, kn1);
                        }
                        dVar = new hn1.d(ts1, b2);
                    }
                    dVar2 = dVar;
                }
            }
            ts1.u = dVar2;
            if (Log.isLoggable("Request", 2)) {
                nt1.a(ts1.v);
            }
        }
    }

    @Override // defpackage.os1
    public void e() {
        this.g.a();
        int i2 = nt1.b;
        this.v = SystemClock.elapsedRealtimeNanos();
        if (this.j == null) {
            if (rt1.i(this.m, this.n)) {
                this.A = this.m;
                this.B = this.n;
            }
            m(new nn1("Received null model"), i() == null ? 5 : 3);
            return;
        }
        b bVar = this.w;
        b bVar2 = b.RUNNING;
        if (bVar == bVar2) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (bVar == b.COMPLETE) {
            c(this.t, xl1.MEMORY_CACHE);
        } else {
            b bVar3 = b.WAITING_FOR_SIZE;
            this.w = bVar3;
            if (rt1.i(this.m, this.n)) {
                d(this.m, this.n);
            } else {
                this.p.i(this);
            }
            b bVar4 = this.w;
            if ((bVar4 == bVar2 || bVar4 == bVar3) && h()) {
                this.p.f(j());
            }
            if (Log.isLoggable("Request", 2)) {
                nt1.a(this.v);
            }
        }
    }

    @Override // defpackage.os1
    public boolean f() {
        return this.w == b.COMPLETE;
    }

    @Override // defpackage.st1.d
    public vt1 g() {
        return this.g;
    }

    public final boolean h() {
        us1 us1 = this.h;
        return us1 == null || us1.b(this);
    }

    public final Drawable i() {
        int i2;
        if (this.z == null) {
            rs1 rs1 = this.l;
            Drawable drawable = rs1.t;
            this.z = drawable;
            if (drawable == null && (i2 = rs1.u) > 0) {
                this.z = l(i2);
            }
        }
        return this.z;
    }

    @Override // defpackage.os1
    public boolean isCancelled() {
        b bVar = this.w;
        return bVar == b.CANCELLED || bVar == b.CLEARED;
    }

    @Override // defpackage.os1
    public boolean isRunning() {
        b bVar = this.w;
        return bVar == b.RUNNING || bVar == b.WAITING_FOR_SIZE;
    }

    public final Drawable j() {
        int i2;
        if (this.y == null) {
            rs1 rs1 = this.l;
            Drawable drawable = rs1.l;
            this.y = drawable;
            if (drawable == null && (i2 = rs1.m) > 0) {
                this.y = l(i2);
            }
        }
        return this.y;
    }

    public boolean k(os1 os1) {
        if (!(os1 instanceof ts1)) {
            return false;
        }
        ts1 ts1 = (ts1) os1;
        if (this.m != ts1.m || this.n != ts1.n || !rt1.b(this.j, ts1.j) || !this.k.equals(ts1.k) || !this.l.equals(ts1.l) || this.o != ts1.o) {
            return false;
        }
        return true;
    }

    public final Drawable l(int i2) {
        if (D) {
            try {
                return u0.b(this.i, i2);
            } catch (NoClassDefFoundError unused) {
                D = false;
                Resources resources = this.i.getResources();
                Resources.Theme theme = this.l.z;
                ThreadLocal<TypedValue> threadLocal = y5.f3999a;
                return resources.getDrawable(i2, theme);
            }
        } else {
            Resources resources2 = this.i.getResources();
            Resources.Theme theme2 = this.l.z;
            ThreadLocal<TypedValue> threadLocal2 = y5.f3999a;
            return resources2.getDrawable(i2, theme2);
        }
    }

    public final void m(nn1 nn1, int i2) {
        int i3;
        this.g.a();
        int i4 = this.i.g;
        boolean z2 = false;
        if (i4 <= i2) {
            StringBuilder i0 = hj1.i0("Load failed for ");
            i0.append(this.j);
            i0.append(" with size [");
            i0.append(this.A);
            i0.append("x");
            i0.append(this.B);
            i0.append("]");
            i0.toString();
            if (i4 <= 4) {
                Objects.requireNonNull(nn1);
                ArrayList arrayList = new ArrayList();
                nn1.a(nn1, arrayList);
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    int i6 = i5 + 1;
                    Throwable th = (Throwable) arrayList.get(i5);
                    i5 = i6;
                }
            }
        }
        Drawable drawable = null;
        this.u = null;
        this.w = b.FAILED;
        qs1<R> qs1 = this.q;
        if (qs1 != null) {
            Object obj = this.j;
            ct1<R> ct1 = this.p;
            us1 us1 = this.h;
            if (us1 == null || !us1.d()) {
                z2 = true;
            }
            if (qs1.a(nn1, obj, ct1, z2)) {
                return;
            }
        }
        if (h()) {
            if (this.j == null) {
                drawable = i();
            }
            if (drawable == null) {
                if (this.x == null) {
                    rs1 rs1 = this.l;
                    Drawable drawable2 = rs1.j;
                    this.x = drawable2;
                    if (drawable2 == null && (i3 = rs1.k) > 0) {
                        this.x = l(i3);
                    }
                }
                drawable = this.x;
            }
            if (drawable == null) {
                drawable = j();
            }
            this.p.e(drawable);
        }
    }

    public final void n(rn1<?> rn1) {
        Objects.requireNonNull(this.r);
        rt1.a();
        if (rn1 instanceof mn1) {
            ((mn1) rn1).e();
            this.t = null;
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // defpackage.os1
    public void pause() {
        clear();
        this.w = b.PAUSED;
    }
}
