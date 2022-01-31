package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.C0130g;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.function.w;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.w1  reason: case insensitive filesystem */
abstract class AbstractC0223w1<T> implements g3<T, Void>, h3<T, Void> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1836a;

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.w1$a */
    public static final class a extends AbstractC0223w1<Double> implements A2.e {
        final q b;

        a(q qVar, boolean z) {
            super(z);
            this.b = qVar;
        }

        @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2, j$.util.stream.AbstractC0223w1
        public void accept(double d) {
            this.b.accept(d);
        }

        /* renamed from: e */
        public /* synthetic */ void accept(Double d) {
            Q1.a(this, d);
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.w1$b */
    public static final class b extends AbstractC0223w1<Integer> implements A2.f {
        final w b;

        b(w wVar, boolean z) {
            super(z);
            this.b = wVar;
        }

        @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2, j$.util.stream.AbstractC0223w1
        public void accept(int i) {
            this.b.accept(i);
        }

        /* renamed from: e */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.w1$c */
    public static final class c extends AbstractC0223w1<Long> implements A2.g {
        final C b;

        c(C c, boolean z) {
            super(z);
            this.b = c;
        }

        @Override // j$.util.function.C, j$.util.stream.A2.g, j$.util.stream.A2, j$.util.stream.AbstractC0223w1
        public void accept(long j) {
            this.b.accept(j);
        }

        /* renamed from: e */
        public /* synthetic */ void accept(Long l) {
            Q1.c(this, l);
        }

        @Override // j$.util.function.C
        public C g(C c) {
            Objects.requireNonNull(c);
            return new C0131h(this, c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.w1$d */
    public static final class d<T> extends AbstractC0223w1<T> {
        final Consumer b;

        d(Consumer consumer, boolean z) {
            super(z);
            this.b = consumer;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            this.b.accept(obj);
        }
    }

    protected AbstractC0223w1(boolean z) {
        this.f1836a = z;
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

    @Override // j$.util.stream.g3
    public int b() {
        if (this.f1836a) {
            return 0;
        }
        return T2.r;
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        (this.f1836a ? new C0227x1(t1, spliterator, this) : new C0231y1(t1, spliterator, t1.u0(this))).invoke();
        return null;
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        AbstractC0164h1 h1Var = (AbstractC0164h1) t1;
        h1Var.m0(h1Var.u0(this), spliterator);
        return null;
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.function.J
    public /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
