package defpackage;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.fragments.UserDetailsFragment;
import app.zophop.ui.views.PassDurationFormInput;
import java.util.Calendar;

/* renamed from: fx0  reason: default package */
/* compiled from: UserDetailsFragment */
public class fx0 implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PassDurationFormInput f1180a;
    public final /* synthetic */ ra1 b;
    public final /* synthetic */ UserDetailsFragment c;

    public fx0(UserDetailsFragment userDetailsFragment, PassDurationFormInput passDurationFormInput, ra1 ra1) {
        this.c = userDetailsFragment;
        this.f1180a = passDurationFormInput;
        this.b = ra1;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        ed1 ed1 = new ed1("date change event", Long.MIN_VALUE);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(ui1.Q());
        instance.set(i, i2, i3);
        this.c.F.set(i, i2, i3);
        ed1.a("date", Long.valueOf(this.c.F.getTimeInMillis()));
        ed1.a("current date", Long.valueOf(System.currentTimeMillis()));
        jz5.b().g(ed1);
        if (this.c.H.after(instance)) {
            Toast.makeText(this.c.getActivity(), this.c.getString(R.string.pass_validate_date), 1).show();
            return;
        }
        this.f1180a.setText(jh1.d(this.c.F.getTimeInMillis()));
        this.b.setPassDate(jh1.d(this.c.F.getTimeInMillis()));
        this.c.G.set(i, i2, i3);
    }
}
