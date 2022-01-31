package defpackage;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.TimeInterval;
import java.util.List;

/* renamed from: jj0  reason: default package */
/* compiled from: FrequencyAdapter */
public class jj0 extends BaseAdapter {
    public final Context f;
    public final List<Route.RouteTiming> g;
    public int h;

    public jj0(Context context, List<Route.RouteTiming> list) {
        this.f = context;
        this.g = list;
    }

    public int getCount() {
        return this.g.size();
    }

    public Object getItem(int i) {
        return this.g.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.listview_frequency_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.left);
        TextView textView2 = (TextView) inflate.findViewById(R.id.right);
        Route.RouteTiming routeTiming = this.g.get(i);
        int i3 = this.h;
        int i4 = R.color.orange_primary;
        if (i == i3) {
            i2 = R.color.orange_primary;
        } else {
            i4 = R.color.route_connected_item_color;
            i2 = R.color.black_87;
        }
        if (routeTiming._isFrequency) {
            Pair<TimeInterval, Integer> pair = routeTiming._frequencyTuple;
            textView.setText(jh1.l(jh1.g((long) ((TimeInterval) pair.first).getLow()) + " - " + jh1.g((long) ((TimeInterval) pair.first).getHigh()), this.f));
            textView2.setText(ii1.o(((Integer) pair.second).toString(), i4, i2, this.f));
        } else {
            textView.setText(jh1.l(jh1.g((long) routeTiming._startTime), this.f));
            textView2.setVisibility(8);
        }
        textView.setTextColor(this.f.getResources().getColor(i2));
        inflate.setOnClickListener(null);
        return inflate;
    }
}
