package defpackage;

import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: im4  reason: default package */
/* compiled from: MonthAdapter */
public class im4 extends BaseAdapter {
    public static final int k = pm4.g().getMaximum(4);
    public final Month f;
    public final DateSelector<?> g;
    public Collection<Long> h;
    public sl4 i;
    public final CalendarConstraints j;

    public im4(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f = month;
        this.g = dateSelector;
        this.j = calendarConstraints;
        this.h = dateSelector.K0();
    }

    public int a(int i2) {
        return b() + (i2 - 1);
    }

    public int b() {
        return this.f.h();
    }

    /* renamed from: c */
    public Long getItem(int i2) {
        if (i2 < this.f.h() || i2 > d()) {
            return null;
        }
        Month month = this.f;
        return Long.valueOf(month.i((i2 - month.h()) + 1));
    }

    public int d() {
        return (this.f.h() + this.f.j) - 1;
    }

    public final void e(TextView textView, long j2) {
        rl4 rl4;
        if (textView != null) {
            boolean z = false;
            if (this.j.h.B0(j2)) {
                textView.setEnabled(true);
                Iterator<Long> it = this.g.K0().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (pm4.a(j2) == pm4.a(it.next().longValue())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    rl4 = this.i.b;
                } else if (pm4.f().getTimeInMillis() == j2) {
                    rl4 = this.i.c;
                } else {
                    rl4 = this.i.f3224a;
                }
            } else {
                textView.setEnabled(false);
                rl4 = this.i.g;
            }
            rl4.b(textView);
        }
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.f(j2).equals(this.f)) {
            Calendar d = pm4.d(this.f.f);
            d.setTimeInMillis(j2);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(d.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    public int getCount() {
        return b() + this.f.j;
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.f.i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.im4.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public boolean hasStableIds() {
        return true;
    }
}
