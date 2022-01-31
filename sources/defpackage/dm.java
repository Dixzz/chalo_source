package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: dm  reason: default package */
/* compiled from: TransactionExecutor */
public class dm implements Executor {
    public final Executor f;
    public final ArrayDeque<Runnable> g = new ArrayDeque<>();
    public Runnable h;

    /* renamed from: dm$a */
    /* compiled from: TransactionExecutor */
    public class a implements Runnable {
        public final /* synthetic */ Runnable f;

        public a(Runnable runnable) {
            this.f = runnable;
        }

        public void run() {
            try {
                this.f.run();
            } finally {
                dm.this.a();
            }
        }
    }

    public dm(Executor executor) {
        this.f = executor;
    }

    public synchronized void a() {
        Runnable poll = this.g.poll();
        this.h = poll;
        if (poll != null) {
            this.f.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.g.offer(new a(runnable));
        if (this.h == null) {
            a();
        }
    }
}
