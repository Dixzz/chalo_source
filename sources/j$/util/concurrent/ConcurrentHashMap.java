package j$.util.concurrent;

import a.C0118x;
import a.C0122z;
import a.D;
import a.E0;
import a.U;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.x;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, b {
    static final int g = Runtime.getRuntime().availableProcessors();
    private static final Unsafe h;
    private static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final int o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a  reason: collision with root package name */
    volatile transient l[] f1650a;
    private volatile transient l[] b;
    private volatile transient long baseCount;
    private volatile transient c[] c;
    private volatile transient int cellsBusy;
    private transient i d;
    private transient u e;
    private transient e f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    /* access modifiers changed from: package-private */
    public static class a<K, V> extends p<K, V> {
        final ConcurrentHashMap i;
        l j;

        a(l[] lVarArr, int i2, int i3, int i4, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4);
            this.i = concurrentHashMap;
            a();
        }

        public final boolean hasMoreElements() {
            return this.b != null;
        }

        public final boolean hasNext() {
            return this.b != null;
        }

        public final void remove() {
            l lVar = this.j;
            if (lVar != null) {
                this.j = null;
                this.i.i(lVar.b, null, null);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        volatile long value;

        c(long j) {
            this.value = j;
        }
    }

    static final class d<K, V> extends a<K, V> implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        d(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, D.b(consumer));
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            l lVar = this.b;
            if (lVar != null) {
                Object obj = lVar.b;
                Object obj2 = lVar.c;
                this.j = lVar;
                a();
                return new k(obj, obj2, this.i);
            }
            throw new NoSuchElementException();
        }
    }

    static final class e<K, V> extends b<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable, j$.util.Set {
        e(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        /* renamed from: a */
        public boolean add(Map.Entry entry) {
            return this.f1651a.h(entry.getKey(), entry.getValue(), false) == null;
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(Collection collection) {
            java.util.Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.Collection, j$.util.concurrent.ConcurrentHashMap.b, j$.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = this.f1651a.get(key)) == null || (value = entry.getValue()) == null || (value != obj2 && !value.equals(obj2))) ? false : true;
        }

        @Override // j$.util.Collection, j$.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.f1651a.f1650a;
            if (lVarArr != null) {
                p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
                while (true) {
                    l a2 = pVar.a();
                    if (a2 != null) {
                        consumer.accept(new k(a2.b, a2.c, this.f1651a));
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(D.b(consumer));
        }

        @Override // j$.util.Collection, j$.util.Set
        public final int hashCode() {
            l[] lVarArr = this.f1651a.f1650a;
            int i = 0;
            if (lVarArr != null) {
                p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
                while (true) {
                    l a2 = pVar.a();
                    if (a2 == null) {
                        break;
                    }
                    i += a2.hashCode();
                }
            }
            return i;
        }

        @Override // j$.util.Collection, j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.f1651a;
            l[] lVarArr = concurrentHashMap.f1650a;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new d(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.f1651a.remove(key, value);
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.f1651a;
            long m = concurrentHashMap.m();
            l[] lVarArr = concurrentHashMap.f1650a;
            int length = lVarArr == null ? 0 : lVarArr.length;
            long j = 0;
            if (m >= 0) {
                j = m;
            }
            return new f(lVarArr, length, 0, length, j, concurrentHashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f<K, V> extends p<K, V> implements Spliterator<Map.Entry<K, V>> {
        final ConcurrentHashMap i;
        long j;

        f(l[] lVarArr, int i2, int i3, int i4, long j2, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4);
            this.i = concurrentHashMap;
            this.j = j2;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l a2 = a();
            if (a2 == null) {
                return false;
            }
            consumer.accept(new k(a2.b, a2.c, this.i));
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.j;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l a2 = a();
                if (a2 != null) {
                    consumer.accept(new k(a2.b, a2.c, this.i));
                } else {
                    return;
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.chrono.b.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.chrono.b.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f;
            int i3 = this.g;
            int i4 = (i2 + i3) >>> 1;
            if (i4 <= i2) {
                return null;
            }
            l[] lVarArr = this.f1655a;
            int i5 = this.h;
            this.g = i4;
            long j2 = this.j >>> 1;
            this.j = j2;
            return new f(lVarArr, i5, i4, i3, j2, this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g<K, V> extends l<K, V> {
        final l[] e;

        g(l[] lVarArr) {
            super(-1, null, null, null);
            this.e = lVarArr;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if ((r0 instanceof j$.util.concurrent.ConcurrentHashMap.g) == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            r0 = ((j$.util.concurrent.ConcurrentHashMap.g) r0).e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
            return r0.a(r5, r6);
         */
        @Override // j$.util.concurrent.ConcurrentHashMap.l
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public j$.util.concurrent.ConcurrentHashMap.l a(int r5, java.lang.Object r6) {
            /*
                r4 = this;
                j$.util.concurrent.ConcurrentHashMap$l[] r0 = r4.e
            L_0x0002:
                r1 = 0
                if (r0 == 0) goto L_0x0037
                int r2 = r0.length
                if (r2 == 0) goto L_0x0037
                int r2 = r2 + -1
                r2 = r2 & r5
                j$.util.concurrent.ConcurrentHashMap$l r0 = j$.util.concurrent.ConcurrentHashMap.n(r0, r2)
                if (r0 != 0) goto L_0x0012
                goto L_0x0037
            L_0x0012:
                int r2 = r0.f1653a
                if (r2 != r5) goto L_0x0023
                java.lang.Object r3 = r0.b
                if (r3 == r6) goto L_0x0022
                if (r3 == 0) goto L_0x0023
                boolean r3 = r6.equals(r3)
                if (r3 == 0) goto L_0x0023
            L_0x0022:
                return r0
            L_0x0023:
                if (r2 >= 0) goto L_0x0033
                boolean r1 = r0 instanceof j$.util.concurrent.ConcurrentHashMap.g
                if (r1 == 0) goto L_0x002e
                j$.util.concurrent.ConcurrentHashMap$g r0 = (j$.util.concurrent.ConcurrentHashMap.g) r0
                j$.util.concurrent.ConcurrentHashMap$l[] r0 = r0.e
                goto L_0x0002
            L_0x002e:
                j$.util.concurrent.ConcurrentHashMap$l r5 = r0.a(r5, r6)
                return r5
            L_0x0033:
                j$.util.concurrent.ConcurrentHashMap$l r0 = r0.d
                if (r0 != 0) goto L_0x0012
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.g.a(int, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$l");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h<K, V> extends a<K, V> implements java.util.Iterator<K>, Enumeration<K>, j$.util.Iterator {
        h(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, D.b(consumer));
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public final Object next() {
            l lVar = this.b;
            if (lVar != null) {
                Object obj = lVar.b;
                this.j = lVar;
                a();
                return obj;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    public static class i<K, V> extends b<K, V, K> implements Set<K>, Serializable, j$.util.Set {
        i(ConcurrentHashMap concurrentHashMap, Object obj) {
            super(concurrentHashMap);
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, j$.util.concurrent.ConcurrentHashMap.b, j$.util.Set
        public boolean contains(Object obj) {
            return this.f1651a.containsKey(obj);
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.f1651a.f1650a;
            if (lVarArr != null) {
                p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
                while (true) {
                    l a2 = pVar.a();
                    if (a2 != null) {
                        consumer.accept(a2.b);
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(D.b(consumer));
        }

        @Override // j$.util.Collection, j$.util.Set
        public int hashCode() {
            java.util.Iterator it = iterator();
            int i = 0;
            while (((a) it).hasNext()) {
                i += ((h) it).next().hashCode();
            }
            return i;
        }

        @Override // j$.util.Collection, j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.f1651a;
            l[] lVarArr = concurrentHashMap.f1650a;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new h(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // j$.util.Collection, j$.util.Set
        public boolean remove(Object obj) {
            return this.f1651a.remove(obj) != null;
        }

        @Override // j$.util.Collection, java.util.Collection, java.util.Set, j$.util.Set, j$.lang.Iterable, java.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.f1651a;
            long m = concurrentHashMap.m();
            l[] lVarArr = concurrentHashMap.f1650a;
            int length = lVarArr == null ? 0 : lVarArr.length;
            long j = 0;
            if (m >= 0) {
                j = m;
            }
            return new j(lVarArr, length, 0, length, j);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j<K, V> extends p<K, V> implements Spliterator<K> {
        long i;

        j(l[] lVarArr, int i2, int i3, int i4, long j) {
            super(lVarArr, i2, i3, i4);
            this.i = j;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l a2 = a();
            if (a2 == null) {
                return false;
            }
            consumer.accept(a2.b);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.i;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l a2 = a();
                if (a2 != null) {
                    consumer.accept(a2.b);
                } else {
                    return;
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.chrono.b.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.chrono.b.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f;
            int i3 = this.g;
            int i4 = (i2 + i3) >>> 1;
            if (i4 <= i2) {
                return null;
            }
            l[] lVarArr = this.f1655a;
            int i5 = this.h;
            this.g = i4;
            long j = this.i >>> 1;
            this.i = j;
            return new j(lVarArr, i5, i4, i3, j);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class k<K, V> implements Map.Entry<K, V>, Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        final Object f1652a;
        Object b;
        final ConcurrentHashMap c;

        k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
            this.f1652a = obj;
            this.b = obj2;
            this.c = concurrentHashMap;
        }

        @Override // j$.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.f1652a) || key.equals(obj2)) && (value == (obj3 = this.b) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getKey() {
            return this.f1652a;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // j$.util.Map.Entry
        public int hashCode() {
            return this.f1652a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object setValue(Object obj) {
            obj.getClass();
            Object obj2 = this.b;
            this.b = obj;
            this.c.put(this.f1652a, obj);
            return obj2;
        }

        public String toString() {
            return this.f1652a + "=" + this.b;
        }
    }

    /* access modifiers changed from: package-private */
    public static class l<K, V> implements Map.Entry<K, V>, Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        final int f1653a;
        final Object b;
        volatile Object c;
        volatile l d;

        l(int i, Object obj, Object obj2, l lVar) {
            this.f1653a = i;
            this.b = obj;
            this.c = obj2;
            this.d = lVar;
        }

        /* access modifiers changed from: package-private */
        public l a(int i, Object obj) {
            Object obj2;
            l<K, V> lVar = this;
            do {
                if (lVar.f1653a == i && ((obj2 = lVar.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return lVar;
                }
                lVar = lVar.d;
            } while (lVar != null);
            return null;
        }

        @Override // j$.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.b) || key.equals(obj2)) && (value == (obj3 = this.c) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object getValue() {
            return this.c;
        }

        @Override // j$.util.Map.Entry
        public final int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class m<K, V> extends l<K, V> {
        m() {
            super(-3, null, null, null);
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.concurrent.ConcurrentHashMap.l
        public l a(int i, Object obj) {
            return null;
        }
    }

    static class n<K, V> extends ReentrantLock implements Serializable {
        n(float f) {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class o<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f1654a;
        int b;
        l[] c;
        o d;

        o() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class p<K, V> {

        /* renamed from: a  reason: collision with root package name */
        l[] f1655a;
        l b = null;
        o c;
        o d;
        int e;
        int f;
        int g;
        final int h;

        p(l[] lVarArr, int i, int i2, int i3) {
            this.f1655a = lVarArr;
            this.h = i;
            this.e = i2;
            this.f = i2;
            this.g = i3;
        }

        /* access modifiers changed from: package-private */
        public final l a() {
            l[] lVarArr;
            int length;
            int i;
            o oVar;
            l lVar = this.b;
            if (lVar != null) {
                lVar = lVar.d;
            }
            while (lVar == null) {
                if (this.f >= this.g || (lVarArr = this.f1655a) == null || (length = lVarArr.length) <= (i = this.e) || i < 0) {
                    this.b = null;
                    return null;
                }
                l n = ConcurrentHashMap.n(lVarArr, i);
                if (n == null || n.f1653a >= 0) {
                    lVar = n;
                } else if (n instanceof g) {
                    this.f1655a = ((g) n).e;
                    o oVar2 = this.d;
                    if (oVar2 != null) {
                        this.d = oVar2.d;
                    } else {
                        oVar2 = new o();
                    }
                    oVar2.c = lVarArr;
                    oVar2.f1654a = length;
                    oVar2.b = i;
                    oVar2.d = this.c;
                    this.c = oVar2;
                    lVar = null;
                } else {
                    lVar = n instanceof q ? ((q) n).f : null;
                }
                if (this.c != null) {
                    while (true) {
                        oVar = this.c;
                        if (oVar == null) {
                            break;
                        }
                        int i2 = this.e;
                        int i3 = oVar.f1654a;
                        int i4 = i2 + i3;
                        this.e = i4;
                        if (i4 < length) {
                            break;
                        }
                        this.e = oVar.b;
                        this.f1655a = oVar.c;
                        oVar.c = null;
                        o oVar3 = oVar.d;
                        oVar.d = this.d;
                        this.c = oVar3;
                        this.d = oVar;
                        length = i3;
                    }
                    if (oVar == null) {
                        int i5 = this.e + this.h;
                        this.e = i5;
                        if (i5 >= length) {
                            int i6 = this.f + 1;
                            this.f = i6;
                            this.e = i6;
                        }
                    }
                } else {
                    int i7 = i + this.h;
                    this.e = i7;
                    if (i7 >= length) {
                        int i8 = this.f + 1;
                        this.f = i8;
                        this.e = i8;
                    }
                }
            }
            this.b = lVar;
            return lVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class q<K, V> extends l<K, V> {
        private static final Unsafe h;
        private static final long i;
        r e;
        volatile r f;
        volatile Thread g;
        volatile int lockState;

        static {
            try {
                Unsafe c = c.c();
                h = c;
                i = c.objectFieldOffset(q.class.getDeclaredField("lockState"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        q(r rVar) {
            super(-2, null, null, null);
            int j;
            int d;
            this.f = rVar;
            r rVar2 = null;
            while (rVar != null) {
                r rVar3 = (r) rVar.d;
                rVar.g = null;
                rVar.f = null;
                if (rVar2 == null) {
                    rVar.e = null;
                    rVar.i = false;
                } else {
                    Object obj = rVar.b;
                    int i2 = rVar.f1653a;
                    r rVar4 = rVar2;
                    Class cls = null;
                    while (true) {
                        Object obj2 = rVar4.b;
                        int i3 = rVar4.f1653a;
                        j = i3 > i2 ? -1 : i3 < i2 ? 1 : ((cls == null && (cls = ConcurrentHashMap.c(obj)) == null) || (d = ConcurrentHashMap.d(cls, obj, obj2)) == 0) ? j(obj, obj2) : d;
                        r rVar5 = j <= 0 ? rVar4.f : rVar4.g;
                        if (rVar5 == null) {
                            break;
                        }
                        rVar4 = rVar5;
                    }
                    rVar.e = rVar4;
                    if (j <= 0) {
                        rVar4.f = rVar;
                    } else {
                        rVar4.g = rVar;
                    }
                    rVar = c(rVar2, rVar);
                }
                rVar2 = rVar;
                rVar = rVar3;
            }
            this.e = rVar2;
        }

        static r b(r rVar, r rVar2) {
            while (rVar2 != null && rVar2 != rVar) {
                r rVar3 = rVar2.e;
                if (rVar3 == null) {
                    rVar2.i = false;
                    return rVar2;
                } else if (rVar2.i) {
                    rVar2.i = false;
                    return rVar;
                } else {
                    r rVar4 = rVar3.f;
                    r rVar5 = null;
                    if (rVar4 == rVar2) {
                        rVar4 = rVar3.g;
                        if (rVar4 != null && rVar4.i) {
                            rVar4.i = false;
                            rVar3.i = true;
                            rVar = h(rVar, rVar3);
                            rVar3 = rVar2.e;
                            rVar4 = rVar3 == null ? null : rVar3.g;
                        }
                        if (rVar4 != null) {
                            r rVar6 = rVar4.f;
                            r rVar7 = rVar4.g;
                            if ((rVar7 != null && rVar7.i) || (rVar6 != null && rVar6.i)) {
                                if (rVar7 == null || !rVar7.i) {
                                    if (rVar6 != null) {
                                        rVar6.i = false;
                                    }
                                    rVar4.i = true;
                                    rVar = i(rVar, rVar4);
                                    rVar3 = rVar2.e;
                                    if (rVar3 != null) {
                                        rVar5 = rVar3.g;
                                    }
                                } else {
                                    rVar5 = rVar4;
                                }
                                if (rVar5 != null) {
                                    rVar5.i = rVar3 == null ? false : rVar3.i;
                                    r rVar8 = rVar5.g;
                                    if (rVar8 != null) {
                                        rVar8.i = false;
                                    }
                                }
                                if (rVar3 != null) {
                                    rVar3.i = false;
                                    rVar = h(rVar, rVar3);
                                }
                                rVar2 = rVar;
                                rVar = rVar2;
                            }
                            rVar4.i = true;
                        }
                    } else {
                        if (rVar4 != null && rVar4.i) {
                            rVar4.i = false;
                            rVar3.i = true;
                            rVar = i(rVar, rVar3);
                            rVar3 = rVar2.e;
                            rVar4 = rVar3 == null ? null : rVar3.f;
                        }
                        if (rVar4 != null) {
                            r rVar9 = rVar4.f;
                            r rVar10 = rVar4.g;
                            if ((rVar9 != null && rVar9.i) || (rVar10 != null && rVar10.i)) {
                                if (rVar9 == null || !rVar9.i) {
                                    if (rVar10 != null) {
                                        rVar10.i = false;
                                    }
                                    rVar4.i = true;
                                    rVar = h(rVar, rVar4);
                                    rVar3 = rVar2.e;
                                    if (rVar3 != null) {
                                        rVar5 = rVar3.f;
                                    }
                                } else {
                                    rVar5 = rVar4;
                                }
                                if (rVar5 != null) {
                                    rVar5.i = rVar3 == null ? false : rVar3.i;
                                    r rVar11 = rVar5.f;
                                    if (rVar11 != null) {
                                        rVar11.i = false;
                                    }
                                }
                                if (rVar3 != null) {
                                    rVar3.i = false;
                                    rVar = i(rVar, rVar3);
                                }
                                rVar2 = rVar;
                                rVar = rVar2;
                            }
                            rVar4.i = true;
                        }
                    }
                    rVar2 = rVar3;
                }
            }
            return rVar;
        }

        static r c(r rVar, r rVar2) {
            r rVar3;
            rVar2.i = true;
            while (true) {
                r rVar4 = rVar2.e;
                if (rVar4 == null) {
                    rVar2.i = false;
                    return rVar2;
                } else if (!rVar4.i || (rVar3 = rVar4.e) == null) {
                    return rVar;
                } else {
                    r rVar5 = rVar3.f;
                    if (rVar4 == rVar5) {
                        rVar5 = rVar3.g;
                        if (rVar5 == null || !rVar5.i) {
                            if (rVar2 == rVar4.g) {
                                rVar = h(rVar, rVar4);
                                r rVar6 = rVar4.e;
                                rVar3 = rVar6 == null ? null : rVar6.e;
                                rVar4 = rVar6;
                                rVar2 = rVar4;
                            }
                            if (rVar4 != null) {
                                rVar4.i = false;
                                if (rVar3 != null) {
                                    rVar3.i = true;
                                    rVar = i(rVar, rVar3);
                                }
                            }
                        }
                    } else if (rVar5 == null || !rVar5.i) {
                        if (rVar2 == rVar4.f) {
                            rVar = i(rVar, rVar4);
                            r rVar7 = rVar4.e;
                            rVar3 = rVar7 == null ? null : rVar7.e;
                            rVar4 = rVar7;
                            rVar2 = rVar4;
                        }
                        if (rVar4 != null) {
                            rVar4.i = false;
                            if (rVar3 != null) {
                                rVar3.i = true;
                                rVar = h(rVar, rVar3);
                            }
                        }
                    }
                    rVar5.i = false;
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar2 = rVar3;
                }
            }
            return rVar;
        }

        private final void d() {
            boolean z = false;
            while (true) {
                int i2 = this.lockState;
                if ((i2 & -3) == 0) {
                    if (h.compareAndSwapInt(this, i, i2, 1)) {
                        break;
                    }
                } else if ((i2 & 2) == 0) {
                    if (h.compareAndSwapInt(this, i, i2, i2 | 2)) {
                        z = true;
                        this.g = Thread.currentThread();
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.g = null;
            }
        }

        private final void e() {
            if (!h.compareAndSwapInt(this, i, 0, 1)) {
                d();
            }
        }

        static r h(r rVar, r rVar2) {
            r rVar3;
            if (!(rVar2 == null || (rVar3 = rVar2.g) == null)) {
                r rVar4 = rVar3.f;
                rVar2.g = rVar4;
                if (rVar4 != null) {
                    rVar4.e = rVar2;
                }
                r rVar5 = rVar2.e;
                rVar3.e = rVar5;
                if (rVar5 == null) {
                    rVar3.i = false;
                    rVar = rVar3;
                } else if (rVar5.f == rVar2) {
                    rVar5.f = rVar3;
                } else {
                    rVar5.g = rVar3;
                }
                rVar3.f = rVar2;
                rVar2.e = rVar3;
            }
            return rVar;
        }

        static r i(r rVar, r rVar2) {
            r rVar3;
            if (!(rVar2 == null || (rVar3 = rVar2.f) == null)) {
                r rVar4 = rVar3.g;
                rVar2.f = rVar4;
                if (rVar4 != null) {
                    rVar4.e = rVar2;
                }
                r rVar5 = rVar2.e;
                rVar3.e = rVar5;
                if (rVar5 == null) {
                    rVar3.i = false;
                    rVar = rVar3;
                } else if (rVar5.g == rVar2) {
                    rVar5.g = rVar3;
                } else {
                    rVar5.f = rVar3;
                }
                rVar3.g = rVar2;
                rVar2.e = rVar3;
            }
            return rVar;
        }

        static int j(Object obj, Object obj2) {
            int compareTo;
            return (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : compareTo;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.concurrent.ConcurrentHashMap.l
        public final l a(int i2, Object obj) {
            Thread thread;
            Thread thread2;
            Object obj2;
            l lVar = this.f;
            while (true) {
                r rVar = null;
                if (lVar == null) {
                    return null;
                }
                int i3 = this.lockState;
                if ((i3 & 3) == 0) {
                    Unsafe unsafe = h;
                    long j = i;
                    if (unsafe.compareAndSwapInt(this, j, i3, i3 + 4)) {
                        try {
                            r rVar2 = this.e;
                            if (rVar2 != null) {
                                rVar = rVar2.b(i2, obj, null);
                            }
                            if (c.a(unsafe, this, j, -4) == 6 && (thread2 = this.g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return rVar;
                        } catch (Throwable th) {
                            if (c.a(h, this, i, -4) == 6 && (thread = this.g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th;
                        }
                    }
                } else if (lVar.f1653a != i2 || ((obj2 = lVar.b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    lVar = lVar.d;
                }
            }
            return lVar;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final j$.util.concurrent.ConcurrentHashMap.r f(int r16, java.lang.Object r17, java.lang.Object r18) {
            /*
            // Method dump skipped, instructions count: 172
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.f(int, java.lang.Object, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$r");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x008e A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00a9 A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x00aa A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x00ba A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd A[Catch:{ all -> 0x00c8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean g(j$.util.concurrent.ConcurrentHashMap.r r11) {
            /*
            // Method dump skipped, instructions count: 205
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.g(j$.util.concurrent.ConcurrentHashMap$r):boolean");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class r<K, V> extends l<K, V> {
        r e;
        r f;
        r g;
        r h;
        boolean i;

        r(int i2, Object obj, Object obj2, l lVar, r rVar) {
            super(i2, obj, obj2, lVar);
            this.e = rVar;
        }

        /* access modifiers changed from: package-private */
        @Override // j$.util.concurrent.ConcurrentHashMap.l
        public l a(int i2, Object obj) {
            return b(i2, obj, null);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
            if (r0 < 0) goto L_0x003b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final j$.util.concurrent.ConcurrentHashMap.r b(int r6, java.lang.Object r7, java.lang.Class r8) {
            /*
                r5 = this;
                if (r7 == 0) goto L_0x0040
                r0 = r5
            L_0x0003:
                j$.util.concurrent.ConcurrentHashMap$r r1 = r0.f
                j$.util.concurrent.ConcurrentHashMap$r r2 = r0.g
                int r3 = r0.f1653a
                if (r3 <= r6) goto L_0x000c
                goto L_0x003b
            L_0x000c:
                if (r3 >= r6) goto L_0x000f
                goto L_0x001e
            L_0x000f:
                java.lang.Object r3 = r0.b
                if (r3 == r7) goto L_0x003f
                if (r3 == 0) goto L_0x001c
                boolean r4 = r7.equals(r3)
                if (r4 == 0) goto L_0x001c
                goto L_0x003f
            L_0x001c:
                if (r1 != 0) goto L_0x0020
            L_0x001e:
                r0 = r2
                goto L_0x003c
            L_0x0020:
                if (r2 != 0) goto L_0x0023
                goto L_0x003b
            L_0x0023:
                if (r8 != 0) goto L_0x002b
                java.lang.Class r8 = j$.util.concurrent.ConcurrentHashMap.c(r7)
                if (r8 == 0) goto L_0x0034
            L_0x002b:
                int r0 = j$.util.concurrent.ConcurrentHashMap.d(r8, r7, r3)
                if (r0 == 0) goto L_0x0034
                if (r0 >= 0) goto L_0x001e
                goto L_0x003b
            L_0x0034:
                j$.util.concurrent.ConcurrentHashMap$r r0 = r2.b(r6, r7, r8)
                if (r0 == 0) goto L_0x003b
                return r0
            L_0x003b:
                r0 = r1
            L_0x003c:
                if (r0 != 0) goto L_0x0003
                goto L_0x0040
            L_0x003f:
                return r0
            L_0x0040:
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.r.b(int, java.lang.Object, java.lang.Class):j$.util.concurrent.ConcurrentHashMap$r");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class s<K, V> extends a<K, V> implements java.util.Iterator<V>, Enumeration<V>, j$.util.Iterator {
        s(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, D.b(consumer));
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public final Object next() {
            l lVar = this.b;
            if (lVar != null) {
                Object obj = lVar.c;
                this.j = lVar;
                a();
                return obj;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class t<K, V> extends p<K, V> implements Spliterator<V> {
        long i;

        t(l[] lVarArr, int i2, int i3, int i4, long j) {
            super(lVarArr, i2, i3, i4);
            this.i = j;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l a2 = a();
            if (a2 == null) {
                return false;
            }
            consumer.accept(a2.c);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4352;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.i;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l a2 = a();
                if (a2 != null) {
                    consumer.accept(a2.c);
                } else {
                    return;
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.chrono.b.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.chrono.b.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f;
            int i3 = this.g;
            int i4 = (i2 + i3) >>> 1;
            if (i4 <= i2) {
                return null;
            }
            l[] lVarArr = this.f1655a;
            int i5 = this.h;
            this.g = i4;
            long j = this.i >>> 1;
            this.i = j;
            return new t(lVarArr, i5, i4, i3, j);
        }
    }

    static final class u<K, V> extends b<K, V, V> implements Collection<V>, Serializable, j$.util.Collection {
        u(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // j$.util.Collection, java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Collection, j$.util.concurrent.ConcurrentHashMap.b
        public final boolean contains(Object obj) {
            return this.f1651a.containsValue(obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.f1651a.f1650a;
            if (lVarArr != null) {
                p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
                while (true) {
                    l a2 = pVar.a();
                    if (a2 != null) {
                        consumer.accept(a2.c);
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(D.b(consumer));
        }

        @Override // j$.util.Collection, j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.f1651a;
            l[] lVarArr = concurrentHashMap.f1650a;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new s(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // j$.util.Collection
        public final boolean remove(Object obj) {
            a aVar;
            if (obj == null) {
                return false;
            }
            java.util.Iterator it = iterator();
            do {
                aVar = (a) it;
                if (!aVar.hasNext()) {
                    return false;
                }
            } while (!obj.equals(((s) it).next()));
            aVar.remove();
            return true;
        }

        @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.f1651a;
            long m = concurrentHashMap.m();
            l[] lVarArr = concurrentHashMap.f1650a;
            int length = lVarArr == null ? 0 : lVarArr.length;
            long j = 0;
            if (m >= 0) {
                j = m;
            }
            return new t(lVarArr, length, 0, length, j);
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            Unsafe c2 = c.c();
            h = c2;
            i = c2.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            j = c2.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            k = c2.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            l = c2.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            m = c2.objectFieldOffset(c.class.getDeclaredField(FirebaseAnalytics.Param.VALUE));
            n = (long) c2.arrayBaseOffset(l[].class);
            int arrayIndexScale = c2.arrayIndexScale(l[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                o = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                return;
            }
            throw new Error("data type scale not a power of two");
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i2) {
        if (i2 >= 0) {
            this.sizeCtl = i2 >= 536870912 ? CommonUtils.BYTES_IN_A_GIGABYTE : o(i2 + (i2 >>> 1) + 1);
            return;
        }
        throw new IllegalArgumentException();
    }

    public ConcurrentHashMap(int i2, float f2, int i3) {
        if (f2 <= 0.0f || i2 < 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        long j2 = (long) (((double) (((float) ((long) (i2 < i3 ? i3 : i2))) / f2)) + 1.0d);
        this.sizeCtl = j2 >= 1073741824 ? CommonUtils.BYTES_IN_A_GIGABYTE : o((int) j2);
    }

    public ConcurrentHashMap(java.util.Map map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r1.compareAndSwapLong(r11, r3, r5, r9) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(long r12, int r14) {
        /*
        // Method dump skipped, instructions count: 152
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    static final boolean b(l[] lVarArr, int i2, l lVar, l lVar2) {
        return h.compareAndSwapObject(lVarArr, (((long) i2) << o) + n, (Object) null, lVar2);
    }

    static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int d(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009b, code lost:
        if (r24.c != r7) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009d, code lost:
        r1 = new j$.util.concurrent.ConcurrentHashMap.c[(r8 << 1)];
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a2, code lost:
        if (r2 >= r8) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a4, code lost:
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ab, code lost:
        r24.c = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0101 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x001b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e(long r25, boolean r27) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.e(long, boolean):void");
    }

    private final l[] g() {
        while (true) {
            l[] lVarArr = this.f1650a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else if (h.compareAndSwapInt(this, i, i2, -1)) {
                try {
                    l[] lVarArr2 = this.f1650a;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i3 = i2 > 0 ? i2 : 16;
                        l[] lVarArr3 = new l[i3];
                        this.f1650a = lVarArr3;
                        i2 = i3 - (i3 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    return lVarArr2;
                } finally {
                    this.sizeCtl = i2;
                }
            }
        }
    }

    static final int j(int i2) {
        return Integer.numberOfLeadingZeros(i2) | 32768;
    }

    static final void k(l[] lVarArr, int i2, l lVar) {
        h.putObjectVolatile(lVarArr, (((long) i2) << o) + n, lVar);
    }

    static final int l(int i2) {
        return (i2 ^ (i2 >>> 16)) & Integer.MAX_VALUE;
    }

    static final l n(l[] lVarArr, int i2) {
        return (l) h.getObjectVolatile(lVarArr, (((long) i2) << o) + n);
    }

    private static final int o(int i2) {
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        if (i8 < 0) {
            return 1;
        }
        return i8 >= 1073741824 ? CommonUtils.BYTES_IN_A_GIGABYTE : 1 + i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r13v13, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r13v14, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r6v17, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void p(j$.util.concurrent.ConcurrentHashMap.l[] r31, j$.util.concurrent.ConcurrentHashMap.l[] r32) {
        /*
        // Method dump skipped, instructions count: 532
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.p(j$.util.concurrent.ConcurrentHashMap$l[], j$.util.concurrent.ConcurrentHashMap$l[]):void");
    }

    private final void q(l[] lVarArr, int i2) {
        if (lVarArr != null) {
            int length = lVarArr.length;
            if (length < 64) {
                r(length << 1);
                return;
            }
            l n2 = n(lVarArr, i2);
            if (n2 != null && n2.f1653a >= 0) {
                synchronized (n2) {
                    if (n(lVarArr, i2) == n2) {
                        r rVar = null;
                        l lVar = n2;
                        r rVar2 = null;
                        while (lVar != null) {
                            r rVar3 = new r(lVar.f1653a, lVar.b, lVar.c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.d = rVar3;
                            }
                            lVar = lVar.d;
                            rVar2 = rVar3;
                        }
                        k(lVarArr, i2, new q(rVar));
                    }
                }
            }
        }
    }

    private final void r(int i2) {
        int length;
        l[] lVarArr;
        int o2 = i2 >= 536870912 ? CommonUtils.BYTES_IN_A_GIGABYTE : o(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.sizeCtl;
            if (i3 >= 0) {
                l[] lVarArr2 = this.f1650a;
                if (lVarArr2 == null || (length = lVarArr2.length) == 0) {
                    int i4 = i3 > o2 ? i3 : o2;
                    if (h.compareAndSwapInt(this, i, i3, -1)) {
                        try {
                            if (this.f1650a == lVarArr2) {
                                this.f1650a = new l[i4];
                                i3 = i4 - (i4 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = i3;
                        }
                    }
                } else if (o2 > i3 && length < 1073741824) {
                    if (lVarArr2 == this.f1650a) {
                        int j2 = j(length);
                        if (i3 < 0) {
                            if ((i3 >>> 16) == j2 && i3 != j2 + 1 && i3 != j2 + 65535 && (lVarArr = this.b) != null && this.transferIndex > 0) {
                                if (h.compareAndSwapInt(this, i, i3, i3 + 1)) {
                                    p(lVarArr2, lVarArr);
                                }
                            } else {
                                return;
                            }
                        } else if (h.compareAndSwapInt(this, i, i3, (j2 << 16) + 2)) {
                            p(lVarArr2, null);
                        }
                    } else {
                        continue;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j2;
        int i2;
        boolean z;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j3 = 0;
        long j4 = 0;
        l lVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j2 = 1;
            if (readObject != null && readObject2 != null) {
                j4++;
                lVar = new l(l(readObject.hashCode()), readObject, readObject2, lVar);
            }
        }
        if (j4 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j4 >= 536870912) {
            i2 = CommonUtils.BYTES_IN_A_GIGABYTE;
        } else {
            int i3 = (int) j4;
            i2 = o(i3 + (i3 >>> 1) + 1);
        }
        l[] lVarArr = new l[i2];
        int i4 = i2 - 1;
        while (lVar != null) {
            l lVar2 = lVar.d;
            int i5 = lVar.f1653a;
            int i6 = i5 & i4;
            l n2 = n(lVarArr, i6);
            if (n2 == null) {
                z = true;
            } else {
                Object obj2 = lVar.b;
                if (n2.f1653a >= 0) {
                    l lVar3 = n2;
                    int i7 = 0;
                    while (true) {
                        if (lVar3 == null) {
                            z = true;
                            break;
                        } else if (lVar3.f1653a != i5 || ((obj = lVar3.b) != obj2 && (obj == null || !obj2.equals(obj)))) {
                            i7++;
                            lVar3 = lVar3.d;
                        }
                    }
                    z = false;
                    if (z && i7 >= 8) {
                        j3++;
                        lVar.d = n2;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.f1653a, lVar4.b, lVar4.c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.d = rVar3;
                            }
                            lVar4 = lVar4.d;
                            rVar2 = rVar3;
                            j3 = j3;
                        }
                        k(lVarArr, i6, new q(rVar));
                    }
                } else if (((q) n2).f(i5, obj2, lVar.c) == null) {
                    j3 += j2;
                }
                z = false;
            }
            if (z) {
                j3++;
                lVar.d = n2;
                k(lVarArr, i6, lVar);
            }
            j2 = 1;
            lVar = lVar2;
        }
        this.f1650a = lVarArr;
        this.sizeCtl = i2 - (i2 >>> 2);
        this.baseCount = j3;
    }

    static l s(l lVar) {
        l lVar2 = null;
        l lVar3 = null;
        while (lVar != null) {
            l lVar4 = new l(lVar.f1653a, lVar.b, lVar.c, null);
            if (lVar3 == null) {
                lVar2 = lVar4;
            } else {
                lVar3.d = lVar4;
            }
            lVar = lVar.d;
            lVar3 = lVar4;
        }
        return lVar2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i2 = 1;
        int i3 = 0;
        while (i2 < 16) {
            i3++;
            i2 <<= 1;
        }
        int i4 = 32 - i3;
        int i5 = i2 - 1;
        n[] nVarArr = new n[16];
        for (int i6 = 0; i6 < 16; i6++) {
            nVarArr[i6] = new n(0.75f);
        }
        objectOutputStream.putFields().put("segments", nVarArr);
        objectOutputStream.putFields().put("segmentShift", i4);
        objectOutputStream.putFields().put("segmentMask", i5);
        objectOutputStream.writeFields();
        l[] lVarArr = this.f1650a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a2 = pVar.a();
                if (a2 == null) {
                    break;
                }
                objectOutputStream.writeObject(a2.b);
                objectOutputStream.writeObject(a2.c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    @Override // j$.util.Map
    public void clear() {
        l[] lVarArr = this.f1650a;
        long j2 = 0;
        loop0:
        while (true) {
            int i2 = 0;
            while (lVarArr != null && i2 < lVarArr.length) {
                l n2 = n(lVarArr, i2);
                if (n2 == null) {
                    i2++;
                } else {
                    int i3 = n2.f1653a;
                    if (i3 == -1) {
                        lVarArr = f(lVarArr, n2);
                    } else {
                        synchronized (n2) {
                            if (n(lVarArr, i2) == n2) {
                                for (l lVar = i3 >= 0 ? n2 : n2 instanceof q ? ((q) n2).f : null; lVar != null; lVar = lVar.d) {
                                    j2--;
                                }
                                k(lVarArr, i2, null);
                                i2++;
                            }
                        }
                    }
                }
            }
        }
        if (j2 != 0) {
            a(j2, -1);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // j$.util.Map
    public Object compute(Object obj, BiFunction biFunction) {
        Object obj2;
        int i2;
        Object obj3;
        int i3;
        l lVar;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int l2 = l(obj.hashCode());
        l[] lVarArr = this.f1650a;
        int i4 = 0;
        Object obj4 = null;
        int i5 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i6 = (length - 1) & l2;
                    l n2 = n(lVarArr, i6);
                    int i7 = 1;
                    if (n2 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (b(lVarArr, i6, null, mVar)) {
                                try {
                                    Object apply = biFunction.apply(obj, null);
                                    if (apply != null) {
                                        lVar = new l(l2, obj, apply, null);
                                        i3 = 1;
                                    } else {
                                        i3 = i4;
                                        lVar = null;
                                    }
                                    k(lVarArr, i6, lVar);
                                    i4 = i3;
                                    obj4 = apply;
                                    i5 = 1;
                                } catch (Throwable th) {
                                    k(lVarArr, i6, null);
                                    throw th;
                                }
                            }
                        }
                        if (i5 != 0) {
                            break;
                        }
                    } else {
                        int i8 = n2.f1653a;
                        if (i8 == -1) {
                            lVarArr = f(lVarArr, n2);
                        } else {
                            synchronized (n2) {
                                if (n(lVarArr, i6) == n2) {
                                    if (i8 >= 0) {
                                        l lVar2 = null;
                                        l lVar3 = n2;
                                        i2 = 1;
                                        while (true) {
                                            if (lVar3.f1653a != l2 || ((obj3 = lVar3.b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                l lVar4 = lVar3.d;
                                                if (lVar4 == null) {
                                                    obj2 = biFunction.apply(obj, null);
                                                    if (obj2 != null) {
                                                        lVar3.d = new l(l2, obj, obj2, null);
                                                    } else {
                                                        i5 = i2;
                                                        obj4 = obj2;
                                                    }
                                                } else {
                                                    i2++;
                                                    lVar2 = lVar3;
                                                    lVar3 = lVar4;
                                                }
                                            }
                                        }
                                        Object apply2 = biFunction.apply(obj, lVar3.c);
                                        if (apply2 != null) {
                                            lVar3.c = apply2;
                                            i5 = i2;
                                            obj4 = apply2;
                                        } else {
                                            l lVar5 = lVar3.d;
                                            if (lVar2 != null) {
                                                lVar2.d = lVar5;
                                            } else {
                                                k(lVarArr, i6, lVar5);
                                            }
                                            obj2 = apply2;
                                            i7 = i2;
                                            i5 = i7;
                                            obj4 = obj2;
                                            i4 = -1;
                                        }
                                    } else if (n2 instanceof q) {
                                        q qVar = (q) n2;
                                        r rVar = qVar.e;
                                        r b2 = rVar != null ? rVar.b(l2, obj, null) : null;
                                        obj2 = biFunction.apply(obj, b2 == null ? null : b2.c);
                                        if (obj2 != null) {
                                            if (b2 != null) {
                                                b2.c = obj2;
                                            } else {
                                                qVar.f(l2, obj, obj2);
                                                i2 = 1;
                                            }
                                        } else if (b2 != null) {
                                            if (qVar.g(b2)) {
                                                k(lVarArr, i6, s(qVar.f));
                                            }
                                            i5 = i7;
                                            obj4 = obj2;
                                            i4 = -1;
                                        }
                                        obj4 = obj2;
                                        i5 = 1;
                                    }
                                    i5 = i2;
                                    obj4 = obj2;
                                    i4 = 1;
                                }
                            }
                            if (i5 != 0) {
                                if (i5 >= 8) {
                                    q(lVarArr, i6);
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = g();
        }
        if (i4 != 0) {
            a((long) i4, i5);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, C0122z.b(biFunction));
    }

    /* JADX INFO: finally extract failed */
    @Override // j$.util.Map
    public Object computeIfAbsent(Object obj, Function function) {
        r b2;
        Object obj2;
        if (obj == null || function == null) {
            throw null;
        }
        int l2 = l(obj.hashCode());
        l[] lVarArr = this.f1650a;
        Object obj3 = null;
        int i2 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i3 = (length - 1) & l2;
                    l n2 = n(lVarArr, i3);
                    boolean z = true;
                    if (n2 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (b(lVarArr, i3, null, mVar)) {
                                try {
                                    Object apply = function.apply(obj);
                                    k(lVarArr, i3, apply != null ? new l(l2, obj, apply, null) : null);
                                    obj3 = apply;
                                    i2 = 1;
                                } catch (Throwable th) {
                                    k(lVarArr, i3, null);
                                    throw th;
                                }
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i4 = n2.f1653a;
                        if (i4 == -1) {
                            lVarArr = f(lVarArr, n2);
                        } else {
                            synchronized (n2) {
                                if (n(lVarArr, i3) == n2) {
                                    if (i4 >= 0) {
                                        l lVar = n2;
                                        i2 = 1;
                                        while (true) {
                                            if (lVar.f1653a != l2 || ((obj2 = lVar.b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                                                l lVar2 = lVar.d;
                                                if (lVar2 == null) {
                                                    Object apply2 = function.apply(obj);
                                                    if (apply2 != null) {
                                                        lVar.d = new l(l2, obj, apply2, null);
                                                        obj3 = apply2;
                                                    } else {
                                                        obj3 = apply2;
                                                    }
                                                } else {
                                                    i2++;
                                                    lVar = lVar2;
                                                }
                                            }
                                        }
                                        obj3 = lVar.c;
                                    } else if (n2 instanceof q) {
                                        q qVar = (q) n2;
                                        r rVar = qVar.e;
                                        if (rVar == null || (b2 = rVar.b(l2, obj, null)) == null) {
                                            obj3 = function.apply(obj);
                                            if (obj3 != null) {
                                                qVar.f(l2, obj, obj3);
                                                i2 = 2;
                                            }
                                        } else {
                                            obj3 = b2.c;
                                        }
                                        i2 = 2;
                                    }
                                }
                                z = false;
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    q(lVarArr, i3);
                                }
                                if (!z) {
                                    return obj3;
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = g();
        }
        if (obj3 != null) {
            a(1, i2);
        }
        return obj3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, U.c(function));
    }

    @Override // j$.util.Map
    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        r b2;
        l s2;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int l2 = l(obj.hashCode());
        l[] lVarArr = this.f1650a;
        int i2 = 0;
        Object obj3 = null;
        int i3 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & l2;
                    l n2 = n(lVarArr, i4);
                    if (n2 == null) {
                        break;
                    }
                    int i5 = n2.f1653a;
                    if (i5 == -1) {
                        lVarArr = f(lVarArr, n2);
                    } else {
                        synchronized (n2) {
                            if (n(lVarArr, i4) == n2) {
                                if (i5 >= 0) {
                                    i3 = 1;
                                    l lVar = null;
                                    l lVar2 = n2;
                                    while (true) {
                                        if (lVar2.f1653a != l2 || ((obj2 = lVar2.b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                                            l lVar3 = lVar2.d;
                                            if (lVar3 == null) {
                                                break;
                                            }
                                            i3++;
                                            lVar = lVar2;
                                            lVar2 = lVar3;
                                        }
                                    }
                                    obj3 = biFunction.apply(obj, lVar2.c);
                                    if (obj3 != null) {
                                        lVar2.c = obj3;
                                    } else {
                                        s2 = lVar2.d;
                                        if (lVar != null) {
                                            lVar.d = s2;
                                            i2 = -1;
                                        }
                                    }
                                } else if (n2 instanceof q) {
                                    i3 = 2;
                                    q qVar = (q) n2;
                                    r rVar = qVar.e;
                                    if (rVar != null && (b2 = rVar.b(l2, obj, null)) != null) {
                                        obj3 = biFunction.apply(obj, b2.c);
                                        if (obj3 != null) {
                                            b2.c = obj3;
                                        } else {
                                            if (qVar.g(b2)) {
                                                s2 = s(qVar.f);
                                            }
                                            i2 = -1;
                                        }
                                    }
                                }
                                k(lVarArr, i4, s2);
                                i2 = -1;
                            }
                        }
                        if (i3 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArr = g();
        }
        if (i2 != 0) {
            a((long) i2, i3);
        }
        return obj3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, C0122z.b(biFunction));
    }

    @Override // j$.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // j$.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f1650a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a2 = pVar.a();
                if (a2 == null) {
                    break;
                }
                Object obj2 = a2.c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set entrySet() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f = eVar2;
        return eVar2;
    }

    @Override // j$.util.Map
    public boolean equals(Object obj) {
        V value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        l[] lVarArr = this.f1650a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l a2 = pVar.a();
            if (a2 != null) {
                Object obj3 = a2.c;
                Object obj4 = map.get(a2.b);
                if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                    return false;
                }
            } else {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final l[] f(l[] lVarArr, l lVar) {
        l[] lVarArr2;
        int i2;
        if (lVarArr == null || !(lVar instanceof g) || (lVarArr2 = ((g) lVar).e) == null) {
            return this.f1650a;
        }
        int j2 = j(lVarArr.length);
        while (true) {
            if (lVarArr2 == this.b && this.f1650a == lVarArr && (i2 = this.sizeCtl) < 0 && (i2 >>> 16) == j2 && i2 != j2 + 1 && i2 != 65535 + j2 && this.transferIndex > 0) {
                if (h.compareAndSwapInt(this, i, i2, i2 + 1)) {
                    p(lVarArr, lVarArr2);
                    break;
                }
            } else {
                break;
            }
        }
        return lVarArr2;
    }

    @Override // j$.util.concurrent.b, j$.util.Map
    public void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f1650a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a2 = pVar.a();
                if (a2 != null) {
                    biConsumer.accept(a2.b, a2.c);
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(C0118x.b(biConsumer));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004d, code lost:
        return r1.c;
     */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = l(r0)
            j$.util.concurrent.ConcurrentHashMap$l[] r1 = r4.f1650a
            r2 = 0
            if (r1 == 0) goto L_0x004e
            int r3 = r1.length
            if (r3 <= 0) goto L_0x004e
            int r3 = r3 + -1
            r3 = r3 & r0
            j$.util.concurrent.ConcurrentHashMap$l r1 = n(r1, r3)
            if (r1 == 0) goto L_0x004e
            int r3 = r1.f1653a
            if (r3 != r0) goto L_0x002c
            java.lang.Object r3 = r1.b
            if (r3 == r5) goto L_0x0029
            if (r3 == 0) goto L_0x0037
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0029:
            java.lang.Object r5 = r1.c
            return r5
        L_0x002c:
            if (r3 >= 0) goto L_0x0037
            j$.util.concurrent.ConcurrentHashMap$l r5 = r1.a(r0, r5)
            if (r5 == 0) goto L_0x0036
            java.lang.Object r2 = r5.c
        L_0x0036:
            return r2
        L_0x0037:
            j$.util.concurrent.ConcurrentHashMap$l r1 = r1.d
            if (r1 == 0) goto L_0x004e
            int r3 = r1.f1653a
            if (r3 != r0) goto L_0x0037
            java.lang.Object r3 = r1.b
            if (r3 == r5) goto L_0x004b
            if (r3 == 0) goto L_0x0037
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
        L_0x004b:
            java.lang.Object r5 = r1.c
            return r5
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r11 == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.h(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    @Override // j$.util.Map
    public int hashCode() {
        l[] lVarArr = this.f1650a;
        int i2 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a2 = pVar.a();
                if (a2 == null) {
                    break;
                }
                i2 += a2.c.hashCode() ^ a2.b.hashCode();
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final Object i(Object obj, Object obj2, Object obj3) {
        int length;
        int i2;
        l n2;
        boolean z;
        Object obj4;
        r b2;
        l s2;
        Object obj5;
        int l2 = l(obj.hashCode());
        l[] lVarArr = this.f1650a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (n2 = n(lVarArr, (i2 = (length - 1) & l2))) == null) {
                break;
            }
            int i3 = n2.f1653a;
            if (i3 == -1) {
                lVarArr = f(lVarArr, n2);
            } else {
                boolean z2 = false;
                synchronized (n2) {
                    z = true;
                    if (n(lVarArr, i2) == n2) {
                        if (i3 >= 0) {
                            l lVar = null;
                            l lVar2 = n2;
                            while (true) {
                                if (lVar2.f1653a != l2 || ((obj5 = lVar2.b) != obj && (obj5 == null || !obj.equals(obj5)))) {
                                    l lVar3 = lVar2.d;
                                    if (lVar3 == null) {
                                        break;
                                    }
                                    lVar = lVar2;
                                    lVar2 = lVar3;
                                }
                            }
                            obj4 = lVar2.c;
                            if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                if (obj2 != null) {
                                    lVar2.c = obj2;
                                } else if (lVar != null) {
                                    lVar.d = lVar2.d;
                                } else {
                                    s2 = lVar2.d;
                                }
                            }
                            z2 = true;
                        } else if (n2 instanceof q) {
                            q qVar = (q) n2;
                            r rVar = qVar.e;
                            if (rVar != null && (b2 = rVar.b(l2, obj, null)) != null) {
                                obj4 = b2.c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        b2.c = obj2;
                                    } else if (qVar.g(b2)) {
                                        s2 = s(qVar.f);
                                    }
                                }
                            }
                            z2 = true;
                        }
                        k(lVarArr, i2, s2);
                    }
                    obj4 = null;
                    z = z2;
                }
                if (z) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // j$.util.Map
    public boolean isEmpty() {
        return m() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set keySet() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this, null);
        this.d = iVar2;
        return iVar2;
    }

    /* access modifiers changed from: package-private */
    public final long m() {
        c[] cVarArr = this.c;
        long j2 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.value;
                }
            }
        }
        return j2;
    }

    @Override // j$.util.Map
    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i2;
        Object obj3;
        Object obj4 = obj2;
        if (obj == null || obj4 == null || biFunction == null) {
            throw null;
        }
        int l2 = l(obj.hashCode());
        l[] lVarArr = this.f1650a;
        int i3 = 0;
        Object obj5 = null;
        int i4 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i5 = (length - 1) & l2;
                    l n2 = n(lVarArr, i5);
                    i2 = 1;
                    if (n2 != null) {
                        int i6 = n2.f1653a;
                        if (i6 == -1) {
                            lVarArr = f(lVarArr, n2);
                        } else {
                            synchronized (n2) {
                                if (n(lVarArr, i5) == n2) {
                                    if (i6 >= 0) {
                                        l lVar = null;
                                        l lVar2 = n2;
                                        int i7 = 1;
                                        while (true) {
                                            if (lVar2.f1653a != l2 || ((obj3 = lVar2.b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                l lVar3 = lVar2.d;
                                                if (lVar3 == null) {
                                                    lVar2.d = new l(l2, obj, obj4, null);
                                                    i3 = i7;
                                                    i4 = 1;
                                                    obj5 = obj4;
                                                    break;
                                                }
                                                i7++;
                                                lVar = lVar2;
                                                lVar2 = lVar3;
                                            }
                                        }
                                        Object apply = biFunction.apply(lVar2.c, obj4);
                                        if (apply != null) {
                                            lVar2.c = apply;
                                            i3 = i7;
                                            obj5 = apply;
                                        } else {
                                            l lVar4 = lVar2.d;
                                            if (lVar != null) {
                                                lVar.d = lVar4;
                                            } else {
                                                k(lVarArr, i5, lVar4);
                                            }
                                            i3 = i7;
                                            obj5 = apply;
                                        }
                                    } else if (n2 instanceof q) {
                                        i3 = 2;
                                        q qVar = (q) n2;
                                        r rVar = qVar.e;
                                        r b2 = rVar == null ? null : rVar.b(l2, obj, null);
                                        Object apply2 = b2 == null ? obj4 : biFunction.apply(b2.c, obj4);
                                        if (apply2 != null) {
                                            if (b2 != null) {
                                                b2.c = apply2;
                                            } else {
                                                qVar.f(l2, obj, apply2);
                                                obj5 = apply2;
                                                i4 = 1;
                                            }
                                        } else if (b2 != null) {
                                            if (qVar.g(b2)) {
                                                k(lVarArr, i5, s(qVar.f));
                                            }
                                            obj5 = apply2;
                                        }
                                        obj5 = apply2;
                                    }
                                    i4 = -1;
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    q(lVarArr, i5);
                                }
                                i2 = i4;
                                obj4 = obj5;
                            }
                        }
                    } else if (b(lVarArr, i5, null, new l(l2, obj, obj4, null))) {
                        break;
                    }
                }
            }
            lVarArr = g();
        }
        if (i2 != 0) {
            a((long) i2, i3);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, C0122z.b(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object put(Object obj, Object obj2) {
        return h(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void putAll(java.util.Map map) {
        r(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            h(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        return h(obj, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object remove(Object obj) {
        return i(obj, null, null);
    }

    @Override // j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || i(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return i(obj, obj2, null);
        }
        throw null;
    }

    @Override // java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null) {
            throw null;
        } else if (obj2 == null) {
            throw null;
        } else if (obj3 != null) {
            return i(obj, obj3, obj2) != null;
        } else {
            throw null;
        }
    }

    @Override // j$.util.Map
    public void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f1650a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a2 = pVar.a();
                if (a2 != null) {
                    Object obj = a2.c;
                    Object obj2 = a2.b;
                    do {
                        Object apply = biFunction.apply(obj2, obj);
                        apply.getClass();
                        if (i(obj2, apply, obj) != null) {
                            break;
                        }
                        obj = get(obj2);
                    } while (obj != null);
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(C0122z.b(biFunction));
    }

    @Override // j$.util.Map
    public int size() {
        long m2 = m();
        if (m2 < 0) {
            return 0;
        }
        if (m2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) m2;
    }

    public String toString() {
        l[] lVarArr = this.f1650a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        l a2 = pVar.a();
        if (a2 != null) {
            while (true) {
                Object obj = a2.b;
                Object obj2 = a2.c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a2 = pVar.a();
                if (a2 == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Collection values() {
        u uVar = this.e;
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this);
        this.e = uVar2;
        return uVar2;
    }

    /* access modifiers changed from: package-private */
    public static abstract class b<K, V, E> implements Collection<E>, Serializable, j$.util.Collection {

        /* renamed from: a  reason: collision with root package name */
        final ConcurrentHashMap f1651a;

        b(ConcurrentHashMap concurrentHashMap) {
            this.f1651a = concurrentHashMap;
        }

        @Override // j$.util.Collection
        public final void clear() {
            this.f1651a.clear();
        }

        @Override // j$.util.Collection
        public abstract boolean contains(Object obj);

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000c  */
        @Override // j$.util.Collection, java.util.Collection
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean containsAll(java.util.Collection r2) {
            /*
                r1 = this;
                if (r2 == r1) goto L_0x001a
                java.util.Iterator r2 = r2.iterator()
            L_0x0006:
                boolean r0 = r2.hasNext()
                if (r0 == 0) goto L_0x001a
                java.lang.Object r0 = r2.next()
                if (r0 == 0) goto L_0x0018
                boolean r0 = r1.contains(r0)
                if (r0 != 0) goto L_0x0006
            L_0x0018:
                r2 = 0
                return r2
            L_0x001a:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.b.containsAll(java.util.Collection):boolean");
        }

        @Override // j$.util.Collection
        public final boolean isEmpty() {
            return this.f1651a.isEmpty();
        }

        @Override // j$.util.Collection, java.util.Collection, j$.lang.Iterable, java.lang.Iterable
        public abstract java.util.Iterator iterator();

        @Override // j$.util.Collection, java.util.Collection
        public final boolean removeAll(Collection collection) {
            collection.getClass();
            java.util.Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection
        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection.CC.$default$removeIf(this, E0.c(predicate));
        }

        @Override // j$.util.Collection, java.util.Collection
        public final boolean retainAll(java.util.Collection collection) {
            collection.getClass();
            java.util.Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.Collection
        public final int size() {
            return this.f1651a.size();
        }

        @Override // j$.util.Collection
        public final Object[] toArray() {
            long m = this.f1651a.m();
            if (m < 0) {
                m = 0;
            }
            if (m <= 2147483639) {
                int i = (int) m;
                Object[] objArr = new Object[i];
                int i2 = 0;
                java.util.Iterator it = iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (i2 == i) {
                        int i3 = 2147483639;
                        if (i < 2147483639) {
                            if (i < 1073741819) {
                                i3 = (i >>> 1) + 1 + i;
                            }
                            objArr = Arrays.copyOf(objArr, i3);
                            i = i3;
                        } else {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                    }
                    objArr[i2] = next;
                    i2++;
                }
                return i2 == i ? objArr : Arrays.copyOf(objArr, i2);
            }
            throw new OutOfMemoryError("Required array size too large");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            java.util.Iterator it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }

        @Override // j$.util.Collection
        public Object[] toArray(x xVar) {
            return toArray((Object[]) xVar.apply(0));
        }

        @Override // j$.util.Collection, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            long m = this.f1651a.m();
            if (m < 0) {
                m = 0;
            }
            if (m <= 2147483639) {
                int i = (int) m;
                Object[] objArr2 = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                int length = objArr2.length;
                int i2 = 0;
                java.util.Iterator it = iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (i2 == length) {
                        int i3 = 2147483639;
                        if (length < 2147483639) {
                            if (length < 1073741819) {
                                i3 = (length >>> 1) + 1 + length;
                            }
                            objArr2 = Arrays.copyOf(objArr2, i3);
                            length = i3;
                        } else {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                    }
                    objArr2[i2] = next;
                    i2++;
                }
                if (objArr != objArr2 || i2 >= length) {
                    return i2 == length ? objArr2 : Arrays.copyOf(objArr2, i2);
                }
                objArr2[i2] = null;
                return objArr2;
            }
            throw new OutOfMemoryError("Required array size too large");
        }
    }
}
