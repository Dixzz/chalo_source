package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: i65  reason: default package */
/* compiled from: MultiFormatOneDReader */
public final class i65 extends k65 {

    /* renamed from: a  reason: collision with root package name */
    public final k65[] f1483a;

    public i65(Map<s25, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(s25.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(s25.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(o25.EAN_13) || collection.contains(o25.UPC_A) || collection.contains(o25.EAN_8) || collection.contains(o25.UPC_E)) {
                arrayList.add(new j65(map));
            }
            if (collection.contains(o25.CODE_39)) {
                arrayList.add(new x55(z));
            }
            if (collection.contains(o25.CODE_93)) {
                arrayList.add(new z55());
            }
            if (collection.contains(o25.CODE_128)) {
                arrayList.add(new v55());
            }
            if (collection.contains(o25.ITF)) {
                arrayList.add(new g65());
            }
            if (collection.contains(o25.CODABAR)) {
                arrayList.add(new t55());
            }
            if (collection.contains(o25.RSS_14)) {
                arrayList.add(new z65());
            }
            if (collection.contains(o25.RSS_EXPANDED)) {
                arrayList.add(new c75());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j65(map));
            arrayList.add(new x55(false));
            arrayList.add(new t55());
            arrayList.add(new z55());
            arrayList.add(new v55());
            arrayList.add(new g65());
            arrayList.add(new z65());
            arrayList.add(new c75());
        }
        this.f1483a = (k65[]) arrayList.toArray(new k65[arrayList.size()]);
    }

    @Override // defpackage.c35, defpackage.k65
    public void c() {
        for (k65 k65 : this.f1483a) {
            k65.c();
        }
    }

    @Override // defpackage.k65
    public e35 d(int i, e45 e45, Map<s25, ?> map) throws a35 {
        k65[] k65Arr;
        for (k65 k65 : this.f1483a) {
            try {
                return k65.d(i, e45, map);
            } catch (d35 unused) {
            }
        }
        throw a35.h;
    }
}
