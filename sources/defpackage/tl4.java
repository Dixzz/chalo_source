package defpackage;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.SingleDateSelector;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Date;

/* renamed from: tl4  reason: default package */
/* compiled from: DateFormatTextWatcher */
public abstract class tl4 extends ln4 {
    public final TextInputLayout f;
    public final DateFormat g;
    public final CalendarConstraints h;
    public final String i;
    public final Runnable j;
    public Runnable k;

    /* renamed from: tl4$a */
    /* compiled from: DateFormatTextWatcher */
    public class a implements Runnable {
        public final /* synthetic */ String f;

        public a(String str) {
            this.f = str;
        }

        public void run() {
            tl4 tl4 = tl4.this;
            TextInputLayout textInputLayout = tl4.f;
            DateFormat dateFormat = tl4.g;
            Context context = textInputLayout.getContext();
            String string = context.getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.f);
            String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(pm4.f().getTimeInMillis())));
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            ((SingleDateSelector.a) tl4.this).l.a();
        }
    }

    public tl4(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.g = dateFormat;
        this.f = textInputLayout;
        this.h = calendarConstraints;
        this.i = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.j = new a(str);
    }

    public abstract void a(Long l);

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a A[Catch:{ ParseException -> 0x0073 }] */
    @Override // defpackage.ln4
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r7, int r8, int r9, int r10) {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tl4.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
