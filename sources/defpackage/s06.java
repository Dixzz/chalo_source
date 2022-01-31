package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.LinkedList;
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

/* renamed from: s06  reason: default package */
/* compiled from: AsyncTask */
public abstract class s06<Params, Progress, Result> {
    public static final int k;
    public static final int l;
    public static final int m;
    public static final ThreadFactory n;
    public static final BlockingQueue<Runnable> o;
    public static final Executor p;
    public static final Executor q = new f(null);
    public static final e r = new e();
    public final h<Params, Result> f;
    public final FutureTask<Result> g;
    public volatile g h = g.PENDING;
    public final AtomicBoolean i = new AtomicBoolean();
    public final AtomicBoolean j = new AtomicBoolean();

    /* renamed from: s06$a */
    /* compiled from: AsyncTask */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f3161a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder i0 = hj1.i0("AsyncTask #");
            i0.append(this.f3161a.getAndIncrement());
            return new Thread(runnable, i0.toString());
        }
    }

    /* renamed from: s06$b */
    /* compiled from: AsyncTask */
    public class b extends h<Params, Result> {
        public b() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            s06.this.j.set(true);
            Process.setThreadPriority(10);
            s06 s06 = s06.this;
            Params[] paramsArr = this.f;
            b06 b06 = (b06) s06;
            Objects.requireNonNull(b06);
            r06 c = b06.c("doInBackground");
            Result doInBackground = !b06.i.get() ? b06.t.doInBackground() : null;
            c.a();
            s06.a(doInBackground);
            return doInBackground;
        }
    }

    /* renamed from: s06$c */
    /* compiled from: AsyncTask */
    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: s06 */
        /* JADX WARN: Multi-variable type inference failed */
        public void done() {
            try {
                s06 s06 = s06.this;
                Object obj = get();
                if (!s06.j.get()) {
                    s06.a(obj);
                }
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                throw new RuntimeException("An error occured while executing doInBackground()", e.getCause());
            } catch (CancellationException unused2) {
                s06 s062 = s06.this;
                if (!s062.j.get()) {
                    s062.a(null);
                }
            }
        }
    }

    /* renamed from: s06$d */
    /* compiled from: AsyncTask */
    public static class d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final s06 f3162a;
        public final Data[] b;

        public d(s06 s06, Data... dataArr) {
            this.f3162a = s06;
            this.b = dataArr;
        }
    }

    /* renamed from: s06$e */
    /* compiled from: AsyncTask */
    public static class e extends Handler {
        public e() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i = message.what;
            if (i == 1) {
                s06 s06 = dVar.f3162a;
                Data data = dVar.b[0];
                if (s06.i.get()) {
                    b06 b06 = (b06) s06;
                    b06.t.onCancelled(data);
                    b06.t.initializationCallback.a(new a06(b06.t.getIdentifier() + " Initialization was cancelled"));
                } else {
                    b06 b062 = (b06) s06;
                    b062.t.onPostExecute(data);
                    b062.t.initializationCallback.b(data);
                }
                s06.h = g.FINISHED;
            } else if (i == 2) {
                Objects.requireNonNull(dVar.f3162a);
            }
        }
    }

    /* renamed from: s06$f */
    /* compiled from: AsyncTask */
    public static class f implements Executor {
        public final LinkedList<Runnable> f = new LinkedList<>();
        public Runnable g;

        /* renamed from: s06$f$a */
        /* compiled from: AsyncTask */
        public class a implements Runnable {
            public final /* synthetic */ Runnable f;

            public a(Runnable runnable) {
                this.f = runnable;
            }

            public void run() {
                try {
                    this.f.run();
                } finally {
                    f.this.a();
                }
            }
        }

        public f(a aVar) {
        }

        public synchronized void a() {
            Runnable poll = this.f.poll();
            this.g = poll;
            if (poll != null) {
                s06.p.execute(poll);
            }
        }

        public synchronized void execute(Runnable runnable) {
            this.f.offer(new a(runnable));
            if (this.g == null) {
                a();
            }
        }
    }

    /* renamed from: s06$g */
    /* compiled from: AsyncTask */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: s06$h */
    /* compiled from: AsyncTask */
    public static abstract class h<Params, Result> implements Callable<Result> {
        public Params[] f;

        public h(a aVar) {
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        k = availableProcessors;
        int i2 = availableProcessors + 1;
        l = i2;
        int i3 = (availableProcessors * 2) + 1;
        m = i3;
        a aVar = new a();
        n = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        o = linkedBlockingQueue;
        p = new ThreadPoolExecutor(i2, i3, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }

    public s06() {
        b bVar = new b();
        this.f = bVar;
        this.g = new c(bVar);
    }

    public final Result a(Result result) {
        r.obtainMessage(1, new d(this, result)).sendToTarget();
        return result;
    }
}
