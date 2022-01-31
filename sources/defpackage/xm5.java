package defpackage;

import java.util.Collections;

/* renamed from: xm5  reason: default package */
/* compiled from: AutomationEngine */
public class xm5 implements Runnable {
    public final /* synthetic */ ck5 f;
    public final /* synthetic */ ln5 g;
    public final /* synthetic */ mm5 h;

    public xm5(mm5 mm5, ck5 ck5, ln5 ln5) {
        this.h = mm5;
        this.f = ck5;
        this.g = ln5;
    }

    public void run() {
        mm5.f(this.h);
        if (((long) this.h.w.g()) >= this.h.f2399a) {
            yj5.c("AutomationEngine - Unable to insert schedule due to schedule exceeded limit.", new Object[0]);
            this.f.d(Boolean.FALSE);
            return;
        }
        so5 P = hd3.P(this.g);
        this.h.w.m(P);
        mm5.b(this.h, Collections.singletonList(P));
        mm5 mm5 = this.h;
        mm5.l(Collections.singletonList(this.g), new wm5(mm5));
        yj5.h("Scheduled entries: %s", this.g);
        this.f.d(Boolean.TRUE);
    }
}
