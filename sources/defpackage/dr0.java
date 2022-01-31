package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.ProductActiveStatus;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.ui.activities.ConfirmMagicPassActivity;
import app.zophop.ui.activities.MPassPurchaseActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: dr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dr0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ MPass g;
    public final /* synthetic */ HomeScreenMainFragment h;

    public /* synthetic */ dr0(du0 du0, MPass mPass, HomeScreenMainFragment homeScreenMainFragment) {
        this.f = du0;
        this.g = mPass;
        this.h = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        MPass mPass = this.g;
        HomeScreenMainFragment homeScreenMainFragment = this.h;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(du0, "$lBottomSheet");
        n86.e(mPass, "$mPass");
        n86.e(homeScreenMainFragment, "this$0");
        du0.f = true;
        du0.dismiss();
        ProductConfiguration m0 = vn.m0(mPass.getConfigId());
        if (m0 != null) {
            ProductActiveStatus h2 = vn.h(mPass, m0);
            if (h2.getIsActive()) {
                ui1.m0(new ed1("pass status prompt positive button click", Long.MIN_VALUE));
                homeScreenMainFragment.o().f().g(String.valueOf(mPass.getStartingTime()), true);
                ve activity = homeScreenMainFragment.c();
                if (activity != null) {
                    if (mPass.get_passApplicationActionRequired() != PassApplicationActionRequired.INVALID) {
                        MPassPurchaseActivity.s0(activity, "sourcePassVerifiedBottomsheetHomeScreen", "flowPaymentPostVerification", mPass, null);
                        return;
                    }
                    Context context = homeScreenMainFragment.getContext();
                    MPass mPass2 = ConfirmMagicPassActivity.v;
                    Intent N0 = hj1.N0(context, ConfirmMagicPassActivity.class, "src", "home screen bottomsheet");
                    ConfirmMagicPassActivity.x = "home screen bottomsheet";
                    ConfirmMagicPassActivity.v = null;
                    N0.putExtra("magic_pass_info", ov.f(mPass));
                    context.startActivity(N0);
                }
            } else if (h2.getInactiveReason() == null) {
                homeScreenMainFragment.getString(R.string.recent_products_disabled_dialog_copy);
            }
        }
    }
}
