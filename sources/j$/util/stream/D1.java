package j$.util.stream;

import a.C0106q0;
import a.C0109s0;
import a.C0113u0;
import j$.util.Spliterator;
import j$.util.function.B;
import j$.util.function.BiConsumer;
import j$.util.function.C;
import j$.util.function.D;
import j$.util.function.E;
import j$.util.function.F;
import j$.util.function.I;
import j$.util.function.J;
import j$.util.function.x;
import j$.util.n;
import j$.util.o;
import j$.util.q;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0196p1;
import j$.util.stream.AbstractC0223w1;
import j$.util.stream.AbstractC0232y2;
import j$.util.stream.R1;
import j$.util.u;
import java.util.Iterator;
import java.util.Objects;

abstract class D1<E_IN> extends AbstractC0164h1<E_IN, Long, H1> implements H1 {

    class a extends AbstractC0196p1.i<Long> {

        /* renamed from: j$.util.stream.D1$a$a  reason: collision with other inner class name */
        class C0033a extends A2.c<Double> {
            C0033a(a aVar, A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                this.f1691a.accept((double) j);
            }
        }

        a(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, u2, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new C0033a(this, a2);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends i<Long> {
        final /* synthetic */ F l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                this.f1691a.accept(b.this.l.applyAsLong(j));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, F f) {
            super(h1Var, u2, i);
            this.l = f;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends AbstractC0232y2.m<Long, U> {
        final /* synthetic */ D l;

        class a extends A2.c<U> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                this.f1691a.accept(c.this.l.apply(j));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, D d) {
            super(h1Var, u2, i);
            this.l = d;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    class d extends i<Long> {
        final /* synthetic */ D l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                H1 h1 = (H1) d.this.l.apply(j);
                if (h1 != null) {
                    try {
                        h1.sequential().f(new P(this));
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
                if (h1 != null) {
                    h1.close();
                    return;
                }
                return;
                throw th;
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public void n(long j) {
                this.f1691a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, D d) {
            super(h1Var, u2, i);
            this.l = d;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    class e extends i<Long> {
        final /* synthetic */ E l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                if (((C0106q0) e.this.l).b(j)) {
                    this.f1691a.accept(j);
                }
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public void n(long j) {
                this.f1691a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, E e) {
            super(h1Var, u2, i);
            this.l = e;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    class f extends i<Long> {
        final /* synthetic */ C l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                f.this.l.accept(j);
                this.f1691a.accept(j);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(D1 d1, AbstractC0164h1 h1Var, U2 u2, int i, C c) {
            super(h1Var, u2, i);
            this.l = c;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public static class g<E_IN> extends D1<E_IN> {
        g(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final A2 G0(int i, A2 a2) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.H1, j$.util.stream.D1
        public void Y(C c) {
            if (!isParallel()) {
                D1.L0(I0()).d(c);
                return;
            }
            Objects.requireNonNull(c);
            w0(new AbstractC0223w1.c(c, true));
        }

        @Override // j$.util.stream.H1, j$.util.stream.D1
        public void f(C c) {
            if (!isParallel()) {
                D1.L0(I0()).d(c);
            } else {
                D1.super.f(c);
            }
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
        public /* bridge */ /* synthetic */ H1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
        public /* bridge */ /* synthetic */ H1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class h<E_IN> extends D1<E_IN> {
        h(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
        public /* bridge */ /* synthetic */ H1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
        public /* bridge */ /* synthetic */ H1 sequential() {
            sequential();
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class i<E_IN> extends D1<E_IN> {
        i(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
        public /* bridge */ /* synthetic */ H1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
        public /* bridge */ /* synthetic */ H1 sequential() {
            sequential();
            return this;
        }
    }

    D1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    D1(AbstractC0164h1 h1Var, int i2) {
        super(h1Var, i2);
    }

    /* access modifiers changed from: private */
    public static Spliterator.c L0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.c) {
            return (Spliterator.c) spliterator;
        }
        if (i3.f1797a) {
            i3.a(AbstractC0164h1.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // j$.util.stream.H1
    public final long A(long j, B b2) {
        Objects.requireNonNull(b2);
        return ((Long) w0(new C0201q2(U2.LONG_VALUE, b2, j))).longValue();
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final U2 A0() {
        return U2.LONG_VALUE;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final Spliterator J0(T1 t1, J j, boolean z) {
        return new b3(t1, j, z);
    }

    @Override // j$.util.stream.H1
    public final Stream N(D d2) {
        Objects.requireNonNull(d2);
        return new c(this, this, U2.LONG_VALUE, T2.p | T2.n, d2);
    }

    @Override // j$.util.stream.H1
    public void Y(C c2) {
        Objects.requireNonNull(c2);
        w0(new AbstractC0223w1.c(c2, true));
    }

    @Override // j$.util.stream.H1
    public final AbstractC0207s1 asDoubleStream() {
        return new a(this, this, U2.LONG_VALUE, T2.p | T2.n);
    }

    @Override // j$.util.stream.H1
    public final o average() {
        long[] jArr = (long[]) d0(V.f1751a, O.f1721a, N.f1718a);
        return jArr[0] > 0 ? o.d(((double) jArr[1]) / ((double) jArr[0])) : o.a();
    }

    @Override // j$.util.stream.H1
    public final boolean b0(E e2) {
        return ((Boolean) w0(Q1.t(e2, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.H1
    public final Stream boxed() {
        return N(C0134a.f1766a);
    }

    @Override // j$.util.stream.H1
    public final boolean c(E e2) {
        return ((Boolean) w0(Q1.t(e2, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.H1
    public final long count() {
        return ((D1) x(U.f1748a)).sum();
    }

    @Override // j$.util.stream.H1
    public final Object d0(J j, I i2, BiConsumer biConsumer) {
        S s = new S(biConsumer);
        Objects.requireNonNull(j);
        Objects.requireNonNull(i2);
        return w0(new U1(U2.LONG_VALUE, s, i2, j));
    }

    @Override // j$.util.stream.H1
    public final H1 distinct() {
        return ((AbstractC0232y2) ((AbstractC0232y2) N(C0134a.f1766a)).distinct()).e0(T.f1743a);
    }

    @Override // j$.util.stream.H1
    public void f(C c2) {
        Objects.requireNonNull(c2);
        w0(new AbstractC0223w1.c(c2, false));
    }

    @Override // j$.util.stream.H1
    public final boolean f0(E e2) {
        return ((Boolean) w0(Q1.t(e2, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.H1
    public final q findAny() {
        return (q) w0(new C0211t1(false, U2.LONG_VALUE, q.a(), Z0.f1764a, C0151e0.f1782a));
    }

    @Override // j$.util.stream.H1
    public final q findFirst() {
        return (q) w0(new C0211t1(true, U2.LONG_VALUE, q.a(), Z0.f1764a, C0151e0.f1782a));
    }

    @Override // j$.util.stream.H1
    public final H1 g0(E e2) {
        Objects.requireNonNull(e2);
        return new e(this, this, U2.LONG_VALUE, T2.t, e2);
    }

    @Override // j$.util.stream.H1
    public final q i(B b2) {
        Objects.requireNonNull(b2);
        return (q) w0(new C0208s2(U2.LONG_VALUE, b2));
    }

    @Override // j$.util.stream.H1, j$.util.stream.AbstractC0180l1
    public final s.c iterator() {
        return u.h(spliterator());
    }

    @Override // j$.util.stream.H1, j$.util.stream.AbstractC0180l1
    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m10iterator() {
        return u.h(spliterator());
    }

    @Override // j$.util.stream.H1
    public final AbstractC0207s1 j(C0109s0 s0Var) {
        Objects.requireNonNull(s0Var);
        return new F1(this, this, U2.LONG_VALUE, T2.p | T2.n, s0Var);
    }

    @Override // j$.util.stream.H1
    public final H1 limit(long j) {
        if (j >= 0) {
            return B2.h(this, 0, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.H1
    public final q max() {
        return i(Y0.f1761a);
    }

    @Override // j$.util.stream.H1
    public final q min() {
        return i(Y.f1760a);
    }

    @Override // j$.util.stream.H1
    public final H1 q(C c2) {
        Objects.requireNonNull(c2);
        return new f(this, this, U2.LONG_VALUE, 0, c2);
    }

    @Override // j$.util.stream.H1
    public final H1 r(D d2) {
        return new d(this, this, U2.LONG_VALUE, T2.p | T2.n | T2.t, d2);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.T1
    public final R1.a s0(long j, x xVar) {
        return S1.q(j);
    }

    @Override // j$.util.stream.H1
    public final H1 skip(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? this : B2.h(this, j, -1);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.H1
    public final H1 sorted() {
        return new L2(this);
    }

    @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.H1, j$.util.stream.AbstractC0180l1
    public final Spliterator.c spliterator() {
        return L0(super.spliterator());
    }

    @Override // j$.util.stream.H1
    public final long sum() {
        return ((Long) w0(new C0201q2(U2.LONG_VALUE, J0.f1710a, 0))).longValue();
    }

    @Override // j$.util.stream.H1
    public final n summaryStatistics() {
        return (n) d0(C0156f1.f1786a, C0183m0.f1808a, C0222w0.f1835a);
    }

    @Override // j$.util.stream.H1
    public final long[] toArray() {
        return (long[]) S1.o((R1.d) x0(Q.f1726a)).e();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public AbstractC0180l1 unordered() {
        return !B0() ? this : new G1(this, this, U2.LONG_VALUE, T2.r);
    }

    @Override // j$.util.stream.H1
    public final C1 w(C0113u0 u0Var) {
        Objects.requireNonNull(u0Var);
        return new E1(this, this, U2.LONG_VALUE, T2.p | T2.n, u0Var);
    }

    @Override // j$.util.stream.H1
    public final H1 x(F f2) {
        Objects.requireNonNull(f2);
        return new b(this, this, U2.LONG_VALUE, T2.p | T2.n, f2);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final R1 y0(T1 t1, Spliterator spliterator, boolean z, x xVar) {
        return S1.h(t1, spliterator, z);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    @Override // j$.util.stream.AbstractC0164h1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0(j$.util.Spliterator r3, j$.util.stream.A2 r4) {
        /*
            r2 = this;
            j$.util.Spliterator$c r3 = L0(r3)
            boolean r0 = r4 instanceof j$.util.function.C
            if (r0 == 0) goto L_0x000c
            r0 = r4
            j$.util.function.C r0 = (j$.util.function.C) r0
            goto L_0x0015
        L_0x000c:
            boolean r0 = j$.util.stream.i3.f1797a
            if (r0 != 0) goto L_0x0022
            j$.util.stream.K0 r0 = new j$.util.stream.K0
            r0.<init>(r4)
        L_0x0015:
            boolean r1 = r4.p()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r3.j(r0)
            if (r1 != 0) goto L_0x0015
        L_0x0021:
            return
        L_0x0022:
            java.lang.Class<j$.util.stream.h1> r3 = j$.util.stream.AbstractC0164h1.class
            java.lang.String r4 = "using LongStream.adapt(Sink<Long> s)"
            j$.util.stream.i3.a(r3, r4)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.D1.z0(j$.util.Spliterator, j$.util.stream.A2):void");
    }
}
