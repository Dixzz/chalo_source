package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* renamed from: jm5  reason: default package */
/* compiled from: AutomationEngine */
public class jm5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ on5 h;
    public final /* synthetic */ mm5 i;

    public jm5(mm5 mm5, String str, ck5 ck5, on5 on5) {
        this.i = mm5;
        this.f = str;
        this.g = ck5;
        this.h = on5;
    }

    public void run() {
        boolean z;
        so5 f2 = this.i.w.f(this.f);
        if (f2 == null) {
            yj5.c("AutomationEngine - Schedule no longer exists. Unable to edit: %s", this.f);
            this.g.d(Boolean.FALSE);
            return;
        }
        mm5 mm5 = this.i;
        on5 on5 = this.h;
        Objects.requireNonNull(mm5);
        wo5 wo5 = f2.f3238a;
        Long l = on5.b;
        wo5.g = l == null ? wo5.g : l.longValue();
        Long l2 = on5.c;
        wo5.h = l2 == null ? wo5.h : l2.longValue();
        Integer num = on5.f2715a;
        wo5.e = num == null ? wo5.e : num.intValue();
        T t = on5.d;
        wo5.l = t == null ? wo5.l : t.b();
        Integer num2 = on5.e;
        wo5.f = num2 == null ? wo5.f : num2.intValue();
        Long l3 = on5.g;
        wo5.j = l3 == null ? wo5.j : l3.longValue();
        Long l4 = on5.f;
        wo5.i = l4 == null ? wo5.i : l4.longValue();
        zt5 zt5 = on5.h;
        if (zt5 == null) {
            zt5 = wo5.d;
        }
        wo5.d = zt5;
        String str = on5.j;
        if (str == null) {
            str = wo5.k;
        }
        wo5.k = str;
        fm5 fm5 = on5.i;
        if (fm5 == null) {
            fm5 = wo5.u;
        }
        wo5.u = fm5;
        JsonValue jsonValue = on5.k;
        if (jsonValue == null) {
            jsonValue = wo5.v;
        }
        wo5.v = jsonValue;
        List<String> list = on5.l;
        if (list == null) {
            list = wo5.w;
        }
        wo5.w = list;
        long j = -1;
        Objects.requireNonNull(this.i);
        wo5 wo52 = f2.f3238a;
        int i2 = wo52.e;
        boolean z2 = i2 > 0 && wo52.m >= i2;
        boolean k = this.i.k(f2);
        wo5 wo53 = f2.f3238a;
        int i3 = wo53.n;
        if (i3 != 4 || z2 || k) {
            if (i3 != 4 && (z2 || k)) {
                this.i.u(f2, 4);
                if (z2) {
                    mm5 mm52 = this.i;
                    Objects.requireNonNull(mm52);
                    mm52.l(mm52.h(Collections.singleton(f2)), new vm5(mm52));
                } else {
                    mm5 mm53 = this.i;
                    mm53.l(mm53.h(Collections.singleton(f2)), new tm5(mm53));
                }
            }
            z = false;
        } else {
            j = wo53.o;
            this.i.u(f2, 0);
            z = true;
        }
        this.i.w.p(f2);
        if (z) {
            this.i.t(f2, j);
        }
        yj5.h("Updated schedule: %s", this.f);
        this.g.d(Boolean.TRUE);
    }
}
