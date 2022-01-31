package defpackage;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import app.zophop.ui.fragments.ProfileFragment;

/* renamed from: tv0  reason: default package */
/* compiled from: ProfileFragment */
public class tv0 implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileFragment f3410a;

    public tv0(ProfileFragment profileFragment) {
        this.f3410a = profileFragment;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f3410a.k = vn.K(i, i2, i3, "dd/MM/yyyy");
        ProfileFragment profileFragment = this.f3410a;
        profileFragment._dateOfBirthView.setText(profileFragment.k);
        this.f3410a.m();
    }
}
