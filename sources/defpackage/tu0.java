package defpackage;

import android.content.ComponentName;
import android.content.Context;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import defpackage.it0;
import defpackage.xt;

/* renamed from: tu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class tu0 implements it0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f3406a;

    public tu0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f3406a = homeScreenMainFragment;
    }

    @Override // defpackage.it0.a
    public void a() {
        hj1.O0("boost ratings BottomSheet rendered", Long.MIN_VALUE);
    }

    @Override // defpackage.it0.a
    public void b() {
        xt.t1 t1Var = xt.f3961a;
        t1Var.e().c();
        ui1.m0(new ed1("boost ratings rate button clicked", Long.MIN_VALUE));
        if (t1Var.t().b("shouldTurnOffInAppRating")) {
            hj1.O0("in app ratings turned off", Long.MIN_VALUE);
            HomeScreenMainFragment.h(this.f3406a);
            return;
        }
        try {
            Context requireContext = this.f3406a.requireContext();
            int i = PlayCoreDialogWrapperActivity.g;
            hd3.w1(requireContext.getPackageManager(), new ComponentName(requireContext.getPackageName(), "com.google.android.play.core.common.PlayCoreDialogWrapperActivity"), 1);
            Context applicationContext = requireContext.getApplicationContext();
            if (applicationContext != null) {
                requireContext = applicationContext;
            }
            hx4 hx4 = new hx4(new lx4(requireContext));
            n86.d(hx4, "create(requireContext())");
            lx4 lx4 = hx4.f1442a;
            lx4.c.b(4, "requestInAppReview (%s)", new Object[]{lx4.b});
            ay4 ay4 = new ay4();
            lx4.f2291a.a(new jx4(lx4, ay4, ay4));
            ey4<ResultT> ey4 = ay4.f348a;
            n86.d(ey4, "lManager.requestReviewFlow()");
            yq0 yq0 = new yq0(this.f3406a, hx4);
            ey4.b.a(new tx4(rx4.f3146a, yq0));
            ey4.d();
        } catch (Exception e) {
            e.toString();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }

    @Override // defpackage.it0.a
    public void c() {
        xt.f3961a.e().a();
        ui1.m0(new ed1("boost ratings remind later clicked", Long.MIN_VALUE));
    }
}
