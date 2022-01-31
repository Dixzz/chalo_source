package defpackage;

import android.os.Process;

/* renamed from: i06  reason: default package */
/* compiled from: BackgroundPriorityRunnable */
public abstract class i06 implements Runnable {
    public abstract void onRun();

    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
