package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: nq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class nq0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ HomeScreenMainFragment g;
    public final /* synthetic */ SuperPassApplication h;

    public /* synthetic */ nq0(du0 du0, HomeScreenMainFragment homeScreenMainFragment, SuperPassApplication superPassApplication) {
        this.f = du0;
        this.g = homeScreenMainFragment;
        this.h = superPassApplication;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        HomeScreenMainFragment homeScreenMainFragment = this.g;
        SuperPassApplication superPassApplication = this.h;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(du0, "$lBottomSheet");
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(superPassApplication, "$lSuperPassApplication");
        du0.dismiss();
        ui1.m0(new ed1("pass status prompt negative button click", Long.MIN_VALUE));
        homeScreenMainFragment.o().f().g(String.valueOf(superPassApplication.getPassStartDate()), true);
    }
}
