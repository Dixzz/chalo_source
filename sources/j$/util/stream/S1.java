package j$.util.stream;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.C0130g;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.w;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.R1;
import j$.util.stream.S2;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.CountedCompleter;

/* access modifiers changed from: package-private */
public final class S1 {

    /* renamed from: a  reason: collision with root package name */
    private static final R1 f1731a = new j.d(null);
    private static final R1.c b = new j.b();
    private static final R1.d c = new j.c();
    private static final R1.b d = new j.a();
    private static final int[] e = new int[0];
    private static final long[] f = new long[0];
    private static final double[] g = new double[0];

    /* access modifiers changed from: private */
    public static abstract class b<T, T_NODE extends R1<T>> implements R1<T> {

        /* renamed from: a  reason: collision with root package name */
        protected final R1 f1732a;
        protected final R1 b;
        private final long c;

        b(R1 r1, R1 r12) {
            this.f1732a = r1;
            this.b = r12;
            this.c = r1.count() + r12.count();
        }

        @Override // j$.util.stream.R1
        public R1 b(int i) {
            if (i == 0) {
                return this.f1732a;
            }
            if (i == 1) {
                return this.b;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.c;
        }

        @Override // j$.util.stream.R1
        public int o() {
            return 2;
        }
    }

    /* access modifiers changed from: private */
    public static class c<T> implements R1<T> {

        /* renamed from: a  reason: collision with root package name */
        final Object[] f1733a;
        int b;

