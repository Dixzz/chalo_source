package defpackage;

import java.util.Collections;
import java.util.List;

/* renamed from: mh2  reason: default package */
public final class mh2 extends kh2 {
    public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public mh2(lh2 lh2) {
        super(null);
    }

    @Override // defpackage.kh2
    public final void a(Object obj, long j) {
        Object obj2;
        List list = (List) jj2.t(obj, j);
        if (list instanceof jh2) {
            obj2 = ((jh2) list).r();
        } else if (!c.isAssignableFrom(list.getClass())) {
            obj2 = Collections.unmodifiableList(list);
        } else {
            return;
        }
        jj2.f(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    @Override // defpackage.kh2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void b(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh2.b(java.lang.Object, java.lang.Object, long):void");
    }
}
