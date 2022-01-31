package defpackage;

import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import defpackage.zg;

@y66(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
/* renamed from: bh  reason: default package */
/* compiled from: Lifecycle.kt */
public final class bh extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public /* synthetic */ Object f;
    public final /* synthetic */ LifecycleCoroutineScopeImpl g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bh(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, k66 k66) {
        super(2, k66);
        this.g = lifecycleCoroutineScopeImpl;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        n86.e(k66, "completion");
        bh bhVar = new bh(this.g, k66);
        bhVar.f = obj;
        return bhVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        k66<? super s56> k662 = k66;
        n86.e(k662, "completion");
        bh bhVar = new bh(this.g, k662);
        bhVar.f = mb6;
        s56 s56 = s56.f3190a;
        bhVar.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        mb6 mb6 = (mb6) this.f;
        if (((gh) this.g.f).c.compareTo((Enum) zg.b.INITIALIZED) >= 0) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.g;
            lifecycleCoroutineScopeImpl.f.a(lifecycleCoroutineScopeImpl);
        } else {
            ec6.i(mb6.n(), null, 1, null);
        }
        return s56.f3190a;
    }
}
