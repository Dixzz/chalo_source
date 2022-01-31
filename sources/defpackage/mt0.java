package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.DataInfo;
import app.zophop.models.EtaUpdateInfo;
import app.zophop.models.LiveRouteData;
import app.zophop.models.ReportProblemImpl;
import app.zophop.models.Route;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.TimeInterval;
import app.zophop.pubsub.eventbus.events.FirebaseEtaUpdateEvent;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import app.zophop.pubsub.eventbus.events.ReportProblemClickEvent;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.pubsub.eventbus.events.StopSearchedEvent;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.utils.FrequencyRouteHelper;
import app.zophop.ui.views.summary_card.RouteListCardItem;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.appindexing.Indexable;
import defpackage.gn0;
import defpackage.ii1;
import defpackage.xt;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import server.zophop.logging.LoggingConstants;

/* renamed from: mt0  reason: default package */
/* compiled from: BusRouteFragment */
public class mt0 extends Fragment implements FrequencyRouteHelper.c {
    public static final /* synthetic */ int R = 0;
    public boolean A;
    public boolean B = false;
    public List<SeatInfo> C;
    public int D;
    public boolean E = true;
    public String F;
    public List<DataInfo> G;
    public int H;
    public boolean I;
    public String J;
    public long K;
    public Stop L;
    public Runnable M;
    public Runnable N;
    public final ci1<Stop> O = new e();
    public final ci1<Boolean> P = new f();
    public final ci1<Boolean> Q = new g();
    public List<Stop> f;
    public Route g;
    public dk0 h;
    public Stop i;
    public Stop j;
    public Stop k;
    public String l;
    public String m;
    public View n;
    public Handler o;
    public ListView p;
    public String q;
    public LiveRouteData r;
    public TextView s;
    public List<Route.RouteTiming> t;
    public Stop u;
    public final Set<String> v = new HashSet();
    public final Set<String> w = new HashSet();
    public boolean x;
    public boolean y;
    public int z = 500;

    /* renamed from: mt0$a */
    /* compiled from: BusRouteFragment */
    public class a implements ji1<Object, String> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            b00 b00 = b00.f358a;
            hj1.Q0(str, b00.a());
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x020e  */
        /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
        @Override // defpackage.ji1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(java.lang.Object r14) {
            /*
            // Method dump skipped, instructions count: 564
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.mt0.a.onSuccess(java.lang.Object):void");
        }
    }

    /* renamed from: mt0$b */
    /* compiled from: BusRouteFragment */
    public class b implements ji1<j10, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f2439a;
        public final /* synthetic */ Stop b;

