package defpackage;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: wl2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class wl2<K, V> extends LinkedHashMap<K, V> implements Map {
    public static final wl2 g;
    public boolean f = true;

    static {
        wl2 wl2 = new wl2();
        g = wl2;
        wl2.f = false;
    }

    public wl2() {
    }

    public static <K, V> wl2<K, V> a() {
        return g;
    }

    public static int c(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            Charset charset = ka3.f2038a;
            int length = bArr.length;
            int i = length;
            for (byte b : bArr) {
                i = (i * 31) + b;
            }
            if (i == 0) {
                return 1;
            }
            return i;
        } else if (!(obj instanceof ga3)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final wl2<K, V> b() {
        return isEmpty() ? new wl2<>() : new wl2<>(this);
    }

    @Override // j$.util.Map
    public final void clear() {
        d();
        super.clear();
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

    public final void d() {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, j$.util.Map, java.util.HashMap
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // j$.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z = value.equals(obj2);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.LinkedHashMap, java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // j$.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += c(entry.getValue()) ^ c(entry.getKey());
        }
        return i;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map, java.util.HashMap
    public final V put(K k, V v) {
        d();
        Charset charset = ka3.f2038a;
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map, java.util.HashMap
    public final void putAll(java.util.Map<? extends K, ? extends V> map) {
        d();
        for (Object obj : map.keySet()) {
            Charset charset = ka3.f2038a;
            Objects.requireNonNull(obj);
            Objects.requireNonNull(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map, java.util.HashMap
    public final V remove(Object obj) {
        d();
        return (V) super.remove(obj);
    }

    @Override // j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public wl2(java.util.Map<K, V> map) {
        super(map);
    }
}
