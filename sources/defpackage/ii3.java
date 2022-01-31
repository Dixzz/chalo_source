package defpackage;

import j$.util.Map;
import java.util.Map;

/* renamed from: ii3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ii3<K> implements Map.Entry<K, Object>, Map.Entry {
    public Map.Entry<K, gi3> f;

    public ii3(Map.Entry entry, ji3 ji3) {
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
        int i = gi3.c;
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof gj3) {
            gi3 value = this.f.getValue();
            gj3 gj3 = value.f2064a;
            value.b = null;
            value.f2064a = (gj3) obj;
            return gj3;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
