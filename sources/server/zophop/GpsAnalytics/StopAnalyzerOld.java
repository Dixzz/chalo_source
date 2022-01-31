package server.zophop.GpsAnalytics;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StopAnalyzerOld {
    private final IStopOnRouteValidator stopValidator = new StopOnRouteOnRouteValidator();

    private String getTripId() {
        return UUID.randomUUID().toString();
    }

    private int getValidRoutesSize(List<String> list) {
        if (list.size() != 0) {
            return list.size();
        }
        return 99;
    }

    private void printAllValidRoutes(List<RouteAccuracy> list, int i) {
        int i2 = 0;
        while (i2 < list.size() && i2 < i) {
            RouteAccuracy routeAccuracy = list.get(i2);
            PrintStream printStream = System.out;
            printStream.println(routeAccuracy.getRoute().getId() + "   " + routeAccuracy.getRoute().getName() + routeAccuracy.getAccuracy());
            i2++;
        }
    }

    public Map<String, List<Trip>> report(Agency agency, String str, List<String> list, List<GroupedStopArrivals> list2, List<RouteAccuracy> list3) {
        String str2;
        int i;
        int i2;
        int i3;
        ArrayList arrayList;
        int i4;
        int i5;
        int i6;
        ArrayList arrayList2;
        String str3;
        ArrayList arrayList3;
        int i7;
        HashMap hashMap;
        StopAnalyzerOld stopAnalyzerOld = this;
        List<RouteAccuracy> list4 = list3;
        HashMap hashMap2 = new HashMap();
        int validRoutesSize = stopAnalyzerOld.getValidRoutesSize(list);
        stopAnalyzerOld.printAllValidRoutes(list4, validRoutesSize);
        int i8 = 0;
        int i9 = 0;
        while (i9 < list3.size() && i9 < validRoutesSize) {
            RouteAccuracy routeAccuracy = list4.get(i9);
            List<String> stopSequence = routeAccuracy.getRoute().getStopSequence();
            ArrayList arrayList4 = new ArrayList();
            int i10 = 0;
            while (true) {
                str2 = "  ";
                if (i10 >= list2.size()) {
                    break;
                }
                if (list2.get(i10).getStop().getId().equalsIgnoreCase(stopSequence.get(i8))) {
                    PrintStream printStream = System.out;
                    StringBuilder i0 = hj1.i0("----Stop Arrival for Route---- ");
                    i0.append(routeAccuracy.getRoute().getName());
                    printStream.println(i0.toString());
                    ArrayList arrayList5 = new ArrayList();
                    HashMap hashMap3 = new HashMap();
                    String tripId = getTripId();
                    int i11 = i10;
                    int i12 = i11;
                    int i13 = 0;
                    while (i11 < list2.size()) {
                        if (!stopSequence.contains(list2.get(i11).getStop().getId()) || hashMap3.containsKey(list2.get(i11).getStop().getId())) {
                            hashMap = hashMap3;
                            arrayList3 = arrayList5;
                            i5 = i10;
                            i6 = validRoutesSize;
                            i4 = i9;
                            i7 = i11;
                            str3 = str2;
                            arrayList2 = arrayList4;
                        } else {
                            IStopOnRouteValidator iStopOnRouteValidator = stopAnalyzerOld.stopValidator;
                            hashMap = hashMap3;
                            arrayList3 = arrayList5;
                            i6 = validRoutesSize;
                            str3 = str2;
                            i5 = i10;
                            i4 = i9;
                            arrayList2 = arrayList4;
                            if (!iStopOnRouteValidator.validate(agency, list2, routeAccuracy, stopSequence, i12, i13, i11)) {
                                i7 = i11;
                            } else {
                                i7 = i11;
                                long timestamp = list2.get(i7).getTimestamp();
                                long timestamp2 = list2.get(i7).getPoints().get(list2.get(i7).getPoints().size() - 1).getTimestamp();
                                int indexOf = stopSequence.indexOf(list2.get(i7).getStop().getId());
                                arrayList3.add(new StopArrivals(agency.getCity(), agency.getAgency(), "bus", tripId, list2.get(i7).getStop(), routeAccuracy.getRoute(), str, "", System.currentTimeMillis(), timestamp, timestamp2, indexOf));
                                hashMap.put(list2.get(i7).getStop().getId(), Long.valueOf(list2.get(i7).getTimestamp()));
                                i13 = indexOf;
                                i12 = i7;
                            }
                        }
                        i11 = i7 + 1;
                        hashMap3 = hashMap;
                        arrayList5 = arrayList3;
                        str2 = str3;
                        arrayList4 = arrayList2;
                        validRoutesSize = i6;
                        i10 = i5;
                        i9 = i4;
                        stopAnalyzerOld = this;
                    }
                    i2 = i10;
                    i3 = validRoutesSize;
                    i = i9;
                    arrayList = arrayList4;
                    Iterator it = arrayList5.iterator();
                    while (it.hasNext()) {
                        StopArrivals stopArrivals = (StopArrivals) it.next();
                        Date date = new Date(stopArrivals.get_arrivalTime());
                        PrintStream printStream2 = System.out;
                        printStream2.println(date.toString() + str2 + stopArrivals.get_vehicleNo() + " " + stopArrivals.get_stopSeqNum() + " " + stopArrivals.get_stop().getName() + " ");
                    }
                    arrayList.add(new Trip(agency.getCity(), agency.getAgency(), "bus", str, tripId, arrayList5, routeAccuracy.getRoute(), ((StopArrivals) arrayList5.get(0)).get_arrivalTime(), ((StopArrivals) arrayList5.get(arrayList5.size() - 1)).get_arrivalTime()));
                } else {
                    i2 = i10;
                    i3 = validRoutesSize;
                    i = i9;
                    arrayList = arrayList4;
                }
                i10 = i2 + 1;
                i8 = 0;
                stopAnalyzerOld = this;
                arrayList4 = arrayList;
                validRoutesSize = i3;
                i9 = i;
            }
            hashMap2.put(routeAccuracy.getRoute().getId(), arrayList4);
            PrintStream printStream3 = System.out;
            printStream3.println(routeAccuracy.getRoute().getName() + str2 + routeAccuracy.getRoute().getStopSequence().get(0) + "   " + routeAccuracy.getRoute().getStopSequence().get(routeAccuracy.getRoute().getStopSequence().size() - 1) + str2 + routeAccuracy.getRoute().getId() + "   " + routeAccuracy.getAccuracy());
            i9++;
            i8 = 0;
            stopAnalyzerOld = this;
            list4 = list3;
            validRoutesSize = validRoutesSize;
        }
        return hashMap2;
    }
}
