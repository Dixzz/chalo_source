package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.fragments.BasicUserDetailsFragment;
import app.zophop.ui.utils.DatePickerUtils;

/* renamed from: do0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class do0 implements View.OnClickListener {
    public final /* synthetic */ BasicUserDetailsFragment f;

    public /* synthetic */ do0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f = basicUserDetailsFragment;
    }

    public final void onClick(View view) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        basicUserDetailsFragment.k();
        long Q = ui1.Q();
        String string = basicUserDetailsFragment.getString(R.string.select_dob);
        n86.d(string, "getString(R.string.select_dob)");
        em4<Long> b = DatePickerUtils.b(string, Q, ui1.Q() - 3153600000000L, Q);
        b.f.add(new ao0(b, basicUserDetailsFragment));
        ve activity = basicUserDetailsFragment.c();
        if (activity != null) {
            b.show(activity.getSupportFragmentManager(), "tagCalenderDobSelection");
        }
    }
}
