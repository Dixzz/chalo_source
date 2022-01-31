package defpackage;

import defpackage.t2;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: n2  reason: default package */
/* compiled from: ArrayMap */
public class n2<K, V> extends u2<K, V> implements Map<K, V>, j$.util.Map {
    public t2<K, V> m;

    /* renamed from: n2$a */
    /* compiled from: ArrayMap */
    public class a extends t2<K, V> {
        public a() {
        }

        @Override // defpackage.t2
        public void a() {
            n2.this.clear();
        }

        @Override // defpackage.t2
        public Object b(int i, int i2) {
            return n2.this.g[(i << 1) + i2];
        }

        @Override // defpackage.t2
        public Map<K, V> c() {
            return n2.this;
        }

        @Override // defpackage.t2
        public int d() {
            return n2.this.h;
        }

        @Override // defpackage.t2
        public int e(Object obj) {
            return n2.this.e(obj);
        }

        @Override // defpackage.t2
        public int f(Object obj) {
            return n2.this.g(obj);
        }

        @Override // defpackage.t2
        public void g(K k, V v) {
            n2.this.put(k, v);
        }

        @Override // defpackage.t2
        public void h(int i) {
            n2.this.j(i);
        }

        @Override // defpackage.t2
        public V i(int i, V v) {
            int i2 = (i << 1) + 1;
            Object[] objArr = n2.this.g;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
    }

    public n2() {
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

    @Override // java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        t2<K, V> m2 = m();
        if (m2.f3297a == null) {
            m2.f3297a = new t2.b();
        }
        return m2.f3297a;
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map, j$.util.Map
    public Set<K> keySet() {
        t2<K, V> m2 = m();
        if (m2.b == null) {
            m2.b = new t2.c();
        }
        return m2.b;
    }

    public final t2<K, V> m() {
        if (this.m == null) {
            this.m = new a();
        }
        return this.m;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: n2<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        b(map.size() + this.h);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public Collection<V> values() {
        t2<K, V> m2 = m();
        if (m2.c == null) {
            m2.c = new t2.e();
        }
        return m2.c;
    }

    public n2(int i) {
        super(i);
    }

    public n2(u2 u2Var) {
        if (u2Var != null) {
            i(u2Var);
        }
    }
}
