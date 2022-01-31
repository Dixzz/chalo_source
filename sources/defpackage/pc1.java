package defpackage;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.activities.TripsSchedulesDirectionActivity;
import app.zophop.ui.views.summary_card.CardItem;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.appindexing.Indexable;
import defpackage.i10;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: pc1  reason: default package */
/* compiled from: NearbyStopActivityCard */
public class pc1 extends LinearLayout {
    public static final /* synthetic */ int y = 0;
    public final Context f;
    public final SummaryResponse g;
    public final LatLng h;
    public Map<String, i10> i;
    public List<Pair<TripSummary, i10>> j;
    public List<TripSummary> k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public View p;
    public View q;
    public LinearLayout r;
    public double s;
    public CardItem t;
    public CardItem u;
    public boolean v;
    public Map<String, CardItem> w;
    public int x = 0;

    /* renamed from: pc1$a */
    /* compiled from: NearbyStopActivityCard */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Stop f;

        public a(Stop stop) {
            this.f = stop;
        }

        public void onClick(View view) {
            pc1.a(pc1.this, this.f);
            pc1.b(pc1.this, this.f);
        }
    }

    /* renamed from: pc1$b */
    /* compiled from: NearbyStopActivityCard */
    public class b implements View.OnClickListener {
        public final /* synthetic */ Stop f;

        public b(Stop stop) {
            this.f = stop;
        }

        public void onClick(View view) {
            pc1.a(pc1.this, this.f);
            pc1.b(pc1.this, this.f);
        }
    }

    /* renamed from: pc1$c */
    /* compiled from: NearbyStopActivityCard */
    public class c implements Comparator<Pair<TripSummary, i10>>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(Pair<TripSummary, i10> pair, Pair<TripSummary, i10> pair2) {
            int i;
            int i2;
            Pair<TripSummary, i10> pair3 = pair;
            Pair<TripSummary, i10> pair4 = pair2;
            i10 i10 = (i10) pair3.second;
            if (i10.f1460a == Integer.MAX_VALUE && ((i10) pair4.second).f1460a == Integer.MAX_VALUE) {
                return ui1.h((TripSummary) pair3.first, (TripSummary) pair4.first);
            }
            i10.a aVar = i10.d;
            if (aVar == null || aVar.equals(i10.a.FIXED)) {
                i = ((i10) pair3.second).f1460a;
            } else {
                i = ((i10) pair3.second).e;
            }
            i10.a aVar2 = ((i10) pair4.second).d;
            if (aVar2 == null || aVar2.equals(i10.a.FIXED)) {
                i2 = ((i10) pair4.second).f1460a;
            } else {
                i2 = ((i10) pair4.second).e;
            }
            return i - i2;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<Pair<TripSummary, i10>> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<Pair<TripSummary, i10>> thenComparing(java.util.Comparator<? super Pair<TripSummary, i10>> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public pc1(Context context, SummaryResponse summaryResponse, LatLng latLng) {
        super(context);
        this.f = context;
        this.g = summaryResponse;
        this.h = latLng;
        LayoutInflater.from(context).inflate(R.layout.nearby_stop_trip_card_old, (ViewGroup) this, true);
        this.l = (TextView) findViewById(R.id.stop_name);
        this.m = (TextView) findViewById(R.id.stop_dist);
        this.n = (TextView) findViewById(R.id.next_buses);
        TextView textView = (TextView) findViewById(R.id.next_availability_header);
        ImageView imageView = (ImageView) findViewById(R.id.bus_icon);
        this.o = (TextView) findViewById(R.id.more_buses_prefix);
        this.p = findViewById(R.id.nearby_stop_trip_card_more_container);
        this.q = findViewById(R.id.above_nearby_stop_trip_card_div);
        this.r = (LinearLayout) findViewById(R.id.nearby_stop_trip_card_root);
        TransitMode mode = getMode();
        int ordinal = mode.ordinal();
        imageView.setImageResource(ordinal != 0 ? ordinal != 5 ? ordinal != 2 ? ordinal != 3 ? R.drawable.bus_nearby_selected : R.drawable.monorail_nearby_selected : R.drawable.metro_nearby_selected : R.drawable.ferry_nearby_selected : R.drawable.train_nearby_selected);
        int ordinal2 = mode.ordinal();
        textView.setText(context.getString(ordinal2 != 1 ? ordinal2 != 5 ? R.string.next_availability_header_trainish : R.string.next_availability_header_ferries : R.string.next_availability_header_buses));
        this.v = false;
    }

    public static void a(pc1 pc1, Stop stop) {
        Objects.requireNonNull(pc1);
        ed1 ed1 = new ed1("nearby stops activity card more trips clicked", Long.MIN_VALUE);
        ed1.a("stopId", stop.getId());
        ed1.a("stopName", stop.getName());
        jz5.b().g(ed1);
    }

    public static void b(pc1 pc1, Stop stop) {
        Objects.requireNonNull(pc1);
        Intent intent = new Intent(pc1.f, TripsSchedulesDirectionActivity.class);
        intent.putExtra("stop_id", stop.getId());
        intent.putExtra("stop_name", stop.getName());
        intent.putExtra("stop_distance", ui1.q(pc1.s));
        intent.putExtra("mode", stop.getMode().toString());
        intent.putExtra("stop_distance_km", pc1.s);
        pc1.f.startActivity(intent);
        ui1.r0("train schedules direction", "nearby stops", stop.getMode().toString());
    }

    public static List<Pair<TripSummary, i10>> e(List<Pair<TripSummary, i10>> list, List<TripSummary> list2) {
        ArrayList arrayList = new ArrayList();
        for (TripSummary tripSummary : list2) {
            arrayList.add(new Pair(tripSummary, new i10(Integer.MAX_VALUE, System.currentTimeMillis())));
        }
        arrayList.addAll(list);
        Collections.sort(arrayList, new c());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public TransitMode getMode() {
        return getStop().getMode();
    }

    private void setNextBusesText(HashSet<String> hashSet) {
        if (hashSet.size() <= 0) {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
        } else if (getMode().equals(TransitMode.bus)) {
            Iterator<String> it = hashSet.iterator();
            String str = "";
            while (it.hasNext()) {
                str = hj1.T(str, it.next(), ", ");
            }
            this.n.setText(str.substring(0, str.length() - 2));
        } else {
            this.n.setVisibility(4);
            this.o.setVisibility(4);
        }
    }

    public final void d(CardItem cardItem, Pair<TripSummary, i10> pair) {
        Object obj;
        String str;
        if (cardItem != null && (obj = pair.second) != null && (str = ((i10) obj).g) != null) {
            cardItem.f.p = str;
            this.w.put(str, cardItem);
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, app.zophop.ui.views.summary_card.CardItem> f(java.util.Map<java.lang.String, defpackage.i10> r12, java.util.Map<java.lang.String, app.zophop.models.VehicleInfo> r13) {
        /*
        // Method dump skipped, instructions count: 618
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pc1.f(java.util.Map, java.util.Map):java.util.Map");
    }

    public final boolean g(Pair<TripSummary, i10> pair, CardItem cardItem, String str) {
        i10 i10 = (i10) pair.second;
        if (i10.d.equals(i10.a.ESTIMATED)) {
            TextView timeView = cardItem.getTimeView();
            cardItem.getScheduledTimeView().setVisibility(0);
            ui1.G0(timeView, i10, this.f);
            return true;
        }
        Object obj = pair.second;
        if (((i10) obj).f1460a >= Integer.MAX_VALUE) {
            return false;
        }
        int i2 = ((i10) obj).f1460a;
        TextView timeView2 = cardItem.getTimeView();
        cardItem.getScheduledTimeView().setVisibility(0);
        ui1.H0(timeView2, ii1.d((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.f), this.f, 2);
        if (!this.v) {
            return true;
        }
        ui1.s0(str, "stop card home screen", ((TripSummary) pair.first).getRouteName());
        return true;
    }

    public Stop getStop() {
        return this.g.getStop();
    }

    public void setPanelExpanded(boolean z) {
        this.v = z;
    }
}
