package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.EtaModel;
import app.zophop.models.FrequencyRoute;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.BusEtaFrequencyActivity;
import app.zophop.ui.fragments.BusFrequencyActivity;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import defpackage.ii1;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* renamed from: bw0  reason: default package */
/* compiled from: RouteMapFragment */
public class bw0 extends ev0 {
    public bc1 A;
    public Route w;
    public List<Stop> x;
    public final HashMap<Marker, View> y = new HashMap<>();
    public LiveRouteData z;

    @Override // defpackage.e44.e
    public void a(Marker marker) {
        bc1 bc1 = (bc1) this.y.get(marker);
        if (bc1 == null || !(!bc1.i.h(bc1.f).d.equals(ii1.a.EnumC0027a.SUCCESS))) {
            if (bc1 != null && !(true ^ bc1.i.h(bc1.f).d.equals(ii1.a.EnumC0027a.SUCCESS))) {
                Stop m = m(this.i.get(marker).intValue());
                if (bc1.r != null) {
                    bc1.v.removeCallbacks(bc1.u);
                    Context context = bc1.getContext();
                    List<EtaModel> list = bc1.o;
                    List<String> list2 = bc1.s;
                    o61 o61 = bc1.t;
                    int size = bc1.r.size();
                    Objects.requireNonNull(o61);
                    ArrayList arrayList = new ArrayList();
                    int size2 = o61.f2654a.size();
                    while (true) {
                        size--;
                        if (size < 0 || size >= size2) {
                            Route route = bc1.h;
                            boolean d = bc1.d();
                            LiveRouteData liveRouteData = bc1.p;
                            List<EtaModel> list3 = BusEtaFrequencyActivity.E;
                            Intent intent = new Intent(context, BusEtaFrequencyActivity.class);
                            Gson gson = new Gson();
                            BusEtaFrequencyActivity.E = list;
                            BusEtaFrequencyActivity.F = list2;
                            BusEtaFrequencyActivity.G = liveRouteData;
                            intent.putExtra("route", gson.toJson(route));
                            intent.putExtra("selectedStopName", gson.toJson(m));
                            intent.putExtra("isFirstStop", d);
                            context.startActivity(intent);
                            Route route2 = bc1.h;
                            ed1 ed1 = new ed1("eta screen open", Long.MIN_VALUE);
                            ed1.a("route id", route2.getRouteId());
                            ed1.a("route name", route2.getRouteName());
                            ed1.a("stop name", m.getName());
                            ed1.a("stop id", m.getId());
                            jz5.b().g(ed1);
                        } else {
                            arrayList.add(o61.f2654a.get(size));
                        }
                    }
                    Route route3 = bc1.h;
                    boolean d2 = bc1.d();
                    LiveRouteData liveRouteData2 = bc1.p;
                    List<EtaModel> list32 = BusEtaFrequencyActivity.E;
                    Intent intent2 = new Intent(context, BusEtaFrequencyActivity.class);
                    Gson gson2 = new Gson();
                    BusEtaFrequencyActivity.E = list;
                    BusEtaFrequencyActivity.F = list2;
                    BusEtaFrequencyActivity.G = liveRouteData2;
                    intent2.putExtra("route", gson2.toJson(route3));
                    intent2.putExtra("selectedStopName", gson2.toJson(m));
                    intent2.putExtra("isFirstStop", d2);
                    context.startActivity(intent2);
                    Route route22 = bc1.h;
                    ed1 ed12 = new ed1("eta screen open", Long.MIN_VALUE);
                    ed12.a("route id", route22.getRouteId());
                    ed12.a("route name", route22.getRouteName());
                    ed12.a("stop name", m.getName());
                    ed12.a("stop id", m.getId());
                    jz5.b().g(ed12);
                }
            }
        } else if (!ui1.f0(this.w)) {
            q(false);
        } else {
            BusFrequencyActivity.l0(getActivity(), this.w);
            q(true);
        }
    }

    @Override // defpackage.e44.b
    public View b(Marker marker) {
        if (l(marker) != -1) {
            if (!this.y.containsKey(marker)) {
                this.y.put(marker, new bc1(getActivity(), m(this.i.get(marker).intValue()), this.w, marker));
            }
            bc1 bc1 = (bc1) this.y.get(marker);
            bc1.i(this.z, false);
            if (!marker.isInfoWindowShown()) {
                xt.t1 t1Var = xt.f3961a;
                if (xt.p) {
                    bc1.f();
                } else {
                    bc1.e();
                }
            }
            this.A = bc1;
            return bc1;
        } else if (ui1.Y() || ui1.X()) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.info_window, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.vehicle_number)).setText(this.q.get(marker).getVehicleNumber());
            return inflate;
        } else {
            ut.a aVar = ut.f3552a;
            return null;
        }
    }

    @Override // defpackage.e44.f
    public void c(Marker marker) {
        if (this.y.containsKey(marker)) {
            ((bc1) this.y.get(marker)).h();
            this.A = null;
        }
    }

    @Override // defpackage.e44.b
    public View d(Marker marker) {
        return null;
    }

    @Override // defpackage.ev0
    public int h() {
        return this.x.size();
    }

    @Override // defpackage.ev0
    public TransitMode j() {
        return this.w.getMode();
    }

    @Override // defpackage.ev0
    public String k() {
        return this.w.getPolyline();
    }

    @Override // defpackage.ev0
    public Stop m(int i) {
        return this.x.get(i);
    }

    @Override // defpackage.ev0
    public Stop n(String str) {
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i).getId().equalsIgnoreCase(str)) {
                return this.x.get(i);
            }
        }
        return null;
    }

    @Override // defpackage.ev0
    public void o(Bundle bundle) {
        if (bundle != null && bundle.containsKey("extra:route")) {
            Route route = (Route) hj1.s(bundle.getString("extra:route"), FrequencyRoute.class);
            this.w = route;
            this.x = route.getStopSequence();
            this.m = this.w.getRouteId();
            this.z = new LiveRouteData(this.w);
        }
    }

    @Override // defpackage.ev0
    public void onEventMainThread(LiveRouteData liveRouteData) {
        jz5.b().m(this);
        if (liveRouteData.getRoute().getRouteId().equals(this.m)) {
            super.onEventMainThread(liveRouteData);
            this.z = liveRouteData;
            bc1 bc1 = this.A;
            if (bc1 != null) {
                bc1.i(liveRouteData, true);
            }
        }
    }

    @Override // com.google.android.gms.maps.MapFragment, defpackage.ev0
    public void onStart() {
        super.onStart();
        bc1 bc1 = this.A;
        if (bc1 != null) {
            xt.t1 t1Var = xt.f3961a;
            if (xt.p) {
                bc1.f();
            } else {
                bc1.e();
            }
        }
    }

    @Override // com.google.android.gms.maps.MapFragment, defpackage.ev0
    public void onStop() {
        super.onStop();
        bc1 bc1 = this.A;
        if (bc1 != null) {
            bc1.h();
        }
    }

    public final void q(boolean z2) {
        ed1 l = hj1.l("view schedule clicked", Long.MIN_VALUE, "source", "route details map");
        l.a("isTimetableAvailable", String.valueOf(z2));
        jz5.b().g(l);
    }
}
