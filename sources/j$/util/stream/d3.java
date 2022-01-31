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
import j$.util.r;
import j$.util.stream.X2;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/* access modifiers changed from: package-private */
public abstract class d3<T, T_SPLITR extends Spliterator<T>> {

    /* renamed from: a  reason: collision with root package name */
    protected final Spliterator f1779a;
    protected final boolean b;
    private final long c;
    private final AtomicLong d;

    static final class a extends d<Double, q, X2.a, Spliterator.a> implements Spliterator.a, q {
        double e;

        a(Spliterator.a aVar, long j, long j2) {
            super(aVar, j, j2);
        }

        a(Spliterator.a aVar, a aVar2) {
            super(aVar, aVar2);
        }

        @Override // j$.util.function.q
        public void accept(double d) {
            this.e = d;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.e(this, consumer);
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.a(this, consumer);
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3
        public Spliterator r(Spliterator spliterator) {
            return new a((Spliterator.a) spliterator, this);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3.d
        public void t(Object obj) {
            ((q) obj).accept(this.e);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3.d
        public X2.d u(int i) {
            return new X2.a(i);
        }
    }

    static final class b extends d<Integer, w, X2.b, Spliterator.b> implements Spliterator.b, w {
        int e;

        b(Spliterator.b bVar, long j, long j2) {
            super(bVar, j, j2);
        }

        b(Spliterator.b bVar, b bVar2) {
            super(bVar, bVar2);
        }

        @Override // j$.util.function.w
        public void accept(int i) {
            this.e = i;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.f(this, consumer);
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.b(this, consumer);
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3
        public Spliterator r(Spliterator spliterator) {
            return new b((Spliterator.b) spliterator, this);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3.d
        public void t(Object obj) {
            ((w) obj).accept(this.e);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3.d
        public X2.d u(int i) {
            return new X2.b(i);
        }
    }

    static final class c extends d<Long, C, X2.c, Spliterator.c> implements Spliterator.c, C {
        long e;

        c(Spliterator.c cVar, long j, long j2) {
            super(cVar, j, j2);
        }

        c(Spliterator.c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j$.util.function.C
        public void accept(long j) {
            this.e = j;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.g(this, consumer);
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.c(this, consumer);
        }

        @Override // j$.util.function.C
        public C g(C c) {
            Objects.requireNonNull(c);
            return new C0131h(this, c);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3
        public Spliterator r(Spliterator spliterator) {
            return new c((Spliterator.c) spliterator, this);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3.d
        public void t(Object obj) {
            ((C) obj).accept(this.e);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3.d
        public X2.d u(int i) {
            return new X2.c(i);
        }
    }

    static abstract class d<T, T_CONS, T_BUFF extends X2.d<T_CONS>, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>> extends d3<T, T_SPLITR> implements Spliterator.d<T, T_CONS, T_SPLITR> {
        d(Spliterator.d dVar, long j, long j2) {
            super(dVar, j, j2);
        }

        d(Spliterator.d dVar, d dVar2) {
            super(dVar, dVar2);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: forEachRemaining */
        public void e(Object obj) {
            Objects.requireNonNull(obj);
            X2.d dVar = null;
            while (true) {
                f s = s();
                if (s == f.NO_MORE) {
                    return;
                }
                if (s == f.MAYBE_MORE) {
                    if (dVar == null) {
                        dVar = u(128);
                    } else {
                        dVar.b = 0;
                    }
                    long j = 0;
                    while (((Spliterator.d) this.f1779a).tryAdvance(dVar)) {
                        j++;
                        if (j >= 128) {
                            break;
                        }
                    }
                    if (j != 0) {
                        dVar.b(obj, q(j));
                    } else {
                        return;
                    }
                } else {
                    ((Spliterator.d) this.f1779a).forEachRemaining(obj);
                    return;
                }
            }
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

        /* access modifiers changed from: protected */
        public abstract void t(Object obj);

        @Override // j$.util.Spliterator.d
        /* renamed from: tryAdvance */
        public boolean o(Object obj) {
            Objects.requireNonNull(obj);
            while (s() != f.NO_MORE && ((Spliterator.d) this.f1779a).tryAdvance(this)) {
                if (q(1) == 1) {
                    t(obj);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract X2.d u(int i);
    }

    static final class e<T> extends d3<T, Spliterator<T>> implements Spliterator<T>, Consumer<T> {
        Object e;

        e(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2);
        }

        e(Spliterator spliterator, e eVar) {
            super(spliterator, eVar);
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            this.e = obj;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (s() != f.NO_MORE && this.f1779a.b(this)) {
                if (q(1) == 1) {
                    consumer.accept(this.e);
                    this.e = null;
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            X2.e eVar = null;
            while (true) {
                f s = s();
                if (s == f.NO_MORE) {
                    return;
                }
                if (s == f.MAYBE_MORE) {
                    if (eVar == null) {
                        eVar = new X2.e(128);
                    } else {
                        eVar.f1759a = 0;
                    }
                    long j = 0;
                    while (this.f1779a.b(eVar)) {
                        j++;
                        if (j >= 128) {
                            break;
                        }
                    }
                    if (j != 0) {
                        long q = q(j);
                        for (int i = 0; ((long) i) < q; i++) {
                            consumer.accept(eVar.b[i]);
                        }
                    } else {
                        return;
                    }
                } else {
                    this.f1779a.forEachRemaining(consumer);
                    return;
                }
            }
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

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.d3
        public Spliterator r(Spliterator spliterator) {
            return new e(spliterator, this);
        }
    }

    /* access modifiers changed from: package-private */
    public enum f {
        NO_MORE,
        MAYBE_MORE,
        UNLIMITED
    }

    d3(Spliterator spliterator, long j, long j2) {
        this.f1779a = spliterator;
        long j3 = 0;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        this.b = i < 0;
        this.c = i >= 0 ? j2 : j3;
        this.d = new AtomicLong(i >= 0 ? j + j2 : j);
    }

    d3(Spliterator spliterator, d3 d3Var) {
        this.f1779a = spliterator;
        this.b = d3Var.b;
        this.d = d3Var.d;
        this.c = d3Var.c;
    }

    public final int characteristics() {
        return this.f1779a.characteristics() & -16465;
    }

    public final long estimateSize() {
        return this.f1779a.estimateSize();
    }

    /* access modifiers changed from: protected */
    public final long q(long j) {
        long j2;
        long min;
        do {
            j2 = this.d.get();
            if (j2 != 0) {
                min = Math.min(j2, j);
                if (min <= 0) {
                    break;
                }
            } else if (this.b) {
                return j;
            } else {
                return 0;
            }
        } while (!this.d.compareAndSet(j2, j2 - min));
        if (this.b) {
            return Math.max(j - min, 0L);
        }
        long j3 = this.c;
        return j2 > j3 ? Math.max(min - (j2 - j3), 0L) : min;
    }

    /* access modifiers changed from: protected */
    public abstract Spliterator r(Spliterator spliterator);

    /* access modifiers changed from: protected */
    public final f s() {
        return this.d.get() > 0 ? f.MAYBE_MORE : this.b ? f.UNLIMITED : f.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.d.get() == 0 || (trySplit = this.f1779a.trySplit()) == null) {
            return null;
        }
        return r(trySplit);
    }
}
