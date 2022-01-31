package defpackage;

import java.util.Iterator;
import java.util.Map;

/* renamed from: xl2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class xl2 {
    public static final int a(int i, Object obj, Object obj2) {
        wl2 wl2 = (wl2) obj;
        vl2 vl2 = (vl2) obj2;
        if (wl2.isEmpty()) {
            return 0;
        }
        Iterator it = wl2.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean b(Object obj) {
        return !((wl2) obj).f;
    }

    public static final Object c(Object obj, Object obj2) {
        wl2 wl2 = (wl2) obj;
        wl2 wl22 = (wl2) obj2;
        if (!wl22.isEmpty()) {
            if (!wl2.f) {
                wl2 = wl2.b();
            }
            wl2.d();
            if (!wl22.isEmpty()) {
                wl2.putAll(wl22);
            }
        }
        return wl2;
    }
}
