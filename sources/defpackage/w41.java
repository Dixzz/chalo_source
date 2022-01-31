package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.razorpay.AnalyticsConstants;

/* renamed from: w41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class w41 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f;

    public /* synthetic */ w41(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f = superPassBasicUserDetailsFragment;
    }

    public final void onClick(View view) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        da1 j = superPassBasicUserDetailsFragment.j();
        SuperPassPurchaseSharedViewModel i2 = superPassBasicUserDetailsFragment.i();
        n86.e(i2, "viewModel");
        String str = j.e;
        Gender d = j.h().d();
        String valueOf = String.valueOf(j.f().d());
        n86.e(valueOf, "lDateOfBirth");
        SuperPassUserDetails superPassUserDetails = i2.k;
        if (str == null) {
            str = new String();
        }
        superPassUserDetails.setFullName(str);
        SuperPassUserDetails superPassUserDetails2 = i2.k;
        if (d == null) {
            d = Gender.MALE;
        }
        superPassUserDetails2.setGender(d);
        i2.k.setDateOfBirth(valueOf);
        i2.c.b("keySuperPassUserDetails", i2.k);
        Long d2 = j.g().d();
        n86.c(d2);
        n86.d(d2, "passStartDate.value!!");
        long longValue = d2.longValue();
        i2.m = longValue;
        i2.c.b("keyStartTime", Long.valueOf(longValue));
        ed1 ed1 = new ed1("basic user details next clicked", Long.MIN_VALUE);
        ed1.a("fullName", superPassBasicUserDetailsFragment.j().e);
        ed1.a(SuperPassJsonKeys.DATE_OF_BIRTH, ui1.w(superPassBasicUserDetailsFragment.j().f().d()));
        Gender d3 = superPassBasicUserDetailsFragment.j().h().d();
        ed1.a(SuperPassJsonKeys.GENDER, d3 == null ? null : d3.name());
        ed1.a(SuperPassJsonKeys.PASS_START_DATE, jh1.e(superPassBasicUserDetailsFragment.j().g().d()));
        ed1.a("source", "basicUserDetailsFragment");
        ed1.a(AnalyticsConstants.FLOW, superPassBasicUserDetailsFragment.i().f);
        ed1.a("isSuperPass", Boolean.TRUE);
        ui1.m0(ed1);
        si siVar = new si(R.id.action_superPassBasicUserDetailsFragment_to_superPassUserProofsOverviewFragment);
        n86.d(siVar, "actionSuperPassBasicUser…rProofsOverviewFragment()");
        vh1 vh1 = vh1.f3649a;
        n86.f(superPassBasicUserDetailsFragment, "$this$findNavController");
        NavController d4 = NavHostFragment.d(superPassBasicUserDetailsFragment);
        n86.b(d4, "NavHostFragment.findNavController(this)");
        vh1.a(d4, siVar);
    }
}
