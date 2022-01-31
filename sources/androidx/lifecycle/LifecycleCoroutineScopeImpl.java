package androidx.lifecycle;

import defpackage.zg;

/* compiled from: Lifecycle.kt */
public final class LifecycleCoroutineScopeImpl extends ah implements dh {
    public final zg f;
    public final m66 g;

    public LifecycleCoroutineScopeImpl(zg zgVar, m66 m66) {
        n86.e(zgVar, "lifecycle");
        n86.e(m66, "coroutineContext");
        this.f = zgVar;
        this.g = m66;
        if (((gh) zgVar).c == zg.b.DESTROYED) {
            ec6.i(m66, null, 1, null);
        }
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        n86.e(fhVar, "source");
        n86.e(aVar, "event");
        if (((gh) this.f).c.compareTo((Enum) zg.b.DESTROYED) <= 0) {
            gh ghVar = (gh) this.f;
            ghVar.d("removeObserver");
            ghVar.b.n(this);
            ec6.i(this.g, null, 1, null);
        }
    }

    @Override // defpackage.ah
    public zg h() {
        return this.f;
    }

    @Override // defpackage.mb6
    public m66 n() {
        return this.g;
    }
}
