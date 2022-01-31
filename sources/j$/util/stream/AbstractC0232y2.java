package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C;
import j$.util.function.C0126c;
import j$.util.function.C0127d;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.J;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.function.n;
import j$.util.function.q;
import j$.util.function.w;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0184m1;
import j$.util.stream.AbstractC0196p1;
import j$.util.stream.AbstractC0223w1;
import j$.util.stream.AbstractC0235z1;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.u;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: j$.util.stream.y2  reason: case insensitive filesystem */
abstract class AbstractC0232y2<P_IN, P_OUT> extends AbstractC0164h1<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT> {

    /* renamed from: j$.util.stream.y2$a */
    class a extends D1.i<P_OUT> {
        final /* synthetic */ Function l;

        /* renamed from: j$.util.stream.y2$a$a  reason: collision with other inner class name */
        class C0036a extends A2.d<P_OUT, Long> {
            C b;

            C0036a(A2 a2) {
                super(a2);
                A2 a22 = this.f1692a;
                Objects.requireNonNull(a22);
                this.b = new K0(a22);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                H1 h1 = (H1) a.this.l.apply(obj);
                if (h1 != null) {
                    try {
                        h1.sequential().f(this.b);
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

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void n(long j) {
                this.f1692a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Function function) {
            super(h1Var, u2, i);
            this.l = function;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new C0036a(a2);
        }
    }

    /* renamed from: j$.util.stream.y2$b */
    class b extends m<P_OUT, P_OUT> {
        final /* synthetic */ Consumer l;

        /* renamed from: j$.util.stream.y2$b$a */
        class a extends A2.d<P_OUT, P_OUT> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                b.this.l.accept(obj);
                this.f1692a.accept(obj);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Consumer consumer) {
            super(h1Var, u2, i);
            this.l = consumer;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.y2$c */
    class c extends m<P_OUT, P_OUT> {
        final /* synthetic */ Predicate l;

        /* renamed from: j$.util.stream.y2$c$a */
        class a extends A2.d<P_OUT, P_OUT> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                if (c.this.l.test(obj)) {
                    this.f1692a.accept(obj);
                }
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void n(long j) {
                this.f1692a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Predicate predicate) {
            super(h1Var, u2, i);
            this.l = predicate;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.y2$d */
    class d extends m<P_OUT, R> {
        final /* synthetic */ Function l;

        /* renamed from: j$.util.stream.y2$d$a */
        class a extends A2.d<P_OUT, R> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.f1692a.accept(d.this.l.apply(obj));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Function function) {
            super(h1Var, u2, i);
            this.l = function;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.y2$e */
    public class e extends AbstractC0235z1.k<P_OUT> {
        final /* synthetic */ ToIntFunction l;

        /* renamed from: j$.util.stream.y2$e$a */
        class a extends A2.d<P_OUT, Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.f1692a.accept(e.this.l.applyAsInt(obj));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, ToIntFunction toIntFunction) {
            super(h1Var, u2, i);
            this.l = toIntFunction;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.y2$f */
    public class f extends D1.i<P_OUT> {
        final /* synthetic */ ToLongFunction l;

        /* renamed from: j$.util.stream.y2$f$a */
        class a extends A2.d<P_OUT, Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.f1692a.accept(f.this.l.applyAsLong(obj));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, ToLongFunction toLongFunction) {
            super(h1Var, u2, i);
            this.l = toLongFunction;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.y2$g */
    public class g extends AbstractC0196p1.i<P_OUT> {
        final /* synthetic */ ToDoubleFunction l;

        /* renamed from: j$.util.stream.y2$g$a */
        class a extends A2.d<P_OUT, Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.f1692a.accept(g.this.l.applyAsDouble(obj));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, ToDoubleFunction toDoubleFunction) {
            super(h1Var, u2, i);
            this.l = toDoubleFunction;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.y2$h */
    class h extends m<P_OUT, R> {
        final /* synthetic */ Function l;

        /* renamed from: j$.util.stream.y2$h$a */
        class a extends A2.d<P_OUT, R> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                Stream stream = (Stream) h.this.l.apply(obj);
                if (stream != null) {
                    try {
                        ((Stream) stream.sequential()).forEach(this.f1692a);
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
                throw th;
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void n(long j) {
                this.f1692a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Function function) {
            super(h1Var, u2, i);
            this.l = function;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.y2$i */
    class i extends AbstractC0235z1.k<P_OUT> {
        final /* synthetic */ Function l;

        /* renamed from: j$.util.stream.y2$i$a */
        class a extends A2.d<P_OUT, Integer> {
            w b;

            a(A2 a2) {
                super(a2);
                A2 a22 = this.f1692a;
                Objects.requireNonNull(a22);
                this.b = new C0142c(a22);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                C1 c1 = (C1) i.this.l.apply(obj);
                if (c1 != null) {
                    try {
                        c1.sequential().Q(this.b);
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

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void n(long j) {
                this.f1692a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Function function) {
            super(h1Var, u2, i);
            this.l = function;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* renamed from: j$.util.stream.y2$j */
    class j extends AbstractC0196p1.i<P_OUT> {
        final /* synthetic */ Function l;

        /* renamed from: j$.util.stream.y2$j$a */
        class a extends A2.d<P_OUT, Double> {
            q b;

            a(A2 a2) {
                super(a2);
                A2 a22 = this.f1692a;
                Objects.requireNonNull(a22);
                this.b = new M(a22);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                AbstractC0207s1 s1Var = (AbstractC0207s1) j.this.l.apply(obj);
                if (s1Var != null) {
                    try {
                        s1Var.sequential().l(this.b);
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

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void n(long j) {
                this.f1692a.n(-1);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AbstractC0232y2 y2Var, AbstractC0164h1 h1Var, U2 u2, int i, Function function) {
            super(h1Var, u2, i);
            this.l = function;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public A2 G0(int i, A2 a2) {
            return new a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.y2$k */
    public static class k<E_IN, E_OUT> extends AbstractC0232y2<E_IN, E_OUT> {
        k(Spliterator spliterator, int i, boolean z) {
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

        @Override // j$.util.stream.AbstractC0232y2, j$.util.stream.Stream
        public void forEach(Consumer consumer) {
            if (!isParallel()) {
                I0().forEachRemaining(consumer);
            } else {
                AbstractC0232y2.super.forEach(consumer);
            }
        }

        @Override // j$.util.stream.AbstractC0232y2, j$.util.stream.Stream
        public void g(Consumer consumer) {
            if (!isParallel()) {
                I0().forEachRemaining(consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            w0(new AbstractC0223w1.d(consumer, true));
        }
    }

    /* renamed from: j$.util.stream.y2$l */
    static abstract class l<E_IN, E_OUT> extends AbstractC0232y2<E_IN, E_OUT> {
        l(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.y2$m */
    public static abstract class m<E_IN, E_OUT> extends AbstractC0232y2<E_IN, E_OUT> {
        m(AbstractC0164h1 h1Var, U2 u2, int i) {
            super(h1Var, i);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractC0164h1
        public final boolean F0() {
            return false;
        }
    }

    AbstractC0232y2(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0232y2(AbstractC0164h1 h1Var, int i2) {
        super(h1Var, i2);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final U2 A0() {
        return U2.REFERENCE;
    }

    @Override // j$.util.stream.Stream
    public final AbstractC0207s1 B(Function function) {
        Objects.requireNonNull(function);
        return new j(this, this, U2.REFERENCE, T2.p | T2.n | T2.t, function);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final Spliterator J0(T1 t1, J j2, boolean z) {
        return new e3(t1, j2, z);
    }

    @Override // j$.util.stream.Stream
    public final Stream P(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new c(this, this, U2.REFERENCE, T2.t, predicate);
    }

    @Override // j$.util.stream.Stream
    public final Stream S(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new b(this, this, U2.REFERENCE, 0, consumer);
    }

    @Override // j$.util.stream.Stream
    public final Object T(AbstractC0184m1 m1Var) {
        Object obj;
        if (!isParallel() || !m1Var.characteristics().contains(AbstractC0184m1.a.CONCURRENT) || (B0() && !m1Var.characteristics().contains(AbstractC0184m1.a.UNORDERED))) {
            Objects.requireNonNull(m1Var);
            J supplier = m1Var.supplier();
            obj = w0(new C0161g2(U2.REFERENCE, m1Var.combiner(), m1Var.accumulator(), supplier, m1Var));
        } else {
            obj = m1Var.supplier().get();
            forEach(new C0202r0(m1Var.accumulator(), obj));
        }
        return m1Var.characteristics().contains(AbstractC0184m1.a.IDENTITY_FINISH) ? obj : m1Var.finisher().apply(obj);
    }

    @Override // j$.util.stream.Stream
    public final boolean U(Predicate predicate) {
        return ((Boolean) w0(Q1.u(predicate, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final H1 V(Function function) {
        Objects.requireNonNull(function);
        return new a(this, this, U2.REFERENCE, T2.p | T2.n | T2.t, function);
    }

    @Override // j$.util.stream.Stream
    public final boolean a(Predicate predicate) {
        return ((Boolean) w0(Q1.u(predicate, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean c0(Predicate predicate) {
        return ((Boolean) w0(Q1.u(predicate, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return ((D1) e0(C0195p0.f1816a)).sum();
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return new C0192o1(this, U2.REFERENCE, T2.m | T2.t);
    }

    @Override // j$.util.stream.Stream
    public final C1 e(Function function) {
        Objects.requireNonNull(function);
        return new i(this, this, U2.REFERENCE, T2.p | T2.n | T2.t, function);
    }

    @Override // j$.util.stream.Stream
    public final H1 e0(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new f(this, this, U2.REFERENCE, T2.p | T2.n, toLongFunction);
    }

    @Override // j$.util.stream.Stream
    public final Optional findAny() {
        return (Optional) w0(new C0211t1(false, U2.REFERENCE, Optional.a(), C0160g1.f1791a, W0.f1754a));
    }

    @Override // j$.util.stream.Stream
    public final Optional findFirst() {
        return (Optional) w0(new C0211t1(true, U2.REFERENCE, Optional.a(), C0160g1.f1791a, W0.f1754a));
    }

    @Override // j$.util.stream.Stream
    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        w0(new AbstractC0223w1.d(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public void g(Consumer consumer) {
        Objects.requireNonNull(consumer);
        w0(new AbstractC0223w1.d(consumer, true));
    }

    @Override // j$.util.stream.Stream
    public final AbstractC0207s1 h0(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new g(this, this, U2.REFERENCE, T2.p | T2.n, toDoubleFunction);
    }

    @Override // j$.util.stream.AbstractC0180l1
    public final Iterator iterator() {
        return u.i(spliterator());
    }

    @Override // j$.util.stream.Stream
    public final Object k(J j2, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(j2);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return w0(new C0169i2(U2.REFERENCE, biConsumer2, biConsumer, j2));
    }

    @Override // j$.util.stream.Stream
    public final Object l0(Object obj, n nVar) {
        Objects.requireNonNull(nVar);
        return w0(new C0145c2(U2.REFERENCE, nVar, nVar, obj));
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j2) {
        if (j2 >= 0) {
            return B2.i(this, 0, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.Stream
    public final C1 m(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new e(this, this, U2.REFERENCE, T2.p | T2.n, toIntFunction);
    }

    @Override // j$.util.stream.Stream
    public final Optional max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return s(new C0127d(comparator));
    }

    @Override // j$.util.stream.Stream
    public final Optional min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return s(new C0126c(comparator));
    }

    @Override // j$.util.stream.Stream
    public final Stream n(Function function) {
        Objects.requireNonNull(function);
        return new d(this, this, U2.REFERENCE, T2.p | T2.n, function);
    }

    @Override // j$.util.stream.Stream
    public final Stream p(Function function) {
        Objects.requireNonNull(function);
        return new h(this, this, U2.REFERENCE, T2.p | T2.n | T2.t, function);
    }

    @Override // j$.util.stream.Stream
    public final Optional s(n nVar) {
        Objects.requireNonNull(nVar);
        return (Optional) w0(new C0153e2(U2.REFERENCE, nVar));
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.T1
    public final R1.a s0(long j2, x xVar) {
        return S1.d(j2, xVar);
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? this : B2.i(this, j2, -1);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return new M2(this);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        C0199q0 q0Var = C0199q0.f1818a;
        return S1.l(x0(q0Var), q0Var).q(q0Var);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(x xVar) {
        return S1.l(x0(xVar), xVar).q(xVar);
    }

    @Override // j$.util.stream.AbstractC0180l1
    public AbstractC0180l1 unordered() {
        return !B0() ? this : new C0236z2(this, this, U2.REFERENCE, T2.r);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0164h1
    public final R1 y0(T1 t1, Spliterator spliterator, boolean z, x xVar) {
        return S1.e(t1, spliterator, z, xVar);
    }

    @Override // j$.util.stream.Stream
    public final Object z(Object obj, BiFunction biFunction, n nVar) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(nVar);
        return w0(new C0145c2(U2.REFERENCE, nVar, biFunction, obj));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    @Override // j$.util.stream.AbstractC0164h1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0(j$.util.Spliterator r2, j$.util.stream.A2 r3) {
        /*
            r1 = this;
        L_0x0000:
            boolean r0 = r3.p()
            if (r0 != 0) goto L_0x000c
            boolean r0 = r2.b(r3)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.AbstractC0232y2.z0(j$.util.Spliterator, j$.util.stream.A2):void");
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new M2(this, comparator);
    }
}
