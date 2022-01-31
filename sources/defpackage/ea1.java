package defpackage;

import android.content.Context;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;

@y66(c = "app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel$onPayBtnClickedWithNoVerificationRequired$1", f = "SuperPassPurchaseSharedViewModel.kt", l = {}, m = "invokeSuspend")
/* renamed from: ea1  reason: default package */
/* compiled from: SuperPassPurchaseSharedViewModel.kt */
public final class ea1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ SuperPassPurchaseSharedViewModel f;
    public final /* synthetic */ Context g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ea1(SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel, Context context, k66<? super ea1> k66) {
        super(2, k66);
        this.f = superPassPurchaseSharedViewModel;
        this.g = context;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new ea1(this.f, this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        ea1 ea1 = new ea1(this.f, this.g, k66);
        s56 s56 = s56.f3190a;
        ea1.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel = this.f;
        y60.g(superPassPurchaseSharedViewModel.k, superPassPurchaseSharedViewModel.l, superPassPurchaseSharedViewModel.m, superPassPurchaseSharedViewModel.g(), this.g);
        return s56.f3190a;
    }
}
