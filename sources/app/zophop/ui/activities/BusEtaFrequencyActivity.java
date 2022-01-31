package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.DataInfo;
import app.zophop.models.EtaModel;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.VehicleInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.DatabaseConnectionEvent;
import app.zophop.pubsub.eventbus.events.FirebaseEtaUpdateEvent;
import app.zophop.pubsub.eventbus.events.FirebaseRouteUpdateEvent;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.pubsub.eventbus.events.StopListenerEvent;
import com.google.gson.Gson;
import defpackage.mt0;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BusEtaFrequencyActivity extends fe0 {
    public static List<EtaModel> E;
    public static List<String> F;
    public static LiveRouteData G;
    public static List<EtaModel> H;
    public static Map<Long, String> I;
    public List<SeatInfo> A;
    public List<VehicleInfo> B;
    public Map<String, Integer> C;
    public final ci1<Boolean> D = new a();
    public Route m;
    public Stop n;
    public boolean o;
    public ListView p;
    public yi0 q;
    public Runnable r;
    public Runnable s;
    public Handler t;
    public TextView u;
    public List<DataInfo> v;
    public String w;
    public boolean x = false;
    public String y;
    public boolean z = false;

    public class a implements ci1<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Boolean bool) {
            BusEtaFrequencyActivity busEtaFrequencyActivity = BusEtaFrequencyActivity.this;
            Objects.requireNonNull(busEtaFrequencyActivity);
            gw0.d(busEtaFrequencyActivity.getSupportFragmentManager(), busEtaFrequencyActivity, new zc0(busEtaFrequencyActivity), BusEtaFrequencyActivity.class.getSimpleName());
        }
    }

    public static List k0(BusEtaFrequencyActivity busEtaFrequencyActivity, List list) {
        Objects.requireNonNull(busEtaFrequencyActivity);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            EtaModel etaModel = (EtaModel) list.get(i);
            arrayList.add(new VehicleInfo(etaModel.get_vehicleNumber(), System.currentTimeMillis() + ((long) etaModel.get_eta().intValue())));
        }
        return arrayList;
    }

    public static Map<Integer, Long> l0(List<i10> list, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = list.get(i2).f1460a;
            long j = list.get(i2).c;
            if (i > 0 && i3 != -1 && x61.s(i3)) {
                i--;
                linkedHashMap.put(Integer.valueOf(i3), Long.valueOf(j));
            }
        }
        return linkedHashMap;
    }

    public static void n0(Context context, List<EtaModel> list, Map<Long, String> map, Route route, Stop stop, boolean z2, LiveRouteData liveRouteData) {
        Intent intent = new Intent(context, BusEtaFrequencyActivity.class);
        Gson gson = new Gson();
        H = list;
        I = map;
        G = liveRouteData;
        intent.putExtra("route", gson.toJson(route));
        intent.putExtra("selectedStopName", gson.toJson(stop));
        intent.putExtra("isFirstStop", z2);
        context.startActivity(intent);
    }

    @Override // defpackage.fe0
    public void init() {
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
        Intent intent = getIntent();
        intent.getStringExtra("directionStopName");
        String stringExtra = getIntent().getStringExtra("selectedStopName");
        String stringExtra2 = getIntent().getStringExtra("route");
        if (stringExtra2 != null) {
            this.m = (Route) hj1.s(stringExtra2, Route.class);
        }
        if (stringExtra != null) {
            this.n = (Stop) hj1.s(stringExtra, Stop.class);
        }
        this.o = intent.getBooleanExtra("isFirstStop", false);
        this.C = new HashMap();
        i0();
    }

    @Override // defpackage.fe0
    public void j0() {
        setContentView(R.layout.bus_eta_list);
        setSupportActionBar((Toolbar) findViewById(R.id.eta_list_toolbar));
        getSupportActionBar().z(this.m.getRouteName());
        x supportActionBar = getSupportActionBar();
        StringBuilder i0 = hj1.i0("To ");
        i0.append(this.m.getDirectionStop().getName());
        supportActionBar.x(i0.toString());
        getSupportActionBar().o(true);
        getSupportActionBar().t(R.drawable.ic_arrow_back_black_24dp);
        StringBuilder i02 = hj1.i0("Arriving at ");
        i02.append(this.n.getName());
        ((TextView) findViewById(R.id.stop_name)).setText(i02.toString());
        this.p = (ListView) findViewById(R.id.eta_list);
        this.u = (TextView) findViewById(R.id.empty_view);
        yi0 yi0 = new yi0(this, this.o, H, I, this.D);
        this.q = yi0;
        this.p.setAdapter((ListAdapter) yi0);
    }

    public final List<EtaModel> m0(List<i10> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).g;
            int i2 = list.get(i).f1460a;
            arrayList.add(new EtaModel(str, Integer.valueOf(i2), list.get(i).c, list.get(i).h));
        }
        return arrayList;
    }

    public final boolean o0(DataInfo dataInfo) {
        StreamInfo streamInfo = (StreamInfo) dataInfo;
        String nextStopId = streamInfo.getNextStopId();
        int i = 0;
        while (true) {
            if (i >= this.m.getStopSequence().size()) {
                i = -1;
                break;
            } else if (this.m.getStopSequence().get(i).getId().equals(nextStopId)) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i - 1;
        if (i2 >= 0) {
            i = i2;
        }
        if (!vn.R0(streamInfo.getTimeStamp(), streamInfo.getOriginalEtaSec(), true) && i >= 0) {
            return true;
        }
        return false;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        Runnable runnable = this.r;
        if (runnable != null) {
            this.t.removeCallbacks(runnable);
            this.x = false;
        }
        Runnable runnable2 = this.s;
        if (runnable2 != null) {
            this.t.removeCallbacks(runnable2);
        }
        xt.t1 t1Var = xt.f3961a;
        t1Var.u().a(this.w);
        t1Var.u().a(this.y);
        jz5.b().o(this);
        super.onDestroy();
    }

    public void onEvent(DatabaseConnectionEvent databaseConnectionEvent) {
        if (!databaseConnectionEvent.isConnected()) {
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.t().b("firebasePollingEnabled")) {
                m20 u2 = t1Var.u();
                String id = this.n.getId();
                String lowerCase = t1Var.k().d().getDisplayName().toLowerCase();
                Uri.Builder builder = new Uri.Builder();
                builder.encodedPath(ut.q).appendEncodedPath("eta").appendEncodedPath(lowerCase).appendEncodedPath(this.m.getRouteId()).appendEncodedPath(id);
                this.w = u2.b(builder.build().toString(), "eta");
                m20 u3 = t1Var.u();
                String routeId = this.m.getRouteId();
                String lowerCase2 = t1Var.k().d().getDisplayName().toLowerCase();
                Uri.Builder builder2 = new Uri.Builder();
                builder2.encodedPath(ut.q).appendEncodedPath("route").appendEncodedPath(lowerCase2).appendEncodedPath(routeId);
                this.y = u3.b(builder2.build().toString(), "route");
                this.t.removeCallbacksAndMessages(null);
                this.x = false;
                return;
            }
        }
        xt.t1 t1Var2 = xt.f3961a;
        t1Var2.u().a(this.w);
        t1Var2.u().a(this.y);
    }

    public void onEventMainThread(LiveRouteData liveRouteData) {
        jz5.b().m(this);
        G = liveRouteData;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        super.onPause();
        for (String str : this.C.keySet()) {
            xt.f3961a.O().l(str, this.C.get(str).intValue());
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        this.t = new Handler();
        if (this.m.getSeatAvailability() != 0) {
            G.getFirebaseStreams().size();
            this.s = new xc0(this, this.n, G.getFirebaseStreams().size(), this.m.getSeatAvailability());
        }
        xt.t1 t1Var = xt.f3961a;
        if (!xt.p) {
            t1Var.N().h();
            yc0 yc0 = new yc0(this, this.n);
            this.r = yc0;
            if (!this.x) {
                this.t.post(yc0);
                this.x = true;
                return;
            }
            return;
        }
        String v2 = vn.v("etas", this.n.getId(), this.m.getRouteId());
        this.C.put(v2, Integer.valueOf(t1Var.O().k(v2, new vc0(this))));
        this.C.put(vn.u(ProductDiscountsObject.KEY_ROUTES, this.m.getRouteId()), Integer.valueOf(t1Var.O().k(vn.u(ProductDiscountsObject.KEY_ROUTES, this.m.getRouteId()), new wc0(this))));
    }

    public void onEvent(FirebaseRouteUpdateEvent firebaseRouteUpdateEvent) {
        if (firebaseRouteUpdateEvent.get_requestId() == this.y && G != null) {
            if (firebaseRouteUpdateEvent.get_responseType().equals(ad1.SUCCESS)) {
                List<StreamInfo> list = firebaseRouteUpdateEvent.get_streamInfoList();
                ArrayList arrayList = new ArrayList();
                G.clearStreams();
                for (StreamInfo streamInfo : list) {
                    if (o0(streamInfo)) {
                        arrayList.add(streamInfo);
                        G.addStreamInfo(streamInfo);
                    }
                }
                if (arrayList.size() <= 0 || !vn.K0(this)) {
                    G.setFirebaseResponse(mt0.h.FAILED);
                } else {
                    G.setFirebaseResponse(mt0.h.SUCCESS);
                }
            } else if (firebaseRouteUpdateEvent.get_responseType().equals(ad1.FAILED)) {
                G.setFirebaseResponse(mt0.h.FAILED);
            }
        }
    }

    public void onEvent(StopListenerEvent stopListenerEvent) {
        if (this.n.getId().equalsIgnoreCase(stopListenerEvent.get_stopId())) {
            this.v = new ArrayList();
            List<DataInfo> list = stopListenerEvent.get_dataInfo();
            this.v = list;
            j10 h = ii1.h(list, G.getFirebaseStreams(), this.n.getLatLong());
            List<i10> c = h.c();
            Map<Integer, Long> l0 = l0(c, c.size());
            List<EtaModel> m0 = m0(c);
            List<i10> b = h.b();
            LinkedHashMap linkedHashMap = new LinkedHashMap(b.size());
            for (int i = 0; i < b.size(); i++) {
                linkedHashMap.put(Long.valueOf(b.get(i).c), ui1.R(b.get(i).e, b.get(i).f));
            }
            if (l0.size() == 0 && linkedHashMap.size() == 0) {
                this.u.setVisibility(0);
                this.p.setVisibility(8);
                return;
            }
            this.u.setVisibility(8);
            this.p.setVisibility(0);
            yi0 yi0 = this.q;
            yi0.g = linkedHashMap;
            yi0.h = m0;
            yi0.notifyDataSetChanged();
            this.q.notifyDataSetChanged();
        }
    }

    public void onEvent(FirebaseEtaUpdateEvent firebaseEtaUpdateEvent) {
        if (firebaseEtaUpdateEvent.get_requestId() == this.w && G != null && firebaseEtaUpdateEvent.get_responseType().equals(ad1.SUCCESS)) {
            this.v = new ArrayList();
            List<DataInfo> list = firebaseEtaUpdateEvent.get_etaInfoList();
            this.v = list;
            j10 h = ii1.h(list, G.getFirebaseStreams(), this.n.getLatLong());
            List<i10> c = h.c();
            Map<Integer, Long> l0 = l0(c, c.size());
            List<EtaModel> m0 = m0(c);
            List<i10> b = h.b();
            LinkedHashMap linkedHashMap = new LinkedHashMap(b.size());
            for (int i = 0; i < b.size(); i++) {
                linkedHashMap.put(Long.valueOf(b.get(i).c), ui1.R(b.get(i).e, b.get(i).f));
            }
            if (l0.size() == 0 && linkedHashMap.size() == 0) {
                this.u.setVisibility(0);
                this.p.setVisibility(8);
                return;
            }
            this.u.setVisibility(8);
            this.p.setVisibility(0);
            yi0 yi0 = this.q;
            yi0.g = linkedHashMap;
            yi0.h = m0;
            yi0.notifyDataSetChanged();
            this.q.notifyDataSetChanged();
        }
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        jz5.b().m(seatAvailabilityStatusEvent);
        if (seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            this.A = seatInfoList;
            if (seatInfoList != null) {
                for (int i = 0; i < this.A.size(); i++) {
                    ed1 ed1 = new ed1("seat status", Long.MIN_VALUE);
                    SeatInfo seatInfo = this.A.get(i);
                    ed1.a("vehicle no", seatInfo.getVehicleNo());
                    ed1.a("seat status", Integer.valueOf(seatInfo.getSeatStatus()));
                    ed1.a("route id", this.m.getRouteId());
                    ed1.a("route name", this.m.getRouteName());
                    ed1.a("seat occupancy api mode", Integer.valueOf(this.m.getSeatAvailability()));
                    ed1.a("time", Long.valueOf(System.currentTimeMillis()));
                    jz5.b().g(ed1);
                }
            }
            yi0 yi0 = this.q;
            yi0.k = this.A;
            yi0.notifyDataSetChanged();
        }
    }
}
