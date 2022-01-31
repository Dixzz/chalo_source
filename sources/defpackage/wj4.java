package defpackage;

import com.razorpay.AnalyticsConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: wj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class wj4<TResult> extends yi4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3791a = new Object();
    public final tj4<TResult> b = new tj4<>();
    @GuardedBy("mLock")
    public boolean c;
    public volatile boolean d;
    @GuardedBy("mLock")
    public TResult e;
    @GuardedBy("mLock")
    public Exception f;

    @Override // defpackage.yi4
    public final yi4<TResult> a(Executor executor, si4 si4) {
        this.b.a(new jj4(executor, si4));
        x();
        return this;
    }

    @Override // defpackage.yi4
    public final yi4<TResult> b(ti4<TResult> ti4) {
        this.b.a(new lj4(aj4.f170a, ti4));
        x();
        return this;
    }

    @Override // defpackage.yi4
    public final yi4<TResult> c(Executor executor, ti4<TResult> ti4) {
        this.b.a(new lj4(executor, ti4));
        x();
        return this;
    }

    @Override // defpackage.yi4
    public final yi4<TResult> d(ui4 ui4) {
        e(aj4.f170a, ui4);
        return this;
    }

    @Override // defpackage.yi4
    public final yi4<TResult> e(Executor executor, ui4 ui4) {
        this.b.a(new nj4(executor, ui4));
        x();
        return this;
    }

    @Override // defpackage.yi4
    public final yi4<TResult> f(vi4<? super TResult> vi4) {
        g(aj4.f170a, vi4);
        return this;
    }

    @Override // defpackage.yi4
    public final yi4<TResult> g(Executor executor, vi4<? super TResult> vi4) {
        this.b.a(new pj4(executor, vi4));
        x();
        return this;
    }

    @Override // defpackage.yi4
    public final <TContinuationResult> yi4<TContinuationResult> h(qi4<TResult, TContinuationResult> qi4) {
        return i(aj4.f170a, qi4);
    }

    @Override // defpackage.yi4
    public final <TContinuationResult> yi4<TContinuationResult> i(Executor executor, qi4<TResult, TContinuationResult> qi4) {
        wj4 wj4 = new wj4();
        this.b.a(new fj4(executor, qi4, wj4));
        x();
        return wj4;
    }

    @Override // defpackage.yi4
    public final <TContinuationResult> yi4<TContinuationResult> j(qi4<TResult, yi4<TContinuationResult>> qi4) {
        return k(aj4.f170a, qi4);
    }

    @Override // defpackage.yi4
    public final <TContinuationResult> yi4<TContinuationResult> k(Executor executor, qi4<TResult, yi4<TContinuationResult>> qi4) {
        wj4 wj4 = new wj4();
        this.b.a(new hj4(executor, qi4, wj4));
        x();
        return wj4;
    }

    @Override // defpackage.yi4
    public final Exception l() {
        Exception exc;
        synchronized (this.f3791a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // defpackage.yi4
    public final TResult m() {
        TResult tresult;
        synchronized (this.f3791a) {
            gj1.o(this.c, "Task is not yet complete");
            if (!this.d) {
                Exception exc = this.f;
                if (exc == null) {
                    tresult = this.e;
                } else {
                    throw new wi4(exc);
                }
            } else {
                throw new CancellationException("Task is already canceled.");
            }
        }
        return tresult;
    }

    @Override // defpackage.yi4
    public final <X extends Throwable> TResult n(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f3791a) {
            gj1.o(this.c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            } else if (!cls.isInstance(this.f)) {
                Exception exc = this.f;
                if (exc == null) {
                    tresult = this.e;
                } else {
                    throw new wi4(exc);
                }
            } else {
                throw cls.cast(this.f);
            }
        }
        return tresult;
    }

    @Override // defpackage.yi4
    public final boolean o() {
        return this.d;
    }

    @Override // defpackage.yi4
    public final boolean p() {
        boolean z;
        synchronized (this.f3791a) {
            z = this.c;
        }
        return z;
    }

    @Override // defpackage.yi4
    public final boolean q() {
        boolean z;
        synchronized (this.f3791a) {
            z = false;
            if (this.c && !this.d && this.f == null) {
                z = true;
            }
        }
        return z;
    }

    @Override // defpackage.yi4
    public final <TContinuationResult> yi4<TContinuationResult> r(xi4<TResult, TContinuationResult> xi4) {
        Executor executor = aj4.f170a;
        wj4 wj4 = new wj4();
        this.b.a(new rj4(executor, xi4, wj4));
        x();
        return wj4;
    }

    @Override // defpackage.yi4
    public final <TContinuationResult> yi4<TContinuationResult> s(Executor executor, xi4<TResult, TContinuationResult> xi4) {
        wj4 wj4 = new wj4();
        this.b.a(new rj4(executor, xi4, wj4));
        x();
        return wj4;
    }

    public final void t(TResult tresult) {
        synchronized (this.f3791a) {
            w();
            this.c = true;
            this.e = tresult;
        }
        this.b.b(this);
    }

    public final void u(Exception exc) {
        gj1.l(exc, "Exception must not be null");
        synchronized (this.f3791a) {
            w();
            this.c = true;
            this.f = exc;
        }
        this.b.b(this);
    }

    public final boolean v() {
        synchronized (this.f3791a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
            this.b.b(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    public final void w() {
        String str;
        if (this.c) {
            int i = ri4.f;
            if (p()) {
                Exception l = l();
                if (l != null) {
                    str = AnalyticsConstants.FAILURE;
                } else if (q()) {
                    String valueOf = String.valueOf(m());
                    str = hj1.a0(new StringBuilder(valueOf.length() + 7), "result ", valueOf);
                } else {
                    str = o() ? "cancellation" : "unknown issue";
                }
                String valueOf2 = String.valueOf(str);
                throw new ri4(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), l);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public final void x() {
        synchronized (this.f3791a) {
            if (this.c) {
                this.b.b(this);
            }
        }
    }
}
