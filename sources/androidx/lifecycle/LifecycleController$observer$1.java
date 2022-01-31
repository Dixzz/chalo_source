package androidx.lifecycle;

import defpackage.zg;

/* compiled from: LifecycleController.kt */
public final class LifecycleController$observer$1 implements dh {
    public final /* synthetic */ LifecycleController f;
    public final /* synthetic */ rc6 g;

    public LifecycleController$observer$1(LifecycleController lifecycleController, rc6 rc6) {
        this.f = lifecycleController;
        this.g = rc6;
    }

    @Override // defpackage.dh
    public final void c(fh fhVar, zg.a aVar) {
        n86.e(fhVar, "source");
        n86.e(aVar, "<anonymous parameter 1>");
        zg lifecycle = fhVar.getLifecycle();
        n86.d(lifecycle, "source.lifecycle");
        if (((gh) lifecycle).c == zg.b.DESTROYED) {
            LifecycleController lifecycleController = this.f;
            ec6.j(this.g, null, 1, null);
            lifecycleController.a();
            return;
        }
        zg lifecycle2 = fhVar.getLifecycle();
        n86.d(lifecycle2, "source.lifecycle");
        if (((gh) lifecycle2).c.compareTo((Enum) this.f.c) < 0) {
            this.f.d.f3350a = true;
            return;
        }
        tg tgVar = this.f.d;
        if (tgVar.f3350a) {
            if (!tgVar.b) {
                tgVar.f3350a = false;
                tgVar.b();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
