package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: y25  reason: default package */
/* compiled from: MultiFormatReader */
public final class y25 implements c35 {

    /* renamed from: a  reason: collision with root package name */
    public Map<s25, ?> f3992a;
    public c35[] b;

    @Override // defpackage.c35
    public e35 a(q25 q25, Map<s25, ?> map) throws a35 {
        e(map);
        return d(q25);
    }

    @Override // defpackage.c35
    public e35 b(q25 q25) throws a35 {
        e(null);
        return d(q25);
    }

    @Override // defpackage.c35
    public void c() {
        c35[] c35Arr = this.b;
        if (c35Arr != null) {
            for (c35 c35 : c35Arr) {
                c35.c();
            }
        }
    }

    public final e35 d(q25 q25) throws a35 {
        c35[] c35Arr = this.b;
        if (c35Arr != null) {
            for (c35 c35 : c35Arr) {
                try {
                    return c35.a(q25, this.f3992a);
                } catch (d35 unused) {
                }
            }
        }
        throw a35.h;
    }

    public void e(Map<s25, ?> map) {
        Collection collection;
        this.f3992a = map;
        boolean z = false;
        boolean z2 = map != null && map.containsKey(s25.TRY_HARDER);
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(s25.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(o25.UPC_A) || collection.contains(o25.UPC_E) || collection.contains(o25.EAN_13) || collection.contains(o25.EAN_8) || collection.contains(o25.CODABAR) || collection.contains(o25.CODE_39) || collection.contains(o25.CODE_93) || collection.contains(o25.CODE_128) || collection.contains(o25.ITF) || collection.contains(o25.RSS_14) || collection.contains(o25.RSS_EXPANDED)) {
                z = true;
            }
            if (z && !z2) {
                arrayList.add(new i65(map));
            }
            if (collection.contains(o25.QR_CODE)) {
                arrayList.add(new v85());
            }
            if (collection.contains(o25.DATA_MATRIX)) {
                arrayList.add(new u45());
            }
            if (collection.contains(o25.AZTEC)) {
                arrayList.add(new l35());
            }
            if (collection.contains(o25.PDF_417)) {
                arrayList.add(new x75());
            }
            if (collection.contains(o25.MAXICODE)) {
                arrayList.add(new p55());
            }
            if (z && z2) {
                arrayList.add(new i65(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new i65(map));
            }
            arrayList.add(new v85());
            arrayList.add(new u45());
            arrayList.add(new l35());
            arrayList.add(new x75());
            arrayList.add(new p55());
            if (z2) {
                arrayList.add(new i65(map));
            }
        }
        this.b = (c35[]) arrayList.toArray(new c35[arrayList.size()]);
    }
}
