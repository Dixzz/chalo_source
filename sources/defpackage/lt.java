package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: lt  reason: default package */
/* compiled from: WorkTimer */
public class lt {
    public static final String f = tp.e("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f2265a;
    public final ScheduledExecutorService b;
    public final Map<String, c> c = new HashMap();
    public final Map<String, b> d = new HashMap();
    public final Object e = new Object();

    /* renamed from: lt$a */
    /* compiled from: WorkTimer */
    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public int f2266a = 0;

        public a(lt ltVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder i0 = hj1.i0("WorkManager-WorkTimer-thread-");
            i0.append(this.f2266a);
            newThread.setName(i0.toString());
            this.f2266a++;
            return newThread;
        }
    }

    /* renamed from: lt$b */
    /* compiled from: WorkTimer */
    public interface b {
        void a(String str);
    }

    /* renamed from: lt$c */
    /* compiled from: WorkTimer */
    public static class c implements Runnable {
        public final lt f;
        public final String g;

        public c(lt ltVar, String str) {
            this.f = ltVar;
            this.g = str;
        }

        public void run() {
            synchronized (this.f.e) {
                if (this.f.c.remove(this.g) != null) {
                    b remove = this.f.d.remove(this.g);
                    if (remove != null) {
                        remove.a(this.g);
                    }
                } else {
                    tp.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.g), new Throwable[0]);
                }
            }
        }
    }

    public lt() {
        a aVar = new a(this);
        this.f2265a = aVar;
        this.b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a(String str, long j, b bVar) {
        synchronized (this.e) {
            tp.c().a(f, String.format("Starting timer for %s", str), new Throwable[0]);
            b(str);
            c cVar = new c(this, str);
            this.c.put(str, cVar);
            this.d.put(str, bVar);
            this.b.schedule(cVar, j, TimeUnit.MILLISECONDS);
        }
    }

    public void b(String str) {
        synchronized (this.e) {
            if (this.c.remove(str) != null) {
                tp.c().a(f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.d.remove(str);
            }
        }
    }
}
