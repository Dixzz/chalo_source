package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: n31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class n31 extends o86 implements h76<s56> {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;
    public final /* synthetic */ SuperPass g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n31(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, SuperPass superPass) {
        super(0);
        this.f = activeSuperPassVisualValidationFragment;
        this.g = superPass;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public s56 invoke() {
        ah b = wg.b(this.f);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new m31(this.g, this.f, null), 2, null);
        return s56.f3190a;
    }
}
