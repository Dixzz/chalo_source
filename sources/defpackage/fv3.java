package defpackage;

import j$.util.Map;
import java.util.Map;

/* renamed from: fv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class fv3<K> implements Map.Entry<K, Object>, Map.Entry {
    public Map.Entry<K, dv3> f;

    public fv3(Map.Entry entry, gv3 gv3) {
        this.f = entry;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final K getKey() {
        return this.f.getKey();
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final Object getValue() {
        if (this.f.getValue() == null) {
            return null;
        }
        int i = dv3.c;
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof cw3) {
            dv3 value = this.f.getValue();
            cw3 cw3 = value.f1433a;
            value.b = null;
            value.f1433a = (cw3) obj;
            return cw3;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
