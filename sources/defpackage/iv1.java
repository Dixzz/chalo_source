package defpackage;

import java.util.concurrent.Executor;

/* renamed from: iv1  reason: default package */
/* compiled from: SafeLoggingExecutor */
public class iv1 implements Executor {
    public final Executor f;

    /* renamed from: iv1$a */
    /* compiled from: SafeLoggingExecutor */
    public static class a implements Runnable {
        public final Runnable f;

        public a(Runnable runnable) {
            this.f = runnable;
        }

        public void run() {
            try {
                this.f.run();
            } catch (Exception unused) {
                gj1.L("Executor");
            }
        }
    }

    public iv1(Executor executor) {
        this.f = executor;
    }

    public void execute(Runnable runnable) {
        this.f.execute(new a(runnable));
    }
}
