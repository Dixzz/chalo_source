package defpackage;

import android.app.DatePickerDialog;
import android.view.View;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.ui.activities.RenewMagicPassActivity;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/* renamed from: hf0  reason: default package */
/* compiled from: RenewMagicPassActivity */
public class hf0 implements View.OnClickListener {
    public final /* synthetic */ ra1 f;
    public final /* synthetic */ RenewMagicPassActivity g;

    public hf0(RenewMagicPassActivity renewMagicPassActivity, ra1 ra1) {
        this.g = renewMagicPassActivity;
        this.f = ra1;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("renew date change", Long.MIN_VALUE));
        RenewMagicPassActivity renewMagicPassActivity = this.g;
        ra1 ra1 = this.f;
        List<ProductFareMapping> list = RenewMagicPassActivity.v;
        Objects.requireNonNull(renewMagicPassActivity);
        DatePickerDialog datePickerDialog = new DatePickerDialog(renewMagicPassActivity, new if0(renewMagicPassActivity, ra1), renewMagicPassActivity.o.get(1), renewMagicPassActivity.o.get(2), renewMagicPassActivity.o.get(5));
        System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(ui1.Q());
        instance.add(2, 3);
        datePickerDialog.getDatePicker().setMinDate(this.g.s);
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
        datePickerDialog.show();
    }
}
