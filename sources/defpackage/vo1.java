package defpackage;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: vo1  reason: default package */
/* compiled from: GlideExecutor */
public final class vo1 extends ThreadPoolExecutor {
    public static final long g = TimeUnit.SECONDS.toMillis(10);
    public static final /* synthetic */ int h = 0;
    public final boolean f;

    /* renamed from: vo1$a */
    /* compiled from: GlideExecutor */
    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final String f3667a;
        public final b b;
        public final boolean c;
        public int d;

        /* renamed from: vo1$a$a  reason: collision with other inner class name */
        /* compiled from: GlideExecutor */
        public class C0063a extends Thread {
            public C0063a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (a.this.c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    a.this.b.handle(th);
                }
            }
        }

        public a(String str, b bVar, boolean z) {
            this.f3667a = str;
            this.b = bVar;
            this.c = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            C0063a aVar;
            aVar = new C0063a(runnable, "glide-" + this.f3667a + "-thread-" + this.d);
            this.d = this.d + 1;
            return aVar;
        }
    }

    /* renamed from: vo1$b */
    /* compiled from: GlideExecutor */
    public enum b {
        IGNORE,
        LOG {
            @Override // defpackage.vo1.b
            public void handle(Throwable th) {
                if (th != null) {
                    Log.isLoggable("GlideExecutor", 6);
                }
            }
        },
        THROW {
            @Override // defpackage.vo1.b
            public void handle(Throwable th) {
                super.handle(th);
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        
        public static final b DEFAULT;

        /* access modifiers changed from: public */
        static {
            a aVar;
            DEFAULT = aVar;
        }

        public void handle(Throwable th) {
        }

        /* access modifiers changed from: public */
        /* synthetic */ b(uo1 uo1) {
            this();
        }
    }

    public vo1(int i, String str, b bVar, boolean z, boolean z2) {
        this(i, i, 0, str, bVar, z, z2, new PriorityBlockingQueue());
    }

    public final <T> Future<T> a(Future<T> future) {
        if (this.f) {
            boolean z = false;
            while (!future.isDone()) {
                try {
                    try {
                        future.get();
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        return future;
    }

    public void execute(Runnable runnable) {
        if (this.f) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        Future<?> submit = super.submit(runnable);
        a(submit);
        return submit;
    }

    public vo1(int i, int i2, long j, String str, b bVar, boolean z, boolean z2, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, TimeUnit.MILLISECONDS, blockingQueue, new a(str, bVar, z));
        this.f = z2;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        Future<T> submit = super.submit(runnable, t);
        a(submit);
        return submit;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        Future<T> submit = super.submit(callable);
        a(submit);
        return submit;
    }
}
