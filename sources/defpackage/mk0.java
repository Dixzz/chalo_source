package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import defpackage.k90;
import defpackage.l00;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mk0  reason: default package */
/* compiled from: StopPickerAdapter */
public class mk0 extends yf1<Stop> {
    public final TransitMode j;
    public List<Stop> k;
    public final k90 l;
    public k90.a m;

    public mk0(Context context, TransitMode transitMode, List<Stop> list, k90 k90) {
        super(context);
        this.j = transitMode;
        if (list != null) {
            this.k = list;
        } else {
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.A().c != null) {
                this.k = new ArrayList(t1Var.A().g(transitMode).values());
            }
        }
        this.l = k90;
    }

    public static int b(TransitMode transitMode) {
        int ordinal = transitMode.ordinal();
        if (ordinal == 0) {
            return R.drawable.train_search;
        }
        if (ordinal == 1) {
            return R.drawable.bus_search;
        }
        if (ordinal == 2) {
            return R.drawable.metro_search;
        }
        if (ordinal == 3) {
            return R.drawable.monorail_search;
        }
        if (ordinal != 5) {
            return 0;
        }
        return R.drawable.ferry_search;
    }

    public static rg1 c(View view, Stop stop, Context context, TransitMode transitMode, String str) {
        rg1 rg1;
        if (view == null) {
            rg1 = new rg1(context);
        } else {
            rg1 = (rg1) view;
        }
        CharSequence j2 = vn.j(stop.getName(), str, context.getResources().getColor(R.color.view_schedule_color), false);
        if (transitMode.equals(TransitMode.ALL)) {
            rg1.a(j2, null, b(stop.getMode()));
        } else {
            rg1.a(j2, null, b(transitMode));
        }
        rg1.findViewById(R.id.bus_agency_name).setVisibility(8);
        return rg1;
    }

    @Override // defpackage.yf1
    public List<Stop> a(String str) {
        List<Stop> list;
        if (this.k != null) {
            list = xt.f3961a.b().b(str, this.k);
        } else {
            xt.t1 t1Var = xt.f3961a;
            l00 b = t1Var.b();
            TransitMode transitMode = this.j;
            if (!b.f2144a.l()) {
                mi1 mi1 = new mi1(transitMode);
                try {
                    list = mi1.b(mi1.a(mi1.c(str)));
                } catch (Exception unused) {
                    list = new ArrayList<>();
                }
            } else {
                list = new k30().a(str, new ArrayList(t1Var.A().g(transitMode).values()), new l00.a(b));
            }
        }
        if (list.isEmpty()) {
            this.m = k90.a.NO_MATCH_FOUND;
        }
        return list;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return c(view, this.g.get(i), this.f, this.j, this.i);
    }

    public void notifyDataSetChanged() {
        k90.a aVar;
        super.notifyDataSetChanged();
        if (getCount() == 0 && (aVar = this.m) != null) {
            ((de0) this.l).f825a.q0(aVar);
        }
    }
}
