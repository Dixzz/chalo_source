package defpackage;

import androidx.lifecycle.LifecycleController;
import defpackage.rc6;
import defpackage.zg;

@y66(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {162}, m = "invokeSuspend")
/* renamed from: sh  reason: default package */
/* compiled from: PausingDispatcher.kt */
public final class sh extends b76 implements w76<mb6, k66<? super T>, Object> {
    public /* synthetic */ Object f;
    public int g;
    public final /* synthetic */ zg h;
    public final /* synthetic */ zg.b i;
    public final /* synthetic */ w76 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sh(zg zgVar, zg.b bVar, w76 w76, k66 k66) {
        super(2, k66);
        this.h = zgVar;
        this.i = bVar;
        this.j = w76;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        n86.e(k66, "completion");
        sh shVar = new sh(this.h, this.i, this.j, k66);
        shVar.f = obj;
        return shVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public final Object invoke(mb6 mb6, Object obj) {
        k66 k66 = (k66) obj;
        n86.e(k66, "completion");
        sh shVar = new sh(this.h, this.i, this.j, k66);
        shVar.f = mb6;
        return shVar.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        LifecycleController lifecycleController;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i2 = this.g;
        if (i2 == 0) {
            hd3.Y2(obj);
            m66 n = ((mb6) this.f).n();
            int i3 = rc6.e;
            rc6 rc6 = (rc6) n.get(rc6.a.f);
            if (rc6 != null) {
                rh rhVar = new rh();
                LifecycleController lifecycleController2 = new LifecycleController(this.h, this.i, rhVar.g, rc6);
                try {
                    w76 w76 = this.j;
                    this.f = lifecycleController2;
                    this.g = 1;
                    obj = hd3.j3(rhVar, w76, this);
                    if (obj == p66) {
                        return p66;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th2) {
                    th = th2;
                    lifecycleController = lifecycleController2;
                    lifecycleController.a();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i2 == 1) {
            lifecycleController = (LifecycleController) this.f;
            try {
                hd3.Y2(obj);
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.a();
        return obj;
    }
}
