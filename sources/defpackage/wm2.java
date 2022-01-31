package defpackage;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: wm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class wm2<K extends Comparable<K>, V> extends AbstractMap<K, V> implements Map {
    public static final /* synthetic */ int l = 0;
    public final int f;
    public List<tm2> g = Collections.emptyList();
    public java.util.Map<K, V> h = Collections.emptyMap();
    public boolean i;
    public volatile vm2 j;
    public java.util.Map<K, V> k = Collections.emptyMap();

    public /* synthetic */ wm2(int i2) {
        this.f = i2;
    }

    public void a() {
        java.util.Map<K, V> map;
        java.util.Map<K, V> map2;
        if (!this.i) {
            if (this.h.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.h);
            }
            this.h = map;
            if (this.k.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.k);
            }
            this.k = map2;
            this.i = true;
        }
    }

    public final int b() {
        return this.g.size();
    }

    public final Map.Entry<K, V> c(int i2) {
        return this.g.get(i2);
    }

    @Override // j$.util.Map
    public final void clear() {
        g();
        if (!this.g.isEmpty()) {
            this.g.clear();
        }
        if (!this.h.isEmpty()) {
            this.h.clear();
        }
    }

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: wm2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.h.containsKey(comparable);
    }

    /* renamed from: d */
    public final V put(K k2, V v) {
        g();
        int f2 = f(k2);
        if (f2 >= 0) {
            tm2 tm2 = this.g.get(f2);
            tm2.h.g();
            V v2 = (V) tm2.g;
            tm2.g = v;
            return v2;
        }
        g();
        if (this.g.isEmpty() && !(this.g instanceof ArrayList)) {
            this.g = new ArrayList(this.f);
        }
        int i2 = -(f2 + 1);
        if (i2 >= this.f) {
            return h().put(k2, v);
        }
        int size = this.g.size();
        int i3 = this.f;
        if (size == i3) {
            tm2 remove = this.g.remove(i3 - 1);
            h().put((K) remove.f, (V) remove.g);
        }
        this.g.add(i2, new tm2(this, k2, v));
        return null;
    }

    public final V e(int i2) {
        g();
        V v = (V) this.g.remove(i2).g;
        if (!this.h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = h().entrySet().iterator();
            List<tm2> list = this.g;
            Map.Entry<K, V> next = it.next();
            list.add(new tm2(this, next.getKey(), next.getValue()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.j == null) {
            this.j = new vm2(this);
        }
        return this.j;
    }

    @Override // j$.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wm2)) {
            return super.equals(obj);
        }
        wm2 wm2 = (wm2) obj;
        int size = size();
        if (size != wm2.size()) {
            return false;
        }
        int b = b();
        if (b == wm2.b()) {
            for (int i2 = 0; i2 < b; i2++) {
                if (!c(i2).equals(wm2.c(i2))) {
                    return false;
                }
            }
            if (b != size) {
                return this.h.equals(wm2.h);
            }
            return true;
        }
        return ((AbstractSet) entrySet()).equals(wm2.entrySet());
    }

    public final int f(K k2) {
        int size = this.g.size() - 1;
        int i2 = 0;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.g.get(size).f);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.g.get(i3).f);
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public final void g() {
        if (this.i) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: wm2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f2 = f(comparable);
        return f2 >= 0 ? (V) this.g.get(f2).g : this.h.get(comparable);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    public final SortedMap<K, V> h() {
        g();
        if (this.h.isEmpty() && !(this.h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.h = treeMap;
            this.k = treeMap.descendingMap();
        }
        return (SortedMap) this.h;
    }

    @Override // j$.util.Map
    public final int hashCode() {
        int b = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b; i3++) {
            i2 += this.g.get(i3).hashCode();
        }
        return this.h.size() > 0 ? this.h.hashCode() + i2 : i2;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: wm2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public final V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f2 = f(comparable);
        if (f2 >= 0) {
            return (V) e(f2);
        }
        if (this.h.isEmpty()) {
            return null;
        }
        return this.h.remove(comparable);
    }

    @Override // j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    @Override // j$.util.Map
    public final int size() {
        return this.h.size() + this.g.size();
    }
}
