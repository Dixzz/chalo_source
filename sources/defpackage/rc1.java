package defpackage;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.VehicleInfo;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.NearbyStopTripEvent;
import app.zophop.ui.activities.TripsSchedulesDirectionActivity;
import app.zophop.ui.views.summary_card.CardItem;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.appindexing.Indexable;
import defpackage.i10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: rc1  reason: default package */
/* compiled from: NearbyStopTripCard */
public class rc1 extends LinearLayout {
    public static LatLng s;
    public final Context f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public View k;
    public LinearLayout l;
    public double m;
    public CardItem n;
    public CardItem o;
    public boolean p;
    public Map<String, CardItem> q;
    public int r = 0;

    /* renamed from: rc1$a */
    /* compiled from: NearbyStopTripCard */
    public class a implements View.OnClickListener {
        public final /* synthetic */ NearbyStopTripEvent f;

        public a(NearbyStopTripEvent nearbyStopTripEvent) {
            this.f = nearbyStopTripEvent;
        }

        public void onClick(View view) {
            rc1.a(rc1.this, "nearby stops card more trips clicked", this.f.getStop());
            rc1.b(rc1.this, this.f);
        }
    }

    /* renamed from: rc1$b */
    /* compiled from: NearbyStopTripCard */
    public class b implements View.OnClickListener {
        public final /* synthetic */ NearbyStopTripEvent f;

        public b(NearbyStopTripEvent nearbyStopTripEvent) {
            this.f = nearbyStopTripEvent;
        }

        public void onClick(View view) {
            rc1.a(rc1.this, "nearby stops card stop name header clicked", this.f.getStop());
            rc1.b(rc1.this, this.f);
        }
    }

    public rc1(Context context) {
        super(context);
        this.f = context;
        LayoutInflater.from(context).inflate(R.layout.nearby_stop_trip_card, (ViewGroup) this, true);
        this.g = (TextView) findViewById(R.id.stop_name);
        this.h = (TextView) findViewById(R.id.stop_dist);
        this.i = (TextView) findViewById(R.id.next_buses);
        this.j = findViewById(R.id.nearby_stop_trip_card_more_container);
        this.k = findViewById(R.id.above_nearby_stop_trip_card_div);
        this.l = (LinearLayout) findViewById(R.id.nearby_stop_trip_card_root);
        this.p = false;
    }

    public static void a(rc1 rc1, String str, Stop stop) {
        Objects.requireNonNull(rc1);
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        ed1.a("stopId", stop.getId());
        ed1.a("stopName", stop.getName());
        jz5.b().g(ed1);
    }

    public static void b(rc1 rc1, NearbyStopTripEvent nearbyStopTripEvent) {
        Objects.requireNonNull(rc1);
        Intent intent = new Intent(rc1.f, TripsSchedulesDirectionActivity.class);
        intent.putExtra("stop_id", nearbyStopTripEvent.getStop().getId());
        intent.putExtra("stop_name", nearbyStopTripEvent.getStop().getName());
        intent.putExtra("stop_distance", ui1.q(rc1.m));
        intent.putExtra("mode", nearbyStopTripEvent.getStop().getMode().toString());
        intent.putExtra("stop_distance_km", rc1.m);
        rc1.f.startActivity(intent);
    }

    public static LatLng getPrevQueriedLoc() {
        return s;
    }

