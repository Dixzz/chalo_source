package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Set;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;

/* renamed from: vd  reason: default package */
/* compiled from: SmallSortedMap */
public class vd<K extends Comparable<K>, V> extends AbstractMap<K, V> implements Map {
    public static final /* synthetic */ int m = 0;
    public final int f;
    public List<vd<K, V>.d> g = Collections.emptyList();
    public java.util.Map<K, V> h = Collections.emptyMap();
    public boolean i;
    public volatile vd<K, V>.f j;
    public java.util.Map<K, V> k = Collections.emptyMap();
    public volatile vd<K, V>.b l;

    /* renamed from: vd$a */
    /* compiled from: SmallSortedMap */
    public class a implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        public int f;
        public Iterator<Map.Entry<K, V>> g;

        public a(ud udVar) {
            this.f = vd.this.g.size();
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        public final Iterator<Map.Entry<K, V>> a() {
            if (this.g == null) {
                this.g = vd.this.k.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.g;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            int i = this.f;
            return (i > 0 && i <= vd.this.g.size()) || a().hasNext();
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            if (a().hasNext()) {
                return a().next();
            }
            List<vd<K, V>.d> list = vd.this.g;
            int i = this.f - 1;
            this.f = i;
            return list.get(i);
        }

        @Override // j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: vd$b */
    /* compiled from: SmallSortedMap */
    public class b extends vd<K, V>.f {
        public b(ud udVar) {
            super(null);
        }

        @Override // j$.util.Collection, java.util.AbstractCollection, defpackage.vd.f, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new a(null);
        }
    }

    /* renamed from: vd$c */
    /* compiled from: SmallSortedMap */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final java.util.Iterator<Object> f3632a = new a();
        public static final Iterable<Object> b = new b();

        /* renamed from: vd$c$a */
        /* compiled from: SmallSortedMap */
        public static class a implements java.util.Iterator<Object>, j$.util.Iterator {
            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // j$.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // j$.util.Iterator, java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // j$.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: vd$c$b */
        /* compiled from: SmallSortedMap */
        public static class b implements Iterable<Object>, Iterable {
            @Override // j$.lang.Iterable
            public /* synthetic */ void forEach(Consumer consumer) {
                Iterable.CC.$default$forEach(this, consumer);
            }

            @Override // j$.lang.Iterable, java.lang.Iterable
            public java.util.Iterator<Object> iterator() {
                return c.f3632a;
            }

            /* Return type fixed from 'j$.util.Spliterator' to match base method */
            @Override // j$.lang.Iterable, java.lang.Iterable
            public /* synthetic */ Spliterator<Object> spliterator() {
                return Iterable.CC.$default$spliterator(this);
            }
        }
    }

    /* renamed from: vd$e */
    /* compiled from: SmallSortedMap */
    public class e implements java.util.Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        public int f = -1;
        public boolean g;
        public java.util.Iterator<Map.Entry<K, V>> h;

        public e(ud udVar) {
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        public final java.util.Iterator<Map.Entry<K, V>> a() {
            if (this.h == null) {
                this.h = vd.this.h.entrySet().iterator();
            }
            return (java.util.Iterator<Map.Entry<K, V>>) this.h;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (this.f + 1 < vd.this.g.size()) {
                return true;
            }
            if (vd.this.h.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            this.g = true;
            int i2 = this.f + 1;
            this.f = i2;
            if (i2 < vd.this.g.size()) {
                return vd.this.g.get(this.f);
            }
            return a().next();
        }

        @Override // j$.util.Iterator
        public void remove() {
            if (this.g) {
                this.g = false;
                vd vdVar = vd.this;
                int i2 = vd.m;
                vdVar.b();
                if (this.f < vd.this.g.size()) {
                    vd vdVar2 = vd.this;
                    int i3 = this.f;
                    this.f = i3 - 1;
                    vdVar2.i(i3);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* renamed from: vd$f */
    /* compiled from: SmallSortedMap */
    public class f extends AbstractSet<Map.Entry<K, V>> implements Set {
        public f(ud udVar) {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: vd */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            vd.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // j$.util.Collection, j$.util.Set
        public void clear() {
            vd.this.clear();
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = vd.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // j$.util.Collection, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new e(null);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            vd.this.remove(entry.getKey());
            return true;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.Collection, j$.util.Set
        public int size() {
            return vd.this.size();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public /* synthetic */ j$.util.Spliterator spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }
    }

    public vd(int i2, ud udVar) {
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

    public final void b() {
        if (this.i) {
            throw new UnsupportedOperationException();
        }
    }

    public Map.Entry<K, V> c(int i2) {
        return this.g.get(i2);
    }

    @Override // j$.util.Map
    public void clear() {
        b();
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: vd<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.h.containsKey(comparable);
    }

    public int d() {
        return this.g.size();
    }

    public Iterable<Map.Entry<K, V>> e() {
        return this.h.isEmpty() ? (Iterable<Map.Entry<K, V>>) c.b : this.h.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public java.util.Set<Map.Entry<K, V>> entrySet() {
        if (this.j == null) {
            this.j = new f(null);
        }
        return this.j;
    }

    @Override // j$.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vd)) {
            return super.equals(obj);
        }
        vd vdVar = (vd) obj;
        int size = size();
        if (size != vdVar.size()) {
            return false;
        }
        int d2 = d();
        if (d2 != vdVar.d()) {
            return entrySet().equals(vdVar.entrySet());
        }
        for (int i2 = 0; i2 < d2; i2++) {
            if (!c(i2).equals(vdVar.c(i2))) {
                return false;
            }
        }
        if (d2 != size) {
            return this.h.equals(vdVar.h);
        }
        return true;
    }

    public final SortedMap<K, V> f() {
        b();
        if (this.h.isEmpty() && !(this.h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.h = treeMap;
            this.k = treeMap.descendingMap();
        }
        return (SortedMap) this.h;
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public void g() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: vd<K extends java.lang.Comparable<K>, V> */
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

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: h */
    public V put(K k2, V v) {
        b();
        int a2 = a(k2);
        if (a2 >= 0) {
            vd<K, V>.d dVar = this.g.get(a2);
            vd.this.b();
            V v2 = dVar.g;
            dVar.g = v;
            return v2;
        }
        b();
        if (this.g.isEmpty() && !(this.g instanceof ArrayList)) {
            this.g = new ArrayList(this.f);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f) {
            return f().put(k2, v);
        }
        int size = this.g.size();
        int i3 = this.f;
        if (size == i3) {
            vd<K, V>.d remove = this.g.remove(i3 - 1);
            f().put(remove.f, remove.g);
        }
        this.g.add(i2, new d(k2, v));
        return null;
    }

    @Override // j$.util.Map
    public int hashCode() {
        int d2 = d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            i2 += this.g.get(i3).hashCode();
        }
        return this.h.size() > 0 ? i2 + this.h.hashCode() : i2;
    }

    public final V i(int i2) {
        b();
        V v = this.g.remove(i2).g;
        if (!this.h.isEmpty()) {
            java.util.Iterator<Map.Entry<K, V>> it = f().entrySet().iterator();
            this.g.add(new d(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: vd<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) i(a2);
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

    /* renamed from: vd$d */
    /* compiled from: SmallSortedMap */
    public class d implements Map.Entry<K, V>, Comparable<vd<K, V>.d>, Map.Entry {
        public final K f;
        public V g;

        public d(vd vdVar, Map.Entry<K, V> entry) {
            V value = entry.getValue();
            vd.this = vdVar;
            this.f = entry.getKey();
            this.g = value;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(vd<K, V>.d dVar) {
            return this.f.compareTo(dVar.f);
        }

        @Override // j$.util.Map.Entry
        public boolean equals(Object obj) {
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
        public Object getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // j$.util.Map.Entry
        public int hashCode() {
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
        public V setValue(V v) {
            vd vdVar = vd.this;
            int i = vd.m;
            vdVar.b();
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return ((Object) this.f) + "=" + ((Object) this.g);
        }

        public d(K k, V v) {
            this.f = k;
            this.g = v;
        }
    }
}
