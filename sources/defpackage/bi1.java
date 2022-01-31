package defpackage;

import android.util.SparseIntArray;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import app.zophop.models.TripLeg;
import app.zophop.models.http_response.TripSummary;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: bi1  reason: default package */
/* compiled from: FirebaseTripReader */
public class bi1 {
    public final void a(ArrayList<TripSummary> arrayList, ArrayList<String> arrayList2, TransitMode transitMode, DataSnapshot dataSnapshot, DataSnapshot dataSnapshot2, int i) {
        int i2;
        HashMap<Integer, Integer> hashMap;
        int i3;
        xt.t1 t1Var = xt.f3961a;
        i30 A = t1Var.A();
        Stop e = A.e(arrayList2.get(0), transitMode);
        Stop e2 = A.e(arrayList2.get(arrayList2.size() - 1), transitMode);
        List<SPECIAL_FEATURE> n = t1Var.U().n(dataSnapshot);
        if (dataSnapshot2.hasChild("dMap")) {
            DataSnapshot child = dataSnapshot2.child("dMap");
            String str = dataSnapshot2.hasChild("pMap") ? e(dataSnapshot2.child("pMap")).get(Integer.valueOf(i)) : null;
            HashMap<Integer, Integer> f = f(child);
            int D0 = vn.D0();
            RouteInfo c = new rv().c(dataSnapshot, dataSnapshot.getKey(), transitMode);
            Iterator q0 = hj1.q0(dataSnapshot2, "Trips");
            while (q0.hasNext()) {
                DataSnapshot dataSnapshot3 = (DataSnapshot) q0.next();
                if (ii1.t(dataSnapshot3.child("wd").getValue().toString(), D0)) {
                    int parseInt = Integer.parseInt(dataSnapshot3.child("st").getValue().toString());
                    HashMap<Integer, Integer> b = b(f, dataSnapshot3);
                    int i4 = parseInt;
                    for (int i5 = 0; i5 < i; i5++) {
                        i4 += b.get(Integer.valueOf(i5)).intValue();
                    }
                    hashMap = f;
                    i3 = D0;
                    TripSummary tripSummary = new TripSummary(dataSnapshot3.getKey(), i4, e, e2, e2, c.getRouteId(), c.getRouteName(), false, c.getSpecialFeatures());
                    tripSummary.setAgencyName(c.getAgencyName());
                    String str2 = d(dataSnapshot3).get(Integer.valueOf(i));
                    if (str2 == null) {
                        str2 = str;
                    }
                    tripSummary.setPlatform(str2);
                    arrayList.add(tripSummary);
                } else {
                    hashMap = f;
                    i3 = D0;
                }
                f = hashMap;
                D0 = i3;
            }
            return;
        }
        Route h = t1Var.U().h(dataSnapshot, dataSnapshot2, transitMode);
        int size = arrayList2.size();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i6 = 86400;
        for (Route.RouteTiming routeTiming : h.getRouteTiming()) {
            if (routeTiming._isFrequency) {
                arrayList4.add(routeTiming._frequencyTuple);
                if (((TimeInterval) routeTiming._frequencyTuple.first).getLow() < i6) {
                    i6 = ((TimeInterval) routeTiming._frequencyTuple.first).getLow();
                } else {
                    i2 = i6;
                }
            } else {
                int i7 = routeTiming._startTime;
                i2 = i6;
                TripSummary tripSummary2 = new TripSummary(routeTiming._tripId, (int) Math.round((((((double) routeTiming.duration) * 1.0d) / ((double) (size - 1))) * ((double) i)) + ((double) i7)), e, e2, h.getDirectionStop(), h.getRouteId(), h.getRouteName(), false, n);
                tripSummary2.setAgencyName(h.getAgencyName());
                arrayList3.add(tripSummary2);
            }
            i6 = i2;
        }
        TripSummary tripSummary3 = new TripSummary(null, i6, e, e2, h.getDirectionStop(), h.getRouteId(), h.getRouteName(), true, n);
        tripSummary3.setFrequencyList(arrayList4);
        tripSummary3.setAgencyName(h.getAgencyName());
        arrayList3.add(tripSummary3);
        arrayList.addAll(arrayList3);
    }