    private void setNextBusesText(HashSet<String> hashSet) {
        if (hashSet.size() > 0) {
            Iterator<String> it = hashSet.iterator();
            String str = "";
            while (it.hasNext()) {
                str = hj1.T(str, it.next(), ", ");
            }
            this.i.setText(str.substring(0, str.length() - 2));
            return;
        }
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    public final void c(CardItem cardItem, Pair<TripSummary, i10> pair) {
        Object obj;
        String str;
        if (cardItem != null && (obj = pair.second) != null && (str = ((i10) obj).g) != null) {
            cardItem.f.p = str;
            this.q.put(str, cardItem);
        }
    }

    public Map<String, CardItem> d(NearbyStopTripEvent nearbyStopTripEvent, Map<String, VehicleInfo> map) {
        int i2;
        CardItem cardItem = this.o;
        if (cardItem != null) {
            cardItem.setVisibility(0);
            this.o.setAlpha(1.0f);
        }
        CardItem cardItem2 = this.n;
        if (cardItem2 != null) {
            cardItem2.setAlpha(1.0f);
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        s = nearbyStopTripEvent.getLatLng();
        Stop stop = nearbyStopTripEvent.getStop();
        this.g.setText(stop.getName());
        double L = vn.L(nearbyStopTripEvent.getLatLng(), stop.getLatLong());
        this.m = L;
        ui1.y0(this.h, L, R.drawable.walk_nearbycard);
        List<Pair<TripSummary, i10>> liveTimings = nearbyStopTripEvent.getLiveTimings();
        List<TripSummary> scheduledTimings = nearbyStopTripEvent.getScheduledTimings();
        String name = nearbyStopTripEvent.getStop().getName();
        ArrayList arrayList = new ArrayList();
        for (TripSummary tripSummary : scheduledTimings) {
            arrayList.add(new Pair(tripSummary, new i10(Integer.MAX_VALUE, System.currentTimeMillis())));
        }
        arrayList.addAll(liveTimings);
        Collections.sort(arrayList, new tc1(this));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            i10 i10 = (i10) pair.second;
            String str = i10.g;
            if (str != null) {
                VehicleInfo vehicleInfo = new VehicleInfo(str, i10.b);
                vehicleInfo.setStopId(((TripSummary) pair.first).getDirectionStop().getId());
                vehicleInfo.setRouteId(((TripSummary) pair.first).getRouteId());
                vehicleInfo.toString();
                map.put(str, vehicleInfo);
            }
        }
        this.q = new HashMap();
        Pair<TripSummary, i10> pair2 = (Pair) arrayList.get(0);
        CardItem cardItem3 = this.n;
        int i3 = 1;
        if (cardItem3 == null) {
            CardItem d = y61.d((TripSummary) pair2.first, TransitMode.bus, this.f);
            this.n = d;
            this.l.addView(d, 1);
        } else {
            cardItem3.setContent(y61.a((TripSummary) pair2.first, TransitMode.bus, this.f));
        }
        this.n.setAlpha(1.0f);
        if (e(pair2, this.n, name)) {
            i2 = 1;
        } else {
            this.n.getSeatAvailabilityIconView().setVisibility(8);
            i2 = 0;
        }
        this.n.setOnClickListener(new sc1(this, nearbyStopTripEvent.getStop(), (TripSummary) pair2.first));
        c(this.n, pair2);
        if (arrayList.size() >= 2) {
            Pair<TripSummary, i10> pair3 = (Pair) arrayList.get(1);
            CardItem cardItem4 = this.o;
            if (cardItem4 == null) {
                CardItem d2 = y61.d((TripSummary) pair3.first, TransitMode.bus, this.f);
                this.o = d2;
                this.l.addView(d2, 3);
            } else {
                cardItem4.setContent(y61.a((TripSummary) pair3.first, TransitMode.bus, this.f));
            }
            this.o.setAlpha(1.0f);
            if (e(pair3, this.o, name)) {
                i2++;
            } else {
                this.o.getSeatAvailabilityIconView().setVisibility(8);
            }
            int i4 = this.r;
            if (i4 == 0 && i2 != 0) {
                this.r = i4 + 1;
                ui1.q0("Home Screen Nearby Stop Card", stop.getName(), stop.getId(), i2);
            }
            this.o.setOnClickListener(new sc1(this, nearbyStopTripEvent.getStop(), (TripSummary) pair3.first));
            c(this.o, pair3);
            i3 = 2;
        } else {
            CardItem cardItem5 = this.o;
            if (cardItem5 != null) {
                cardItem5.setVisibility(8);
                this.k.setVisibility(8);
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        if (arrayList.size() > i3) {
            while (i3 < arrayList.size()) {
                hashSet.add(((TripSummary) ((Pair) arrayList.get(i3)).first).getRouteName());
                i3++;
            }
        }
        setNextBusesText(hashSet);
        findViewById(R.id.nearby_trips_more).setOnClickListener(new a(nearbyStopTripEvent));
        findViewById(R.id.nearby_stop_trip_card_header).setOnClickListener(new b(nearbyStopTripEvent));
        if (this.r == Integer.MAX_VALUE) {
            this.r = 0;
        }
        return this.q;
    }

    public final boolean e(Pair<TripSummary, i10> pair, CardItem cardItem, String str) {
        i10 i10 = (i10) pair.second;
        if (xt.f3961a.E().c) {
            cardItem.getTimeView().setVisibility(8);
            cardItem.getSkeletonLoaderEta().setVisibility(0);
        } else {
            cardItem.getTimeView().setVisibility(0);
            cardItem.getSkeletonLoaderEta().setVisibility(8);
        }
        if (i10.d.equals(i10.a.ESTIMATED)) {
            TextView timeView = cardItem.getTimeView();
            cardItem.getScheduledTimeView().setVisibility(0);
            ui1.G0(timeView, i10, this.f);
        } else {
            Object obj = pair.second;
            if (((i10) obj).f1460a >= Integer.MAX_VALUE) {
                return false;
            }
            int i2 = ((i10) obj).f1460a;
            TextView timeView2 = cardItem.getTimeView();
            cardItem.getScheduledTimeView().setVisibility(0);
            ui1.H0(timeView2, ii1.d((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.f), this.f, 2);
            if (this.p) {
                ui1.s0(str, "stop card home screen", ((TripSummary) pair.first).getRouteName());
            }
        }
        return true;
    }

    public void setPanelExpanded(boolean z) {
        this.p = z;
    }
}
