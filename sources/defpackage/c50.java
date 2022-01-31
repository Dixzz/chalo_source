package defpackage;

import android.util.SparseIntArray;
import app.zophop.models.NeighbouringStopTripInfo;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.PreProcessingDoneEvent;
import com.google.firebase.database.DataSnapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: c50  reason: default package */
/* compiled from: SchedulerPreProcessor */
public class c50 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ArrayList<k20>> f521a = new HashMap<>();
    public final HashMap<String, HashSet<String>> b = new HashMap<>();
    public final HashMap<String, ArrayList<String>> c = new HashMap<>();
    public final HashMap<String, List<SPECIAL_FEATURE>> d = new HashMap<>();
    public final HashMap<String, String> e = new HashMap<>();
    public final HashMap<String, HashMap<Integer, String>> f = new HashMap<>();
    public ArrayList<TransitMode> g;
    public long h;
    public long i;
    public final bi1 j = new bi1();

    public static void b(HashMap<String, HashSet<String>> hashMap, String str, String str2) {
        if (hashMap.containsKey(str)) {
            hashMap.get(str).add(str2);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(str2);
        hashMap.put(str, hashSet);
    }

    public final void a(ad1 ad1) {
        if (ad1.FAILED.equals(ad1) || Thread.interrupted()) {
            this.f.clear();
            jz5.b().i(new PreProcessingDoneEvent(ad1));
            return;
        }
        this.f.clear();
        Iterator it = new HashSet(this.f521a.keySet()).iterator();
        while (it.hasNext()) {
            Collections.sort(this.f521a.get((String) it.next()));
        }
        jz5.b().i(new PreProcessingDoneEvent(ad1));
    }

    public final void c(DataSnapshot dataSnapshot, SparseIntArray sparseIntArray, ArrayList<String> arrayList, int i2, String str) {
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList.size() - 1;
        String key = dataSnapshot.getKey();
        int i3 = 0;
        int i4 = i2;
        while (i3 < size) {
            String str2 = arrayList2.get(i3);
            int i5 = i3 + 1;
            String str3 = arrayList2.get(i5);
            int i6 = sparseIntArray.get(i3) + i4;
            NeighbouringStopTripInfo neighbouringStopTripInfo = new NeighbouringStopTripInfo(i4, i6, key, str, -1);
            Integer valueOf = Integer.valueOf(this.c.get(str).indexOf(str2));
            String str4 = this.j.d(dataSnapshot).get(valueOf);
            if (str4 == null) {
                str4 = this.f.get(str).get(valueOf);
            }
            neighbouringStopTripInfo.depPlatform = str4;
            String k = ii1.k(str2, str3);
            if (!this.f521a.containsKey(k)) {
                ArrayList<k20> arrayList3 = new ArrayList<>();
                arrayList3.add(neighbouringStopTripInfo);
                this.f521a.put(k, arrayList3);
            } else {
                this.f521a.get(k).add(neighbouringStopTripInfo);
            }
            arrayList2 = arrayList;
            i3 = i5;
            i4 = i6;
        }
    }

    public final void d(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("status", "succeeded");
        } else {
            hashMap.put("status", "failed");
        }
        hashMap.put("total_time_taken", (((double) (System.currentTimeMillis() - this.h)) / 1000.0d) + " seconds");
        hashMap.put("fetch_time", (((double) this.i) / 1000.0d) + " seconds");
        hashMap.put("city", xt.f3961a.k().d().getName());
        jz5.b().g(new ed1("scheduler preprocessing done event", Long.MIN_VALUE, hashMap));
    }
}
