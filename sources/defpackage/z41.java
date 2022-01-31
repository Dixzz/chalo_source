package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;
import app.zophop.ui.utils.DatePickerUtils;

/* renamed from: z41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class z41 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f;

    public /* synthetic */ z41(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f = superPassBasicUserDetailsFragment;
    }

    public final void onClick(View view) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        superPassBasicUserDetailsFragment.k();
        long Q = ui1.Q();
        String string = superPassBasicUserDetailsFragment.getString(R.string.select_dob);
        n86.d(string, "getString(R.string.select_dob)");
        em4<Long> b = DatePickerUtils.b(string, Q, ui1.Q() - 3153600000000L, Q);
        b.f.add(new c51(b, superPassBasicUserDetailsFragment));
        ve activity = superPassBasicUserDetailsFragment.c();
        if (activity != null) {
            b.show(activity.getSupportFragmentManager(), "tagCalenderDobSelection");
        }
    }
}
