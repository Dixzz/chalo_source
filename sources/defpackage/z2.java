package defpackage;

import defpackage.w2;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: z2  reason: default package */
/* compiled from: CallbackToFutureAdapter */
public final class z2<T> implements gy4<T> {
    public final WeakReference<x2<T>> f;
    public final w2<T> g = new a();

    /* renamed from: z2$a */
    /* compiled from: CallbackToFutureAdapter */
    public class a extends w2<T> {
        public a() {
        }

        @Override // defpackage.w2
        public String g() {
            x2<T> x2Var = z2.this.f.get();
            if (x2Var == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            StringBuilder i0 = hj1.i0("tag=[");
            i0.append(x2Var.f3872a);
            i0.append("]");
            return i0.toString();
        }
    }

    public z2(x2<T> x2Var) {
        this.f = new WeakReference<>(x2Var);
    }

    @Override // defpackage.gy4
    public void c(Runnable runnable, Executor executor) {
        this.g.c(runnable, executor);
    }

    public boolean cancel(boolean z) {
        x2<T> x2Var = this.f.get();
        boolean cancel = this.g.cancel(z);
        if (cancel && x2Var != null) {
            x2Var.f3872a = null;
            x2Var.b = null;
            x2Var.c.i(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        return this.g.get();
    }

    public boolean isCancelled() {
        return this.g.f instanceof w2.c;
    }

    public boolean isDone() {
        return this.g.isDone();
    }

    public String toString() {
        return this.g.toString();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.g.get(j, timeUnit);
    }
}
