package defpackage;

import java.util.Objects;

/* renamed from: zf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zf4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ xf4 g;

    public zf4(xf4 xf4, long j) {
        this.g = xf4;
        this.f = j;
    }

    public final void run() {
        xf4 xf4 = this.g;
        long j = this.f;
        xf4.b();
        xf4.w();
        xf4.g().n.b("Activity paused, time", Long.valueOf(j));
        yf4 yf4 = xf4.f;
        Objects.requireNonNull((db2) yf4.b.f3331a.n);
        cg4 cg4 = new cg4(yf4, System.currentTimeMillis(), j);
        yf4.f4043a = cg4;
        yf4.b.c.postDelayed(cg4, 2000);
        if (xf4.f3331a.g.y().booleanValue()) {
            xf4.e.c.c();
        }
        gg4 gg4 = xf4.d;
        if (!gg4.f1256a.f3331a.g.l(q64.v0)) {
            gg4.f1256a.i().w.a(true);
        }
    }
}
