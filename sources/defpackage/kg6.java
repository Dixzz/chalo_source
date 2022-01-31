package defpackage;

import defpackage.g96;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import server.zophop.Constants;

/* renamed from: kg6  reason: default package */
/* compiled from: CoroutineScheduler.kt */
public final class kg6 implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater m = AtomicLongFieldUpdater.newUpdater(kg6.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(kg6.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(kg6.class, "_isTerminated");
    public static final dg6 p = new dg6("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated;
    public volatile /* synthetic */ long controlState;
    public final int f;
    public final int g;
    public final long h;
    public final String i;
    public final ng6 j;
    public final ng6 k;
    public final AtomicReferenceArray<a> l;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: kg6$a */
    /* compiled from: CoroutineScheduler.kt */
    public final class a extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");
        public final wg6 f = new wg6();
        public b g = b.DORMANT;
        public long h;
        public long i;
        private volatile int indexInArray;
        public int j;
        public boolean k;
        private volatile Object nextParkedWorker = kg6.p;
        public volatile /* synthetic */ int workerCtl = 0;

        public a(int i2) {
            kg6.this = kg6.this;
            setDaemon(true);
            g96.a aVar = g96.g;
            this.j = g96.f.a();
            f(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final defpackage.sg6 a(boolean r11) {
            /*
            // Method dump skipped, instructions count: 145
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.kg6.a.a(boolean):sg6");
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int i2) {
            int i3 = this.j;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.j = i6;
            int i7 = i2 - 1;
            if ((i7 & i2) == 0) {
                return i6 & i7;
            }
            return (i6 & Integer.MAX_VALUE) % i2;
        }

        public final sg6 e() {
            if (d(2) == 0) {
                sg6 sg6 = (sg6) kg6.this.j.d();
                return sg6 == null ? (sg6) kg6.this.k.d() : sg6;
            }
            sg6 sg62 = (sg6) kg6.this.k.d();
            return sg62 == null ? (sg6) kg6.this.j.d() : sg62;
        }

        public final void f(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(kg6.this.i);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void g(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean h(b bVar) {
            b bVar2 = this.g;
            boolean z = bVar2 == b.CPU_ACQUIRED;
            if (z) {
                kg6.n.addAndGet(kg6.this, 4398046511104L);
            }
            if (bVar2 != bVar) {
                this.g = bVar;
            }
            return z;
        }

        public final sg6 i(boolean z) {
            long j2;
            int i2 = (int) (kg6.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int d = d(i2);
            kg6 kg6 = kg6.this;
            long j3 = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                d++;
                if (d > i2) {
                    d = 1;
                }
                a aVar = kg6.l.get(d);
                if (!(aVar == null || aVar == this)) {
                    if (z) {
                        j2 = this.f.g(aVar.f);
                    } else {
                        wg6 wg6 = this.f;
                        wg6 wg62 = aVar.f;
                        Objects.requireNonNull(wg6);
                        sg6 f2 = wg62.f();
                        if (f2 != null) {
                            wg6.a(f2, false);
                            j2 = -1;
                        } else {
                            j2 = wg6.h(wg62, false);
                        }
                    }
                    if (j2 == -1) {
                        return this.f.e();
                    }
                    if (j2 > 0) {
                        j3 = Math.min(j3, j2);
                    }
                }
            }
            if (j3 == Long.MAX_VALUE) {
                j3 = 0;
            }
            this.i = j3;
            return null;
        }

        public void run() {
            b bVar;
            b bVar2;
            loop0:
            while (true) {
                boolean z = false;
                while (!kg6.this.isTerminated() && this.g != (bVar = b.TERMINATED)) {
                    sg6 a2 = a(this.k);
                    if (a2 == null) {
                        this.k = false;
                        if (this.i == 0) {
                            if (this.nextParkedWorker != kg6.p) {
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != kg6.p) || this.workerCtl != -1 || kg6.this.isTerminated() || this.g == (bVar2 = b.TERMINATED)) {
                                        break;
                                    }
                                    h(b.PARKING);
                                    Thread.interrupted();
                                    if (this.h == 0) {
                                        this.h = System.nanoTime() + kg6.this.h;
                                    }
                                    LockSupport.parkNanos(kg6.this.h);
                                    if (System.nanoTime() - this.h >= 0) {
                                        this.h = 0;
                                        kg6 kg6 = kg6.this;
                                        synchronized (kg6.l) {
                                            if (!kg6.isTerminated()) {
                                                if (((int) (kg6.controlState & 2097151)) > kg6.f) {
                                                    if (m.compareAndSet(this, -1, 1)) {
                                                        int i2 = this.indexInArray;
                                                        f(0);
                                                        kg6.i(this, i2, 0);
                                                        int andDecrement = (int) (kg6.n.getAndDecrement(kg6) & 2097151);
                                                        if (andDecrement != i2) {
                                                            a aVar = kg6.l.get(andDecrement);
                                                            n86.c(aVar);
                                                            kg6.l.set(i2, aVar);
                                                            aVar.f(i2);
                                                            kg6.i(aVar, andDecrement, i2);
                                                        }
                                                        kg6.l.set(andDecrement, null);
                                                        this.g = bVar2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                kg6.this.h(this);
                            }
                        } else if (!z) {
                            z = true;
                        } else {
                            h(b.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.i);
                            this.i = 0;
                        }
                    } else {
                        this.i = 0;
                        int l2 = a2.g.l();
                        this.h = 0;
                        if (this.g == b.PARKING) {
                            this.g = b.BLOCKING;
                        }
                        if (l2 != 0 && h(b.BLOCKING)) {
                            kg6.this.k();
                        }
                        kg6.this.j(a2);
                        if (l2 != 0) {
                            kg6.n.addAndGet(kg6.this, -2097152);
                            if (this.g != bVar) {
                                this.g = b.DORMANT;
                            }
                        }
                    }
                }
            }
            h(b.TERMINATED);
        }
    }

    /* renamed from: kg6$b */
    /* compiled from: CoroutineScheduler.kt */
    public enum b {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public kg6(int i2, int i3, long j2, String str) {
        this.f = i2;
        this.g = i3;
        this.h = j2;
        this.i = str;
        if (i2 >= 1) {
            if (i3 >= i2) {
                if (i3 <= 2097150) {
                    if (j2 > 0) {
                        this.j = new ng6();
                        this.k = new ng6();
                        this.parkedWorkersStack = 0;
                        this.l = new AtomicReferenceArray<>(i3 + 1);
                        this.controlState = ((long) i2) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(hj1.J("Max pool size ", i3, " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(hj1.L("Max pool size ", i3, " should be greater than or equals to core pool size ", i2).toString());
        }
        throw new IllegalArgumentException(hj1.J("Core pool size ", i2, " should be at least 1").toString());
    }

    public final int a() {
        synchronized (this.l) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
            boolean z = false;
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= this.f) {
                return 0;
            }
            if (i2 >= this.g) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (i4 > 0 && this.l.get(i4) == null) {
                a aVar = new a(i4);
                this.l.set(i4, aVar);
                if (i4 == ((int) (2097151 & n.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    aVar.start();
                    return i3 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final sg6 c(Runnable runnable, tg6 tg6) {
        long a2 = vg6.e.a();
        if (!(runnable instanceof sg6)) {
            return new ug6(runnable, a2, tg6);
        }
        sg6 sg6 = (sg6) runnable;
        sg6.f = a2;
        sg6.g = tg6;
        return sg6;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i2;
        sg6 sg6;
        boolean z;
        if (o.compareAndSet(this, 0, 1)) {
            a e = e();
            synchronized (this.l) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    a aVar = this.l.get(i3);
                    n86.c(aVar);
                    if (aVar != e) {
                        while (aVar.isAlive()) {
                            LockSupport.unpark(aVar);
                            aVar.join(Constants.THRESHOLD_TIMESTAMP);
                        }
                        wg6 wg6 = aVar.f;
                        ng6 ng6 = this.k;
                        Objects.requireNonNull(wg6);
                        sg6 sg62 = (sg6) wg6.b.getAndSet(wg6, null);
                        if (sg62 != null) {
                            ng6.a(sg62);
                        }
                        do {
                            sg6 f2 = wg6.f();
                            if (f2 == null) {
                                z = false;
                                continue;
                            } else {
                                ng6.a(f2);
                                z = true;
                                continue;
                            }
                        } while (z);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            this.k.b();
            this.j.b();
            while (true) {
                if (e == null) {
                    sg6 = null;
                } else {
                    sg6 = e.a(true);
                }
                if (sg6 == null) {
                    sg6 = (sg6) this.j.d();
                }
                if (sg6 == null && (sg6 = (sg6) this.k.d()) == null) {
                    break;
                }
                j(sg6);
            }
            if (e != null) {
                e.h(b.TERMINATED);
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final a e() {
        Thread currentThread = Thread.currentThread();
        a aVar = currentThread instanceof a ? (a) currentThread : null;
        if (aVar != null && n86.a(kg6.this, this)) {
            return aVar;
        }
        return null;
    }

    public void execute(Runnable runnable) {
        f(runnable, qg6.f, false);
    }

    public final void f(Runnable runnable, tg6 tg6, boolean z) {
        sg6 sg6;
        boolean z2;
        sg6 c = c(runnable, tg6);
        a e = e();
        boolean z3 = true;
        if (e == null || e.g == b.TERMINATED || (c.g.l() == 0 && e.g == b.BLOCKING)) {
            sg6 = c;
        } else {
            e.k = true;
            sg6 = e.f.a(c, z);
        }
        if (sg6 != null) {
            if (sg6.g.l() == 1) {
                z2 = this.k.a(sg6);
            } else {
                z2 = this.j.a(sg6);
            }
            if (!z2) {
                throw new RejectedExecutionException(n86.j(this.i, " was terminated"));
            }
        }
        if (!z || e == null) {
            z3 = false;
        }
        if (c.g.l() != 0) {
            long addAndGet = n.addAndGet(this, 2097152);
            if (!z3 && !m() && !l(addAndGet)) {
                m();
            }
        } else if (!z3) {
            k();
        }
    }

    public final int g(a aVar) {
        Object c = aVar.c();
        while (c != p) {
            if (c == null) {
                return 0;
            }
            a aVar2 = (a) c;
            int b2 = aVar2.b();
            if (b2 != 0) {
                return b2;
            }
            c = aVar2.c();
        }
        return -1;
    }

    public final boolean h(a aVar) {
        long j2;
        int b2;
        if (aVar.c() != p) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            b2 = aVar.b();
            aVar.g(this.l.get((int) (2097151 & j2)));
        } while (!m.compareAndSet(this, j2, ((2097152 + j2) & -2097152) | ((long) b2)));
        return true;
    }

    public final void i(a aVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & -2097152;
            if (i4 == i2) {
                i4 = i3 == 0 ? g(aVar) : i3;
            }
            if (i4 >= 0 && m.compareAndSet(this, j2, j3 | ((long) i4))) {
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isTerminated() {
        /*
            r1 = this;
            int r0 = r1._isTerminated
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kg6.isTerminated():boolean");
    }

    public final void j(sg6 sg6) {
        try {
            sg6.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public final void k() {
        if (!m() && !l(this.controlState)) {
            m();
        }
    }

    public final boolean l(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 < this.f) {
            int a2 = a();
            if (a2 == 1 && this.f > 1) {
                a();
            }
            if (a2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            a aVar = this.l.get((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & -2097152;
                int g2 = g(aVar);
                if (g2 >= 0 && m.compareAndSet(this, j2, ((long) g2) | j3)) {
                    aVar.g(p);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.m.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public String toString() {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        int length = this.l.length();
        int i6 = 0;
        if (1 < length) {
            i4 = 0;
            int i7 = 0;
            i3 = 0;
            i2 = 0;
            int i8 = 1;
            while (true) {
                int i9 = i8 + 1;
                a aVar = this.l.get(i8);
                if (aVar != null) {
                    int d = aVar.f.d();
                    int ordinal = aVar.g.ordinal();
                    if (ordinal == 0) {
                        i7++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(d);
                        sb.append('c');
                        arrayList.add(sb.toString());
                    } else if (ordinal == 1) {
                        i4++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(d);
                        sb2.append('b');
                        arrayList.add(sb2.toString());
                    } else if (ordinal == 2) {
                        i6++;
                    } else if (ordinal == 3) {
                        i3++;
                        if (d > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(d);
                            sb3.append('d');
                            arrayList.add(sb3.toString());
                        }
                    } else if (ordinal == 4) {
                        i2++;
                    }
                }
                if (i9 >= length) {
                    break;
                }
                i8 = i9;
            }
            i5 = i6;
            i6 = i7;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        long j2 = this.controlState;
        return this.i + '@' + hd3.l1(this) + "[Pool Size {core = " + this.f + ", max = " + this.g + "}, Worker States {CPU = " + i6 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i3 + ", terminated = " + i2 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.j.c() + ", global blocking queue size = " + this.k.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
