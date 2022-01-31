package defpackage;

import java.util.Objects;

/* renamed from: mf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class mf4 implements Runnable {
    public final /* synthetic */ ja4 f;
    public final /* synthetic */ lf4 g;

    public mf4(lf4 lf4, ja4 ja4) {
        this.g = lf4;
        this.f = ja4;
    }

    public final void run() {
        synchronized (this.g) {
            this.g.f2209a = false;
            if (!this.g.c.A()) {
                this.g.c.g().m.a("Connected to remote service");
                re4 re4 = this.g.c;
                ja4 ja4 = this.f;
                re4.b();
                Objects.requireNonNull(ja4, "null reference");
                re4.d = ja4;
                re4.E();
                re4.G();
            }
        }
    }
}
