package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: ft  reason: default package */
/* compiled from: SerialExecutor */
public class ft implements Executor {
    public final ArrayDeque<a> f = new ArrayDeque<>();
    public final Executor g;
    public final Object h = new Object();
    public volatile Runnable i;

    /* renamed from: ft$a */
    /* compiled from: SerialExecutor */
    public static class a implements Runnable {
        public final ft f;
        public final Runnable g;

        public a(ft ftVar, Runnable runnable) {
            this.f = ftVar;
            this.g = runnable;
        }

        public void run() {
            try {
                this.g.run();
            } finally {
                this.f.a();
            }
        }
    }

    public ft(Executor executor) {
        this.g = executor;
    }

    public void a() {
        synchronized (this.h) {
            a poll = this.f.poll();
            this.i = poll;
            if (poll != null) {
                this.g.execute(this.i);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.h) {
            this.f.add(new a(this, runnable));
            if (this.i == null) {
                a();
            }
        }
    }
}
