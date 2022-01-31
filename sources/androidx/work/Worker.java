package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;

public abstract class Worker extends ListenableWorker {
    public ot<ListenableWorker.a> j;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Worker.this.j.j(Worker.this.g());
            } catch (Throwable th) {
                Worker.this.j.k(th);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final gy4<ListenableWorker.a> d() {
        this.j = new ot<>();
        this.g.c.execute(new a());
        return this.j;
    }

    public abstract ListenableWorker.a g();
}
