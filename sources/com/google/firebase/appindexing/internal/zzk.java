package com.google.firebase.appindexing.internal;

import android.os.Handler;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzk implements ti4<Void>, Executor {
    private final Handler handler;
    private final z22<?> zzfa;
    @GuardedBy("pendingCalls")
    private final Queue<zzj> zzff = new ArrayDeque();
    @GuardedBy("pendingCalls")
    private int zzfg = 0;

    public zzk(z22<?> z22) {
        this.zzfa = z22;
        this.handler = new b34(z22.getLooper());
    }

    public final void execute(Runnable runnable) {
        this.handler.post(runnable);
    }

    @Override // defpackage.ti4
    public final void onComplete(yi4<Void> yi4) {
        zzj zzj;
        synchronized (this.zzff) {
            if (this.zzfg == 2) {
                zzj = this.zzff.peek();
                gj1.n(zzj != null);
            } else {
                zzj = null;
            }
            this.zzfg = 0;
        }
        if (zzj != null) {
            zzj.execute();
        }
    }

    public final yi4<Void> zzb(zzy zzy) {
        boolean isEmpty;
        zzj zzj = new zzj(this, zzy);
        yi4<Void> task = zzj.getTask();
        task.c(this, this);
        synchronized (this.zzff) {
            isEmpty = this.zzff.isEmpty();
            this.zzff.add(zzj);
        }
        if (isEmpty) {
            zzj.execute();
        }
        return task;
    }
}
