package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ri3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ri3 extends pi3 {
    public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public ri3(oi3 oi3) {
        super(null);
    }

    @Override // defpackage.pi3
    public final void a(Object obj, long j) {
        Object obj2;
        List list = (List) mk3.r(obj, j);
        if (list instanceof mi3) {
            obj2 = ((mi3) list).x();
        } else if (!c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof oj3) || !(list instanceof ci3)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                ci3 ci3 = (ci3) list;
                if (ci3.V()) {
                    ci3.a1();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        mk3.d(obj, j, obj2);
    }

    @Override // defpackage.pi3
    public final <E> void b(Object obj, Object obj2, long j) {
        ArrayList arrayList;
        List list = (List) mk3.r(obj2, j);
        int size = list.size();
        List list2 = (List) mk3.r(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof mi3) {
                list2 = new ni3(size);
            } else if (!(list2 instanceof oj3) || !(list2 instanceof ci3)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((ci3) list2).H0(size);
            }
            mk3.d(obj, j, list2);
        } else {
            if (c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList2 = new ArrayList(list2.size() + size);
                arrayList2.addAll(list2);
                mk3.d(obj, j, arrayList2);
                arrayList = arrayList2;
            } else if (list2 instanceof lk3) {
                ni3 ni3 = new ni3(list2.size() + size);
                ni3.addAll(ni3.size(), (lk3) list2);
                mk3.d(obj, j, ni3);
                arrayList = ni3;
            } else if ((list2 instanceof oj3) && (list2 instanceof ci3)) {
                ci3 ci3 = (ci3) list2;
                if (!ci3.V()) {
                    list2 = ci3.H0(list2.size() + size);
                    mk3.d(obj, j, list2);
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
        mk3.d(obj, j, list);
    }
}
