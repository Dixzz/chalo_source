package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import defpackage.mi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: ki  reason: default package */
/* compiled from: AsyncTaskLoader */
public abstract class ki<D> extends li<D> {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncTaskLoader";
    public volatile ki<D>.a mCancellingTask;
    private final Executor mExecutor;
    public Handler mHandler;
    public long mLastLoadCompleteTime;
    public volatile ki<D>.a mTask;
    public long mUpdateThrottle;

    /* renamed from: ki$a */
    /* compiled from: AsyncTaskLoader */
    public final class a extends mi<Void, Void, D> implements Runnable {
        public final CountDownLatch o = new CountDownLatch(1);
        public boolean p;

        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // defpackage.mi
        public Object a(Void[] voidArr) {
            return ki.this.onLoadInBackground();
        }

        @Override // defpackage.mi
        public void b(D d) {
            try {
                ki.this.dispatchOnCancelled(this, d);
            } finally {
                this.o.countDown();
            }
        }

        @Override // defpackage.mi
        public void c(D d) {
            try {
                ki.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.o.countDown();
            }
        }

        public void run() {
            this.p = false;
            ki.this.executePendingTask();
        }
    }

    public ki(Context context) {
        this(context, mi.m);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(ki<D>.a aVar, D d) {
        onCanceled(d);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(ki<D>.a aVar, D d) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    @Override // defpackage.li
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.p);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.p);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            y7.b(this.mUpdateThrottle, printWriter, 0);
            printWriter.print(" mLastLoadCompleteTime=");
            long j = this.mLastLoadCompleteTime;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (j == 0) {
                printWriter.print("--");
            } else {
                y7.b(j - uptimeMillis, printWriter, 0);
            }
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.p) {
                this.mTask.p = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                ki<D>.a aVar = this.mTask;
                Executor executor = this.mExecutor;
                if (aVar.h != mi.f.PENDING) {
                    int ordinal = aVar.h.ordinal();
                    if (ordinal == 1) {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    } else if (ordinal != 2) {
                        throw new IllegalStateException("We should never reach this state");
                    } else {
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                } else {
                    aVar.h = mi.f.RUNNING;
                    aVar.f.f = null;
                    executor.execute(aVar.g);
                }
            } else {
                this.mTask.p = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            }
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    @Override // defpackage.li
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.p) {
                this.mTask.p = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.p) {
            this.mTask.p = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            ki<D>.a aVar = this.mTask;
            aVar.i.set(true);
            boolean cancel = aVar.g.cancel(false);
            if (cancel) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return cancel;
        }
    }

    public void onCanceled(D d) {
    }

    @Override // defpackage.li
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new a();
        executePendingTask();
    }

    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        ki<D>.a aVar = this.mTask;
        if (aVar != null) {
            try {
                aVar.o.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    private ki(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }
}
