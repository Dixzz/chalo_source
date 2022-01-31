package defpackage;

import app.zophop.models.NeighbouringStopTripInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: i50  reason: default package */
/* compiled from: TrainishDjikstraImpl */
public class i50 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, HashSet<String>> f1478a;
    public final HashMap<String, ArrayList<k20>> b;
    public final HashMap<String, Integer> c = new HashMap<>();
    public final HashMap<String, NeighbouringStopTripInfo> d = new HashMap<>();

    public i50(HashMap<String, HashSet<String>> hashMap, HashMap<String, ArrayList<k20>> hashMap2) {
        this.f1478a = hashMap;
        this.b = hashMap2;
    }

    public int a(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
