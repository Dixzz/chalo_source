package defpackage;

import java.util.concurrent.Executor;

/* renamed from: nt  reason: default package */
/* compiled from: DirectExecutor */
public enum nt implements Executor {
    INSTANCE;

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
