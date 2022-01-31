package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: aq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class aq0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ HomeScreenMainFragment g;
    public final /* synthetic */ SuperPassApplication h;

    public /* synthetic */ aq0(du0 du0, HomeScreenMainFragment homeScreenMainFragment, SuperPassApplication superPassApplication) {
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
        homeScreenMainFragment.o().f().g(String.valueOf(superPassApplication.getPassStartDate()), true);
        Context context = homeScreenMainFragment.getContext();
        if (context != null) {
            BookableSuperPassConfiguration a2 = t60.a(superPassApplication);
            if (a2 == null || !a2.isBookablePassConfigActive()) {
                w76<String, String, s56> m = homeScreenMainFragment.m();
                String string = context.getResources().getString(R.string.recent_products_disabled_dialog_copy);
                n86.d(string, "lContext.resources.getSt…cts_disabled_dialog_copy)");
                m.invoke(string, "Home screen pass status prompt");
                return;
            }
            SuperPassPurchaseActivity.t0(context, "Home screen pass status prompt", a2, superPassApplication);
        }
    }
}
