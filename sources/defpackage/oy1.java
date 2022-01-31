package defpackage;

import android.util.SparseArray;
import java.util.HashMap;

/* renamed from: oy1  reason: default package */
/* compiled from: PriorityMapping */
public final class oy1 {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<bu1> f2743a = new SparseArray<>();
    public static HashMap<bu1, Integer> b;

    static {
        HashMap<bu1, Integer> hashMap = new HashMap<>();
        b = hashMap;
        hashMap.put(bu1.DEFAULT, 0);
        b.put(bu1.VERY_LOW, 1);
        b.put(bu1.HIGHEST, 2);
        for (bu1 bu1 : b.keySet()) {
            f2743a.append(b.get(bu1).intValue(), bu1);
        }
    }

    public static int a(bu1 bu1) {
        Integer num = b.get(bu1);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + bu1);
    }

    public static bu1 b(int i) {
        bu1 bu1 = f2743a.get(i);
        if (bu1 != null) {
            return bu1;
        }
        throw new IllegalArgumentException(hj1.I("Unknown Priority for value ", i));
    }
}
