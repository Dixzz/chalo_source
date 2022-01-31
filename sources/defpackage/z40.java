package defpackage;

import android.os.Handler;
import android.util.SparseIntArray;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: z40  reason: default package */
/* compiled from: ScheduleFeature */
public class z40 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ TransitMode h;
    public final /* synthetic */ Handler i;
    public final /* synthetic */ w40 j;

    public z40(w40 w40, String str, String str2, TransitMode transitMode, Handler handler) {
        this.j = w40;
        this.f = str;
        this.g = str2;
        this.h = transitMode;
        this.i = handler;
    }

    public void run() {
        Trip trip;
        Trip trip2;
        bi1 bi1 = new bi1();
        System.currentTimeMillis();
        String str = this.f;
        String str2 = this.g;
        TransitMode transitMode = this.h;
        xt.t1 t1Var = xt.f3961a;
        DatabaseReference child = t1Var.A().i().child(transitMode.toString().toUpperCase()).child(str);
        DatabaseReference child2 = child.child("Trips").child(str2);
        DataSnapshot b = ai1.b(t1Var.A().d().child(transitMode.toString().toUpperCase()).child(str));
        DataSnapshot b2 = ai1.b(child2);
        String key = b.getKey();
        String key2 = b2.getKey();
        String E = hj1.E(b2, "wd");
        int D0 = vn.D0();
        if (!ai1.a(b, b2) || !ii1.t(E, D0)) {
            trip = bi1.h(false, key2, null);
        } else {
            v40 U = t1Var.U();
            DataSnapshot child3 = b.child("seq");
            Objects.requireNonNull(U);
            ArrayList<Stop> arrayList = new ArrayList<>((int) child3.getChildrenCount());
            i30 A = t1Var.A();
            for (DataSnapshot dataSnapshot : child3.getChildren()) {
                arrayList.add(Integer.parseInt(dataSnapshot.getKey()), A.e(dataSnapshot.getValue().toString(), transitMode));
            }
            List<SPECIAL_FEATURE> n = b.hasChild("sf") ? xt.f3961a.U().n(b) : null;
            String key3 = b2.getKey();
            DataSnapshot b3 = ai1.b(child.child("dMap"));
            if (ai1.a(b3)) {
                long parseLong = Long.parseLong(b2.child("st").getValue().toString());
                DataSnapshot b4 = ai1.b(child.child("pMap"));
                HashMap<Integer, Integer> b5 = bi1.b(bi1.f(b3), b2);
                HashMap<Integer, String> e = bi1.e(b4);
                e.putAll(bi1.d(b2));
                Trip trip3 = new Trip(b2.getKey(), transitMode, bi1.i(arrayList, (int) parseLong, e, b5), n);
                trip3.set_routeId(key);
                trip = bi1.h(true, key3, trip3);
            } else {
                int parseInt = Integer.parseInt(b2.child("tt").child("s").getValue().toString());
                SparseIntArray c = bi1.c(b2, arrayList.size(), parseInt);
                if (c == null) {
                    trip2 = null;
                } else {
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        hashMap.put(Integer.valueOf(i2), Integer.valueOf(c.get(i2)));
                    }
                    trip2 = new Trip(b2.getKey(), transitMode, bi1.i(arrayList, parseInt, new HashMap(), hashMap), n);
                }
                if (trip2 != null) {
                    trip2.set_routeId(key);
                    trip = bi1.h(true, key3, trip2);
                } else {
                    trip = bi1.h(false, key3, null);
                }
            }
        }
        System.currentTimeMillis();
        w40 w40 = this.j;
        Handler handler = this.i;
        Objects.requireNonNull(w40);
        jz5.b().i(trip);
        handler.getLooper().quit();
        this.i.getLooper().quit();
    }
}
