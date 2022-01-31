package j$.util.stream;

import a.C0078c0;
import a.C0082e0;
import a.C0090i0;
import j$.util.Spliterator;
import j$.util.function.A;
import j$.util.function.BiConsumer;
import j$.util.function.H;
import j$.util.function.J;
import j$.util.function.v;
import j$.util.function.w;
import j$.util.function.x;
import j$.util.function.y;
import j$.util.function.z;
import j$.util.m;
import j$.util.o;
import j$.util.p;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0196p1;
import j$.util.stream.AbstractC0223w1;
import j$.util.stream.AbstractC0232y2;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.u;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: j$.util.stream.z1  reason: case insensitive filesystem */
abstract class AbstractC0235z1<E_IN> extends AbstractC0164h1<E_IN, Integer, C1> implements C1 {

    /* renamed from: j$.util.stream.z1$a */
    class a extends D1.i<Integer> {

        /* renamed from: j$.util.stream.z1$a$a  reason: collision with other inner class name */
        class C0037a extends A2.b<Long> {
            C0037a(a aVar, A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                this.f1690a.accept((long) i);
            }
        }

        a(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, u2, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new C0037a(this, a2);
        }
    }

    /* renamed from: j$.util.stream.z1$b */
    class b extends k<Integer> {
        final /* synthetic */ w l;

        /* renamed from: j$.util.stream.z1$b$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                b.this.l.accept(i);
                this.f1690a.accept(i);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, w wVar) {
            super(h1Var, u2, i);
            this.l = wVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.z1$c */
    class c extends AbstractC0196p1.i<Integer> {

        /* renamed from: j$.util.stream.z1$c$a */
        class a extends A2.b<Double> {
            a(c cVar, A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                this.f1690a.accept((double) i);
            }
        }

        c(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, u2, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(this, a2);
        }
    }

    /* renamed from: j$.util.stream.z1$d */
    class d extends k<Integer> {
        final /* synthetic */ A l;

        /* renamed from: j$.util.stream.z1$d$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                this.f1690a.accept(((C0090i0) d.this.l).a(i));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, A a2) {
            super(h1Var, u2, i);
            this.l = a2;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.z1$e */
    public class e extends AbstractC0232y2.m<Integer, U> {
        final /* synthetic */ x l;

        /* renamed from: j$.util.stream.z1$e$a */
        class a extends A2.b<U> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                this.f1690a.accept(e.this.l.apply(i));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, x xVar) {
            super(h1Var, u2, i);
            this.l = xVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.z1$f */
    public class f extends D1.i<Integer> {
        final /* synthetic */ z l;

        /* renamed from: j$.util.stream.z1$f$a */
        class a extends A2.b<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                this.f1690a.accept(f.this.l.applyAsLong(i));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, z zVar) {
            super(h1Var, u2, i);
            this.l = zVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.z1$g */
    class g extends k<Integer> {
        final /* synthetic */ x l;

        /* renamed from: j$.util.stream.z1$g$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                C1 c1 = (C1) g.this.l.apply(i);
                if (c1 != null) {
                    try {
                        c1.sequential().Q(new F(this));
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
                if (c1 != null) {
                    c1.close();
                    return;
                }
                return;
                throw th;
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public void n(long j) {
                this.f1690a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, x xVar) {
            super(h1Var, u2, i);
            this.l = xVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.z1$h */
    class h extends k<Integer> {
        final /* synthetic */ y l;

