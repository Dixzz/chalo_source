package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: rm6  reason: default package */
/* compiled from: AsyncTimeout.kt */
public class rm6 extends rn6 {
    public static final long h;
    public static final long i;
    public static rm6 j;
    public static final a k = new a(null);
    public boolean e;
    public rm6 f;
    public long g;

    /* renamed from: rm6$a */
    /* compiled from: AsyncTimeout.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final rm6 a() throws InterruptedException {
            rm6 rm6 = rm6.j;
            if (rm6 != null) {
                rm6 rm62 = rm6.f;
                if (rm62 == null) {
                    long nanoTime = System.nanoTime();
                    rm6.class.wait(rm6.h);
                    rm6 rm63 = rm6.j;
                    if (rm63 == null) {
                        n86.k();
                        throw null;
                    } else if (rm63.f != null || System.nanoTime() - nanoTime < rm6.i) {
                        return null;
                    } else {
                        return rm6.j;
                    }
                } else {
                    long nanoTime2 = rm62.g - System.nanoTime();
                    if (nanoTime2 > 0) {
                        long j = nanoTime2 / 1000000;
                        rm6.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
                        return null;
                    }
                    rm6 rm64 = rm6.j;
                    if (rm64 != null) {
                        rm64.f = rm62.f;
                        rm62.f = null;
                        return rm62;
                    }
                    n86.k();
                    throw null;
                }
            } else {
                n86.k();
                throw null;
            }
        }
    }

    /* renamed from: rm6$b */
    /* compiled from: AsyncTimeout.kt */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r1 == null) goto L_0x0000;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
            r1.l();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<rm6> r0 = defpackage.rm6.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                rm6$a r1 = defpackage.rm6.k     // Catch:{ all -> 0x0019 }
                rm6 r1 = r1.a()     // Catch:{ all -> 0x0019 }
                rm6 r2 = defpackage.rm6.j     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0012
                r1 = 0
                defpackage.rm6.j = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)
                return
            L_0x0012:
                monitor-exit(r0)
                if (r1 == 0) goto L_0x0000
                r1.l()
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.rm6.b.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        h = millis;
        i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        rm6 rm6;
        if (!this.e) {
            long j2 = this.c;
            boolean z = this.f3105a;
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 != 0 || z) {
                this.e = true;
                synchronized (rm6.class) {
                    if (j == null) {
                        j = new rm6();
                        new b().start();
                    }
                    long nanoTime = System.nanoTime();
                    if (i2 != 0 && z) {
                        this.g = Math.min(j2, c() - nanoTime) + nanoTime;
                    } else if (i2 != 0) {
                        this.g = j2 + nanoTime;
                    } else if (z) {
                        this.g = c();
                    } else {
                        throw new AssertionError();
                    }
                    long j3 = this.g - nanoTime;
                    rm6 rm62 = j;
                    if (rm62 != null) {
                        while (true) {
                            rm6 = rm62.f;
                            if (rm6 == null) {
                                break;
                            } else if (j3 < rm6.g - nanoTime) {
                                break;
                            } else {
                                rm62 = rm6;
                            }
                        }
                        this.f = rm6;
                        rm62.f = this;
                        if (rm62 == j) {
                            rm6.class.notify();
                        }
                    } else {
                        n86.k();
                        throw null;
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean j() {
        boolean z = false;
        if (!this.e) {
            return false;
        }
        this.e = false;
        synchronized (rm6.class) {
            rm6 rm6 = j;
            while (true) {
                if (rm6 == null) {
                    z = true;
                    break;
                }
                rm6 rm62 = rm6.f;
                if (rm62 == this) {
                    rm6.f = this.f;
                    this.f = null;
                    break;
                }
                rm6 = rm62;
            }
        }
        return z;
    }

    public IOException k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void l() {
    }
}
