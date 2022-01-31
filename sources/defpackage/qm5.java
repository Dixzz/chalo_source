package defpackage;

import java.util.List;

/* renamed from: qm5  reason: default package */
/* compiled from: AutomationEngine */
public class qm5 implements Runnable {
    public final /* synthetic */ int f;
    public final /* synthetic */ cu5 g;
    public final /* synthetic */ double h;
    public final /* synthetic */ mm5 i;

    public qm5(mm5 mm5, int i2, cu5 cu5, double d) {
        this.i = mm5;
        this.f = i2;
        this.g = cu5;
        this.h = d;
    }

    public void run() {
        yj5.a("Updating triggers with type: %s", Integer.valueOf(this.f));
        List<xo5> d = this.i.w.d(this.f);
        if (!d.isEmpty()) {
            mm5 mm5 = this.i;
            mm5.i.post(new rm5(mm5, d, this.g, this.h));
        }
    }
}
