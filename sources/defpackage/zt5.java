package defpackage;

import com.urbanairship.json.JsonValue;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import org.json.JSONException;
import org.json.JSONStringer;

/* renamed from: zt5  reason: default package */
/* compiled from: JsonMap */
public class zt5 implements Iterable<Map.Entry<String, JsonValue>>, cu5, Iterable {
    public static final zt5 g = new zt5(null);
    public final Map<String, JsonValue> f;

    /* renamed from: zt5$b */
    /* compiled from: JsonMap */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, JsonValue> f4211a = new HashMap();

        public b(a aVar) {
        }

        public zt5 a() {
            return new zt5(this.f4211a);
        }

        public b b(String str, double d) {
            e(str, JsonValue.q(d));
            return this;
        }

        public b c(String str, int i) {
            e(str, JsonValue.x(Integer.valueOf(i)));
            return this;
        }

        public b d(String str, long j) {
            e(str, JsonValue.x(Long.valueOf(j)));
            return this;
        }

        public b e(String str, cu5 cu5) {
            if (cu5 == null || cu5.b().l()) {
                this.f4211a.remove(str);
            } else {
                this.f4211a.put(str, cu5.b());
            }
            return this;
        }

        public b f(String str, String str2) {
            if (str2 != null) {
                e(str, JsonValue.x(str2));
            } else {
                this.f4211a.remove(str);
            }
            return this;
        }

        public b g(String str, boolean z) {
            e(str, JsonValue.x(Boolean.valueOf(z)));
            return this;
        }

        public b h(zt5 zt5) {
            for (Map.Entry<String, JsonValue> entry : zt5.e()) {
                e(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public b i(String str, Object obj) {
            e(str, JsonValue.x(obj));
            return this;
        }
    }

    public zt5(Map<String, JsonValue> map) {
        this.f = map == null ? new HashMap() : new HashMap(map);
    }

    public static b s() {
        return new b(null);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(this);
    }

    public boolean d(String str) {
        return this.f.containsKey(str);
    }

    public Set<Map.Entry<String, JsonValue>> e() {
        return this.f.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zt5) {
            return this.f.equals(((zt5) obj).f);
        }
        if (obj instanceof JsonValue) {
            return this.f.equals(((JsonValue) obj).n().f);
        }
        return false;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<Map.Entry<String, JsonValue>> iterator() {
        return e().iterator();
    }

    public JsonValue k(String str) {
        return this.f.get(str);
    }

    public Map<String, JsonValue> n() {
        return new HashMap(this.f);
    }

    public int size() {
        return this.f.size();
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Map.Entry<String, JsonValue>> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            v(jSONStringer);
            return jSONStringer.toString();
        } catch (StringIndexOutOfBoundsException | JSONException e) {
            yj5.e(e, "JsonMap - Failed to create JSON String.", new Object[0]);
            return "";
        }
    }

    public JsonValue u(String str) {
        JsonValue jsonValue = this.f.get(str);
        if (jsonValue != null) {
            return jsonValue;
        }
        return JsonValue.g;
    }

    public void v(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.object();
        for (Map.Entry<String, JsonValue> entry : e()) {
            jSONStringer.key(entry.getKey());
            entry.getValue().y(jSONStringer);
        }
        jSONStringer.endObject();
    }
}
