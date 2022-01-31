package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.Month;

/* renamed from: wl4  reason: default package */
/* compiled from: MaterialCalendar */
public final class wl4<S> extends mm4<S> {
    public static final /* synthetic */ int q = 0;
    public int g;
    public DateSelector<S> h;
    public CalendarConstraints i;
    public Month j;
    public e k;
    public sl4 l;
    public RecyclerView m;
    public RecyclerView n;
    public View o;
    public View p;

    /* renamed from: wl4$a */
    /* compiled from: MaterialCalendar */
    public class a implements Runnable {
        public final /* synthetic */ int f;

        public a(int i) {
            this.f = i;
        }

        public void run() {
            wl4.this.n.l0(this.f);
        }
    }

    /* renamed from: wl4$b */
    /* compiled from: MaterialCalendar */
    public class b extends z7 {
        public b(wl4 wl4) {
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            e9Var.m(null);
        }
    }

    /* renamed from: wl4$c */
    /* compiled from: MaterialCalendar */
    public class c extends nm4 {
        public final /* synthetic */ int M;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.M = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void l1(RecyclerView.x xVar, int[] iArr) {
            if (this.M == 0) {
                iArr[0] = wl4.this.n.getWidth();
                iArr[1] = wl4.this.n.getWidth();
                return;
            }
            iArr[0] = wl4.this.n.getHeight();
            iArr[1] = wl4.this.n.getHeight();
        }
    }

    /* renamed from: wl4$d */
    /* compiled from: MaterialCalendar */
    public class d implements f {
        public d() {
        }
    }

    /* renamed from: wl4$e */
    /* compiled from: MaterialCalendar */
    public enum e {
        DAY,
        YEAR
    }

    /* renamed from: wl4$f */
    /* compiled from: MaterialCalendar */
    public interface f {
    }

    @Override // defpackage.mm4
    public boolean d(lm4<S> lm4) {
        return this.f.add(lm4);
    }

    public LinearLayoutManager e() {
        return (LinearLayoutManager) this.n.getLayoutManager();
    }

    public final void f(int i2) {
        this.n.post(new a(i2));
    }

    public void g(Month month) {
        km4 km4 = (km4) this.n.getAdapter();
        int m2 = km4.b.f.m(month);
        int d2 = m2 - km4.d(this.j);
        boolean z = true;
        boolean z2 = Math.abs(d2) > 3;
        if (d2 <= 0) {
            z = false;
        }
        this.j = month;
        if (z2 && z) {
            this.n.i0(m2 - 3);
            f(m2);
        } else if (z2) {
            this.n.i0(m2 + 3);
            f(m2);
        } else {
            f(m2);
        }
    }

    public void h(e eVar) {
        this.k = eVar;
        if (eVar == e.YEAR) {
            this.m.getLayoutManager().Y0(((rm4) this.m.getAdapter()).c(this.j.h));
            this.o.setVisibility(0);
            this.p.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.o.setVisibility(8);
            this.p.setVisibility(0);
            g(this.j);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.g = bundle.getInt("THEME_RES_ID_KEY");
        this.h = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.j = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.g);
        this.l = new sl4(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.i.f;
        if (em4.f(contextThemeWrapper)) {
            i3 = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        r8.v(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new vl4());
        gridView.setNumColumns(month.i);
        gridView.setEnabled(false);
        this.n = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.n.setLayoutManager(new c(getContext(), i2, false, i2));
        this.n.setTag("MONTHS_VIEW_GROUP_TAG");
        km4 km4 = new km4(contextThemeWrapper, this.h, this.i, new d());
        this.n.setAdapter(km4);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        int i4 = R.id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(i4);
        this.m = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.m.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.m.setAdapter(new rm4(this));
            this.m.f(new xl4(this));
        }
        int i5 = R.id.month_navigation_fragment_toggle;
        if (inflate.findViewById(i5) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(i5);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            r8.v(materialButton, new yl4(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.o = inflate.findViewById(i4);
            this.p = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            h(e.DAY);
            materialButton.setText(this.j.j(inflate.getContext()));
            this.n.g(new zl4(this, km4, materialButton));
            materialButton.setOnClickListener(new am4(this));
            materialButton3.setOnClickListener(new bm4(this, km4));
            materialButton2.setOnClickListener(new cm4(this, km4));
        }
        if (!em4.f(contextThemeWrapper)) {
            new wk().a(this.n);
        }
        this.n.i0(km4.d(this.j));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.g);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.h);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.i);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.j);
    }
}
