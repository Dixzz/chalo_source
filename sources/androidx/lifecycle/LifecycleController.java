package androidx.lifecycle;

import defpackage.zg;

/* compiled from: LifecycleController.kt */
public final class LifecycleController {

    /* renamed from: a  reason: collision with root package name */
    public final dh f221a;
    public final zg b;
    public final zg.b c;
    public final tg d;

    public LifecycleController(zg zgVar, zg.b bVar, tg tgVar, rc6 rc6) {
        n86.e(zgVar, "lifecycle");
        n86.e(bVar, "minState");
        n86.e(tgVar, "dispatchQueue");
        n86.e(rc6, "parentJob");
        this.b = zgVar;
        this.c = bVar;
        this.d = tgVar;
        LifecycleController$observer$1 lifecycleController$observer$1 = new LifecycleController$observer$1(this, rc6);
        this.f221a = lifecycleController$observer$1;
        if (((gh) zgVar).c == zg.b.DESTROYED) {
            ec6.j(rc6, null, 1, null);
            a();
            return;
        }
        zgVar.a(lifecycleController$observer$1);
    }

    public final void a() {
        this.b.b(this.f221a);
        tg tgVar = this.d;
        tgVar.b = true;
        tgVar.b();
    }
}
