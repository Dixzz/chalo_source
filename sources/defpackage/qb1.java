package defpackage;

import android.util.Pair;
import app.zophop.models.Stop;
import com.google.firebase.database.ValueEventListener;
import defpackage.ii1;
import defpackage.xt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;

/* renamed from: qb1  reason: default package */
/* compiled from: RealTimeInfoHelper */
public class qb1 {

    /* renamed from: a  reason: collision with root package name */
    public final Itinerary f2921a;
    public final ji1 b;
    public Map<Integer, Pair<Stop, String>> c;
    public Map<Integer, ii1.a> d;
    public Map<Pair<Stop, String>, ValueEventListener> e = new HashMap();
    public Map<Integer, String> f = new HashMap();

    /* renamed from: qb1$a */
    /* compiled from: RealTimeInfoHelper */
    public class a implements ji1<Object, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Integer f2922a;

        public a(Integer num) {
            this.f2922a = num;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            ii1.a aVar = new ii1.a();
            aVar.d = ii1.a.EnumC0027a.FAILURE;
            qb1.a(qb1.this, aVar, this.f2922a);
        }

        @Override // defpackage.ji1
        public void onSuccess(Object obj) {
            j10 g = ii1.g((List) obj);
            ii1.a aVar = new ii1.a();
            aVar.b = g.c();
            aVar.f1519a = g.a();
            aVar.c = g.b();
            aVar.d = ii1.a.EnumC0027a.SUCCESS;
            qb1.a(qb1.this, aVar, this.f2922a);
        }
    }

    /* renamed from: qb1$b */
    /* compiled from: RealTimeInfoHelper */
    public class b implements ji1<j10, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Integer f2923a;

        public b(Integer num) {
            this.f2923a = num;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
            ii1.a aVar = new ii1.a();
            aVar.d = ii1.a.EnumC0027a.FAILURE;
            qb1.a(qb1.this, aVar, this.f2923a);
            b00 b00 = b00.f358a;
            hj1.Q0(str, b00.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void onSuccess(j10 j10) {
            j10 j102 = j10;
            if (x61.t(j102)) {
                ii1.a aVar = new ii1.a();
                aVar.b = j102.c();
                aVar.f1519a = j102.a();
                aVar.c = j102.b();
                aVar.d = ii1.a.EnumC0027a.SUCCESS;
                qb1.a(qb1.this, aVar, this.f2923a);
            }
        }
    }

    public qb1(Itinerary itinerary, ji1 ji1) {
        this.f2921a = itinerary;
        this.b = ji1;
        d();
    }

    public static void a(qb1 qb1, ii1.a aVar, Integer num) {
        qb1.d.put(num, aVar);
        String str = "size" + qb1.d.size() + ":total" + qb1.c.size() + "position" + num + "type" + aVar.d;
        if (qb1.b != null && aVar.d.equals(ii1.a.EnumC0027a.SUCCESS)) {
            qb1.b.onSuccess(qb1.d);
        }
    }

    public void b() {
        xt.t1 t1Var = xt.f3961a;
        if (!xt.p) {
            Map<Pair<Stop, String>, ValueEventListener> map = this.e;
            if (map != null) {
                for (Map.Entry<Pair<Stop, String>, ValueEventListener> entry : map.entrySet()) {
                    Stop stop = (Stop) entry.getKey().first;
                    String str = (String) entry.getKey().second;
                    ValueEventListener value = entry.getValue();
                    z30 N = xt.f3961a.N();
                    if (N.d != null) {
                        N.d.child(N.f.d().getName().toUpperCase()).child(stop.getId()).child(str).removeEventListener(value);
                    }
                }
                this.e.clear();
                return;
            }
            return;
        }
        Map<Integer, String> map2 = this.f;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<Integer, String> entry2 : this.f.entrySet()) {
                xt.f3961a.O().l(entry2.getValue(), entry2.getKey().intValue());
            }
            this.f.clear();
        }
    }

    public void c() {
        b40 b40;
        for (Integer num : this.c.keySet()) {
            Pair<Stop, String> pair = this.c.get(num);
            Stop stop = (Stop) pair.first;
            String str = (String) pair.second;
            xt.t1 t1Var = xt.f3961a;
            if (xt.p) {
                String v = vn.v("etas", stop.getId(), str);
                this.f.put(Integer.valueOf(t1Var.O().k(v, new a(num))), v);
            } else {
                z30 N = t1Var.N();
                b bVar = new b(num);
                if (!vn.K0(N.g)) {
                    bVar.a("NO Internet");
                    b40 = null;
                } else {
                    String upperCase = N.f.d().getName().toUpperCase();
                    b40 b402 = new b40(N, bVar);
                    N.d.child(upperCase).child(stop.getId()).child(str).addValueEventListener(b402);
                    b40 = b402;
                }
                if (b40 != null) {
                    this.e.put(pair, b40);
                }
            }
        }
    }

    public final void d() {
        this.c = new HashMap(this.f2921a.legs.size());
        Iterator<Leg> it = this.f2921a.legs.iterator();
        int i = 0;
        while (it.hasNext()) {
            Leg next = it.next();
            LegMode legMode = next.mode;
            if (!legMode.equals(LegMode.WALK) && !legMode.equals(LegMode.AUTO) && !legMode.equals(LegMode.TAXI)) {
                Stop l = vn.l(next.first_stop);
                l.getName();
                this.c.put(Integer.valueOf(i), new Pair<>(l, next.route_id));
            }
            i++;
        }
        this.d = new HashMap(i);
    }

    public qb1(Itinerary itinerary, ji1 ji1, Leg leg) {
        this.f2921a = itinerary;
        this.b = ji1;
        d();
    }
}
