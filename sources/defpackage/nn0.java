package defpackage;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import app.zophop.R;
import j$.util.DesugarTimeZone;
import java.util.Calendar;

/* renamed from: nn0  reason: default package */
/* compiled from: TimePickerFragment */
public class nn0 extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: nn0$a */
    /* compiled from: TimePickerFragment */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2577a;
        public int b;

        public a(nn0 nn0) {
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("gmt"));
        instance.setTimeInMillis(currentTimeMillis + 19800000);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), this, instance.get(11), instance.get(12), false);
        timePickerDialog.setButton(-1, getString(R.string.ok), timePickerDialog);
        timePickerDialog.setButton(-2, getString(R.string.cancel).toUpperCase(), timePickerDialog);
        return timePickerDialog;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        a aVar = new a(this);
        aVar.f2577a = i;
        aVar.b = i2;
        jz5.b().i(aVar);
    }
}
