package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: j52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final /* synthetic */ class j52 implements Executor {
    public final Handler f;

    public j52(Handler handler) {
        this.f = handler;
    }

    public final void execute(Runnable runnable) {
        this.f.post(runnable);
    }
}
