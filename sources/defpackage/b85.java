package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: b85  reason: default package */
/* compiled from: BarcodeValue */
public final class b85 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Integer> f398a = new HashMap();

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry<Integer, Integer> entry : this.f398a.entrySet()) {
            if (entry.getValue().intValue() > i) {
                i = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i) {
                arrayList.add(entry.getKey());
            }
        }
        return w75.b(arrayList);
    }

    public void b(int i) {
        Integer num = this.f398a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f398a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
