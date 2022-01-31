package defpackage;

import android.os.Process;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* renamed from: wb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class wb4 extends Thread {
    public final Object f;
    public final BlockingQueue<tb4<?>> g;
    public boolean h = false;
    public final /* synthetic */ sb4 i;

    public wb4(sb4 sb4, String str, BlockingQueue<tb4<?>> blockingQueue) {
        this.i = sb4;
        Objects.requireNonNull(blockingQueue, "null reference");
        this.f = new Object();
        this.g = blockingQueue;
        setName(str);
    }

    public final void a(InterruptedException interruptedException) {
        this.i.g().i.b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void b() {
        synchronized (this.i.i) {
            if (!this.h) {
                this.i.j.release();
                this.i.i.notifyAll();
                sb4 sb4 = this.i;
                if (this == sb4.c) {
                    sb4.c = null;
                } else if (this == sb4.d) {
                    sb4.d = null;
                } else {
                    sb4.g().f.a("Current scheduler thread is neither worker nor network");
                }
                this.h = true;
            }
        }
    }

    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.i.j.acquire();
                z = true;
            } catch (InterruptedException e) {
                a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                tb4<?> poll = this.g.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.g ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.f) {
                        if (this.g.peek() == null) {
                            Objects.requireNonNull(this.i);
                            try {
                                this.f.wait(30000);
                            } catch (InterruptedException e2) {
                                a(e2);
                            }
                        }
                    }
                    synchronized (this.i.i) {
                        if (this.g.peek() == null) {
                            if (this.i.f3331a.g.l(q64.r0)) {
                            }
                            b();
                            return;
                        }
                    }
                }
            }
        } finally {
            b();
        }
    }
}
