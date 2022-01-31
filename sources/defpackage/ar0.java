package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.MPass;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: ar0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ar0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ HomeScreenMainFragment g;
    public final /* synthetic */ MPass h;

    public /* synthetic */ ar0(du0 du0, HomeScreenMainFragment homeScreenMainFragment, MPass mPass) {
        this.f = du0;
        this.g = homeScreenMainFragment;
        this.h = mPass;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        HomeScreenMainFragment homeScreenMainFragment = this.g;
        MPass mPass = this.h;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(du0, "$lBottomSheet");
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(mPass, "$mPass");
        du0.dismiss();
        ui1.m0(new ed1("pass status prompt negative button click", Long.MIN_VALUE));
        homeScreenMainFragment.o().f().g(String.valueOf(mPass.getStartingTime()), true);
    }
}
