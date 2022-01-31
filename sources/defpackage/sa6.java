package defpackage;

import defpackage.rc6;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: sa6  reason: default package */
/* compiled from: CancellableContinuationImpl.kt */
public class sa6<T> extends vb6<T> implements ra6<T>, x66 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(sa6.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(sa6.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision = 0;
    private volatile /* synthetic */ Object _state = la6.f;
    public final k66<T> i;
    public final m66 j;
    public yb6 k;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: k66<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public sa6(k66<? super T> k66, int i2) {
        super(i2);
        this.i = k66;
        this.j = k66.getContext();
    }

    public final void A() {
        k66<T> k66 = this.i;
        Throwable th = null;
        qf6 qf6 = k66 instanceof qf6 ? (qf6) k66 : null;
        if (qf6 != null) {
            th = qf6.p(this);
        }
        if (th != null) {
            p();
            o(th);
        }
    }

    public final boolean B() {
        Object obj = this._state;
        if (!(obj instanceof db6) || ((db6) obj).d == null) {
            this._decision = 0;
            this._state = la6.f;
            return true;
        }
        p();
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v4, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    public final void C(Object obj, int i2, s76<? super Throwable, s56> s76) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof dd6) {
            } else {
                if (obj2 instanceof ua6) {
                    ua6 ua6 = (ua6) obj2;
                    Objects.requireNonNull(ua6);
                    if (ua6.c.compareAndSet(ua6, 0, 1)) {
                        if (s76 != null) {
                            n(s76, ua6.f955a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(n86.j("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!m.compareAndSet(this, obj2, D((dd6) obj2, obj, i2, s76, null)));
        q();
        r(i2);
    }

    public final Object D(dd6 dd6, Object obj, int i2, s76<? super Throwable, s56> s76, Object obj2) {
        if (obj instanceof eb6) {
            return obj;
        }
        if (!hd3.D1(i2) && obj2 == null) {
            return obj;
        }
        if (s76 == null && ((!(dd6 instanceof pa6) || (dd6 instanceof ma6)) && obj2 == null)) {
            return obj;
        }
        return new db6(obj, dd6 instanceof pa6 ? (pa6) dd6 : null, s76, obj2, null, 16);
    }

    public final dg6 E(Object obj, Object obj2, s76<? super Throwable, s56> s76) {
        Object obj3;
        dg6 dg6 = ta6.f3328a;
        do {
            obj3 = this._state;
            if (obj3 instanceof dd6) {
            } else if (!(obj3 instanceof db6)) {
                return null;
            } else {
                if (obj2 == null || ((db6) obj3).d != obj2) {
                    return null;
                }
                return dg6;
            }
        } while (!m.compareAndSet(this, obj3, D((dd6) obj3, obj, this.h, s76, obj2)));
        q();
        return dg6;
    }

    @Override // defpackage.vb6
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof dd6) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof eb6)) {
                if (obj2 instanceof db6) {
                    db6 db6 = (db6) obj2;
                    if (!(db6.e != null)) {
                        if (m.compareAndSet(this, obj2, db6.a(db6, null, null, null, null, th, 15))) {
                            pa6 pa6 = db6.b;
                            if (pa6 != null) {
                                k(pa6, th);
                            }
                            s76<Throwable, s56> s76 = db6.c;
                            if (s76 != null) {
                                n(s76, th);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (m.compareAndSet(this, obj2, new db6(obj2, null, null, null, th, 14))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // defpackage.vb6
    public final k66<T> b() {
        return this.i;
    }

    @Override // defpackage.vb6
    public Throwable c(Object obj) {
        Throwable c = super.c(obj);
        if (c == null) {
            return null;
        }
        return c;
    }

    @Override // defpackage.ra6
    public Object d(T t, Object obj) {
        return E(t, obj, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.vb6
    public <T> T e(Object obj) {
        return obj instanceof db6 ? (T) ((db6) obj).f818a : obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ra6
    public void g(s76<? super Throwable, s56> s76) {
        pa6 oc6 = s76 instanceof pa6 ? (pa6) s76 : new oc6(s76);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof la6)) {
                Throwable th = null;
                if (!(obj instanceof pa6)) {
                    boolean z = obj instanceof eb6;
                    boolean z2 = true;
                    if (z) {
                        eb6 eb6 = (eb6) obj;
                        Objects.requireNonNull(eb6);
                        if (!eb6.b.compareAndSet(eb6, 0, 1)) {
                            y(s76, obj);
                            throw null;
                        } else if (obj instanceof ua6) {
                            if (!z) {
                                eb6 = null;
                            }
                            if (eb6 != null) {
                                th = eb6.f955a;
                            }
                            j(s76, th);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj instanceof db6) {
                        db6 db6 = (db6) obj;
                        if (db6.b != null) {
                            y(s76, obj);
                            throw null;
                        } else if (!(oc6 instanceof ma6)) {
                            Throwable th2 = db6.e;
                            if (th2 == null) {
                                z2 = false;
                            }
                            if (z2) {
                                j(s76, th2);
                                return;
                            } else {
                                if (m.compareAndSet(this, obj, db6.a(db6, null, oc6, null, null, null, 29))) {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (!(oc6 instanceof ma6)) {
                        if (m.compareAndSet(this, obj, new db6(obj, oc6, null, null, null, 28))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    y(s76, obj);
                    throw null;
                }
            } else if (m.compareAndSet(this, obj, oc6)) {
                return;
            }
        }
    }

    @Override // defpackage.x66
    public x66 getCallerFrame() {
        k66<T> k66 = this.i;
        if (k66 instanceof x66) {
            return (x66) k66;
        }
        return null;
    }

    @Override // defpackage.k66
    public m66 getContext() {
        return this.j;
    }

    @Override // defpackage.ra6
    public Object h(Throwable th) {
        return E(new eb6(th, false, 2), null, null);
    }

    @Override // defpackage.vb6
    public Object i() {
        return this._state;
    }

    public final void j(s76<? super Throwable, s56> s76, Throwable th) {
        try {
            s76.invoke(th);
        } catch (Throwable th2) {
            hd3.x1(this.j, new hb6(n86.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void k(pa6 pa6, Throwable th) {
        try {
            pa6.a(th);
        } catch (Throwable th2) {
            hd3.x1(this.j, new hb6(n86.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    @Override // defpackage.ra6
    public Object l(T t, Object obj, s76<? super Throwable, s56> s76) {
        return E(t, null, s76);
    }

    @Override // defpackage.ra6
    public void m(kb6 kb6, T t) {
        kb6 kb62;
        k66<T> k66 = this.i;
        qf6 qf6 = k66 instanceof qf6 ? (qf6) k66 : null;
        if (qf6 == null) {
            kb62 = null;
        } else {
            kb62 = qf6.i;
        }
        C(t, kb62 == kb6 ? 4 : this.h, null);
    }

    public final void n(s76<? super Throwable, s56> s76, Throwable th) {
        try {
            s76.invoke(th);
        } catch (Throwable th2) {
            hd3.x1(this.j, new hb6(n86.j("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    public boolean o(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof dd6)) {
                return false;
            }
            z = obj instanceof pa6;
        } while (!m.compareAndSet(this, obj, new ua6(this, th, z)));
        pa6 pa6 = z ? (pa6) obj : null;
        if (pa6 != null) {
            k(pa6, th);
        }
        q();
        r(this.h);
        return true;
    }

    public final void p() {
        yb6 yb6 = this.k;
        if (yb6 != null) {
            yb6.h();
            this.k = cd6.f;
        }
    }

    public final void q() {
        if (!x()) {
            p();
        }
    }

    public final void r(int i2) {
        boolean z;
        boolean z2;
        while (true) {
            int i3 = this._decision;
            z = false;
            if (i3 == 0) {
                if (l.compareAndSet(this, 0, 2)) {
                    z2 = true;
                    break;
                }
            } else if (i3 == 1) {
                z2 = false;
            } else {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z2) {
            k66<T> b = b();
            if (i2 == 4) {
                z = true;
            }
            if (z || !(b instanceof qf6) || hd3.D1(i2) != hd3.D1(this.h)) {
                hd3.H2(this, b, z);
                return;
            }
            kb6 kb6 = ((qf6) b).i;
            m66 context = b.getContext();
            if (kb6.n(context)) {
                kb6.m(context, this);
                return;
            }
            md6 md6 = md6.f2360a;
            bc6 a2 = md6.a();
            if (a2.K()) {
                a2.E(this);
                return;
            }
            a2.J(true);
            try {
                hd3.H2(this, b(), true);
                do {
                } while (a2.L());
            } catch (Throwable th) {
                a2.A(true);
                throw th;
            }
            a2.A(true);
        }
    }

    @Override // defpackage.k66
    public void resumeWith(Object obj) {
        Throwable a2 = n56.a(obj);
        if (a2 != null) {
            obj = new eb6(a2, false, 2);
        }
        C(obj, this.h, null);
    }

    @Override // defpackage.ra6
    public void s(Object obj) {
        r(this.h);
    }

    public Throwable t(rc6 rc6) {
        return ((wc6) rc6).j();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(z());
        sb.append('(');
        sb.append(hd3.a3(this.i));
        sb.append("){");
        Object obj = this._state;
        if (obj instanceof dd6) {
            str = "Active";
        } else {
            str = obj instanceof ua6 ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(hd3.l1(this));
        return sb.toString();
    }

    public final Object u() {
        boolean z;
        boolean x = x();
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 == 0) {
                if (l.compareAndSet(this, 0, 1)) {
                    z = true;
                    break;
                }
            } else if (i2 != 2) {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z) {
            if (this.k == null) {
                w();
            }
            if (x) {
                A();
            }
            return p66.COROUTINE_SUSPENDED;
        }
        if (x) {
            A();
        }
        Object obj = this._state;
        if (obj instanceof eb6) {
            throw ((eb6) obj).f955a;
        }
        if (hd3.D1(this.h)) {
            m66 m66 = this.j;
            int i3 = rc6.e;
            rc6 rc6 = (rc6) m66.get(rc6.a.f);
            if (rc6 != null && !rc6.a()) {
                CancellationException j2 = rc6.j();
                a(obj, j2);
                throw j2;
            }
        }
        return e(obj);
    }

    public void v() {
        yb6 w = w();
        if (w != null && (!(this._state instanceof dd6))) {
            w.h();
            this.k = cd6.f;
        }
    }

    public final yb6 w() {
        m66 m66 = this.j;
        int i2 = rc6.e;
        rc6 rc6 = (rc6) m66.get(rc6.a.f);
        if (rc6 == null) {
            return null;
        }
        yb6 r = ec6.r(rc6, true, false, new va6(this), 2, null);
        this.k = r;
        return r;
    }

    public final boolean x() {
        k66<T> k66 = this.i;
        return (k66 instanceof qf6) && ((qf6) k66).k(this);
    }

    public final void y(s76<? super Throwable, s56> s76, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + s76 + ", already has " + obj).toString());
    }

    public String z() {
        return "CancellableContinuation";
    }
}
