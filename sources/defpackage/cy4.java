package defpackage;

import java.util.concurrent.Executor;

/* renamed from: cy4  reason: default package */
public final class cy4 implements Executor {
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
