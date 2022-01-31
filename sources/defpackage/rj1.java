package defpackage;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import defpackage.oj1;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* renamed from: rj1  reason: default package */
/* compiled from: NetworkDispatcher */
public class rj1 extends Thread {
    public final BlockingQueue<wj1<?>> f;
    public final qj1 g;
    public final jj1 h;
    public final zj1 i;
    public volatile boolean j = false;

    public rj1(BlockingQueue<wj1<?>> blockingQueue, qj1 qj1, jj1 jj1, zj1 zj1) {
        this.f = blockingQueue;
        this.g = qj1;
        this.h = jj1;
        this.i = zj1;
    }

    public final void a() throws InterruptedException {
        boolean z;
        wj1<?> take = this.f.take();
        SystemClock.elapsedRealtime();
        try {
            take.a("network-queue-take");
            if (take.t()) {
                take.i("network-discard-cancelled");
                take.w();
                return;
            }
            TrafficStats.setThreadStatsTag(take.i);
            tj1 f2 = ((gk1) this.g).f(take);
            take.a("network-http-complete");
            if (f2.e) {
                synchronized (take.j) {
                    z = take.p;
                }
                if (z) {
                    take.i("not-modified");
                    take.w();
                    return;
                }
            }
            yj1<?> A = take.A(f2);
            take.a("network-parse-complete");
            if (take.n && A.b != null) {
                ((ik1) this.h).e(take.l(), A.b);
                take.a("network-cache-written");
            }
            synchronized (take.j) {
                take.p = true;
            }
            ((oj1) this.i).a(take, A, null);
            take.x(A);
        } catch (dk1 e) {
            SystemClock.elapsedRealtime();
            Objects.requireNonNull(take);
            oj1 oj1 = (oj1) this.i;
            Objects.requireNonNull(oj1);
            take.a("post-error");
            oj1.f2697a.execute(new oj1.b(take, new yj1(e), null));
            take.w();
        } catch (Exception e2) {
            ek1.a("Unhandled exception %s", e2.toString());
            dk1 dk1 = new dk1(e2);
            SystemClock.elapsedRealtime();
            oj1 oj12 = (oj1) this.i;
            Objects.requireNonNull(oj12);
            take.a("post-error");
            oj12.f2697a.execute(new oj1.b(take, new yj1(dk1), null));
            take.w();
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.j) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ek1.a("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
