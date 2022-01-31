package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.fragments.BasicUserDetailsFragment;
import app.zophop.ui.utils.DatePickerUtils;

/* renamed from: yn0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yn0 implements View.OnClickListener {
    public final /* synthetic */ BasicUserDetailsFragment f;

    public /* synthetic */ yn0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f = basicUserDetailsFragment;
    }

    public final void onClick(View view) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        basicUserDetailsFragment.k();
        long Q = ui1.Q() - 86400000;
        long a2 = DatePickerUtils.a(Q, 30);
        String string = basicUserDetailsFragment.getString(R.string.select_pass_start_date);
        n86.d(string, "getString(R.string.select_pass_start_date)");
        em4<Long> b = DatePickerUtils.b(string, ui1.Q(), Q, a2);
        b.f.add(new zn0(b, basicUserDetailsFragment));
        ve activity = basicUserDetailsFragment.c();
        if (activity != null) {
            b.show(activity.getSupportFragmentManager(), "tagCalenderPassStartDateSelection");
        }
    }
}