        public b(boolean z, Stop stop) {
            this.f2439a = z;
            this.b = stop;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            String str2;
            Stop stop;
            String str3 = str;
            if (this.f2439a && mt0.this.getActivity() != null && mt0.this.isAdded()) {
                mt0 mt0 = mt0.this;
                Stop stop2 = this.b;
                int i = mt0.R;
                if (!mt0.f(stop2) || (stop = mt0.this.L) == null || !stop.equals(this.b)) {
                    h firebaseResponse = mt0.this.r.getFirebaseResponse();
                    h hVar = h.WAITING;
                    if (!firebaseResponse.equals(hVar)) {
                        String str4 = null;
                        if (!mt0.this.r.getFirebaseResponse().equals(h.SUCCESS) || !vn.K0(mt0.this.getActivity())) {
                            mt0.this.m(this.b);
                            if (!mt0.this.r.isLiveFeedProvider() || !mt0.this.r.getLiveFeedResponse().equals(hVar)) {
                                mt0.this.i();
                                str4 = "not available";
                            }
                        } else {
                            if (str3.equals("all_max_etas")) {
                                mt0.this.n(ii1.a.EnumC0027a.NOT_ARRIVING_SOON, this.b, null);
                                str2 = "not arriving soon";
                            } else {
                                if (str3.equals("no_etas")) {
                                    mt0.this.n(ii1.a.EnumC0027a.PASSED, this.b, null);
                                    str2 = "bus passed";
                                }
                                mt0.this.i();
                            }
                            str4 = str2;
                            mt0.this.i();
                        }
                        Stop stop3 = mt0.this.u;
                        if (stop3 == null || !stop3.equals(this.b)) {
                            mt0 mt02 = mt0.this;
                            mt02.u = this.b;
                            if (str4 != null) {
                                ui1.p0(mt02.g.getRouteName(), mt0.this.g.getMode().toString(), mt0.this.L.getName(), false, "list view", str4, String.valueOf(0L), mt0.this.r.getLastSeenInfo().getVehicleNumber(), null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                List<EtaUpdateInfo> list = mt0.this.r.getLiveFeedEtaUpdateInfoMap().get(this.b.getId());
                mt0 mt03 = mt0.this;
                dk0 dk0 = mt03.h;
                LiveRouteData liveRouteData = mt03.r;
                dk0.w = liveRouteData;
                x61 x61 = dk0.k;
                if (x61 != null) {
                    x61.c = liveRouteData;
                }
                dk0.g(this.b, list);
                mt0.this.h.notifyDataSetChanged();
                Stop stop4 = mt0.this.u;
                if (stop4 == null || !stop4.equals(this.b)) {
                    mt0 mt04 = mt0.this;
                    mt04.u = this.b;
                    ui1.p0(mt04.g.getRouteName(), mt0.this.g.getMode().toString(), mt0.this.L.getName(), true, "list view", "eta shown", String.valueOf(0L), mt0.this.r.getLastSeenInfo().getVehicleNumber(), null);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0213  */
        /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
        @Override // defpackage.ji1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(defpackage.j10 r12) {
            /*
            // Method dump skipped, instructions count: 569
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.mt0.b.onSuccess(java.lang.Object):void");
        }
    }

    /* renamed from: mt0$c */
    /* compiled from: BusRouteFragment */
    public class c implements Runnable {
        public final /* synthetic */ int f;

        public c(int i) {
            this.f = i;
        }

        public void run() {
            mt0.this.p.requestFocusFromTouch();
            mt0.this.p.setSelection(this.f);
            mt0.this.p.requestFocus();
        }
    }

    /* renamed from: mt0$d */
    /* compiled from: BusRouteFragment */
    public class d implements gn0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Stop f2440a;

        public d(Stop stop) {
            this.f2440a = stop;
        }
    }

    /* renamed from: mt0$e */
    /* compiled from: BusRouteFragment */
    public class e implements ci1<Stop> {
        public e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Stop stop) {
            String str;
            Set<String> set;
            int i;
            Stop stop2 = stop;
            if (mt0.this.getActivity() instanceof RouteDetailsActivity) {
                ev0 ev0 = ((RouteDetailsActivity) mt0.this.getActivity()).r;
                String id = stop2.getId();
                if (!(ev0.t == null || (i = ev0.u) == 0 || i == ev0.h() - 1)) {
                    ev0.t.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.stop_marker_route_details));
                    ev0.t.setAnchor(0.5f, 0.5f);
                }
                Marker marker = ev0.j.containsKey(id) ? ev0.j.get(id) : null;
                ev0.t = marker;
                int l = ev0.l(marker);
                ev0.u = l;
                if (!(ev0.t == null || l == 0 || l == ev0.h() - 1)) {
                    ev0.t.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bus_nearby_selected));
                    ev0.t.setAnchor(0.5f, 1.0f);
                }
            }
            mt0 mt0 = mt0.this;
            mt0.B = false;
            mt0.I = false;
            Runnable runnable = mt0.N;
            if (runnable != null) {
                mt0.o.removeCallbacks(runnable);
            }
            xt.t1 t1Var = xt.f3961a;
            f40 O = t1Var.O();
            mt0 mt02 = mt0.this;
            O.l(mt02.J, mt02.H);
            mt0 mt03 = mt0.this;
            if (!(mt03.g == null || stop2 == null || (set = mt03.v) == null || set.contains(stop2.getId()))) {
                t1Var.N().j(stop2.getId(), mt0.this.g.getRouteId(), true);
                mt0.this.v.add(stop2.getId());
            }
            sf1 l2 = t1Var.l();
            Objects.requireNonNull(mt0.this);
            l2.put("BusRouteFragment:RealTimeInfoBanner", String.valueOf(true));
            if (!mt0.this.r.isLiveFeedProvider() || !mt0.this.r.getLiveFeedResponse().equals(h.SUCCESS)) {
                mt0 mt04 = mt0.this;
                mt04.g();
                Runnable runnable2 = mt04.N;
                if (runnable2 != null) {
                    mt04.o.removeCallbacks(runnable2);
                }
                h firebaseResponse = mt04.r.getFirebaseResponse();
                if (mt04.getActivity() instanceof RouteDetailsActivity) {
                    mt04.E = ((RouteDetailsActivity) mt04.getActivity()).B;
                }
                mt04.N = new ot0(mt04, stop2, mt04.g.getSeatAvailability());
                if (xt.p) {
                    mt04.L = stop2;
                    if (stop2 != null) {
                        mt04.a();
                    }
                } else if (mt04.E || !t1Var.t().b("firebasePollingEnabled")) {
                    if (firebaseResponse.equals(h.SUCCESS) || firebaseResponse.equals(h.WAITING)) {
                        mt04.L = stop2;
                        nt0 nt0 = new nt0(mt04, stop2);
                        mt04.M = nt0;
                        mt04.o.post(nt0);
                    } else {
                        h hVar = h.FAILED;
                        if (firebaseResponse.equals(hVar)) {
                            if (!mt04.r.isLiveFeedProvider() || mt04.r.getLiveFeedResponse().equals(hVar)) {
                                mt04.L = stop2;
                                mt04.n(ii1.a.EnumC0027a.FAILURE, stop2, null);
                            }
                            Stop stop3 = mt04.u;
                            if (stop3 == null || !stop3.equals(stop2)) {
                                mt04.u = stop2;
                                mt04.L = stop2;
                                ui1.p0(mt04.g.getRouteName(), mt04.g.getMode().toString(), mt04.L.getName(), true, "list view", "not available", null, null, null);
                            }
                        }
                    }
                    t1Var.u().c("eta");
                } else {
                    mt04.L = stop2;
                    t1Var.u().c("eta");
                    mt04.F = t1Var.u().b(mt04.c(stop2.getId()), "eta");
                    mt04.g();
                }
            } else {
                List<EtaUpdateInfo> list = mt0.this.r.getLiveFeedEtaUpdateInfoMap().get(stop2.getId());
                mt0 mt05 = mt0.this;
                mt05.L = stop2;
                mt05.h.g(stop2, list);
                mt0.this.g();
                if (list.size() != 0) {
                    mt0.this.h.g(stop2, list);
                    ui1.t0("realTimeEtaInfoSeen");
                    t1Var.l().put("real_time_info_seen", String.valueOf(true));
                    str = "eta seen";
                } else {
                    mt0.this.i();
                    mt0.this.n(ii1.a.EnumC0027a.FAILURE, stop2, null);
                    str = "not available";
                }
                Stop stop4 = mt0.this.u;
                if (stop4 == null || !stop4.equals(stop2)) {
                    mt0 mt06 = mt0.this;
                    mt06.u = stop2;
                    ui1.p0(mt06.g.getRouteName(), mt0.this.g.getMode().toString(), mt0.this.L.getName(), true, "list view", str, String.valueOf(mt0.this.r.getLastSeenInfo().getLastSeen()), mt0.this.r.getLastSeenInfo().getVehicleNumber(), null);
                }
            }
        }
    }

    /* renamed from: mt0$f */
    /* compiled from: BusRouteFragment */
    public class f implements ci1<Boolean> {
        public f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Boolean bool) {
            mt0 mt0 = mt0.this;
            Objects.requireNonNull(mt0);
            gw0.d(((ve) mt0.getActivity()).getSupportFragmentManager(), mt0.getActivity(), new pt0(mt0), RouteDetailsActivity.class.getSimpleName());
        }
    }

    /* renamed from: mt0$g */
    /* compiled from: BusRouteFragment */
    public class g implements ci1<Boolean> {
        public g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ci1
        public void a(Boolean bool) {
            FragmentTransaction beginTransaction = mt0.this.getFragmentManager().beginTransaction();
            Fragment findFragmentByTag = mt0.this.getFragmentManager().findFragmentByTag("dialog");
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.addToBackStack(null);
            mt0.this.getActivity();
            hn0.l = (int) mt0.this.g.getAvailabilityStatus();
            hn0 hn0 = new hn0();
            Bundle bundle = new Bundle();
            bundle.putInt("status", hn0.l);
            hn0.setArguments(bundle);
            hn0.show(beginTransaction, "dialog");
        }
    }

    /* renamed from: mt0$h */
    /* compiled from: BusRouteFragment */
    public enum h {
        SUCCESS,
        FAILED,
        WAITING
    }

    public final void a() {
        if (!this.I) {
            this.I = true;
            this.J = vn.v("etas", this.L.getId(), this.g.getRouteId());
            this.H = xt.f3961a.O().k(this.J, new a());
        }
    }

    public final void b(Stop stop, boolean z2) {
        if (stop != null) {
            xt.f3961a.N().c(stop, this.g.getRouteId(), this.r.getFirebaseStreams(), new b(z2, stop));
            return;
        }
        n(ii1.a.EnumC0027a.FAILURE, stop, null);
        i();
    }

    public final String c(String str) {
        String lowerCase = xt.f3961a.k().d().getDisplayName().toLowerCase();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.q).appendEncodedPath("eta").appendEncodedPath(lowerCase).appendEncodedPath(this.g.getRouteId()).appendEncodedPath(str);
        return builder.build().toString();
    }

