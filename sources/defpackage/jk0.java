package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: jk0  reason: default package */
/* compiled from: SchedulerTripAdapter */
public class jk0 extends BaseAdapter {
    public List<Route> f = new ArrayList();
    public final Context g;
    public final TransitMode h;

    /* renamed from: jk0$a */
    /* compiled from: SchedulerTripAdapter */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public a(int i, int i2) {
            this.f = i;
            this.g = i2;
        }

        public void onClick(View view) {
            jk0 jk0 = jk0.this;
            RouteDetailsActivity.w0(jk0.g, jk0.f.get(this.f).getRouteId(), jk0.this.f.get(this.f).getStopSequence().get(0), jk0.this.f.get(this.f).getStopSequence().get(this.g - 1), jk0.this.h, "scheduler_screen");
        }
    }

    public jk0(ArrayList<Route> arrayList, Context context, TransitMode transitMode) {
        this.f = arrayList;
        this.g = context;
        this.h = transitMode;
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, String str) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#727171")), length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), length, spannableStringBuilder.length(), 17);
    }

    public int getCount() {
        return this.f.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Route.RouteTiming next;
        Route.RouteTiming routeTiming = null;
        View inflate = LayoutInflater.from(this.g).inflate(R.layout.scheduler_card_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.card_item_icon);
        int ordinal = this.h.ordinal();
        imageView.setImageResource(ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 5 ? 0 : R.drawable.ferry_trip_planner : R.drawable.monorail_trip_planner : R.drawable.metro_trip_planner : R.drawable.bus_trip_planner : R.drawable.train_trip_planner);
        StringBuilder i0 = hj1.i0("From ");
        i0.append(this.f.get(i).getStopSequence().get(0).getName());
        ((TextView) inflate.findViewById(R.id.card_title_from)).setText(i0.toString());
        int size = this.f.get(i).getStopSequence().size();
        StringBuilder i02 = hj1.i0("To ");
        i02.append(this.f.get(i).getStopSequence().get(size - 1).getName());
        ((TextView) inflate.findViewById(R.id.card_title)).setText(i02.toString());
        TextView textView = (TextView) inflate.findViewById(R.id.card_timing);
        Context context = this.g;
        List<Route.RouteTiming> routeTiming2 = this.f.get(i).getRouteTiming();
        ui1.N();
        String str = v40.d;
        Collections.sort(routeTiming2, new m40());
        int N = ui1.N();
        Iterator<Route.RouteTiming> it = routeTiming2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            next = it.next();
            if (next._isFrequency) {
                if (((TimeInterval) next._frequencyTuple.first).containsTime(N)) {
                    break;
                }
            } else if (next._startTime > N) {
                break;
            }
        }
        routeTiming = next;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (routeTiming == null) {
            a(spannableStringBuilder, context.getString(R.string.no_more_trips_today));
        } else if (routeTiming._isFrequency) {
            a(spannableStringBuilder, context.getString(R.string.every));
            spannableStringBuilder.append((CharSequence) "").append((CharSequence) String.valueOf(routeTiming._frequencyTuple.second));
            a(spannableStringBuilder, " min");
        } else {
            String g2 = jh1.g((long) routeTiming._startTime);
            a(spannableStringBuilder, context.getString(R.string.after));
            String replace = g2.replace("am", "AM").replace("pm", "PM");
            spannableStringBuilder.append((CharSequence) replace);
            if (replace.length() >= 2) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
            }
        }
        textView.setText(spannableStringBuilder);
        inflate.setOnClickListener(new a(i, size));
        return inflate;
    }
}
