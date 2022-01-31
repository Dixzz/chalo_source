package defpackage;

import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: g2  reason: default package */
/* compiled from: SafeIterableMap */
public class g2<K, V> implements Iterable<Map.Entry<K, V>>, Iterable {
    public c<K, V> f;
    public c<K, V> g;
    public WeakHashMap<f<K, V>, Boolean> h = new WeakHashMap<>();
    public int i = 0;

    /* renamed from: g2$a */
    /* compiled from: SafeIterableMap */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // defpackage.g2.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.i;
        }

        @Override // defpackage.g2.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.h;
        }
    }

    /* renamed from: g2$b */
    /* compiled from: SafeIterableMap */
    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // defpackage.g2.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.h;
        }

        @Override // defpackage.g2.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.i;
        }
    }

    /* renamed from: g2$c */
    /* compiled from: SafeIterableMap */
    public static class c<K, V> implements Map.Entry<K, V>, Map.Entry {
        public final K f;
        public final V g;
        public c<K, V> h;
        public c<K, V> i;

        public c(K k, V v) {
            this.f = k;
            this.g = v;
        }

        @Override // j$.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f.equals(cVar.f) || !this.g.equals(cVar.g)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // j$.util.Map.Entry
        public int hashCode() {
            return this.f.hashCode() ^ this.g.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return ((Object) this.f) + "=" + ((Object) this.g);
        }
    }

    /* renamed from: g2$d */
    /* compiled from: SafeIterableMap */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V>, j$.util.Iterator {
        public c<K, V> f;
        public boolean g = true;

        public d() {
        }

        @Override // defpackage.g2.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.i;
                this.f = cVar3;
                this.g = cVar3 == null;
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            if (!this.g) {
                c<K, V> cVar = this.f;
                if (cVar == null || cVar.h == null) {
                    return false;
                }
                return true;
            } else if (g2.this.f != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            if (this.g) {
                this.g = false;
                this.f = g2.this.f;
            } else {
                c<K, V> cVar = this.f;
                this.f = cVar != null ? cVar.h : null;
            }
            return this.f;
        }
    }

    /* renamed from: g2$e */
    /* compiled from: SafeIterableMap */
    public static abstract class e<K, V> implements java.util.Iterator<Map.Entry<K, V>>, f<K, V>, j$.util.Iterator {
        public c<K, V> f;
        public c<K, V> g;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f = cVar2;
            this.g = cVar;
        }

        @Override // defpackage.g2.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.f == cVar && cVar == this.g) {
                this.g = null;
                this.f = null;
            }
            c<K, V> cVar3 = this.f;
            if (cVar3 == cVar) {
                this.f = b(cVar3);
            }
            c<K, V> cVar4 = this.g;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.f;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.g = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator
        public boolean hasNext() {
            return this.g != null;
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.g;
            c<K, V> cVar2 = this.f;
            this.g = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* renamed from: g2$f */
    /* compiled from: SafeIterableMap */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> b(K k) {
        c<K, V> cVar = this.f;
        while (cVar != null && !cVar.f.equals(k)) {
            cVar = cVar.h;
        }
        return cVar;
    }

    public g2<K, V>.d d() {
        g2<K, V>.d dVar = new d();
        this.h.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public c<K, V> e(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.i++;
        c<K, V> cVar2 = this.g;
        if (cVar2 == null) {
            this.f = cVar;
            this.g = cVar;
            return cVar;
        }
        cVar2.h = cVar;
        cVar.i = cVar2;
        this.g = cVar;
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((defpackage.g2.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof defpackage.g2
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            g2 r7 = (defpackage.g2) r7
            int r1 = r6.i
            int r3 = r7.i
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x001b:
            r3 = r1
            g2$e r3 = (defpackage.g2.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            r4 = r7
            g2$e r4 = (defpackage.g2.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0044
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L_0x003b
            if (r4 != 0) goto L_0x0043
        L_0x003b:
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001b
        L_0x0043:
            return r2
        L_0x0044:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L_0x0053
            g2$e r7 = (defpackage.g2.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g2.equals(java.lang.Object):boolean");
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int hashCode() {
        java.util.Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i2;
            }
            i2 += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f, this.g);
        this.h.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V k(K k, V v) {
        c<K, V> b2 = b(k);
        if (b2 != null) {
            return b2.g;
        }
        e(k, v);
        return null;
    }

    public V n(K k) {
        c<K, V> b2 = b(k);
        if (b2 == null) {
            return null;
        }
        this.i--;
        if (!this.h.isEmpty()) {
            for (f<K, V> fVar : this.h.keySet()) {
                fVar.a(b2);
            }
        }
        c<K, V> cVar = b2.i;
        if (cVar != null) {
            cVar.h = b2.h;
        } else {
            this.f = b2.h;
        }
        c<K, V> cVar2 = b2.h;
        if (cVar2 != null) {
            cVar2.i = cVar;
        } else {
            this.g = cVar;
        }
        b2.h = null;
        b2.i = null;
        return b2.g;
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("[");
        java.util.Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                i0.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    i0.append(", ");
                }
            } else {
                i0.append("]");
                return i0.toString();
            }
        }
    }
}
