package defpackage;

import androidx.work.impl.workers.ConstraintTrackingWorker;

/* renamed from: rt  reason: default package */
/* compiled from: ConstraintTrackingWorker */
public class rt implements Runnable {
    public final /* synthetic */ gy4 f;
    public final /* synthetic */ ConstraintTrackingWorker g;

    public rt(ConstraintTrackingWorker constraintTrackingWorker, gy4 gy4) {
        this.g = constraintTrackingWorker;
        this.f = gy4;
    }

    public void run() {
        synchronized (this.g.k) {
            if (this.g.l) {
                this.g.h();
            } else {
                this.g.m.l(this.f);
            }
        }
    }
}
