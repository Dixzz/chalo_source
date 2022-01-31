package defpackage;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.SeatInfo;
import app.zophop.models.VehicleInfo;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import defpackage.ii1;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import zophop.models.Fare;
import zophop.models.FareTuple;
import zophop.models.FareType;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;
import zophop.models.Stop;
import zophop.models.StopSequence;

/* renamed from: ok0  reason: default package */
/* compiled from: TripDetailsAdapter */
public class ok0 extends BaseAdapter {
    public static final /* synthetic */ int r = 0;
    public final Context f;
    public final String g;
    public final String h;
    public final Itinerary i;
    public List<b> j;
    public HashMap<Integer, ii1.a> k;
    public final Map<String, Integer> l = new HashMap();
    public final Map<String, Route> m = new HashMap();
    public final Set<String> n = new HashSet();
    public Map<String, VehicleInfo> o;
    public Map<String, Integer> p;
    public boolean q;

    /* renamed from: ok0$a */
    /* compiled from: TripDetailsAdapter */
    public class a implements View.OnClickListener {
        public final /* synthetic */ View f;
        public final /* synthetic */ View g;

        public a(View view, View view2) {
            this.f = view;
            this.g = view2;
        }

        public void onClick(View view) {
            View findViewById = this.f.findViewById(R.id.stops_name_container);
            TextView textView = (TextView) this.g.findViewById(R.id.stop_numbers);
            ImageView imageView = (ImageView) this.g.findViewById(R.id.more_stops);
            View findViewById2 = this.f.findViewById(R.id.location_container);
            if (findViewById.getVisibility() == 0) {
                textView.setText(ok0.this.f.getString(R.string.btn_text_show_all_stops));
                imageView.setImageResource(R.drawable.stops_show);
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                return;
            }
            imageView.setImageResource(R.drawable.stops_less);
            textView.setText(ok0.this.f.getString(R.string.btn_text_hide_stops));
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        }
    }

    /* renamed from: ok0$b */
    /* compiled from: TripDetailsAdapter */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f2703a;
        public Object b;
        public Fare c;
        public boolean d;
        public int e;

