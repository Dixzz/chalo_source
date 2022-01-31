package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: d2  reason: default package */
/* compiled from: DefaultTaskExecutor */
public class d2 extends e2 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f779a = new Object();
    public final ExecutorService b = Executors.newFixedThreadPool(4, new a(this));
    public volatile Handler c;

    /* renamed from: d2$a */
    /* compiled from: DefaultTaskExecutor */
    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f780a = new AtomicInteger(0);

        public a(d2 d2Var) {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f780a.getAndIncrement())));
            return thread;
        }
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // defpackage.e2
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // defpackage.e2
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // defpackage.e2
    public void c(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f779a) {
                if (this.c == null) {
                    this.c = d(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }
}
