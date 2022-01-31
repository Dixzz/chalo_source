package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: l31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class l31 extends o86 implements h76<s56> {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;
    public final /* synthetic */ z25 g;
    public final /* synthetic */ SuperPass h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l31(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, z25 z25, SuperPass superPass) {
        super(0);
        this.f = activeSuperPassVisualValidationFragment;
        this.g = z25;
        this.h = superPass;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public s56 invoke() {
        ah b = wg.b(this.f);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new k31(this.f, this.g, this.h, null), 2, null);
        return s56.f3190a;
    }
}
