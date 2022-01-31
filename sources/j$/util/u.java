package j$.util;

import a.D;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.C0130g;
import j$.util.function.C0131h;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.function.w;
import j$.util.s;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Spliterator f1846a = new g.d();
    private static final Spliterator.b b = new g.b();
    private static final Spliterator.c c = new g.c();
    private static final Spliterator.a d = new g.a();

    class a implements Iterator<T>, Consumer<T>, Iterator {

        /* renamed from: a  reason: collision with root package name */
        boolean f1847a = false;
        Object b;
        final /* synthetic */ Spliterator c;

        a(Spliterator spliterator) {
            this.c = spliterator;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            this.f1847a = true;
            this.b = obj;
        }

        @Override // j$.util.function.Consumer
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull(consumer);
            return new C0128e(this, consumer);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, D.b(consumer));
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (!this.f1847a) {
                this.c.b(this);
            }
            return this.f1847a;
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            if (this.f1847a || hasNext()) {
                this.f1847a = false;
                return this.b;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class b implements s.b, w {

        /* renamed from: a  reason: collision with root package name */
        boolean f1848a = false;
        int b;
        final /* synthetic */ Spliterator.b c;

        b(Spliterator.b bVar) {
            this.c = bVar;
        }

        @Override // j$.util.function.w
        public void accept(int i) {
            this.f1848a = true;
            this.b = i;
        }

        @Override // j$.util.s.b
        /* renamed from: c */
        public void forEachRemaining(w wVar) {
            Objects.requireNonNull(wVar);
            while (hasNext()) {
                wVar.accept(nextInt());
            }
        }

        @Override // j$.util.Iterator, j$.util.s.b
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof w) {
                forEachRemaining((w) consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            if (!v.f1856a) {
                forEachRemaining(new h(consumer));
            } else {
                v.a(b.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                throw null;
            }
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (!this.f1848a) {
                this.c.h(this);
            }
            return this.f1848a;
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }

        @Override // j$.util.Iterator, java.util.Iterator, j$.util.s.b
        public Integer next() {
            if (!v.f1856a) {
                return Integer.valueOf(nextInt());
            }
            v.a(b.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }

        @Override // j$.util.s.b
        public int nextInt() {
            if (this.f1848a || hasNext()) {
                this.f1848a = false;
                return this.b;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class c implements s.c, C {

        /* renamed from: a  reason: collision with root package name */
        boolean f1849a = false;
        long b;
        final /* synthetic */ Spliterator.c c;

        c(Spliterator.c cVar) {
            this.c = cVar;
        }

        @Override // j$.util.function.C
        public void accept(long j) {
            this.f1849a = true;
            this.b = j;
        }

        @Override // j$.util.s.c
        /* renamed from: d */
        public void forEachRemaining(C c2) {
            Objects.requireNonNull(c2);
            while (hasNext()) {
                c2.accept(nextLong());
            }
        }

        @Override // j$.util.Iterator, j$.util.s.c
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof C) {
                forEachRemaining((C) consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            if (!v.f1856a) {
                while (hasNext()) {
                    consumer.accept(Long.valueOf(nextLong()));
                }
                return;
            }
            v.a(c.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        }

        @Override // j$.util.function.C
        public C g(C c2) {
            Objects.requireNonNull(c2);
            return new C0131h(this, c2);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (!this.f1849a) {
                this.c.j(this);
            }
            return this.f1849a;
        }

        @Override // j$.util.Iterator, java.util.Iterator, j$.util.s.c
        public Long next() {
            if (!v.f1856a) {
                return Long.valueOf(nextLong());
            }
            v.a(c.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }

        @Override // j$.util.s.c
        public long nextLong() {
            if (this.f1849a || hasNext()) {
                this.f1849a = false;
                return this.b;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class d implements s.a, q {

        /* renamed from: a  reason: collision with root package name */
        boolean f1850a = false;
        double b;
        final /* synthetic */ Spliterator.a c;

        d(Spliterator.a aVar) {
            this.c = aVar;
        }

        @Override // j$.util.function.q
        public void accept(double d) {
            this.f1850a = true;
            this.b = d;
        }

        @Override // j$.util.s.a
        /* renamed from: e */
        public void forEachRemaining(q qVar) {
            Objects.requireNonNull(qVar);
            while (hasNext()) {
                qVar.accept(nextDouble());
            }
        }

        @Override // j$.util.Iterator, j$.util.s.a
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof q) {
                forEachRemaining((q) consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            if (!v.f1856a) {
                while (hasNext()) {
                    consumer.accept(Double.valueOf(nextDouble()));
                }
                return;
            }
            v.a(d.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
            throw null;
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (!this.f1850a) {
                this.c.o(this);
            }
            return this.f1850a;
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }

        @Override // j$.util.Iterator, java.util.Iterator, j$.util.s.a
        public Double next() {
            if (!v.f1856a) {
                return Double.valueOf(nextDouble());
            }
            v.a(d.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
            throw null;
        }

        @Override // j$.util.s.a
        public double nextDouble() {
            if (this.f1850a || hasNext()) {
                this.f1850a = false;
                return this.b;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    static final class e<T> implements Spliterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f1851a;
        private int b;
        private final int c;
        private final int d;

        public e(Object[] objArr, int i, int i2, int i3) {
            this.f1851a = objArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            Object[] objArr = this.f1851a;
            this.b = i + 1;
            consumer.accept(objArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return (long) (this.c - this.b);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            int i;
            consumer.getClass();
            Object[] objArr = this.f1851a;
            int length = objArr.length;
            int i2 = this.c;
            if (length >= i2 && (i = this.b) >= 0) {
                this.b = i2;
                if (i < i2) {
                    do {
                        consumer.accept(objArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            if (j$.time.chrono.b.h(this, 4)) {
                return null;
            }
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
        public Spliterator trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            Object[] objArr = this.f1851a;
            this.b = i2;
            return new e(objArr, i, i2, this.d);
        }
    }

    static final class f implements Spliterator.a {

        /* renamed from: a  reason: collision with root package name */
        private final double[] f1852a;
        private int b;
        private final int c;
        private final int d;

        public f(double[] dArr, int i, int i2, int i3) {
            this.f1852a = dArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator.a
        /* renamed from: e */
        public void forEachRemaining(q qVar) {
            int i;
            qVar.getClass();
            double[] dArr = this.f1852a;
            int length = dArr.length;
            int i2 = this.c;
            if (length >= i2 && (i = this.b) >= 0) {
                this.b = i2;
                if (i < i2) {
                    do {
                        qVar.accept(dArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return (long) (this.c - this.b);
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.a(this, consumer);
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            if (j$.time.chrono.b.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator.a
        /* renamed from: o */
        public boolean tryAdvance(q qVar) {
            qVar.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            double[] dArr = this.f1852a;
            this.b = i + 1;
            qVar.accept(dArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
        public Spliterator.a trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            double[] dArr = this.f1852a;
            this.b = i2;
            return new f(dArr, i, i2, this.d);
        }
    }

    private static abstract class g<T, S extends Spliterator<T>, C> {

        private static final class a extends g<Double, Spliterator.a, q> implements Spliterator.a {
            a() {
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.e(this, consumer);
            }

            @Override // j$.util.Spliterator.a
            public void e(q qVar) {
                Objects.requireNonNull(qVar);
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.a(this, consumer);
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

            @Override // j$.util.Spliterator.a
            public boolean o(q qVar) {
                Objects.requireNonNull(qVar);
                return false;
            }
        }

        private static final class b extends g<Integer, Spliterator.b, w> implements Spliterator.b {
            b() {
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.f(this, consumer);
            }

            @Override // j$.util.Spliterator.b
            public void c(w wVar) {
                Objects.requireNonNull(wVar);
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.b(this, consumer);
            }

            @Override // j$.util.Spliterator
            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return j$.time.chrono.b.g(this);
            }

            @Override // j$.util.Spliterator.b
            public boolean h(w wVar) {
                Objects.requireNonNull(wVar);
                return false;
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return j$.time.chrono.b.h(this, i);
            }
        }

        private static final class c extends g<Long, Spliterator.c, C> implements Spliterator.c {
            c() {
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.g(this, consumer);
            }

            @Override // j$.util.Spliterator.c
            public void d(C c) {
                Objects.requireNonNull(c);
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.c(this, consumer);
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

            @Override // j$.util.Spliterator.c
            public boolean j(C c) {
                Objects.requireNonNull(c);
                return false;
            }
        }

        private static final class d<T> extends g<T, Spliterator<T>, Consumer<? super T>> implements Spliterator<T> {
            d() {
            }

            @Override // j$.util.Spliterator
            public boolean b(Consumer consumer) {
                Objects.requireNonNull(consumer);
                return false;
            }

            @Override // j$.util.Spliterator
            public void forEachRemaining(Consumer consumer) {
                Objects.requireNonNull(consumer);
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

        g() {
        }

        public int characteristics() {
            return 16448;
        }

        public long estimateSize() {
            return 0;
        }

        public void forEachRemaining(Object obj) {
            Objects.requireNonNull(obj);
        }

        public boolean tryAdvance(Object obj) {
            Objects.requireNonNull(obj);
            return false;
        }

        public Spliterator trySplit() {
            return null;
        }
    }

    static final class h implements Spliterator.b {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1853a;
        private int b;
        private final int c;
        private final int d;

        public h(int[] iArr, int i, int i2, int i3) {
            this.f1853a = iArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.f(this, consumer);
        }

        @Override // j$.util.Spliterator.b
        /* renamed from: c */
        public void forEachRemaining(w wVar) {
            int i;
            wVar.getClass();
            int[] iArr = this.f1853a;
            int length = iArr.length;
            int i2 = this.c;
            if (length >= i2 && (i = this.b) >= 0) {
                this.b = i2;
                if (i < i2) {
                    do {
                        wVar.accept(iArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return (long) (this.c - this.b);
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.b(this, consumer);
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            if (j$.time.chrono.b.h(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.chrono.b.g(this);
        }

        @Override // j$.util.Spliterator.b
        /* renamed from: h */
        public boolean tryAdvance(w wVar) {
            wVar.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            int[] iArr = this.f1853a;
            this.b = i + 1;
            wVar.accept(iArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.chrono.b.h(this, i);
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator.d, j$.util.Spliterator
        public Spliterator.b trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            int[] iArr = this.f1853a;
            this.b = i2;
            return new h(iArr, i, i2, this.d);
        }
    }

    /* access modifiers changed from: package-private */
    public static class i<T> implements Spliterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Collection f1854a;
        private java.util.Iterator b;
        private final int c;
        private long d;
        private int e;

        public i(Collection collection, int i) {
            this.f1854a = collection;
            this.b = null;
            this.c = (i & 4096) == 0 ? i | 64 | 16384 : i;
        }

        public i(java.util.Iterator it, int i) {
            this.f1854a = null;
            this.b = it;
            this.d = Long.MAX_VALUE;
            this.c = i & -16449;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            if (this.b == null) {
                this.b = this.f1854a.iterator();
                this.d = (long) this.f1854a.size();
            }
            if (!this.b.hasNext()) {
                return false;
            }
            consumer.accept(this.b.next());
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.c;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            if (this.b != null) {
                return this.d;
            }
            this.b = this.f1854a.iterator();
            long size = (long) this.f1854a.size();
            this.d = size;
            return size;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            java.util.Iterator it = this.b;
            if (it == null) {
                it = this.f1854a.iterator();
                this.b = it;
                this.d = (long) this.f1854a.size();
            }
            if (it instanceof Iterator) {
                ((Iterator) it).forEachRemaining(consumer);
            } else {
                Iterator.CC.$default$forEachRemaining(it, consumer);
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            if (j$.time.chrono.b.h(this, 4)) {
                return null;
            }
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
        public Spliterator trySplit() {
            long j;
            java.util.Iterator it = this.b;
            if (it == null) {
                it = this.f1854a.iterator();
                this.b = it;
                j = (long) this.f1854a.size();
                this.d = j;
            } else {
                j = this.d;
            }
            if (j <= 1 || !it.hasNext()) {
                return null;
            }
            int i = this.e + 1024;
            if (((long) i) > j) {
                i = (int) j;
            }
            if (i > 33554432) {
                i = 33554432;
            }
            Object[] objArr = new Object[i];
            int i2 = 0;
            do {
                objArr[i2] = it.next();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (it.hasNext());
            this.e = i2;
            long j2 = this.d;
            if (j2 != Long.MAX_VALUE) {
                this.d = j2 - ((long) i2);
            }
            return new e(objArr, 0, i2, this.c);
        }
    }

    static final class j implements Spliterator.c {

        /* renamed from: a  reason: collision with root package name */
        private final long[] f1855a;
        private int b;
        private final int c;
        private final int d;

        public j(long[] jArr, int i, int i2, int i3) {
            this.f1855a = jArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.g(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator.c
        /* renamed from: d */
        public void forEachRemaining(C c2) {
            int i;
            c2.getClass();
            long[] jArr = this.f1855a;
            int length = jArr.length;
            int i2 = this.c;
            if (length >= i2 && (i = this.b) >= 0) {
                this.b = i2;
                if (i < i2) {
                    do {
                        c2.accept(jArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return (long) (this.c - this.b);
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.c(this, consumer);
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            if (j$.time.chrono.b.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator.c
        /* renamed from: j */
        public boolean tryAdvance(C c2) {
            c2.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            long[] jArr = this.f1855a;
            this.b = i + 1;
            c2.accept(jArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator.d, j$.util.Spliterator.c, j$.util.Spliterator
        public Spliterator.c trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            long[] jArr = this.f1855a;
            this.b = i2;
            return new j(jArr, i, i2, this.d);
        }
    }

    private static void a(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new ArrayIndexOutOfBoundsException("origin(" + i3 + ") > fence(" + i4 + ")");
        } else if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException(i3);
        } else if (i4 > i2) {
            throw new ArrayIndexOutOfBoundsException(i4);
        }
    }

    public static Spliterator.a b() {
        return d;
    }

    public static Spliterator.b c() {
        return b;
    }

    public static Spliterator.c d() {
        return c;
    }

    public static Spliterator e() {
        return f1846a;
    }

    public static s.a f(Spliterator.a aVar) {
        Objects.requireNonNull(aVar);
        return new d(aVar);
    }

    public static s.b g(Spliterator.b bVar) {
        Objects.requireNonNull(bVar);
        return new b(bVar);
    }

    public static s.c h(Spliterator.c cVar) {
        Objects.requireNonNull(cVar);
        return new c(cVar);
    }

    public static java.util.Iterator i(Spliterator spliterator) {
        Objects.requireNonNull(spliterator);
        return new a(spliterator);
    }

    public static Spliterator.a j(double[] dArr, int i2, int i3, int i4) {
        Objects.requireNonNull(dArr);
        a(dArr.length, i2, i3);
        return new f(dArr, i2, i3, i4);
    }

    public static Spliterator.b k(int[] iArr, int i2, int i3, int i4) {
        Objects.requireNonNull(iArr);
        a(iArr.length, i2, i3);
        return new h(iArr, i2, i3, i4);
    }

    public static Spliterator.c l(long[] jArr, int i2, int i3, int i4) {
        Objects.requireNonNull(jArr);
        a(jArr.length, i2, i3);
        return new j(jArr, i2, i3, i4);
    }

    public static Spliterator m(Collection collection, int i2) {
        Objects.requireNonNull(collection);
        return new i(collection, i2);
    }

    public static Spliterator n(Object[] objArr, int i2, int i3, int i4) {
        Objects.requireNonNull(objArr);
        a(objArr.length, i2, i3);
        return new e(objArr, i2, i3, i4);
    }

    public static Spliterator o(java.util.Iterator it, int i2) {
        Objects.requireNonNull(it);
        return new i(it, i2);
    }
}
