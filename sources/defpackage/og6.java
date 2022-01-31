package defpackage;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: og6  reason: default package */
/* compiled from: Dispatcher.kt */
public final class og6 extends hc6 implements tg6, Executor {
    public static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(og6.class, "inFlightTasks");
    public final mg6 g;
    public final int h;
    public final String i;
    private volatile /* synthetic */ int inFlightTasks = 0;
    public final int j;
    public final ConcurrentLinkedQueue<Runnable> k = new ConcurrentLinkedQueue<>();

    public og6(mg6 mg6, int i2, String str, int i3) {
        this.g = mg6;
        this.h = i2;
        this.i = str;
        this.j = i3;
    }

    public final void D(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = l;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.h) {
                mg6 mg6 = this.g;
                Objects.requireNonNull(mg6);
                try {
                    mg6.k.f(runnable, this, z);
                    return;
                } catch (RejectedExecutionException unused) {
                    pb6.l.P(mg6.k.c(runnable, this));
                    return;
                }
            } else {
                this.k.add(runnable);
                if (atomicIntegerFieldUpdater.decrementAndGet(this) < this.h) {
                    runnable = this.k.poll();
                } else {
                    return;
                }
            }
        } while (runnable != null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void execute(Runnable runnable) {
        D(runnable, false);
    }

    @Override // defpackage.tg6
    public void h() {
        Runnable poll = this.k.poll();
        if (poll != null) {
            mg6 mg6 = this.g;
            Objects.requireNonNull(mg6);
            try {
                mg6.k.f(poll, this, true);
            } catch (RejectedExecutionException unused) {
                pb6.l.P(mg6.k.c(poll, this));
            }
        } else {
            l.decrementAndGet(this);
            Runnable poll2 = this.k.poll();
            if (poll2 != null) {
                D(poll2, true);
            }
        }
    }

    @Override // defpackage.tg6
    public int l() {
        return this.j;
    }

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        D(runnable, false);
    }

    @Override // defpackage.kb6
    public String toString() {
        String str = this.i;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.g + ']';
    }
}
