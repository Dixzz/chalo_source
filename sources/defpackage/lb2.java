package defpackage;

import android.os.Process;

/* renamed from: lb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class lb2 implements Runnable {
    public final Runnable f;

    public lb2(Runnable runnable) {
        this.f = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.f.run();
    }
}
