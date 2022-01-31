package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import app.zophop.ui.activities.MPassPurchaseActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: br0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class br0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ HomeScreenMainFragment g;
    public final /* synthetic */ MPass h;

    public /* synthetic */ br0(du0 du0, HomeScreenMainFragment homeScreenMainFragment, MPass mPass) {
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
        du0.f = true;
        du0.dismiss();
        ui1.m0(new ed1("pass status prompt positive button click", Long.MIN_VALUE));
        homeScreenMainFragment.o().f().g(String.valueOf(mPass.getStartingTime()), true);
        ve activity = homeScreenMainFragment.c();
        if (activity != null) {
            if (mPass.get_passApplicationActionRequired() != PassApplicationActionRequired.INVALID) {
                MPassPurchaseActivity.s0(activity, "sourcePassVerificationFailedDialogHomeScreen", "flowReapplication", mPass, null);
                return;
            }
            Intent intent = new Intent(homeScreenMainFragment.getContext(), BookingSummaryMagicPassActivity.class);
            intent.putExtra("magic_pass_info", mPass);
            intent.putExtra("src", "home screen dialog");
            homeScreenMainFragment.startActivity(intent);
        }
    }
}
