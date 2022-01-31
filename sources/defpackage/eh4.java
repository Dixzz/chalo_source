package defpackage;

import defpackage.t2;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: eh4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class eh4 {

    /* renamed from: a  reason: collision with root package name */
    public String f974a;
    public boolean b;
    public ar3 c;
    public BitSet d;
    public BitSet e;
    public Map<Integer, Long> f;
    public Map<Integer, List<Long>> g;
    public final /* synthetic */ ch4 h;

    public eh4(ch4 ch4, String str, bh4 bh4) {
        this.h = ch4;
        this.f974a = str;
        this.b = true;
        this.d = new BitSet();
        this.e = new BitSet();
        this.f = new n2();
        this.g = new n2();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0151 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.sq3 a(int r9) {
        /*
        // Method dump skipped, instructions count: 386
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.eh4.a(int):sq3");
    }

    public final void b(fh4 fh4) {
        int a2 = fh4.a();
        Boolean bool = fh4.c;
        if (bool != null) {
            this.e.set(a2, bool.booleanValue());
        }
        Boolean bool2 = fh4.d;
        if (bool2 != null) {
            this.d.set(a2, bool2.booleanValue());
        }
        if (fh4.e != null) {
            Long l = this.f.get(Integer.valueOf(a2));
            long longValue = fh4.e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f.put(Integer.valueOf(a2), Long.valueOf(longValue));
            }
        }
        if (fh4.f != null) {
            List<Long> list = this.g.get(Integer.valueOf(a2));
            if (list == null) {
                list = new ArrayList<>();
                this.g.put(Integer.valueOf(a2), list);
            }
            if (fh4.g()) {
                list.clear();
            }
            if (gz3.a() && this.h.f3331a.g.t(this.f974a, q64.c0) && fh4.h()) {
                list.clear();
            }
            if (!gz3.a() || !this.h.f3331a.g.t(this.f974a, q64.c0)) {
                list.add(Long.valueOf(fh4.f.longValue() / 1000));
                return;
            }
            long longValue2 = fh4.f.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    public eh4(ch4 ch4, String str, ar3 ar3, BitSet bitSet, BitSet bitSet2, Map map, Map map2, bh4 bh4) {
        this.h = ch4;
        this.f974a = str;
        this.d = bitSet;
        this.e = bitSet2;
        this.f = map;
        this.g = new n2();
        Iterator it = ((t2.c) ((n2) map2).keySet()).iterator();
        while (true) {
            t2.a aVar = (t2.a) it;
            if (aVar.hasNext()) {
                Integer num = (Integer) aVar.next();
                ArrayList arrayList = new ArrayList();
                arrayList.add((Long) ((u2) map2).get(num));
                this.g.put(num, arrayList);
            } else {
                this.b = false;
                this.c = ar3;
                return;
            }
        }
    }
}
