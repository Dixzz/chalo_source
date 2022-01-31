package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: dy4  reason: default package */
public final class dy4 implements Executor {
    public final Handler f = new Handler(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f.post(runnable);
    }
}
