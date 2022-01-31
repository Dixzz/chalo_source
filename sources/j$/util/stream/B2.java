package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0196p1;
import j$.util.stream.AbstractC0232y2;
import j$.util.stream.AbstractC0235z1;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.stream.c3;
import j$.util.stream.d3;

final class B2 {

    /* access modifiers changed from: package-private */
    public class a extends AbstractC0232y2.l<T, T> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        /* renamed from: j$.util.stream.B2$a$a  reason: collision with other inner class name */
        class C0032a extends A2.d<T, T> {
            long b;
            long c;

            C0032a(A2 a2) {
                super(a2);
                this.b = a.this.l;
                long j = a.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                long j = this.b;
                if (j == 0) {
                    long j2 = this.c;
                    if (j2 > 0) {
                        this.c = j2 - 1;
                        this.f1692a.accept(obj);
                        return;
                    }
                    return;
                }
                this.b = j - 1;
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void n(long j) {
                this.f1692a.n(B2.c(j, a.this.l, this.c));
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public boolean p() {
                return this.c == 0 || this.f1692a.p();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AbstractC0164h1 h1Var, U2 u2, int i, long j, long j2) {
            super(h1Var, u2, i);
            this.l = j;
            this.m = j2;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    return S1.e(t1, B2.b(t1.q0(), spliterator, this.l, this.m), true, xVar);
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? S1.e(this, K0(t1.v0(spliterator), this.l, this.m, p0), true, xVar) : (R1) new e(this, t1, spliterator, xVar, this.l, this.m).invoke();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public Spliterator E0(T1 t1, Spliterator spliterator) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    Spliterator v0 = t1.v0(spliterator);
                    long j = this.l;
                    return new c3.e(v0, j, B2.d(j, this.m));
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? K0(t1.v0(spliterator), this.l, this.m, p0) : ((R1) new e(this, t1, spliterator, C0210t0.f1825a, this.l, this.m).invoke()).spliterator();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new C0032a(a2);
        }

        /* access modifiers changed from: package-private */
        public Spliterator K0(Spliterator spliterator, long j, long j2, long j3) {
            long j4;
            long j5;
            if (j <= j3) {
                long j6 = j3 - j;
                j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                j5 = 0;
            } else {
                j5 = j;
                j4 = j2;
            }
            return new d3.e(spliterator, j5, j4);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends AbstractC0235z1.j<Integer> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        class a extends A2.b<Integer> {
            long b;
            long c;

            a(A2 a2) {
                super(a2);
                this.b = b.this.l;
                long j = b.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                long j = this.b;
                if (j == 0) {
                    long j2 = this.c;
                    if (j2 > 0) {
                        this.c = j2 - 1;
                        this.f1690a.accept(i);
                        return;
                    }
                    return;
                }
                this.b = j - 1;
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public void n(long j) {
                this.f1690a.n(B2.c(j, b.this.l, this.c));
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public boolean p() {
                return this.c == 0 || this.f1690a.p();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AbstractC0164h1 h1Var, U2 u2, int i, long j, long j2) {
            super(h1Var, u2, i);
            this.l = j;
            this.m = j2;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    return S1.g(t1, B2.b(t1.q0(), spliterator, this.l, this.m), true);
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? S1.g(this, M0((Spliterator.b) t1.v0(spliterator), this.l, this.m, p0), true) : (R1) new e(this, t1, spliterator, xVar, this.l, this.m).invoke();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public Spliterator E0(T1 t1, Spliterator spliterator) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    long j = this.l;
                    return new c3.b((Spliterator.b) t1.v0(spliterator), j, B2.d(j, this.m));
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? M0((Spliterator.b) t1.v0(spliterator), this.l, this.m, p0) : ((R1) new e(this, t1, spliterator, C0206s0.f1823a, this.l, this.m).invoke()).spliterator();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }

        /* access modifiers changed from: package-private */
        public Spliterator.b M0(Spliterator.b bVar, long j, long j2, long j3) {
            long j4;
            long j5;
            if (j <= j3) {
                long j6 = j3 - j;
                j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                j5 = 0;
            } else {
                j5 = j;
                j4 = j2;
            }
            return new d3.b(bVar, j5, j4);
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends D1.h<Long> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        class a extends A2.c<Long> {
            long b;
            long c;

            a(A2 a2) {
                super(a2);
                this.b = c.this.l;
                long j = c.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                long j2 = this.b;
                if (j2 == 0) {
                    long j3 = this.c;
                    if (j3 > 0) {
                        this.c = j3 - 1;
                        this.f1691a.accept(j);
                        return;
                    }
                    return;
                }
                this.b = j2 - 1;
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public void n(long j) {
                this.f1691a.n(B2.c(j, c.this.l, this.c));
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public boolean p() {
                return this.c == 0 || this.f1691a.p();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AbstractC0164h1 h1Var, U2 u2, int i, long j, long j2) {
            super(h1Var, u2, i);
            this.l = j;
            this.m = j2;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    return S1.h(t1, B2.b(t1.q0(), spliterator, this.l, this.m), true);
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? S1.h(this, M0((Spliterator.c) t1.v0(spliterator), this.l, this.m, p0), true) : (R1) new e(this, t1, spliterator, xVar, this.l, this.m).invoke();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public Spliterator E0(T1 t1, Spliterator spliterator) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    long j = this.l;
                    return new c3.c((Spliterator.c) t1.v0(spliterator), j, B2.d(j, this.m));
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? M0((Spliterator.c) t1.v0(spliterator), this.l, this.m, p0) : ((R1) new e(this, t1, spliterator, C0214u0.f1829a, this.l, this.m).invoke()).spliterator();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }

        /* access modifiers changed from: package-private */
        public Spliterator.c M0(Spliterator.c cVar, long j, long j2, long j3) {
            long j4;
            long j5;
            if (j <= j3) {
                long j6 = j3 - j;
                j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                j5 = 0;
            } else {
                j5 = j;
                j4 = j2;
            }
            return new d3.c(cVar, j5, j4);
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends AbstractC0196p1.h<Double> {
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        class a extends A2.a<Double> {
            long b;
            long c;

            a(A2 a2) {
                super(a2);
                this.b = d.this.l;
                long j = d.this.m;
                this.c = j < 0 ? Long.MAX_VALUE : j;
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                long j = this.b;
                if (j == 0) {
                    long j2 = this.c;
                    if (j2 > 0) {
                        this.c = j2 - 1;
                        this.f1689a.accept(d2);
                        return;
                    }
                    return;
                }
                this.b = j - 1;
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public void n(long j) {
                this.f1689a.n(B2.c(j, d.this.l, this.c));
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public boolean p() {
                return this.c == 0 || this.f1689a.p();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AbstractC0164h1 h1Var, U2 u2, int i, long j, long j2) {
            super(h1Var, u2, i);
            this.l = j;
            this.m = j2;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public R1 D0(T1 t1, Spliterator spliterator, x xVar) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    return S1.f(t1, B2.b(t1.q0(), spliterator, this.l, this.m), true);
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? S1.f(this, M0((Spliterator.a) t1.v0(spliterator), this.l, this.m, p0), true) : (R1) new e(this, t1, spliterator, xVar, this.l, this.m).invoke();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public Spliterator E0(T1 t1, Spliterator spliterator) {
            long p0 = t1.p0(spliterator);
            if (p0 > 0) {
                if (spliterator.hasCharacteristics(16384)) {
                    long j = this.l;
                    return new c3.a((Spliterator.a) t1.v0(spliterator), j, B2.d(j, this.m));
                }
            }
            return !T2.ORDERED.n(t1.r0()) ? M0((Spliterator.a) t1.v0(spliterator), this.l, this.m, p0) : ((R1) new e(this, t1, spliterator, C0218v0.f1832a, this.l, this.m).invoke()).spliterator();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }

        /* access modifiers changed from: package-private */
        public Spliterator.a M0(Spliterator.a aVar, long j, long j2, long j3) {
            long j4;
            long j5;
            if (j <= j3) {
                long j6 = j3 - j;
                j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                j5 = 0;
            } else {
                j5 = j;
                j4 = j2;
            }
            return new d3.a(aVar, j5, j4);
        }
    }

    private static final class e<P_IN, P_OUT> extends AbstractC0168i1<P_IN, P_OUT, R1<P_OUT>, e<P_IN, P_OUT>> {
        private final AbstractC0164h1 j;
        private final x k;
        private final long l;
        private final long m;
        private long n;
        private volatile boolean o;

        e(e eVar, Spliterator spliterator) {
            super(eVar, spliterator);
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
        }

        e(AbstractC0164h1 h1Var, T1 t1, Spliterator spliterator, x xVar, long j2, long j3) {
            super(t1, spliterator);
            this.j = h1Var;
            this.k = xVar;
            this.l = j2;
            this.m = j3;
        }

        private long m(long j2) {
            if (this.o) {
                return this.n;
            }
            e eVar = (e) this.d;
            e eVar2 = (e) this.e;
            if (eVar == null || eVar2 == null) {
                return this.n;
            }
            long m2 = eVar.m(j2);
            return m2 >= j2 ? m2 : m2 + eVar2.m(j2);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0176k1
        public Object a() {
            long j2 = -1;
            if (e()) {
                if (T2.SIZED.t(this.j.c)) {
                    j2 = this.j.p0(this.b);
                }
                R1.a s0 = this.j.s0(j2, this.k);
                A2 G0 = this.j.G0(this.f1803a.r0(), s0);
                T1 t1 = this.f1803a;
                t1.n0(t1.u0(G0), this.b);
                return s0.a();
            }
            T1 t12 = this.f1803a;
            R1.a s02 = t12.s0(-1, this.k);
            t12.t0(s02, this.b);
            R1 a2 = s02.a();
            this.n = a2.count();
            this.o = true;
            this.b = null;
            return a2;
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0176k1
        public AbstractC0176k1 f(Spliterator spliterator) {
            return new e(this, spliterator);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0168i1
        public void i() {
            this.i = true;
            if (this.o) {
                g(k());
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public final R1 k() {
            return S1.k(this.j.A0());
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
        @Override // j$.util.stream.AbstractC0176k1, java.util.concurrent.CountedCompleter
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
            /*
            // Method dump skipped, instructions count: 228
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.B2.e.onCompletion(java.util.concurrent.CountedCompleter):void");
        }
    }

    static Spliterator b(U2 u2, Spliterator spliterator, long j, long j2) {
        long d2 = d(j, j2);
        int ordinal = u2.ordinal();
        if (ordinal == 0) {
            return new c3.e(spliterator, j, d2);
        }
        if (ordinal == 1) {
            return new c3.b((Spliterator.b) spliterator, j, d2);
        }
        if (ordinal == 2) {
            return new c3.c((Spliterator.c) spliterator, j, d2);
        }
        if (ordinal == 3) {
            return new c3.a((Spliterator.a) spliterator, j, d2);
        }
        throw new IllegalStateException("Unknown shape " + u2);
    }

    static long c(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static long d(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    private static int e(long j) {
        return (j != -1 ? T2.u : 0) | T2.t;
    }

    public static AbstractC0207s1 f(AbstractC0164h1 h1Var, long j, long j2) {
        if (j >= 0) {
            return new d(h1Var, U2.DOUBLE_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static C1 g(AbstractC0164h1 h1Var, long j, long j2) {
        if (j >= 0) {
            return new b(h1Var, U2.INT_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static H1 h(AbstractC0164h1 h1Var, long j, long j2) {
        if (j >= 0) {
            return new c(h1Var, U2.LONG_VALUE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static Stream i(AbstractC0164h1 h1Var, long j, long j2) {
        if (j >= 0) {
            return new a(h1Var, U2.REFERENCE, e(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }
}
