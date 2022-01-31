package defpackage;

import defpackage.xt;

/* renamed from: f60  reason: default package */
/* compiled from: UniversalPassFeature.kt */
public final class f60 implements e60 {
    @Override // defpackage.e60
    public boolean a() {
        xt.t1 t1Var = xt.f3961a;
        return t1Var.l().containsKey(n86.j("uniPass", t1Var.L().getUserId()));
    }

    @Override // defpackage.e60
    public void b() {
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put(n86.j("uniPass", t1Var.L().getUserId()), "true");
    }
}
