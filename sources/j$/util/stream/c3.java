package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.function.w;
import j$.util.r;
import java.util.Comparator;
import java.util.Objects;

/* access modifiers changed from: package-private */
public abstract class c3<T, T_SPLITR extends Spliterator<T>> {

    /* renamed from: a  reason: collision with root package name */
    final long f1775a;
    final long b;
    Spliterator c;
    long d;
    long e;

    static final class a extends d<Double, Spliterator.a, q> implements Spliterator.a {
        a(Spliterator.a aVar, long j, long j2) {
            super(aVar, j, j2);
        }

        a(Spliterator.a aVar, long j, long j2, long j3, long j4) {
            super(aVar, j, j2, j3, j4, null);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3
        public Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new a((Spliterator.a) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.e(this, consumer);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3.d
        public /* bridge */ /* synthetic */ Object f() {
            return B0.f1694a;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.a(this, consumer);
        }
    }

    static final class b extends d<Integer, Spliterator.b, w> implements Spliterator.b {
        b(Spliterator.b bVar, long j, long j2) {
            super(bVar, j, j2);
        }

        b(Spliterator.b bVar, long j, long j2, long j3, long j4) {
            super(bVar, j, j2, j3, j4, null);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3
        public Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new b((Spliterator.b) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.f(this, consumer);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3.d
        public /* bridge */ /* synthetic */ Object f() {
            return C0.f1696a;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.b(this, consumer);
        }
    }

    static final class c extends d<Long, Spliterator.c, C> implements Spliterator.c {
        c(Spliterator.c cVar, long j, long j2) {
            super(cVar, j, j2);
        }

        c(Spliterator.c cVar, long j, long j2, long j3, long j4) {
            super(cVar, j, j2, j3, j4, null);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3
        public Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new c((Spliterator.c) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.g(this, consumer);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3.d
        public /* bridge */ /* synthetic */ Object f() {
            return D0.f1698a;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.c(this, consumer);
        }
    }

    static abstract class d<T, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_CONS> extends c3<T, T_SPLITR> implements Spliterator.d<T, T_CONS, T_SPLITR> {
        d(Spliterator.d dVar, long j, long j2) {
            super(dVar, j, j2, 0, Math.min(dVar.estimateSize(), j2));
        }

        /* access modifiers changed from: protected */
        public abstract Object f();

        @Override // j$.util.Spliterator.d
        /* renamed from: forEachRemaining */
        public void e(Object obj) {
            Objects.requireNonNull(obj);
            long j = this.f1775a;
            long j2 = this.e;
            if (j < j2) {
                long j3 = this.d;
                if (j3 < j2) {
                    if (j3 < j || ((Spliterator.d) this.c).estimateSize() + j3 > this.b) {
                        while (this.f1775a > this.d) {
                            ((Spliterator.d) this.c).tryAdvance(f());
                            this.d++;
                        }
                        while (this.d < this.e) {
                            ((Spliterator.d) this.c).tryAdvance(obj);
                            this.d++;
                        }
                        return;
                    }
                    ((Spliterator.d) this.c).forEachRemaining(obj);
                    this.d = this.e;
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

        @Override // j$.util.Spliterator.d
        /* renamed from: tryAdvance */
        public boolean o(Object obj) {
            long j;
            Objects.requireNonNull(obj);
            if (this.f1775a >= this.e) {
                return false;
            }
            while (true) {
                long j2 = this.f1775a;
                j = this.d;
                if (j2 <= j) {
                    break;
                }
                ((Spliterator.d) this.c).tryAdvance(f());
                this.d++;
            }
            if (j >= this.e) {
                return false;
            }
            this.d = j + 1;
            return ((Spliterator.d) this.c).tryAdvance(obj);
        }

        d(Spliterator.d dVar, long j, long j2, long j3, long j4, V2 v2) {
            super(dVar, j, j2, j3, j4);
        }
    }

    static final class e<T> extends c3<T, Spliterator<T>> implements Spliterator<T> {
        e(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2, 0, Math.min(spliterator.estimateSize(), j2));
        }

        private e(Spliterator spliterator, long j, long j2, long j3, long j4) {
            super(spliterator, j, j2, j3, j4);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.c3
        public Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new e(spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            long j;
            Objects.requireNonNull(consumer);
            if (this.f1775a >= this.e) {
                return false;
            }
            while (true) {
                long j2 = this.f1775a;
                j = this.d;
                if (j2 <= j) {
                    break;
                }
                this.c.b(E0.f1700a);
                this.d++;
            }
            if (j >= this.e) {
                return false;
            }
            this.d = j + 1;
            return this.c.b(consumer);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            long j = this.f1775a;
            long j2 = this.e;
            if (j < j2) {
                long j3 = this.d;
                if (j3 < j2) {
                    if (j3 < j || this.c.estimateSize() + j3 > this.b) {
                        while (this.f1775a > this.d) {
                            this.c.b(F0.f1702a);
                            this.d++;
                        }
                        while (this.d < this.e) {
                            this.c.b(consumer);
                            this.d++;
                        }
                        return;
                    }
                    this.c.forEachRemaining(consumer);
                    this.d = this.e;
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
    }

    c3(Spliterator spliterator, long j, long j2, long j3, long j4) {
        this.c = spliterator;
        this.f1775a = j;
        this.b = j2;
        this.d = j3;
        this.e = j4;
    }

    /* access modifiers changed from: protected */
    public abstract Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4);

    public int characteristics() {
        return this.c.characteristics();
    }

    public long estimateSize() {
        long j = this.f1775a;
        long j2 = this.e;
        if (j < j2) {
            return j2 - Math.max(j, this.d);
        }
        return 0;
    }

    public Spliterator trySplit() {
        long j = this.f1775a;
        long j2 = this.e;
        if (j >= j2 || this.d >= j2) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.d;
            long min = Math.min(estimateSize, this.b);
            long j3 = this.f1775a;
            if (j3 >= min) {
                this.d = min;
            } else {
                long j4 = this.b;
                if (min >= j4) {
                    this.c = trySplit;
                    this.e = min;
                } else {
                    long j5 = this.d;
                    if (j5 < j3 || estimateSize > j4) {
                        this.d = min;
                        return a(trySplit, j3, j4, j5, min);
                    }
                    this.d = min;
                    return trySplit;
                }
            }
        }
    }
}
