package app.zophop.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.VehicleInfo;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.pubsub.eventbus.events.BusSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.MetroSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.MonorailSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.TrainSummaryResponseEvent;
import app.zophop.ui.fragments.NearbyStopsScreenMapFragment;
import app.zophop.ui.views.MapCustomMyLocation;
import app.zophop.ui.views.summary_card.CardItem;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScroll;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import defpackage.wd1;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NearbyStopsActivity extends au implements wd1.a {
    public static final Float Y = Float.valueOf(18.0f);
    public static final Float Z = Float.valueOf(14.0f);
    public static final Float a0 = Float.valueOf(12.0f);
    public Handler A;
    public Handler B;
    public HandlerThread C;
    public Handler D;
    public boolean E = false;
    public k00 F;
    public p5 G;
    public Map<String, Bitmap> H;
    public boolean I = false;
    public boolean J;
    public Stop K;
    public NearbyStopsScreenMapFragment L;
    public pc1 M;
    public MapCustomMyLocation N;
    public ah1 O;
    public Runnable P;
    public DataSnapshot Q;
    public Map<String, Integer> R;
    public boolean S;
    public Map<String, CardItem> T;
    public Map<String, VehicleInfo> U;
    public Map<String, VehicleInfo> V;
    public boolean W;
    public boolean X = false;
    public e80 k;
    public e44 l;
    public je1 m;
    public w40 n;
    public Map<TransitMode, b> o;
    public List<TransitMode> p;
    public RelativeLayout q;
    public LinearLayout r;
    public SlidingUpPanelLayout s;
    public Map<String, Marker> t;
    public HorizontalTabScroll u;
    public Toolbar v;
    public TransitMode w;
    public String x;
    public SummaryResponseEvent y;
    public ValueEventListener z;

    public class a implements ji1<Object, String> {
        public a(NearbyStopsActivity nearbyStopsActivity) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            b00 b00 = b00.f358a;
            hj1.Q0(str, b00.a());
        }

        @Override // defpackage.ji1
        public void onSuccess(Object obj) {
            Map map = (Map) obj;
            HashMap hashMap = new HashMap();
            hashMap.clear();
            for (String str : map.keySet()) {
                j10 g = ii1.g((List) map.get(str));
                if (g.a() < 7200) {
                    hashMap.put(str, g.c().get(0));
                } else if (g.b().size() != 0) {
                    hashMap.put(str, g.b().get(0));
                }
            }
            jz5.b().g(hashMap);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f299a;
        public LatLng b;
        public LatLng c;
        public final Map<Stop, SummaryResponse> d = new HashMap();
        public final Map<Marker, SummaryResponse> e = new HashMap();
        public final Map<Stop, Marker> f = new HashMap();

        public void a(boolean z) {
            for (Marker marker : this.e.keySet()) {
                marker.setVisible(z);
            }
        }
    }

    public static LatLng h0(NearbyStopsActivity nearbyStopsActivity) {
        LatLng h = nearbyStopsActivity.m.h();
        City d = nearbyStopsActivity.k.d();
        return (h == null || !d.containsLocation(h)) ? d.getCenter() : h;
    }

    @Override // defpackage.wd1.a
    public void b0() {
    }

    @Override // defpackage.wd1.a
    public void c0() {
        if (this.l != null && this.L != null) {
            if (this.K != null) {
                this.X = false;
                this.s.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
            NearbyStopsScreenMapFragment nearbyStopsScreenMapFragment = this.L;
            nearbyStopsScreenMapFragment.i.a(n0());
            this.D.removeMessages(2);
            this.D.sendEmptyMessageDelayed(2, 300);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        TransitMode transitMode;
        this.H = new HashMap();
        this.G = new p5(this);
        xt.t1 t1Var = xt.f3961a;
        this.F = t1Var.y();
        this.k = t1Var.k();
        this.O = new ah1(this, t1Var.B().a());
        Intent intent = getIntent();
        g30 g30 = new g30(intent);
        if (g30.a()) {
            if (g30.f1208a.containsKey("source")) {
                this.F.a("nearbyStopsScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
            }
            this.G.b(h.R(this));
            this.w = null;
            if (g30.f1208a.containsKey("mode")) {
                TransitMode transitMode2 = TransitMode.getTransitMode(g30.f1208a.get("mode"));
                List<TransitMode> modes = this.k.d().getModes();
                Iterator<TransitMode> it = modes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        transitMode = modes.get(0);
                        break;
                    }
                    transitMode = it.next();
                    if (transitMode.equals(transitMode2)) {
                        break;
                    }
                }
                this.w = transitMode;
            }
            this.E = true;
        } else {
            String stringExtra = intent.getStringExtra("nearby:mode");
            String stringExtra2 = intent.getStringExtra("source");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.w = TransitMode.getTransitMode(stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.x = stringExtra2;
                this.y = (SummaryResponseEvent) new Gson().fromJson(intent.getStringExtra("nearby:summary_response"), SummaryResponseEvent.class);
            }
        }
        xt.t1 t1Var2 = xt.f3961a;
        this.m = t1Var2.B();
        this.o = new HashMap();
        this.n = t1Var2.c0();
        this.t = new HashMap();
        this.R = new HashMap();
        this.D = new Handler(new xe0(this));
        setContentView(R.layout.nearby_stops_screen);
        this.q = (RelativeLayout) findViewById(R.id.nearby_card_container);
        this.r = (LinearLayout) findViewById(R.id.nearby_card_container_root);
        SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.s = slidingUpPanelLayout;
        slidingUpPanelLayout.setPanelHeight((int) getResources().getDimension(R.dimen.nearby_card_height));
        Toolbar toolbar = (Toolbar) findViewById(R.id.nearby_screen_action_tool_bar);
        this.v = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().z(getString(R.string.nearby_stops_activity_toolbar_title));
        getSupportActionBar().o(true);
        this.u = (HorizontalTabScroll) findViewById(R.id.tabs);
        ArrayList arrayList = new ArrayList(this.k.d().getModes());
        this.p = arrayList;
        Collections.sort(arrayList, new vi1());
        for (TransitMode transitMode3 : this.p) {
            this.o.put(transitMode3, new b());
        }
        ik0 ik0 = new ik0(this, this.p, new ve0(this));
        this.u.setDistributeEvenly(true);
        this.u.setSelectedIndicatorColors(Color.parseColor("#fe7c00"));
        HorizontalTabScroll horizontalTabScroll = this.u;
        horizontalTabScroll.g = R.layout.schedule_tab;
        horizontalTabScroll.h = R.id.tab_title;
        horizontalTabScroll.setAdapter(ik0);
        if (this.p.size() == 1) {
            this.u.setVisibility(8);
        }
        j0();
        this.I = ui1.T(this, "android.permission.ACCESS_FINE_LOCATION");
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
        if (!ui1.T(this, strArr)) {
            requestPermissions(strArr, 123);
        }
        NearbyStopsScreenMapFragment nearbyStopsScreenMapFragment = (NearbyStopsScreenMapFragment) getFragmentManager().findFragmentById(R.id.map);
        this.L = nearbyStopsScreenMapFragment;
        nearbyStopsScreenMapFragment.e(new ye0(this));
        if (this.p.size() >= 2) {
            this.u.setVisibility(0);
        }
        r0(true, null);
        SlidingUpPanelLayout slidingUpPanelLayout2 = this.s;
        if (slidingUpPanelLayout2 != null) {
            slidingUpPanelLayout2.c(new te0(this));
        }
        xt.t1 t1Var3 = xt.f3961a;
        if (!xt.p) {
            HandlerThread handlerThread = new HandlerThread("NearbyHandler");
            this.C = handlerThread;
            handlerThread.start();
            this.A = new Handler(this.C.getLooper());
            this.B = new Handler();
            se0 se0 = new se0(this);
            this.P = se0;
            se0.run();
        }
        zz zzVar = new zz("nearby stops screen open", new HashMap());
        zzVar.a("source", this.x);
        ui1.l0(zzVar);
    }

    public final void i0(String str) {
        xt.t1 t1Var = xt.f3961a;
        if (!xt.p) {
            this.z = new re0(this);
            t1Var.N().d(str).addValueEventListener(this.z);
            return;
        }
        String w2 = vn.w("allRoutesEtas", str);
        this.R.put(w2, Integer.valueOf(t1Var.O().k(w2, new a(this))));
    }

    public final void j0() {
        if (vn.K0(this)) {
            e0();
            this.S = false;
        } else if (!this.S) {
            this.S = f0(this.s);
        }
    }

    public final void k0(SummaryResponseEvent summaryResponseEvent, b bVar, boolean z2) {
        List<SummaryResponse> summaryResponseList = summaryResponseEvent.getSummaryResponseList();
        boolean z3 = bVar.d.keySet().size() == 0;
        bVar.d.clear();
        Stop stop = z2 ? summaryResponseList.get(0).getStop() : null;
        for (SummaryResponse summaryResponse : summaryResponseList) {
            bVar.d.put(summaryResponse.getStop(), summaryResponse);
        }
        LatLng latLng = bVar.c;
        if (latLng != null) {
            bVar.b = latLng;
            bVar.c = null;
        }
        if (l0().equals(summaryResponseEvent.getMode())) {
            r0(z3, stop);
        }
    }

    public final TransitMode l0() {
        return ((ik0) this.u.getAdapter()).d.get(this.u.getSelectedPosition());
    }

    public final double m0(TransitMode transitMode) {
        if (transitMode == null) {
            transitMode = this.p.get(this.u.getSelectedPosition());
        }
        return transitMode.equals(TransitMode.bus) ? 1.0d : 10.0d;
    }

    public final double n0() {
        return m0(null) * 1000.0d;
    }

    public final void o0(TransitMode transitMode, LatLng latLng) {
        String str;
        b bVar = this.o.get(transitMode);
        LatLng latLng2 = bVar.c;
        LatLng latLng3 = bVar.b;
        if (this.k.d().containsLocation(latLng) && latLng2 == null && (latLng3 == null || ui1.m(latLng3, latLng) >= ((transitMode == null || transitMode.equals(TransitMode.bus)) ? 100.0d : 1000.0d))) {
            if (latLng != null) {
                String str2 = "make summary query " + transitMode;
                findViewById(R.id.stops_loading_view).setVisibility(0);
                str = this.n.e(latLng, transitMode, Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, String.valueOf(m0(transitMode)));
            } else {
                str = "";
            }
            bVar.f299a = str;
            bVar.c = latLng;
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 1010) {
            Stop stop = (Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class);
            Intent intent2 = new Intent(this, TripsSchedulesDirectionActivity.class);
            intent2.putExtra("stop_id", stop.getId());
            intent2.putExtra("stop_name", stop.getName());
            LatLng h = xt.f3961a.B().h();
            if (h != null) {
                double L2 = vn.L(h, stop.getLatLong());
                intent2.putExtra("stop_distance", ui1.q(L2));
                intent2.putExtra("stop_distance_km", L2);
            }
            intent2.putExtra("mode", stop.getMode().toString());
            startActivity(intent2);
            return;
        }
        intent.getStringExtra("result:picked_location");
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.X) {
            this.X = false;
            this.s.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            return;
        }
        ui1.F0(this.G);
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nearby_stop_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        this.H.clear();
        this.H = null;
        for (hd1 hd1 : xt.f3961a.a().b) {
            hd1.c();
        }
        xt.t1 t1Var = xt.f3961a;
        if (xt.p) {
            t0();
        } else {
            this.D.removeCallbacksAndMessages(null);
            this.A.removeCallbacks(this.P);
            this.C.quit();
        }
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            t1Var.Z().b();
            this.B = null;
        }
        super.onDestroy();
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        if (this.W && seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            if (this.T != null) {
                for (SeatInfo seatInfo : seatInfoList) {
                    String vehicleNo = seatInfo.getVehicleNo();
                    if (this.T.containsKey(vehicleNo) && this.T.get(vehicleNo).getContent().p.equals(vehicleNo)) {
                        CardItem cardItem = this.T.get(vehicleNo);
                        int seatStatus = seatInfo.getSeatStatus();
                        if (seatStatus == -1) {
                            cardItem.getSeatAvailabilityIconView().setVisibility(8);
                        } else {
                            cardItem.getSeatAvailabilityIconView().setVisibility(0);
                            cardItem.getSeatAvailabilityIconView().setImageResource(vn.v0(seatStatus));
                        }
                    }
                }
            }
            xt.f3961a.Z().c(seatInfoList, "Nearby Stops Card");
        }
    }

    public void onEventMainThread(Map<String, i10> map) {
        if (map.keySet().size() != 0 && this.M != null) {
            if (this.V == null) {
                this.V = new HashMap();
            }
            HashMap hashMap = new HashMap();
            this.U = hashMap;
            Map<String, CardItem> f = this.M.f(map, hashMap);
            this.T = f;
            boolean z2 = false;
            if (f.size() > 0) {
                xt.t1 t1Var = xt.f3961a;
                t1Var.Z().g(this.U);
                t1Var.Z().h();
                z2 = true;
            } else {
                xt.f3961a.Z().h();
                this.W = false;
            }
            if (!this.W && z2) {
                xt.t1 t1Var2 = xt.f3961a;
                t1Var2.Z().e(this.B);
                Runnable a2 = t1Var2.Z().a();
                if (a2 != null) {
                    a2.run();
                    this.W = true;
                }
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (!this.X) {
                ui1.F0(this.G);
                finish();
                return true;
            }
            this.X = false;
            this.s.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            return true;
        } else if (itemId == R.id.menu_home_schedular) {
            startActivity(new Intent(this, SchedulerActivity.class));
            return true;
        } else if (itemId != R.id.menu_stop_search) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            Intent intent = new Intent(this, PickStopActivity.class);
            intent.putExtra("extra_mode", TransitMode.ALL.toString());
            startActivityForResult(intent, 1010);
            return true;
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 123 && iArr.length > 0 && iArr[0] == 0) {
            this.I = true;
            e44 e44 = this.l;
            if (e44 != null) {
                e44.h(true);
                this.N.setMap(this.l);
                if (!vn.J0(this)) {
                    this.O.b(getString(R.string.gps_not_available_toast));
                }
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
        pc1 pc1 = this.M;
        if (pc1 != null && pc1.getStop() != null) {
            i0(this.M.getStop().getId());
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
        xt.t1 t1Var = xt.f3961a;
        if (xt.p) {
            t0();
            return;
        }
        pc1 pc1 = this.M;
        if (pc1 != null) {
            t1Var.N().d(pc1.getStop().getId()).removeEventListener(this.z);
        }
    }

    public boolean p0(Marker marker) {
        this.J = true;
        SummaryResponse summaryResponse = this.o.get(l0()).e.get(marker);
        xt.t1 t1Var = xt.f3961a;
        if (xt.p) {
            t0();
        } else {
            pc1 pc1 = this.M;
            if (pc1 != null) {
                t1Var.N().d(pc1.getStop().getId()).removeEventListener(this.z);
            }
        }
        if (summaryResponse != null) {
            this.K = summaryResponse.getStop();
            s0();
            if (this.M == null) {
                this.X = false;
                this.s.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
            pc1 pc12 = new pc1(this, summaryResponse, this.l.d().target);
            this.M = pc12;
            pc12.f(null, this.U);
            pc1 pc13 = this.M;
            this.s.setPanelHeight((int) getResources().getDimension(R.dimen.nearby_card_height));
            this.r.removeAllViews();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.home_screen_new_card, (ViewGroup) null, false);
            ((CardView) linearLayout.findViewById(R.id.card_container)).addView(pc13);
            this.r.addView(linearLayout);
            new Handler().postDelayed(new we0(this), 500);
            i0(this.M.getStop().getId());
            ed1 ed1 = new ed1("nearby stops marker click", Long.MIN_VALUE);
            ed1.a("mode", l0().name());
            ed1.a("stop", this.M.getStop().getName());
            jz5.b().g(ed1);
            ui1.t0("nearByStopsChecked");
        }
        this.W = false;
        t1Var.Z().h();
        return true;
    }

    public void q0(SummaryResponseEvent summaryResponseEvent) {
        String str;
        b bVar = this.o.get(summaryResponseEvent.getMode());
        if (bVar != null && (str = bVar.f299a) != null && str.equals(summaryResponseEvent.getRequestId())) {
            findViewById(R.id.stops_loading_view).setVisibility(8);
            if (summaryResponseEvent.getResponseType().equals(SummaryResponseEvent.ResponseType.SUCCESS)) {
                k0(summaryResponseEvent, bVar, false);
            } else {
                bVar.c = null;
            }
            jz5.b().m(summaryResponseEvent);
        }
    }

    public final void r0(boolean z2, Stop stop) {
        Float f;
        TransitMode transitMode = this.p.get(this.u.getSelectedPosition());
        if (!(this.l == null || this.L == null)) {
            for (b bVar : this.o.values()) {
                bVar.a(false);
            }
            b bVar2 = this.o.get(transitMode);
            boolean z3 = true;
            bVar2.a(true);
            for (Marker marker : bVar2.e.keySet()) {
                marker.remove();
            }
            bVar2.e.clear();
            bVar2.f.clear();
            Marker marker2 = null;
            ArrayList arrayList = new ArrayList();
            Float valueOf = Float.valueOf(this.l.d().zoom);
            for (Stop stop2 : bVar2.d.keySet()) {
                if (!bVar2.f.containsKey(stop2)) {
                    boolean z4 = valueOf.compareTo(Y) >= 0;
                    TransitMode mode = stop2.getMode();
                    if (mode == null || mode.equals(TransitMode.bus)) {
                        f = Z;
                    } else {
                        f = a0;
                    }
                    boolean z5 = valueOf.compareTo(f) <= 0;
                    e44 e44 = this.l;
                    MarkerOptions markerOptions = new MarkerOptions();
                    Stop stop3 = this.K;
                    Marker a2 = e44.a(markerOptions.icon(BitmapDescriptorFactory.fromBitmap(vn.y0(this, stop2, z4, z5, stop3 != null && stop3.getId().equals(stop2.getId())))).title(stop2.getName()).anchor(0.5f, 1.0f).position(stop2.getLatLong()));
                    bVar2.e.put(a2, bVar2.d.get(stop2));
                    bVar2.f.put(stop2, a2);
                    if (stop2.equals(stop)) {
                        marker2 = a2;
                    }
                }
                arrayList.add(stop2.getLatLong());
            }
            if (z2 && arrayList.size() != 0) {
                int dimension = (int) getResources().getDimension(R.dimen.home_map_padding);
                if (arrayList.size() == 1) {
                    e44 e442 = this.l;
                    e442.j(new eh1(e442, (LatLng) arrayList.get(0), 14.0f));
                } else {
                    e44 e443 = this.l;
                    ue0 ue0 = new ue0(this);
                    if (arrayList.size() != 0) {
                        LatLngBounds.Builder builder = new LatLngBounds.Builder();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            builder.include((LatLng) it.next());
                        }
                        e443.j(new dh1(e443, builder.build(), dimension, Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, ue0));
                    }
                    z3 = false;
                }
            }
            if (z3) {
                this.L.i.a(n0());
            }
            if (marker2 != null) {
                p0(marker2);
            }
        }
        for (String str : this.t.keySet()) {
            this.t.get(str).setVisible(false);
        }
    }

    public final void s0() {
        Marker marker;
        Float f;
        if (!(this.L == null || this.l == null)) {
            Map<Stop, Marker> map = this.o.get(this.p.get(this.u.getSelectedPosition())).f;
            Float valueOf = Float.valueOf(this.l.d().zoom);
            if (map != null) {
                for (Stop stop : map.keySet()) {
                    if (!(stop == null || (marker = map.get(stop)) == null)) {
                        boolean z2 = false;
                        boolean z3 = valueOf.compareTo(Y) >= 0;
                        TransitMode mode = stop.getMode();
                        if (mode == null || mode.equals(TransitMode.bus)) {
                            f = Z;
                        } else {
                            f = a0;
                        }
                        boolean z4 = valueOf.compareTo(f) <= 0;
                        Stop stop2 = this.K;
                        if (stop2 != null && stop2.getId().equals(stop.getId())) {
                            z2 = true;
                        }
                        marker.setIcon(BitmapDescriptorFactory.fromBitmap(vn.y0(this, stop, z3, z4, z2)));
                    }
                }
            }
            this.L.i.a(n0());
        }
    }

    public final void t0() {
        Iterator<Map.Entry<String, Integer>> it = this.R.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            xt.f3961a.O().l(next.getKey(), next.getValue().intValue());
            it.remove();
        }
    }

    public void onEvent(SummaryResponseEvent summaryResponseEvent) {
        q0(summaryResponseEvent);
    }

    public void onEventMainThread(TrainSummaryResponseEvent trainSummaryResponseEvent) {
        q0(trainSummaryResponseEvent);
    }

    public void onEvent(qd1 qd1) {
        j0();
    }

    public void onEventMainThread(BusSummaryResponseEvent busSummaryResponseEvent) {
        q0(busSummaryResponseEvent);
    }

    public void onEventMainThread(MetroSummaryResponseEvent metroSummaryResponseEvent) {
        q0(metroSummaryResponseEvent);
    }

    public void onEventMainThread(MonorailSummaryResponseEvent monorailSummaryResponseEvent) {
        q0(monorailSummaryResponseEvent);
    }

    public void onEventMainThread(qd1 qd1) {
        j0();
    }
}
