package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import java.lang.Thread;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: jz1  reason: default package */
public final class jz1 {
    public static volatile jz1 f;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1998a;
    public final List<mz1> b = new CopyOnWriteArrayList();
    public final a c = new a();
    public volatile oe3 d;
    public Thread.UncaughtExceptionHandler e;

    /* renamed from: jz1$a */
    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new lz1(this, runnable, t);
        }
    }

    /* renamed from: jz1$b */
    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicInteger f1999a = new AtomicInteger();

        public b(kz1 kz1) {
        }

        public final Thread newThread(Runnable runnable) {
            return new c(runnable, hj1.v(23, "measurement-", f1999a.incrementAndGet()));
        }
    }

    /* renamed from: jz1$c */
    public static class c extends Thread {
        public c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public jz1(Context context) {
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.f1998a = applicationContext;
        new ez1();
    }

    public static void c() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> a(Callable<V> callable) {
        if (!(Thread.currentThread() instanceof c)) {
            return this.c.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void b(Runnable runnable) {
        this.c.submit(runnable);
    }
}
