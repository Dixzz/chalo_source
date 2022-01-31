package defpackage;

import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: sb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class sb4 extends sc4 {
    public static final AtomicLong k = new AtomicLong(Long.MIN_VALUE);
    public wb4 c;
    public wb4 d;
    public final PriorityBlockingQueue<tb4<?>> e = new PriorityBlockingQueue<>();
    public final BlockingQueue<tb4<?>> f = new LinkedBlockingQueue();
    public final Thread.UncaughtExceptionHandler g = new ub4(this, "Thread death: Uncaught exception on worker thread");
    public final Thread.UncaughtExceptionHandler h = new ub4(this, "Thread death: Uncaught exception on network thread");
    public final Object i = new Object();
    public final Semaphore j = new Semaphore(2);

    public sb4(vb4 vb4) {
        super(vb4);
    }

    @Override // defpackage.tc4
    public final void a() {
        if (Thread.currentThread() != this.d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // defpackage.tc4
    public final void b() {
        if (Thread.currentThread() != this.c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // defpackage.sc4
    public final boolean p() {
        return false;
    }

    public final <T> T q(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            f().u(runnable);
            try {
                atomicReference.wait(j2);
            } catch (InterruptedException unused) {
                g().i.a(str.length() != 0 ? "Interrupted waiting for ".concat(str) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            g().i.a(str.length() != 0 ? "Timed out waiting for ".concat(str) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final <V> Future<V> s(Callable<V> callable) throws IllegalStateException {
        l();
        tb4<?> tb4 = new tb4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            if (!this.e.isEmpty()) {
                g().i.a("Callable skipped the worker queue.");
            }
            tb4.run();
        } else {
            t(tb4);
        }
        return tb4;
    }

    public final void t(tb4<?> tb4) {
        synchronized (this.i) {
            this.e.add(tb4);
            wb4 wb4 = this.c;
            if (wb4 == null) {
                wb4 wb42 = new wb4(this, "Measurement Worker", this.e);
                this.c = wb42;
                wb42.setUncaughtExceptionHandler(this.g);
                this.c.start();
            } else {
                synchronized (wb4.f) {
                    wb4.f.notifyAll();
                }
            }
        }
    }

    public final void u(Runnable runnable) throws IllegalStateException {
        l();
        Objects.requireNonNull(runnable, "null reference");
        t(new tb4<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void v(Runnable runnable) throws IllegalStateException {
        l();
        t(new tb4<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) throws IllegalStateException {
        l();
        tb4<?> tb4 = new tb4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.i) {
            this.f.add(tb4);
            wb4 wb4 = this.d;
            if (wb4 == null) {
                wb4 wb42 = new wb4(this, "Measurement Network", this.f);
                this.d = wb42;
                wb42.setUncaughtExceptionHandler(this.h);
                this.d.start();
            } else {
                synchronized (wb4.f) {
                    wb4.f.notifyAll();
                }
            }
        }
    }

    public final boolean x() {
        return Thread.currentThread() == this.c;
    }
}
