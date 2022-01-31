package defpackage;

import java.lang.Thread;

/* renamed from: co6  reason: default package */
/* compiled from: SafeRunnable */
public abstract class co6 implements Runnable {
    public final wn6 f;

    public co6(wn6 wn6) {
        this.f = wn6;
    }

    public abstract void a();

    public final void run() {
        try {
            if (!this.f.l.d()) {
                a();
            }
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
