package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: rp5  reason: default package */
/* compiled from: AttributeRegistrar */
public class rp5 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3113a = new Object();
    public final np5 b;
    public final zp5 c;
    public final List<pp5> d = new CopyOnWriteArrayList();
    public String e;

    public rp5(np5 np5, zp5 zp5) {
        this.b = np5;
        this.c = zp5;
    }

    public void a(List<qp5> list) {
        zp5 zp5 = this.c;
        synchronized (zp5.b) {
            List<JsonValue> e2 = zp5.f3862a.d(zp5.b).m().e();
            ((ArrayList) e2).add(((cu5) zp5.d.apply(list)).b());
            zp5.f3862a.j(zp5.b, JsonValue.x(e2));
        }
    }

    public List<qp5> b() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) this.c.b()).iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) it.next());
        }
        return arrayList;
    }

    public void c(String str, boolean z) {
        synchronized (this.f3113a) {
            if (z) {
                if (!hd3.R0(this.e, str)) {
                    this.c.e();
                }
            }
            this.e = str;
        }
    }

    public boolean d() {
        List<qp5> list;
        String str;
        synchronized (this.f3113a) {
            zp5 zp5 = this.c;
            zp5.a(new aq5(zp5));
            list = (List) this.c.c();
            str = this.e;
        }
        if (str == null || list == null || list.isEmpty()) {
            return true;
        }
        try {
            tq5<Void> a2 = this.b.a(str, list);
            yj5.a("Updated attributes response: %s", a2);
            if (a2.b() || a2.d()) {
                return false;
            }
            int i = a2.c;
            if (i / 100 == 4) {
                yj5.c("Dropping attributes %s due to error: %s message: %s", list, Integer.valueOf(i), a2.f3395a);
            } else {
                for (pp5 pp5 : this.d) {
                    pp5.a(str, list);
                }
            }
            synchronized (this.f3113a) {
                if (list.equals(this.c.c()) && str.equals(this.e)) {
                    this.c.d();
                }
            }
            return true;
        } catch (rq5 e2) {
            yj5.b(e2, "Failed to update attributes", new Object[0]);
            return false;
        }
    }
}
