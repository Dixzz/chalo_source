package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: dz5  reason: default package */
/* compiled from: SerialExecutor */
public class dz5 implements Executor {
    public final Executor f;
    public final ArrayDeque<Runnable> g = new ArrayDeque<>();
    public boolean h = false;

    /* renamed from: dz5$a */
    /* compiled from: SerialExecutor */
    public class a implements Runnable {
        public final /* synthetic */ Runnable f;

        public a(Runnable runnable) {
            this.f = runnable;
        }

        public void run() {
            try {
                this.f.run();
            } finally {
                dz5.this.a();
            }
        }
    }

    public dz5(Executor executor) {
        this.f = executor;
    }

    public final void a() {
        synchronized (this.g) {
            Runnable pollFirst = this.g.pollFirst();
            if (pollFirst != null) {
                this.h = true;
                this.f.execute(pollFirst);
            } else {
                this.h = false;
            }
        }
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            a aVar = new a(runnable);
            synchronized (this.g) {
                this.g.offer(aVar);
                if (!this.h) {
                    a();
                }
            }
        }
    }
}
