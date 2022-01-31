package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;
import defpackage.wl4;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: km4  reason: default package */
/* compiled from: MonthsPagerAdapter */
public class km4 extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2079a;
    public final CalendarConstraints b;
    public final DateSelector<?> c;
    public final wl4.f d;
    public final int e;

    /* renamed from: km4$a */
    /* compiled from: MonthsPagerAdapter */
    public static class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f2080a;
        public final MaterialCalendarGridView b;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f2080a = textView;
            AtomicInteger atomicInteger = r8.f3055a;
            new v8(androidx.core.R.id.tag_accessibility_heading, Boolean.class, 28).e(textView, Boolean.TRUE);
            this.b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    public km4(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, wl4.f fVar) {
        Month month = calendarConstraints.f;
        Month month2 = calendarConstraints.g;
        Month month3 = calendarConstraints.i;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (month3.compareTo(month2) <= 0) {
            int i = im4.k;
            int i2 = wl4.q;
            Resources resources = context.getResources();
            int i3 = R.dimen.mtrl_calendar_day_height;
            int dimensionPixelSize = i * resources.getDimensionPixelSize(i3);
            int dimensionPixelSize2 = em4.f(context) ? context.getResources().getDimensionPixelSize(i3) : 0;
            this.f2079a = context;
            this.e = dimensionPixelSize + dimensionPixelSize2;
            this.b = calendarConstraints;
            this.c = dateSelector;
            this.d = fVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public Month c(int i) {
        return this.b.f.l(i);
    }

    public int d(Month month) {
        return this.b.f.m(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.b.k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long getItemId(int i) {
        return this.b.f.l(i).f.getTimeInMillis();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        Month l = this.b.f.l(i);
        aVar2.f2080a.setText(l.j(aVar2.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar2.b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !l.equals(materialCalendarGridView.getAdapter().f)) {
            im4 im4 = new im4(l, this.c, this.b);
            materialCalendarGridView.setNumColumns(l.i);
            materialCalendarGridView.setAdapter((ListAdapter) im4);
        } else {
            materialCalendarGridView.invalidate();
            im4 a2 = materialCalendarGridView.getAdapter();
            for (Long l2 : a2.h) {
                a2.f(materialCalendarGridView, l2.longValue());
            }
            DateSelector<?> dateSelector = a2.g;
            if (dateSelector != null) {
                for (Long l3 : dateSelector.K0()) {
                    a2.f(materialCalendarGridView, l3.longValue());
                }
                a2.h = a2.g.K0();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new jm4(this, materialCalendarGridView));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!em4.f(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.n(-1, this.e));
        return new a(linearLayout, true);
    }
}
