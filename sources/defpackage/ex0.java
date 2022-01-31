package defpackage;

import android.app.DatePickerDialog;
import android.view.View;
import app.zophop.ui.fragments.UserDetailsFragment;
import app.zophop.ui.views.PassDurationFormInput;
import java.util.Calendar;
import java.util.Objects;

/* renamed from: ex0  reason: default package */
/* compiled from: UserDetailsFragment */
public class ex0 implements View.OnClickListener {
    public final /* synthetic */ ra1 f;
    public final /* synthetic */ PassDurationFormInput g;
    public final /* synthetic */ UserDetailsFragment h;

    public ex0(UserDetailsFragment userDetailsFragment, ra1 ra1, PassDurationFormInput passDurationFormInput) {
        this.h = userDetailsFragment;
        this.f = ra1;
        this.g = passDurationFormInput;
    }

    public void onClick(View view) {
        UserDetailsFragment userDetailsFragment = this.h;
        ra1 ra1 = this.f;
        PassDurationFormInput passDurationFormInput = this.g;
        int i = UserDetailsFragment.Y;
        Objects.requireNonNull(userDetailsFragment);
        DatePickerDialog datePickerDialog = new DatePickerDialog(userDetailsFragment.getActivity(), new fx0(userDetailsFragment, passDurationFormInput, ra1), userDetailsFragment.G.get(1), userDetailsFragment.G.get(2), userDetailsFragment.G.get(5));
        long Q = ui1.Q();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(Q);
        instance.add(5, 30);
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
        datePickerDialog.getDatePicker().setMinDate(Q - 1000);
        datePickerDialog.show();
    }
}
