package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: ym5  reason: default package */
/* compiled from: AutomationEngine */
public class ym5 implements Runnable {
    public final /* synthetic */ List f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ mm5 h;

    public ym5(mm5 mm5, List list, ck5 ck5) {
        this.h = mm5;
        this.f = list;
        this.g = ck5;
    }

    public void run() {
        Boolean bool = Boolean.FALSE;
        mm5.f(this.h);
        if (((long) (this.f.size() + this.h.w.g())) > this.h.f2399a) {
            yj5.c("AutomationDataManager - Unable to insert schedule due to schedule exceeded limit.", new Object[0]);
            this.g.d(bool);
            return;
        }
        List<ln5> list = this.f;
        ArrayList arrayList = new ArrayList();
        for (ln5 ln5 : list) {
            arrayList.add(hd3.P(ln5));
        }
        if (arrayList.isEmpty()) {
            this.g.d(bool);
            return;
        }
        this.h.w.o(arrayList);
        mm5.b(this.h, arrayList);
        Collection<ln5<? extends mn5>> h2 = this.h.h(arrayList);
        mm5 mm5 = this.h;
        mm5.l(h2, new wm5(mm5));
        yj5.h("Scheduled entries: %s", h2);
        this.g.d(Boolean.TRUE);
    }
}
