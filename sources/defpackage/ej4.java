package defpackage;

/* renamed from: ej4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class ej4 implements Runnable {
    public final /* synthetic */ yi4 f;
    public final /* synthetic */ fj4 g;

    public ej4(fj4 fj4, yi4 yi4) {
        this.g = fj4;
        this.f = yi4;
    }

    public final void run() {
        if (this.f.o()) {
            this.g.c.v();
            return;
        }
        try {
            this.g.c.t(this.g.b.then(this.f));
        } catch (wi4 e) {
            if (e.getCause() instanceof Exception) {
                this.g.c.u((Exception) e.getCause());
            } else {
                this.g.c.u(e);
            }
        } catch (Exception e2) {
            this.g.c.u(e2);
        }
    }
}
