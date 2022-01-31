package defpackage;

import android.util.Pair;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.ui.fragments.BasicUserDetailsFragment;
import com.razorpay.AnalyticsConstants;
import defpackage.ut;
import defpackage.xt;
import org.json.JSONObject;

/* renamed from: co0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class co0 implements View.OnClickListener {
    public final /* synthetic */ BasicUserDetailsFragment f;

    public /* synthetic */ co0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f = basicUserDetailsFragment;
    }

    public final void onClick(View view) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        a81 j = basicUserDetailsFragment.j();
        p81 i2 = basicUserDetailsFragment.i();
        n86.e(i2, "viewModel");
        Pair<String, String> y = ui1.y(j.e);
        BasicProfileFields build = new BasicProfileFields.Builder().withFirstName((String) y.first).withLastName((String) y.second).withGender(j.h().d()).withDateOfBirth(String.valueOf(j.f().d())).build();
        n86.d(build, "lBasicProfileFields");
        n86.e(build, "lBasicProfileFields");
        UserProfile d = i2.g().d();
        if (d != null) {
            d.setUserDetails(build);
            i2.c.b("keyUserProfile", d);
        }
        MPass mPass = i2.g;
        Long d2 = j.g().d();
        n86.c(d2);
        n86.d(d2, "passStartDate.value!!");
        mPass.setStartingTime(d2.longValue());
        xt.t1 t1Var = xt.f3961a;
        String f2 = t1Var.t().f("shouldEnableSafetyGuidelinesHook");
        ut.a aVar = ut.f3552a;
        if (f2 != null) {
            String C = hj1.C(t1Var);
            try {
                JSONObject jSONObject = new JSONObject(f2);
                if (jSONObject.has("cityNamesForGuidelinesHook")) {
                    t1Var.l().put("guidelines_hook_url", jSONObject.getJSONObject("cityNamesForGuidelinesHook").optString(C, "disabled"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ed1 ed1 = new ed1("basic user details next clicked", Long.MIN_VALUE);
        ed1.a("fullName", basicUserDetailsFragment.j().e);
        ed1.a(SuperPassJsonKeys.DATE_OF_BIRTH, ui1.w(basicUserDetailsFragment.j().f().d()));
        Gender d3 = basicUserDetailsFragment.j().h().d();
        ed1.a(SuperPassJsonKeys.GENDER, d3 == null ? null : d3.name());
        ed1.a(SuperPassJsonKeys.PASS_START_DATE, jh1.e(basicUserDetailsFragment.j().g().d()));
        ed1.a("source", "basicUserDetailsFragment");
        ed1.a(AnalyticsConstants.FLOW, basicUserDetailsFragment.i().f);
        ui1.m0(ed1);
        si siVar = new si(R.id.action_basicUserDetailsFragment_to_userProofsOverviewFragment);
        n86.d(siVar, "actionBasicUserDetailsFr…rProofsOverviewFragment()");
        vh1 vh1 = vh1.f3649a;
        n86.f(basicUserDetailsFragment, "$this$findNavController");
        NavController d4 = NavHostFragment.d(basicUserDetailsFragment);
        n86.b(d4, "NavHostFragment.findNavController(this)");
        vh1.a(d4, siVar);
    }
}
