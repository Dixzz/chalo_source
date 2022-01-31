package defpackage;

import j$.util.Map;
import java.util.Map;

/* renamed from: ak3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ak3 implements Comparable<ak3>, Map.Entry<K, V>, Map.Entry {
    public final K f;
    public V g;
    public final /* synthetic */ xj3 h;

    public ak3(xj3 xj3, Map.Entry<K, V> entry) {
        V value = entry.getValue();
        this.h = xj3;
        this.f = entry.getKey();
        this.g = value;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ak3 ak3) {
        return this.f.compareTo(ak3.f);
    }

    @Override // j$.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        K k = this.f;
        Object key = entry.getKey();
        if (k == null) {
            z = key == null;
        } else {
            z = k.equals(key);
        }
        if (z) {
            V v = this.g;
            Object value = entry.getValue();
            if (v == null) {
                z2 = value == null;
            } else {
                z2 = v.equals(value);
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final V getValue() {
        return this.g;
    }

    @Override // j$.util.Map.Entry
    public final int hashCode() {
        K k = this.f;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.g;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final V setValue(V v) {
        xj3 xj3 = this.h;
        int i = xj3.l;
        xj3.h();
        V v2 = this.g;
        this.g = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        String valueOf2 = String.valueOf(this.g);
        return hj1.y(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }

    public ak3(xj3 xj3, K k, V v) {
        this.h = xj3;
        this.f = k;
        this.g = v;
    }
}
