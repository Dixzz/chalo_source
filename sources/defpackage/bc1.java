package defpackage;

import android.content.Context;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.EtaModel;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import app.zophop.models.TripLeg;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.ui.views.summary_card.CardItem;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import defpackage.ii1;
import defpackage.mt0;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;

/* renamed from: bc1  reason: default package */
/* compiled from: ZophopInfoWindow */
public class bc1 extends LinearLayout {
    public final Stop f;
    public final Marker g;
    public final Route h;
    public final x61 i;
    public boolean j;
    public boolean k = false;
    public xc1 l;
    public ValueEventListener m;
    public List<SeatInfo> n;
    public List<EtaModel> o;
    public LiveRouteData p;
    public Trip q;
    public List<Integer> r;
    public List<String> s;
    public final o61 t;
    public Runnable u;
    public Handler v;
    public String w;
    public int x;

    /* renamed from: bc1$a */
    /* compiled from: ZophopInfoWindow */
    public class a implements ValueEventListener {
        public a() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            bc1.a(bc1.this, dataSnapshot, null);
        }
    }

    /* renamed from: bc1$b */
    /* compiled from: ZophopInfoWindow */
    public class b implements ji1<Object, String> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            b00 b00 = b00.f358a;
            hj1.Q0(str, b00.a());
        }

        @Override // defpackage.ji1
        public void onSuccess(Object obj) {
            bc1.a(bc1.this, null, (List) obj);
        }
    }

    public bc1(Context context, Stop stop, Route route, Marker marker) {
        super(context);
        this.f = stop;
        this.h = route;
        this.g = marker;
        this.j = false;
        stop.getMode();
        this.i = new x61(context);
        this.t = new o61(route);
        this.p = new LiveRouteData(route);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
        c();
        this.v = new Handler();
        this.u = new ac1(this, stop, route.getSeatAvailability());
    }

    public static void a(bc1 bc1, DataSnapshot dataSnapshot, List list) {
        j10 j10;
        if (list == null) {
            j10 = ii1.f(dataSnapshot, bc1.p.getFirebaseStreams(), bc1.f.getLatLong());
        } else {
            j10 = ii1.h(list, bc1.p.getFirebaseStreams(), bc1.f.getLatLong());
        }
        ii1.a b2 = bc1.b(j10);
        bc1.i.c(bc1.f, b2);
        List<SeatInfo> list2 = bc1.n;
        if (list2 != null) {
            bc1.i.d = list2;
        }
        bc1.g();
        bc1.g.showInfoWindow();
        List<i10> list3 = b2.b;
        if (list3 != null) {
            bc1.r = x61.l(b2, list3.size());
        }
        List<i10> list4 = b2.c;
        if (list4 != null) {
            ArrayList arrayList = new ArrayList(list4.size());
            List<i10> list5 = b2.c;
            for (int i2 = 0; i2 < list5.size(); i2++) {
                arrayList.add(ui1.R(list5.get(i2).e, list5.get(i2).f));
            }
            bc1.s = arrayList;
        }
        List<i10> list6 = b2.b;
        if (list6 != null) {
            bc1.o = x61.j(b2, list6.size());
        }
        if (!bc1.j) {
            bc1.j = true;
            int a2 = j10.a();
            if (j10.c().size() <= 0 || a2 >= 7200 || a2 <= 0) {
                ui1.p0(bc1.h.getRouteName(), bc1.h.getMode().toString(), bc1.f.getName(), false, "map", "not available", String.valueOf(bc1.p.getLastSeenInfo().getLastSeen()), bc1.p.getLastSeenInfo().getVehicleNumber(), null);
            } else {
                ui1.p0(bc1.h.getRouteName(), bc1.h.getMode().toString(), bc1.f.getName(), false, "map", "eta seen", String.valueOf(bc1.p.getLastSeenInfo().getLastSeen()), bc1.p.getLastSeenInfo().getVehicleNumber(), null);
            }
        }
        if (!(bc1.k || bc1.h.getSeatAvailability() == 0)) {
            bc1.v.removeCallbacks(bc1.u);
            bc1.v.post(bc1.u);
            bc1.k = true;
        }
    }

    private String getEtaRef() {
        return vn.v("etas", this.f.getId(), this.h.getRouteId());
    }

    private CharSequence getScheduledTime() {
        TripLeg tripLeg = null;
        for (TripLeg tripLeg2 : this.q.getTripLegs()) {
            if (tripLeg2.getStop().equals(this.f)) {
                tripLeg = tripLeg2;
            }
        }
        return ui1.O(getContext(), jh1.g(Long.valueOf((long) tripLeg.getArrivalTime()).longValue()));
    }

    private int getStopPosition() {
        for (int i2 = 0; i2 < this.h.getStopSequence().size(); i2++) {
            if (this.h.getStopSequence().get(i2).equals(this.f)) {
                return i2;
            }
        }
        return -1;
    }

    private void setLastSeenAt(boolean z) {
        if (z) {
            String A = ui1.A(this.p.getLastSeenInfo().getLastSeen(), getContext());
            this.l.getLastUpdatedView().setVisibility(8);
            ui1.w0(getContext(), this.l.getLastUpdatedView(), A, R.color.black_87);
            return;
        }
        this.l.getLastUpdatedView().setVisibility(8);
    }

    public final ii1.a b(j10 j10) {
        ii1.a aVar = new ii1.a();
        int a2 = j10.a();
        if (j10.c().size() > 0 && a2 < 7200 && a2 > 0) {
            aVar.d = ii1.a.EnumC0027a.SUCCESS;
            aVar.b = j10.c();
            aVar.f1519a = j10.a();
            if (!d()) {
                setLastSeenAt(true);
            } else {
                setLastSeenAt(false);
            }
        } else if (j10.b().size() != 0) {
            aVar.d = ii1.a.EnumC0027a.SUCCESS;
            aVar.c = j10.b();
            aVar.f1519a = j10.a();
            aVar.b = j10.c();
            setLastSeenAt(false);
        } else {
            aVar.d = ii1.a.EnumC0027a.FAILURE;
            setLastSeenAt(false);
        }
        return aVar;
    }

    public final void c() {
        setOrientation(0);
        this.l = new xc1(getContext());
        CharSequence scheduledTime = this.q != null ? getScheduledTime() : null;
        String name = this.f.getName();
        ut.a aVar = ut.f3552a;
        CardItem.b bVar = new CardItem.b(name, null, scheduledTime, null);
        bVar.k = 1;
        this.l.setContent(bVar);
        if (this.l.getReportHook() != null) {
            this.l.getReportHook().setVisibility(8);
        }
        this.i.d(this.f);
        g();
        addView(this.l);
        this.m = getEtaListener();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.route_map_infowindow_width);
        if (getMeasuredWidth() > dimensionPixelSize) {
            this.l.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, -2));
            this.l.invalidate();
        }
    }

    public final boolean d() {
        return getStopPosition() == 0;
    }

    public void e() {
        xt.f3961a.N().d(this.f.getId()).child(this.h.getRouteId()).addValueEventListener(this.m);
    }

    public void f() {
        this.w = getEtaRef();
        this.x = xt.f3961a.O().k(this.w, new b());
    }

    public final void g() {
        List<i10> list;
        List<i10> list2;
        if (!this.i.q(this.f) && this.p.getFirstLiveStopPosition() > getStopPosition()) {
            ii1.a h2 = this.i.h(this.h.getStopSequence().get(getStopPosition()));
            if (h2 != null && d() && (list2 = h2.b) != null && list2.size() != 0) {
                h2.d = ii1.a.EnumC0027a.FIRST_STOP;
                this.i.c(this.f, h2);
            } else if (h2 == null || (list = h2.c) == null || list.size() == 0) {
                this.i.c(this.f, b(new j10(new ArrayList())));
            }
        }
        if (this.h.getMode().equals(TransitMode.bus)) {
            this.l.c(this.i, this.f, this.h, d());
        }
        ((TextView) this.l.findViewById(R.id.card_timing)).setGravity(3);
    }

    public ValueEventListener getEtaListener() {
        return new a();
    }

    public void h() {
        this.v.removeCallbacks(this.u);
        xt.t1 t1Var = xt.f3961a;
        t1Var.N().d(this.f.getId()).child(this.h.getRouteId()).removeEventListener(this.m);
        t1Var.O().l(this.w, this.x);
        jz5.b().o(this);
    }

    public void i(LiveRouteData liveRouteData, boolean z) {
        String str;
        this.p = liveRouteData;
        if (liveRouteData.isLiveFeedProvider() && liveRouteData.getLiveFeedResponse().equals(mt0.h.SUCCESS) && liveRouteData.getLiveFeedEtaUpdateInfoMap().size() > 0) {
            ii1.a q0 = vn.q0(liveRouteData.getLiveFeedEtaUpdateInfoMap().get(this.f.getId()));
            if (q0.d.equals(ii1.a.EnumC0027a.SUCCESS)) {
                setLastSeenAt(true);
                str = "eta seen";
            } else {
                setLastSeenAt(false);
                str = "not available";
            }
            if (!this.j) {
                this.j = true;
                ui1.p0(this.h.getRouteName(), this.h.getMode().toString(), this.f.getName(), false, "map", str, String.valueOf(this.p.getLastSeenInfo().getLastSeen()), this.p.getLastSeenInfo().getVehicleNumber(), null);
            }
            this.i.c(this.f, q0);
            g();
            if (z) {
                this.g.showInfoWindow();
            }
        }
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        if (seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            this.n = seatAvailabilityStatusEvent.getSeatInfoList();
            this.i.d = seatAvailabilityStatusEvent.getSeatInfoList();
            g();
            this.g.showInfoWindow();
        }
    }

    public bc1(Context context, Stop stop, Trip trip, Route route, Marker marker) {
        super(context);
        this.f = stop;
        this.h = route;
        this.q = trip;
        this.g = marker;
        route.getMode();
        this.i = new x61(context);
        this.p = new LiveRouteData(route);
        this.t = new o61(route);
        c();
    }
}
