package defpackage;

import defpackage.rc6;

/* renamed from: ka6  reason: default package */
/* compiled from: AbstractCoroutine.kt */
public abstract class ka6<T> extends wc6 implements rc6, k66<T>, mb6 {
    public final m66 g;

    public ka6(m66 m66, boolean z, boolean z2) {
        super(z2);
        if (z) {
            M((rc6) m66.get(rc6.a.f));
        }
        this.g = m66.plus(this);
    }

    @Override // defpackage.wc6
    public String A() {
        return n86.j(getClass().getSimpleName(), " was cancelled");
    }

    @Override // defpackage.wc6
    public final void L(Throwable th) {
        hd3.x1(this.g, th);
    }

    @Override // defpackage.wc6
    public String Q() {
        boolean z = ib6.f1503a;
        return super.Q();
    }

    @Override // defpackage.wc6
    public final void U(Object obj) {
        if (obj instanceof eb6) {
            eb6 eb6 = (eb6) obj;
            Throwable th = eb6.f955a;
            eb6.a();
            d0();
            return;
        }
        e0();
    }

    @Override // defpackage.rc6, defpackage.wc6
    public boolean a() {
        return super.a();
    }

    public void c0(Object obj) {
        u(obj);
    }

    public void d0() {
    }

    /* JADX WARN: Incorrect args count in method signature: (TT;)V */
    public void e0() {
    }

    @Override // defpackage.k66
    public final m66 getContext() {
        return this.g;
    }

    @Override // defpackage.mb6
    public m66 n() {
        return this.g;
    }

    @Override // defpackage.k66
    public final void resumeWith(Object obj) {
        Object P = P(hd3.d3(obj, null));
        if (P != xc6.b) {
            c0(P);
        }
    }
}
