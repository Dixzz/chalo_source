package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: c66  reason: default package */
/* compiled from: Maps.kt */
public final class c66 implements Map, Serializable, c96, j$.util.Map {
    public static final c66 f = new c66();

    @Override // j$.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @Override // j$.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override // j$.util.Map
    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            n86.e((Void) obj, FirebaseAnalytics.Param.VALUE);
        }
        return false;
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return d66.f;
    }

    @Override // j$.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof java.util.Map) && ((java.util.Map) obj).isEmpty();
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Object get(Object obj) {
        return null;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // j$.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // j$.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return d66.f;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
    public final /* bridge */ int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ Collection values() {
        return b66.f;
    }
}
