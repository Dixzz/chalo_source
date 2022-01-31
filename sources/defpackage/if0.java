package defpackage;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.RenewMagicPassActivity;
import java.util.Calendar;

/* renamed from: if0  reason: default package */
/* compiled from: RenewMagicPassActivity */
public class if0 implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ra1 f1513a;
    public final /* synthetic */ RenewMagicPassActivity b;

    public if0(RenewMagicPassActivity renewMagicPassActivity, ra1 ra1) {
        this.b = renewMagicPassActivity;
        this.f1513a = ra1;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(ui1.Q());
        instance.set(i, i2, i3);
        this.b.p.set(i, i2, i3);
        if (this.b.q.after(instance)) {
            RenewMagicPassActivity renewMagicPassActivity = this.b;
            Toast.makeText(renewMagicPassActivity, renewMagicPassActivity.getString(R.string.pass_validate_date), 1).show();
            return;
        }
        RenewMagicPassActivity renewMagicPassActivity2 = this.b;
        renewMagicPassActivity2.r = renewMagicPassActivity2.p.getTimeInMillis();
        RenewMagicPassActivity renewMagicPassActivity3 = this.b;
        renewMagicPassActivity3.m.setStartingTime(renewMagicPassActivity3.p.getTimeInMillis());
        this.f1513a.setPassDate(jh1.d(this.b.p.getTimeInMillis()));
        this.b.o.set(i, i2, i3);
    }
}
