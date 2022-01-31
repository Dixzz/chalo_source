package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* renamed from: j65  reason: default package */
/* compiled from: MultiFormatUPCEANReader */
public final class j65 extends k65 {

    /* renamed from: a  reason: collision with root package name */
    public final r65[] f1886a;

    public j65(Map<s25, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(s25.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(o25.EAN_13)) {
                arrayList.add(new b65());
            } else if (collection.contains(o25.UPC_A)) {
                arrayList.add(new m65());
            }
            if (collection.contains(o25.EAN_8)) {
                arrayList.add(new d65());
            }
            if (collection.contains(o25.UPC_E)) {
                arrayList.add(new t65());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new b65());
            arrayList.add(new d65());
            arrayList.add(new t65());
        }
        this.f1886a = (r65[]) arrayList.toArray(new r65[arrayList.size()]);
    }

    @Override // defpackage.c35, defpackage.k65
    public void c() {
        for (r65 r65 : this.f1886a) {
            Objects.requireNonNull(r65);
        }
    }

    @Override // defpackage.k65
    public e35 d(int i, e45 e45, Map<s25, ?> map) throws a35 {
        r65[] r65Arr;
        Collection collection;
        boolean z;
        int[] p = r65.p(e45);
        for (r65 r65 : this.f1886a) {
            try {
                e35 n = r65.n(i, e45, p, map);
                boolean z2 = n.d == o25.EAN_13 && n.f921a.charAt(0) == '0';
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(s25.POSSIBLE_FORMATS);
                }
                if (collection != null) {
                    if (!collection.contains(o25.UPC_A)) {
                        z = false;
                        if (z2 || !z) {
                            return n;
                        }
                        e35 e35 = new e35(n.f921a.substring(1), n.b, n.c, o25.UPC_A);
                        e35.a(n.e);
                        return e35;
                    }
                }
                z = true;
                if (z2) {
                }
                return n;
            } catch (d35 unused) {
            }
        }
        throw a35.h;
    }
}
