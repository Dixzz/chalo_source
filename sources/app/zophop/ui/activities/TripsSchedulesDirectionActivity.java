package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.features.GeoFenceService;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.VehicleInfo;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.ui.SkeletonLoader;
import app.zophop.ui.activities.SplashScreen;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import defpackage.a32;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.zophop.logging.LoggingConstants;

public class TripsSchedulesDirectionActivity extends au {
    public static final /* synthetic */ int M = 0;
    public Handler A;
    public Handler B;
    public Runnable C;
    public DataSnapshot D;
    public Map<String, Integer> E;
    public Map<String, j10> F;
    public boolean G;
    public boolean H;
    public Map<String, VehicleInfo> I;
    public Map<String, Integer> J;
    public boolean K;
    public Runnable L;
    @InjectView(R.id.skeleton_loader)
    public SkeletonLoader _skeletonLoader;
    public String k;
    public TransitMode l;
    public String m;
    public String n;
    public String o;
    public double p;
    public String q;
    public ListView r;
    public Spinner s;
    public Map<String, List<TripSummary>> t;
    public a32 u;
    public k00 v;
    public p5 w;
    public ValueEventListener x;
    public kk0 y;
    public boolean z = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity = TripsSchedulesDirectionActivity.this;
            tripsSchedulesDirectionActivity.l0(tripsSchedulesDirectionActivity.n, tripsSchedulesDirectionActivity.m);
            TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity2 = TripsSchedulesDirectionActivity.this;
            tripsSchedulesDirectionActivity2.A.postDelayed(tripsSchedulesDirectionActivity2.C, 2000);
        }
    }

    public class b implements ci1<TripSummary> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(TripSummary tripSummary) {
            TripSummary tripSummary2 = tripSummary;
            if (tripSummary2.isFrequencyTrip() || tripSummary2.getTripId() == null || TransitMode.bus.equals(TripsSchedulesDirectionActivity.this.l)) {
                TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity = TripsSchedulesDirectionActivity.this;
                String routeId = tripSummary2.getRouteId();
                Stop firstStop = tripSummary2.getFirstStop();
                Stop lastStop = tripSummary2.getLastStop();
                TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity2 = TripsSchedulesDirectionActivity.this;
                TransitMode transitMode = tripsSchedulesDirectionActivity2.l;
                String str = tripsSchedulesDirectionActivity2.n;
                String str2 = tripsSchedulesDirectionActivity2.m;
                Intent r0 = RouteDetailsActivity.r0(tripsSchedulesDirectionActivity, routeId, firstStop, lastStop, transitMode, "tripSchedulesDirectionScreen");
                r0.putExtra("extra_trigger_stop", str);
                r0.putExtra("extra_trigger_stop_id", str2);
                tripsSchedulesDirectionActivity.startActivity(r0);
                return;
            }
            Intent intent = new Intent(TripsSchedulesDirectionActivity.this, TripActivity.class);
            intent.putExtra("trip_id", tripSummary2.getTripId());
            intent.putExtra("stop_id", TripsSchedulesDirectionActivity.this.m);
            intent.putExtra(LoggingConstants.ROUTE_ID, tripSummary2.getRouteId());
            intent.putExtra("transit_mode", TripsSchedulesDirectionActivity.this.l.toString());
            intent.putExtra("routeName", tripSummary2.getRouteName());
            intent.putExtra("source", "tripSchedulesDirectionScreen");
            TripsSchedulesDirectionActivity.this.startActivity(intent);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        String str;
        a32.a aVar = new a32.a(this);
        aVar.a(qz1.f3013a);
        a32 d = aVar.d();
        this.u = d;
        d.f();
        this.w = new p5(this);
        xt.t1 t1Var = xt.f3961a;
        this.v = t1Var.y();
        this.E = new HashMap();
        this.G = true;
        Intent intent = getIntent();
        g30 g30 = new g30(intent);
        if (g30.a()) {
            i0(g30);
        } else {
            this.m = intent.getStringExtra("stop_id");
            this.n = intent.getStringExtra("stop_name");
            this.k = intent.getStringExtra("extra_direction");
            this.o = intent.getStringExtra("stop_distance");
            this.l = TransitMode.getTransitMode(intent.getStringExtra("mode"));
            this.p = intent.getDoubleExtra("stop_distance_km", -1.0d);
            if (this.k == null) {
                this.k = "_all";
            }
            String stringExtra = intent.hasExtra("source") ? intent.getStringExtra("source") : null;
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(GeoFenceService.class.getName())) {
                GeoFenceService.h(false, this.n, this.m, this.l.toString());
                SplashScreen.a.a(stringExtra);
            }
            zz zzVar = new zz("stop details screen opened", new HashMap());
            zzVar.a("source", stringExtra);
            ui1.l0(zzVar);
        }
        String g = vn.g(this.l.toString());
        if (this.l.equals(TransitMode.bus)) {
            str = hj1.c0(new StringBuilder(), this.n, " - ", g, " Stop");
        } else if (this.l.equals(TransitMode.train)) {
            str = hj1.a0(new StringBuilder(), this.n, " - Train Station");
        } else {
            str = hj1.c0(new StringBuilder(), this.n, " - ", g, " Station");
        }
        if (this.q == null) {
            this.q = hj1.B(t1Var);
        }
        this.q = vn.g(this.q);
        StringBuilder i0 = hj1.i0("android-app://");
        i0.append(getPackageName());
        i0.append("/zophop/stop?city=");
        i0.append(this.q);
        i0.append("&stop_id=");
        i0.append(this.m);
        i0.append("&stop_name=");
        i0.append(this.n);
        i0.append("&mode=");
        i0.append(this.l);
        i0.append("&extra_direction=");
        hj1.V0(i0, this.k, "&", "source", "=");
        ((gf3) qz1.b).a(this.u, hj1.m(i0, "appIndex", "http://schema.org/ViewAction", str));
        setContentView(R.layout.activity_train_trips);
        ButterKnife.inject(this);
        setSupportActionBar((Toolbar) findViewById(R.id.train_trips_action_tool_bar));
        getSupportActionBar().o(true);
        getSupportActionBar().p(true);
        View inflate = getLayoutInflater().inflate(R.layout.train_schedules_direction_toolbar_view, (ViewGroup) null);
        getSupportActionBar().m(inflate);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.n);
        TextView textView = (TextView) inflate.findViewById(R.id.distance);
        double d2 = this.p;
        if (d2 == -1.0d) {
            textView.setText(this.o);
        } else {
            ui1.y0(textView, d2, R.drawable.walk_nearbycard_black);
        }
        String B2 = hj1.B(t1Var);
        this.s = (Spinner) findViewById(R.id.filter_spinner);
        ListView listView = (ListView) findViewById(R.id.trip_legs_list);
        this.r = listView;
        listView.setEmptyView(findViewById(R.id.empty_view));
        j0(true);
        findViewById(R.id.retry).setOnClickListener(new zg0(this, B2));
        if (!xt.p) {
            this.x = new dh0(this);
        }
        t1Var.c0().b(this, this.m, this.l, this.q);
    }

    public final void h0() {
        if (!this.z && this.x != null) {
            xt.f3961a.N().d(this.m).addValueEventListener(this.x);
            this.z = true;
        }
    }

    public final void i0(g30 g30) {
        this.m = g30.f1208a.get("stop_id");
        this.n = g30.f1208a.get("stop_name");
        this.l = TransitMode.getTransitMode(g30.f1208a.get("mode"));
        this.k = g30.f1208a.get("extra_direction");
        if (g30.f1208a.containsKey("source")) {
            this.v.a("stopDetailsScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
        }
        this.q = g30.f1208a.get("city");
        this.w.b(h.R(this));
    }

    public final void j0(boolean z2) {
        if (z2) {
            this._skeletonLoader.d(true, "tripsSchedulesDirectionActivity", true);
            findViewById(R.id.empty_view_text).setVisibility(8);
            findViewById(R.id.retry).setVisibility(8);
            return;
        }
        this._skeletonLoader.a(null);
        findViewById(R.id.empty_view_text).setVisibility(0);
        findViewById(R.id.retry).setVisibility(0);
    }

    public final void k0(List<TripSummary> list) {
        this.y = new kk0(this, list, new b(), this.l, this.n);
        xt.t1 t1Var = xt.f3961a;
        if (!xt.p) {
            l0(this.n, this.m);
        } else {
            Map<String, j10> map = this.F;
            if (map != null && map.size() > 0) {
                this.y.d(this.F, this.I);
            }
        }
        this.r.setAdapter((ListAdapter) this.y);
        if (!TransitMode.bus.equals(this.l)) {
            this.r.setSelection(this.y.c(ui1.N()));
        }
    }

    public final void l0(String str, String str2) {
        Map<String, j10> map;
        if (this.y != null) {
            xt.t1 t1Var = xt.f3961a;
            if (!xt.p) {
                DataSnapshot dataSnapshot = this.D;
                if (dataSnapshot != null) {
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    HashMap hashMap = new HashMap();
                    for (DataSnapshot dataSnapshot2 : children) {
                        j10 e = ii1.e(dataSnapshot2);
                        if (e.a() < 7200) {
                            hashMap.put(dataSnapshot2.getKey(), e);
                        } else if (e.b().size() != 0) {
                            hashMap.put(dataSnapshot2.getKey(), e);
                        }
                    }
                    if (this.G && hashMap.size() > 0) {
                        ui1.q0("Stop Details Screen", str, str2, hashMap.size());
                        this.G = false;
                    }
                    this.y.d(hashMap, this.I);
                    m0();
                }
            } else if (this.G && (map = this.F) != null && map.size() > 0) {
                ui1.q0("Stop Details Screen", this.n, this.m, this.F.size());
                this.G = false;
                this.y.d(this.F, this.I);
                m0();
            }
        }
    }

    public final void m0() {
        Map<String, VehicleInfo> map;
        xt.t1 t1Var = xt.f3961a;
        t1Var.Z().g(this.I);
        if (!this.K && (map = this.I) != null && map.size() != 0) {
            t1Var.Z().e(this.B);
            Runnable a2 = t1Var.Z().a();
            this.L = a2;
            if (a2 != null) {
                a2.run();
                this.K = true;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ui1.F0(this.w);
        super.onBackPressed();
    }

    public void onEvent(qd1 qd1) {
        if (vn.K0(this)) {
            h0();
        }
    }

    public void onEventMainThread(List<TripSummary> list) {
        list.toString();
        int i = 0;
        if (list.size() == 0) {
            j0(false);
            return;
        }
        HashMap hashMap = new HashMap();
        for (TripSummary tripSummary : list) {
            if (tripSummary.getDirectionStop() != null) {
                String name = tripSummary.getDirectionStop().getName();
                if (!hashMap.containsKey(name)) {
                    hashMap.put(name, new ArrayList());
                }
                ((List) hashMap.get(name)).add(tripSummary);
            }
        }
        this.t = hashMap;
        hashMap.put("_all", list);
        if (!this.l.equals(TransitMode.bus)) {
            this.s.setVisibility(0);
            ArrayList arrayList = new ArrayList(this.t.keySet());
            Collections.sort(arrayList, new ch0(this));
            xi0 xi0 = new xi0(arrayList, this);
            this.s.setAdapter((SpinnerAdapter) xi0);
            this.s.setOnItemSelectedListener(new bh0(this, xi0));
            Spinner spinner = this.s;
            String str = this.k;
            while (true) {
                if (i >= xi0.getCount()) {
                    i = -1;
                    break;
                } else if (str.equals(xi0.a(i))) {
                    xi0.a(i);
                    break;
                } else {
                    i++;
                }
            }
            spinner.setSelection(i);
            return;
        }
        k0(this.t.get("_all"));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        ui1.F0(this.w);
        return true;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        super.onPause();
        this.A.removeCallbacks(this.C);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        this.H = true;
        this.C.run();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
        this.A = new Handler();
        this.B = new Handler();
        this.I = new HashMap();
        this.J = new HashMap();
        if (vn.K0(this)) {
            xt.t1 t1Var = xt.f3961a;
            if (!xt.p) {
                h0();
            }
        }
        xt.t1 t1Var2 = xt.f3961a;
        if (xt.p) {
            String w2 = vn.w("allRoutesEtas", this.m);
            this.E.put(w2, Integer.valueOf(t1Var2.O().k(w2, new ah0(this))));
        }
        this.C = new a();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
        if (this.z && this.x != null) {
            xt.f3961a.N().d(this.m).removeEventListener(this.x);
            this.z = false;
        }
        xt.t1 t1Var = xt.f3961a;
        if (xt.p) {
            Map<String, j10> map = this.F;
            if (map != null) {
                map.clear();
            }
            Iterator<Map.Entry<String, Integer>> it = this.E.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                xt.f3961a.O().l(next.getKey(), next.getValue().intValue());
                it.remove();
            }
        }
        if (this.B != null) {
            xt.f3961a.Z().b();
            this.B.removeCallbacksAndMessages(null);
            this.B = null;
            this.K = false;
        }
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        if (this.K && seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            xt.t1 t1Var = xt.f3961a;
            Map<String, Integer> d = t1Var.Z().d(seatInfoList, this.J);
            this.J = d;
            kk0 kk0 = this.y;
            kk0.k = d;
            kk0.notifyDataSetChanged();
            t1Var.Z().c(seatInfoList, "Trip Schedules Direction Activity");
        }
    }
}
