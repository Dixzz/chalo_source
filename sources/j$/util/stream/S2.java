package j$.util.stream;

import a.D;
import com.rabbitmq.client.AMQP;
import j$.lang.Iterable;
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
import j$.util.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/* access modifiers changed from: package-private */
public class S2<E> extends AbstractC0172j1 implements Consumer<E>, Iterable<E>, Iterable {
    protected Object[] e = new Object[16];
    protected Object[][] f;

    /* access modifiers changed from: package-private */
    public class a implements Spliterator<E> {

        /* renamed from: a  reason: collision with root package name */
        int f1741a;
        final int b;
        int c;
        final int d;
        Object[] e;

        a(int i, int i2, int i3, int i4) {
            this.f1741a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            Object[][] objArr = S2.this.f;
            this.e = objArr == null ? S2.this.e : objArr[i];
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            Objects.requireNonNull(consumer);
            int i = this.f1741a;
            int i2 = this.b;
            if (i >= i2 && (i != i2 || this.c >= this.d)) {
                return false;
            }
            Object[] objArr = this.e;
            int i3 = this.c;
            this.c = i3 + 1;
            consumer.accept(objArr[i3]);
            if (this.c == this.e.length) {
                this.c = 0;
                int i4 = this.f1741a + 1;
                this.f1741a = i4;
                Object[][] objArr2 = S2.this.f;
                if (objArr2 != null && i4 <= this.b) {
                    this.e = objArr2[i4];
                }
            }
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 16464;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            int i = this.f1741a;
            int i2 = this.b;
            if (i == i2) {
                return ((long) this.d) - ((long) this.c);
            }
            long[] jArr = S2.this.d;
            return ((jArr[i2] + ((long) this.d)) - jArr[i]) - ((long) this.c);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            int i;
            Objects.requireNonNull(consumer);
            int i2 = this.f1741a;
            int i3 = this.b;
            if (i2 < i3 || (i2 == i3 && this.c < this.d)) {
                int i4 = this.c;
                while (true) {
                    i = this.b;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = S2.this.f[i2];
                    while (i4 < objArr.length) {
                        consumer.accept(objArr[i4]);
                        i4++;
                    }
                    i4 = 0;
                    i2++;
                }
                Object[] objArr2 = this.f1741a == i ? this.e : S2.this.f[i];
                int i5 = this.d;
                while (i4 < i5) {
                    consumer.accept(objArr2[i4]);
                    i4++;
                }
                this.f1741a = this.b;
                this.c = this.d;
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

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.f1741a;
            int i2 = this.b;
            if (i < i2) {
                S2 s2 = S2.this;
                int i3 = i2 - 1;
                a aVar = new a(i, i3, this.c, s2.f[i3].length);
                int i4 = this.b;
                this.f1741a = i4;
                this.c = 0;
                this.e = S2.this.f[i4];
                return aVar;
            } else if (i != i2) {
                return null;
            } else {
                int i5 = this.d;
                int i6 = this.c;
                int i7 = (i5 - i6) / 2;
                if (i7 == 0) {
                    return null;
                }
                Spliterator n = u.n(this.e, i6, i6 + i7, 1040);
                this.c += i7;
                return n;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends e<Double, double[], q> implements q {

        /* access modifiers changed from: package-private */
        public class a extends e<Double, double[], q>.a implements Spliterator.a {
            a(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public void a(Object obj, int i, Object obj2) {
                ((q) obj2).accept(((double[]) obj)[i]);
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.e(this, consumer);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public Spliterator.d f(Object obj, int i, int i2) {
                return u.j((double[]) obj, i, i2 + i, 1040);
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.a(this, consumer);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public Spliterator.d g(int i, int i2, int i3, int i4) {
                return new a(i, i2, i3, i4);
            }
        }

        b() {
        }

        b(int i) {
            super(i);
        }

        /* renamed from: B */
        public Spliterator.a spliterator() {
            return new a(0, this.c, 0, this.b);
        }

        @Override // j$.util.function.q
        public void accept(double d) {
            A();
            int i = this.b;
            this.b = i + 1;
            ((double[]) this.e)[i] = d;
        }

        @Override // j$.util.stream.S2.e
        public Object c(int i) {
            return new double[i];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof q) {
                h((q) consumer);
            } else if (!i3.f1797a) {
                spliterator().forEachRemaining(consumer);
            } else {
                i3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            }
        }

        @Override // j$.lang.Iterable, java.lang.Iterable
        public Iterator iterator() {
            return u.f(spliterator());
        }

        @Override // j$.util.function.q
        public q k(q qVar) {
            Objects.requireNonNull(qVar);
            return new C0129f(this, qVar);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public void t(Object obj, int i, int i2, Object obj2) {
            double[] dArr = (double[]) obj;
            q qVar = (q) obj2;
            while (i < i2) {
                qVar.accept(dArr[i]);
                i++;
            }
        }

        public String toString() {
            double[] dArr = (double[]) e();
            if (dArr.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(dArr));
            }
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(dArr, (int) AMQP.REPLY_SUCCESS)));
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public int u(Object obj) {
            return ((double[]) obj).length;
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public Object[] z(int i) {
            return new double[i][];
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends e<Integer, int[], w> implements w {

        /* access modifiers changed from: package-private */
        public class a extends e<Integer, int[], w>.a implements Spliterator.b {
            a(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public void a(Object obj, int i, Object obj2) {
                ((w) obj2).accept(((int[]) obj)[i]);
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.f(this, consumer);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public Spliterator.d f(Object obj, int i, int i2) {
                return u.k((int[]) obj, i, i2 + i, 1040);
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.b(this, consumer);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public Spliterator.d g(int i, int i2, int i3, int i4) {
                return new a(i, i2, i3, i4);
            }
        }

        c() {
        }

        c(int i) {
            super(i);
        }

        /* renamed from: B */
        public Spliterator.b spliterator() {
            return new a(0, this.c, 0, this.b);
        }

        @Override // j$.util.function.w
        public void accept(int i) {
            A();
            int i2 = this.b;
            this.b = i2 + 1;
            ((int[]) this.e)[i2] = i;
        }

        @Override // j$.util.stream.S2.e
        public Object c(int i) {
            return new int[i];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof w) {
                h((w) consumer);
            } else if (!i3.f1797a) {
                spliterator().forEachRemaining(consumer);
            } else {
                i3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            }
        }

        @Override // j$.lang.Iterable, java.lang.Iterable
        public Iterator iterator() {
            return u.g(spliterator());
        }

        @Override // j$.util.function.w
        public w l(w wVar) {
            Objects.requireNonNull(wVar);
            return new C0130g(this, wVar);
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public void t(Object obj, int i, int i2, Object obj2) {
            int[] iArr = (int[]) obj;
            w wVar = (w) obj2;
            while (i < i2) {
                wVar.accept(iArr[i]);
                i++;
            }
        }

        public String toString() {
            int[] iArr = (int[]) e();
            if (iArr.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(iArr));
            }
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(iArr, (int) AMQP.REPLY_SUCCESS)));
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public int u(Object obj) {
            return ((int[]) obj).length;
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public Object[] z(int i) {
            return new int[i][];
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends e<Long, long[], C> implements C {

        /* access modifiers changed from: package-private */
        public class a extends e<Long, long[], C>.a implements Spliterator.c {
            a(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public void a(Object obj, int i, Object obj2) {
                ((C) obj2).accept(((long[]) obj)[i]);
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.g(this, consumer);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public Spliterator.d f(Object obj, int i, int i2) {
                return u.l((long[]) obj, i, i2 + i, 1040);
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.c(this, consumer);
            }

            /* access modifiers changed from: package-private */
            @Override // j$.util.stream.S2.e.a
            public Spliterator.d g(int i, int i2, int i3, int i4) {
                return new a(i, i2, i3, i4);
            }
        }

        d() {
        }

        d(int i) {
            super(i);
        }

        /* renamed from: B */
        public Spliterator.c spliterator() {
            return new a(0, this.c, 0, this.b);
        }

        @Override // j$.util.function.C
        public void accept(long j) {
            A();
            int i = this.b;
            this.b = i + 1;
            ((long[]) this.e)[i] = j;
        }

        @Override // j$.util.stream.S2.e
        public Object c(int i) {
            return new long[i];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof C) {
                h((C) consumer);
            } else if (!i3.f1797a) {
                spliterator().forEachRemaining(consumer);
            } else {
                i3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
        }

        @Override // j$.util.function.C
        public C g(C c) {
            Objects.requireNonNull(c);
            return new C0131h(this, c);
        }

        @Override // j$.lang.Iterable, java.lang.Iterable
        public Iterator iterator() {
            return u.h(spliterator());
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public void t(Object obj, int i, int i2, Object obj2) {
            long[] jArr = (long[]) obj;
            C c = (C) obj2;
            while (i < i2) {
                c.accept(jArr[i]);
                i++;
            }
        }

        public String toString() {
            long[] jArr = (long[]) e();
            if (jArr.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(jArr));
            }
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(jArr, (int) AMQP.REPLY_SUCCESS)));
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public int u(Object obj) {
            return ((long[]) obj).length;
        }

        /* access modifiers changed from: protected */
        @Override // j$.util.stream.S2.e
        public Object[] z(int i) {
            return new long[i][];
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class e<E, T_ARR, T_CONS> extends AbstractC0172j1 implements Iterable<E>, Iterable {
        Object e = c(16);
        Object[] f;

        abstract class a<T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>> implements Spliterator.d<E, T_CONS, T_SPLITR> {

            /* renamed from: a  reason: collision with root package name */
            int f1742a;
            final int b;
            int c;
            final int d;
            Object e;

            a(int i, int i2, int i3, int i4) {
                this.f1742a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
                Object[] objArr = e.this.f;
                this.e = objArr == null ? e.this.e : objArr[i];
            }

            /* access modifiers changed from: package-private */
            public abstract void a(Object obj, int i, Object obj2);

            @Override // j$.util.Spliterator
            public int characteristics() {
                return 16464;
            }

            @Override // j$.util.Spliterator
            public long estimateSize() {
                int i = this.f1742a;
                int i2 = this.b;
                if (i == i2) {
                    return ((long) this.d) - ((long) this.c);
                }
                long[] jArr = e.this.d;
                return ((jArr[i2] + ((long) this.d)) - jArr[i]) - ((long) this.c);
            }

            /* access modifiers changed from: package-private */
            public abstract Spliterator.d f(Object obj, int i, int i2);

            @Override // j$.util.Spliterator.d
            /* renamed from: forEachRemaining */
            public void e(Object obj) {
                int i;
                Objects.requireNonNull(obj);
                int i2 = this.f1742a;
                int i3 = this.b;
                if (i2 < i3 || (i2 == i3 && this.c < this.d)) {
                    int i4 = this.c;
                    while (true) {
                        i = this.b;
                        if (i2 >= i) {
                            break;
                        }
                        e eVar = e.this;
                        Object obj2 = eVar.f[i2];
                        eVar.t(obj2, i4, eVar.u(obj2), obj);
                        i4 = 0;
                        i2++;
                    }
                    e.this.t(this.f1742a == i ? this.e : e.this.f[i], i4, this.d, obj);
                    this.f1742a = this.b;
                    this.c = this.d;
                }
            }

            /* access modifiers changed from: package-private */
            public abstract Spliterator.d g(int i, int i2, int i3, int i4);

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
                Objects.requireNonNull(obj);
                int i = this.f1742a;
                int i2 = this.b;
                if (i >= i2 && (i != i2 || this.c >= this.d)) {
                    return false;
                }
                Object obj2 = this.e;
                int i3 = this.c;
                this.c = i3 + 1;
                a(obj2, i3, obj);
                if (this.c == e.this.u(this.e)) {
                    this.c = 0;
                    int i4 = this.f1742a + 1;
                    this.f1742a = i4;
                    Object[] objArr = e.this.f;
                    if (objArr != null && i4 <= this.b) {
                        this.e = objArr[i4];
                    }
                }
                return true;
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public Spliterator.d trySplit() {
                int i = this.f1742a;
                int i2 = this.b;
                if (i < i2) {
                    int i3 = this.c;
                    e eVar = e.this;
                    Spliterator.d g = g(i, i2 - 1, i3, eVar.u(eVar.f[i2 - 1]));
                    int i4 = this.b;
                    this.f1742a = i4;
                    this.c = 0;
                    this.e = e.this.f[i4];
                    return g;
                } else if (i != i2) {
                    return null;
                } else {
                    int i5 = this.d;
                    int i6 = this.c;
                    int i7 = (i5 - i6) / 2;
                    if (i7 == 0) {
                        return null;
                    }
                    Spliterator.d f2 = f(this.e, i6, i7);
                    this.c += i7;
                    return f2;
                }
            }
        }

        e() {
        }

        e(int i) {
            super(i);
        }

        private void y() {
            if (this.f == null) {
                Object[] z = z(8);
                this.f = z;
                this.d = new long[8];
                z[0] = this.e;
            }
        }

        /* access modifiers changed from: protected */
        public void A() {
            if (this.b == u(this.e)) {
                y();
                int i = this.c;
                int i2 = i + 1;
                Object[] objArr = this.f;
                if (i2 >= objArr.length || objArr[i + 1] == null) {
                    x(v() + 1);
                }
                this.b = 0;
                int i3 = this.c + 1;
                this.c = i3;
                this.e = this.f[i3];
            }
        }

        public abstract Object c(int i);

        @Override // j$.util.stream.AbstractC0172j1
        public void clear() {
            Object[] objArr = this.f;
            if (objArr != null) {
                this.e = objArr[0];
                this.f = null;
                this.d = null;
            }
            this.b = 0;
            this.c = 0;
        }

        public void d(Object obj, int i) {
            long j = (long) i;
            long count = count() + j;
            if (count > ((long) u(obj)) || count < j) {
                throw new IndexOutOfBoundsException("does not fit");
            } else if (this.c == 0) {
                System.arraycopy(this.e, 0, obj, i, this.b);
            } else {
                for (int i2 = 0; i2 < this.c; i2++) {
                    Object[] objArr = this.f;
                    System.arraycopy(objArr[i2], 0, obj, i, u(objArr[i2]));
                    i += u(this.f[i2]);
                }
                int i3 = this.b;
                if (i3 > 0) {
                    System.arraycopy(this.e, 0, obj, i, i3);
                }
            }
        }

        public Object e() {
            long count = count();
            if (count < 2147483639) {
                Object c = c((int) count);
                d(c, 0);
                return c;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        public void h(Object obj) {
            for (int i = 0; i < this.c; i++) {
                Object[] objArr = this.f;
                t(objArr[i], 0, u(objArr[i]), obj);
            }
            t(this.e, 0, this.b, obj);
        }

        @Override // j$.lang.Iterable, java.lang.Iterable
        public abstract Spliterator spliterator();

        /* access modifiers changed from: protected */
        public abstract void t(Object obj, int i, int i2, Object obj2);

        /* access modifiers changed from: protected */
        public abstract int u(Object obj);

        /* access modifiers changed from: protected */
        public long v() {
            int i = this.c;
            if (i == 0) {
                return (long) u(this.e);
            }
            return ((long) u(this.f[i])) + this.d[i];
        }

        /* access modifiers changed from: protected */
        public int w(long j) {
            if (this.c == 0) {
                if (j < ((long) this.b)) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else if (j < count()) {
                for (int i = 0; i <= this.c; i++) {
                    if (j < this.d[i] + ((long) u(this.f[i]))) {
                        return i;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
        }

        /* access modifiers changed from: protected */
        public final void x(long j) {
            long v = v();
            if (j > v) {
                y();
                int i = this.c;
                while (true) {
                    i++;
                    if (j > v) {
                        Object[] objArr = this.f;
                        if (i >= objArr.length) {
                            int length = objArr.length * 2;
                            this.f = Arrays.copyOf(objArr, length);
                            this.d = Arrays.copyOf(this.d, length);
                        }
                        int s = s(i);
                        this.f[i] = c(s);
                        long[] jArr = this.d;
                        int i2 = i - 1;
                        jArr[i] = jArr[i2] + ((long) u(this.f[i2]));
                        v += (long) s;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract Object[] z(int i);
    }

    S2() {
    }

    private void v() {
        if (this.f == null) {
            Object[][] objArr = new Object[8][];
            this.f = objArr;
            this.d = new long[8];
            objArr[0] = this.e;
        }
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (this.b == this.e.length) {
            v();
            int i = this.c;
            int i2 = i + 1;
            Object[][] objArr = this.f;
            if (i2 >= objArr.length || objArr[i + 1] == null) {
                u(t() + 1);
            }
            this.b = 0;
            int i3 = this.c + 1;
            this.c = i3;
            this.e = this.f[i3];
        }
        Object[] objArr2 = this.e;
        int i4 = this.b;
        this.b = i4 + 1;
        objArr2[i4] = obj;
    }

    @Override // j$.util.stream.AbstractC0172j1
    public void clear() {
        Object[][] objArr = this.f;
        if (objArr != null) {
            this.e = objArr[0];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.e;
                if (i >= objArr2.length) {
                    break;
                }
                objArr2[i] = null;
                i++;
            }
            this.f = null;
            this.d = null;
        } else {
            for (int i2 = 0; i2 < this.b; i2++) {
                this.e[i2] = null;
            }
        }
        this.b = 0;
        this.c = 0;
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.lang.Iterable
    public void forEach(Consumer consumer) {
        for (int i = 0; i < this.c; i++) {
            for (Object obj : this.f[i]) {
                consumer.accept(obj);
            }
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            consumer.accept(this.e[i2]);
        }
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(D.b(consumer));
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator iterator() {
        return u.i(spliterator());
    }

    public void j(Object[] objArr, int i) {
        long j = (long) i;
        long count = count() + j;
        if (count > ((long) objArr.length) || count < j) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.c == 0) {
            System.arraycopy(this.e, 0, objArr, i, this.b);
        } else {
            for (int i2 = 0; i2 < this.c; i2++) {
                Object[][] objArr2 = this.f;
                System.arraycopy(objArr2[i2], 0, objArr, i, objArr2[i2].length);
                i += this.f[i2].length;
            }
            int i3 = this.b;
            if (i3 > 0) {
                System.arraycopy(this.e, 0, objArr, i, i3);
            }
        }
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Spliterator spliterator() {
        return new a(0, this.c, 0, this.b);
    }

    /* access modifiers changed from: protected */
    public long t() {
        int i = this.c;
        if (i == 0) {
            return (long) this.e.length;
        }
        return ((long) this.f[i].length) + this.d[i];
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        forEach(new C0140b1(arrayList));
        StringBuilder a2 = j$.com.android.tools.r8.a.a("SpinedBuffer:");
        a2.append(arrayList.toString());
        return a2.toString();
    }

    /* access modifiers changed from: protected */
    public final void u(long j) {
        long t = t();
        if (j > t) {
            v();
            int i = this.c;
            while (true) {
                i++;
                if (j > t) {
                    Object[][] objArr = this.f;
                    if (i >= objArr.length) {
                        int length = objArr.length * 2;
                        this.f = (Object[][]) Arrays.copyOf(objArr, length);
                        this.d = Arrays.copyOf(this.d, length);
                    }
                    int s = s(i);
                    Object[][] objArr2 = this.f;
                    objArr2[i] = new Object[s];
                    long[] jArr = this.d;
                    int i2 = i - 1;
                    jArr[i] = jArr[i2] + ((long) objArr2[i2].length);
                    t += (long) s;
                } else {
                    return;
                }
            }
        }
    }
}
