package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* renamed from: sb3  reason: default package */
public final class sb3 extends yb3 {
    public final mc3 h;

    public sb3(ac3 ac3, cc3 cc3) {
        super(ac3);
        this.h = new mc3(ac3, cc3);
    }

    @Override // defpackage.yb3
    public final void a0() {
        this.h.Z();
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02c0 A[LOOP:2: B:83:0x02ba->B:85:0x02c0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long i0(defpackage.dc3 r20) {
        /*
        // Method dump skipped, instructions count: 985
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sb3.i0(dc3):long");
    }

    public final void j0(nd3 nd3) {
        g0();
        o("Hit delivery requested", nd3);
        w().b(new ub3(this, nd3));
    }

    public final void m0() {
        g0();
        Context context = this.f.f146a;
        if (!yd3.a(context) || !zd3.c(context)) {
            g0();
            w().b(new vb3(this, null));
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
        context.startService(intent);
    }

    public final void o0() {
        jz1.c();
        mc3 mc3 = this.h;
        Objects.requireNonNull(mc3);
        jz1.c();
        Objects.requireNonNull((db2) mc3.f.c);
        mc3.q = System.currentTimeMillis();
    }
}
