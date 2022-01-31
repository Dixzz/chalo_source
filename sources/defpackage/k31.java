package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment$initQrCode$1$1", f = "ActiveSuperPassVisualValidationFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: k31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class k31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;
    public final /* synthetic */ z25 g;
    public final /* synthetic */ SuperPass h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k31(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, z25 z25, SuperPass superPass, k66<? super k31> k66) {
        super(2, k66);
        this.f = activeSuperPassVisualValidationFragment;
        this.g = z25;
        this.h = superPass;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new k31(this.f, this.g, this.h, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        k31 k31 = new k31(this.f, this.g, this.h, k66);
        s56 s56 = s56.f3190a;
        k31.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        ActiveSuperPassVisualValidationFragment.f(this.f).j.setImageBitmap(this.f.g().e(this.g, this.h));
        return s56.f3190a;
    }
}
