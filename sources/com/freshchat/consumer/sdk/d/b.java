package com.freshchat.consumer.sdk.d;

import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b<T> extends a<T> {
    private final String nh = "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL";
    private final HashMap<String, List<b<T>.a>> ni = new HashMap<>();
    private final HashMap<Class, b<T>.a> nj = new HashMap<>();

    public class a {
        private final Class clz;
        private final String fieldName;
        private final String label;
        private final String nk;
        private TypeAdapter<?> nl;

        private a(String str, String str2, String str3, Class cls) {
            this.nk = str;
            this.fieldName = str3;
            this.label = str2;
            this.clz = cls;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setDelegate(TypeAdapter<?> typeAdapter) {
            this.nl = typeAdapter;
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.d.b$b  reason: collision with other inner class name */
    public class C0010b {
        private final String fieldName;
        private final String nk;
        private final Map<String, Class> nn = new HashMap();

        public C0010b(String str, String str2) {
            this.nk = str;
            this.fieldName = str2;
        }

        public b<T>.C0010b a(String str, Class cls) {
            if (str == null || cls == null) {
                throw new IllegalArgumentException("label or clz cannot be null while adding secondaryType");
            }
            this.nn.put(str, cls);
            return this;
        }

        public void gY() {
            if (!k.c(this.nn)) {
                List list = (List) b.this.ni.get(this.nk);
                if (list == null) {
                    list = new ArrayList();
                }
                for (Map.Entry<String, Class> entry : this.nn.entrySet()) {
                    Class value = entry.getValue();
                    a aVar = new a(this.nk, entry.getKey(), this.fieldName, value);
                    list.add(aVar);
                    b.this.nj.put(value, aVar);
                }
                b.this.ni.put(this.nk, list);
                return;
            }
            throw new IllegalArgumentException("secondaryTypes list cannot be empty while registering");
        }
    }

    private b(Class cls, String str) {
        super(cls, str);
    }

    public static <T> b<T> a(Class<T> cls, String str) {
        return new b<>(cls, str);
    }

    private boolean a(String str, JsonElement jsonElement) {
        if (as.isEmpty(str)) {
            return false;
        }
        if (this.eu.containsKey(str)) {
            return true;
        }
        List<b<T>.a> list = this.ni.get(str);
        if (k.isEmpty(list)) {
            return false;
        }
        String str2 = null;
        for (b<T>.a aVar : list) {
            if (as.isEmpty(str2)) {
                str2 = super.a(jsonElement, ((a) aVar).clz, ((a) aVar).fieldName);
            }
            if (as.isEmpty(str2)) {
                return false;
            }
            if (((a) aVar).label.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.freshchat.consumer.sdk.d.a
    public <R> JsonObject a(String str, TypeAdapter<R> typeAdapter, R r) {
        JsonObject a2 = super.a(str, typeAdapter, r);
        if (as.p(str, "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL")) {
            return a2;
        }
        try {
            return (JsonObject) new JsonParser().parse(a2.getAsJsonPrimitive("rawJsonOfUnsupportedType").getAsString());
        } catch (Exception e) {
            q.a(e);
            return a2;
        }
    }

    @Override // com.freshchat.consumer.sdk.d.a
    public TypeAdapter<?> a(Class<?> cls, Map<Class<?>, TypeAdapter<?>> map) {
        b<T>.a aVar = this.nj.get(cls);
        return aVar != null ? ((a) aVar).nl : super.a(cls, map);
    }

    @Override // com.freshchat.consumer.sdk.d.a
    public TypeAdapter<?> a(String str, Map<String, TypeAdapter<?>> map, JsonElement jsonElement, Class<?> cls) {
        List<b<T>.a> list;
        try {
            if (this.ni.containsKey(str) && (list = this.ni.get(str)) != null) {
                for (b<T>.a aVar : list) {
                    if (super.a(jsonElement, cls, ((a) aVar).fieldName).equals(((a) aVar).label)) {
                        return ((a) aVar).nl;
                    }
                }
            }
            TypeAdapter<?> a2 = super.a(str, map, jsonElement, cls);
            if (a2 != null) {
                return a2;
            }
        } catch (Exception e) {
            ai.e("FRESHCHAT", e.toString());
        }
        return super.a("RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL", map, jsonElement, cls);
    }

    @Override // com.freshchat.consumer.sdk.d.a
    public String a(JsonElement jsonElement, Class<?> cls, String str) {
        String a2 = super.a(jsonElement, cls, str);
        if (a(a2, jsonElement)) {
            return a2;
        }
        ai.w("FRESHCHAT_WARNING", "cannot deserialize " + cls + " subtype named " + a2 + "; did you forget to register a subtype?");
        jsonElement.getAsJsonObject().addProperty("rawJsonOfUnsupportedType", jsonElement.getAsJsonObject().toString());
        return "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL";
    }

    public a<T> b(Class<? extends T> cls) {
        return b(cls, "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL");
    }

    @Override // com.freshchat.consumer.sdk.d.a
    public String c(Class<?> cls) {
        b<T>.a aVar = this.nj.get(cls);
        return aVar != null ? ((a) aVar).nk : super.c(cls);
    }

    @Override // com.freshchat.consumer.sdk.d.a, com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        for (Map.Entry<String, List<b<T>.a>> entry : this.ni.entrySet()) {
            for (b<T>.a aVar : entry.getValue()) {
                aVar.setDelegate(gson.getDelegateAdapter(this, TypeToken.get(((a) aVar).clz)));
            }
        }
        return super.create(gson, typeToken);
    }

    public b<T>.C0010b w(String str, String str2) {
        return new C0010b(str, str2);
    }
}
