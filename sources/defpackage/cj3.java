package defpackage;

import java.util.Iterator;
import java.util.Map;

/* renamed from: cj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class cj3 implements zi3 {
    @Override // defpackage.zi3
    public final Object b(Object obj, Object obj2) {
        aj3 aj3 = (aj3) obj;
        aj3 aj32 = (aj3) obj2;
        if (!aj32.isEmpty()) {
            if (!aj3.f) {
                aj3 = aj3.isEmpty() ? new aj3() : new aj3(aj3);
            }
            aj3.a();
            if (!aj32.isEmpty()) {
                aj3.putAll(aj32);
            }
        }
        return aj3;
    }

    @Override // defpackage.zi3
    public final wi3<?, ?> c(Object obj) {
        xi3 xi3 = (xi3) obj;
        throw new NoSuchMethodError();
    }

    @Override // defpackage.zi3
    public final Object d(Object obj) {
        ((aj3) obj).f = false;
        return obj;
    }

    @Override // defpackage.zi3
    public final int e(int i, Object obj, Object obj2) {
        aj3 aj3 = (aj3) obj;
        xi3 xi3 = (xi3) obj2;
        if (aj3.isEmpty()) {
            return 0;
        }
        Iterator it = aj3.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // defpackage.zi3
    public final Map<?, ?> f(Object obj) {
        return (aj3) obj;
    }
}