        /* renamed from: j$.util.stream.z1$h$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                if (((C0078c0) h.this.l).b(i)) {
                    this.f1690a.accept(i);
                }
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public void n(long j) {
                this.f1690a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AbstractC0235z1 z1Var, AbstractC0164h1 h1Var, U2 u2, int i, y yVar) {
            super(h1Var, u2, i);
            this.l = yVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.z1$i */
    public static class i<E_IN> extends AbstractC0235z1<E_IN> {
        i(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // j$.util.stream.AbstractC0235z1, j$.util.stream.C1
        public void E(w wVar) {
            if (!isParallel()) {
                AbstractC0235z1.L0(I0()).c(wVar);
                return;
            }
            Objects.requireNonNull(wVar);
            w0(new AbstractC0223w1.b(wVar, true));
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

        @Override // j$.util.stream.AbstractC0235z1, j$.util.stream.C1
        public void Q(w wVar) {
            if (!isParallel()) {
                AbstractC0235z1.L0(I0()).c(wVar);
            } else {
                AbstractC0235z1.super.Q(wVar);
            }
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
        public /* bridge */ /* synthetic */ C1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
        public /* bridge */ /* synthetic */ C1 sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.z1$j */
    static abstract class j<E_IN> extends AbstractC0235z1<E_IN> {
        j(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
        public /* bridge */ /* synthetic */ C1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
        public /* bridge */ /* synthetic */ C1 sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.z1$k */
    static abstract class k<E_IN> extends AbstractC0235z1<E_IN> {
        k(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
        public /* bridge */ /* synthetic */ C1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
        public /* bridge */ /* synthetic */ C1 sequential() {
            sequential();
            return this;
        }
    }

    AbstractC0235z1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0235z1(AbstractC0164h1 h1Var, int i2) {
        super(h1Var, i2);
    }

    /* access modifiers changed from: private */
    public static Spliterator.b L0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.b) {
            return (Spliterator.b) spliterator;
        }
        if (i3.f1797a) {
            i3.a(AbstractC0164h1.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final U2 A0() {
        return U2.INT_VALUE;
    }

    @Override // j$.util.stream.C1
    public void E(w wVar) {
        Objects.requireNonNull(wVar);
        w0(new AbstractC0223w1.b(wVar, true));
    }

    @Override // j$.util.stream.C1
    public final Stream F(x xVar) {
        Objects.requireNonNull(xVar);
        return new e(this, this, U2.INT_VALUE, T2.p | T2.n, xVar);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final Spliterator J0(T1 t1, J j2, boolean z) {
        return new a3(t1, j2, z);
    }

    @Override // j$.util.stream.C1
    public final int K(int i2, v vVar) {
        Objects.requireNonNull(vVar);
        return ((Integer) w0(new C0177k2(U2.INT_VALUE, vVar, i2))).intValue();
    }

    @Override // j$.util.stream.C1
    public final boolean L(y yVar) {
        return ((Boolean) w0(Q1.s(yVar, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.C1
    public final C1 M(x xVar) {
        return new g(this, this, U2.INT_VALUE, T2.p | T2.n | T2.t, xVar);
    }

    @Override // j$.util.stream.C1
    public void Q(w wVar) {
        Objects.requireNonNull(wVar);
        w0(new AbstractC0223w1.b(wVar, false));
    }

    @Override // j$.util.stream.C1
    public final boolean R(y yVar) {
        return ((Boolean) w0(Q1.s(yVar, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.C1
    public final C1 X(y yVar) {
        Objects.requireNonNull(yVar);
        return new h(this, this, U2.INT_VALUE, T2.t, yVar);
    }

    @Override // j$.util.stream.C1
    public final p Z(v vVar) {
        Objects.requireNonNull(vVar);
        return (p) w0(new C0185m2(U2.INT_VALUE, vVar));
    }

    @Override // j$.util.stream.C1
    public final C1 a0(w wVar) {
        Objects.requireNonNull(wVar);
        return new b(this, this, U2.INT_VALUE, 0, wVar);
    }

    @Override // j$.util.stream.C1
    public final AbstractC0207s1 asDoubleStream() {
        return new c(this, this, U2.INT_VALUE, T2.p | T2.n);
    }

    @Override // j$.util.stream.C1
    public final H1 asLongStream() {
        return new a(this, this, U2.INT_VALUE, T2.p | T2.n);
    }

    @Override // j$.util.stream.C1
    public final o average() {
        long[] jArr = (long[]) j0(E.f1699a, L.f1713a, K.f1711a);
        return jArr[0] > 0 ? o.d(((double) jArr[1]) / ((double) jArr[0])) : o.a();
    }

    @Override // j$.util.stream.C1
    public final boolean b(y yVar) {
        return ((Boolean) w0(Q1.s(yVar, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.C1
    public final Stream boxed() {
        return F(C0146d.f1776a);
    }

    @Override // j$.util.stream.C1
    public final long count() {
        return ((D1) h(I.f1707a)).sum();
    }

    @Override // j$.util.stream.C1
    public final C1 distinct() {
        return ((AbstractC0232y2) ((AbstractC0232y2) F(C0146d.f1776a)).distinct()).m(J.f1709a);
    }

    @Override // j$.util.stream.C1
    public final p findAny() {
        return (p) w0(new C0211t1(false, U2.INT_VALUE, p.a(), R0.f1728a, W.f1753a));
    }

    @Override // j$.util.stream.C1
    public final p findFirst() {
        return (p) w0(new C0211t1(true, U2.INT_VALUE, p.a(), R0.f1728a, W.f1753a));
    }

    @Override // j$.util.stream.C1
    public final H1 h(z zVar) {
        Objects.requireNonNull(zVar);
        return new f(this, this, U2.INT_VALUE, T2.p | T2.n, zVar);
    }

    @Override // j$.util.stream.C1
    public final AbstractC0207s1 i0(C0082e0 e0Var) {
        Objects.requireNonNull(e0Var);
        return new A1(this, this, U2.INT_VALUE, T2.p | T2.n, e0Var);
    }

    @Override // j$.util.stream.AbstractC0180l1, j$.util.stream.C1
    public final s.b iterator() {
        return u.g(spliterator());
    }

    @Override // j$.util.stream.AbstractC0180l1, j$.util.stream.C1
    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m27iterator() {
        return u.g(spliterator());
    }

    @Override // j$.util.stream.C1
    public final Object j0(J j2, H h2, BiConsumer biConsumer) {
        G g2 = new G(biConsumer);
        Objects.requireNonNull(j2);
        Objects.requireNonNull(h2);
        return w0(new C0193o2(U2.INT_VALUE, g2, h2, j2));
    }

    @Override // j$.util.stream.C1
    public final C1 limit(long j2) {
        if (j2 >= 0) {
            return B2.g(this, 0, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.C1
    public final p max() {
        return Z(Q0.f1727a);
    }

    @Override // j$.util.stream.C1
    public final p min() {
        return Z(C.f1695a);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.T1
    public final R1.a s0(long j2, x xVar) {
        return S1.p(j2);
    }

    @Override // j$.util.stream.C1
    public final C1 skip(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? this : B2.g(this, j2, -1);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.C1
    public final C1 sorted() {
        return new K2(this);
    }

    @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.C1
    public final Spliterator.b spliterator() {
        return L0(super.spliterator());
    }

    @Override // j$.util.stream.C1
    public final int sum() {
        return ((Integer) w0(new C0177k2(U2.INT_VALUE, C0191o0.f1814a, 0))).intValue();
    }

    @Override // j$.util.stream.C1
    public final m summaryStatistics() {
        return (m) j0(C0148d1.f1778a, C0162h.f1792a, C0136a1.f1768a);
    }

    @Override // j$.util.stream.C1
    public final int[] toArray() {
        return (int[]) S1.n((R1.c) x0(H.f1705a)).e();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public AbstractC0180l1 unordered() {
        return !B0() ? this : new B1(this, this, U2.INT_VALUE, T2.r);
    }

    @Override // j$.util.stream.C1
    public final C1 y(A a2) {
        Objects.requireNonNull(a2);
        return new d(this, this, U2.INT_VALUE, T2.p | T2.n, a2);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final R1 y0(T1 t1, Spliterator spliterator, boolean z, x xVar) {
        return S1.g(t1, spliterator, z);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    @Override // j$.util.stream.AbstractC0164h1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0(j$.util.Spliterator r3, j$.util.stream.A2 r4) {
        /*
            r2 = this;
            j$.util.Spliterator$b r3 = L0(r3)
            boolean r0 = r4 instanceof j$.util.function.w
            if (r0 == 0) goto L_0x000c
            r0 = r4
            j$.util.function.w r0 = (j$.util.function.w) r0
            goto L_0x0015
        L_0x000c:
            boolean r0 = j$.util.stream.i3.f1797a
            if (r0 != 0) goto L_0x0022
            j$.util.stream.c r0 = new j$.util.stream.c
            r0.<init>(r4)
        L_0x0015:
            boolean r1 = r4.p()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r3.h(r0)
            if (r1 != 0) goto L_0x0015
        L_0x0021:
            return
        L_0x0022:
            java.lang.Class<j$.util.stream.h1> r3 = j$.util.stream.AbstractC0164h1.class
            java.lang.String r4 = "using IntStream.adapt(Sink<Integer> s)"
            j$.util.stream.i3.a(r3, r4)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.AbstractC0235z1.z0(j$.util.Spliterator, j$.util.stream.A2):void");
    }
}
