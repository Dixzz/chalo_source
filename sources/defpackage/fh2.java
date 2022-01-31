package defpackage;

import j$.util.Map;
import java.util.Map;

/* renamed from: fh2  reason: default package */
public final class fh2<K> implements Map.Entry<K, Object>, Map.Entry {
    public Map.Entry<K, dh2> f;

    public fh2(Map.Entry entry, eh2 eh2) {
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
        int i = dh2.c;
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zh2) {
            dh2 value = this.f.getValue();
            zh2 zh2 = value.f1371a;
            value.b = null;
            value.f1371a = (zh2) obj;
            return zh2;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
