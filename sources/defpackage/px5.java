package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: px5  reason: default package */
/* compiled from: DisableInfo */
public class px5 implements cu5 {
    public final Set<String> f;
    public final long g;
    public final Set<String> h;
    public final bu5 i;

    /* renamed from: px5$b */
    /* compiled from: DisableInfo */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f2867a = new HashSet();
        public long b;
        public Set<String> c;
        public bu5 d;

        public b(a aVar) {
        }
    }

    public px5(b bVar, a aVar) {
        this.f = bVar.f2867a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
    }

    public static px5 a(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        b bVar = new b(null);
        if (n.f.containsKey("modules")) {
            HashSet hashSet = new HashSet();
            if ("all".equals(n.u("modules").i())) {
                hashSet.addAll(rx5.f3147a);
            } else {
                yt5 f2 = n.u("modules").f();
                if (f2 != null) {
                    Iterator<JsonValue> it = f2.iterator();
                    while (it.hasNext()) {
                        JsonValue next = it.next();
                        if (next.f instanceof String) {
                            if (rx5.f3147a.contains(next.i())) {
                                hashSet.add(next.i());
                            }
                        } else {
                            throw new xt5(hj1.F(n, "modules", hj1.i0("Modules must be an array of strings: ")));
                        }
                    }
                } else {
                    throw new xt5(hj1.F(n, "modules", hj1.i0("Modules must be an array of strings: ")));
                }
            }
            bVar.f2867a.clear();
            bVar.f2867a.addAll(hashSet);
        }
        if (n.f.containsKey("remote_data_refresh_interval")) {
            if (n.u("remote_data_refresh_interval").f instanceof Number) {
                bVar.b = TimeUnit.SECONDS.toMillis(n.u("remote_data_refresh_interval").g(0));
            } else {
                StringBuilder i0 = hj1.i0("Remote data refresh interval must be a number: ");
                i0.append(n.f.get("remote_data_refresh_interval"));
                throw new IllegalArgumentException(i0.toString());
            }
        }
        if (n.f.containsKey("sdk_versions")) {
            HashSet hashSet2 = new HashSet();
            yt5 f3 = n.u("sdk_versions").f();
            if (f3 != null) {
                Iterator<JsonValue> it2 = f3.iterator();
                while (it2.hasNext()) {
                    JsonValue next2 = it2.next();
                    if (next2.f instanceof String) {
                        hashSet2.add(next2.i());
                    } else {
                        throw new xt5(hj1.F(n, "sdk_versions", hj1.i0("SDK Versions must be an array of strings: ")));
                    }
                }
                bVar.c = new HashSet(hashSet2);
            } else {
                throw new xt5(hj1.F(n, "sdk_versions", hj1.i0("SDK Versions must be an array of strings: ")));
            }
        }
        if (n.f.containsKey("app_versions")) {
            bVar.d = bu5.d(n.f.get("app_versions"));
        }
        return new px5(bVar, null);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("modules", this.f);
        s.i("remote_data_refresh_interval", Long.valueOf(this.g));
        s.i("sdk_versions", this.h);
        s.i("app_versions", this.i);
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || px5.class != obj.getClass()) {
            return false;
        }
        px5 px5 = (px5) obj;
        if (this.g != px5.g || !this.f.equals(px5.f)) {
            return false;
        }
        Set<String> set = this.h;
        if (set == null ? px5.h != null : !set.equals(px5.h)) {
            return false;
        }
        bu5 bu5 = this.i;
        bu5 bu52 = px5.i;
        if (bu5 != null) {
            return bu5.equals(bu52);
        }
        if (bu52 == null) {
            return true;
        }
        return false;
    }
}
