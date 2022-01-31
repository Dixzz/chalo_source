package defpackage;

import java.util.Iterator;
import java.util.Map;

/* renamed from: yv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class yv3 implements vv3 {
    @Override // defpackage.vv3
    public final boolean a(Object obj) {
        return !((wv3) obj).f;
    }

    @Override // defpackage.vv3
    public final Map<?, ?> c(Object obj) {
        return (wv3) obj;
    }

    @Override // defpackage.vv3
    public final Map<?, ?> d(Object obj) {
        return (wv3) obj;
    }

    @Override // defpackage.vv3
    public final tv3<?, ?> e(Object obj) {
        uv3 uv3 = (uv3) obj;
        throw new NoSuchMethodError();
    }

    @Override // defpackage.vv3
    public final Object f(Object obj) {
        wv3 wv3 = wv3.g;
        return wv3.isEmpty() ? new wv3() : new wv3(wv3);
    }

    @Override // defpackage.vv3
    public final Object g(Object obj) {
        ((wv3) obj).f = false;
        return obj;
    }

    @Override // defpackage.vv3
    public final Object h(Object obj, Object obj2) {
        wv3 wv3 = (wv3) obj;
        wv3 wv32 = (wv3) obj2;
        if (!wv32.isEmpty()) {
            if (!wv3.f) {
                wv3 = wv3.isEmpty() ? new wv3() : new wv3(wv3);
            }
            wv3.b();
            if (!wv32.isEmpty()) {
                wv3.putAll(wv32);
            }
        }
        return wv3;
    }

    @Override // defpackage.vv3
    public final int i(int i, Object obj, Object obj2) {
        wv3 wv3 = (wv3) obj;
        uv3 uv3 = (uv3) obj2;
        if (wv3.isEmpty()) {
            return 0;
        }
        Iterator it = wv3.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
