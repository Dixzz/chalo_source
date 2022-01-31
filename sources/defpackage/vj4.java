package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: vj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class vj4 implements Executor {
    public final Handler f = new a34(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f.post(runnable);
    }
}
