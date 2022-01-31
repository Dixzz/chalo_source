package defpackage;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: mt  reason: default package */
/* compiled from: AbstractFuture */
public abstract class mt<V> implements gy4<V> {
    public static final boolean i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger j = Logger.getLogger(mt.class.getName());
    public static final b k;
    public static final Object l = new Object();
    public volatile Object f;
    public volatile e g;
    public volatile i h;

    /* renamed from: mt$b */
    /* compiled from: AbstractFuture */
    public static abstract class b {
        public b(a aVar) {
        }

        public abstract boolean a(mt<?> mtVar, e eVar, e eVar2);

        public abstract boolean b(mt<?> mtVar, Object obj, Object obj2);

        public abstract boolean c(mt<?> mtVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    /* renamed from: mt$c */
    /* compiled from: AbstractFuture */
    public static final class c {
        public static final c c;
        public static final c d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2433a;
        public final Throwable b;

        static {
            if (mt.i) {
                d = null;
                c = null;
                return;
            }
            d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f2433a = z;
            this.b = th;
        }
    }

    /* renamed from: mt$d */
    /* compiled from: AbstractFuture */
    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f2434a;

        /* renamed from: mt$d$a */
        /* compiled from: AbstractFuture */
        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            boolean z = mt.i;
            Objects.requireNonNull(th);
            this.f2434a = th;
        }
    }

