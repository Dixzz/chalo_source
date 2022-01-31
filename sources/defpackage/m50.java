package defpackage;

import app.zophop.models.NeighbouringStopTripInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import zophop.models.Leg;
import zophop.models.SPECIAL_FEATURE;
import zophop.models.StationType;
import zophop.models.Trip;
import zophop.models.TripAndArrivalInfoTuple;

/* renamed from: m50  reason: default package */
/* compiled from: TripTupleAndItinearyGenerator */
public class m50 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ArrayList<String>> f2328a;
    public final HashMap<String, ArrayList<k20>> b;
    public final HashMap<String, List<SPECIAL_FEATURE>> c;
    public final HashMap<String, String> d;

    public m50(c50 c50) {
        this.f2328a = c50.c;
        this.b = c50.f521a;
        this.c = c50.d;
        this.d = c50.e;
    }

    public final ArrayList<String> a(String str) {
        return this.f2328a.get(str);
    }

    public final ArrayList<SPECIAL_FEATURE> b(String str) {
        if (this.c.containsKey(str)) {
            return new ArrayList<>(this.c.get(str));
        }
        return new ArrayList<>();
    }

    public ArrayList<TripAndArrivalInfoTuple> c(Leg leg) {
        String str = leg.trip_id;
        String str2 = leg.route_id;
        TripAndArrivalInfoTuple tripAndArrivalInfoTuple = new TripAndArrivalInfoTuple();
        tripAndArrivalInfoTuple.setArrival_time(leg.start_time);
        tripAndArrivalInfoTuple.setPlatform(leg.platform);
        tripAndArrivalInfoTuple.setTrip(ii1.s(str, a(str2), str2, leg.station_type, leg.frequency, leg.route_name));
        ArrayList<TripAndArrivalInfoTuple> d2 = d(leg.first_stop_id, leg.last_stop_id, leg.start_time, 2, leg.station_type);
        String str3 = leg.trip_id;
        boolean isFrequencyTrip = tripAndArrivalInfoTuple.getTrip().isFrequencyTrip();
        Iterator<TripAndArrivalInfoTuple> it = d2.iterator();
        while (it.hasNext()) {
            Trip trip = it.next().getTrip();
            if (trip.isFrequencyTrip() && isFrequencyTrip) {
                it.remove();
            } else if (str3.equals(trip.getTrip_id())) {
                it.remove();
            }
        }
        tripAndArrivalInfoTuple.getTrip().setSpecial_features(b(leg.route_id));
        d2.add(0, tripAndArrivalInfoTuple);
        return d2;
    }

    public ArrayList<TripAndArrivalInfoTuple> d(String str, String str2, int i, int i2, StationType stationType) {
        char c2;
        int i3;
        xt.t1 t1Var = xt.f3961a;
        HashSet<String> c3 = ii1.c(t1Var.A().c(str), t1Var.A().c(str2));
        HashSet hashSet = new HashSet();
        Iterator<String> it = c3.iterator();
        while (true) {
            c2 = 0;
            i3 = -1;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            ArrayList<String> a2 = a(next);
            int indexOf = a2.indexOf(str);
            int indexOf2 = a2.indexOf(str2);
            if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
                c2 = 1;
            }
            if (c2 != 0) {
                hashSet.add(next);
            }
        }
        HashSet hashSet2 = new HashSet();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            ArrayList<String> a3 = a((String) it2.next());
            hashSet2.add(ii1.k(str, a3.get(a3.indexOf(str) + 1)));
        }
        ArrayList<TripAndArrivalInfoTuple> arrayList = new ArrayList<>();
        Iterator it3 = hashSet2.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            String str4 = str3.split(ProductDiscountsObject.KEY_DELIMITER)[c2];
            ArrayList<k20> arrayList2 = this.b.get(str3);
            ArrayList arrayList3 = new ArrayList();
            int m = ii1.m(arrayList2, i);
            if (m != i3) {
                while (arrayList3.size() < i2 && m < arrayList2.size()) {
                    String str5 = ((NeighbouringStopTripInfo) arrayList2.get(m)).routeId;
                    if (hashSet.contains(str5)) {
                        NeighbouringStopTripInfo neighbouringStopTripInfo = (NeighbouringStopTripInfo) arrayList2.get(m);
                        int i4 = neighbouringStopTripInfo.depTime;
                        String str6 = neighbouringStopTripInfo.tripId;
                        int i5 = neighbouringStopTripInfo.freqM;
                        String str7 = this.d.get(str5);
                        String str8 = neighbouringStopTripInfo.depPlatform;
                        TripAndArrivalInfoTuple tripAndArrivalInfoTuple = new TripAndArrivalInfoTuple();
                        tripAndArrivalInfoTuple.setArrival_time(i4);
                        tripAndArrivalInfoTuple.setTrip(ii1.s(str6, this.f2328a.get(str5), str5, stationType, i5, str7));
                        tripAndArrivalInfoTuple.setPlatform(str8);
                        arrayList3.add(tripAndArrivalInfoTuple);
                    }
                    m++;
                }
                arrayList.addAll(arrayList3);
                c2 = 0;
                i3 = -1;
            }
        }
        if (arrayList.size() == 0) {
            return arrayList;
        }
        Iterator<TripAndArrivalInfoTuple> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            TripAndArrivalInfoTuple next2 = it4.next();
            int arrival_time = next2.getArrival_time();
            if (arrival_time < 3600) {
                arrival_time += 86400;
            }
            next2.setArrival_time(arrival_time);
        }
        HashSet hashSet3 = new HashSet();
        int i6 = 1;
        while (i6 < arrayList.size()) {
            Trip trip = arrayList.get(i6).getTrip();
            String k = ii1.k(trip.getRoute_id(), trip.getTrip_id());
            if (hashSet3.contains(k)) {
                arrayList.remove(i6);
                i6--;
            } else {
                hashSet3.add(k);
            }
            i6++;
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (size > i2) {
            size = i2;
        }
        ArrayList<TripAndArrivalInfoTuple> arrayList4 = new ArrayList<>(arrayList.subList(0, size));
        Iterator<TripAndArrivalInfoTuple> it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            Trip trip2 = it5.next().getTrip();
            trip2.setSpecial_features(b(trip2.getRoute_id()));
        }
        return arrayList4;
    }
}
