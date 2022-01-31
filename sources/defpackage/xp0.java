package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: xp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xp0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ HomeScreenMainFragment g;
    public final /* synthetic */ SuperPassApplication h;

    public /* synthetic */ xp0(du0 du0, HomeScreenMainFragment homeScreenMainFragment, SuperPassApplication superPassApplication) {
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
        du0.f = true;
        du0.dismiss();
        ui1.m0(new ed1("pass status prompt positive button click", Long.MIN_VALUE));
        BookableSuperPassConfiguration a2 = t60.a(superPassApplication);
        Context context = homeScreenMainFragment.getContext();
        if (context != null) {
            if (a2 == null) {
                w76<String, String, s56> m = homeScreenMainFragment.m();
                String string = context.getResources().getString(R.string.recent_products_disabled_dialog_copy);
                n86.d(string, "lContext.resources.getSt…cts_disabled_dialog_copy)");
                m.invoke(string, "Home screen pass status prompt");
            } else if (superPassApplication.getVerificationExpiryTime() == -1 || superPassApplication.getVerificationExpiryTime() - (((long) a2.getSelectedProductFareMapping().getNoOfDays()) * 86400000) >= 1) {
                SuperPassPurchaseActivity.s0(context, "Home Screen", a2, superPassApplication);
            } else {
                w76<String, String, s56> m2 = homeScreenMainFragment.m();
                String string2 = context.getResources().getString(R.string.validity_expired_desc_recent_products);
                n86.d(string2, "lContext.resources.getSt…red_desc_recent_products)");
                m2.invoke(string2, "Home screen pass status prompt");
            }
        }
        homeScreenMainFragment.o().f().g(String.valueOf(superPassApplication.getPassStartDate()), true);
    }
}
