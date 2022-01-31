package defpackage;

import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: gw1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gw1 implements Runnable {
    public final /* synthetic */ iw1 f;
    public final /* synthetic */ jv1 g;
    public final /* synthetic */ fu1 h;
    public final /* synthetic */ gv1 i;

    public /* synthetic */ gw1(iw1 iw1, jv1 jv1, fu1 fu1, gv1 gv1) {
        this.f = iw1;
        this.g = jv1;
        this.h = fu1;
        this.i = gv1;
    }

    public final void run() {
        iw1 iw1 = this.f;
        jv1 jv1 = this.g;
        fu1 fu1 = this.h;
        gv1 gv1 = this.i;
        Objects.requireNonNull(iw1);
        try {
            cw1 a2 = iw1.c.a(jv1.b());
            if (a2 == null) {
                String format = String.format("Transport backend '%s' is not registered", jv1.b());
                iw1.f.warning(format);
                fu1.onSchedule(new IllegalArgumentException(format));
                return;
            }
            iw1.e.a(new hw1(iw1, jv1, a2.b(gv1)));
            fu1.onSchedule(null);
        } catch (Exception e) {
            Logger logger = iw1.f;
            StringBuilder i0 = hj1.i0("Error scheduling event ");
            i0.append(e.getMessage());
            logger.warning(i0.toString());
            fu1.onSchedule(e);
        }
    }
}
