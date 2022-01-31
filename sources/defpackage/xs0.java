package defpackage;

import android.util.Pair;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.ui.fragments.UserProofsOverviewFragment;
import com.razorpay.AnalyticsConstants;

/* renamed from: xs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xs0 implements View.OnClickListener {
    public final /* synthetic */ UserProofsOverviewFragment f;

    public /* synthetic */ xs0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f = userProofsOverviewFragment;
    }

    public final void onClick(View view) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        ed1 ed1 = new ed1("userProofsOverview next clicked", Long.MIN_VALUE);
        ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
        userProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        g91 g91 = userProofsOverviewFragment.g;
        if (g91 != null) {
            if (!g91.k) {
                String str = g91.l;
                if (!(str == null || str.length() == 0)) {
                    g91 g912 = userProofsOverviewFragment.g;
                    if (g912 != null) {
                        Pair<String, String> y = ui1.y(g912.l);
                        p81 j = userProofsOverviewFragment.j();
                        String str2 = (String) y.first;
                        String str3 = (String) y.second;
                        UserProfile d = j.g().d();
                        if (d != null) {
                            d.updateUserName(str2, str3);
                            j.c.b("keyUserProfile", d);
                        }
                    } else {
                        n86.l("viewModel");
                        throw null;
                    }
                }
            }
            userProofsOverviewFragment.j().g.setDisplayProps(userProofsOverviewFragment.j().f());
            si siVar = new si(R.id.action_userProofsOverviewFragment_to_confirmMPassPurchaseFragment);
            n86.d(siVar, "actionUserProofsOverview…rmMPassPurchaseFragment()");
            vh1 vh1 = vh1.f3649a;
            n86.f(userProofsOverviewFragment, "$this$findNavController");
            NavController d2 = NavHostFragment.d(userProofsOverviewFragment);
            n86.b(d2, "NavHostFragment.findNavController(this)");
            vh1.a(d2, siVar);
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
