package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment$initQrCode$1$1", f = "ActiveSuperPassFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: w21  reason: default package */
/* compiled from: ActiveSuperPassFragment.kt */
public final class w21 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ActiveSuperPassFragment f;
    public final /* synthetic */ z25 g;
    public final /* synthetic */ SuperPass h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w21(ActiveSuperPassFragment activeSuperPassFragment, z25 z25, SuperPass superPass, k66<? super w21> k66) {
        super(2, k66);
        this.f = activeSuperPassFragment;
        this.g = z25;
        this.h = superPass;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new w21(this.f, this.g, this.h, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        w21 w21 = new w21(this.f, this.g, this.h, k66);
        s56 s56 = s56.f3190a;
        w21.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        ActiveSuperPassFragment.f(this.f).i.setImageBitmap(this.f.g().e(this.g, this.h));
        return s56.f3190a;
    }
}
