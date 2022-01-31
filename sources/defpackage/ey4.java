package defpackage;

import java.util.concurrent.Executor;

/* JADX WARN: Incorrect class signature, class is equals to this class: <ResultT:Ljava/lang/Object;>Ley4<TResultT;>; */
/* renamed from: ey4  reason: default package */
public final class ey4<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1045a = new Object();
    public final zx4<ResultT> b = new zx4<>();
    public boolean c;
    public ResultT d;
    public Exception e;

    public final void a(ResultT resultt) {
        synchronized (this.f1045a) {
            if (!this.c) {
                this.c = true;
                this.d = resultt;
            } else {
                throw new IllegalStateException("Task is already complete");
            }
        }
        this.b.b(this);
    }

    public final ey4<ResultT> b(Executor executor, px4<? super ResultT> px4) {
        this.b.a(new xx4(executor, px4));
        d();
        return this;
    }

    public final void c(Exception exc) {
        synchronized (this.f1045a) {
            if (!this.c) {
                this.c = true;
                this.e = exc;
            } else {
                throw new IllegalStateException("Task is already complete");
            }
        }
        this.b.b(this);
    }

    public final void d() {
        synchronized (this.f1045a) {
            if (this.c) {
                this.b.b(this);
            }
        }
    }

    public final ResultT e() {
        ResultT resultt;
        synchronized (this.f1045a) {
            if (this.c) {
                Exception exc = this.e;
                if (exc == null) {
                    resultt = this.d;
                } else {
                    throw new qx4(exc);
                }
            } else {
                throw new IllegalStateException("Task is not yet complete");
            }
        }
        return resultt;
    }

    public final boolean f() {
        boolean z;
        synchronized (this.f1045a) {
            z = false;
            if (this.c && this.e == null) {
                z = true;
            }
        }
        return z;
    }
}
