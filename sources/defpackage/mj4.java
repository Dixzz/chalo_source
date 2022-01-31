package defpackage;

import java.util.Objects;

/* renamed from: mj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class mj4 implements Runnable {
    public final /* synthetic */ yi4 f;
    public final /* synthetic */ nj4 g;

    public mj4(nj4 nj4, yi4 yi4) {
        this.g = nj4;
        this.f = yi4;
    }

    public final void run() {
        synchronized (this.g.b) {
            ui4 ui4 = this.g.c;
            if (ui4 != null) {
                Exception l = this.f.l();
                Objects.requireNonNull(l, "null reference");
                ui4.onFailure(l);
            }
        }
    }
}
