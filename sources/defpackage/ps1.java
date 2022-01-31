package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ps1  reason: default package */
/* compiled from: RequestFutureTarget */
public class ps1<R> implements ns1<R>, Runnable {
    public static final a n = new a();
    public final Handler f;
    public final int g;
    public final int h;
    public R i;
    public os1 j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* renamed from: ps1$a */
    /* compiled from: RequestFutureTarget */
    public static class a {
    }

    public ps1(Handler handler, int i2, int i3) {
        this.f = handler;
        this.g = i2;
        this.h = i3;
    }

    @Override // defpackage.ct1
    public void a(bt1 bt1) {
    }

    @Override // defpackage.ct1
    public synchronized void b(R r, ft1<? super R> ft1) {
        this.l = true;
        this.i = r;
        notifyAll();
    }

    public synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this.k = true;
        notifyAll();
        if (z) {
            this.f.post(this);
        }
        return true;
    }

    @Override // defpackage.ct1
    public void d(os1 os1) {
        this.j = os1;
    }

    @Override // defpackage.ct1
    public synchronized void e(Drawable drawable) {
        this.m = true;
        notifyAll();
    }

    @Override // defpackage.ct1
    public void f(Drawable drawable) {
    }

    @Override // defpackage.ct1
    public os1 g() {
        return this.j;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return j(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.ct1
    public void h(Drawable drawable) {
    }

    @Override // defpackage.ct1
    public void i(bt1 bt1) {
        ((ts1) bt1).d(this.g, this.h);
    }

    public synchronized boolean isCancelled() {
        return this.k;
    }

    public synchronized boolean isDone() {
        return this.k || this.l;
    }

    public final synchronized R j(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (!isDone()) {
            if (!rt1.g()) {
                throw new IllegalArgumentException("You must call this method on a background thread");
            }
        }
        if (this.k) {
            throw new CancellationException();
        } else if (this.m) {
            throw new ExecutionException(new IllegalStateException("Load failed"));
        } else if (this.l) {
            return this.i;
        } else {
            if (l2 == null) {
                wait(0);
            } else if (l2.longValue() > 0) {
                wait(l2.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.m) {
                throw new ExecutionException(new IllegalStateException("Load failed"));
            } else if (this.k) {
                throw new CancellationException();
            } else if (this.l) {
                return this.i;
            } else {
                throw new TimeoutException();
            }
        }
    }

    @Override // defpackage.ur1
    public void l() {
    }

    @Override // defpackage.ur1
    public void m() {
    }

    @Override // defpackage.ur1
    public void n() {
    }

    public void run() {
        os1 os1 = this.j;
        if (os1 != null) {
            os1.clear();
            this.j = null;
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return j(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
