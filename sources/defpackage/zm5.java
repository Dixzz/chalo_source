package defpackage;

import java.util.Collection;
import java.util.List;

/* renamed from: zm5  reason: default package */
/* compiled from: AutomationEngine */
public class zm5 implements Runnable {
    public final /* synthetic */ Collection f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ mm5 h;

    public zm5(mm5 mm5, Collection collection, ck5 ck5) {
        this.h = mm5;
        this.f = collection;
        this.g = ck5;
    }

    public void run() {
        List<so5> i = this.h.w.i(this.f);
        if (i.isEmpty()) {
            this.g.d(Boolean.FALSE);
            return;
        }
        yj5.h("Cancelled schedules: %s", this.f);
        this.h.w.b(i);
        mm5.c(this.h, i);
        mm5.d(this.h, this.f);
        this.g.d(Boolean.TRUE);
    }
}
