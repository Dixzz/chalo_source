package defpackage;

import android.os.Bundle;

/* renamed from: bg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class bg4 implements Runnable {
    public final cg4 f;

    public bg4(cg4 cg4) {
        this.f = cg4;
    }

    public final void run() {
        cg4 cg4 = this.f;
        yf4 yf4 = cg4.h;
        long j = cg4.f;
        long j2 = cg4.g;
        yf4.b.b();
        yf4.b.g().m.a("Application going to the background");
        boolean z = true;
        if (yf4.b.f3331a.g.l(q64.v0)) {
            yf4.b.i().w.a(true);
        }
        Bundle bundle = new Bundle();
        if (!yf4.b.f3331a.g.y().booleanValue()) {
            yf4.b.e.c.c();
            if (yf4.b.f3331a.g.l(q64.m0)) {
                eg4 eg4 = yf4.b.e;
                eg4.b = j2;
                bundle.putLong("_et", j2 - eg4.b);
                ie4.z(yf4.b.o().v(true), bundle, true);
            } else {
                z = false;
            }
            yf4.b.v(false, z, j2);
        }
        yf4.b.k().D("auto", "_ab", j, bundle);
    }
}
