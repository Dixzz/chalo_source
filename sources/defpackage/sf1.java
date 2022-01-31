package defpackage;

import android.content.SharedPreferences;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: sf1  reason: default package */
/* compiled from: PersistedMap */
public class sf1 implements Map<String, String>, j$.util.Map {
    public final SharedPreferences f;
    public final String g;
    public JSONObject h;

    /* renamed from: sf1$a */
    /* compiled from: PersistedMap */
    public class a implements Map.Entry<String, String>, Map.Entry {
        public String f;
        public String g;

        public a(sf1 sf1, String str, String str2) {
            this.f = str;
            this.g = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public String getKey() {
            return this.f;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public String getValue() {
            return this.g;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public String setValue(String str) {
            String str2 = str;
            this.g = str2;
            return str2;
        }
    }

    public sf1(SharedPreferences sharedPreferences, String str) {
        this.f = sharedPreferences;
        this.g = str;
        try {
            this.h = new JSONObject(sharedPreferences.getString(str, ""));
        } catch (Exception unused) {
            this.h = new JSONObject();
        }
    }

    public String a(Object obj) {
        return this.h.optString((String) obj, null);
    }

    /* renamed from: b */
    public String put(String str, String str2) {
        String optString = this.h.optString(str, null);
        try {
            this.h.put(str, str2);
            SharedPreferences.Editor edit = this.f.edit();
            edit.putString(this.g, this.h.toString());
            edit.apply();
            return optString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public String remove(Object obj) {
        String str = (String) this.h.remove((String) obj);
        try {
            SharedPreferences.Editor edit = this.f.edit();
            edit.putString(this.g, this.h.toString());
            edit.apply();
            return str;
        } catch (RuntimeException unused) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // j$.util.Map
    public void clear() {
        this.h = new JSONObject();
        SharedPreferences.Editor edit = this.f.edit();
        edit.clear();
        edit.commit();
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
        return this.h.has((String) obj);
    }

    @Override // j$.util.Map
    public boolean containsValue(Object obj) {
        return ((HashSet) values()).contains(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public Set<Map.Entry<String, String>> entrySet() {
        HashSet hashSet = new HashSet();
        Iterator it = ((HashSet) keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            hashSet.add(new a(this, str, a(str)));
        }
        return hashSet;
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Map, j$.util.Map
    public String get(Object obj) {
        return this.h.optString((String) obj, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ String getOrDefault(Object obj, String str) {
        return Map.CC.$default$getOrDefault(this, obj, str);
    }

    @Override // j$.util.Map
    public boolean isEmpty() {
        return this.h.length() == 0;
    }

    @Override // java.util.Map, j$.util.Map
    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = this.h.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends String, ? extends String> map) {
        for (String str : map.keySet()) {
            put(str, (String) map.get(str));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ String putIfAbsent(String str, String str2) {
        return Map.CC.$default$putIfAbsent(this, str, str2);
    }

    @Override // j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ String replace(String str, String str2) {
        return Map.CC.$default$replace(this, str, str2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(String str, String str2, String str3) {
        return Map.CC.$default$replace(this, str, str2, str3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    @Override // j$.util.Map
    public int size() {
        return this.h.length();
    }

    @Override // java.util.Map, j$.util.Map
    public Collection<String> values() {
        HashSet hashSet = new HashSet();
        Iterator it = ((HashSet) entrySet()).iterator();
        while (it.hasNext()) {
            hashSet.add((String) ((Map.Entry) it.next()).getValue());
        }
        return hashSet;
    }
}
