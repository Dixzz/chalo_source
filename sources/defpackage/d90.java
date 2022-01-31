package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: d90  reason: default package */
/* compiled from: ExceptionThrowingFutureTask */
public class d90 extends FutureTask<Object> {

    /* renamed from: d90$a */
    /* compiled from: ExceptionThrowingFutureTask */
    public class a implements Runnable {
        public final /* synthetic */ ExecutionException f;

        public a(d90 d90, ExecutionException executionException) {
            this.f = executionException;
        }

        public void run() {
            throw new RuntimeException(this.f.getMessage(), this.f);
        }
    }

    public d90(Runnable runnable) {
        super(runnable, null);
    }

    public void done() {
        try {
            if (!isCancelled()) {
                get();
            }
        } catch (ExecutionException e) {
            new Thread(new a(this, e)).start();
        } catch (InterruptedException unused) {
        }
    }
}
