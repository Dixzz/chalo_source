package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.UniversalSearchItem;
import app.zophop.models.UniversalSearchViewItem;
import app.zophop.ui.activities.UniversalPickerActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: wk0  reason: default package */
/* compiled from: UniversalSearchAdapter */
public class wk0 extends BaseAdapter {
    public final Context f;
    public final z61 g;
    public String h;
    public final ci1<Object> i;
    public final boolean j = xt.f3961a.c().K();

    /* renamed from: wk0$a */
    /* compiled from: UniversalSearchAdapter */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            wk0.this.i.a(null);
        }
    }

    public wk0(Context context, ci1<Object> ci1) {
        this.f = context;
        this.i = ci1;
        this.g = new z61(context);
    }

    public static void e(String str, String str2, String str3) {
        ed1 l = hj1.l("universal item clicked", Long.MIN_VALUE, FirebaseAnalytics.Param.ORIGIN, str);
        l.a(FirebaseAnalytics.Param.DESTINATION, str2);
        UniversalPickerActivity.l0(l, "location trip", true, str3, str3 == null, false);
    }

    public static void g(Context context, TextView textView, String str) {
        String str2;
        String str3;
        int indexOf = str.indexOf(",");
        if (indexOf != -1) {
            str3 = str.substring(0, indexOf).trim();
            str2 = str.substring(indexOf + 1).trim();
        } else {
            str3 = str.trim();
            str2 = null;
        }
        SpannableStringBuilder f2 = hj1.f(str3);
        f2.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        if (str2 != null) {
            int length = f2.length();
            f2.append((CharSequence) ", ").append((CharSequence) str2);
            f2.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), length, f2.length(), 17);
            f2.setSpan(new AbsoluteSizeSpan(14, true), length, f2.length(), 17);
        }
        textView.setText(f2);
    }

    public void a() {
        this.g.a();
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public UniversalSearchViewItem getItem(int i2) {
        z61 z61 = this.g;
        Objects.requireNonNull(z61);
        UniversalSearchViewItem universalSearchViewItem = (UniversalSearchViewItem) new ArrayList(z61.f).get(i2);
        StringBuilder j0 = hj1.j0("list item at ", i2, " = ");
        j0.append(universalSearchViewItem.getType());
        j0.toString();
        return universalSearchViewItem;
    }

    public final View c(ViewGroup viewGroup, String str, UniversalSearchViewItem.Type type) {
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.pick_location_error_state, viewGroup, false);
        if (type.equals(UniversalSearchViewItem.Type.QUERY_FAILED)) {
            inflate = LayoutInflater.from(this.f).inflate(R.layout.loader_view, viewGroup, false);
            hj1.x0(inflate, R.id.loading_spinner, 8, R.id.alert_icon, 8);
            hj1.x0(inflate, R.id.connection_error_textview, 8, R.id.empty_view_text, 0);
            inflate.findViewById(R.id.miscellaneous_text2).setVisibility(8);
            ((TextView) inflate.findViewById(R.id.empty_view_text)).setText(str);
            inflate.findViewById(R.id.retry).setVisibility(0);
            inflate.findViewById(R.id.retry).setOnClickListener(new a());
        } else if (type.equals(UniversalSearchViewItem.Type.EMPTY_STATE)) {
            hj1.x0(inflate, R.id.error_reason_drawable, 0, R.id.error_reason_description, 0);
            ((TextView) inflate.findViewById(R.id.error_reason)).setText(str);
            inflate.findViewById(R.id.error_reason).setBackgroundColor(0);
        } else if (type.equals(UniversalSearchViewItem.Type.ERROR_STATE)) {
            inflate = LayoutInflater.from(this.f).inflate(R.layout.loader_view, viewGroup, false);
            hj1.x0(inflate, R.id.loading_spinner, 8, R.id.alert_icon, 8);
            hj1.x0(inflate, R.id.connection_error_textview, 8, R.id.empty_view_text, 8);
            TextView textView = (TextView) inflate.findViewById(R.id.miscellaneous_text2);
            textView.setVisibility(0);
            textView.setText(R.string.connection_error_places);
            inflate.findViewById(R.id.connection_error_layout).setVisibility(0);
            inflate.findViewById(R.id.retry).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(R.id.error_reason)).setText(str);
            int dimensionPixelSize = this.f.getResources().getDimensionPixelSize(R.dimen.error_state_side_padding);
            inflate.setBackgroundColor(-1);
            inflate.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        inflate.setEnabled(false);
        return inflate;
    }

    public final View d(ViewGroup viewGroup, String str, Object obj) {
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.see_more_pick_route, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.seeText)).setText(str);
        inflate.setOnClickListener(new xk0(this, obj));
        return inflate;
    }

    public void f(boolean z) {
        z61 z61 = this.g;
        z61.e = z;
        z61.i();
        notifyDataSetChanged();
    }

    public int getCount() {
        z61 z61 = this.g;
        Objects.requireNonNull(z61);
        return new ArrayList(z61.f).size();
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        UniversalSearchViewItem b = getItem(i2);
        StringBuilder j0 = hj1.j0("list view item at position ", i2, " type = ");
        j0.append(b.getType());
        j0.toString();
        switch (b.getType().ordinal()) {
            case 0:
                return LayoutInflater.from(this.f).inflate(R.layout.divider, viewGroup, false);
            case 1:
                TextView textView = (TextView) LayoutInflater.from(this.f).inflate(R.layout.universal_recent_view, viewGroup, false);
                textView.setText((String) b.getDataObject());
                textView.setClickable(false);
                return textView;
            case 2:
                return LayoutInflater.from(this.f).inflate(R.layout.loader_new_pick_route_location, viewGroup, false);
            case 3:
                UniversalSearchItem universalSearchItem = (UniversalSearchItem) b.getDataObject();
                int ordinal = universalSearchItem.getType().ordinal();
                if (ordinal == 0) {
                    md1 md1 = (md1) universalSearchItem.getData();
                    mf1 mf1 = new mf1(md1.f2356a, md1.b);
                    rg1 b2 = uj0.b(null, mf1, this.f);
                    b2.setOnClickListener(new cl0(this, mf1));
                    b2.setBackgroundResource(R.drawable.item_selector);
                    return b2;
                } else if (ordinal == 1) {
                    Stop stop = (Stop) universalSearchItem.getData();
                    rg1 c = mk0.c(null, stop, this.f, stop.getMode(), this.h);
                    c.setOnClickListener(new yk0(this, stop));
                    c.setBackgroundResource(R.drawable.item_selector);
                    return c;
                } else if (ordinal == 2) {
                    RouteInfo routeInfo = (RouteInfo) universalSearchItem.getData();
                    View b3 = fk0.b(routeInfo, this.h, this.f, this.j, false);
                    b3.setOnClickListener(new zk0(this, routeInfo));
                    b3.setBackgroundResource(R.drawable.item_selector);
                    return b3;
                } else if (ordinal == 3) {
                    Pair pair = (Pair) universalSearchItem.getData();
                    View inflate = LayoutInflater.from(this.f).inflate(R.layout.trip_planner_universal_search, viewGroup, false);
                    g(this.f, (TextView) inflate.findViewById(R.id.from_location), ((Stop) pair.first).getName());
                    g(this.f, (TextView) inflate.findViewById(R.id.to_location), ((Stop) pair.second).getName());
                    inflate.setOnClickListener(new bl0(this, pair));
                    return inflate;
                } else if (ordinal != 4) {
                    return null;
                } else {
                    Pair pair2 = (Pair) universalSearchItem.getData();
                    View inflate2 = LayoutInflater.from(this.f).inflate(R.layout.trip_planner_universal_search, viewGroup, false);
                    g(this.f, (TextView) inflate2.findViewById(R.id.from_location), ((md1) pair2.first).f2356a);
                    g(this.f, (TextView) inflate2.findViewById(R.id.to_location), ((md1) pair2.second).f2356a);
                    inflate2.setOnClickListener(new al0(this, pair2));
                    return inflate2;
                }
            case 4:
            default:
                return null;
            case 5:
                return d(viewGroup, this.f.getString(R.string.see_more), b.getDataObject());
            case 6:
                return d(viewGroup, this.f.getString(R.string.see_less), b.getDataObject());
            case 7:
                return c(viewGroup, (String) b.getDataObject(), b.getType());
            case 8:
                return c(viewGroup, (String) b.getDataObject(), b.getType());
            case 9:
                return c(viewGroup, (String) b.getDataObject(), b.getType());
        }
    }

    public void h(List<UniversalSearchItem> list, String str) {
        this.g.j(list, str);
        this.h = str;
        notifyDataSetChanged();
    }
}
