package com.freshchat.consumer.sdk.j.a;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aw;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final ThreadFactory iJ;
    private static final BlockingQueue<Runnable> iK;
    public static final Executor iL;
    private static final b iM = new b();
    private static volatile Executor iN;
    private final e<Params, Result> iO;
    private final FutureTask<Result> iP;
    private volatile d iQ = d.PENDING;
    private final AtomicBoolean iR = new AtomicBoolean();
    private final AtomicBoolean iS = new AtomicBoolean();

    /* renamed from: com.freshchat.consumer.sdk.j.a.a$4  reason: invalid class name */
    public /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] iV;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000d */
        static {
            /*
                com.freshchat.consumer.sdk.j.a.a.d.values()
                r0 = 3
                int[] r0 = new int[r0]
                com.freshchat.consumer.sdk.j.a.a.AnonymousClass4.iV = r0
                com.freshchat.consumer.sdk.j.a.a$d r1 = com.freshchat.consumer.sdk.j.a.a.d.RUNNING     // Catch:{ NoSuchFieldError -> 0x000d }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000d }
            L_0x000d:
                int[] r0 = com.freshchat.consumer.sdk.j.a.a.AnonymousClass4.iV     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.freshchat.consumer.sdk.j.a.a$d r1 = com.freshchat.consumer.sdk.j.a.a.d.FINISHED     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.a.AnonymousClass4.<clinit>():void");
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.j.a.a$a  reason: collision with other inner class name */
    public static class C0011a<Data> {
        public final a iW;
        public final Data[] iX;

        public C0011a(a aVar, Data... dataArr) {
            this.iW = aVar;
            this.iX = dataArr;
        }
    }

    public static class b extends Handler {
        private b() {
        }

        public void handleMessage(Message message) {
            C0011a aVar = (C0011a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.iW.finish(aVar.iX[0]);
            } else if (i == 2) {
                aVar.iW.onProgressUpdate(aVar.iX);
            }
        }
    }

    @TargetApi(11)
    public static class c implements Executor {
        public final ArrayDeque<Runnable> iY;
        public Runnable iZ;

        private c() {
            this.iY = new ArrayDeque<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.iY.offer(new Runnable() {
                /* class com.freshchat.consumer.sdk.j.a.a.c.AnonymousClass1 */

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.fe();
                    }
                }
            });
            if (this.iZ == null) {
                fe();
            }
        }

        public synchronized void fe() {
            Runnable poll = this.iY.poll();
            this.iZ = poll;
            if (poll != null) {
                a.THREAD_POOL_EXECUTOR.execute(poll);
            }
        }
    }

    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class e<Params, Result> implements Callable<Result> {
        public Params[] jg;

        private e() {
        }
    }

    static {
        AnonymousClass1 r9 = new ThreadFactory() {
            /* class com.freshchat.consumer.sdk.j.a.a.AnonymousClass1 */
            private final AtomicInteger iT = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                StringBuilder i0 = hj1.i0("AsyncTask #");
                i0.append(this.iT.getAndIncrement());
                return new Thread(runnable, i0.toString());
            }
        };
        iJ = r9;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        iK = linkedBlockingQueue;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, r9, new ThreadPoolExecutor.DiscardOldestPolicy());
        Executor cVar = aw.eT() ? new c() : Executors.newSingleThreadExecutor(r9);
        SERIAL_EXECUTOR = cVar;
        iL = Executors.newFixedThreadPool(2, r9);
        iN = cVar;
    }

    public a() {
        AnonymousClass2 r0 = new e<Params, Result>() {
            /* class com.freshchat.consumer.sdk.j.a.a.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                a.this.iS.set(true);
                Process.setThreadPriority(10);
                a aVar = a.this;
                return (Result) aVar.c(aVar.doInBackground(this.jg));
            }
        };
        this.iO = r0;
        this.iP = new FutureTask<Result>(r0) {
            /* class com.freshchat.consumer.sdk.j.a.a.AnonymousClass3 */

            public void done() {
                try {
                    a.this.b(get());
                } catch (InterruptedException e) {
                    ai.w("AsyncTask", "", e);
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
                } catch (Exception | CancellationException unused) {
                    a.this.b(null);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(Result result) {
        if (!this.iS.get()) {
            c(result);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Result c(Result result) {
        iM.obtainMessage(1, new C0011a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.iQ = d.FINISHED;
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.iQ != d.PENDING) {
            int i = AnonymousClass4.iV[this.iQ.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.iQ = d.RUNNING;
        onPreExecute();
        this.iO.jg = paramsArr;
        executor.execute(this.iP);
        return this;
    }

    public final a<Params, Progress, Result> a(Params... paramsArr) {
        return a(iN, paramsArr);
    }

    public final boolean cancel(boolean z) {
        this.iR.set(true);
        return this.iP.cancel(z);
    }

    public abstract Result doInBackground(Params... paramsArr);

    public final boolean isCancelled() {
        return this.iR.get();
    }

    public void onCancelled() {
    }

    public void onCancelled(Result result) {
        onCancelled();
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }
}
