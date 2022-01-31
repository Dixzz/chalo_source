package defpackage;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: xj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class xj3<K extends Comparable<K>, V> extends AbstractMap<K, V> implements Map {
    public static final /* synthetic */ int l = 0;
    public final int f;
    public List<ak3> g = Collections.emptyList();
    public java.util.Map<K, V> h = Collections.emptyMap();
    public boolean i;
    public volatile ck3 j;
    public java.util.Map<K, V> k = Collections.emptyMap();

    public xj3(int i2, wj3 wj3) {
        this.f = i2;
    }

    public final int a(K k2) {
        int size = this.g.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.g.get(size).f);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
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

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: b */
    public final V put(K k2, V v) {
        h();
        int a2 = a(k2);
        if (a2 >= 0) {
            ak3 ak3 = this.g.get(a2);
            ak3.h.h();
            V v2 = ak3.g;
            ak3.g = v;
            return v2;
        }
        h();
        if (this.g.isEmpty() && !(this.g instanceof ArrayList)) {
            this.g = new ArrayList(this.f);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f) {
            return i().put(k2, v);
        }
        int size = this.g.size();
        int i3 = this.f;
        if (size == i3) {
            ak3 remove = this.g.remove(i3 - 1);
            i().put(remove.f, remove.g);
        }
        this.g.add(i2, new ak3(this, k2, v));
        return null;
    }

    public void c() {
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

    @Override // j$.util.Map
    public void clear() {
        h();
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: xj3<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.h.containsKey(comparable);
    }

    public final Map.Entry<K, V> d(int i2) {
        return this.g.get(i2);
    }

    public final V e(int i2) {
        h();
        V v = this.g.remove(i2).g;
        if (!this.h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = i().entrySet().iterator();
            this.g.add(new ak3(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.j == null) {
            this.j = new ck3(this, null);
        }
        return this.j;
    }

    @Override // j$.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xj3)) {
            return super.equals(obj);
        }
        xj3 xj3 = (xj3) obj;
        int size = size();
        if (size != xj3.size()) {
            return false;
        }
        int f2 = f();
        if (f2 != xj3.f()) {
            return entrySet().equals(xj3.entrySet());
        }
        for (int i2 = 0; i2 < f2; i2++) {
            if (!d(i2).equals(xj3.d(i2))) {
                return false;
            }
        }
        if (f2 != size) {
            return this.h.equals(xj3.h);
        }
        return true;
    }

    public final int f() {
        return this.g.size();
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public final Iterable<Map.Entry<K, V>> g() {
        return this.h.isEmpty() ? (Iterable<Map.Entry<K, V>>) zj3.b : this.h.entrySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: xj3<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.g.get(a2).g;
        }
        return this.h.get(comparable);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    public final void h() {
        if (this.i) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // j$.util.Map
    public int hashCode() {
        int f2 = f();
        int i2 = 0;
        for (int i3 = 0; i3 < f2; i3++) {
            i2 += this.g.get(i3).hashCode();
        }
        return this.h.size() > 0 ? i2 + this.h.hashCode() : i2;
    }

    public final SortedMap<K, V> i() {
        h();
        if (this.h.isEmpty() && !(this.h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.h = treeMap;
            this.k = treeMap.descendingMap();
        }
        return (SortedMap) this.h;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: xj3<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) e(a2);
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
    public int size() {
        return this.h.size() + this.g.size();
    }
}
