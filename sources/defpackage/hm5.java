package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: hm5  reason: default package */
/* compiled from: AutomationEngine */
public class hm5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ mm5 h;

    public hm5(mm5 mm5, String str, ck5 ck5) {
        this.h = mm5;
        this.f = str;
        this.g = ck5;
    }

    public void run() {
        List<so5> j = this.h.w.j(this.f);
        if (j.isEmpty()) {
            this.g.d(Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (so5 so5 : j) {
            arrayList.add(so5.f3238a.b);
        }
        yj5.h("Cancelled schedules: %s", arrayList);
        this.h.w.b(j);
        mm5.c(this.h, j);
        mm5.d(this.h, arrayList);
        this.g.d(Boolean.TRUE);
    }
}
