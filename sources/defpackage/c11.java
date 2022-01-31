package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: c11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class c11 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSuperPassQrZoomedFragment f502a;

    public /* synthetic */ c11(ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment) {
        this.f502a = activeSuperPassQrZoomedFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment = this.f502a;
        SuperPass superPass = (SuperPass) obj;
        ActiveSuperPassQrZoomedFragment.a aVar = ActiveSuperPassQrZoomedFragment.h;
        n86.e(activeSuperPassQrZoomedFragment, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("super pass fetched", Long.MIN_VALUE);
        ed1.a("source", "active super pass qr zoomed fragment");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
        T t = activeSuperPassQrZoomedFragment.f;
        n86.c(t);
        ((fx) t).c.setOnMenuItemClickListener(new f11(activeSuperPassQrZoomedFragment, superPass));
        ah b = wg.b(activeSuperPassQrZoomedFragment);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new h31(superPass, activeSuperPassQrZoomedFragment, null), 2, null);
    }
}
