package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: g11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class g11 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSuperPassQrZoomedFragment f1203a;
    public final /* synthetic */ z25 b;
    public final /* synthetic */ int c;

    public /* synthetic */ g11(ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment, z25 z25, int i) {
        this.f1203a = activeSuperPassQrZoomedFragment;
        this.b = z25;
        this.c = i;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment = this.f1203a;
        z25 z25 = this.b;
        int i = this.c;
        SuperPass superPass = (SuperPass) obj;
        ActiveSuperPassQrZoomedFragment.a aVar = ActiveSuperPassQrZoomedFragment.h;
        n86.e(activeSuperPassQrZoomedFragment, "this$0");
        n86.e(z25, "$lMultiFormatWriter");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("super pass fetched", Long.MIN_VALUE);
        ed1.a("source", "active super pass qr zoomed fragment");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
        ah b2 = wg.b(activeSuperPassQrZoomedFragment);
        g31 g31 = new g31(activeSuperPassQrZoomedFragment, z25, superPass, i);
        n86.e(b2, "<this>");
        n86.e(g31, "action");
        hd3.Y1(b2, hj1.s0(CoroutineExceptionHandler.a.f, xb6.b), null, new rh1(1000, g31, null), 2, null);
    }
}
