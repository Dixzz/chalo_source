package defpackage;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ck5  reason: default package */
/* compiled from: PendingResult */
public class ck5<T> implements tj5, Future<T> {
    public boolean f;
    public boolean g;
    public boolean h = true;
    public T i;
    public final List<tj5> j = new ArrayList();
    public final List<uj5> k = new ArrayList();

    /* renamed from: ck5$a */
    /* compiled from: PendingResult */
    public class a extends uj5 {
        public final /* synthetic */ kk5 m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Looper looper, kk5 kk5) {
            super(looper);
            this.m = kk5;
        }

        @Override // defpackage.uj5
        public void d() {
            synchronized (ck5.this) {
                ck5 ck5 = ck5.this;
                if (ck5.h) {
                    this.m.a(ck5.i);
                }
            }
        }
    }

    public ck5<T> a(Looper looper, kk5<T> kk5) {
        synchronized (this) {
            if (!isCancelled()) {
                if (this.h) {
                    a aVar = new a(looper, kk5);
                    if (isDone()) {
                        aVar.run();
                    }
                    this.k.add(aVar);
                    return this;
                }
            }
            return this;
        }
    }

    public ck5<T> b(kk5<T> kk5) {
        a(Looper.myLooper(), kk5);
        return this;
    }

    @Override // defpackage.tj5
    public final boolean cancel() {
        return cancel(false);
    }

    public void d(T t) {
        synchronized (this) {
            if (!isDone()) {
                this.i = t;
                this.g = true;
                this.j.clear();
                notifyAll();
                for (uj5 uj5 : this.k) {
                    uj5.run();
                }
                this.k.clear();
            }
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        synchronized (this) {
            if (isDone()) {
                return this.i;
            }
            wait();
            return this.i;
        }
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.f;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this) {
            if (!this.f) {
                if (!this.g) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // defpackage.tj5
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isCancelled()) {
                return true;
            }
            this.h = false;
            for (uj5 uj5 : this.k) {
                uj5.cancel(z);
            }
            this.k.clear();
            if (isDone()) {
                return false;
            }
            this.f = true;
            notifyAll();
            for (tj5 tj5 : this.j) {
                tj5.cancel(z);
            }
            this.j.clear();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        synchronized (this) {
            if (isDone()) {
                return this.i;
            }
            wait(timeUnit.toMillis(j2));
            return this.i;
        }
    }
}
