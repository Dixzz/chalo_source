package defpackage;

import java.util.Objects;

/* renamed from: wf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class wf4 implements Runnable {
    public final /* synthetic */ long f;
    public final /* synthetic */ xf4 g;

    public wf4(xf4 xf4, long j) {
        this.g = xf4;
        this.f = j;
    }

    public final void run() {
        xf4 xf4 = this.g;
        long j = this.f;
        xf4.b();
        xf4.w();
        xf4.g().n.b("Activity resumed, time", Long.valueOf(j));
        if (xf4.f3331a.g.l(q64.v0)) {
            if (xf4.f3331a.g.y().booleanValue() || xf4.i().w.b()) {
                eg4 eg4 = xf4.e;
                eg4.d.b();
                eg4.c.c();
                eg4.f969a = j;
                eg4.b = j;
            }
            xf4.f.a();
        } else {
            xf4.f.a();
            if (xf4.f3331a.g.y().booleanValue()) {
                eg4 eg42 = xf4.e;
                eg42.d.b();
                eg42.c.c();
                eg42.f969a = j;
                eg42.b = j;
            }
        }
        gg4 gg4 = xf4.d;
        gg4.f1256a.b();
        if (gg4.f1256a.f3331a.d()) {
            if (!gg4.f1256a.f3331a.g.l(q64.v0)) {
                gg4.f1256a.i().w.a(false);
            }
            Objects.requireNonNull((db2) gg4.f1256a.f3331a.n);
            gg4.b(System.currentTimeMillis(), false);
        }
    }
}
