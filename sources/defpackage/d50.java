package defpackage;

import android.util.Pair;
import app.zophop.models.ArrivalInfoTuple;
import app.zophop.models.NeighbouringStopTripInfo;
import com.google.firebase.appindexing.Indexable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import server.zophop.logicLayer.CsLogic;

/* renamed from: d50  reason: default package */
/* compiled from: SchedulesGenerator */
public class d50 {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, HashSet<String>> f788a;
    public HashMap<String, ArrayList<k20>> b;
    public int c = Integer.MAX_VALUE;

    public d50(c50 c50) {
        HashMap<String, HashSet<String>> hashMap = c50.b;
        this.f788a = new HashMap<>();
        synchronized (hashMap) {
            for (String str : hashMap.keySet()) {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.addAll(hashMap.get(str));
                this.f788a.put(str, hashSet);
            }
        }
        this.b = c50.f521a;
        new HashSet();
        new HashSet();
        new HashSet();
    }

    public final ArrayList<ArrayList<ArrivalInfoTuple>> a(String str, String str2, int i, int i2) {
        int i3 = i2;
        ArrayList<ArrayList<ArrivalInfoTuple>> arrayList = new ArrayList<>();
        ArrayList<ArrivalInfoTuple> c2 = c(str, str2, i, new HashSet<>());
        if (c2 != null) {
            arrayList.add(c2);
            int edgeDjikstraWeight = c2.get(c2.size() - 1).destInfo.getEdgeDjikstraWeight();
            this.c = (edgeDjikstraWeight - i) + edgeDjikstraWeight;
        }
        if (arrayList.size() == 0) {
            return i < 86400 ? a(str, str2, i + 86400, i3) : arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i4 = 1;
        while (i4 <= i3) {
            if (arrayList.size() >= i4) {
                ArrayList arrayList3 = new ArrayList();
                int i5 = 1;
                while (true) {
                    int i6 = i4 - 1;
                    if (i5 >= arrayList.get(i6).size()) {
                        break;
                    }
                    String str3 = arrayList.get(i6).get(i5).destinationStopId;
                    NeighbouringStopTripInfo neighbouringStopTripInfo = (NeighbouringStopTripInfo) arrayList.get(i6).get(i5).destInfo;
                    int i7 = 0;
                    ArrayList arrayList4 = new ArrayList(arrayList.get(i6).subList(0, i5));
                    HashSet<String> hashSet = new HashSet<>();
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        ArrivalInfoTuple arrivalInfoTuple = (ArrivalInfoTuple) it.next();
                        if (!arrivalInfoTuple.destinationStopId.equals(str3) && !arrivalInfoTuple.destinationStopId.equals(str2)) {
                            hashSet.add(arrivalInfoTuple.destinationStopId);
                        }
                    }
                    ArrayList arrayList5 = new ArrayList();
                    Iterator<ArrayList<ArrivalInfoTuple>> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ArrayList<ArrivalInfoTuple> next = it2.next();
                        if (next.size() > i5 && arrayList4.equals(next.subList(i7, i5))) {
                            int i8 = i5 + 1;
                            if (next.size() > i8) {
                                String str4 = next.get(i5).destinationStopId;
                                String str5 = next.get(i8).destinationStopId;
                                arrayList5.add(new Pair(str4, str5));
                                this.f788a.get(str4).remove(str5);
                            }
                            i7 = 0;
                        }
                    }
                    int i9 = neighbouringStopTripInfo.arrTime;
                    if (i9 != Integer.MAX_VALUE) {
                        ArrayList<ArrivalInfoTuple> c3 = c(str3, str2, i9, hashSet);
                        Iterator it3 = arrayList5.iterator();
                        while (it3.hasNext()) {
                            Pair pair = (Pair) it3.next();
                            this.f788a.get(pair.first).add((String) pair.second);
                        }
                        if (c3 != null) {
                            c3.get(0).destInfo = neighbouringStopTripInfo;
                            Iterator<ArrivalInfoTuple> it4 = c3.iterator();
                            while (it4.hasNext()) {
                                ArrivalInfoTuple next2 = it4.next();
                                if (!arrayList4.contains(next2) && next2 != null) {
                                    arrayList4.add(next2);
                                }
                            }
                            if (arrayList4 != null && arrayList4.size() >= 1 && !arrayList4.contains(null) && !arrayList3.contains(arrayList4)) {
                                arrayList3.add(arrayList4);
                            }
                            i5++;
                        }
                    }
                    arrayList4 = null;
                    arrayList3.add(arrayList4);
                    i5++;
                }
                arrayList2.addAll(arrayList3);
            }
            if (arrayList2.size() < 1) {
                break;
            }
            if (arrayList2.size() > 0) {
                ArrayList<ArrivalInfoTuple> arrayList6 = new ArrayList<>(d(arrayList2));
                while (arrayList.contains(arrayList6) && arrayList2.size() > 0) {
                    arrayList2.remove(arrayList6);
                    if (arrayList2.size() > 0) {
                        arrayList6 = new ArrayList<>(d(arrayList2));
                    }
                }
                if (!arrayList.contains(arrayList6) && arrayList6.size() > 0) {
                    arrayList.add(arrayList6);
                }
                arrayList2.remove(arrayList6);
            }
            i4++;
            i3 = i2;
        }
        return arrayList;
    }

    public final int b(ArrayList<ArrivalInfoTuple> arrayList) {
        k20 k20;
        int size = arrayList.size();
        if (size != 0) {
            int i = size - 1;
            if (!(arrayList.get(i) == null || (k20 = arrayList.get(i).destInfo) == null)) {
                return k20.getEdgeDjikstraWeight();
            }
        }
        return Integer.MAX_VALUE;
    }

    public final ArrayList<ArrivalInfoTuple> c(String str, String str2, int i, HashSet<String> hashSet) {
        int a2;
        HashSet<String> hashSet2;
        NeighbouringStopTripInfo neighbouringStopTripInfo;
        HashMap<String, HashSet<String>> hashMap = this.f788a;
        HashMap hashMap2 = new HashMap();
        for (String str3 : hashMap.keySet()) {
            if (!hashSet.contains(str3)) {
                hashMap2.put(str3, hashMap.get(str3));
            }
        }
        i50 i50 = new i50(hashMap2, this.b);
        int i2 = this.c;
        PriorityQueue priorityQueue = new PriorityQueue(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, new h50(i50));
        HashMap hashMap3 = new HashMap();
        if (!(str == null || str2 == null || str.equals(str2))) {
            i50.c.put(str, Integer.valueOf(i));
            i50.d.put(str, null);
            priorityQueue.add(str);
            while (priorityQueue.size() > 0) {
                String str4 = (String) priorityQueue.poll();
                if (str4.equals(str2) || (a2 = i50.a(str4)) > i2) {
                    break;
                }
                if (i50.f1478a.containsKey(str4)) {
                    hashSet2 = i50.f1478a.get(str4);
                } else {
                    hashSet2 = new HashSet<>();
                }
                for (String str5 : hashSet2) {
                    String str6 = str5;
                    String k = ii1.k(str4, str6);
                    NeighbouringStopTripInfo l = ii1.l(i50.b.get(k), a2);
                    if (l.depTime - a2 > 3600) {
                        neighbouringStopTripInfo = ii1.j();
                    } else {
                        NeighbouringStopTripInfo neighbouringStopTripInfo2 = i50.d.get(str4);
                        if (neighbouringStopTripInfo2 != null && (!neighbouringStopTripInfo2.tripId.equals(l.tripId) || !neighbouringStopTripInfo2.routeId.equals(l.routeId))) {
                            l = ii1.l(i50.b.get(k), a2 + CsLogic.ETA_FORCE_UPDATE_REDIS_TTL);
                        }
                        int i3 = l.arrTime;
                        neighbouringStopTripInfo = i3 < a2 ? new NeighbouringStopTripInfo(l.depTime + 86400, i3 + 86400, l.tripId, l.routeId, l.freqM) : l;
                    }
                    int edgeDjikstraWeight = neighbouringStopTripInfo.getEdgeDjikstraWeight();
                    if (i50.a(str6) > edgeDjikstraWeight) {
                        String obj = str5.toString();
                        priorityQueue.remove(obj);
                        priorityQueue.add(obj);
                        hashMap3.put(obj, str4);
                        i50.c.put(obj, Integer.valueOf(edgeDjikstraWeight));
                        i50.d.put(obj, neighbouringStopTripInfo);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            String str7 = (String) hashMap3.get(str2);
            if (str7 != null) {
                while (!str7.equals(str)) {
                    if (arrayList.contains(str7)) {
                        b00 b00 = b00.f358a;
                        c00 a3 = b00.a();
                        a3.b(new Throwable("Loop found in path for query from " + str + " to " + str2));
                    } else {
                        arrayList.add(str7);
                        if (hashMap3.containsKey(str7)) {
                            str7 = (String) hashMap3.get(str7);
                        }
                    }
                }
                arrayList.add(str7);
                ArrayList arrayList2 = new ArrayList(arrayList);
                Collections.reverse(arrayList2);
                ArrayList<ArrivalInfoTuple> arrayList3 = new ArrayList<>();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str8 = (String) it.next();
                    arrayList3.add(new ArrivalInfoTuple(str8, i50.d.get(str8)));
                }
                return arrayList3;
            }
        }
        return null;
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/util/ArrayList<Ljava/util/ArrayList<Lapp/zophop/models/ArrivalInfoTuple;>;>;I)Ljava/util/ArrayList<Lapp/zophop/models/ArrivalInfoTuple;>; */
    public final ArrayList d(ArrayList arrayList) {
        ArrayList<ArrivalInfoTuple> arrayList2 = (ArrayList) arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (b(arrayList2) > b((ArrayList) arrayList.get(i))) {
                arrayList2 = (ArrayList) arrayList.get(i);
            }
        }
        return new ArrayList(arrayList2);
    }
}
