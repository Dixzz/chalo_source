package defpackage;

import defpackage.g2;
import java.util.HashMap;

/* renamed from: f2  reason: default package */
/* compiled from: FastSafeIterableMap */
public class f2<K, V> extends g2<K, V> {
    public HashMap<K, g2.c<K, V>> j = new HashMap<>();

    @Override // defpackage.g2
    public g2.c<K, V> b(K k) {
        return this.j.get(k);
    }

    public boolean contains(K k) {
        return this.j.containsKey(k);
    }

    @Override // defpackage.g2
    public V k(K k, V v) {
        g2.c<K, V> cVar = this.j.get(k);
        if (cVar != null) {
            return cVar.g;
        }
        this.j.put(k, e(k, v));
        return null;
    }

    @Override // defpackage.g2
    public V n(K k) {
        V v = (V) super.n(k);
        this.j.remove(k);
        return v;
    }
}
