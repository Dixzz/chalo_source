package j$.util.stream;

import a.L;
import a.N;
import a.S;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.G;
import j$.util.function.J;
import j$.util.function.p;
import j$.util.function.q;
import j$.util.function.r;
import j$.util.function.s;
import j$.util.function.t;
import j$.util.function.u;
import j$.util.function.x;
import j$.util.l;
import j$.util.o;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0223w1;
import j$.util.stream.AbstractC0232y2;
import j$.util.stream.D1;
import j$.util.stream.R1;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: j$.util.stream.p1  reason: case insensitive filesystem */
abstract class AbstractC0196p1<E_IN> extends AbstractC0164h1<E_IN, Double, AbstractC0207s1> implements AbstractC0207s1 {

    /* renamed from: j$.util.stream.p1$a */
    class a extends i<Double> {
        final /* synthetic */ u l;

        /* renamed from: j$.util.stream.p1$a$a  reason: collision with other inner class name */
        class C0035a extends A2.a<Double> {
            C0035a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d) {
                this.f1689a.accept(((S) a.this.l).a(d));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, u uVar) {
            super(h1Var, u2, i);
            this.l = uVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new C0035a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.p1$b */
    public class b extends AbstractC0232y2.m<Double, U> {
        final /* synthetic */ r l;

        /* renamed from: j$.util.stream.p1$b$a */
        class a extends A2.a<U> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d) {
                this.f1689a.accept(b.this.l.apply(d));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, r rVar) {
            super(h1Var, u2, i);
            this.l = rVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.p1$c */
    public class c extends D1.i<Double> {
        final /* synthetic */ t l;

        /* renamed from: j$.util.stream.p1$c$a */
        class a extends A2.a<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d) {
                this.f1689a.accept(c.this.l.applyAsLong(d));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, t tVar) {
            super(h1Var, u2, i);
            this.l = tVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.p1$d */
    class d extends i<Double> {
        final /* synthetic */ r l;

        /* renamed from: j$.util.stream.p1$d$a */
        class a extends A2.a<Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d) {
                AbstractC0207s1 s1Var = (AbstractC0207s1) d.this.l.apply(d);
                if (s1Var != null) {
                    try {
                        s1Var.sequential().l(new C0190o(this));
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
                if (s1Var != null) {
                    s1Var.close();
                    return;
                }
                return;
                throw th;
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public void n(long j) {
                this.f1689a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, r rVar) {
            super(h1Var, u2, i);
            this.l = rVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.p1$e */
    class e extends i<Double> {
        final /* synthetic */ s l;

        /* renamed from: j$.util.stream.p1$e$a */
        class a extends A2.a<Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d) {
                if (((L) e.this.l).b(d)) {
                    this.f1689a.accept(d);
                }
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public void n(long j) {
                this.f1689a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, s sVar) {
            super(h1Var, u2, i);
            this.l = sVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.p1$f */
    class f extends i<Double> {
        final /* synthetic */ q l;

        /* renamed from: j$.util.stream.p1$f$a */
        class a extends A2.a<Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d) {
                f.this.l.accept(d);
                this.f1689a.accept(d);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AbstractC0196p1 p1Var, AbstractC0164h1 h1Var, U2 u2, int i, q qVar) {
            super(h1Var, u2, i);
            this.l = qVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.p1$g */
    public static class g<E_IN> extends AbstractC0196p1<E_IN> {
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

        @Override // j$.util.stream.AbstractC0207s1, j$.util.stream.AbstractC0196p1
        public void k0(q qVar) {
            if (!isParallel()) {
                AbstractC0196p1.L0(I0()).e(qVar);
                return;
            }
            Objects.requireNonNull(qVar);
            w0(new AbstractC0223w1.a(qVar, true));
        }

        @Override // j$.util.stream.AbstractC0207s1, j$.util.stream.AbstractC0196p1
        public void l(q qVar) {
            if (!isParallel()) {
                AbstractC0196p1.L0(I0()).e(qVar);
            } else {
                AbstractC0196p1.super.l(qVar);
            }
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
        public /* bridge */ /* synthetic */ AbstractC0207s1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
        public /* bridge */ /* synthetic */ AbstractC0207s1 sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.p1$h */
    static abstract class h<E_IN> extends AbstractC0196p1<E_IN> {
        h(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
        public /* bridge */ /* synthetic */ AbstractC0207s1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
        public /* bridge */ /* synthetic */ AbstractC0207s1 sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.p1$i */
    static abstract class i<E_IN> extends AbstractC0196p1<E_IN> {
        i(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
        public /* bridge */ /* synthetic */ AbstractC0207s1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
        public /* bridge */ /* synthetic */ AbstractC0207s1 sequential() {
            sequential();
            return this;
        }
    }

    AbstractC0196p1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0196p1(AbstractC0164h1 h1Var, int i2) {
        super(h1Var, i2);
    }

    /* access modifiers changed from: private */
    public static Spliterator.a L0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.a) {
            return (Spliterator.a) spliterator;
        }
        if (i3.f1797a) {
            i3.a(AbstractC0164h1.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final U2 A0() {
        return U2.DOUBLE_VALUE;
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final o C(p pVar) {
        Objects.requireNonNull(pVar);
        return (o) w0(new Y1(U2.DOUBLE_VALUE, pVar));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final Object D(J j, G g2, BiConsumer biConsumer) {
        C0221w wVar = new C0221w(biConsumer);
        Objects.requireNonNull(j);
        Objects.requireNonNull(g2);
        return w0(new C0137a2(U2.DOUBLE_VALUE, wVar, g2, j));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final double G(double d2, p pVar) {
        Objects.requireNonNull(pVar);
        return ((Double) w0(new W1(U2.DOUBLE_VALUE, pVar, d2))).doubleValue();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 H(u uVar) {
        Objects.requireNonNull(uVar);
        return new a(this, this, U2.DOUBLE_VALUE, T2.p | T2.n, uVar);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final Stream I(r rVar) {
        Objects.requireNonNull(rVar);
        return new b(this, this, U2.DOUBLE_VALUE, T2.p | T2.n, rVar);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final boolean J(s sVar) {
        return ((Boolean) w0(Q1.r(sVar, N1.NONE))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final Spliterator J0(T1 t1, J j, boolean z) {
        return new Z2(t1, j, z);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final boolean O(s sVar) {
        return ((Boolean) w0(Q1.r(sVar, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final boolean W(s sVar) {
        return ((Boolean) w0(Q1.r(sVar, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final o average() {
        double[] dArr = (double[]) D(C0225x.f1838a, C0209t.f1824a, C0217v.f1831a);
        return dArr[2] > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? o.d(C0188n1.a(dArr) / dArr[2]) : o.a();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final Stream boxed() {
        return I(O0.f1722a);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final long count() {
        return ((D1) v(C0205s.f1822a)).sum();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 d(q qVar) {
        Objects.requireNonNull(qVar);
        return new f(this, this, U2.DOUBLE_VALUE, 0, qVar);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 distinct() {
        return ((AbstractC0232y2) ((AbstractC0232y2) I(O0.f1722a)).distinct()).h0(C0186n.f1810a);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final o findAny() {
        return (o) w0(new C0211t1(false, U2.DOUBLE_VALUE, o.a(), S0.f1730a, U0.f1749a));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final o findFirst() {
        return (o) w0(new C0211t1(true, U2.DOUBLE_VALUE, o.a(), S0.f1730a, U0.f1749a));
    }

    @Override // j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
    public final s.a iterator() {
        return j$.util.u.f(spliterator());
    }

    @Override // j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m26iterator() {
        return j$.util.u.f(spliterator());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public void k0(q qVar) {
        Objects.requireNonNull(qVar);
        w0(new AbstractC0223w1.a(qVar, true));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public void l(q qVar) {
        Objects.requireNonNull(qVar);
        w0(new AbstractC0223w1.a(qVar, false));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 limit(long j) {
        if (j >= 0) {
            return B2.f(this, 0, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final o max() {
        return C(D.f1697a);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final o min() {
        return C(X0.f1757a);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final C1 o(N n) {
        Objects.requireNonNull(n);
        return new C0200q1(this, this, U2.DOUBLE_VALUE, T2.p | T2.n, n);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.T1
    public final R1.a s0(long j, x xVar) {
        return S1.j(j);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 skip(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? this : B2.f(this, j, -1);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 sorted() {
        return new J2(this);
    }

    @Override // j$.util.stream.AbstractC0164h1, j$.util.stream.AbstractC0180l1, j$.util.stream.AbstractC0207s1
    public final Spliterator.a spliterator() {
        return L0(super.spliterator());
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final double sum() {
        return C0188n1.a((double[]) D(C0213u.f1828a, r.f1819a, C0194p.f1815a));
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final l summaryStatistics() {
        return (l) D(H0.f1706a, X.f1756a, C0175k0.f1802a);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 t(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new e(this, this, U2.DOUBLE_VALUE, T2.t, sVar);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final double[] toArray() {
        return (double[]) S1.m((R1.b) x0(C0198q.f1817a)).e();
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final AbstractC0207s1 u(r rVar) {
        return new d(this, this, U2.DOUBLE_VALUE, T2.p | T2.n | T2.t, rVar);
    }

    @Override // j$.util.stream.AbstractC0180l1
    public AbstractC0180l1 unordered() {
        return !B0() ? this : new C0203r1(this, this, U2.DOUBLE_VALUE, T2.r);
    }

    @Override // j$.util.stream.AbstractC0207s1
    public final H1 v(t tVar) {
        Objects.requireNonNull(tVar);
        return new c(this, this, U2.DOUBLE_VALUE, T2.p | T2.n, tVar);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final R1 y0(T1 t1, Spliterator spliterator, boolean z, x xVar) {
        return S1.f(t1, spliterator, z);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    @Override // j$.util.stream.AbstractC0164h1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0(j$.util.Spliterator r3, j$.util.stream.A2 r4) {
        /*
            r2 = this;
            j$.util.Spliterator$a r3 = L0(r3)
            boolean r0 = r4 instanceof j$.util.function.q
            if (r0 == 0) goto L_0x000c
            r0 = r4
            j$.util.function.q r0 = (j$.util.function.q) r0
            goto L_0x0015
        L_0x000c:
            boolean r0 = j$.util.stream.i3.f1797a
            if (r0 != 0) goto L_0x0022
            j$.util.stream.M r0 = new j$.util.stream.M
            r0.<init>(r4)
        L_0x0015:
            boolean r1 = r4.p()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r3.o(r0)
            if (r1 != 0) goto L_0x0015
        L_0x0021:
            return
        L_0x0022:
            java.lang.Class<j$.util.stream.h1> r3 = j$.util.stream.AbstractC0164h1.class
            java.lang.String r4 = "using DoubleStream.adapt(Sink<Double> s)"
            j$.util.stream.i3.a(r3, r4)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.AbstractC0196p1.z0(j$.util.Spliterator, j$.util.stream.A2):void");
    }
}
