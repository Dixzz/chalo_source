package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: wy5  reason: default package */
/* compiled from: JsonDataStoreQueue */
public class wy5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f3862a;
    public final String b;
    public final h2<JsonValue, T> c;
    public final h2<T, ? extends cu5> d;

    public wy5(hk5 hk5, String str, h2<T, ? extends cu5> h2Var, h2<JsonValue, T> h2Var2) {
        this.f3862a = hk5;
        this.b = str;
        this.d = h2Var;
        this.c = h2Var2;
    }

    public void a(h2<List<T>, List<T>> h2Var) {
        synchronized (this.b) {
            List<T> apply = h2Var.apply(b());
            if (apply.isEmpty()) {
                this.f3862a.l(this.b);
            } else {
                this.f3862a.j(this.b, JsonValue.x(apply));
            }
        }
    }

    public List<T> b() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList();
            Iterator<JsonValue> it = this.f3862a.d(this.b).m().iterator();
            while (it.hasNext()) {
                arrayList.add(this.c.apply(it.next()));
            }
        }
        return arrayList;
    }

    public T c() {
        ArrayList arrayList = (ArrayList) this.f3862a.d(this.b).m().e();
        if (arrayList.isEmpty()) {
            return null;
        }
        return this.c.apply((JsonValue) arrayList.get(0));
    }

    public T d() {
        synchronized (this.b) {
            List<JsonValue> e = this.f3862a.d(this.b).m().e();
            ArrayList arrayList = (ArrayList) e;
            if (arrayList.isEmpty()) {
                return null;
            }
            JsonValue jsonValue = (JsonValue) arrayList.remove(0);
            if (arrayList.isEmpty()) {
                this.f3862a.l(this.b);
            } else {
                this.f3862a.j(this.b, JsonValue.x(e));
            }
            return this.c.apply(jsonValue);
        }
    }

    public void e() {
        synchronized (this.b) {
            this.f3862a.l(this.b);
        }
    }
}
