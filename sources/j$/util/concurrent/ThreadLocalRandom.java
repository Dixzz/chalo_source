package j$.util.concurrent;

import a.T0;
import a.V0;
import a.X0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.Consumer;
import j$.util.function.q;
import j$.util.function.w;
import j$.util.r;
import j$.util.stream.Q1;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ThreadLocalRandom extends Random {
    private static final AtomicInteger d = new AtomicInteger();
    private static final AtomicLong e;
    private static final ThreadLocal f = new ThreadLocal();
    private static final ThreadLocal g = new a();

    /* renamed from: a  reason: collision with root package name */
    long f1656a;
    int b;
    boolean c = true;

    class a extends ThreadLocal<ThreadLocalRandom> {
        a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom(null);
        }
    }

    static final class b implements Spliterator.a {

        /* renamed from: a  reason: collision with root package name */
        long f1657a;
        final long b;
        final double c;
        final double d;

        b(long j, long j2, double d2, double d3) {
            this.f1657a = j;
            this.b = j2;
            this.c = d2;
            this.d = d3;
        }

        /* renamed from: a */
        public b trySplit() {
            long j = this.f1657a;
            long j2 = (this.b + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.f1657a = j2;
            return new b(j, j2, this.c, this.d);
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator.a
        /* renamed from: e */
        public void forEachRemaining(q qVar) {
            qVar.getClass();
            long j = this.f1657a;
            long j2 = this.b;
            if (j < j2) {
                this.f1657a = j2;
                double d2 = this.c;
                double d3 = this.d;
                ThreadLocalRandom current = ThreadLocalRandom.current();
                do {
                    qVar.accept(current.c(d2, d3));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.b - this.f1657a;
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
        /* renamed from: o */
        public boolean tryAdvance(q qVar) {
            qVar.getClass();
            long j = this.f1657a;
            if (j >= this.b) {
                return false;
            }
            qVar.accept(ThreadLocalRandom.current().c(this.c, this.d));
            this.f1657a = j + 1;
            return true;
        }
    }

    static final class c implements Spliterator.b {

        /* renamed from: a  reason: collision with root package name */
        long f1658a;
        final long b;
        final int c;
        final int d;

        c(long j, long j2, int i, int i2) {
            this.f1658a = j;
            this.b = j2;
            this.c = i;
            this.d = i2;
        }

        /* renamed from: a */
        public c trySplit() {
            long j = this.f1658a;
            long j2 = (this.b + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.f1658a = j2;
            return new c(j, j2, this.c, this.d);
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.f(this, consumer);
        }

        @Override // j$.util.Spliterator.b
        /* renamed from: c */
        public void forEachRemaining(w wVar) {
            wVar.getClass();
            long j = this.f1658a;
            long j2 = this.b;
            if (j < j2) {
                this.f1658a = j2;
                int i = this.c;
                int i2 = this.d;
                ThreadLocalRandom current = ThreadLocalRandom.current();
                do {
                    wVar.accept(current.d(i, i2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.b - this.f1658a;
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
        /* renamed from: h */
        public boolean tryAdvance(w wVar) {
            wVar.getClass();
            long j = this.f1658a;
            if (j >= this.b) {
                return false;
            }
            wVar.accept(ThreadLocalRandom.current().d(this.c, this.d));
            this.f1658a = j + 1;
            return true;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.chrono.b.h(this, i);
        }
    }

    static final class d implements Spliterator.c {

        /* renamed from: a  reason: collision with root package name */
        long f1659a;
        final long b;
        final long c;
        final long d;

        d(long j, long j2, long j3, long j4) {
            this.f1659a = j;
            this.b = j2;
            this.c = j3;
            this.d = j4;
        }

        /* renamed from: a */
        public d trySplit() {
            long j = this.f1659a;
            long j2 = (this.b + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.f1659a = j2;
            return new d(j, j2, this.c, this.d);
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.g(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator.c
        /* renamed from: d */
        public void forEachRemaining(C c2) {
            c2.getClass();
            long j = this.f1659a;
            long j2 = this.b;
            if (j < j2) {
                this.f1659a = j2;
                long j3 = this.c;
                long j4 = this.d;
                ThreadLocalRandom current = ThreadLocalRandom.current();
                do {
                    c2.accept(current.e(j3, j4));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.b - this.f1659a;
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
        /* renamed from: j */
        public boolean tryAdvance(C c2) {
            c2.getClass();
            long j = this.f1659a;
            if (j >= this.b) {
                return false;
            }
            c2.accept(ThreadLocalRandom.current().e(this.c, this.d));
            this.f1659a = j + 1;
            return true;
        }
    }

    static {
        long j;
        if (((Boolean) AccessController.doPrivileged(new d())).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            j = ((long) seed[0]) & 255;
            for (int i = 1; i < 8; i++) {
                j = (j << 8) | (((long) seed[i]) & 255);
            }
        } else {
            j = h(System.nanoTime()) ^ h(System.currentTimeMillis());
        }
        e = new AtomicLong(j);
        new ObjectStreamField("rnd", Long.TYPE);
        new ObjectStreamField("initialized", Boolean.TYPE);
    }

    private ThreadLocalRandom() {
    }

    ThreadLocalRandom(d dVar) {
    }

    static final int a(int i) {
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        ((ThreadLocalRandom) g.get()).b = i4;
        return i4;
    }

    static final int b() {
        return ((ThreadLocalRandom) g.get()).b;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) g.get();
        if (threadLocalRandom.b == 0) {
            f();
        }
        return threadLocalRandom;
    }

    static final void f() {
        int addAndGet = d.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long h = h(e.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) g.get();
        threadLocalRandom.f1656a = h;
        threadLocalRandom.b = addAndGet;
    }

    private static int g(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        return (int) (((j2 ^ (j2 >>> 33)) * -4265267296055464877L) >>> 32);
    }

    private static long h(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    /* access modifiers changed from: package-private */
    public final double c(double d2, double d3) {
        double nextLong = ((double) (nextLong() >>> 11)) * 1.1102230246251565E-16d;
        if (d2 >= d3) {
            return nextLong;
        }
        double d4 = ((d3 - d2) * nextLong) + d2;
        return d4 >= d3 ? Double.longBitsToDouble(Double.doubleToLongBits(d3) - 1) : d4;
    }

    /* access modifiers changed from: package-private */
    public final int d(int i, int i2) {
        int i3;
        int g2 = g(i());
        if (i >= i2) {
            return g2;
        }
        int i4 = i2 - i;
        int i5 = i4 - 1;
        if ((i4 & i5) == 0) {
            i3 = g2 & i5;
        } else if (i4 > 0) {
            int i6 = g2 >>> 1;
            while (true) {
                int i7 = i6 + i5;
                i3 = i6 % i4;
                if (i7 - i3 >= 0) {
                    break;
                }
                i6 = g(i()) >>> 1;
            }
        } else {
            while (true) {
                if (g2 >= i && g2 < i2) {
                    return g2;
                }
                g2 = g(i());
            }
        }
        return i3 + i;
    }

    public DoubleStream doubles() {
        return T0.m0(Q1.o(new b(0, Long.MAX_VALUE, Double.MAX_VALUE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), false));
    }

    /* access modifiers changed from: package-private */
    public final long e(long j, long j2) {
        long h = h(i());
        if (j >= j2) {
            return h;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (h & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = h >>> 1;
                long j6 = j5 + j4;
                long j7 = j5 % j3;
                if (j6 - j7 >= 0) {
                    return j7 + j;
                }
                h = h(i());
            }
        } else {
            while (true) {
                if (h >= j && h < j2) {
                    return h;
                }
                h = h(i());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final long i() {
        long j = this.f1656a - 7046029254386353131L;
        this.f1656a = j;
        return j;
    }

    public IntStream ints() {
        return V0.m0(Q1.p(new c(0, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false));
    }

    public LongStream longs() {
        return X0.m0(Q1.q(new d(0, Long.MAX_VALUE, Long.MAX_VALUE, 0), false));
    }

    /* access modifiers changed from: protected */
    public int next(int i) {
        return (int) (h(i()) >>> (64 - i));
    }

    public boolean nextBoolean() {
        return g(i()) < 0;
    }

    public double nextDouble() {
        return ((double) (h(i()) >>> 11)) * 1.1102230246251565E-16d;
    }

    public float nextFloat() {
        return ((float) (g(i()) >>> 8)) * 5.9604645E-8f;
    }

    public double nextGaussian() {
        ThreadLocal threadLocal = f;
        Double d2 = (Double) threadLocal.get();
        if (d2 != null) {
            threadLocal.set(null);
            return d2.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d3 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d3 < 1.0d && d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d3) * -2.0d) / d3);
                f.set(new Double(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    public int nextInt() {
        return g(i());
    }

    public int nextInt(int i) {
        if (i > 0) {
            int g2 = g(i());
            int i2 = i - 1;
            if ((i & i2) == 0) {
                return g2 & i2;
            }
            while (true) {
                int i3 = g2 >>> 1;
                int i4 = i3 + i2;
                int i5 = i3 % i;
                if (i4 - i5 >= 0) {
                    return i5;
                }
                g2 = g(i());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public long nextLong() {
        return h(i());
    }

    public void setSeed(long j) {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public DoubleStream doubles(double d2, double d3) {
        if (d2 < d3) {
            return T0.m0(Q1.o(new b(0, Long.MAX_VALUE, d2, d3), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public IntStream ints(int i, int i2) {
        if (i < i2) {
            return V0.m0(Q1.p(new c(0, Long.MAX_VALUE, i, i2), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public LongStream longs(long j) {
        if (j >= 0) {
            return X0.m0(Q1.q(new d(0, j, Long.MAX_VALUE, 0), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public DoubleStream doubles(long j) {
        if (j >= 0) {
            return T0.m0(Q1.o(new b(0, j, Double.MAX_VALUE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public IntStream ints(long j) {
        if (j >= 0) {
            return V0.m0(Q1.p(new c(0, j, Integer.MAX_VALUE, 0), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public LongStream longs(long j, long j2) {
        if (j < j2) {
            return X0.m0(Q1.q(new d(0, Long.MAX_VALUE, j, j2), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public DoubleStream doubles(long j, double d2, double d3) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (d2 < d3) {
            return T0.m0(Q1.o(new b(0, j, d2, d3), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    public IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (i < i2) {
            return V0.m0(Q1.p(new c(0, j, i, i2), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    public LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (j2 < j3) {
            return X0.m0(Q1.q(new d(0, j, j2, j3), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }
}
