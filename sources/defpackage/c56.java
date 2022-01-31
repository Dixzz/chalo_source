package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

/* renamed from: c56  reason: default package */
/* compiled from: EventThread */
public class c56 extends Thread {
    public static final Logger f = Logger.getLogger(c56.class.getName());
    public static final ThreadFactory g = new a();
    public static c56 h;
    public static ExecutorService i;
    public static int j = 0;

    /* renamed from: c56$a */
    /* compiled from: EventThread */
    public static class a implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            c56 c56 = new c56(runnable, null);
            c56.h = c56;
            c56.setName("EventThread");
            c56.h.setDaemon(Thread.currentThread().isDaemon());
            return c56.h;
        }
    }

    /* renamed from: c56$b */
    /* compiled from: EventThread */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable f;

        public b(Runnable runnable) {
            this.f = runnable;
        }

        public void run() {
            try {
                this.f.run();
                synchronized (c56.class) {
                    int i = c56.j - 1;
                    c56.j = i;
                    if (i == 0) {
                        c56.i.shutdown();
                        c56.i = null;
                        c56.h = null;
                    }
                }
            } catch (Throwable th) {
                synchronized (c56.class) {
                    int i2 = c56.j - 1;
                    c56.j = i2;
                    if (i2 == 0) {
                        c56.i.shutdown();
                        c56.i = null;
                        c56.h = null;
                    }
                    throw th;
                }
            }
        }
    }

    public c56(Runnable runnable, a aVar) {
        super(runnable);
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == h) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public static void b(Runnable runnable) {
        ExecutorService executorService;
        synchronized (c56.class) {
            j++;
            if (i == null) {
                i = Executors.newSingleThreadExecutor(g);
            }
            executorService = i;
        }
        executorService.execute(new b(runnable));
    }
}
