package defpackage;

import com.razorpay.AnalyticsConstants;
import java.util.Objects;

/* renamed from: rh  reason: default package */
/* compiled from: PausingDispatcher.kt */
public final class rh extends kb6 {
    public final tg g = new tg();

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        n86.e(runnable, "block");
        tg tgVar = this.g;
        Objects.requireNonNull(tgVar);
        n86.e(m66, AnalyticsConstants.CONTEXT);
        n86.e(runnable, "runnable");
        xb6 xb6 = xb6.f3911a;
        ad6 A = xf6.c.A();
        if (A.n(m66) || tgVar.a()) {
            A.m(m66, new sg(tgVar, m66, runnable));
        } else {
            tgVar.c(runnable);
        }
    }

    @Override // defpackage.kb6
    public boolean n(m66 m66) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        xb6 xb6 = xb6.f3911a;
        if (xf6.c.A().n(m66)) {
            return true;
        }
        return !this.g.a();
    }
}
