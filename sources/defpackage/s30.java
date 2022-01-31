package defpackage;

import android.util.Pair;
import android.util.SparseIntArray;
import app.zophop.models.NeighbouringStopTripInfo;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.PreProcessingDoneEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: s30  reason: default package */
/* compiled from: OfflineSchedulerFeature */
public class s30 {

    /* renamed from: a  reason: collision with root package name */
    public c50 f3176a;
    public m50 b;
    public final ArrayList<c> c = new ArrayList<>();
    public b d = b.NOT_STARTED;
    public ScheduledFuture<?> e;

    /* renamed from: s30$a */
    /* compiled from: OfflineSchedulerFeature */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z;
            Iterator<TransitMode> it;
            c50 c50;
            boolean z2;
            DataSnapshot dataSnapshot;
            Iterator<DataSnapshot> it2;
            v40 v40;
            Iterator<TransitMode> it3;
            c50 c502;
            DataSnapshot dataSnapshot2;
            c50 c503;
            DataSnapshot dataSnapshot3;
            DataSnapshot dataSnapshot4;
            String str;
            TransitMode transitMode;
            String str2;
            DataSnapshot dataSnapshot5;
            ArrayList arrayList;
            DataSnapshot dataSnapshot6;
            String str3;
            TransitMode transitMode2;
            DataSnapshot dataSnapshot7;
            Iterator<DataSnapshot> it4;
            Iterator<Route.RouteTiming> it5;
            Thread currentThread = Thread.currentThread();
            StringBuilder i0 = hj1.i0("Scheduler Preprocesser : ");
            xt.t1 t1Var = xt.f3961a;
            i0.append(t1Var.k().d().getName());
            currentThread.setName(i0.toString());
            c50 c504 = s30.this.f3176a;
            Objects.requireNonNull(c504);
            c504.h = System.currentTimeMillis();
            c504.i = 0;
            ArrayList<TransitMode> arrayList2 = (ArrayList) t1Var.k().d().getModes();
            c504.g = arrayList2;
            Iterator<TransitMode> it6 = arrayList2.iterator();
            c50 c505 = c504;
            c50 c506 = c505;
            while (true) {
                if (!it6.hasNext()) {
                    z = true;
                    break;
                }
                TransitMode next = it6.next();
                if (!next.equals(TransitMode.bus)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    xt.t1 t1Var2 = xt.f3961a;
                    DatabaseReference child = t1Var2.A().i().child(next.toString().toUpperCase());
                    DatabaseReference child2 = t1Var2.A().d().child(next.toString().toUpperCase());
                    DataSnapshot b = ai1.b(child);
                    DataSnapshot b2 = ai1.b(child2);
                    c505.i = (System.currentTimeMillis() - currentTimeMillis) + c505.i;
                    if (!ai1.a(b, b2)) {
                        break;
                    }
                    System.currentTimeMillis();
                    v40 U = t1Var2.U();
                    Iterator<DataSnapshot> it7 = b.getChildren().iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            it = it6;
                            c50 = c506;
                            next.toString();
                            System.currentTimeMillis();
                            z2 = true;
                            break;
                        }
                        DataSnapshot next2 = it7.next();
                        if (Thread.interrupted()) {
                            z2 = false;
                            it = it6;
                            c50 = c506;
                            break;
                        }
                        DataSnapshot child3 = b2.child(next2.getKey());
                        Objects.requireNonNull(U);
                        String str4 = "pMap";
                        if (next2.hasChild("ft")) {
                            xt.t1 t1Var3 = xt.f3961a;
                            Route h = t1Var3.U().h(child3, next2, next);
                            String routeId = h.getRouteId();
                            c505.e.put(routeId, h.getRouteName());
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            List<Stop> stopSequence = h.getStopSequence();
                            it3 = it6;
                            if (stopSequence.contains(null)) {
                                t1Var3.A().o();
                                dataSnapshot3 = next2;
                                dataSnapshot4 = child3;
                                str = str4;
                                transitMode = next;
                                v40 = U;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                int i = 0;
                                while (i < stopSequence.size() - 1) {
                                    String id = stopSequence.get(i).getId();
                                    int i2 = i + 1;
                                    String id2 = stopSequence.get(i2).getId();
                                    arrayList3.add(id);
                                    arrayList4.add(ii1.k(id, id2));
                                    c50.b(c505.b, id, id2);
                                    c506 = c506;
                                    i = i2;
                                    U = U;
                                }
                                v40 = U;
                                arrayList3.add(((Stop) hj1.t(stopSequence, -1)).getId());
                                c505.c.put(routeId, arrayList3);
                                Iterator<Route.RouteTiming> it8 = h.getRouteTiming().iterator();
                                c506 = c506;
                                int i3 = -1;
                                while (it8.hasNext()) {
                                    Route.RouteTiming next3 = it8.next();
                                    if (!next3._isFrequency) {
                                        it5 = it8;
                                    } else {
                                        Pair<TimeInterval, Integer> pair = next3._frequencyTuple;
                                        int low = ((TimeInterval) pair.first).getLow();
                                        it5 = it8;
                                        int high = ((TimeInterval) pair.first).getHigh();
                                        int i4 = next3.duration;
                                        if (i4 != i3) {
                                            int intValue = ((Integer) pair.second).intValue();
                                            int i5 = intValue * 60;
                                            c50 c507 = c505;
                                            int size = arrayList4.size();
                                            it4 = it7;
                                            c50 c508 = c506;
                                            dataSnapshot7 = next2;
                                            double d = (((double) i4) * 1.0d) / ((double) size);
                                            String uuid = UUID.randomUUID().toString();
                                            int i6 = 0;
                                            while (i6 < size) {
                                                double d2 = ((double) i6) * d;
                                                double d3 = ((double) low) + d2;
                                                String str5 = (String) arrayList4.get(i6);
                                                ArrayList<k20> arrayList5 = new ArrayList<>();
                                                int i7 = low;
                                                String str6 = routeId;
                                                int i8 = 0;
                                                while (d3 < ((double) high) + d2) {
                                                    arrayList5.add(new NeighbouringStopTripInfo(d3, d3 + d, uuid + "_" + i8, str6, intValue));
                                                    d3 += (double) i5;
                                                    i8++;
                                                    i7 = i7;
                                                    str6 = str6;
                                                    high = high;
                                                }
                                                if (!c504.f521a.containsKey(str5)) {
                                                    c504.f521a.put(str5, arrayList5);
                                                } else {
                                                    c504.f521a.get(str5).addAll(arrayList5);
                                                }
                                                i6++;
                                                i5 = i5;
                                                c507 = c504;
                                                c508 = c507;
                                                next = next;
                                                str4 = str4;
                                                b2 = b2;
                                                arrayList4 = arrayList4;
                                                size = size;
                                                child3 = child3;
                                                low = i7;
                                                routeId = str6;
                                                high = high;
                                            }
                                            arrayList = arrayList4;
                                            dataSnapshot5 = child3;
                                            str3 = str4;
                                            transitMode2 = next;
                                            dataSnapshot6 = b2;
                                            str2 = routeId;
                                            c505 = c507;
                                            c506 = c508;
                                            i3 = -1;
                                            it8 = it5;
                                            it7 = it4;
                                            next2 = dataSnapshot7;
                                            next = transitMode2;
                                            str4 = str3;
                                            b2 = dataSnapshot6;
                                            arrayList4 = arrayList;
                                            child3 = dataSnapshot5;
                                            routeId = str2;
                                        }
                                    }
                                    arrayList = arrayList4;
                                    dataSnapshot7 = next2;
                                    dataSnapshot5 = child3;
                                    str3 = str4;
                                    transitMode2 = next;
                                    it4 = it7;
                                    dataSnapshot6 = b2;
                                    str2 = routeId;
                                    i3 = -1;
                                    it8 = it5;
                                    it7 = it4;
                                    next2 = dataSnapshot7;
                                    next = transitMode2;
                                    str4 = str3;
                                    b2 = dataSnapshot6;
                                    arrayList4 = arrayList;
                                    child3 = dataSnapshot5;
                                    routeId = str2;
                                }
                                dataSnapshot3 = next2;
                                dataSnapshot4 = child3;
                                str = str4;
                                transitMode = next;
                            }
                            it2 = it7;
                            dataSnapshot = b2;
                            c505.d.put(dataSnapshot4.getKey(), xt.f3961a.U().n(dataSnapshot4));
                            dataSnapshot2 = dataSnapshot3;
                            c505.f.put(dataSnapshot4.getKey(), c505.j.e(dataSnapshot2.child(str)));
                            c503 = c505;
                            c502 = c506;
                            next = transitMode;
                        } else {
                            it3 = it6;
                            c502 = c506;
                            dataSnapshot2 = next2;
                            v40 = U;
                            it2 = it7;
                            dataSnapshot = b2;
                            String key = child3.getKey();
                            xt.t1 t1Var4 = xt.f3961a;
                            RouteInfo i9 = t1Var4.U().i(child3, next);
                            String routeId2 = i9.getRouteId();
                            c505.e.put(routeId2, i9.getRouteName());
                            c505.d.put(routeId2, i9.getSpecialFeatures());
                            ArrayList<String> p = t1Var4.U().p(child3);
                            c505.c.put(key, p);
                            int size2 = p.size();
                            String str7 = p.get(0);
                            int i10 = 1;
                            while (i10 < size2) {
                                String str8 = p.get(i10);
                                c50.b(c505.b, str7, str8);
                                i10++;
                                str7 = str8;
                            }
                            c505.f.put(key, c505.j.e(dataSnapshot2.child(str4)));
                            c503 = c505;
                        }
                        if (dataSnapshot2.hasChild("Trips")) {
                            String key2 = dataSnapshot2.getKey();
                            ArrayList<String> arrayList6 = c503.c.get(key2);
                            if (dataSnapshot2.hasChild("dMap")) {
                                bi1 bi1 = c503.j;
                                DataSnapshot child4 = dataSnapshot2.child("dMap");
                                Objects.requireNonNull(bi1);
                                SparseIntArray sparseIntArray = new SparseIntArray(15);
                                for (DataSnapshot dataSnapshot8 : child4.getChildren()) {
                                    sparseIntArray.put(Integer.parseInt(dataSnapshot8.getKey()), Integer.parseInt(dataSnapshot8.getValue().toString()));
                                }
                                Iterator q0 = hj1.q0(dataSnapshot2, "Trips");
                                while (q0.hasNext()) {
                                    DataSnapshot dataSnapshot9 = (DataSnapshot) q0.next();
                                    if (ii1.t(hj1.E(dataSnapshot9, "wd"), vn.D0())) {
                                        int parseInt = Integer.parseInt(dataSnapshot9.child("st").getValue().toString());
                                        Objects.requireNonNull(c503.j);
                                        SparseIntArray sparseIntArray2 = new SparseIntArray(5);
                                        if (dataSnapshot9.hasChild("tt")) {
                                            Iterator q02 = hj1.q0(dataSnapshot9, "tt");
                                            while (q02.hasNext()) {
                                                DataSnapshot dataSnapshot10 = (DataSnapshot) q02.next();
                                                sparseIntArray2.put(Integer.parseInt(dataSnapshot10.getKey()), Integer.parseInt(dataSnapshot10.getValue().toString()));
                                            }
                                        }
                                        int size3 = arrayList6.size();
                                        SparseIntArray sparseIntArray3 = new SparseIntArray();
                                        for (int i11 = 0; i11 < size3; i11++) {
                                            sparseIntArray3.put(i11, sparseIntArray2.get(i11, sparseIntArray.get(i11)));
                                        }
                                        c504.c(dataSnapshot9, sparseIntArray3, arrayList6, parseInt, key2);
                                    }
                                }
                            } else {
                                Iterator q03 = hj1.q0(dataSnapshot2, "Trips");
                                while (q03.hasNext()) {
                                    DataSnapshot dataSnapshot11 = (DataSnapshot) q03.next();
                                    if (ii1.t(hj1.E(dataSnapshot11, "wd"), vn.D0())) {
                                        int parseInt2 = Integer.parseInt(dataSnapshot11.child("tt").child("s").getValue().toString());
                                        c504.c(dataSnapshot11, c503.j.c(dataSnapshot11, arrayList6.size(), parseInt2), arrayList6, parseInt2, key2);
                                    }
                                }
                            }
                        }
                        c505 = c503;
                        c506 = c502;
                        it6 = it3;
                        U = v40;
                        it7 = it2;
                        b2 = dataSnapshot;
                    }
                    if (!z2) {
                        next.toString();
                        c506 = c50;
                        break;
                    }
                    c506 = c50;
                    it6 = it;
                }
            }
            z = false;
            if (z) {
                c506.a(ad1.SUCCESS);
                c506.d(true);
            } else {
                c506.a(ad1.FAILED);
                c506.d(false);
            }
            System.currentTimeMillis();
        }
    }

    /* renamed from: s30$b */
    /* compiled from: OfflineSchedulerFeature */
    public enum b {
        NOT_STARTED,
        IN_PROGRESS,
        SUCCESSFUL,
        FAILED
    }

    /* renamed from: s30$c */
    /* compiled from: OfflineSchedulerFeature */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f3177a;
        public final String b;
        public final String c;
        public final String d;
        public final TransitMode e;

        public c(s30 s30, int i, String str, String str2, String str3, TransitMode transitMode) {
            this.f3177a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = transitMode;
        }
    }

    public s30() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    public final void a(c cVar) {
        jz5.b().g(new TripPlannerEvent(null, null, null, TripPlannerEvent.ResponseType.FAILED, cVar.d));
    }

    public void b() {
        b bVar = this.d;
        b bVar2 = b.IN_PROGRESS;
        if (!bVar.equals(bVar2) && !this.d.equals(b.SUCCESSFUL)) {
            this.d = bVar2;
            this.f3176a = new c50();
            a aVar = new a();
            ScheduledExecutorService scheduledExecutorService = e90.f946a;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.e = e90.f946a.schedule(new d90(aVar), 0, timeUnit);
        }
    }

    public final void c(c cVar) {
        try {
            t30 t30 = new t30(this, cVar);
            ScheduledExecutorService scheduledExecutorService = e90.f946a;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            e90.f946a.schedule(new d90(t30), 0, timeUnit);
        } catch (RejectedExecutionException unused) {
            a(cVar);
        }
    }

    public void onEventMainThread(PreProcessingDoneEvent preProcessingDoneEvent) {
        if (!this.d.equals(b.IN_PROGRESS)) {
            return;
        }
        if (preProcessingDoneEvent.getResponseType().equals(ad1.SUCCESS)) {
            this.d = b.SUCCESSFUL;
            this.b = new m50(this.f3176a);
            Iterator<c> it = this.c.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            this.c.clear();
            return;
        }
        this.d = b.FAILED;
        Iterator<c> it2 = this.c.iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
    }
}
