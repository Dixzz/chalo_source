package defpackage;

import android.view.View;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.Month;
import defpackage.wl4;

/* renamed from: qm4  reason: default package */
/* compiled from: YearGridAdapter */
public class qm4 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ rm4 g;

    public qm4(rm4 rm4, int i) {
        this.g = rm4;
        this.f = i;
    }

    public void onClick(View view) {
        Month c = Month.c(this.f, this.g.f3100a.j.g);
        CalendarConstraints calendarConstraints = this.g.f3100a.i;
        if (c.compareTo(calendarConstraints.f) < 0) {
            c = calendarConstraints.f;
        } else if (c.compareTo(calendarConstraints.g) > 0) {
            c = calendarConstraints.g;
        }
        this.g.f3100a.g(c);
        this.g.f3100a.h(wl4.e.DAY);
    }
}