    public HashMap<Integer, Integer> b(HashMap<Integer, Integer> hashMap, DataSnapshot dataSnapshot) {
        HashMap<Integer, Integer> hashMap2 = new HashMap<>(hashMap);
        HashMap hashMap3 = new HashMap();
        if (dataSnapshot.hasChild("tt")) {
            Iterator q0 = hj1.q0(dataSnapshot, "tt");
            while (q0.hasNext()) {
                DataSnapshot dataSnapshot2 = (DataSnapshot) q0.next();
                hashMap3.put(Integer.valueOf(Integer.parseInt(dataSnapshot2.getKey())), Integer.valueOf(Integer.parseInt(dataSnapshot2.getValue().toString())));
            }
        }
        hashMap2.putAll(hashMap3);
        return hashMap2;
    }

    public SparseIntArray c(DataSnapshot dataSnapshot, int i, int i2) {
        int i3;
        if (dataSnapshot.child("tt").hasChild("e")) {
            i3 = Integer.parseInt(dataSnapshot.child("tt").child("e").getValue().toString());
        } else {
            i3 = dataSnapshot.hasChild("d") ? Integer.parseInt(dataSnapshot.child("d").getValue().toString()) + i2 : -1;
        }
        if (i3 == -1) {
            return null;
        }
        int i4 = i - 1;
        int round = (int) Math.round((((double) (i3 - i2)) * 1.0d) / ((double) i4));
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i5 = 0; i5 < i4; i5++) {
            sparseIntArray.put(i5, round);
        }
        return sparseIntArray;
    }

    public HashMap<Integer, String> d(DataSnapshot dataSnapshot) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        if (dataSnapshot.hasChild("p")) {
            Iterator q0 = hj1.q0(dataSnapshot, "p");
            while (q0.hasNext()) {
                DataSnapshot dataSnapshot2 = (DataSnapshot) q0.next();
                hashMap.put(Integer.valueOf(Integer.parseInt(dataSnapshot2.getKey())), dataSnapshot2.getValue().toString());
            }
        }
        return hashMap;
    }

    public HashMap<Integer, String> e(DataSnapshot dataSnapshot) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        if (!(dataSnapshot == null || dataSnapshot.getValue() == null)) {
            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                hashMap.put(Integer.valueOf(Integer.parseInt(dataSnapshot2.getKey())), dataSnapshot2.getValue().toString());
            }
        }
        return hashMap;
    }

    public HashMap<Integer, Integer> f(DataSnapshot dataSnapshot) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            hashMap.put(Integer.valueOf(Integer.parseInt(dataSnapshot2.getKey())), Integer.valueOf(Integer.parseInt(dataSnapshot2.getValue().toString())));
        }
        return hashMap;
    }

    public final DataSnapshot g(String str, TransitMode transitMode) {
        DatabaseReference child = xt.f3961a.A().i().child(transitMode.toString().toUpperCase()).child(str);
        String str2 = "tripsBaseRef = " + child;
        return ai1.b(child);
    }

    public final Trip h(boolean z, String str, Trip trip) {
        return z ? trip : new Trip(str, null, null, null);
    }

    public final ArrayList<TripLeg> i(ArrayList<Stop> arrayList, int i, Map<Integer, String> map, Map<Integer, Integer> map2) {
        TripLeg tripLeg;
        int size = arrayList.size();
        ArrayList<TripLeg> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            Stop stop = arrayList.get(i2);
            if (i2 == 0) {
                tripLeg = new TripLeg(stop, i);
            } else {
                int intValue = map2.get(Integer.valueOf(i2 - 1)).intValue() + i;
                tripLeg = new TripLeg(stop, intValue);
                i = intValue;
            }
            if (map.get(Integer.valueOf(i2)) != null) {
                tripLeg.setPlatform(map.get(Integer.valueOf(i2)));
            }
            arrayList2.add(tripLeg);
        }
        return arrayList2;
    }
}
