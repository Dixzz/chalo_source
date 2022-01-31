package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.razorpay.AnalyticsConstants;

/* renamed from: s51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class s51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f;

    public /* synthetic */ s51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f = superPassUserProofsOverviewFragment;
    }

    public final void onClick(View view) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        ed1 ed1 = new ed1("userProofsOverview next clicked", Long.MIN_VALUE);
        ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
        superPassUserProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        ga1 ga1 = superPassUserProofsOverviewFragment.g;
        if (ga1 != null) {
            if (!ga1.k) {
                String str = ga1.l;
                if (!(str == null || str.length() == 0)) {
                    SuperPassPurchaseSharedViewModel j = superPassUserProofsOverviewFragment.j();
                    ga1 ga12 = superPassUserProofsOverviewFragment.g;
                    if (ga12 != null) {
                        String str2 = ga12.l;
                        if (str2 != null) {
                            j.k.setFullName(str2);
                        }
                        j.c.b("keySuperPassUserDetails", j.k);
                    } else {
                        n86.l("viewModel");
                        throw null;
                    }
                }
            }
            si siVar = new si(R.id.action_userProofsOverviewFragment_to_confirmSuperPassPurchaseFragment);
            n86.d(siVar, "actionUserProofsOverview…perPassPurchaseFragment()");
            vh1 vh1 = vh1.f3649a;
            n86.f(superPassUserProofsOverviewFragment, "$this$findNavController");
            NavController d = NavHostFragment.d(superPassUserProofsOverviewFragment);
            n86.b(d, "NavHostFragment.findNavController(this)");
            vh1.a(d, siVar);
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
