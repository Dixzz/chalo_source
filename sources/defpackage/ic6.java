package defpackage;

import defpackage.rc6;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: ic6  reason: default package */
/* compiled from: Executors.kt */
public abstract class ic6 extends hc6 implements tb6 {
    public boolean g;

    public final void D(m66 m66, RejectedExecutionException rejectedExecutionException) {
        CancellationException cancellationException = new CancellationException("The task was rejected");
        cancellationException.initCause(rejectedExecutionException);
        int i = rc6.e;
        rc6 rc6 = (rc6) m66.get(rc6.a.f);
        if (rc6 != null) {
            rc6.c(cancellationException);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor A = A();
        ExecutorService executorService = A instanceof ExecutorService ? (ExecutorService) A : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ic6) && ((ic6) obj).A() == A();
    }

    @Override // defpackage.tb6
    public void g(long j, ra6<? super s56> ra6) {
        ScheduledFuture<?> scheduledFuture = null;
        if (this.g) {
            hd6 hd6 = new hd6(this, ra6);
            m66 m66 = ((sa6) ra6).j;
            try {
                Executor A = A();
                ScheduledExecutorService scheduledExecutorService = A instanceof ScheduledExecutorService ? (ScheduledExecutorService) A : null;
                if (scheduledExecutorService != null) {
                    scheduledFuture = scheduledExecutorService.schedule(hd6, j, TimeUnit.MILLISECONDS);
                }
            } catch (RejectedExecutionException e) {
                D(m66, e);
            }
        }
        if (scheduledFuture != null) {
            ((sa6) ra6).g(new oa6(scheduledFuture));
        } else {
            pb6.l.g(j, ra6);
        }
    }

    public int hashCode() {
        return System.identityHashCode(A());
    }

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        try {
            A().execute(runnable);
        } catch (RejectedExecutionException e) {
            D(m66, e);
            xb6 xb6 = xb6.f3911a;
            xb6.c.m(m66, runnable);
        }
    }

    @Override // defpackage.kb6
    public String toString() {
        return A().toString();
    }
}
