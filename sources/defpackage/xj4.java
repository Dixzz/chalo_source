package defpackage;

import java.util.concurrent.Callable;

/* renamed from: xj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class xj4 implements Runnable {
    public final /* synthetic */ wj4 f;
    public final /* synthetic */ Callable g;

    public xj4(wj4 wj4, Callable callable) {
        this.f = wj4;
        this.g = callable;
    }

    public final void run() {
        try {
            this.f.t(this.g.call());
        } catch (Exception e) {
            this.f.u(e);
        } catch (Throwable th) {
            this.f.u(new RuntimeException(th));
        }
    }
}
