package defpackage;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import app.zophop.ui.fragments.UserDetailsFragment;

/* renamed from: ax0  reason: default package */
/* compiled from: UserDetailsFragment */
public class ax0 implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserDetailsFragment f343a;

    public ax0(UserDetailsFragment userDetailsFragment) {
        this.f343a = userDetailsFragment;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        jz5.b().g(new ed1("dob change event", Long.MIN_VALUE));
        String K = vn.K(i, i2, i3, "dd/MM/yyyy");
        this.f343a.j = vn.K(i, i2, i3, "dd MMM yyyy");
        this.f343a._dateOfBirthView.setTag(K);
        UserDetailsFragment userDetailsFragment = this.f343a;
        userDetailsFragment._dateOfBirthView.setText(userDetailsFragment.j);
        this.f343a.h();
    }
}
