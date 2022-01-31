package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* renamed from: fq5  reason: default package */
/* compiled from: TagGroupApiClient */
public class fq5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f1160a;
    public Callable<String> b;
    public final String c;

    public fq5(kq5 kq5, sq5 sq5, Callable<String> callable, String str) {
        this.f1160a = kq5;
        this.b = callable;
        this.c = str;
    }

    public tq5<Void> a(String str, jq5 jq5) throws rq5 {
        oq5 a2 = this.f1160a.b().a();
        a2.a(this.c);
        Uri b2 = a2.b();
        zt5.b s = zt5.s();
        s.h(jq5.b().n());
        zt5.b s2 = zt5.s();
        try {
            s2.f(this.b.call(), str);
            s.e("audience", s2.a());
            zt5 a3 = s.a();
            yj5.h("Updating tag groups with path: %s, payload: %s", this.c, a3);
            qq5 qq5 = new qq5();
            qq5.d = FirebasePerformance.HttpMethod.POST;
            qq5.f2981a = b2;
            AirshipConfigOptions airshipConfigOptions = this.f1160a.b;
            String str2 = airshipConfigOptions.f711a;
            String str3 = airshipConfigOptions.b;
            qq5.b = str2;
            qq5.c = str3;
            qq5.f(a3);
            qq5.d();
            qq5.e(this.f1160a);
            tq5<Void> a4 = qq5.a();
            String str4 = a4.f3395a;
            if (str4 != null) {
                try {
                    JsonValue p = JsonValue.p(str4);
                    if (p.f instanceof zt5) {
                        if (p.n().f.containsKey("warnings")) {
                            Iterator<JsonValue> it = p.n().u("warnings").m().iterator();
                            while (it.hasNext()) {
                                yj5.i("Tag Groups warnings: %s", it.next());
                            }
                        }
                        if (p.n().f.containsKey("error")) {
                            yj5.c("Tag Groups error: %s", p.n().f.get("error"));
                        }
                    }
                } catch (xt5 e) {
                    yj5.e(e, "Unable to parse tag group response", new Object[0]);
                }
            }
            return a4;
        } catch (Exception e2) {
            throw new rq5("Audience exception", e2);
        }
    }
}
