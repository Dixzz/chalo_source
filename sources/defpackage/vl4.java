package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: vl4  reason: default package */
/* compiled from: DaysOfWeekAdapter */
public class vl4 extends BaseAdapter {
    public static final int i = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);
    public final Calendar f;
    public final int g;
    public final int h;

    public vl4() {
        Calendar g2 = pm4.g();
        this.f = g2;
        this.g = g2.getMaximum(7);
        this.h = g2.getFirstDayOfWeek();
    }

    public int getCount() {
        return this.g;
    }

    public Object getItem(int i2) {
        int i3 = this.g;
        if (i2 >= i3) {
            return null;
        }
        int i4 = i2 + this.h;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    public long getItemId(int i2) {
        return 0;
    }

    @SuppressLint({"WrongConstant"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f;
        int i3 = i2 + this.h;
        int i4 = this.g;
        if (i3 > i4) {
            i3 -= i4;
        }
        calendar.set(7, i3);
        textView.setText(this.f.getDisplayName(7, i, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
