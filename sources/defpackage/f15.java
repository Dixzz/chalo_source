package defpackage;

import defpackage.c15;
import java.util.Map;
import java.util.Objects;

/* renamed from: f15  reason: default package */
/* compiled from: MapFieldSchemaLite */
public class f15 implements e15 {
    @Override // defpackage.e15
    public Object a(Object obj, Object obj2) {
        d15 d15 = (d15) obj;
        d15 d152 = (d15) obj2;
        if (!d152.isEmpty()) {
            if (!d15.f) {
                d15 = d15.c();
            }
            d15.b();
            if (!d152.isEmpty()) {
                d15.putAll(d152);
            }
        }
        return d15;
    }

    @Override // defpackage.e15
    public Object b(Object obj) {
        ((d15) obj).f = false;
        return obj;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: c15$a<K, V>, c15$a<?, ?> */
    @Override // defpackage.e15
    public c15.a<?, ?> c(Object obj) {
        return (c15.a<K, V>) ((c15) obj).f503a;
    }

    @Override // defpackage.e15
    public Map<?, ?> d(Object obj) {
        return (d15) obj;
    }

    @Override // defpackage.e15
    public Object e(Object obj) {
        return d15.g.c();
    }

    @Override // defpackage.e15
    public int f(int i, Object obj, Object obj2) {
        d15 d15 = (d15) obj;
        c15 c15 = (c15) obj2;
        int i2 = 0;
        if (!d15.isEmpty()) {
            for (Map.Entry entry : d15.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                Objects.requireNonNull(c15);
                i2 += d05.o(c15.a(c15.f503a, key, value)) + d05.x(i);
            }
        }
        return i2;
    }

    @Override // defpackage.e15
    public boolean g(Object obj) {
        return !((d15) obj).f;
    }

    @Override // defpackage.e15
    public Map<?, ?> h(Object obj) {
        return (d15) obj;
    }
}
