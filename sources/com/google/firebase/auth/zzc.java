package com.google.firebase.auth;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.HashMap;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzc extends HashMap<String, Integer> implements Map {
    public zzc() {
        put("recoverEmail", 2);
        put("resetPassword", 0);
        put("signIn", 4);
        put("verifyEmail", 1);
        put("verifyBeforeChangeEmail", 5);
        put("revertSecondFactorAddition", 6);
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
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Integer getOrDefault(Object obj, Integer num) {
        return Map.CC.$default$getOrDefault(this, obj, num);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Integer putIfAbsent(String str, Integer num) {
        return Map.CC.$default$putIfAbsent(this, str, num);
    }

    @Override // j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Integer replace(String str, Integer num) {
        return Map.CC.$default$replace(this, str, num);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ boolean replace(String str, Integer num, Integer num2) {
        return Map.CC.$default$replace(this, str, num, num2);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }
}
