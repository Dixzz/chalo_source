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

/* renamed from: w2  reason: default package */
/* compiled from: AbstractResolvableFuture */
public abstract class w2<V> implements gy4<V> {
    public static final boolean i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger j = Logger.getLogger(w2.class.getName());
    public static final b k;
    public static final Object l = new Object();
    public volatile Object f;
    public volatile e g;
    public volatile i h;

    /* renamed from: w2$b */
    /* compiled from: AbstractResolvableFuture */
    public static abstract class b {
        public b(a aVar) {
        }

        public abstract boolean a(w2<?> w2Var, e eVar, e eVar2);

        public abstract boolean b(w2<?> w2Var, Object obj, Object obj2);

        public abstract boolean c(w2<?> w2Var, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    /* renamed from: w2$c */
    /* compiled from: AbstractResolvableFuture */
    public static final class c {
        public static final c c;
        public static final c d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3708a;
        public final Throwable b;

        static {
            if (w2.i) {
                d = null;
                c = null;
                return;
            }
            d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f3708a = z;
            this.b = th;
        }
    }

    /* renamed from: w2$d */
    /* compiled from: AbstractResolvableFuture */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f3709a;

        /* renamed from: w2$d$a */
        /* compiled from: AbstractResolvableFuture */
        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            a aVar = new a("Failure occurred while trying to finish a future.");
            boolean z = w2.i;
            Objects.requireNonNull(aVar);
        }

        public d(Throwable th) {
            boolean z = w2.i;
            Objects.requireNonNull(th);
            this.f3709a = th;
        }
    }

    /* renamed from: w2$e */
    /* compiled from: AbstractResolvableFuture */
    public static final class e {
        public static final e d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f3710a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.f3710a = runnable;
            this.b = executor;
        }
    }

    /* renamed from: w2$f */
    /* compiled from: AbstractResolvableFuture */
    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, Thread> f3711a;
        public final AtomicReferenceFieldUpdater<i, i> b;
        public final AtomicReferenceFieldUpdater<w2, i> c;
        public final AtomicReferenceFieldUpdater<w2, e> d;
        public final AtomicReferenceFieldUpdater<w2, Object> e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<w2, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<w2, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<w2, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.f3711a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // defpackage.w2.b
        public boolean a(w2<?> w2Var, e eVar, e eVar2) {
            return this.d.compareAndSet(w2Var, eVar, eVar2);
        }

        @Override // defpackage.w2.b
        public boolean b(w2<?> w2Var, Object obj, Object obj2) {
            return this.e.compareAndSet(w2Var, obj, obj2);
        }

        @Override // defpackage.w2.b
        public boolean c(w2<?> w2Var, i iVar, i iVar2) {
            return this.c.compareAndSet(w2Var, iVar, iVar2);
        }

        @Override // defpackage.w2.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // defpackage.w2.b
        public void e(i iVar, Thread thread) {
            this.f3711a.lazySet(iVar, thread);
        }
    }

    /* renamed from: w2$g */
    /* compiled from: AbstractResolvableFuture */
    public static final class g<V> implements Runnable {
        public void run() {
            throw null;
        }
    }

    /* renamed from: w2$h */
    /* compiled from: AbstractResolvableFuture */
    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // defpackage.w2.b
        public boolean a(w2<?> w2Var, e eVar, e eVar2) {
            synchronized (w2Var) {
                if (w2Var.g != eVar) {
                    return false;
                }
                w2Var.g = eVar2;
                return true;
            }
        }

        @Override // defpackage.w2.b
        public boolean b(w2<?> w2Var, Object obj, Object obj2) {
            synchronized (w2Var) {
                if (w2Var.f != obj) {
                    return false;
                }
                w2Var.f = obj2;
                return true;
            }
        }

        @Override // defpackage.w2.b
        public boolean c(w2<?> w2Var, i iVar, i iVar2) {
            synchronized (w2Var) {
                if (w2Var.h != iVar) {
                    return false;
                }
                w2Var.h = iVar2;
                return true;
            }
        }

        @Override // defpackage.w2.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // defpackage.w2.b
        public void e(i iVar, Thread thread) {
            iVar.f3712a = thread;
        }
    }

    /* renamed from: w2$i */
    /* compiled from: AbstractResolvableFuture */
    public static final class i {
        public static final i c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f3712a;
        public volatile i b;

        public i(boolean z) {
        }

        public i() {
            w2.k.e(this, Thread.currentThread());
        }
    }

    static {
        b bVar;
        Throwable th;
        try {
            bVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(w2.class, i.class, "h"), AtomicReferenceFieldUpdater.newUpdater(w2.class, e.class, "g"), AtomicReferenceFieldUpdater.newUpdater(w2.class, Object.class, "f"));
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

    public static void b(w2<?> w2Var) {
        i iVar;
        e eVar;
        do {
            iVar = w2Var.h;
        } while (!k.c(w2Var, iVar, i.c));
        while (iVar != null) {
            Thread thread = iVar.f3712a;
            if (thread != null) {
                iVar.f3712a = null;
                LockSupport.unpark(thread);
            }
            iVar = iVar.b;
        }
        do {
            eVar = w2Var.g;
        } while (!k.a(w2Var, eVar, e.d));
        e eVar2 = null;
        while (eVar != null) {
            e eVar3 = eVar.c;
            eVar.c = eVar2;
            eVar2 = eVar;
            eVar = eVar3;
        }
        while (eVar2 != null) {
            e eVar4 = eVar2.c;
            Runnable runnable = eVar2.f3710a;
            if (!(runnable instanceof g)) {
                d(runnable, eVar2.b);
                eVar2 = eVar4;
            } else {
                Objects.requireNonNull((g) runnable);
                throw null;
            }
        }
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

    public static <V> V f(Future<V> future) throws ExecutionException {
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
            Object f2 = f(this);
            sb.append("SUCCESS, result=[");
            if (f2 == this) {
                str = "this future";
            } else {
                str = String.valueOf(f2);
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
        Objects.requireNonNull(runnable);
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
        while (!k.b(this, obj, cVar)) {
            obj = this.f;
            if (!(obj instanceof g)) {
            }
        }
        b(this);
        if (!(obj instanceof g)) {
            return true;
        }
        Objects.requireNonNull((g) obj);
        throw null;
        return false;
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
            throw new ExecutionException(((d) obj).f3709a);
        } else if (obj == l) {
            return null;
        } else {
            return obj;
        }
    }

    public String g() {
        Object obj = this.f;
        if (obj instanceof g) {
            Objects.requireNonNull((g) obj);
            return "setFuture=[null]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder i0 = hj1.i0("remaining delay=[");
            i0.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            i0.append(" ms]");
            return i0.toString();
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w2.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public final void h(i iVar) {
        iVar.f3712a = null;
        while (true) {
            i iVar2 = this.h;
            if (iVar2 != i.c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.b;
                    if (iVar2.f3712a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.b = iVar4;
                        if (iVar3.f3712a == null) {
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

    public boolean i(V v) {
        if (v == null) {
            v = (V) l;
        }
        if (!k.b(this, null, v)) {
            return false;
        }
        b(this);
        return true;
    }

    public final boolean isCancelled() {
        return this.f instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.f;
        return (!(obj instanceof g)) & (obj != null);
    }

    public boolean j(Throwable th) {
        Objects.requireNonNull(th);
        if (!k.b(this, null, new d(th))) {
            return false;
        }
        b(this);
        return true;
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
                str = g();
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
                                h(iVar3);
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
