package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* renamed from: pb6  reason: default package */
/* compiled from: DefaultExecutor.kt */
public final class pb6 extends cc6 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final pb6 l;
    public static final long m;

    static {
        Long l2;
        pb6 pb6 = new pb6();
        l = pb6;
        pb6.J(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        m = timeUnit.toNanos(l2.longValue());
    }

    @Override // defpackage.dc6
    public Thread M() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    public final synchronized void g0() {
        if (i0()) {
            debugStatus = 3;
            Z();
            notifyAll();
        }
    }

    public final boolean i0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public void run() {
        boolean z;
        md6 md6 = md6.f2360a;
        md6.b.set(this);
        try {
            synchronized (this) {
                if (i0()) {
                    z = false;
                } else {
                    z = true;
                    debugStatus = 1;
                    notifyAll();
                }
            }
            if (z) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long X = X();
                    if (X == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = m + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            g0();
                            if (!V()) {
                                M();
                                return;
                            }
                            return;
                        } else if (X > j2) {
                            X = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (X > 0) {
                        if (i0()) {
                            _thread = null;
                            g0();
                            if (!V()) {
                                M();
                                return;
                            }
                            return;
                        }
                        LockSupport.parkNanos(this, X);
                    }
                }
            }
        } finally {
            _thread = null;
            g0();
            if (!V()) {
                M();
            }
        }
    }
}
