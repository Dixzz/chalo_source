package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: g31  reason: default package */
/* compiled from: ActiveSuperPassQrZoomedFragment.kt */
public final class g31 extends o86 implements h76<s56> {
    public final /* synthetic */ ActiveSuperPassQrZoomedFragment f;
    public final /* synthetic */ z25 g;
    public final /* synthetic */ SuperPass h;
    public final /* synthetic */ int i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g31(ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment, z25 z25, SuperPass superPass, int i2) {
        super(0);
        this.f = activeSuperPassQrZoomedFragment;
        this.g = z25;
        this.h = superPass;
        this.i = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public s56 invoke() {
        ah b = wg.b(this.f);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new f31(this.f, this.g, this.h, this.i, null), 2, null);
        return s56.f3190a;
    }
}
