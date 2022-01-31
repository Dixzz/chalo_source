package defpackage;

import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import defpackage.cn1;
import defpackage.fn1;
import defpackage.hn1;
import defpackage.lm1;
import defpackage.st1;
import defpackage.vt1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: en1  reason: default package */
/* compiled from: DecodeJob */
public class en1<R> implements cn1.a, Runnable, Comparable<en1<?>>, st1.d {
    public Thread A;
    public dm1 B;
    public dm1 C;
    public Object D;
    public xl1 E;
    public km1<?> F;
    public volatile cn1 G;
    public volatile boolean H;
    public volatile boolean I;
    public final dn1<R> f = new dn1<>();
    public final List<Exception> g = new ArrayList();
    public final vt1 h = new vt1.b();
    public final d i;
    public final v7<en1<?>> j;
    public final c<?> k = new c<>();
    public final e l = new e();
    public il1 m;
    public dm1 n;
    public kl1 o;
    public kn1 p;
    public int q;
    public int r;
    public gn1 s;
    public fm1 t;
    public a<R> u;
    public int v;
    public g w;
    public f x;
    public long y;
    public boolean z;

    /* renamed from: en1$a */
    /* compiled from: DecodeJob */
    public interface a<R> {
    }

    /* renamed from: en1$b */
    /* compiled from: DecodeJob */
    public final class b<Z> implements fn1.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        public final xl1 f1001a;

