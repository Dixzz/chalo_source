package defpackage;

import defpackage.wc;
import java.util.Map;
import java.util.Objects;

/* renamed from: zc  reason: default package */
/* compiled from: MapFieldSchemaLite */
public class zc implements yc {
    @Override // defpackage.yc
    public Object a(Object obj, Object obj2) {
        xc xcVar = (xc) obj;
        xc xcVar2 = (xc) obj2;
        if (!xcVar2.isEmpty()) {
            if (!xcVar.f) {
                xcVar = xcVar.c();
            }
            xcVar.b();
            if (!xcVar2.isEmpty()) {
                xcVar.putAll(xcVar2);
            }
        }
        return xcVar;
    }

    @Override // defpackage.yc
    public Object b(Object obj) {
        ((xc) obj).f = false;
        return obj;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: wc$a<K, V>, wc$a<?, ?> */
    @Override // defpackage.yc
    public wc.a<?, ?> c(Object obj) {
        return (wc.a<K, V>) ((wc) obj).f3758a;
    }

    @Override // defpackage.yc
    public Map<?, ?> d(Object obj) {
        return (xc) obj;
    }

    @Override // defpackage.yc
    public Object e(Object obj) {
        return xc.g.c();
    }

    @Override // defpackage.yc
    public int f(int i, Object obj, Object obj2) {
        xc xcVar = (xc) obj;
        wc wcVar = (wc) obj2;
        int i2 = 0;
        if (!xcVar.isEmpty()) {
            for (Map.Entry entry : xcVar.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                Objects.requireNonNull(wcVar);
                i2 += xb.o(wc.a(wcVar.f3758a, key, value)) + xb.x(i);
            }
        }
        return i2;
    }

    @Override // defpackage.yc
    public boolean g(Object obj) {
        return !((xc) obj).f;
    }

    @Override // defpackage.yc
    public Map<?, ?> h(Object obj) {
        return (xc) obj;
    }
}
