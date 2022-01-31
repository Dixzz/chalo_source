package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ov3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ov3 extends mv3 {
    public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public ov3(lv3 lv3) {
        super(null);
    }

    @Override // defpackage.mv3
    public final <E> void a(Object obj, Object obj2, long j) {
        ArrayList arrayList;
        List list = (List) kx3.r(obj2, j);
        int size = list.size();
        List list2 = (List) kx3.r(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof jv3) {
                list2 = new kv3(size);
            } else if (!(list2 instanceof lw3) || !(list2 instanceof zu3)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((zu3) list2).j(size);
            }
            kx3.f(obj, j, list2);
        } else {
            if (c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList2 = new ArrayList(list2.size() + size);
                arrayList2.addAll(list2);
                kx3.f(obj, j, arrayList2);
                arrayList = arrayList2;
            } else if (list2 instanceof fx3) {
                kv3 kv3 = new kv3(list2.size() + size);
                kv3.addAll(kv3.size(), (fx3) list2);
                kx3.f(obj, j, kv3);
                arrayList = kv3;
            } else if ((list2 instanceof lw3) && (list2 instanceof zu3)) {
                zu3 zu3 = (zu3) list2;
                if (!zu3.zza()) {
                    list2 = zu3.j(list2.size() + size);
                    kx3.f(obj, j, list2);
                }
            }
            list2 = arrayList;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        kx3.f(obj, j, list);
    }

    @Override // defpackage.mv3
    public final void b(Object obj, long j) {
        Object obj2;
        List list = (List) kx3.r(obj, j);
        if (list instanceof jv3) {
            obj2 = ((jv3) list).J();
        } else if (!c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof lw3) || !(list instanceof zu3)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zu3 zu3 = (zu3) list;
                if (zu3.zza()) {
                    zu3.S0();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        kx3.f(obj, j, obj2);
    }
}