        public b(xl1 xl1) {
            this.f1001a = xl1;
        }
    }

    /* renamed from: en1$c */
    /* compiled from: DecodeJob */
    public static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        public dm1 f1002a;
        public hm1<Z> b;
        public qn1<Z> c;

        public void a(d dVar, fm1 fm1) {
            int i = y6.f4005a;
            Trace.beginSection("DecodeJob.encode");
            try {
                ((hn1.c) dVar).a().a(this.f1002a, new bn1(this.b, this.c, fm1));
            } finally {
                this.c.d();
                Trace.endSection();
            }
        }
    }

    /* renamed from: en1$d */
    /* compiled from: DecodeJob */
    public interface d {
    }

    /* renamed from: en1$e */
    /* compiled from: DecodeJob */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1003a;
        public boolean b;
        public boolean c;

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.f1003a;
        }
    }

    /* renamed from: en1$f */
    /* compiled from: DecodeJob */
    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: en1$g */
    /* compiled from: DecodeJob */
    public enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public en1(d dVar, v7<en1<?>> v7Var) {
        this.i = dVar;
        this.j = v7Var;
    }

    @Override // defpackage.cn1.a
    public void a(dm1 dm1, Exception exc, km1<?> km1, xl1 xl1) {
        km1.b();
        nn1 nn1 = new nn1("Fetching data failed", exc);
        Class<?> a2 = km1.a();
        nn1.g = dm1;
        nn1.h = xl1;
        nn1.i = a2;
        this.g.add(nn1);
        if (Thread.currentThread() != this.A) {
            this.x = f.SWITCH_TO_SOURCE_SERVICE;
            in1 in1 = (in1) this.u;
            (in1.p ? in1.m : in1.l).execute(this);
            return;
        }
        r();
    }

    public final <Data> rn1<R> c(km1<?> km1, Data data, xl1 xl1) throws nn1 {
        if (data == null) {
            km1.b();
            return null;
        }
        try {
            int i2 = nt1.b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            rn1<R> i3 = i(data, xl1);
            if (Log.isLoggable("DecodeJob", 2)) {
                m("Decoded result " + i3, elapsedRealtimeNanos, null);
            }
            return i3;
        } finally {
            km1.b();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(en1<?> en1) {
        en1<?> en12 = en1;
        int ordinal = this.o.ordinal() - en12.o.ordinal();
        return ordinal == 0 ? this.v - en12.v : ordinal;
    }

    @Override // defpackage.cn1.a
    public void f() {
        this.x = f.SWITCH_TO_SOURCE_SERVICE;
        in1 in1 = (in1) this.u;
        (in1.p ? in1.m : in1.l).execute(this);
    }

    @Override // defpackage.st1.d
    public vt1 g() {
        return this.h;
    }

    @Override // defpackage.cn1.a
    public void h(dm1 dm1, Object obj, km1<?> km1, xl1 xl1, dm1 dm12) {
        this.B = dm1;
        this.D = obj;
        this.F = km1;
        this.E = xl1;
        this.C = dm12;
        if (Thread.currentThread() != this.A) {
            this.x = f.DECODE_DATA;
            in1 in1 = (in1) this.u;
            (in1.p ? in1.m : in1.l).execute(this);
            return;
        }
        int i2 = y6.f4005a;
        Trace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            j();
        } finally {
            Trace.endSection();
        }
    }

    public final <Data> rn1<R> i(Data data, xl1 xl1) throws nn1 {
        lm1<Data> b2;
        pn1<Data, ?, R> d2 = this.f.d(data.getClass());
        fm1 fm1 = this.t;
        if (Build.VERSION.SDK_INT >= 26) {
            em1<Boolean> em1 = kq1.i;
            if (fm1.c(em1) == null && (xl1 == xl1.RESOURCE_DISK_CACHE || this.f.r)) {
                fm1 = new fm1();
                fm1.d(this.t);
                fm1.b.put(em1, Boolean.TRUE);
            }
        }
        mm1 mm1 = this.m.b.e;
        synchronized (mm1) {
            lm1.a<?> aVar = mm1.f2397a.get(data.getClass());
            if (aVar == null) {
                Iterator<lm1.a<?>> it = mm1.f2397a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    lm1.a<?> next = it.next();
                    if (next.a().isAssignableFrom(data.getClass())) {
                        aVar = next;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = mm1.b;
            }
            b2 = aVar.b(data);
        }
        try {
            return d2.a(b2, fm1, this.q, this.r, new b(xl1));
        } finally {
            b2.b();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0069 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rn1<?>, rn1<Z> */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Class<?>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [qn1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [qn1] */
    public final void j() {
        rn1 rn1;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.y;
            StringBuilder i0 = hj1.i0("data: ");
            i0.append(this.D);
            i0.append(", cache key: ");
            i0.append(this.B);
            i0.append(", fetcher: ");
            i0.append(this.F);
            m("Retrieved data", j2, i0.toString());
        }
        qn1<?> qn1 = 0;
        try {
            rn1 = (rn1<R>) c(this.F, this.D, this.E);
        } catch (nn1 e2) {
            dm1 dm1 = this.C;
            xl1 xl1 = this.E;
            e2.g = dm1;
            e2.h = xl1;
            e2.i = qn1;
            this.g.add(e2);
            rn1 = (rn1<Z>) qn1;
        }
        if (rn1 != null) {
            xl1 xl12 = this.E;
            if (rn1 instanceof on1) {
                ((on1) rn1).initialize();
            }
            boolean z2 = false;
            if (this.k.c != null) {
                qn1 = qn1.j.b();
                qn1.i = false;
                qn1.h = true;
                qn1.g = (rn1<Z>) rn1;
                rn1 = qn1;
            }
            w();
            in1 in1 = (in1) this.u;
            in1.q = rn1;
            in1.r = xl12;
            in1.A.obtainMessage(1, in1).sendToTarget();
            this.w = g.ENCODE;
            try {
                c<?> cVar = this.k;
                if (cVar.c != null) {
                    z2 = true;
                }
                if (z2) {
                    cVar.a(this.i, this.t);
                }
            } finally {
                if (qn1 != 0) {
                    qn1.d();
                }
                p();
            }
        } else {
            r();
        }
    }

    public final cn1 k() {
        int ordinal = this.w.ordinal();
        if (ordinal == 1) {
            return new sn1(this.f, this);
        }
        if (ordinal == 2) {
            return new zm1(this.f, this);
        }
        if (ordinal == 3) {
            return new vn1(this.f, this);
        }
        if (ordinal == 5) {
            return null;
        }
        StringBuilder i0 = hj1.i0("Unrecognized stage: ");
        i0.append(this.w);
        throw new IllegalStateException(i0.toString());
    }

    public final g l(g gVar) {
        int ordinal = gVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return this.z ? g.FINISHED : g.SOURCE;
                }
                if (ordinal == 3 || ordinal == 5) {
                    return g.FINISHED;
                }
                throw new IllegalArgumentException("Unrecognized stage: " + gVar);
            } else if (this.s.a()) {
                return g.DATA_CACHE;
            } else {
                return l(g.DATA_CACHE);
            }
        } else if (this.s.b()) {
            return g.RESOURCE_CACHE;
        } else {
            return l(g.RESOURCE_CACHE);
        }
    }

    public final void m(String str, long j2, String str2) {
        StringBuilder k0 = hj1.k0(str, " in ");
        k0.append(nt1.a(j2));
        k0.append(", load key: ");
        k0.append(this.p);
        k0.append(str2 != null ? hj1.S(", ", str2) : "");
        k0.append(", thread: ");
        k0.append(Thread.currentThread().getName());
        k0.toString();
    }

    public final void o() {
        boolean a2;
        w();
        nn1 nn1 = new nn1("Failed to load resource", new ArrayList(this.g));
        in1 in1 = (in1) this.u;
        in1.t = nn1;
        in1.A.obtainMessage(2, in1).sendToTarget();
        e eVar = this.l;
        synchronized (eVar) {
            eVar.c = true;
            a2 = eVar.a(false);
        }
        if (a2) {
            q();
        }
    }

    public final void p() {
        boolean a2;
        e eVar = this.l;
        synchronized (eVar) {
            eVar.b = true;
            a2 = eVar.a(false);
        }
        if (a2) {
            q();
        }
    }

    public final void q() {
        e eVar = this.l;
        synchronized (eVar) {
            eVar.b = false;
            eVar.f1003a = false;
            eVar.c = false;
        }
        c<?> cVar = this.k;
        cVar.f1002a = null;
        cVar.b = null;
        cVar.c = null;
        dn1<R> dn1 = this.f;
        dn1.c = null;
        dn1.d = null;
        dn1.n = null;
        dn1.g = null;
        dn1.k = null;
        dn1.i = null;
        dn1.o = null;
        dn1.j = null;
        dn1.p = null;
        dn1.f859a.clear();
        dn1.l = false;
        dn1.b.clear();
        dn1.m = false;
        this.H = false;
        this.m = null;
        this.n = null;
        this.t = null;
        this.o = null;
        this.p = null;
        this.u = null;
        this.w = null;
        this.G = null;
        this.A = null;
        this.B = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.y = 0;
        this.I = false;
        this.g.clear();
        this.j.a(this);
    }

    public final void r() {
        this.A = Thread.currentThread();
        int i2 = nt1.b;
        this.y = SystemClock.elapsedRealtimeNanos();
        boolean z2 = false;
        while (!this.I && this.G != null && !(z2 = this.G.b())) {
            this.w = l(this.w);
            this.G = k();
            if (this.w == g.SOURCE) {
                f();
                return;
            }
        }
        if ((this.w == g.FINISHED || this.I) && !z2) {
            o();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r0.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        android.os.Trace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r0 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.en1.run():void");
    }

    public final void t() {
        int ordinal = this.x.ordinal();
        if (ordinal == 0) {
            this.w = l(g.INITIALIZE);
            this.G = k();
            r();
        } else if (ordinal == 1) {
            r();
        } else if (ordinal == 2) {
            j();
        } else {
            StringBuilder i0 = hj1.i0("Unrecognized run reason: ");
            i0.append(this.x);
            throw new IllegalStateException(i0.toString());
        }
    }

    public final void w() {
        this.h.a();
        if (!this.H) {
            this.H = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }
}
