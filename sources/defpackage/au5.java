package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: au5  reason: default package */
/* compiled from: JsonMatcher */
public class au5 implements cu5, dk5<cu5> {
    public final String f;
    public final List<String> g;
    public final du5 h;
    public final Boolean i;

    /* renamed from: au5$b */
    /* compiled from: JsonMatcher */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public du5 f333a;
        public List<String> b = new ArrayList(1);
        public String c;
        public Boolean d;

        public b(a aVar) {
        }
    }

    public au5(b bVar, a aVar) {
        this.f = bVar.c;
        this.g = bVar.b;
        du5 du5 = bVar.f333a;
        this.h = du5 == null ? new hu5(true) : du5;
        this.i = bVar.d;
    }

    public static au5 a(JsonValue jsonValue) throws xt5 {
        du5 du5;
        iu5 iu5;
        hu5 hu5;
        if (!(jsonValue.f instanceof zt5) || jsonValue.n().isEmpty()) {
            throw new xt5(hj1.R("Unable to parse empty JsonValue: ", jsonValue));
        }
        zt5 n = jsonValue.n();
        if (n.f.containsKey(FirebaseAnalytics.Param.VALUE)) {
            b bVar = new b(null);
            bVar.c = n.u(AnalyticsConstants.KEY).i();
            JsonValue jsonValue2 = n.f.get(FirebaseAnalytics.Param.VALUE);
            zt5 n2 = jsonValue2 == null ? zt5.g : jsonValue2.n();
            if (n2.f.containsKey("equals")) {
                du5 = new fu5(n2.u("equals"));
            } else if (n2.f.containsKey("at_least") || n2.f.containsKey("at_most")) {
                Double valueOf = n2.f.containsKey("at_least") ? Double.valueOf(n2.u("at_least").c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) : null;
                Double valueOf2 = n2.f.containsKey("at_most") ? Double.valueOf(n2.u("at_most").c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) : null;
                if (!(valueOf == null || valueOf2 == null)) {
                    try {
                        if (valueOf2.doubleValue() < valueOf.doubleValue()) {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        throw new xt5(hj1.R("Invalid range matcher: ", jsonValue2), e);
                    }
                }
                du5 = new gu5(valueOf, valueOf2);
            } else if (n2.f.containsKey("is_present")) {
                if (n2.u("is_present").a(false)) {
                    hu5 = new hu5(true);
                } else {
                    hu5 = new hu5(false);
                }
                du5 = hu5;
            } else {
                if (n2.f.containsKey("version_matches")) {
                    try {
                        iu5 = new iu5(vy5.c(n2.u("version_matches").o()));
                    } catch (NumberFormatException e2) {
                        throw new xt5(hj1.F(n2, "version_matches", hj1.i0("Invalid version constraint: ")), e2);
                    }
                } else if (n2.f.containsKey("version")) {
                    try {
                        iu5 = new iu5(vy5.c(n2.u("version").o()));
                    } catch (NumberFormatException e3) {
                        throw new xt5(hj1.F(n2, "version", hj1.i0("Invalid version constraint: ")), e3);
                    }
                } else if (n2.f.containsKey("array_contains")) {
                    bu5 d = bu5.d(n2.f.get("array_contains"));
                    if (n2.f.containsKey(FirebaseAnalytics.Param.INDEX)) {
                        int e4 = n2.u(FirebaseAnalytics.Param.INDEX).e(-1);
                        if (e4 != -1) {
                            du5 = new eu5(d, Integer.valueOf(e4));
                        } else {
                            StringBuilder i0 = hj1.i0("Invalid index for array_contains matcher: ");
                            i0.append(n2.f.get(FirebaseAnalytics.Param.INDEX));
                            throw new xt5(i0.toString());
                        }
                    } else {
                        du5 = new eu5(d, null);
                    }
                } else {
                    throw new xt5(hj1.R("Unknown value matcher: ", jsonValue2));
                }
                du5 = iu5;
            }
            bVar.f333a = du5;
            JsonValue u = n.u("scope");
            Object obj = u.f;
            if (obj instanceof String) {
                String o = u.o();
                ArrayList arrayList = new ArrayList();
                bVar.b = arrayList;
                arrayList.add(o);
            } else if (obj instanceof yt5) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = ((ArrayList) u.m().e()).iterator();
                while (it.hasNext()) {
                    arrayList2.add(((JsonValue) it.next()).i());
                }
                ArrayList arrayList3 = new ArrayList();
                bVar.b = arrayList3;
                arrayList3.addAll(arrayList2);
            }
            if (n.f.containsKey("ignore_case")) {
                bVar.d = Boolean.valueOf(n.u("ignore_case").a(false));
            }
            return new au5(bVar, null);
        }
        throw new xt5("JsonMatcher must contain a value matcher.");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.dk5
    public boolean apply(cu5 cu5) {
        cu5 cu52 = cu5;
        JsonValue b2 = cu52 == null ? JsonValue.g : cu52.b();
        for (String str : this.g) {
            b2 = b2.n().u(str);
            if (b2.l()) {
                break;
            }
        }
        if (this.f != null) {
            b2 = b2.n().u(this.f);
        }
        du5 du5 = this.h;
        Boolean bool = this.i;
        return du5.a(b2, bool != null && bool.booleanValue());
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i(AnalyticsConstants.KEY, this.f);
        s.i("scope", this.g);
        zt5.b e = s.e(FirebaseAnalytics.Param.VALUE, this.h);
        e.i("ignore_case", this.i);
        return JsonValue.x(e.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || au5.class != obj.getClass()) {
            return false;
        }
        au5 au5 = (au5) obj;
        String str = this.f;
        if (str == null ? au5.f != null : !str.equals(au5.f)) {
            return false;
        }
        if (!this.g.equals(au5.g)) {
            return false;
        }
        Boolean bool = this.i;
        if (bool == null ? au5.i == null : bool.equals(au5.i)) {
            return this.h.equals(au5.h);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        int hashCode2 = (this.h.hashCode() + ((this.g.hashCode() + (hashCode * 31)) * 31)) * 31;
        Boolean bool = this.i;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode2 + i2;
    }
}
