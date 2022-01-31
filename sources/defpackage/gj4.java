package defpackage;

import java.util.concurrent.Executor;

/* renamed from: gj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class gj4 implements Runnable {
    public final /* synthetic */ yi4 f;
    public final /* synthetic */ hj4 g;

    public gj4(hj4 hj4, yi4 yi4) {
        this.g = hj4;
        this.f = yi4;
    }

    public final void run() {
        try {
            yi4<TContinuationResult> then = this.g.b.then(this.f);
            if (then == null) {
                hj4 hj4 = this.g;
                hj4.c.u(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = aj4.b;
            then.g(executor, this.g);
            then.e(executor, this.g);
            then.a(executor, this.g);
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
