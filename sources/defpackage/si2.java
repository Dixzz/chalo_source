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

/* renamed from: si2  reason: default package */
public class si2<K extends Comparable<K>, V> extends AbstractMap<K, V> implements Map {
    public static final /* synthetic */ int l = 0;
    public final int f;
    public List<xi2> g = Collections.emptyList();
    public java.util.Map<K, V> h = Collections.emptyMap();
    public boolean i;
    public volatile zi2 j;
    public java.util.Map<K, V> k = Collections.emptyMap();

    public si2(int i2, ti2 ti2) {
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
        g();
        int a2 = a(k2);
        if (a2 >= 0) {
            xi2 xi2 = this.g.get(a2);
            xi2.h.g();
            V v2 = xi2.g;
            xi2.g = v;
            return v2;
        }
        g();
        if (this.g.isEmpty() && !(this.g instanceof ArrayList)) {
            this.g = new ArrayList(this.f);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f) {
            return h().put(k2, v);
        }
        int size = this.g.size();
        int i3 = this.f;
        if (size == i3) {
            xi2 remove = this.g.remove(i3 - 1);
            h().put(remove.f, remove.g);
        }
        this.g.add(i2, new xi2(this, k2, v));
        return null;
    }

    public final Map.Entry<K, V> c(int i2) {
        return this.g.get(i2);
    }

    @Override // j$.util.Map
    public void clear() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: si2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.h.containsKey(comparable);
    }

    public final V d(int i2) {
        g();
        V v = this.g.remove(i2).g;
        if (!this.h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = h().entrySet().iterator();
            this.g.add(new xi2(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final int e() {
        return this.g.size();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.j == null) {
            this.j = new zi2(this, null);
        }
        return this.j;
    }

    @Override // j$.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof si2)) {
            return super.equals(obj);
        }
        si2 si2 = (si2) obj;
        int size = size();
        if (size != si2.size()) {
            return false;
        }
        int e = e();
        if (e != si2.e()) {
            return entrySet().equals(si2.entrySet());
        }
        for (int i2 = 0; i2 < e; i2++) {
            if (!c(i2).equals(si2.c(i2))) {
                return false;
            }
        }
        if (e != size) {
            return this.h.equals(si2.h);
        }
        return true;
    }

    public final Iterable<Map.Entry<K, V>> f() {
        return this.h.isEmpty() ? (Iterable<Map.Entry<K, V>>) ui2.b : this.h.entrySet();
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: si2<K extends java.lang.Comparable<K>, V> */
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
    public int hashCode() {
        int e = e();
        int i2 = 0;
        for (int i3 = 0; i3 < e; i3++) {
            i2 += this.g.get(i3).hashCode();
        }
        return this.h.size() > 0 ? i2 + this.h.hashCode() : i2;
    }

    public void i() {
        if (!this.i) {
            this.h = this.h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.h);
            this.k = this.k.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.k);
            this.i = true;
        }
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: si2<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) d(a2);
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
