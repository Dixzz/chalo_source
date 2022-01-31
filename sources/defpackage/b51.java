package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;
import app.zophop.ui.utils.DatePickerUtils;

/* renamed from: b51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class b51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f;

    public /* synthetic */ b51(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f = superPassBasicUserDetailsFragment;
    }

    public final void onClick(View view) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        superPassBasicUserDetailsFragment.k();
        long Q = ui1.Q() - 86400000;
        long a2 = DatePickerUtils.a(Q, 30);
        String string = superPassBasicUserDetailsFragment.getString(R.string.select_pass_start_date);
        n86.d(string, "getString(R.string.select_pass_start_date)");
        em4<Long> b = DatePickerUtils.b(string, ui1.Q(), Q, a2);
        b.f.add(new a51(b, superPassBasicUserDetailsFragment));
        ve activity = superPassBasicUserDetailsFragment.c();
        if (activity != null) {
            b.show(activity.getSupportFragmentManager(), "tagCalenderPassStartDateSelection");
        }
    }
}
