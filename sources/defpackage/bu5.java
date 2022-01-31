package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: bu5  reason: default package */
/* compiled from: JsonPredicate */
public class bu5 implements cu5, dk5<cu5> {
    public final List<dk5<cu5>> f;
    public final String g;

    /* renamed from: bu5$b */
    /* compiled from: JsonPredicate */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f477a = "or";
        public final List<dk5<cu5>> b = new ArrayList();

        public bu5 a() {
            if (this.f477a.equals("not") && this.b.size() > 1) {
                throw new IllegalArgumentException("`NOT` predicate type only supports a single matcher or predicate.");
            } else if (!this.b.isEmpty()) {
                return new bu5(this, null);
            } else {
                throw new IllegalArgumentException("Predicate must contain at least 1 matcher or child predicate.");
            }
        }
    }

    public bu5(b bVar, a aVar) {
        this.f = bVar.b;
        this.g = bVar.f477a;
    }

    public static String c(zt5 zt5) {
        if (zt5.f.containsKey("and")) {
            return "and";
        }
        if (zt5.f.containsKey("or")) {
            return "or";
        }
        if (zt5.f.containsKey("not")) {
            return "not";
        }
        return null;
    }

    public static bu5 d(JsonValue jsonValue) throws xt5 {
        if (jsonValue == null || !(jsonValue.f instanceof zt5) || jsonValue.n().isEmpty()) {
            throw new xt5(hj1.R("Unable to parse empty JsonValue: ", jsonValue));
        }
        zt5 n = jsonValue.n();
        b bVar = new b();
        String c = c(n);
        if (c != null) {
            bVar.f477a = c;
            Iterator<JsonValue> it = n.u(c).m().iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.f instanceof zt5) {
                    if (c(next.n()) != null) {
                        bVar.b.add(d(next));
                    } else {
                        bVar.b.add(au5.a(next));
                    }
                }
            }
        } else {
            bVar.b.add(au5.a(jsonValue));
        }
        try {
            return bVar.a();
        } catch (IllegalArgumentException e) {
            throw new xt5("Unable to parse JsonPredicate.", e);
        }
    }

    /* renamed from: a */
    public boolean apply(cu5 cu5) {
        if (this.f.size() == 0) {
            return true;
        }
        String str = this.g;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3555) {
            if (hashCode != 96727) {
                if (hashCode == 109267 && str.equals("not")) {
                    c = 0;
                }
            } else if (str.equals("and")) {
                c = 1;
            }
        } else if (str.equals("or")) {
            c = 2;
        }
        if (c == 0) {
            return !this.f.get(0).apply(cu5);
        }
        if (c != 1) {
            for (dk5<cu5> dk5 : this.f) {
                if (dk5.apply(cu5)) {
                    return true;
                }
            }
            return false;
        }
        for (dk5<cu5> dk52 : this.f) {
            if (!dk52.apply(cu5)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(zt5.s().e(this.g, JsonValue.x(this.f)).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bu5.class != obj.getClass()) {
            return false;
        }
        bu5 bu5 = (bu5) obj;
        List<dk5<cu5>> list = this.f;
        if (list == null ? bu5.f != null : !list.equals(bu5.f)) {
            return false;
        }
        String str = this.g;
        String str2 = bu5.g;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        List<dk5<cu5>> list = this.f;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.g;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }
}