    public final void d(Stop stop) {
        l();
        i();
        n(ii1.a.EnumC0027a.FAILURE, stop, null);
    }

    public final void e() {
        z30 N2 = xt.f3961a.N();
        String routeId = this.g.getRouteId();
        ut0 ut0 = new ut0(this);
        if (!vn.K0(N2.g)) {
            ut0.a("no_internet");
        } else {
            N2.c.child(N2.f.d().getName().toUpperCase()).child(routeId).addListenerForSingleValueEvent(new a40(N2, ut0));
        }
    }

    public final boolean f(Stop stop) {
        return this.r.isLiveFeedProvider() && this.r.getLiveFeedResponse().equals(h.SUCCESS) && this.r.getLiveFeedEtaUpdateInfoMap().get(stop.getId()).size() != 0;
    }

    public final void g() {
        Runnable runnable = this.M;
        if (runnable != null) {
            this.o.removeCallbacks(runnable);
        }
    }

    public void h() {
        int size = this.f.size();
        String name = this.f.get(0).getName();
        String name2 = this.f.get(size - 1).getName();
        String transitMode = this.g.getMode().toString();
        String routeName = this.g.getRouteName();
        boolean f0 = ui1.f0(this.g);
        if (this.r.isLiveFeedProvider()) {
            h liveFeedResponse = this.r.getLiveFeedResponse();
            if (liveFeedResponse.equals(h.SUCCESS)) {
                ui1.o0(routeName, name, name2, transitMode, this.q, true, this.l, this.g.getAgencyName(), f0);
            } else if (liveFeedResponse.equals(h.FAILED)) {
                ui1.o0(routeName, name, name2, transitMode, this.q, false, this.l, this.g.getAgencyName(), f0);
            }
        } else if (this.r.getFirebaseResponse().equals(h.SUCCESS)) {
            ui1.o0(routeName, name, name2, transitMode, this.q, true, this.l, this.g.getAgencyName(), f0);
        } else {
            ui1.o0(routeName, name, name2, transitMode, this.q, false, this.l, this.g.getAgencyName(), f0);
        }
    }

