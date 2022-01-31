package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import app.zophop.models.Stop;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.BusSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.NearbyStopTripEvent;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: m30  reason: default package */
/* compiled from: NearbyStopTripRequestHandler */
public class m30 {

    /* renamed from: a  reason: collision with root package name */
    public String f2315a;
    public String b;
    public Stop c;
    public Map<String, i10> d;
    public List<TripSummary> e;
    public LatLng f;
    public ValueEventListener g;
    public Handler h;
    public HandlerThread i;
    public Runnable j;
    public DataSnapshot k;
    public long l;
    public boolean m;
    public boolean n;
    public Map<String, Integer> o;

    /* renamed from: m30$a */
    /* compiled from: NearbyStopTripRequestHandler */
    public class a implements ji1<Object, String> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            b00 b00 = b00.f358a;
            hj1.Q0(str, b00.a());
        }

        @Override // defpackage.ji1
        public void onSuccess(Object obj) {
            xt.f3961a.E().c = false;
            m30.this.n = true;
            Map map = (Map) obj;
            m30.this.d.clear();
            for (String str : map.keySet()) {
                j10 g = ii1.g((List) map.get(str));
                if (g.a() < 7200) {
                    m30.this.d.put(str, g.c().get(0));
                } else if (g.b().size() != 0) {
                    m30.this.d.put(str, g.b().get(0));
                }
            }
            m30.this.c();
        }
    }

    public m30() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public final boolean a() {
        return this.g != null;
    }

    public final void b() {
        xt.t1 t1Var = xt.f3961a;
        if (xt.p) {
            if (!this.n && this.c != null) {
                t1Var.E().c = true;
                String w = vn.w("allRoutesEtas", this.c.getId());
                e();
                this.o.put(w, Integer.valueOf(t1Var.O().k(w, new a())));
            }
        } else if (!a()) {
            this.g = new n30(this);
            t1Var.N().d(this.c.getId()).addValueEventListener(this.g);
            this.j.run();
        }
    }

    public final void c() {
        List<TripSummary> list = this.e;
        if (list == null || list.size() <= 0) {
            List<TripSummary> list2 = this.e;
            if (list2 != null && list2.size() == 0) {
                if (this.c != null) {
                    b00 b00 = b00.f358a;
                    c00 a2 = b00.a();
                    a2.a("Trip Summary => ", this.c.getId() + " : " + this.c.getName() + " : " + this.f.latitude + " : " + this.f.longitude);
                    return;
                }
                b00 b002 = b00.f358a;
                c00 a3 = b00.a();
                a3.a("Trip Summary => ", this.f.latitude + " : " + this.f.longitude);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (TripSummary tripSummary : this.e) {
            String routeId = tripSummary.getRouteId();
            if (!hashMap.containsKey(routeId)) {
                hashMap.put(routeId, tripSummary);
            }
        }
        hashMap.size();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, i10> map = this.d;
        if (map == null || map.size() <= 0) {
            jz5.b().i(new NearbyStopTripEvent(this.f2315a, TripPlannerEvent.ResponseType.SUCCESS, this.c, arrayList, new ArrayList(this.e), this.f));
            System.currentTimeMillis();
            return;
        }
        for (String str : hashMap.keySet()) {
            if (this.d.containsKey(str)) {
                arrayList.add(new Pair((TripSummary) hashMap.get(str), this.d.get(str)));
            } else {
                arrayList2.add((TripSummary) hashMap.get(str));
            }
        }
        arrayList.size();
        jz5.b().i(new NearbyStopTripEvent(this.f2315a, TripPlannerEvent.ResponseType.SUCCESS, this.c, arrayList, arrayList2, this.f));
    }

    public void d() {
        if (a()) {
            xt.f3961a.N().d(this.c.getId()).removeEventListener(this.g);
            this.g = null;
            this.d.clear();
            this.e.clear();
        }
        this.n = false;
        e();
        this.h.removeCallbacks(this.j);
        this.i.quit();
    }

    public void e() {
        Map<String, Integer> map = this.o;
        if (map != null) {
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                xt.f3961a.O().l(next.getKey(), next.getValue().intValue());
                it.remove();
            }
        }
    }

    public void onEvent(BusSummaryResponseEvent busSummaryResponseEvent) {
        if (busSummaryResponseEvent.getRequestId().equals(this.b)) {
            if (busSummaryResponseEvent.getResponseType().equals(SummaryResponseEvent.ResponseType.SUCCESS)) {
                SummaryResponse summaryResponse = busSummaryResponseEvent.getSummaryResponseList().get(0);
                this.c = summaryResponse.getStop();
                this.e = summaryResponse.getTripSummary();
                b();
                c();
            } else {
                jz5.b().i(new NearbyStopTripEvent(this.f2315a, TripPlannerEvent.ResponseType.FAILED, this.c, null, null, this.f));
            }
            jz5.b().m(busSummaryResponseEvent);
            jz5.b().o(this);
        }
    }
}
