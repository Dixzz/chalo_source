package defpackage;

import j$.util.Map;
import java.util.Map;

/* renamed from: xi2  reason: default package */
public final class xi2 implements Comparable<xi2>, Map.Entry<K, V>, Map.Entry {
    public final K f;
    public V g;
    public final /* synthetic */ si2 h;

    public xi2(si2 si2, K k, V v) {
        this.h = si2;
        this.f = k;
        this.g = v;
    }

    public xi2(si2 si2, Map.Entry<K, V> entry) {
        V value = entry.getValue();
        this.h = si2;
        this.f = entry.getKey();
        this.g = value;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(xi2 xi2) {
        return this.f.compareTo(xi2.f);
    }

    @Override // j$.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        K k = this.f;
        Object key = entry.getKey();
        if (k == null ? key == null : k.equals(key)) {
            V v = this.g;
            Object value = entry.getValue();
            if (v == null) {
                z = value == null;
            } else {
                z = v.equals(value);
            }
            if (z) {
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
        si2 si2 = this.h;
        int i = si2.l;
        si2.g();
        V v2 = this.g;
        this.g = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        String valueOf2 = String.valueOf(this.g);
        return hj1.y(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }
}
