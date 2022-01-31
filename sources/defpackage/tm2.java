package defpackage;

import j$.util.Map;
import java.util.Map;

/* renamed from: tm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class tm2 implements Map.Entry, Comparable<tm2>, Map.Entry {
    public final Comparable f;
    public Object g;
    public final /* synthetic */ wm2 h;

    public tm2(wm2 wm2, Comparable comparable, Object obj) {
        this.h = wm2;
        this.f = comparable;
        this.g = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(tm2 tm2) {
        return this.f.compareTo(tm2.f);
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
        Comparable comparable = this.f;
        Object key = entry.getKey();
        if (comparable == null) {
            z = key == null;
        } else {
            z = comparable.equals(key);
        }
        if (z) {
            Object obj2 = this.g;
            Object value = entry.getValue();
            if (obj2 == null) {
                z2 = value == null;
            } else {
                z2 = obj2.equals(value);
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.f;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final Object getValue() {
        return this.g;
    }

    @Override // j$.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f;
        int i = 0;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.g;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode ^ i;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final Object setValue(Object obj) {
        wm2 wm2 = this.h;
        int i = wm2.l;
        wm2.g();
        Object obj2 = this.g;
        this.g = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        String valueOf2 = String.valueOf(this.g);
        return hj1.b0(new StringBuilder(valueOf.length() + 1 + valueOf2.length()), valueOf, "=", valueOf2);
    }
}
