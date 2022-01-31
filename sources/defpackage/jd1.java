package defpackage;

import defpackage.nc5;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: jd1  reason: default package */
/* compiled from: MixpanelSender */
public class jd1 implements hd1 {

    /* renamed from: a  reason: collision with root package name */
    public nc5 f1905a;
    public zc1 b;
    public String c;

    public jd1(nc5 nc5, zc1 zc1, String str) {
        this.f1905a = nc5;
        this.b = zc1;
        this.c = str;
        String a2 = zc1.a();
        if (!nc5.m() && a2 != null) {
            synchronized (nc5.g) {
                String a3 = nc5.g.a();
                xc5 xc5 = nc5.g;
                synchronized (xc5) {
                    if (!xc5.i) {
                        xc5.e();
                    }
                    if (xc5.m == null) {
                        xc5.m = a3;
                        xc5.n = true;
                        xc5.k();
                    }
                }
                xc5 xc52 = nc5.g;
                synchronized (xc52) {
                    if (!xc52.i) {
                        xc52.e();
                    }
                    xc52.j = a2;
                    xc52.k();
                }
                xc5 xc53 = nc5.g;
                synchronized (xc53) {
                    if (!xc53.i) {
                        xc53.e();
                    }
                    xc53.k = true;
                    xc53.k();
                }
                String c2 = nc5.g.c();
                nc5.j.c(c2 == null ? nc5.g.a() : c2);
                if (!a2.equals(a3)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("$anon_distinct_id", a3);
                        if (!nc5.m()) {
                            nc5.s("$identify", jSONObject, false);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        nc5.e eVar = this.f1905a.e;
        eVar.a(this.b.a());
        if (this.b.d() != null) {
            this.f1905a.e.h("$name", this.b.d());
        }
        Objects.requireNonNull(this.b);
        Objects.requireNonNull(this.b);
        this.f1905a.e.h("$email", "");
        eVar.i(this.c);
    }

    @Override // defpackage.hd1
    public void a(String str) {
        this.f1905a.e.h("$email", str);
    }

    @Override // defpackage.hd1
    public void b(String str) {
        this.f1905a.e.h("$name", str);
    }

    @Override // defpackage.hd1
    public void c() {
        this.f1905a.f();
    }

    @Override // defpackage.hd1
    public void d(String str, double d) {
        this.f1905a.e.e(str, d);
    }

    @Override // defpackage.hd1
    public void e(Map<String, String> map) {
        this.f1905a.e.g(new JSONObject(map));
    }

    @Override // defpackage.hd1
    public void f(Map<String, String> map) {
        this.f1905a.p(new JSONObject(map));
    }

    @Override // defpackage.hd1
    public void g(ed1 ed1) {
        Map<String, Object> map = ed1.b;
        this.f1905a.r(ed1.f961a, (map == null || map.size() == 0) ? null : new JSONObject(ed1.b));
    }
}
