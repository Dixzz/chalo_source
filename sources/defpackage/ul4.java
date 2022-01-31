package defpackage;

import android.os.Build;
import com.google.android.material.datepicker.SingleDateSelector;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ul4  reason: default package */
/* compiled from: DateFormatTextWatcher */
public class ul4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ tl4 g;

    public ul4(tl4 tl4, long j) {
        this.g = tl4;
        this.f = j;
    }

    public void run() {
        String str;
        tl4 tl4 = this.g;
        TextInputLayout textInputLayout = tl4.f;
        String str2 = tl4.i;
        Object[] objArr = new Object[1];
        long j = this.f;
        Calendar f2 = pm4.f();
        Calendar g2 = pm4.g();
        g2.setTimeInMillis(j);
        if (f2.get(1) == g2.get(1)) {
            Locale locale = Locale.getDefault();
            if (Build.VERSION.SDK_INT >= 24) {
                str = pm4.c("MMMd", locale).format(new Date(j));
            } else {
                AtomicReference<om4> atomicReference = pm4.f2830a;
                DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
                dateInstance.setTimeZone(pm4.e());
                SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
                String pattern = simpleDateFormat.toPattern();
                int b = pm4.b(pattern, "yY", 1, 0);
                if (b < pattern.length()) {
                    String str3 = "EMd";
                    int b2 = pm4.b(pattern, str3, 1, b);
                    if (b2 < pattern.length()) {
                        str3 = "EMd,";
                    }
                    pattern = pattern.replace(pattern.substring(pm4.b(pattern, str3, -1, b) + 1, b2), " ").trim();
                }
                simpleDateFormat.applyPattern(pattern);
                str = simpleDateFormat.format(new Date(j));
            }
        } else {
            str = hd3.v1(j);
        }
        objArr[0] = str;
        textInputLayout.setError(String.format(str2, objArr));
        ((SingleDateSelector.a) this.g).l.a();
    }
}
