package defpackage;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: cr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class cr0 implements om0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f746a;
    public final /* synthetic */ SuperPassApplication b;

    public /* synthetic */ cr0(HomeScreenMainFragment homeScreenMainFragment, SuperPassApplication superPassApplication) {
        this.f746a = homeScreenMainFragment;
        this.b = superPassApplication;
    }

    @Override // defpackage.om0
    public final void a() {
        HomeScreenMainFragment homeScreenMainFragment = this.f746a;
        SuperPassApplication superPassApplication = this.b;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(superPassApplication, "$lSuperPassApplication");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        String string = homeScreenMainFragment.getString(R.string.verification_successful);
        String string2 = homeScreenMainFragment.getString(R.string.document_verification_successful);
        String string3 = homeScreenMainFragment.getString(R.string.pay_now);
        String string4 = homeScreenMainFragment.getString(R.string.later_caps);
        HomeActivity.a aVar2 = HomeActivity.k;
        n86.e(parentFragmentManager, "manager");
        du0 du0 = new du0();
        new qn0().g = "Home Screen";
        Bundle bundle = new Bundle();
        if (string != null) {
            bundle.putString("extra:title_copy", string);
        }
        if (string2 != null) {
            bundle.putString("extra:message_copy", string2);
        }
        if (string3 != null) {
            bundle.putString("extra:positive_action_copy", string3);
        }
        if (string4 != null) {
            bundle.putString("extra:negative_action_copy", string4);
        }
        bundle.putInt("extra:alignment_id", 1);
        bundle.putInt("extra:drawable_id", R.drawable.pass_success);
        du0.setArguments(bundle);
        du0.show(parentFragmentManager, "confirmation_bottomsheet");
        du0.setCancelable(false);
        du0.e(new xp0(du0, homeScreenMainFragment, superPassApplication));
        du0.d(new qq0(du0, homeScreenMainFragment, superPassApplication));
    }
}
