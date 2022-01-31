package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ol2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ol2 extends ql2 {
    public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    public static <L> List<L> d(Object obj, long j, int i) {
        ml2 ml2;
        List<L> list;
        List<L> list2 = (List) ln2.t(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof nl2) {
                list = new ml2(i);
            } else if (!(list2 instanceof hm2) || !(list2 instanceof ja3)) {
                list = new ArrayList<>(i);
            } else {
                list = ((ja3) list2).D(i);
            }
            ln2.e.o(obj, j, list);
            return list;
        }
        if (c.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            ln2.e.o(obj, j, arrayList);
            ml2 = arrayList;
        } else if (list2 instanceof en2) {
            ml2 ml22 = new ml2(list2.size() + i);
            ml22.addAll(ml22.size(), (en2) list2);
            ln2.e.o(obj, j, ml22);
            ml2 = ml22;
        } else if (!(list2 instanceof hm2) || !(list2 instanceof ja3)) {
            return list2;
        } else {
            ja3 ja3 = (ja3) list2;
            if (ja3.zza()) {
                return list2;
            }
            ja3 D = ja3.D(list2.size() + i);
            ln2.e.o(obj, j, D);
            return D;
        }
        return ml2;
    }

    @Override // defpackage.ql2
    public final <L> List<L> a(Object obj, long j) {
        return d(obj, j, 10);
    }

    @Override // defpackage.ql2
    public final void b(Object obj, long j) {
        Object obj2;
        List list = (List) ln2.t(obj, j);
        if (list instanceof nl2) {
            obj2 = ((nl2) list).h();
        } else if (!c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof hm2) || !(list instanceof ja3)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                ja3 ja3 = (ja3) list;
                if (ja3.zza()) {
                    ja3.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        ln2.e.o(obj, j, obj2);
    }

    @Override // defpackage.ql2
    public final <E> void c(Object obj, Object obj2, long j) {
        List list = (List) ln2.t(obj2, j);
        List d = d(obj, j, list.size());
        int size = d.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            d.addAll(list);
        }
        if (size > 0) {
            list = d;
        }
        ln2.e.o(obj, j, list);
    }
}
