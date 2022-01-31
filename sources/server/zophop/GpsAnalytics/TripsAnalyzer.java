package server.zophop.GpsAnalytics;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TripsAnalyzer {
    private final StopOnRouteOnRouteValidator stopOnRouteValidator = new StopOnRouteOnRouteValidator();

    private void addValidTripEntry(Agency agency, String str, RouteAccuracy routeAccuracy, List<Trip> list, String str2, List<StopArrivals> list2, int i) {
        PrintStream printStream = System.out;
        printStream.println(" accuracy " + i + "  valid trip !!!!!!!!! :)");
        for (StopArrivals stopArrivals : list2) {
            Date date = new Date(stopArrivals.get_arrivalTime());
            Date date2 = new Date(stopArrivals.get_departureTime());
            PrintStream printStream2 = System.out;
            printStream2.println(date.toString() + " " + date2.toString() + "  " + stopArrivals.get_vehicleNo() + " " + stopArrivals.get_stopSeqNum() + " " + stopArrivals.get_stop().getName() + " ");
        }
        list.add(new Trip(agency.getCity(), agency.getAgency(), "bus", str, str2, list2, routeAccuracy.getRoute(), list2.get(0).get_arrivalTime(), ((StopArrivals) hj1.t(list2, -1)).get_arrivalTime(), TripType.complete));
    }

    public Map<String, List<Trip>> discoverTrips(Agency agency, String str, List<GroupedStopArrivals> list, List<RouteAccuracy> list2, boolean z) {
        HashMap hashMap;
        List<String> list3;
        List<Trip> list4;
        int i;
        int i2;
        int i3;
        int i4;
        HashMap hashMap2;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i5;
        int i6;
        int i7;
        HashMap hashMap3 = new HashMap();
        RouteAccuracy routeAccuracy = list2.get(0);
        List<String> stopSequence = routeAccuracy.getRoute().getStopSequence();
        ArrayList arrayList3 = new ArrayList();
        int i8 = 0;
        while (i8 < stopSequence.size() / 4) {
            int i9 = 1;
            int i10 = 0;
            while (i10 < list.size()) {
                if (list.get(i10).getStop().getId().equalsIgnoreCase(stopSequence.get(i8))) {
                    if (i8 >= stopSequence.size() / 4) {
                        break;
                    }
                    PrintStream printStream = System.out;
                    StringBuilder i0 = hj1.i0("..............start with stop ");
                    i0.append(stopSequence.get(i8));
                    printStream.println(i0.toString());
                    PrintStream printStream2 = System.out;
                    printStream2.println(routeAccuracy.getRoute().getName() + "  ");
                    ArrayList arrayList4 = new ArrayList();
                    String uuid = UUID.randomUUID().toString();
                    ArrayList arrayList5 = new ArrayList();
                    int i11 = i10;
                    int i12 = i11;
                    int i13 = i12;
                    int i14 = i13;
                    int i15 = i8;
                    while (i13 < list.size()) {
                        if (!stopSequence.contains(list.get(i13).getStop().getId()) || arrayList4.contains(list.get(i13).getStop().getId())) {
                            i7 = i11;
                            i5 = i13;
                            arrayList2 = arrayList5;
                            hashMap2 = hashMap3;
                            i4 = i10;
                            i6 = i12;
                            arrayList = arrayList4;
                        } else {
                            i7 = i11;
                            hashMap2 = hashMap3;
                            i6 = i12;
                            i4 = i10;
                            arrayList = arrayList4;
                            if (!this.stopOnRouteValidator.validate(agency, list, routeAccuracy, stopSequence, i14, i15, i13)) {
                                i5 = i13;
                                arrayList2 = arrayList5;
                            } else {
                                i5 = i13;
                                long timestamp = list.get(i5).getTimestamp();
                                long timestamp2 = list.get(i5).getPoints().get(list.get(i5).getPoints().size() - i9).getTimestamp();
                                i15 = stopSequence.indexOf(list.get(i5).getStop().getId());
                                StopArrivals stopArrivals = new StopArrivals(agency.getCity(), agency.getAgency(), "bus", uuid, list.get(i5).getStop(), routeAccuracy.getRoute(), str, "", System.currentTimeMillis(), timestamp, timestamp2, i15);
                                PrintStream printStream3 = System.out;
                                printStream3.println(i5 + " " + list.get(i5).getStop().getName());
                                int i16 = arrayList5.size() == i9 ? i5 : i6;
                                arrayList2 = arrayList5;
                                arrayList2.add(stopArrivals);
                                arrayList.add(list.get(i5).getStop().getId());
                                i12 = i16;
                                i11 = i14;
                                i14 = i5;
                                i13 = i5 + 1;
                                arrayList5 = arrayList2;
                                arrayList4 = arrayList;
                                hashMap3 = hashMap2;
                                i10 = i4;
                            }
                        }
                        i11 = i7;
                        i12 = i6;
                        i13 = i5 + 1;
                        arrayList5 = arrayList2;
                        arrayList4 = arrayList;
                        hashMap3 = hashMap2;
                        i10 = i4;
                    }
                    hashMap = hashMap3;
                    i3 = i10;
                    int size = (arrayList5.size() * 100) / stopSequence.size();
                    if (size > 70 || (size > 50 && z)) {
                        i2 = i3;
                        i = i8;
                        list4 = arrayList3;
                        list3 = stopSequence;
                        addValidTripEntry(agency, str, routeAccuracy, list4, uuid, arrayList5, size);
                        list.subList(i12, i11).clear();
                        i10 = i2 + 1;
                        i9 = 1;
                        i8 = i;
                        arrayList3 = list4;
                        stopSequence = list3;
                        hashMap3 = hashMap;
                    }
                } else {
                    hashMap = hashMap3;
                    i3 = i10;
                }
                i = i8;
                list4 = arrayList3;
                list3 = stopSequence;
                i2 = i3;
                i10 = i2 + 1;
                i9 = 1;
                i8 = i;
                arrayList3 = list4;
                stopSequence = list3;
                hashMap3 = hashMap;
            }
            i8++;
            arrayList3 = arrayList3;
            stopSequence = stopSequence;
            hashMap3 = hashMap3;
        }
        hashMap3.put(routeAccuracy.getRoute().getId(), arrayList3);
        if (list2.size() > 1) {
            hashMap3.putAll(discoverTrips(agency, str, list, list2.subList(1, list2.size()), z));
        }
        new StopAnalyzerOld().report(agency, str, new ArrayList(), list, list2);
        return hashMap3;
    }
}
