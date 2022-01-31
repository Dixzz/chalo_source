package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: hq5  reason: default package */
/* compiled from: TagGroupRegistrar */
public class hq5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<gq5> f1413a = new CopyOnWriteArrayList();
    public final Object b = new Object();
    public final fq5 c;
    public final bq5 d;
    public String e;

    public hq5(fq5 fq5, bq5 bq5) {
        this.c = fq5;
        this.d = bq5;
        bq5.a(new cq5(bq5));
    }

    public void a(List<jq5> list) {
        bq5 bq5 = this.d;
        Objects.requireNonNull(bq5);
        if (!list.isEmpty()) {
            synchronized (bq5.b) {
                List<JsonValue> e2 = bq5.f3862a.d(bq5.b).m().e();
                for (jq5 jq5 : list) {
                    ((ArrayList) e2).add(((cu5) bq5.d.apply(jq5)).b());
                }
                bq5.f3862a.j(bq5.b, JsonValue.x(e2));
            }
        }
    }

    public void b(String str, boolean z) {
        synchronized (this.b) {
            if (z) {
                if (!hd3.R0(this.e, str)) {
                    this.d.e();
                }
            }
            this.e = str;
        }
    }

    public boolean c() {
        jq5 jq5;
        String str;
        while (true) {
            synchronized (this.b) {
                bq5 bq5 = this.d;
                bq5.a(new cq5(bq5));
                jq5 = (jq5) this.d.c();
                str = this.e;
            }
            if (hd3.G1(str) || jq5 == null) {
                return true;
            }
            try {
                tq5<Void> a2 = this.c.a(str, jq5);
                yj5.a("Updated tag group response: %s", a2);
                if (a2.b() || a2.d()) {
                    return false;
                }
                int i = a2.c;
                if (i / 100 == 4) {
                    yj5.c("Dropping tag group update %s due to error: %s message: %s", jq5, Integer.valueOf(i), a2.f3395a);
                } else {
                    for (gq5 gq5 : this.f1413a) {
                        gq5.a(str, jq5);
                    }
                }
                synchronized (this.b) {
                    if (jq5.equals(this.d.c()) && str.equals(this.e)) {
                        this.d.d();
                    }
                }
            } catch (rq5 e2) {
                yj5.b(e2, "Failed to update tag groups", new Object[0]);
                return false;
            }
        }
        return false;
    }
}
