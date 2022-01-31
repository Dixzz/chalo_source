package defpackage;

import android.app.DatePickerDialog;
import android.view.View;
import app.zophop.ui.fragments.UserDetailsFragment;

/* renamed from: bx0  reason: default package */
/* compiled from: UserDetailsFragment */
public class bx0 implements View.OnClickListener {
    public final /* synthetic */ DatePickerDialog f;

    public bx0(UserDetailsFragment userDetailsFragment, DatePickerDialog datePickerDialog) {
        this.f = datePickerDialog;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("dob changed", Long.MIN_VALUE);
        ed1.a("date", Long.valueOf(ui1.Q()));
        jz5.b().g(ed1);
        this.f.getDatePicker().setMaxDate(System.currentTimeMillis());
        this.f.show();
    }
}