    /* renamed from: mt$e */
    /* compiled from: AbstractFuture */
    public static final class e {
        public static final e d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f2435a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.f2435a = runnable;
            this.b = executor;
        }
    }

    /* renamed from: mt$f */
    /* compiled from: AbstractFuture */
    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, Thread> f2436a;
        public final AtomicReferenceFieldUpdater<i, i> b;
        public final AtomicReferenceFieldUpdater<mt, i> c;
        public final AtomicReferenceFieldUpdater<mt, e> d;
        public final AtomicReferenceFieldUpdater<mt, Object> e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<mt, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<mt, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<mt, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.f2436a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // defpackage.mt.b
        public boolean a(mt<?> mtVar, e eVar, e eVar2) {
            return this.d.compareAndSet(mtVar, eVar, eVar2);
        }

        @Override // defpackage.mt.b
        public boolean b(mt<?> mtVar, Object obj, Object obj2) {
            return this.e.compareAndSet(mtVar, obj, obj2);
        }

        @Override // defpackage.mt.b
        public boolean c(mt<?> mtVar, i iVar, i iVar2) {
            return this.c.compareAndSet(mtVar, iVar, iVar2);
        }

        @Override // defpackage.mt.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // defpackage.mt.b
        public void e(i iVar, Thread thread) {
            this.f2436a.lazySet(iVar, thread);
        }
    }

    /* renamed from: mt$g */
    /* compiled from: AbstractFuture */
    public static final class g<V> implements Runnable {
        public final mt<V> f;
        public final gy4<? extends V> g;

        public g(mt<V> mtVar, gy4<? extends V> gy4) {
            this.f = mtVar;
            this.g = gy4;
        }

        public void run() {
            if (this.f.f == this) {
                if (mt.k.b(this.f, this, mt.f(this.g))) {
                    mt.b(this.f);
                }
            }
        }
    }

    /* renamed from: mt$h */
    /* compiled from: AbstractFuture */
    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // defpackage.mt.b
        public boolean a(mt<?> mtVar, e eVar, e eVar2) {
            synchronized (mtVar) {
                if (mtVar.g != eVar) {
                    return false;
                }
                mtVar.g = eVar2;
                return true;
            }
        }

        @Override // defpackage.mt.b
        public boolean b(mt<?> mtVar, Object obj, Object obj2) {
            synchronized (mtVar) {
                if (mtVar.f != obj) {
                    return false;
                }
                mtVar.f = obj2;
                return true;
            }
        }

        @Override // defpackage.mt.b
        public boolean c(mt<?> mtVar, i iVar, i iVar2) {
            synchronized (mtVar) {
                if (mtVar.h != iVar) {
                    return false;
                }
                mtVar.h = iVar2;
                return true;
            }
        }

        @Override // defpackage.mt.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // defpackage.mt.b
        public void e(i iVar, Thread thread) {
            iVar.f2437a = thread;
        }
    }

    /* renamed from: mt$i */
    /* compiled from: AbstractFuture */
    public static final class i {
        public static final i c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f2437a;
        public volatile i b;

        public i(boolean z) {
        }

        public i() {
            mt.k.e(this, Thread.currentThread());
        }
    }

    static {
        b bVar;
        Throwable th;
        try {
            bVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(mt.class, i.class, "h"), AtomicReferenceFieldUpdater.newUpdater(mt.class, e.class, "g"), AtomicReferenceFieldUpdater.newUpdater(mt.class, Object.class, "f"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            bVar = new h();
        }
        k = bVar;
        if (th != null) {
            j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [mt<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [mt] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [mt<V>, mt] */
    /* JADX WARN: Type inference failed for: r4v2, types: [mt$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(defpackage.mt<?> r5) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            mt$i r2 = r5.h
            mt$b r3 = defpackage.mt.k
            mt$i r4 = defpackage.mt.i.c
            boolean r3 = r3.c(r5, r2, r4)
            if (r3 == 0) goto L_0x0002
        L_0x000e:
            if (r2 == 0) goto L_0x001c
            java.lang.Thread r3 = r2.f2437a
            if (r3 == 0) goto L_0x0019
            r2.f2437a = r0
            java.util.concurrent.locks.LockSupport.unpark(r3)
        L_0x0019:
            mt$i r2 = r2.b
            goto L_0x000e
        L_0x001c:
            mt$e r2 = r5.g
            mt$b r3 = defpackage.mt.k
            mt$e r4 = defpackage.mt.e.d
            boolean r3 = r3.a(r5, r2, r4)
            if (r3 == 0) goto L_0x001c
        L_0x0028:
            r5 = r1
            r1 = r2
            if (r1 == 0) goto L_0x0031
            mt$e r2 = r1.c
            r1.c = r5
            goto L_0x0028
        L_0x0031:
            if (r5 == 0) goto L_0x0059
            mt$e r1 = r5.c
            java.lang.Runnable r2 = r5.f2435a
            boolean r3 = r2 instanceof defpackage.mt.g
            if (r3 == 0) goto L_0x0052
            mt$g r2 = (defpackage.mt.g) r2
            mt<V> r5 = r2.f
            java.lang.Object r3 = r5.f
            if (r3 != r2) goto L_0x0057
            gy4<? extends V> r3 = r2.g
            java.lang.Object r3 = f(r3)
            mt$b r4 = defpackage.mt.k
            boolean r2 = r4.b(r5, r2, r3)
            if (r2 == 0) goto L_0x0057
            goto L_0x0002
        L_0x0052:
            java.util.concurrent.Executor r5 = r5.b
            d(r2, r5)
        L_0x0057:
            r5 = r1
            goto L_0x0031
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt.b(mt):void");
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = j;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object f(gy4<?> gy4) {
        if (gy4 instanceof mt) {
            Object obj = ((mt) gy4).f;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f2433a) {
                return obj;
            }
            if (cVar.b != null) {
                return new c(false, cVar.b);
            }
            return c.d;
        }
        boolean isCancelled = gy4.isCancelled();
        if ((!i) && isCancelled) {
            return c.d;
        }
        try {
            Object g2 = g(gy4);
            return g2 == null ? l : g2;
        } catch (ExecutionException e2) {
            return new d(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(false, e3);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + gy4, e3));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static <V> V g(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public final void a(StringBuilder sb) {
        String str;
        try {
            Object g2 = g(this);
            sb.append("SUCCESS, result=[");
            if (g2 == this) {
                str = "this future";
            } else {
                str = String.valueOf(g2);
            }
            sb.append(str);
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override // defpackage.gy4
    public final void c(Runnable runnable, Executor executor) {
        e eVar = e.d;
        Objects.requireNonNull(executor);
        e eVar2 = this.g;
        if (eVar2 != eVar) {
            e eVar3 = new e(runnable, executor);
            do {
                eVar3.c = eVar2;
                if (!k.a(this, eVar2, eVar3)) {
                    eVar2 = this.g;
                } else {
                    return;
                }
            } while (eVar2 != eVar);
        }
        d(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        c cVar;
        Object obj = this.f;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (i) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            cVar = c.c;
        } else {
            cVar = c.d;
        }
        boolean z2 = false;
        mt<V> mtVar = this;
        while (true) {
            if (k.b(mtVar, obj, cVar)) {
                b(mtVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                gy4<? extends V> gy4 = ((g) obj).g;
                if (gy4 instanceof mt) {
                    mtVar = (mt) gy4;
                    obj = mtVar.f;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    gy4.cancel(z);
                    return true;
                }
            } else {
                obj = mtVar.f;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V e(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f2434a);
        } else if (obj == l) {
            return null;
        } else {
            return obj;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    @Override // java.util.concurrent.Future
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(long r18, java.util.concurrent.TimeUnit r20) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public String h() {
        String str;
        Object obj = this.f;
        if (obj instanceof g) {
            StringBuilder i0 = hj1.i0("setFuture=[");
            gy4<? extends V> gy4 = ((g) obj).g;
            if (gy4 == this) {
                str = "this future";
            } else {
                str = String.valueOf(gy4);
            }
            return hj1.a0(i0, str, "]");
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder i02 = hj1.i0("remaining delay=[");
            i02.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            i02.append(" ms]");
            return i02.toString();
        }
    }

    public final void i(i iVar) {
        iVar.f2437a = null;
        while (true) {
            i iVar2 = this.h;
            if (iVar2 != i.c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.b;
                    if (iVar2.f2437a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.b = iVar4;
                        if (iVar3.f2437a == null) {
                        }
                    } else if (!k.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public final boolean isCancelled() {
        return this.f instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.f;
        return (!(obj instanceof g)) & (obj != null);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f instanceof c) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = h();
            } catch (RuntimeException e2) {
                StringBuilder i0 = hj1.i0("Exception thrown from implementation: ");
                i0.append(e2.getClass());
                str = i0.toString();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        i iVar = i.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return e(obj2);
            }
            i iVar2 = this.h;
            if (iVar2 != iVar) {
                i iVar3 = new i();
                do {
                    b bVar = k;
                    bVar.d(iVar3, iVar2);
                    if (bVar.c(this, iVar2, iVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f;
                            } else {
                                i(iVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return e(obj);
                    }
                    iVar2 = this.h;
                } while (iVar2 != iVar);
            }
            return e(this.f);
        }
        throw new InterruptedException();
    }
}
