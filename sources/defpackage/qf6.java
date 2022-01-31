package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: qf6  reason: default package */
/* compiled from: DispatchedContinuation.kt */
public final class qf6<T> extends vb6<T> implements x66, k66<T> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(qf6.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public final kb6 i;
    public final k66<T> j;
    public Object k = rf6.f3077a;
    public final Object l;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: k66<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public qf6(kb6 kb6, k66<? super T> k66) {
        super(-1);
        this.i = kb6;
        this.j = k66;
        Object fold = getContext().fold(0, fg6.b);
        n86.c(fold);
        this.l = fold;
        this._reusableCancellableContinuation = null;
    }

    @Override // defpackage.vb6
    public void a(Object obj, Throwable th) {
        if (obj instanceof fb6) {
            ((fb6) obj).b.invoke(th);
        }
    }

    @Override // defpackage.vb6
    public k66<T> b() {
        return this;
    }

    @Override // defpackage.x66
    public x66 getCallerFrame() {
        k66<T> k66 = this.j;
        if (k66 instanceof x66) {
            return (x66) k66;
        }
        return null;
    }

    @Override // defpackage.k66
    public m66 getContext() {
        return this.j.getContext();
    }

    @Override // defpackage.vb6
    public Object i() {
        Object obj = this.k;
        this.k = rf6.f3077a;
        return obj;
    }

    public final sa6<T> j() {
        dg6 dg6 = rf6.b;
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = dg6;
                return null;
            } else if (obj instanceof sa6) {
                if (m.compareAndSet(this, obj, dg6)) {
                    return (sa6) obj;
                }
            } else if (obj != dg6 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(n86.j("Inconsistent state ", obj).toString());
            }
        }
    }

    public final boolean k(sa6<?> sa6) {
        Object obj = this._reusableCancellableContinuation;
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof sa6) || obj == sa6) {
            return true;
        }
        return false;
    }

    public final boolean n(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            dg6 dg6 = rf6.b;
            if (n86.a(obj, dg6)) {
                if (m.compareAndSet(this, dg6, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (m.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void o() {
        do {
        } while (this._reusableCancellableContinuation == rf6.b);
        Object obj = this._reusableCancellableContinuation;
        sa6 sa6 = obj instanceof sa6 ? (sa6) obj : null;
        if (sa6 != null) {
            sa6.p();
        }
    }

    public final Throwable p(ra6<?> ra6) {
        dg6 dg6;
        do {
            Object obj = this._reusableCancellableContinuation;
            dg6 = rf6.b;
            if (obj != dg6) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(n86.j("Inconsistent state ", obj).toString());
                } else if (m.compareAndSet(this, obj, null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!m.compareAndSet(this, dg6, ra6));
        return null;
    }

    @Override // defpackage.k66
    public void resumeWith(Object obj) {
        m66 context = this.j.getContext();
        Object d3 = hd3.d3(obj, null);
        if (this.i.n(context)) {
            this.k = d3;
            this.h = 0;
            this.i.m(context, this);
            return;
        }
        md6 md6 = md6.f2360a;
        bc6 a2 = md6.a();
        if (a2.K()) {
            this.k = d3;
            this.h = 0;
            a2.E(this);
            return;
        }
        a2.J(true);
        try {
            m66 context2 = getContext();
            Object b = fg6.b(context2, this.l);
            try {
                this.j.resumeWith(obj);
                do {
                } while (a2.L());
                a2.A(true);
            } finally {
                fg6.a(context2, b);
            }
        } catch (Throwable th) {
            a2.A(true);
            throw th;
        }
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DispatchedContinuation[");
        i0.append(this.i);
        i0.append(", ");
        i0.append(hd3.a3(this.j));
        i0.append(']');
        return i0.toString();
    }
}
