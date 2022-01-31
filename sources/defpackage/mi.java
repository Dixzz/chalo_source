package defpackage;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: mi  reason: default package */
/* compiled from: ModernAsyncTask */
public abstract class mi<Params, Progress, Result> {
    public static final ThreadFactory k;
    public static final BlockingQueue<Runnable> l;
    public static final Executor m;
    public static e n;
    public final g<Params, Result> f;
    public final FutureTask<Result> g;
    public volatile f h = f.PENDING;
    public final AtomicBoolean i = new AtomicBoolean();
    public final AtomicBoolean j = new AtomicBoolean();

    /* renamed from: mi$a */
    /* compiled from: ModernAsyncTask */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f2379a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder i0 = hj1.i0("ModernAsyncTask #");
            i0.append(this.f2379a.getAndIncrement());
            return new Thread(runnable, i0.toString());
        }
    }

    /* renamed from: mi$b */
    /* compiled from: ModernAsyncTask */
    public class b extends g<Params, Result> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            mi.this.j.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) mi.this.a(this.f);
                Binder.flushPendingCommands();
                mi.this.d(result);
                return result;
            } catch (Throwable th) {
                mi.this.d(result);
                throw th;
            }
        }
    }

    /* renamed from: mi$c */
    /* compiled from: ModernAsyncTask */
    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: mi */
        /* JADX WARN: Multi-variable type inference failed */
        public void done() {
            try {
                Object obj = get();
                mi miVar = mi.this;
                if (!miVar.j.get()) {
                    miVar.d(obj);
                }
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
            } catch (CancellationException unused2) {
                mi miVar2 = mi.this;
                if (!miVar2.j.get()) {
                    miVar2.d(null);
                }
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: mi$d */
    /* compiled from: ModernAsyncTask */
    public static class d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final mi f2380a;
        public final Data[] b;

        public d(mi miVar, Data... dataArr) {
            this.f2380a = miVar;
            this.b = dataArr;
        }
    }

    /* renamed from: mi$e */
    /* compiled from: ModernAsyncTask */
    public static class e extends Handler {
        public e() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i = message.what;
            if (i == 1) {
                mi miVar = dVar.f2380a;
                Data data = dVar.b[0];
                if (miVar.i.get()) {
                    miVar.b(data);
                } else {
                    miVar.c(data);
                }
                miVar.h = f.FINISHED;
            } else if (i == 2) {
                Objects.requireNonNull(dVar.f2380a);
            }
        }
    }

    /* renamed from: mi$f */
    /* compiled from: ModernAsyncTask */
    public enum f {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: mi$g */
    /* compiled from: ModernAsyncTask */
    public static abstract class g<Params, Result> implements Callable<Result> {
        public Params[] f;
    }

    static {
        a aVar = new a();
        k = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        l = linkedBlockingQueue;
        m = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }

    public mi() {
        b bVar = new b();
        this.f = bVar;
        this.g = new c(bVar);
    }

    public abstract Result a(Params... paramsArr);

    public void b(Result result) {
    }

    public void c(Result result) {
    }

    public Result d(Result result) {
        e eVar;
        synchronized (mi.class) {
            if (n == null) {
                n = new e();
            }
            eVar = n;
        }
        eVar.obtainMessage(1, new d(this, result)).sendToTarget();
        return result;
    }
}
