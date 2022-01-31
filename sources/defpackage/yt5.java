package defpackage;

import com.urbanairship.json.JsonValue;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.json.JSONException;
import org.json.JSONStringer;

/* renamed from: yt5  reason: default package */
/* compiled from: JsonList */
public class yt5 implements Iterable<JsonValue>, cu5, Iterable {
    public static final yt5 g = new yt5(null);
    public final List<JsonValue> f;

    public yt5(List<JsonValue> list) {
        this.f = list == null ? new ArrayList() : new ArrayList(list);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(this);
    }

    public JsonValue d(int i) {
        return this.f.get(i);
    }

    public List<JsonValue> e() {
        return new ArrayList(this.f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof yt5) {
            return this.f.equals(((yt5) obj).f);
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

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<JsonValue> iterator() {
        return this.f.iterator();
    }

    public void k(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.array();
        Iterator<JsonValue> it = iterator();
        while (it.hasNext()) {
            it.next().y(jSONStringer);
        }
        jSONStringer.endArray();
    }

    public int size() {
        return this.f.size();
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<JsonValue> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            k(jSONStringer);
            return jSONStringer.toString();
        } catch (StringIndexOutOfBoundsException | JSONException e) {
            yj5.e(e, "JsonList - Failed to create JSON String.", new Object[0]);
            return "";
        }
    }
}
