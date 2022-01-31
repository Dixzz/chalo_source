package defpackage;

import com.crashlytics.android.answers.AnswersPreferenceManager;
import defpackage.ol6;
import defpackage.xk6;
import defpackage.yk6;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: pk6  reason: default package */
/* compiled from: Http2Connection.kt */
public final class pk6 implements Closeable {
    public static final dl6 H;
    public static final pk6 I = null;
    public long A;
    public long B;
    public long C;
    public final Socket D;
    public final zk6 E;
    public final d F;
    public final Set<Integer> G;
    public final boolean f;
    public final c g;
    public final Map<Integer, yk6> h = new LinkedHashMap();
    public final String i;
    public int j;
    public int k;
    public boolean l;
    public final ij6 m;
    public final hj6 n;
    public final hj6 o;
    public final hj6 p;
    public final cl6 q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public final dl6 x;
    public dl6 y;
    public long z;

    /* renamed from: pk6$a */
    /* compiled from: TaskQueue.kt */
    public static final class a extends fj6 {
        public final /* synthetic */ pk6 e;
        public final /* synthetic */ long f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, pk6 pk6, long j) {
            super(str2, true);
            this.e = pk6;
            this.f = j;
        }

        @Override // defpackage.fj6
        public long a() {
            pk6 pk6;
            boolean z;
            synchronized (this.e) {
                pk6 = this.e;
                long j = pk6.s;
                long j2 = pk6.r;
                if (j < j2) {
                    z = true;
                } else {
                    pk6.r = j2 + 1;
                    z = false;
                }
            }
            if (z) {
                lk6 lk6 = lk6.PROTOCOL_ERROR;
                pk6.c(lk6, lk6, null);
                return -1;
            }
            pk6.k(false, 1, 0);
            return this.f;
        }
    }

    /* renamed from: pk6$b */
    /* compiled from: Http2Connection.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Socket f2817a;
        public String b;
        public ym6 c;
        public xm6 d;
        public c e = c.f2818a;
        public cl6 f = cl6.f582a;
        public int g;
        public boolean h;
        public final ij6 i;

        public b(boolean z, ij6 ij6) {
            n86.f(ij6, "taskRunner");
            this.h = z;
            this.i = ij6;
        }
    }

    /* renamed from: pk6$c */
    /* compiled from: Http2Connection.kt */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f2818a = new a();

        /* renamed from: pk6$c$a */
        /* compiled from: Http2Connection.kt */
        public static final class a extends c {
            @Override // defpackage.pk6.c
            public void b(yk6 yk6) throws IOException {
                n86.f(yk6, "stream");
                yk6.c(lk6.REFUSED_STREAM, null);
            }
        }

        public void a(pk6 pk6, dl6 dl6) {
            n86.f(pk6, "connection");
            n86.f(dl6, AnswersPreferenceManager.PREF_STORE_NAME);
        }

        public abstract void b(yk6 yk6) throws IOException;
    }

    /* renamed from: pk6$d */
    /* compiled from: Http2Connection.kt */
    public final class d implements xk6.b, h76<s56> {
        public final xk6 f;
        public final /* synthetic */ pk6 g;

        /* renamed from: pk6$d$a */
        /* compiled from: TaskQueue.kt */
        public static final class a extends fj6 {
            public final /* synthetic */ yk6 e;
            public final /* synthetic */ d f;
            public final /* synthetic */ List g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z, String str2, boolean z2, yk6 yk6, d dVar, yk6 yk62, int i, List list, boolean z3) {
                super(str2, z2);
                this.e = yk6;
                this.f = dVar;
                this.g = list;
            }

            @Override // defpackage.fj6
            public long a() {
                try {
                    this.f.g.g.b(this.e);
                    return -1;
                } catch (IOException e2) {
                    ol6.a aVar = ol6.c;
                    ol6 ol6 = ol6.f2709a;
                    StringBuilder i0 = hj1.i0("Http2Connection.Listener failure for ");
                    i0.append(this.f.g.i);
                    ol6.i(i0.toString(), 4, e2);
                    try {
                        this.e.c(lk6.PROTOCOL_ERROR, e2);
                        return -1;
                    } catch (IOException unused) {
                        return -1;
                    }
                }
            }
        }

        /* renamed from: pk6$d$b */
        /* compiled from: TaskQueue.kt */
        public static final class b extends fj6 {
            public final /* synthetic */ d e;
            public final /* synthetic */ int f;
            public final /* synthetic */ int g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z, String str2, boolean z2, d dVar, int i, int i2) {
                super(str2, z2);
                this.e = dVar;
                this.f = i;
                this.g = i2;
            }

            @Override // defpackage.fj6
            public long a() {
                this.e.g.k(true, this.f, this.g);
                return -1;
            }
        }

        /* renamed from: pk6$d$c */
        /* compiled from: TaskQueue.kt */
        public static final class c extends fj6 {
            public final /* synthetic */ d e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ dl6 g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z, String str2, boolean z2, d dVar, boolean z3, dl6 dl6) {
                super(str2, z2);
                this.e = dVar;
                this.f = z3;
                this.g = dl6;
            }

            /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
            /* JADX WARNING: Removed duplicated region for block: B:61:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
            @Override // defpackage.fj6
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public long a() {
                /*
                // Method dump skipped, instructions count: 288
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.pk6.d.c.a():long");
            }
        }

        public d(pk6 pk6, xk6 xk6) {
            n86.f(xk6, "reader");
            this.g = pk6;
            this.f = xk6;
        }

        @Override // defpackage.xk6.b
        public void a() {
        }

        @Override // defpackage.xk6.b
        public void c(boolean z, dl6 dl6) {
            n86.f(dl6, AnswersPreferenceManager.PREF_STORE_NAME);
            hj6 hj6 = this.g.n;
            String a0 = hj1.a0(new StringBuilder(), this.g.i, " applyAndAckSettings");
            hj6.c(new c(a0, true, a0, true, this, z, dl6), 0);
        }

        @Override // defpackage.xk6.b
        public void d(boolean z, int i, int i2, List<mk6> list) {
            n86.f(list, "headerBlock");
            if (this.g.f(i)) {
                pk6 pk6 = this.g;
                Objects.requireNonNull(pk6);
                n86.f(list, "requestHeaders");
                String str = pk6.i + '[' + i + "] onHeaders";
                pk6.o.c(new sk6(str, true, str, true, pk6, i, list, z), 0);
                return;
            }
            synchronized (this.g) {
                yk6 e = this.g.e(i);
                if (e == null) {
                    pk6 pk62 = this.g;
                    if (!pk62.l) {
                        if (i > pk62.j) {
                            if (i % 2 != pk62.k % 2) {
                                yk6 yk6 = new yk6(i, this.g, false, z, vi6.v(list));
                                pk6 pk63 = this.g;
                                pk63.j = i;
                                pk63.h.put(Integer.valueOf(i), yk6);
                                String str2 = this.g.i + '[' + i + "] onStream";
                                this.g.m.f().c(new a(str2, true, str2, true, yk6, this, e, i, list, z), 0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                e.j(vi6.v(list), z);
            }
        }

        @Override // defpackage.xk6.b
        public void f(int i, long j) {
            if (i == 0) {
                synchronized (this.g) {
                    pk6 pk6 = this.g;
                    pk6.C += j;
                    pk6.notifyAll();
                }
                return;
            }
            yk6 e = this.g.e(i);
            if (e != null) {
                synchronized (e) {
                    e.d += j;
                    if (j > 0) {
                        e.notifyAll();
                    }
                }
            }
        }

        @Override // defpackage.xk6.b
        public void g(boolean z, int i, ym6 ym6, int i2) throws IOException {
            boolean z2;
            boolean z3;
            long j;
            n86.f(ym6, "source");
            if (this.g.f(i)) {
                pk6 pk6 = this.g;
                Objects.requireNonNull(pk6);
                n86.f(ym6, "source");
                vm6 vm6 = new vm6();
                long j2 = (long) i2;
                ym6.e1(j2);
                ym6.read(vm6, j2);
                String str = pk6.i + '[' + i + "] onData";
                pk6.o.c(new rk6(str, true, str, true, pk6, i, vm6, i2, z), 0);
                return;
            }
            yk6 e = this.g.e(i);
            if (e == null) {
                this.g.l(i, lk6.PROTOCOL_ERROR);
                long j3 = (long) i2;
                this.g.i(j3);
                ym6.d(j3);
                return;
            }
            n86.f(ym6, "source");
            byte[] bArr = vi6.f3652a;
            yk6.b bVar = e.g;
            long j4 = (long) i2;
            Objects.requireNonNull(bVar);
            n86.f(ym6, "source");
            while (true) {
                boolean z4 = true;
                if (j4 <= 0) {
                    break;
                }
                synchronized (yk6.this) {
                    z2 = bVar.j;
                    z3 = bVar.g.g + j4 > bVar.i;
                }
                if (z3) {
                    ym6.d(j4);
                    yk6.this.e(lk6.FLOW_CONTROL_ERROR);
                    break;
                } else if (z2) {
                    ym6.d(j4);
                    break;
                } else {
                    long read = ym6.read(bVar.f, j4);
                    if (read != -1) {
                        j4 -= read;
                        synchronized (yk6.this) {
                            if (bVar.h) {
                                vm6 vm62 = bVar.f;
                                j = vm62.g;
                                vm62.d(j);
                            } else {
                                vm6 vm63 = bVar.g;
                                if (vm63.g != 0) {
                                    z4 = false;
                                }
                                vm63.t0(bVar.f);
                                if (z4) {
                                    yk6 yk6 = yk6.this;
                                    if (yk6 != null) {
                                        yk6.notifyAll();
                                    } else {
                                        throw new p56("null cannot be cast to non-null type java.lang.Object");
                                    }
                                }
                                j = 0;
                            }
                        }
                        if (j > 0) {
                            bVar.a(j);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (z) {
                e.j(vi6.b, true);
            }
        }

        @Override // defpackage.xk6.b
        public void h(boolean z, int i, int i2) {
            if (z) {
                synchronized (this.g) {
                    if (i == 1) {
                        this.g.s++;
                    } else if (i == 2) {
                        this.g.u++;
                    } else if (i == 3) {
                        pk6 pk6 = this.g;
                        pk6.v++;
                        pk6.notifyAll();
                    }
                }
                return;
            }
            hj6 hj6 = this.g.n;
            String a0 = hj1.a0(new StringBuilder(), this.g.i, " ping");
            hj6.c(new b(a0, true, a0, true, this, i, i2), 0);
        }

        @Override // defpackage.xk6.b
        public void i(int i, int i2, int i3, boolean z) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public s56 invoke() {
            Throwable th;
            lk6 lk6;
            lk6 lk62 = lk6.INTERNAL_ERROR;
            IOException e = null;
            try {
                this.f.c(this);
                while (this.f.a(false, this)) {
                }
                lk6 = lk6.NO_ERROR;
                try {
                    this.g.c(lk6, lk6.CANCEL, null);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        lk6 lk63 = lk6.PROTOCOL_ERROR;
                        this.g.c(lk63, lk63, e);
                        vi6.c(this.f);
                        return s56.f3190a;
                    } catch (Throwable th2) {
                        th = th2;
                        this.g.c(lk6, lk62, e);
                        vi6.c(this.f);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                lk6 = lk62;
                lk6 lk632 = lk6.PROTOCOL_ERROR;
                this.g.c(lk632, lk632, e);
                vi6.c(this.f);
                return s56.f3190a;
            } catch (Throwable th3) {
                th = th3;
                lk6 = lk62;
                this.g.c(lk6, lk62, e);
                vi6.c(this.f);
                throw th;
            }
            vi6.c(this.f);
            return s56.f3190a;
        }

        @Override // defpackage.xk6.b
        public void j(int i, lk6 lk6) {
            n86.f(lk6, "errorCode");
            if (this.g.f(i)) {
                pk6 pk6 = this.g;
                Objects.requireNonNull(pk6);
                n86.f(lk6, "errorCode");
                String str = pk6.i + '[' + i + "] onReset";
                pk6.o.c(new uk6(str, true, str, true, pk6, i, lk6), 0);
                return;
            }
            yk6 g2 = this.g.g(i);
            if (g2 != null) {
                g2.k(lk6);
            }
        }

        @Override // defpackage.xk6.b
        public void k(int i, int i2, List<mk6> list) {
            n86.f(list, "requestHeaders");
            pk6 pk6 = this.g;
            Objects.requireNonNull(pk6);
            n86.f(list, "requestHeaders");
            synchronized (pk6) {
                if (pk6.G.contains(Integer.valueOf(i2))) {
                    pk6.l(i2, lk6.PROTOCOL_ERROR);
                    return;
                }
                pk6.G.add(Integer.valueOf(i2));
                String str = pk6.i + '[' + i2 + "] onRequest";
                pk6.o.c(new tk6(str, true, str, true, pk6, i2, list), 0);
            }
        }

        @Override // defpackage.xk6.b
        public void l(int i, lk6 lk6, zm6 zm6) {
            int i2;
            yk6[] yk6Arr;
            n86.f(lk6, "errorCode");
            n86.f(zm6, "debugData");
            zm6.g();
            synchronized (this.g) {
                Object[] array = this.g.h.values().toArray(new yk6[0]);
                if (array != null) {
                    yk6Arr = (yk6[]) array;
                    this.g.l = true;
                } else {
                    throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (yk6 yk6 : yk6Arr) {
                if (yk6.m > i && yk6.h()) {
                    yk6.k(lk6.REFUSED_STREAM);
                    this.g.g(yk6.m);
                }
            }
        }
    }

    /* renamed from: pk6$e */
    /* compiled from: TaskQueue.kt */
    public static final class e extends fj6 {
        public final /* synthetic */ pk6 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ lk6 g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z, String str2, boolean z2, pk6 pk6, int i, lk6 lk6) {
            super(str2, z2);
            this.e = pk6;
            this.f = i;
            this.g = lk6;
        }

        @Override // defpackage.fj6
        public long a() {
            try {
                pk6 pk6 = this.e;
                int i = this.f;
                lk6 lk6 = this.g;
                Objects.requireNonNull(pk6);
                n86.f(lk6, "statusCode");
                pk6.E.i(i, lk6);
                return -1;
            } catch (IOException e2) {
                pk6.a(this.e, e2);
                return -1;
            }
        }
    }

    /* renamed from: pk6$f */
    /* compiled from: TaskQueue.kt */
    public static final class f extends fj6 {
        public final /* synthetic */ pk6 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z, String str2, boolean z2, pk6 pk6, int i, long j) {
            super(str2, z2);
            this.e = pk6;
            this.f = i;
            this.g = j;
        }

        @Override // defpackage.fj6
        public long a() {
            try {
                this.e.E.j(this.f, this.g);
                return -1;
            } catch (IOException e2) {
                pk6.a(this.e, e2);
                return -1;
            }
        }
    }

    static {
        dl6 dl6 = new dl6();
        dl6.c(7, 65535);
        dl6.c(5, 16384);
        H = dl6;
    }

    public pk6(b bVar) {
        n86.f(bVar, "builder");
        boolean z2 = bVar.h;
        this.f = z2;
        this.g = bVar.e;
        String str = bVar.b;
        if (str != null) {
            this.i = str;
            this.k = bVar.h ? 3 : 2;
            ij6 ij6 = bVar.i;
            this.m = ij6;
            hj6 f2 = ij6.f();
            this.n = f2;
            this.o = ij6.f();
            this.p = ij6.f();
            this.q = bVar.f;
            dl6 dl6 = new dl6();
            if (bVar.h) {
                dl6.c(7, 16777216);
            }
            this.x = dl6;
            dl6 dl62 = H;
            this.y = dl62;
            this.C = (long) dl62.a();
            Socket socket = bVar.f2817a;
            if (socket != null) {
                this.D = socket;
                xm6 xm6 = bVar.d;
                if (xm6 != null) {
                    this.E = new zk6(xm6, z2);
                    ym6 ym6 = bVar.c;
                    if (ym6 != null) {
                        this.F = new d(this, new xk6(ym6, z2));
                        this.G = new LinkedHashSet();
                        int i2 = bVar.g;
                        if (i2 != 0) {
                            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i2);
                            String S = hj1.S(str, " ping");
                            f2.c(new a(S, S, this, nanos), nanos);
                            return;
                        }
                        return;
                    }
                    n86.l("source");
                    throw null;
                }
                n86.l("sink");
                throw null;
            }
            n86.l("socket");
            throw null;
        }
        n86.l("connectionName");
        throw null;
    }

    public static final void a(pk6 pk6, IOException iOException) {
        Objects.requireNonNull(pk6);
        lk6 lk6 = lk6.PROTOCOL_ERROR;
        pk6.c(lk6, lk6, iOException);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|(2:1|2)|3|10|(2:16|(5:18|19|20|33|21))|23|24|25|26|27|29) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(defpackage.lk6 r4, defpackage.lk6 r5, java.io.IOException r6) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pk6.c(lk6, lk6, java.io.IOException):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c(lk6.NO_ERROR, lk6.CANCEL, null);
    }

    public final synchronized yk6 e(int i2) {
        return this.h.get(Integer.valueOf(i2));
    }

    public final boolean f(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final synchronized yk6 g(int i2) {
        yk6 remove;
        remove = this.h.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public final void h(lk6 lk6) throws IOException {
        n86.f(lk6, "statusCode");
        synchronized (this.E) {
            synchronized (this) {
                if (!this.l) {
                    this.l = true;
                    this.E.f(this.j, lk6, vi6.f3652a);
                }
            }
        }
    }

    public final synchronized void i(long j2) {
        long j3 = this.z + j2;
        this.z = j3;
        long j4 = j3 - this.A;
        if (j4 >= ((long) (this.x.a() / 2))) {
            m(0, j4);
            this.A += j4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.E.g);
        r6 = (long) r3;
        r8.B += r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(int r9, boolean r10, defpackage.vm6 r11, long r12) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pk6.j(int, boolean, vm6, long):void");
    }

    public final void k(boolean z2, int i2, int i3) {
        try {
            this.E.h(z2, i2, i3);
        } catch (IOException e2) {
            lk6 lk6 = lk6.PROTOCOL_ERROR;
            c(lk6, lk6, e2);
        }
    }

    public final void l(int i2, lk6 lk6) {
        n86.f(lk6, "errorCode");
        String str = this.i + '[' + i2 + "] writeSynReset";
        this.n.c(new e(str, true, str, true, this, i2, lk6), 0);
    }

    public final void m(int i2, long j2) {
        String str = this.i + '[' + i2 + "] windowUpdate";
        this.n.c(new f(str, true, str, true, this, i2, j2), 0);
    }
}
