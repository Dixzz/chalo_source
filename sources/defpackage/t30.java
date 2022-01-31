package defpackage;

import android.os.Process;
import app.zophop.models.ArrivalInfoTuple;
import app.zophop.models.NeighbouringStopTripInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import defpackage.s30;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;
import zophop.models.StationType;
import zophop.models.TripAndArrivalInfoTuple;
import zophop.models.TripPlannerResponse;

/* renamed from: t30  reason: default package */
/* compiled from: OfflineSchedulerFeature */
public class t30 implements Runnable {
    public final /* synthetic */ s30.c f;
    public final /* synthetic */ s30 g;

    public t30(s30 s30, s30.c cVar) {
        this.g = s30;
        this.f = cVar;
    }

    public void run() {
        Itinerary itinerary;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        NeighbouringStopTripInfo neighbouringStopTripInfo;
        boolean z4;
        Process.setThreadPriority(10);
        Thread currentThread = Thread.currentThread();
        StringBuilder i0 = hj1.i0("Scheduler Query ");
        i0.append(this.f.b);
        i0.append(ProductDiscountsObject.KEY_DELIMITER);
        i0.append(this.f.c);
        i0.append(ProductDiscountsObject.KEY_DELIMITER);
        i0.append(this.f.f3177a);
        currentThread.setName(i0.toString());
        System.currentTimeMillis();
        d50 d50 = new d50(this.g.f3176a);
        s30.c cVar = this.f;
        int i3 = cVar.f3177a;
        String str = cVar.b;
        String str2 = cVar.c;
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList(d50.a(str, str2, i3, 5));
        System.currentTimeMillis();
        arrayList.size();
        d50.b = new HashMap<>();
        d50.f788a = new HashMap<>();
        if (!(this.g.b == null || Thread.interrupted())) {
            m50 m50 = this.g.b;
            s30.c cVar2 = this.f;
            int i4 = cVar2.f3177a;
            TransitMode transitMode = cVar2.e;
            Objects.requireNonNull(m50);
            StationType stationType = StationType.getStationType(transitMode.toString());
            ArrayList<Itinerary> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (true) {
                int i5 = Integer.MAX_VALUE;
                if (!it.hasNext()) {
                    break;
                }
                ArrayList arrayList3 = (ArrayList) it.next();
                Itinerary itinerary2 = new Itinerary();
                itinerary2.legs = new ArrayList<>();
                Leg leg = new Leg();
                int i6 = 0;
                int i7 = i4;
                while (true) {
                    if (i6 >= arrayList3.size() - 1) {
                        String str3 = ((ArrivalInfoTuple) arrayList3.get(arrayList3.size() - 1)).destinationStopId;
                        leg.mode = LegMode.getMode(stationType);
                        leg.station_type = stationType;
                        ii1.v(leg, str3);
                        leg.end_time = i7;
                        ii1.a(leg, m50.c(leg));
                        itinerary2.legs.add(leg);
                        itinerary2.number_of_transfers = itinerary2.legs.size() - 1;
                        itinerary2.time_taken = (double) (((i7 - i4) + 86400) % 86400);
                        break;
                    }
                    int i8 = i6 + 1;
                    NeighbouringStopTripInfo neighbouringStopTripInfo2 = (NeighbouringStopTripInfo) ((ArrivalInfoTuple) arrayList3.get(i8)).destInfo;
                    if (neighbouringStopTripInfo2.tripId == null || neighbouringStopTripInfo2.depTime == i5) {
                        String str4 = ((ArrivalInfoTuple) arrayList3.get(i6)).destinationStopId;
                        String str5 = ((ArrivalInfoTuple) arrayList3.get(i8)).destinationStopId;
                        itinerary2 = null;
                    } else {
                        if (!(leg.trip_id == null || leg.route_id == null)) {
                            if (!leg.route_id.equals(neighbouringStopTripInfo2.routeId)) {
                                z4 = false;
                            } else {
                                z4 = leg.trip_id.equals(neighbouringStopTripInfo2.tripId);
                            }
                            if (z4) {
                                i7 = neighbouringStopTripInfo2.arrTime;
                                i5 = Integer.MAX_VALUE;
                                i6 = i8;
                            }
                        }
                        if (!(leg.trip_id == null || leg.route_id == null)) {
                            String str6 = ((ArrivalInfoTuple) arrayList3.get(i6)).destinationStopId;
                            leg.mode = LegMode.getMode(stationType);
                            leg.station_type = stationType;
                            ii1.v(leg, str6);
                            leg.end_time = i7;
                            ii1.a(leg, m50.c(leg));
                            itinerary2.legs.add(leg);
                        }
                        String str7 = ((ArrivalInfoTuple) arrayList3.get(i6)).destinationStopId;
                        leg = new Leg();
                        leg.mode = LegMode.getMode(stationType);
                        leg.station_type = stationType;
                        leg.start_time = neighbouringStopTripInfo2.depTime;
                        int i9 = neighbouringStopTripInfo2.freqM;
                        leg.isFrequencyLeg = i9 > 0;
                        leg.frequency = i9;
                        leg.route_id = neighbouringStopTripInfo2.routeId;
                        leg.trip_id = neighbouringStopTripInfo2.tripId;
                        leg.platform = neighbouringStopTripInfo2.depPlatform;
                        ii1.u(leg, str7);
                        leg.route_name = m50.d.get(leg.route_id);
                        leg.special_features = m50.b(leg.route_id);
                        i7 = neighbouringStopTripInfo2.arrTime;
                        i5 = Integer.MAX_VALUE;
                        i6 = i8;
                    }
                }
                if (itinerary2 != null) {
                    arrayList2.add(itinerary2);
                }
            }
            arrayList2.size();
            TripPlannerResponse tripPlannerResponse = new TripPlannerResponse();
            Iterator<Itinerary> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Itinerary next = it2.next();
                int size = next.legs.size() - 1;
                while (size > 0) {
                    Leg leg2 = next.legs.get(size);
                    size--;
                    Leg leg3 = next.legs.get(size);
                    leg2.extraTrips.extraTrips.get(0);
                    leg3.extraTrips.extraTrips.get(0);
                    String str8 = leg3.first_stop_id;
                    String str9 = leg2.last_stop_id;
                    String str10 = leg2.route_id;
                    ArrayList<String> a2 = m50.a(str10);
                    int indexOf = a2.indexOf(str8);
                    int indexOf2 = a2.indexOf(str9);
                    if (indexOf != -1 && indexOf < indexOf2) {
                        ArrayList<k20> arrayList4 = m50.b.get(ii1.k(a2.get(indexOf), a2.get(indexOf + 1)));
                        int m = ii1.m(arrayList4, leg3.start_time);
                        if (m != -1) {
                            while (true) {
                                if (m >= arrayList4.size()) {
                                    neighbouringStopTripInfo = ii1.j();
                                    break;
                                } else if (((NeighbouringStopTripInfo) arrayList4.get(m)).routeId.equals(str10)) {
                                    neighbouringStopTripInfo = (NeighbouringStopTripInfo) arrayList4.get(m);
                                    break;
                                } else {
                                    m++;
                                }
                            }
                        } else {
                            neighbouringStopTripInfo = ii1.j();
                        }
                        if (leg2.trip_id.equals(neighbouringStopTripInfo.tripId)) {
                            ii1.u(leg2, str8);
                            leg2.start_time = neighbouringStopTripInfo.depTime;
                            leg2.platform = neighbouringStopTripInfo.depPlatform;
                            leg2.extraTrips.extraTrips.clear();
                            ii1.a(leg2, m50.c(leg2));
                            next.legs.remove(leg3);
                            next.number_of_transfers--;
                        }
                    }
                    it2 = it2;
                }
            }
            arrayList2.size();
            Collections.sort(arrayList2);
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                int i11 = 0;
                while (i11 < size2 - 1) {
                    Itinerary itinerary3 = arrayList2.get(i11);
                    i11++;
                    Itinerary itinerary4 = arrayList2.get(i11);
                    if (itinerary3.time_taken == itinerary4.time_taken && itinerary3.number_of_transfers > itinerary4.number_of_transfers) {
                        arrayList2.remove(itinerary3);
                        arrayList2.add(i11, itinerary3);
                    }
                }
            }
            arrayList2.size();
            if (arrayList2.size() >= 2) {
                int i12 = 0;
                while (i12 < arrayList2.size()) {
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (i14 < arrayList2.size()) {
                        Itinerary itinerary5 = arrayList2.get(i12);
                        Itinerary itinerary6 = arrayList2.get(i14);
                        if (itinerary5.number_of_transfers == itinerary6.number_of_transfers) {
                            ArrayList<Leg> arrayList5 = itinerary5.legs;
                            ArrayList<Leg> arrayList6 = itinerary6.legs;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= arrayList5.size()) {
                                    i2 = i12;
                                    i = i13;
                                    z2 = true;
                                    break;
                                }
                                Leg leg4 = arrayList6.get(i15);
                                Leg leg5 = arrayList5.get(i15);
                                i2 = i12;
                                i = i13;
                                if (!leg5.start_place_name.equals(leg4.start_place_name) || !leg5.end_place_name.equals(leg4.end_place_name)) {
                                    z2 = false;
                                } else {
                                    i15++;
                                    i12 = i2;
                                    i13 = i;
                                }
                            }
                            z2 = false;
                            if (!z2) {
                                ArrayList<Leg> arrayList7 = itinerary5.legs;
                                ArrayList<Leg> arrayList8 = itinerary6.legs;
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= arrayList7.size()) {
                                        z3 = true;
                                        break;
                                    } else if (!arrayList7.get(i16).extraTrips.extraTrips.get(0).getTrip().getTrip_id().equals(arrayList8.get(i16).extraTrips.extraTrips.get(0).getTrip().getTrip_id())) {
                                        z3 = false;
                                        break;
                                    } else {
                                        i16++;
                                    }
                                }
                                if (!z3) {
                                }
                            }
                            arrayList2.remove(i14);
                            i14--;
                        } else {
                            i2 = i12;
                            i = i13;
                        }
                        i14++;
                        i12 = i2;
                        i13 = i;
                    }
                    i12 = i13;
                }
            }
            arrayList2.size();
            arrayList2.size();
            if (arrayList2.size() >= 2) {
                Itinerary itinerary7 = arrayList2.get(0);
                double d = itinerary7.time_taken * 2.0d;
                Iterator<Itinerary> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    Itinerary next2 = it3.next();
                    double d2 = next2.time_taken;
                    if (d2 > d) {
                        it3.remove();
                    } else if (d2 > itinerary7.time_taken && next2.number_of_transfers > itinerary7.number_of_transfers + 2) {
                        it3.remove();
                    }
                }
            }
            arrayList2.size();
            int i17 = 0;
            while (i17 < arrayList2.size()) {
                Itinerary itinerary8 = arrayList2.get(i17);
                i17++;
                int i18 = i17;
                while (i18 < arrayList2.size()) {
                    Itinerary itinerary9 = arrayList2.get(i18);
                    if (itinerary9.time_taken > itinerary8.time_taken) {
                        if (itinerary9.number_of_transfers < itinerary8.number_of_transfers) {
                            z = false;
                        } else {
                            z = vn.H(itinerary9).containsAll(vn.H(itinerary8));
                        }
                        if (z) {
                            arrayList2.remove(i18);
                            i18--;
                        }
                    }
                    i18++;
                }
            }
            arrayList2.size();
            if (arrayList2.size() != 0) {
                Iterator<Itinerary> it4 = arrayList2.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        if (it4.next().legs.size() == 1) {
                            break;
                        }
                    } else {
                        ArrayList<Leg> arrayList9 = arrayList2.get(0).legs;
                        int size3 = arrayList9.size();
                        String str11 = arrayList9.get(0).first_stop_id;
                        String str12 = arrayList9.get(size3 - 1).last_stop_id;
                        ArrayList<TripAndArrivalInfoTuple> d3 = m50.d(str11, str12, i4, 2, stationType);
                        if (d3.size() == 0) {
                            itinerary = null;
                        } else {
                            Leg leg6 = new Leg();
                            leg6.mode = LegMode.getMode(stationType);
                            leg6.station_type = stationType;
                            ii1.u(leg6, str11);
                            ii1.v(leg6, str12);
                            ii1.a(leg6, d3);
                            leg6.start_time = d3.get(0).getArrival_time();
                            ArrayList<String> a3 = m50.a(d3.get(0).getTrip().getRoute_id());
                            ArrayList arrayList10 = new ArrayList(a3.subList(a3.indexOf(str11), a3.indexOf(str12) + 1));
                            int i19 = leg6.start_time;
                            HashMap<String, ArrayList<k20>> hashMap = m50.b;
                            int i20 = 0;
                            while (i20 < arrayList10.size() - 1) {
                                i20++;
                                i19 = ii1.l(hashMap.get(ii1.k((String) arrayList10.get(i20), (String) arrayList10.get(i20))), i19).arrTime;
                                if (i19 == Integer.MAX_VALUE) {
                                    break;
                                }
                            }
                            leg6.end_time = i19;
                            itinerary = new Itinerary();
                            itinerary.number_of_transfers = 0;
                            ArrayList<Leg> arrayList11 = new ArrayList<>();
                            itinerary.legs = arrayList11;
                            arrayList11.add(leg6);
                            itinerary.time_taken = (double) (leg6.end_time - i4);
                        }
                        if (itinerary != null) {
                            arrayList2.add(itinerary);
                        }
                    }
                }
            }
            arrayList2.size();
            tripPlannerResponse.itineraries = arrayList2;
            System.currentTimeMillis();
            jz5.b().i(new TripPlannerEvent(null, "raw", tripPlannerResponse, TripPlannerEvent.ResponseType.SUCCESS, this.f.d));
        }
    }
}