        public b() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.d != bVar.d) {
                return false;
            }
            Object obj2 = this.b;
            if (obj2 == null ? bVar.b != null : !obj2.equals(bVar.b)) {
                return false;
            }
            Fare fare = this.c;
            if (fare == null ? bVar.c != null : !fare.equals(bVar.c)) {
                return false;
            }
            if (this.f2703a == bVar.f2703a && this.e == bVar.e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            c cVar = this.f2703a;
            int i = 0;
            int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
            Object obj = this.b;
            int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
            Fare fare = this.c;
            if (fare != null) {
                i = fare.hashCode();
            }
            return ((((hashCode2 + i) * 31) + (this.d ? 1 : 0)) * 31) + this.e;
        }

        public b(a aVar) {
        }
    }

    /* renamed from: ok0$c */
    /* compiled from: TripDetailsAdapter */
    public enum c {
        TRANSIT,
        AUTO,
        TAXI,
        WALK,
        FARE;

        public static boolean isLeg(c cVar) {
            return cVar.equals(TRANSIT) || cVar.equals(AUTO) || cVar.equals(WALK) || cVar.equals(TAXI);
        }
    }

    public ok0(Context context, Itinerary itinerary, String str) {
        int i2;
        String str2;
        this.f = context;
        this.i = itinerary;
        this.g = str;
        Iterator<Leg> it = itinerary.legs.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Leg next = it.next();
            if ((next.mode.equals(LegMode.BUS) || next.mode.equals(LegMode.FERRY) || next.mode.equals(LegMode.RAILWAY) || next.mode.equals(LegMode.METRO)) && (str2 = next.route_id) != null) {
                this.l.put(str2, Integer.valueOf(i3));
            }
            i3 += next.end_time - next.start_time;
        }
        this.j = new ArrayList();
        Itinerary itinerary2 = this.i;
        ArrayList<Fare> arrayList = itinerary2.fares;
        ArrayList<Leg> arrayList2 = itinerary2.legs;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= arrayList2.size()) {
                break;
            }
            b bVar = new b(null);
            bVar.f2703a = d(arrayList2.get(i4));
            bVar.b = arrayList2.get(i4);
            if (i4 != 0) {
                LegMode legMode = arrayList2.get(i4).mode;
                if (!legMode.equals(LegMode.AUTO) && !legMode.equals(LegMode.TAXI) && !legMode.equals(LegMode.WALK)) {
                    z = false;
                }
                if (!z) {
                    i2 = arrayList2.get(i4).start_time - arrayList2.get(i4 - 1).end_time;
                    bVar.e = i2;
                    this.j.add(bVar);
                    i4++;
                }
            }
            i2 = 0;
            bVar.e = i2;
            this.j.add(bVar);
            i4++;
        }
        for (Fare fare : arrayList) {
            int intValue = ((Integer) Collections.min(fare.leg_index)).intValue();
            int size = fare.leg_index.size();
            arrayList2.get(intValue);
            b bVar2 = this.j.get(intValue);
            bVar2.c = fare;
            if (size > 1) {
                bVar2.d = true;
            }
        }
        this.j.size();
        this.h = hj1.B(xt.f3961a);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    public final String a(double d) {
        int i2 = (int) d;
        if (i2 > 1000) {
            return new DecimalFormat("#.00").format(d / 1000.0d) + " " + this.f.getString(R.string.km);
        }
        return i2 + " " + this.f.getString(R.string.mt);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public View b(int i2, int i3, ViewGroup viewGroup) {
        ArrayList<StopSequence> arrayList;
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.trip_details_list_child, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.stop_name);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.circle);
        Stop stop = e(i2).intermediateStops.get(i3).getStop();
        textView.setText(stop.getStop_name());
        inflate.findViewById(R.id.circle_top).setVisibility(0);
        inflate.findViewById(R.id.circle_bottom).setVisibility(0);
        if (i3 == 0) {
            Context context = this.f;
            CalligraphyUtils.applyFontToTextView(context, textView, context.getString(R.string.font_medium));
            textView.setText("From " + stop.getStop_name());
            textView.setTextSize(0, (float) this.f.getResources().getDimensionPixelSize(R.dimen.trip_details_stop_location_size));
            inflate.findViewById(R.id.circle_top).setVisibility(4);
        }
        Leg e = e(i2);
        if (i3 == ((e == null || (arrayList = e.intermediateStops) == null) ? 0 : arrayList.size()) - 1) {
            StringBuilder i0 = hj1.i0("To ");
            i0.append(stop.getStop_name());
            textView.setText(i0.toString());
            Context context2 = this.f;
            CalligraphyUtils.applyFontToTextView(context2, textView, context2.getString(R.string.font_medium));
            textView.setTextSize(0, (float) this.f.getResources().getDimensionPixelSize(R.dimen.trip_details_stop_location_size));
            inflate.findViewById(R.id.circle_bottom).setVisibility(4);
            imageView.setImageResource(R.drawable.trip_planner_circle_to);
        }
        return inflate;
    }

    public final FareTuple c(List<FareTuple> list, FareType fareType) {
        for (FareTuple fareTuple : list) {
            if (FareType.getFareType(fareTuple.fare_type) != null && FareType.getFareType(fareTuple.fare_type).equals(fareType)) {
                return fareTuple;
            }
        }
        return null;
    }

    public c d(Leg leg) {
        LegMode legMode = leg.mode;
        if (legMode.equals(LegMode.WALK)) {
            return c.WALK;
        }
        if (legMode.equals(LegMode.AUTO)) {
            return c.AUTO;
        }
        if (legMode.equals(LegMode.TAXI)) {
            return c.TAXI;
        }
        return c.TRANSIT;
    }

    public Leg e(int i2) {
        b bVar = this.j.get(i2);
        if (c.isLeg(bVar.f2703a)) {
            return (Leg) bVar.b;
        }
        return null;
    }

    public int f(int i2) {
        Leg e;
        if (i2 == getCount() || (e = e(i2)) == null) {
            return R.drawable.location_stop_details;
        }
        int ordinal = e.mode.ordinal();
        if (ordinal == 0) {
            return R.drawable.mono_stop_details;
        }
        if (ordinal == 1) {
            return R.drawable.metro_stop_details;
        }
        if (ordinal == 5) {
            return R.drawable.train_stop_details;
        }
        if (ordinal != 6) {
            return R.drawable.location_stop_details;
        }
        return R.drawable.bus_stop_details;
    }

    public final String g(double d) {
        return ui1.H() + ((int) d);
    }

    public int getCount() {
        return this.j.size();
    }

    public Object getItem(int i2) {
        return this.j.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x062d, code lost:
        if (r14 == null) goto L_0x065e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0633, code lost:
        if (r8 >= r14.size()) goto L_0x065e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x063d, code lost:
        if (r14.get(r8).e <= r9) goto L_0x065b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x063f, code lost:
        r8 = r14.get(r8);
        r9 = defpackage.hj1.i0("In ");
        r9.append(defpackage.ui1.R(r8.e, r8.f));
        r8 = r9.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x065b, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0556  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x057f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x058c  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x067e  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x06bf  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x06ce  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x06d4  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x06f3  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0871  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x08c2  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x08ce A[LOOP:3: B:224:0x08bc->B:231:0x08ce, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x08da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x04a8  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x04f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r32, android.view.View r33, android.view.ViewGroup r34) {
        /*
        // Method dump skipped, instructions count: 2482
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ok0.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void h(b bVar, View view) {
        Fare fare = bVar.c;
        TextView textView = (TextView) view.findViewById(R.id.fare_details);
        if (fare == null) {
            textView.setVisibility(8);
            return;
        }
        this.i.legs.get(((Integer) Collections.min(fare.leg_index)).intValue());
        Leg leg = this.i.legs.get(((Integer) Collections.max(fare.leg_index)).intValue());
        TextView textView2 = (TextView) view.findViewById(R.id.fare_more_details);
        j(view);
        if (bVar.d) {
            String string = this.f.getString(R.string.fare_till_station);
            Object[] objArr = new Object[1];
            String[] split = leg.end_place_name.split(",");
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]);
            sb.append(split.length > 1 ? hj1.a0(hj1.i0(", "), split[1], "...") : "");
            objArr[0] = sb.toString();
            textView2.setText(String.format(string, objArr));
            textView2.setVisibility(0);
            textView.setVisibility(0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.alert_fare_trip_details, 0, 0, 0);
            hj1.v0(this.f, R.color.trip_details_view_stops_color, textView2);
            this.i.legs.get(fare.leg_index.get(0).intValue());
            FareTuple c2 = c(fare.fare_tuples, FareType.GENERAL);
            FareTuple c3 = c(fare.fare_tuples, FareType.FIRST_CLASS);
            if (c2 != null && c3 != null) {
                view.findViewById(R.id.service_type).setVisibility(0);
                ((ImageView) view.findViewById(R.id.service_type)).setImageResource(R.drawable.second_class);
                textView.setText(g(c2.amount));
                return;
            }
            return;
        }
        textView.setText(g(fare.default_fare));
        textView.setVisibility(0);
        textView2.setVisibility(8);
    }

    public boolean hasStableIds() {
        return false;
    }

    public final void i(Leg leg, TextView textView) {
        StringBuilder i0 = hj1.i0("From ");
        i0.append(leg.first_stop.getStop_name());
        textView.setText(i0.toString());
    }

    public boolean isEmpty() {
        return false;
    }

    public final void j(View view) {
        view.findViewById(R.id.transaction_container_divider).setVisibility(0);
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        if (this.q && seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            HashMap hashMap = new HashMap();
            xt.t1 t1Var = xt.f3961a;
            this.p = t1Var.Z().d(seatInfoList, hashMap);
            notifyDataSetChanged();
            t1Var.Z().c(seatInfoList, "Trip Details Activity");
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
    }
}
