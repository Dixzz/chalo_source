package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: qj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class qj4 implements Runnable {
    public final /* synthetic */ yi4 f;
    public final /* synthetic */ rj4 g;

    public qj4(rj4 rj4, yi4 yi4) {
        this.g = rj4;
        this.f = yi4;
    }

    public final void run() {
        try {
            yi4<TContinuationResult> then = this.g.b.then((TResult) this.f.m());
            if (then == null) {
                rj4 rj4 = this.g;
                rj4.c.u(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = aj4.b;
            then.g(executor, this.g);
            then.e(executor, this.g);
            then.a(executor, this.g);
        } catch (wi4 e) {
            if (e.getCause() instanceof Exception) {
                this.g.c.u((Exception) e.getCause());
                return;
            }
            this.g.c.u(e);
        } catch (CancellationException unused) {
            this.g.c.v();
        } catch (Exception e2) {
            this.g.c.u(e2);
        }
    }
}
