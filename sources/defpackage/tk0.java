package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.models.UniversalSearchItem;
import app.zophop.models.UniversalSearchViewItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: tk0  reason: default package */
/* compiled from: TripPlannerStopBasedResultsAdapter */
public class tk0 extends BaseAdapter {
    public final Context f;
    public final z61 g;
    public String h;
    public final ci1<Stop> i;
    public final ci1<Stop> j;
    public final ci1<Object> k;
    public boolean l;

    /* renamed from: tk0$a */
    /* compiled from: TripPlannerStopBasedResultsAdapter */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            tk0.this.k.a(null);
        }
    }

    public tk0(Context context, ci1<Stop> ci1, ci1<Stop> ci12, ci1<Stop> ci13, ci1<Object> ci14) {
        this.f = context;
        this.i = ci1;
        this.j = ci12;
        this.k = ci14;
        this.g = new z61(context);
        xt.f3961a.c().K();
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
        inflate.setOnClickListener(new uk0(this, obj));
        return inflate;
    }

    public void e(boolean z) {
        z61 z61 = this.g;
        z61.e = z;
        z61.i();
        notifyDataSetChanged();
    }

    public void f(List<UniversalSearchItem> list, String str) {
        this.g.j(list, str);
        this.h = str;
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
                if (universalSearchItem.getType().ordinal() != 1) {
                    return null;
                }
                Stop stop = (Stop) universalSearchItem.getData();
                rg1 c = mk0.c(null, stop, this.f, stop.getMode(), this.h);
                c.setOnClickListener(new vk0(this, stop));
                c.setBackgroundResource(R.drawable.item_selector);
                return c;
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
}
