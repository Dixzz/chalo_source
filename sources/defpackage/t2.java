package defpackage;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: t2  reason: default package */
/* compiled from: MapCollections */
public abstract class t2<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public t2<K, V>.b f3297a;
    public t2<K, V>.c b;
    public t2<K, V>.e c;

    /* renamed from: t2$a */
    /* compiled from: MapCollections */
    public final class a<T> implements Iterator<T>, j$.util.Iterator {
        public final int f;
        public int g;
        public int h;
        public boolean i = false;

        public a(int i2) {
            this.f = i2;
            this.g = t2.this.d();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.h < this.g;
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) t2.this.b(this.h, this.f);
                this.h++;
                this.i = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public void remove() {
            if (this.i) {
                int i2 = this.h - 1;
                this.h = i2;
                this.g--;
                this.i = false;
                t2.this.h(i2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: t2$b */
    /* compiled from: MapCollections */
    public final class b implements Set<Map.Entry<K, V>>, j$.util.Set {
        public b() {
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: t2 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d = t2.this.d();
            java.util.Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                t2.this.g(entry.getKey(), entry.getValue());
            }
            return d != t2.this.d();
        }

        @Override // j$.util.Collection, j$.util.Set
        public void clear() {
            t2.this.a();
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e = t2.this.e(entry.getKey());
            if (e < 0) {
                return false;
            }
            return q2.c(t2.this.b(e, 1), entry.getValue());
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean containsAll(Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean equals(Object obj) {
            return t2.j(this, obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // j$.util.Collection, j$.util.Set
        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int d = t2.this.d() - 1; d >= 0; d--) {
                Object b = t2.this.b(d, 0);
                Object b2 = t2.this.b(d, 1);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                if (b2 == null) {
                    i2 = 0;
                } else {
                    i2 = b2.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean isEmpty() {
            return t2.this.d() == 0;
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, j$.util.Set
        public int size() {
            return t2.this.d();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // j$.util.Collection, j$.util.Set
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: t2$c */
    /* compiled from: MapCollections */
    public final class c implements java.util.Set<K>, j$.util.Set {
        public c() {
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(java.util.Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, j$.util.Set
        public void clear() {
            t2.this.a();
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean contains(Object obj) {
            return t2.this.e(obj) >= 0;
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            Map<K, V> c = t2.this.c();
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!c.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean equals(Object obj) {
            return t2.j(this, obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // j$.util.Collection, j$.util.Set
        public int hashCode() {
            int i;
            int i2 = 0;
            for (int d = t2.this.d() - 1; d >= 0; d--) {
                Object b = t2.this.b(d, 0);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                i2 += i;
            }
            return i2;
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean isEmpty() {
            return t2.this.d() == 0;
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator<K> iterator() {
            return new a(0);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean remove(Object obj) {
            int e = t2.this.e(obj);
            if (e < 0) {
                return false;
            }
            t2.this.h(e);
            return true;
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            Map<K, V> c = t2.this.c();
            int size = c.size();
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                c.remove(it.next());
            }
            return size != c.size();
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            return t2.k(t2.this.c(), collection);
        }

        @Override // j$.util.Collection, j$.util.Set
        public int size() {
            return t2.this.d();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // j$.util.Collection, j$.util.Set
        public Object[] toArray() {
            return t2.this.l(0);
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t2.this.m(tArr, 0);
        }
    }

    /* renamed from: t2$d */
    /* compiled from: MapCollections */
    public final class d implements java.util.Iterator<Map.Entry<K, V>>, Map.Entry<K, V>, Map.Entry, j$.util.Iterator {
        public int f;
        public int g;
        public boolean h = false;

        public d() {
            this.f = t2.this.d() - 1;
            this.g = -1;
        }

        @Override // j$.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.h) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!q2.c(entry.getKey(), t2.this.b(this.g, 0)) || !q2.c(entry.getValue(), t2.this.b(this.g, 1))) {
                    return false;
                }
                return true;
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            if (this.h) {
                return (K) t2.this.b(this.g, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V getValue() {
            if (this.h) {
                return (V) t2.this.b(this.g, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.g < this.f;
        }

        @Override // j$.util.Map.Entry
        public int hashCode() {
            int i2;
            if (this.h) {
                int i3 = 0;
                Object b = t2.this.b(this.g, 0);
                Object b2 = t2.this.b(this.g, 1);
                if (b == null) {
                    i2 = 0;
                } else {
                    i2 = b.hashCode();
                }
                if (b2 != null) {
                    i3 = b2.hashCode();
                }
                return i2 ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            if (hasNext()) {
                this.g++;
                this.h = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public void remove() {
            if (this.h) {
                t2.this.h(this.g);
                this.g--;
                this.f--;
                this.h = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V setValue(V v) {
            if (this.h) {
                return (V) t2.this.i(this.g, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: t2$e */
    /* compiled from: MapCollections */
    public final class e implements java.util.Collection<V>, j$.util.Collection {
        public e() {
        }

        @Override // j$.util.Collection, java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection
        public void clear() {
            t2.this.a();
        }

        @Override // j$.util.Collection
        public boolean contains(Object obj) {
            return t2.this.f(obj) >= 0;
        }

        @Override // j$.util.Collection, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // j$.util.Collection
        public boolean isEmpty() {
            return t2.this.d() == 0;
        }

        @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return new a(1);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection
        public boolean remove(Object obj) {
            int f2 = t2.this.f(obj);
            if (f2 < 0) {
                return false;
            }
            t2.this.h(f2);
            return true;
        }

        @Override // j$.util.Collection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            int d = t2.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(t2.this.b(i, 1))) {
                    t2.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.Collection, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            int d = t2.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(t2.this.b(i, 1))) {
                    t2.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // j$.util.Collection
        public int size() {
            return t2.this.d();
        }

        @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Collection.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // j$.util.Collection
        public Object[] toArray() {
            return t2.this.l(1);
        }

        @Override // j$.util.Collection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t2.this.m(tArr, 1);
        }
    }

    public static <T> boolean j(java.util.Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof java.util.Set) {
            java.util.Set set2 = (java.util.Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean k(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract java.util.Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i);

    public abstract V i(int i, V v);

    public Object[] l(int i) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] m(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