        c(long j, x xVar) {
            if (j < 2147483639) {
                this.f1733a = (Object[]) xVar.apply((int) j);
                this.b = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        c(Object[] objArr) {
            this.f1733a = objArr;
            this.b = objArr.length;
        }

        @Override // j$.util.stream.R1
        public R1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return (long) this.b;
        }

        @Override // j$.util.stream.R1
        public void forEach(Consumer consumer) {
            for (int i = 0; i < this.b; i++) {
                consumer.accept(this.f1733a[i]);
            }
        }

        @Override // j$.util.stream.R1
        public void j(Object[] objArr, int i) {
            System.arraycopy(this.f1733a, 0, objArr, i, this.b);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public Object[] q(x xVar) {
            Object[] objArr = this.f1733a;
            if (objArr.length == this.b) {
                return objArr;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 r(long j, long j2, x xVar) {
            return Q1.n(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return j$.util.u.n(this.f1733a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.f1733a.length - this.b), Arrays.toString(this.f1733a));
        }
    }

    /* access modifiers changed from: private */
    public static final class d<T> implements R1<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Collection f1734a;

        d(Collection collection) {
            this.f1734a = collection;
        }

        @Override // j$.util.stream.R1
        public R1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return (long) this.f1734a.size();
        }

        @Override // j$.util.stream.R1
        public void forEach(Consumer consumer) {
            j$.time.chrono.b.y(this.f1734a, consumer);
        }

        @Override // j$.util.stream.R1
        public void j(Object[] objArr, int i) {
            for (Object obj : this.f1734a) {
                objArr[i] = obj;
                i++;
            }
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Collection */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.R1
        public Object[] q(x xVar) {
            Collection collection = this.f1734a;
            return collection.toArray((Object[]) xVar.apply(collection.size()));
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 r(long j, long j2, x xVar) {
            return Q1.n(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            Collection collection = this.f1734a;
            return (collection instanceof j$.util.Collection ? ((j$.util.Collection) collection).stream() : Collection.CC.$default$stream(collection)).spliterator();
        }

        public String toString() {
            return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.f1734a.size()), this.f1734a);
        }
    }

    private static class e<P_IN, P_OUT, T_NODE extends R1<P_OUT>, T_BUILDER extends R1.a<P_OUT>> extends AbstractC0176k1<P_IN, P_OUT, T_NODE, e<P_IN, P_OUT, T_NODE, T_BUILDER>> {
        protected final T1 h;
        protected final D i;
        protected final j$.util.function.n j;

        /* access modifiers changed from: private */
        public static final class a<P_IN> extends e<P_IN, Double, R1.b, R1.a.AbstractC0034a> {
            a(T1 t1, Spliterator spliterator) {
                super(t1, spliterator, C0152e1.f1783a, Z.f1763a);
            }
        }

        /* access modifiers changed from: private */
        public static final class b<P_IN> extends e<P_IN, Integer, R1.c, R1.a.b> {
            b(T1 t1, Spliterator spliterator) {
                super(t1, spliterator, C0144c1.f1774a, C0154f.f1784a);
            }
        }

        private static final class c<P_IN> extends e<P_IN, Long, R1.d, R1.a.c> {
            c(T1 t1, Spliterator spliterator) {
                super(t1, spliterator, B.f1693a, C0229y.f1841a);
            }
        }

        private static final class d<P_IN, P_OUT> extends e<P_IN, P_OUT, R1<P_OUT>, R1.a<P_OUT>> {
            d(T1 t1, x xVar, Spliterator spliterator) {
                super(t1, spliterator, new C0171j0(xVar), P0.f1725a);
            }
        }

        e(e eVar, Spliterator spliterator) {
            super(eVar, spliterator);
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
        }

        e(T1 t1, Spliterator spliterator, D d2, j$.util.function.n nVar) {
            super(t1, spliterator);
            this.h = t1;
            this.i = d2;
            this.j = nVar;
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0176k1
        public Object a() {
            R1.a aVar = (R1.a) this.i.apply(this.h.p0(this.b));
            this.h.t0(aVar, this.b);
            return aVar.a();
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0176k1
        public AbstractC0176k1 f(Spliterator spliterator) {
            return new e(this, spliterator);
        }

        @Override // j$.util.stream.AbstractC0176k1, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter countedCompleter) {
            if (!d()) {
                g((R1) this.j.apply((R1) ((e) this.d).b(), (R1) ((e) this.e).b()));
            }
            this.b = null;
            this.e = null;
            this.d = null;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f<T> extends b<T, R1<T>> implements R1<T> {

        /* access modifiers changed from: package-private */
        public static final class a extends d<Double, j$.util.function.q, double[], Spliterator.a, R1.b> implements R1.b {
            a(R1.b bVar, R1.b bVar2) {
                super(bVar, bVar2);
            }

            /* renamed from: a */
            public /* synthetic */ void j(Double[] dArr, int i) {
                Q1.e(this, dArr, i);
            }

            /* renamed from: f */
            public double[] c(int i) {
                return new double[i];
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.h(this, consumer);
            }

            /* renamed from: g */
            public /* synthetic */ R1.b r(long j, long j2, x xVar) {
                return Q1.k(this, j, j2, xVar);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            public Spliterator.d spliterator() {
                return new o.a(this);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m11spliterator() {
                return new o.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class b extends d<Integer, w, int[], Spliterator.b, R1.c> implements R1.c {
            b(R1.c cVar, R1.c cVar2) {
                super(cVar, cVar2);
            }

            /* renamed from: a */
            public /* synthetic */ void j(Integer[] numArr, int i) {
                Q1.f(this, numArr, i);
            }

            /* renamed from: f */
            public int[] c(int i) {
                return new int[i];
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.i(this, consumer);
            }

            /* renamed from: g */
            public /* synthetic */ R1.c r(long j, long j2, x xVar) {
                return Q1.l(this, j, j2, xVar);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            public Spliterator.d spliterator() {
                return new o.b(this);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m12spliterator() {
                return new o.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class c extends d<Long, C, long[], Spliterator.c, R1.d> implements R1.d {
            c(R1.d dVar, R1.d dVar2) {
                super(dVar, dVar2);
            }

            /* renamed from: a */
            public /* synthetic */ void j(Long[] lArr, int i) {
                Q1.g(this, lArr, i);
            }

            /* renamed from: f */
            public long[] c(int i) {
                return new long[i];
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.j(this, consumer);
            }

            /* renamed from: g */
            public /* synthetic */ R1.d r(long j, long j2, x xVar) {
                return Q1.m(this, j, j2, xVar);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            public Spliterator.d spliterator() {
                return new o.c(this);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m13spliterator() {
                return new o.c(this);
            }
        }

        private static abstract class d<E, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>, T_NODE extends R1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends b<E, T_NODE> implements R1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE> {
            d(R1.e eVar, R1.e eVar2) {
                super(eVar, eVar2);
            }

            @Override // j$.util.stream.R1.e
            public void d(Object obj, int i) {
                ((R1.e) this.f1732a).d(obj, i);
                ((R1.e) this.b).d(obj, i + ((int) ((R1.e) this.f1732a).count()));
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                long count = count();
                if (count < 2147483639) {
                    Object c = c((int) count);
                    d(c, 0);
                    return c;
                }
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }

            @Override // j$.util.stream.R1.e
            public void h(Object obj) {
                ((R1.e) this.f1732a).h(obj);
                ((R1.e) this.b).h(obj);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ Object[] q(x xVar) {
                return Q1.d(this, xVar);
            }

            public String toString() {
                if (count() < 32) {
                    return String.format("%s[%s.%s]", getClass().getName(), this.f1732a, this.b);
                }
                return String.format("%s[size=%d]", getClass().getName(), Long.valueOf(count()));
            }
        }

        f(R1 r1, R1 r12) {
            super(r1, r12);
        }

        @Override // j$.util.stream.R1
        public void forEach(Consumer consumer) {
            this.f1732a.forEach(consumer);
            this.b.forEach(consumer);
        }

        @Override // j$.util.stream.R1
        public void j(Object[] objArr, int i) {
            Objects.requireNonNull(objArr);
            this.f1732a.j(objArr, i);
            this.b.j(objArr, i + ((int) this.f1732a.count()));
        }

        @Override // j$.util.stream.R1
        public Object[] q(x xVar) {
            long count = count();
            if (count < 2147483639) {
                Object[] objArr = (Object[]) xVar.apply((int) count);
                j(objArr, 0);
                return objArr;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        @Override // j$.util.stream.R1
        public R1 r(long j, long j2, x xVar) {
            if (j == 0 && j2 == count()) {
                return this;
            }
            long count = this.f1732a.count();
            if (j >= count) {
                return this.b.r(j - count, j2 - count, xVar);
            }
            if (j2 <= count) {
                return this.f1732a.r(j, j2, xVar);
            }
            return S1.i(U2.REFERENCE, this.f1732a.r(j, count, xVar), this.b.r(0, j2 - count, xVar));
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return new o.e(this);
        }

        public String toString() {
            if (count() < 32) {
                return String.format("ConcNode[%s.%s]", this.f1732a, this.b);
            }
            return String.format("ConcNode[size=%d]", Long.valueOf(count()));
        }
    }

    /* access modifiers changed from: private */
    public static final class h extends g implements R1.a.AbstractC0034a {
        h(long j) {
            super(j);
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.AbstractC0034a
        public R1.b a() {
            if (this.b >= this.f1735a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1735a.length)));
        }

        @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
        public void accept(double d) {
            int i = this.b;
            double[] dArr = this.f1735a;
            if (i < dArr.length) {
                this.b = i + 1;
                dArr[i] = d;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f1735a.length)));
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.function.q
        public j$.util.function.q k(j$.util.function.q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }

        @Override // j$.util.stream.A2
        public void m() {
            if (this.b < this.f1735a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1735a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            if (j == ((long) this.f1735a.length)) {
                this.b = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.f1735a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        /* renamed from: s */
        public /* synthetic */ void accept(Double d) {
            Q1.a(this, d);
        }

        @Override // j$.util.stream.S1.g
        public String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(this.f1735a.length - this.b), Arrays.toString(this.f1735a));
        }
    }

    /* access modifiers changed from: private */
    public static final class i extends S2.b implements R1.b, R1.a.AbstractC0034a {
        private boolean g = false;

        i() {
        }

        @Override // j$.util.stream.S2.b
        public Spliterator.a B() {
            return super.spliterator();
        }

        /* renamed from: C */
        public /* synthetic */ void accept(Double d) {
            Q1.a(this, d);
        }

        /* renamed from: D */
        public /* synthetic */ void j(Double[] dArr, int i) {
            Q1.e(this, dArr, i);
        }

        /* renamed from: E */
        public /* synthetic */ R1.b r(long j, long j2, x xVar) {
            return Q1.k(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.AbstractC0034a
        public R1.b a() {
            return this;
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.AbstractC0034a
        /* renamed from: a  reason: collision with other method in class */
        public R1 m15a() {
            return this;
        }

        @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.S2.b, j$.util.stream.A2
        public void accept(double d) {
            super.accept(d);
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void d(Object obj, int i) {
            super.d((double[]) obj, i);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public Object e() {
            return (double[]) super.e();
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void h(Object obj) {
            super.h((j$.util.function.q) obj);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.g = false;
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.g = true;
            clear();
            x(j);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] q(x xVar) {
            return Q1.d(this, xVar);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.S2.e, j$.util.stream.R1.e, j$.util.stream.S2.b, j$.util.stream.R1, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.S2.e, j$.util.stream.R1.e, j$.util.stream.S2.b, j$.util.stream.R1, java.lang.Iterable, j$.lang.Iterable
        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m16spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class j<T, T_ARR, T_CONS> implements R1<T> {

        private static final class a extends j<Double, double[], j$.util.function.q> implements R1.b {
            a() {
            }

            /* renamed from: a */
            public /* synthetic */ void j(Double[] dArr, int i) {
                Q1.e(this, dArr, i);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1, j$.util.stream.S1.j
            public R1.e b(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                return S1.g;
            }

            /* renamed from: f */
            public /* synthetic */ R1.b r(long j, long j2, x xVar) {
                return Q1.k(this, j, j2, xVar);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.h(this, consumer);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            public Spliterator.d spliterator() {
                return j$.util.u.b();
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m17spliterator() {
                return j$.util.u.b();
            }
        }

        private static final class b extends j<Integer, int[], w> implements R1.c {
            b() {
            }

            /* renamed from: a */
            public /* synthetic */ void j(Integer[] numArr, int i) {
                Q1.f(this, numArr, i);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1, j$.util.stream.S1.j
            public R1.e b(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                return S1.e;
            }

            /* renamed from: f */
            public /* synthetic */ R1.c r(long j, long j2, x xVar) {
                return Q1.l(this, j, j2, xVar);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.i(this, consumer);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            public Spliterator.d spliterator() {
                return j$.util.u.c();
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m18spliterator() {
                return j$.util.u.c();
            }
        }

        private static final class c extends j<Long, long[], C> implements R1.d {
            c() {
            }

            /* renamed from: a */
            public /* synthetic */ void j(Long[] lArr, int i) {
                Q1.g(this, lArr, i);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1, j$.util.stream.S1.j
            public R1.e b(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                return S1.f;
            }

            /* renamed from: f */
            public /* synthetic */ R1.d r(long j, long j2, x xVar) {
                return Q1.m(this, j, j2, xVar);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.j(this, consumer);
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            public Spliterator.d spliterator() {
                return j$.util.u.d();
            }

            @Override // j$.util.stream.R1.e, j$.util.stream.R1
            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m19spliterator() {
                return j$.util.u.d();
            }
        }

        private static class d<T> extends j<T, T[], Consumer<? super T>> {
            d(a aVar) {
            }

            @Override // j$.util.stream.R1
            public void forEach(Consumer consumer) {
            }

            @Override // j$.util.stream.R1
            public void j(Object[] objArr, int i) {
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return j$.util.u.e();
            }
        }

        j() {
        }

        @Override // j$.util.stream.R1
        public R1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return 0;
        }

        public void d(Object obj, int i) {
        }

        public void h(Object obj) {
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public Object[] q(x xVar) {
            return (Object[]) xVar.apply(0);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 r(long j, long j2, x xVar) {
            return Q1.n(this, j, j2, xVar);
        }
    }

    /* access modifiers changed from: private */
    public static final class k<T> extends c<T> implements R1.a<T> {
        k(long j, x xVar) {
            super(j, xVar);
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            if (this.b >= this.f1733a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1733a.length)));
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            int i = this.b;
            Object[] objArr = this.f1733a;
            if (i < objArr.length) {
                this.b = i + 1;
                objArr[i] = obj;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f1733a.length)));
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.stream.A2
        public void m() {
            if (this.b < this.f1733a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1733a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            if (j == ((long) this.f1733a.length)) {
                this.b = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.f1733a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        @Override // j$.util.stream.S1.c
        public String toString() {
            return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(this.f1733a.length - this.b), Arrays.toString(this.f1733a));
        }
    }

    /* access modifiers changed from: private */
    public static final class m extends l implements R1.a.b {
        m(long j) {
            super(j);
        }

        @Override // j$.util.stream.R1.a.b, j$.util.stream.R1.a
        public R1.c a() {
            if (this.b >= this.f1736a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1736a.length)));
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
        public void accept(int i) {
            int i2 = this.b;
            int[] iArr = this.f1736a;
            if (i2 < iArr.length) {
                this.b = i2 + 1;
                iArr[i2] = i;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f1736a.length)));
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }

        @Override // j$.util.stream.A2
        public void m() {
            if (this.b < this.f1736a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1736a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            if (j == ((long) this.f1736a.length)) {
                this.b = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.f1736a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        /* renamed from: s */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.stream.S1.l
        public String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(this.f1736a.length - this.b), Arrays.toString(this.f1736a));
        }
    }

    /* access modifiers changed from: private */
    public static final class n extends S2.c implements R1.c, R1.a.b {
        private boolean g = false;

        n() {
        }

        @Override // j$.util.stream.S2.c
        public Spliterator.b B() {
            return super.spliterator();
        }

        /* renamed from: C */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        /* renamed from: D */
        public /* synthetic */ void j(Integer[] numArr, int i) {
            Q1.f(this, numArr, i);
        }

        /* renamed from: E */
        public /* synthetic */ R1.c r(long j, long j2, x xVar) {
            return Q1.l(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.b
        public R1.c a() {
            return this;
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.b
        /* renamed from: a  reason: collision with other method in class */
        public R1 m21a() {
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.S2.c, j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
        public void accept(int i) {
            super.accept(i);
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void d(Object obj, int i) {
            super.d((int[]) obj, i);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public Object e() {
            return (int[]) super.e();
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void h(Object obj) {
            super.h((w) obj);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.g = false;
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.g = true;
            clear();
            x(j);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] q(x xVar) {
            return Q1.d(this, xVar);
        }

        @Override // j$.util.stream.S2.c, j$.util.stream.S2.e, j$.util.stream.S2.e, j$.util.stream.R1.e, j$.util.stream.R1, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.S2.c, j$.util.stream.S2.e, j$.util.stream.S2.e, j$.util.stream.R1.e, j$.util.stream.R1, java.lang.Iterable, j$.lang.Iterable
        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m22spliterator() {
            return super.spliterator();
        }
    }

    /* access modifiers changed from: private */
    public static abstract class o<T, S extends Spliterator<T>, N extends R1<T>> implements Spliterator<T> {

        /* renamed from: a  reason: collision with root package name */
        R1 f1737a;
        int b;
        Spliterator c;
        Spliterator d;
        Deque e;

        private static final class a extends d<Double, j$.util.function.q, double[], Spliterator.a, R1.b> implements Spliterator.a {
            a(R1.b bVar) {
                super(bVar);
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.e(this, consumer);
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.a(this, consumer);
            }
        }

        private static final class b extends d<Integer, w, int[], Spliterator.b, R1.c> implements Spliterator.b {
            b(R1.c cVar) {
                super(cVar);
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.f(this, consumer);
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.b(this, consumer);
            }
        }

        private static final class c extends d<Long, C, long[], Spliterator.c, R1.d> implements Spliterator.c {
            c(R1.d dVar) {
                super(dVar);
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.g(this, consumer);
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.c(this, consumer);
            }
        }

        private static abstract class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, N extends R1.e<T, T_CONS, T_ARR, T_SPLITR, N>> extends o<T, T_SPLITR, N> implements Spliterator.d<T, T_CONS, T_SPLITR> {
            d(R1.e eVar) {
                super(eVar);
            }

            @Override // j$.util.Spliterator.d
            /* renamed from: forEachRemaining */
            public void e(Object obj) {
                if (this.f1737a != null) {
                    if (this.d == null) {
                        Spliterator spliterator = this.c;
                        if (spliterator == null) {
                            Deque f = f();
                            while (true) {
                                R1.e eVar = (R1.e) a(f);
                                if (eVar != null) {
                                    eVar.h(obj);
                                } else {
                                    this.f1737a = null;
                                    return;
                                }
                            }
                        } else {
                            ((Spliterator.d) spliterator).forEachRemaining(obj);
                        }
                    } else {
                        do {
                        } while (o(obj));
                    }
                }
            }

            @Override // j$.util.Spliterator.d
            /* renamed from: tryAdvance */
            public boolean o(Object obj) {
                R1.e eVar;
                if (!g()) {
                    return false;
                }
                boolean tryAdvance = ((Spliterator.d) this.d).tryAdvance(obj);
                if (!tryAdvance) {
                    if (this.c != null || (eVar = (R1.e) a(this.e)) == null) {
                        this.f1737a = null;
                    } else {
                        Spliterator.d spliterator = eVar.spliterator();
                        this.d = spliterator;
                        return spliterator.tryAdvance(obj);
                    }
                }
                return tryAdvance;
            }
        }

        private static final class e<T> extends o<T, Spliterator<T>, R1<T>> {
            e(R1 r1) {
                super(r1);
            }

            @Override // j$.util.Spliterator
            public boolean b(Consumer consumer) {
                R1 a2;
                if (!g()) {
                    return false;
                }
                boolean b = this.d.b(consumer);
                if (!b) {
                    if (this.c != null || (a2 = a(this.e)) == null) {
                        this.f1737a = null;
                    } else {
                        Spliterator spliterator = a2.spliterator();
                        this.d = spliterator;
                        return spliterator.b(consumer);
                    }
                }
                return b;
            }

            @Override // j$.util.Spliterator
            public void forEachRemaining(Consumer consumer) {
                if (this.f1737a != null) {
                    if (this.d == null) {
                        Spliterator spliterator = this.c;
                        if (spliterator == null) {
                            Deque f = f();
                            while (true) {
                                R1 a2 = a(f);
                                if (a2 != null) {
                                    a2.forEach(consumer);
                                } else {
                                    this.f1737a = null;
                                    return;
                                }
                            }
                        } else {
                            spliterator.forEachRemaining(consumer);
                        }
                    } else {
                        do {
                        } while (b(consumer));
                    }
                }
            }
        }

        o(R1 r1) {
            this.f1737a = r1;
        }

        /* access modifiers changed from: protected */
        public final R1 a(Deque deque) {
            while (true) {
                R1 r1 = (R1) deque.pollFirst();
                if (r1 == null) {
                    return null;
                }
                if (r1.o() != 0) {
                    for (int o = r1.o() - 1; o >= 0; o--) {
                        deque.addFirst(r1.b(o));
                    }
                } else if (r1.count() > 0) {
                    return r1;
                }
            }
        }

        @Override // j$.util.Spliterator
        public final int characteristics() {
            return 64;
        }

        @Override // j$.util.Spliterator
        public final long estimateSize() {
            long j = 0;
            if (this.f1737a == null) {
                return 0;
            }
            Spliterator spliterator = this.c;
            if (spliterator != null) {
                return spliterator.estimateSize();
            }
            for (int i = this.b; i < this.f1737a.o(); i++) {
                j += this.f1737a.b(i).count();
            }
            return j;
        }

        /* access modifiers changed from: protected */
        public final Deque f() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            int o = this.f1737a.o();
            while (true) {
                o--;
                if (o < this.b) {
                    return arrayDeque;
                }
                arrayDeque.addFirst(this.f1737a.b(o));
            }
        }

        /* access modifiers changed from: protected */
        public final boolean g() {
            if (this.f1737a == null) {
                return false;
            }
            if (this.d != null) {
                return true;
            }
            Spliterator spliterator = this.c;
            if (spliterator == null) {
                Deque f = f();
                this.e = f;
                R1 a2 = a(f);
                if (a2 != null) {
                    spliterator = a2.spliterator();
                } else {
                    this.f1737a = null;
                    return false;
                }
            }
            this.d = spliterator;
            return true;
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.chrono.b.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.chrono.b.h(this, i);
        }

        @Override // j$.util.Spliterator
        public final Spliterator trySplit() {
            R1 r1 = this.f1737a;
            if (r1 == null || this.d != null) {
                return null;
            }
            Spliterator spliterator = this.c;
            if (spliterator != null) {
                return spliterator.trySplit();
            }
            if (this.b < r1.o() - 1) {
                R1 r12 = this.f1737a;
                int i = this.b;
                this.b = i + 1;
                return r12.b(i).spliterator();
            }
            R1 b2 = this.f1737a.b(this.b);
            this.f1737a = b2;
            if (b2.o() == 0) {
                Spliterator spliterator2 = this.f1737a.spliterator();
                this.c = spliterator2;
                return spliterator2.trySplit();
            }
            this.b = 0;
            R1 r13 = this.f1737a;
            this.b = 1;
            return r13.b(0).spliterator();
        }
    }

    /* access modifiers changed from: private */
    public static final class q extends p implements R1.a.c {
        q(long j) {
            super(j);
        }

        @Override // j$.util.stream.R1.a.c, j$.util.stream.R1.a
        public R1.d a() {
            if (this.b >= this.f1738a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1738a.length)));
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2
        public void accept(long j) {
            int i = this.b;
            long[] jArr = this.f1738a;
            if (i < jArr.length) {
                this.b = i + 1;
                jArr[i] = j;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f1738a.length)));
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.function.C
        public C g(C c) {
            Objects.requireNonNull(c);
            return new C0131h(this, c);
        }

        @Override // j$.util.stream.A2
        public void m() {
            if (this.b < this.f1738a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.b), Integer.valueOf(this.f1738a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            if (j == ((long) this.f1738a.length)) {
                this.b = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.f1738a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        /* renamed from: s */
        public /* synthetic */ void accept(Long l) {
            Q1.c(this, l);
        }

        @Override // j$.util.stream.S1.p
        public String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.f1738a.length - this.b), Arrays.toString(this.f1738a));
        }
    }

    /* access modifiers changed from: private */
    public static final class r extends S2.d implements R1.d, R1.a.c {
        private boolean g = false;

        r() {
        }

        @Override // j$.util.stream.S2.d
        public Spliterator.c B() {
            return super.spliterator();
        }

        /* renamed from: C */
        public /* synthetic */ void accept(Long l) {
            Q1.c(this, l);
        }

        /* renamed from: D */
        public /* synthetic */ void j(Long[] lArr, int i) {
            Q1.g(this, lArr, i);
        }

        /* renamed from: E */
        public /* synthetic */ R1.d r(long j, long j2, x xVar) {
            return Q1.m(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.c
        public R1.d a() {
            return this;
        }

        @Override // j$.util.stream.R1.a, j$.util.stream.R1.a.c
        /* renamed from: a  reason: collision with other method in class */
        public R1 m24a() {
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.stream.S2.d, j$.util.stream.A2.g, j$.util.function.C, j$.util.stream.A2
        public void accept(long j) {
            super.accept(j);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void d(Object obj, int i) {
            super.d((long[]) obj, i);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public Object e() {
            return (long[]) super.e();
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void h(Object obj) {
            super.h((C) obj);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.g = false;
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.g = true;
            clear();
            x(j);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] q(x xVar) {
            return Q1.d(this, xVar);
        }

        @Override // j$.util.stream.S2.d, j$.util.stream.S2.e, j$.util.stream.S2.e, j$.util.stream.R1.e, j$.util.stream.R1, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.S2.d, j$.util.stream.S2.e, j$.util.stream.S2.e, j$.util.stream.R1.e, j$.util.stream.R1, java.lang.Iterable, j$.lang.Iterable
        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m25spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class s<P_IN, P_OUT, T_SINK extends A2<P_OUT>, K extends s<P_IN, P_OUT, T_SINK, K>> extends CountedCompleter<Void> implements A2<P_OUT> {

        /* renamed from: a  reason: collision with root package name */
        protected final Spliterator f1739a;
        protected final T1 b;
        protected final long c;
        protected long d;
        protected long e;
        protected int f;
        protected int g;

        /* access modifiers changed from: package-private */
        public static final class a<P_IN> extends s<P_IN, Double, A2.e, a<P_IN>> implements A2.e {
            private final double[] h;

            a(Spliterator spliterator, T1 t1, double[] dArr) {
                super(spliterator, t1, dArr.length);
                this.h = dArr;
            }

            a(a aVar, Spliterator spliterator, long j, long j2) {
                super(aVar, spliterator, j, j2, aVar.h.length);
                this.h = aVar.h;
            }

            @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.S1.s, j$.util.stream.A2
            public void accept(double d) {
                int i = this.f;
                if (i < this.g) {
                    double[] dArr = this.h;
                    this.f = i + 1;
                    dArr[i] = d;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.f));
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.s
            public s b(Spliterator spliterator, long j, long j2) {
                return new a(this, spliterator, j, j2);
            }

            /* renamed from: c */
            public /* synthetic */ void accept(Double d) {
                Q1.a(this, d);
            }

            @Override // j$.util.function.q
            public j$.util.function.q k(j$.util.function.q qVar) {
                Objects.requireNonNull(qVar);
                return new C0129f(this, qVar);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class b<P_IN> extends s<P_IN, Integer, A2.f, b<P_IN>> implements A2.f {
            private final int[] h;

            b(Spliterator spliterator, T1 t1, int[] iArr) {
                super(spliterator, t1, iArr.length);
                this.h = iArr;
            }

            b(b bVar, Spliterator spliterator, long j, long j2) {
                super(bVar, spliterator, j, j2, bVar.h.length);
                this.h = bVar.h;
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.S1.s, j$.util.function.w, j$.util.stream.A2
            public void accept(int i) {
                int i2 = this.f;
                if (i2 < this.g) {
                    int[] iArr = this.h;
                    this.f = i2 + 1;
                    iArr[i2] = i;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.f));
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.s
            public s b(Spliterator spliterator, long j, long j2) {
                return new b(this, spliterator, j, j2);
            }

            /* renamed from: c */
            public /* synthetic */ void accept(Integer num) {
                Q1.b(this, num);
            }

            @Override // j$.util.function.w
            public w l(w wVar) {
                Objects.requireNonNull(wVar);
                return new C0130g(this, wVar);
            }
        }

        static final class c<P_IN> extends s<P_IN, Long, A2.g, c<P_IN>> implements A2.g {
            private final long[] h;

            c(Spliterator spliterator, T1 t1, long[] jArr) {
                super(spliterator, t1, jArr.length);
                this.h = jArr;
            }

            c(c cVar, Spliterator spliterator, long j, long j2) {
                super(cVar, spliterator, j, j2, cVar.h.length);
                this.h = cVar.h;
            }

            @Override // j$.util.function.C, j$.util.stream.S1.s, j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j) {
                int i = this.f;
                if (i < this.g) {
                    long[] jArr = this.h;
                    this.f = i + 1;
                    jArr[i] = j;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.f));
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.s
            public s b(Spliterator spliterator, long j, long j2) {
                return new c(this, spliterator, j, j2);
            }

            /* renamed from: c */
            public /* synthetic */ void accept(Long l) {
                Q1.c(this, l);
            }

            @Override // j$.util.function.C
            public C g(C c) {
                Objects.requireNonNull(c);
                return new C0131h(this, c);
            }
        }

        static final class d<P_IN, P_OUT> extends s<P_IN, P_OUT, A2<P_OUT>, d<P_IN, P_OUT>> implements A2<P_OUT> {
            private final Object[] h;

            d(Spliterator spliterator, T1 t1, Object[] objArr) {
                super(spliterator, t1, objArr.length);
                this.h = objArr;
            }

            d(d dVar, Spliterator spliterator, long j, long j2) {
                super(dVar, spliterator, j, j2, dVar.h.length);
                this.h = dVar.h;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                int i = this.f;
                if (i < this.g) {
                    Object[] objArr = this.h;
                    this.f = i + 1;
                    objArr[i] = obj;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.f));
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.s
            public s b(Spliterator spliterator, long j, long j2) {
                return new d(this, spliterator, j, j2);
            }
        }

        s(Spliterator spliterator, T1 t1, int i) {
            this.f1739a = spliterator;
            this.b = t1;
            this.c = AbstractC0176k1.h(spliterator.estimateSize());
            this.d = 0;
            this.e = (long) i;
        }

        s(s sVar, Spliterator spliterator, long j, long j2, int i) {
            super(sVar);
            this.f1739a = spliterator;
            this.b = sVar.b;
            this.c = sVar.c;
            this.d = j;
            this.e = j2;
            if (j < 0 || j2 < 0 || (j + j2) - 1 >= ((long) i)) {
                throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
            }
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        /* access modifiers changed from: package-private */
        public abstract s b(Spliterator spliterator, long j, long j2);

        public void compute() {
            Spliterator trySplit;
            Spliterator spliterator = this.f1739a;
            s<P_IN, P_OUT, T_SINK, K> sVar = this;
            while (spliterator.estimateSize() > sVar.c && (trySplit = spliterator.trySplit()) != null) {
                sVar.setPendingCount(1);
                long estimateSize = trySplit.estimateSize();
                sVar.b(trySplit, sVar.d, estimateSize).fork();
                sVar = sVar.b(spliterator, sVar.d + estimateSize, sVar.e - estimateSize);
            }
            AbstractC0164h1 h1Var = (AbstractC0164h1) sVar.b;
            Objects.requireNonNull(h1Var);
            h1Var.m0(h1Var.u0(sVar), spliterator);
            sVar.propagateCompletion();
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.stream.A2
        public void m() {
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            long j2 = this.e;
            if (j <= j2) {
                int i = (int) this.d;
                this.f = i;
                this.g = i + ((int) j2);
                return;
            }
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final class t<T> extends S2<T> implements R1<T>, R1.a<T> {
        private boolean g = false;

        t() {
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d) {
            j$.time.chrono.b.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(int i) {
            j$.time.chrono.b.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j) {
            j$.time.chrono.b.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer, j$.util.stream.S2
        public void accept(Object obj) {
            super.accept(obj);
        }

        @Override // j$.util.stream.R1
        public R1 b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2, j$.util.stream.R1, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            super.forEach(consumer);
        }

        @Override // j$.util.stream.S2, j$.util.stream.R1
        public void j(Object[] objArr, int i) {
            super.j(objArr, i);
        }

        @Override // j$.util.stream.A2
        public void m() {
            this.g = false;
        }

        @Override // j$.util.stream.A2
        public void n(long j) {
            this.g = true;
            clear();
            u(j);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean p() {
            return false;
        }

        @Override // j$.util.stream.R1
        public Object[] q(x xVar) {
            long count = count();
            if (count < 2147483639) {
                Object[] objArr = (Object[]) xVar.apply((int) count);
                j(objArr, 0);
                return objArr;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 r(long j, long j2, x xVar) {
            return Q1.n(this, j, j2, xVar);
        }

        @Override // j$.util.stream.S2, j$.util.stream.S2, j$.util.stream.R1, j$.lang.Iterable, java.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class u<T, T_NODE extends R1<T>, K extends u<T, T_NODE, K>> extends CountedCompleter<Void> {

        /* renamed from: a  reason: collision with root package name */
        protected final R1 f1740a;
        protected final int b;

        /* access modifiers changed from: private */
        public static final class a extends d<Double, j$.util.function.q, double[], Spliterator.a, R1.b> {
            a(R1.b bVar, double[] dArr, int i, a aVar) {
                super(bVar, dArr, i, null);
            }
        }

        /* access modifiers changed from: private */
        public static final class b extends d<Integer, w, int[], Spliterator.b, R1.c> {
            b(R1.c cVar, int[] iArr, int i, a aVar) {
                super(cVar, iArr, i, null);
            }
        }

        /* access modifiers changed from: private */
        public static final class c extends d<Long, C, long[], Spliterator.c, R1.d> {
            c(R1.d dVar, long[] jArr, int i, a aVar) {
                super(dVar, jArr, i, null);
            }
        }

        private static class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_NODE extends R1.e<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends u<T, T_NODE, d<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> {
            private final Object c;

            d(R1.e eVar, Object obj, int i, a aVar) {
                super(eVar, i);
                this.c = obj;
            }

            private d(d dVar, R1.e eVar, int i) {
                super(dVar, eVar, i);
                this.c = dVar.c;
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.u
            public void a() {
                ((R1.e) this.f1740a).d(this.c, this.b);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.u
            public u b(int i, int i2) {
                return new d(this, ((R1.e) this.f1740a).b(i), i2);
            }
        }

        /* access modifiers changed from: private */
        public static final class e<T> extends u<T, R1<T>, e<T>> {
            private final Object[] c;

            e(R1 r1, Object[] objArr, int i, a aVar) {
                super(r1, i);
                this.c = objArr;
            }

            private e(e eVar, R1 r1, int i) {
                super(eVar, r1, i);
                this.c = eVar.c;
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.u
            public void a() {
                this.f1740a.j(this.c, this.b);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S1.u
            public u b(int i, int i2) {
                return new e(this, this.f1740a.b(i), i2);
            }
        }

        u(R1 r1, int i) {
            this.f1740a = r1;
            this.b = i;
        }

        u(u uVar, R1 r1, int i) {
            super(uVar);
            this.f1740a = r1;
            this.b = i;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract u b(int i, int i2);

        public void compute() {
            u<T, T_NODE, K> uVar = this;
            while (uVar.f1740a.o() != 0) {
                uVar.setPendingCount(uVar.f1740a.o() - 1);
                int i = 0;
                int i2 = 0;
                while (i < uVar.f1740a.o() - 1) {
                    u b2 = uVar.b(i, uVar.b + i2);
                    i2 = (int) (((long) i2) + b2.f1740a.count());
                    b2.fork();
                    i++;
                }
                uVar = uVar.b(i, uVar.b + i2);
            }
            uVar.a();
            uVar.propagateCompletion();
        }
    }

    static R1.a d(long j2, x xVar) {
        return (j2 < 0 || j2 >= 2147483639) ? new t() : new k(j2, xVar);
    }

    public static R1 e(T1 t1, Spliterator spliterator, boolean z, x xVar) {
        long p0 = t1.p0(spliterator);
        if (p0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1 r1 = (R1) new e.d(t1, xVar, spliterator).invoke();
            return z ? l(r1, xVar) : r1;
        } else if (p0 < 2147483639) {
            Object[] objArr = (Object[]) xVar.apply((int) p0);
            new s.d(spliterator, t1, objArr).invoke();
            return new c(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static R1.b f(T1 t1, Spliterator spliterator, boolean z) {
        long p0 = t1.p0(spliterator);
        if (p0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1.b bVar = (R1.b) new e.a(t1, spliterator).invoke();
            return z ? m(bVar) : bVar;
        } else if (p0 < 2147483639) {
            double[] dArr = new double[((int) p0)];
            new s.a(spliterator, t1, dArr).invoke();
            return new g(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static R1.c g(T1 t1, Spliterator spliterator, boolean z) {
        long p0 = t1.p0(spliterator);
        if (p0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1.c cVar = (R1.c) new e.b(t1, spliterator).invoke();
            return z ? n(cVar) : cVar;
        } else if (p0 < 2147483639) {
            int[] iArr = new int[((int) p0)];
            new s.b(spliterator, t1, iArr).invoke();
            return new l(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static R1.d h(T1 t1, Spliterator spliterator, boolean z) {
        long p0 = t1.p0(spliterator);
        if (p0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1.d dVar = (R1.d) new e.c(t1, spliterator).invoke();
            return z ? o(dVar) : dVar;
        } else if (p0 < 2147483639) {
            long[] jArr = new long[((int) p0)];
            new s.c(spliterator, t1, jArr).invoke();
            return new p(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    static R1 i(U2 u2, R1 r1, R1 r12) {
        int ordinal = u2.ordinal();
        if (ordinal == 0) {
            return new f(r1, r12);
        }
        if (ordinal == 1) {
            return new f.b((R1.c) r1, (R1.c) r12);
        }
        if (ordinal == 2) {
            return new f.c((R1.d) r1, (R1.d) r12);
        }
        if (ordinal == 3) {
            return new f.a((R1.b) r1, (R1.b) r12);
        }
        throw new IllegalStateException("Unknown shape " + u2);
    }

    static R1.a.AbstractC0034a j(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new i() : new h(j2);
    }

    static R1 k(U2 u2) {
        int ordinal = u2.ordinal();
        if (ordinal == 0) {
            return f1731a;
        }
        if (ordinal == 1) {
            return b;
        }
        if (ordinal == 2) {
            return c;
        }
        if (ordinal == 3) {
            return d;
        }
        throw new IllegalStateException("Unknown shape " + u2);
    }

    public static R1 l(R1 r1, x xVar) {
        if (r1.o() <= 0) {
            return r1;
        }
        long count = r1.count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) xVar.apply((int) count);
            new u.e(r1, objArr, 0, null).invoke();
            return new c(objArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static R1.b m(R1.b bVar) {
        if (bVar.o() <= 0) {
            return bVar;
        }
        long count = bVar.count();
        if (count < 2147483639) {
            double[] dArr = new double[((int) count)];
            new u.a(bVar, dArr, 0, null).invoke();
            return new g(dArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static R1.c n(R1.c cVar) {
        if (cVar.o() <= 0) {
            return cVar;
        }
        long count = cVar.count();
        if (count < 2147483639) {
            int[] iArr = new int[((int) count)];
            new u.b(cVar, iArr, 0, null).invoke();
            return new l(iArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static R1.d o(R1.d dVar) {
        if (dVar.o() <= 0) {
            return dVar;
        }
        long count = dVar.count();
        if (count < 2147483639) {
            long[] jArr = new long[((int) count)];
            new u.c(dVar, jArr, 0, null).invoke();
            return new p(jArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    static R1.a.b p(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new n() : new m(j2);
    }

    static R1.a.c q(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new r() : new q(j2);
    }

    /* access modifiers changed from: private */
    public static class g implements R1.b {

        /* renamed from: a  reason: collision with root package name */
        final double[] f1735a;
        int b;

        g(long j) {
            if (j < 2147483639) {
                this.f1735a = new double[((int) j)];
                this.b = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        g(double[] dArr) {
            this.f1735a = dArr;
            this.b = dArr.length;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return (long) this.b;
        }

        @Override // j$.util.stream.R1.e
        public void d(Object obj, int i) {
            System.arraycopy(this.f1735a, 0, (double[]) obj, i, this.b);
        }

        @Override // j$.util.stream.R1.e
        public Object e() {
            double[] dArr = this.f1735a;
            int length = dArr.length;
            int i = this.b;
            return length == i ? dArr : Arrays.copyOf(dArr, i);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ void forEach(Consumer consumer) {
            Q1.h(this, consumer);
        }

        /* renamed from: g */
        public /* synthetic */ void j(Double[] dArr, int i) {
            Q1.e(this, dArr, i);
        }

        @Override // j$.util.stream.R1.e
        public void h(Object obj) {
            j$.util.function.q qVar = (j$.util.function.q) obj;
            for (int i = 0; i < this.b; i++) {
                qVar.accept(this.f1735a[i]);
            }
        }

        /* renamed from: l */
        public /* synthetic */ R1.b r(long j, long j2, x xVar) {
            return Q1.k(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] q(x xVar) {
            return Q1.d(this, xVar);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public Spliterator.d spliterator() {
            return j$.util.u.j(this.f1735a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.f1735a.length - this.b), Arrays.toString(this.f1735a));
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m14spliterator() {
            return j$.util.u.j(this.f1735a, 0, this.b, 1040);
        }
    }

    /* access modifiers changed from: private */
    public static class l implements R1.c {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1736a;
        int b;

        l(long j) {
            if (j < 2147483639) {
                this.f1736a = new int[((int) j)];
                this.b = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        l(int[] iArr) {
            this.f1736a = iArr;
            this.b = iArr.length;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return (long) this.b;
        }

        @Override // j$.util.stream.R1.e
        public void d(Object obj, int i) {
            System.arraycopy(this.f1736a, 0, (int[]) obj, i, this.b);
        }

        @Override // j$.util.stream.R1.e
        public Object e() {
            int[] iArr = this.f1736a;
            int length = iArr.length;
            int i = this.b;
            return length == i ? iArr : Arrays.copyOf(iArr, i);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ void forEach(Consumer consumer) {
            Q1.i(this, consumer);
        }

        /* renamed from: g */
        public /* synthetic */ void j(Integer[] numArr, int i) {
            Q1.f(this, numArr, i);
        }

        @Override // j$.util.stream.R1.e
        public void h(Object obj) {
            w wVar = (w) obj;
            for (int i = 0; i < this.b; i++) {
                wVar.accept(this.f1736a[i]);
            }
        }

        /* renamed from: k */
        public /* synthetic */ R1.c r(long j, long j2, x xVar) {
            return Q1.l(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] q(x xVar) {
            return Q1.d(this, xVar);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public Spliterator.d spliterator() {
            return j$.util.u.k(this.f1736a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("IntArrayNode[%d][%s]", Integer.valueOf(this.f1736a.length - this.b), Arrays.toString(this.f1736a));
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m20spliterator() {
            return j$.util.u.k(this.f1736a, 0, this.b, 1040);
        }
    }

    /* access modifiers changed from: private */
    public static class p implements R1.d {

        /* renamed from: a  reason: collision with root package name */
        final long[] f1738a;
        int b;

        p(long j) {
            if (j < 2147483639) {
                this.f1738a = new long[((int) j)];
                this.b = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        p(long[] jArr) {
            this.f1738a = jArr;
            this.b = jArr.length;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return (long) this.b;
        }

        @Override // j$.util.stream.R1.e
        public void d(Object obj, int i) {
            System.arraycopy(this.f1738a, 0, (long[]) obj, i, this.b);
        }

        @Override // j$.util.stream.R1.e
        public Object e() {
            long[] jArr = this.f1738a;
            int length = jArr.length;
            int i = this.b;
            return length == i ? jArr : Arrays.copyOf(jArr, i);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ void forEach(Consumer consumer) {
            Q1.j(this, consumer);
        }

        @Override // j$.util.stream.R1.e
        public void h(Object obj) {
            C c = (C) obj;
            for (int i = 0; i < this.b; i++) {
                c.accept(this.f1738a[i]);
            }
        }

        /* renamed from: k */
        public /* synthetic */ void j(Long[] lArr, int i) {
            Q1.g(this, lArr, i);
        }

        /* renamed from: l */
        public /* synthetic */ R1.d r(long j, long j2, x xVar) {
            return Q1.m(this, j, j2, xVar);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int o() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] q(x xVar) {
            return Q1.d(this, xVar);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public Spliterator.d spliterator() {
            return j$.util.u.l(this.f1738a, 0, this.b, 1040);
        }

        public String toString() {
            return String.format("LongArrayNode[%d][%s]", Integer.valueOf(this.f1738a.length - this.b), Arrays.toString(this.f1738a));
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m23spliterator() {
            return j$.util.u.l(this.f1738a, 0, this.b, 1040);
        }
    }
}