    public final void i() {
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.l().h.has("real_time_info_seen")) {
            HashMap hashMap = new HashMap();
            hashMap.put("realTimeEtaInfoSeen", String.valueOf(false));
            t1Var.a().b(hashMap);
            t1Var.a().a(hashMap);
        }
    }

    public final void j() {
        if (this.r.getLiveFeedResponse().equals(h.WAITING)) {
            h();
        }
    }

    public final void k() {
        String A2 = ui1.A(this.r.getLastSeenInfo().getLastSeen(), getActivity());
        this.s.setVisibility(8);
        ui1.w0(getActivity(), this.s, A2, R.color.black_87);
    }

    public final void l() {
        if (this.L != null) {
            i();
            n(ii1.a.EnumC0027a.FAILURE, this.L, null);
        }
    }

    public final void m(Stop stop) {
        if (!this.r.isLiveFeedProvider() || !this.r.getLiveFeedResponse().equals(h.WAITING)) {
            n(ii1.a.EnumC0027a.FAILURE, stop, null);
            i();
        }
    }

    public void n(ii1.a.EnumC0027a aVar, Stop stop, j10 j10) {
        Stop stop2;
        if (getActivity() != null && isAdded() && (stop2 = this.L) != null && stop2.equals(stop)) {
            ii1.a aVar2 = new ii1.a();
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                aVar2.d = ii1.a.EnumC0027a.SUCCESS;
                aVar2.f1519a = j10.a();
                aVar2.b = j10.c();
                aVar2.c = j10.b();
            } else if (ordinal == 1) {
                aVar2.d = ii1.a.EnumC0027a.PASSED;
            } else if (ordinal == 2) {
                aVar2.d = ii1.a.EnumC0027a.NOT_ARRIVING_SOON;
            } else if (ordinal == 3) {
                aVar2.d = ii1.a.EnumC0027a.FAILURE;
            } else if (ordinal == 4) {
                aVar2.d = ii1.a.EnumC0027a.FIRST_STOP;
                aVar2.f1519a = j10.a();
                aVar2.b = j10.c();
                aVar2.c = j10.b();
            }
            this.h.f(stop, aVar2);
            dk0 dk0 = this.h;
            LiveRouteData liveRouteData = this.r;
            dk0.w = liveRouteData;
            x61 x61 = dk0.k;
            if (x61 != null) {
                x61.c = liveRouteData;
            }
            dk0.notifyDataSetChanged();
            if (!this.B && this.g.getSeatAvailability() != 0) {
                this.o.post(this.N);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.K = System.currentTimeMillis();
        return LayoutInflater.from(getActivity()).inflate(R.layout.route_container, viewGroup, false);
    }

    public void onEvent(FirebaseEtaUpdateEvent firebaseEtaUpdateEvent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Stop stop;
        if (this.F == firebaseEtaUpdateEvent.get_requestId()) {
            String str7 = null;
            if (firebaseEtaUpdateEvent.get_responseType().equals(ad1.SUCCESS) && this.r != null) {
                List<DataInfo> list = firebaseEtaUpdateEvent.get_etaInfoList();
                this.G = list;
                Stop stop2 = this.L;
                j10 h2 = ii1.h(list, this.r.getFirebaseStreams(), this.L.getLatLong());
                if (getActivity() != null && isAdded()) {
                    long j2 = 0;
                    LiveRouteData liveRouteData = this.r;
                    if (!(liveRouteData == null || liveRouteData.getLastSeenInfo() == null)) {
                        j2 = this.r.getLastSeenInfo().getLastSeen();
                    }
                    if (!f(this.L) || (stop = this.L) == null || !stop.equals(stop2)) {
                        if (this.r.getFirebaseResponse().equals(h.SUCCESS)) {
                            Stop stop3 = this.L;
                            if (stop3 != null && stop3.equals(stop2)) {
                                if (x61.t(h2)) {
                                    int indexOf = this.f.indexOf(stop2);
                                    if (indexOf < this.r.getFirstLiveStopPosition()) {
                                        if (indexOf == 0 && h2.c().size() != 0) {
                                            n(ii1.a.EnumC0027a.FIRST_STOP, stop2, h2);
                                            ui1.t0("realTimeEtaInfoSeen");
                                            xt.f3961a.l().put("real_time_info_seen", String.valueOf(true));
                                            str6 = h2.c().get(0).g;
                                            j2 = h2.c().get(0).c;
                                            str5 = "first stop eta";
                                        } else if (h2.b().size() != 0) {
                                            n(ii1.a.EnumC0027a.SUCCESS, stop2, h2);
                                            ui1.t0("realTimeEtaInfoSeen");
                                            xt.f3961a.l().put("real_time_info_seen", String.valueOf(true));
                                            str6 = h2.b().get(0).g;
                                            j2 = h2.b().get(0).c;
                                            str5 = "estimated eta";
                                        } else {
                                            n(ii1.a.EnumC0027a.PASSED, stop2, null);
                                            i();
                                            str3 = null;
                                            str4 = "bus passed";
                                        }
                                        str4 = str5;
                                        str3 = str6;
                                    } else {
                                        n(ii1.a.EnumC0027a.SUCCESS, stop2, h2);
                                        ui1.t0("realTimeEtaInfoSeen");
                                        xt.f3961a.l().put("real_time_info_seen", String.valueOf(true));
                                        if (h2.c().size() != 0) {
                                            str7 = h2.c().get(0).g;
                                            j2 = h2.c().get(0).c;
                                        }
                                        str3 = str7;
                                        str4 = "eta seen";
                                    }
                                    str = str3;
                                    str2 = str4;
                                } else {
                                    n(ii1.a.EnumC0027a.PASSED, stop2, null);
                                    i();
                                    str = null;
                                    str2 = "bus passed";
                                }
                            }
                        } else if (this.r.getFirebaseResponse().equals(h.FAILED)) {
                            m(stop2);
                            if (!this.r.isLiveFeedProvider() || !this.r.getLiveFeedResponse().equals(h.WAITING)) {
                                i();
                                str2 = "not available";
                                str = null;
                            }
                        }
                        str2 = null;
                        str = null;
                    } else {
                        this.h.g(stop2, this.r.getLiveFeedEtaUpdateInfoMap().get(stop2.getId()));
                        this.h.notifyDataSetChanged();
                        if (h2.c().size() != 0) {
                            str7 = h2.c().get(0).g;
                            j2 = h2.c().get(0).c;
                        }
                        ui1.t0("realTimeEtaInfoSeen");
                        xt.f3961a.l().put("real_time_info_seen", String.valueOf(true));
                        str = str7;
                        str2 = "eta seen";
                    }
                    Stop stop4 = this.u;
                    if (stop4 == null || !stop4.equals(stop2)) {
                        this.u = stop2;
                        if (str2 != null) {
                            ui1.p0(this.g.getRouteName(), this.g.getMode().toString(), this.L.getName(), false, "list view", str2, String.valueOf(j2), str, str);
                        }
                    }
                }
            } else if (firebaseEtaUpdateEvent.get_responseType().equals(ad1.FAILED)) {
                n(ii1.a.EnumC0027a.PASSED, this.L, null);
            }
        }
    }

    public void onEventMainThread(LiveRouteData liveRouteData) {
        int i2;
        int i3;
        jz5.b().m(this);
        if (this.g.getRouteId().equals(liveRouteData.getRoute().getRouteId())) {
            this.r = liveRouteData;
            long j2 = 0;
            if (liveRouteData.getStreamCount() > 0) {
                if (this.g.getAvailabilityStatus() == 0 || this.A) {
                    ed1 ed1 = new ed1("availability issue", Long.MIN_VALUE);
                    ed1.a("route id", this.g.getRouteId());
                    ed1.a("availability status", Long.valueOf(this.g.getAvailabilityStatus()));
                    hj1.d(this.A, ed1, "offduty", ed1);
                    dk0 dk0 = this.h;
                    dk0.B = true;
                    dk0.notifyDataSetChanged();
                }
            } else if (this.g.getAvailabilityStatus() != 0) {
                long j3 = 2147483647L;
                long j4 = -2147483648L;
                boolean z2 = this.g.getRouteTiming() == null || this.g.getRouteTiming().size() == 0;
                if (!z2) {
                    for (Route.RouteTiming routeTiming : this.g.getRouteTiming()) {
                        long j5 = (long) routeTiming.duration;
                        if (routeTiming._isFrequency) {
                            i2 = ((TimeInterval) routeTiming._frequencyTuple.first).getLow();
                        } else {
                            i2 = routeTiming._startTime;
                        }
                        j3 = Math.min(j3, (long) i2);
                        if (routeTiming._isFrequency) {
                            i3 = ((TimeInterval) routeTiming._frequencyTuple.first).getHigh();
                        } else {
                            i3 = routeTiming._startTime;
                        }
                        j4 = Math.max(j4, (long) i3);
                        j2 = j5;
                    }
                } else {
                    j2 = 0;
                }
                Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                long currentTimeMillis = (System.currentTimeMillis() - instance.getTimeInMillis()) / 1000;
                if (j3 == j4) {
                    j4 = j3 + j2;
                }
                if ((currentTimeMillis < j3 || currentTimeMillis > j4) && !z2) {
                    xt.t1 t1Var = xt.f3961a;
                    String f2 = t1Var.t().f("routeInfoBanner");
                    if (this.g.getMode() != null) {
                        int ordinal = this.g.getMode().ordinal();
                        if (ordinal == 1) {
                            f2 = t1Var.t().f("routeInfoBanner");
                        } else if (ordinal != 5) {
                            f2 = t1Var.t().f("routeInfoBannerTrain");
                        } else {
                            f2 = t1Var.t().f("routeInfoBannerFerry");
                        }
                    }
                    if (f2.contains("firstBusTime")) {
                        f2.replace("firstBusTime", jh1.g(j3));
                    }
                    this.A = true;
                    dk0 dk02 = this.h;
                    if (dk02 != null) {
                        dk02.A = true;
                        dk02.notifyDataSetChanged();
                    }
                }
            }
            if (liveRouteData.isLiveFeedProvider()) {
                List<Stop> list = this.f;
                dk0 dk03 = this.h;
                int i4 = dk03.n;
                if (i4 < 0 || i4 < dk03.l || i4 > dk03.m) {
                    i4 = dk03.l;
                }
                Stop stop = list.get(i4);
                Stop stop2 = this.L;
                if (stop2 != null) {
                    stop = stop2;
                }
                if (!isAdded()) {
                    return;
                }
                if (this.r.getLiveFeedResponse().equals(h.SUCCESS)) {
                    Map<String, List<EtaUpdateInfo>> liveFeedEtaUpdateInfoMap = this.r.getLiveFeedEtaUpdateInfoMap();
                    if (liveFeedEtaUpdateInfoMap.size() == 0) {
                        h hVar = h.FAILED;
                        j();
                        d(stop);
                    } else if (this.r.getLastSeenInfo().getLastSeen() != 0) {
                        this.r.getLiveFeedLocationsList().size();
                        k();
                        g();
                        this.M = null;
                        if (liveFeedEtaUpdateInfoMap.get(stop.getId()) == null) {
                            b00 b00 = b00.f358a;
                            c00 a2 = b00.a();
                            StringBuilder i0 = hj1.i0("No eta update found for");
                            i0.append(stop.getId());
                            i0.append("in");
                            i0.append(this.g.getRouteName());
                            i0.append(this.g.getRouteId());
                            i0.append(xt.f3961a.k().d().getName());
                            a2.b(new Throwable(i0.toString()));
                            l();
                            i();
                            n(ii1.a.EnumC0027a.FAILURE, stop, null);
                            h hVar2 = h.FAILED;
                            j();
                            return;
                        }
                        this.h.g(stop, liveFeedEtaUpdateInfoMap.get(stop.getId()));
                        this.h.notifyDataSetChanged();
                        j();
                    }
                } else {
                    h hVar3 = h.FAILED;
                    j();
                    d(stop);
                }
            } else {
                List<StreamInfo> firebaseStreams = this.r.getFirebaseStreams();
                this.D = firebaseStreams.size();
                Stop stop3 = this.L;
                boolean z3 = stop3 == null;
                if (!z3) {
                    xt.t1 t1Var2 = xt.f3961a;
                    if (!xt.p) {
                        b(stop3, true);
                    }
                }
                if (firebaseStreams.size() <= 0 || !vn.K0(getActivity())) {
                    if (!this.r.isLiveFeedProvider() || this.r.getLiveFeedResponse().equals(h.FAILED)) {
                        l();
                    }
                    dk0 dk04 = this.h;
                    Objects.requireNonNull(dk04);
                    dk04.o = new ArrayList();
                    dk04.p = new ArrayList();
                    dk04.v.g(firebaseStreams);
                    dk04.notifyDataSetChanged();
                    return;
                }
                dk0 dk05 = this.h;
                Objects.requireNonNull(dk05);
                if (firebaseStreams.size() > 0) {
                    dk05.o = new ArrayList();
                    dk05.p = new ArrayList();
                    dk05.v.g(firebaseStreams);
                    for (StreamInfo streamInfo : firebaseStreams) {
                        String nextStopId = streamInfo.getNextStopId();
                        int c2 = dk05.c(nextStopId) - 1;
                        if (c2 < 0) {
                            if (dk05.u.getRouteId() != null) {
                                b00 b002 = b00.f358a;
                                b00.a().b(new Throwable(hj1.T("incorrect next stop Id = ", nextStopId, " detected for route")));
                            } else {
                                b00 b003 = b00.f358a;
                                c00 a3 = b00.a();
                                StringBuilder l0 = hj1.l0("incorrect next stop Id = ", nextStopId, " detected for route");
                                l0.append(dk05.u.getRouteId());
                                a3.b(new Throwable(l0.toString()));
                            }
                            c2 = 0;
                        }
                        String id = dk05.a(c2).getId();
                        dk05.o.add(nextStopId);
                        dk05.p.add(id);
                        if (z3) {
                            dk05.f(dk05.a(dk05.c(streamInfo.getNextStopId())), ii1.n(streamInfo));
                        }
                    }
                } else {
                    dk05.o = new ArrayList();
                    dk05.p = new ArrayList();
                    dk05.v.g(firebaseStreams);
                }
                this.h.notifyDataSetChanged();
                firebaseStreams.size();
                k();
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        xt.t1 t1Var = xt.f3961a;
        if ((System.currentTimeMillis() - this.K) + 5000 > ((long) (ui1.x(t1Var.k().d().getName().toLowerCase()) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL * 60))) {
            dk0 dk0 = this.h;
            int i2 = dk0.y;
            if (i2 < 0 || i2 < dk0.l || i2 > dk0.m) {
                i2 = dk0.l;
            }
            this.p.post(new qt0(this, i2));
        }
        if (xt.p) {
            if (this.L != null) {
                a();
            }
        } else if (this.E || !t1Var.t().b("firebasePollingEnabled")) {
            Runnable runnable = this.M;
            if (runnable != null) {
                this.o.post(runnable);
            }
        } else if (this.L != null) {
            this.F = t1Var.u().b(c(this.L.getId()), "eta");
        }
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public void onStop() {
        Set<String> set;
        this.K = System.currentTimeMillis();
        Runnable runnable = this.M;
        if (runnable != null) {
            this.o.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.N;
        if (runnable2 != null) {
            this.o.removeCallbacks(runnable2);
        }
        if (!(this.g == null || (set = this.v) == null)) {
            for (String str : set) {
                xt.f3961a.N().j(str, this.g.getRouteId(), false);
            }
            this.v.clear();
        }
        xt.t1 t1Var = xt.f3961a;
        t1Var.O().l(this.J, this.H);
        t1Var.u().a(this.F);
        jz5.b().o(this);
        this.I = false;
        super.onStop();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r18, android.os.Bundle r19) {
        /*
        // Method dump skipped, instructions count: 505
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt0.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public void onEvent(StopSearchedEvent stopSearchedEvent) {
        if (this.g != null && stopSearchedEvent.getRouteId().equals(this.g.getRouteId())) {
            int indexOf = this.g.getStopSequence().indexOf(stopSearchedEvent.getStop());
            this.p.clearFocus();
            if (indexOf >= 0) {
                this.p.postDelayed(new c(indexOf), 200);
                this.h.e(indexOf);
                this.h.notifyDataSetChanged();
                jz5.b().m(stopSearchedEvent);
            }
        }
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        if (seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            this.C = seatInfoList;
            if (seatInfoList != null) {
                for (int i2 = 0; i2 < this.C.size(); i2++) {
                    ed1 ed1 = new ed1("seat status", Long.MIN_VALUE);
                    SeatInfo seatInfo = this.C.get(i2);
                    ed1.a("vehicle no", seatInfo.getVehicleNo());
                    ed1.a("seat status", Integer.valueOf(seatInfo.getSeatStatus()));
                    ed1.a("route id", this.g.getRouteId());
                    ed1.a("route name", this.g.getRouteName());
                    ed1.a("seat occupancy api mode", Integer.valueOf(this.g.getSeatAvailability()));
                    ed1.a("time", Long.valueOf(System.currentTimeMillis()));
                    jz5.b().g(ed1);
                }
            }
            dk0 dk0 = this.h;
            List<SeatInfo> seatInfoList2 = seatAvailabilityStatusEvent.getSeatInfoList();
            x61 x61 = dk0.k;
            x61.d = seatInfoList2;
            x61.e = dk0.i;
            this.h.notifyDataSetChanged();
        }
    }

    public void onEvent(ReportProblemClickEvent reportProblemClickEvent) {
        Route route;
        if (reportProblemClickEvent != null && RouteListCardItem.l != null && reportProblemClickEvent.getRequestId() != null && RouteListCardItem.l.equals(reportProblemClickEvent.getRequestId()) && (route = this.g) != null && route.getStopSequence() != null) {
            jz5.b().m(reportProblemClickEvent);
            dk0 dk0 = this.h;
            int i2 = dk0 != null ? dk0.y : -1;
            List<Stop> stopSequence = this.g.getStopSequence();
            if (i2 >= 0 && i2 < stopSequence.size()) {
                Stop stop = stopSequence.get(i2);
                if (stop != null) {
                    ed1 l2 = hj1.l("report problem clicked", Long.MIN_VALUE, "type", ReportProblemImpl.PROBLEM_TYPE_STOP_ETA);
                    l2.a("cityName", xt.f3961a.k().d().getName());
                    l2.a(LoggingConstants.ROUTE_ID, this.g.getRouteId());
                    l2.a("routeName", this.g.getRouteName());
                    l2.a("stopId", stop.getId());
                    l2.a("stopName", stop.getName());
                    Stop stop2 = this.k;
                    l2.a("isNearbyStop", Boolean.valueOf(stop2 != null && stop2.getId().equals(stop.getId())));
                    l2.a("problemSource", "BusRouteFragment");
                    jz5.b().g(l2);
                }
                xt.t1 t1Var = xt.f3961a;
                City d2 = t1Var.k().d();
                if (d2 != null && t1Var.Q().getReportProblemMetadata(ReportProblemImpl.PROBLEM_TYPE_STOP_ETA, d2.getName()) != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    gn0 gn0 = new gn0(getActivity(), ReportProblemImpl.PROBLEM_TYPE_STOP_ETA, new d(stop), RouteDetailsActivity.class.getSimpleName());
                    gn0.show(fragmentManager, gn0.t);
                    gn0.setCancelable(false);
                }
            }
        }
    }

    public void onEvent(LiveRouteDetailsEvent liveRouteDetailsEvent) {
        jz5.b().m(liveRouteDetailsEvent);
        ad1 responseType = liveRouteDetailsEvent.getResponseType();
        if (this.g != null && liveRouteDetailsEvent.getRouteId().equals(this.g.getRouteId()) && responseType.equals(ad1.SUCCESS)) {
            liveRouteDetailsEvent.getRoute();
        }
    }
}
