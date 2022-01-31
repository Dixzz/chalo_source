package defpackage;

import androidx.work.impl.foreground.SystemForegroundService;

/* renamed from: bs  reason: default package */
/* compiled from: SystemForegroundService */
public class bs implements Runnable {
    public final /* synthetic */ int f;
    public final /* synthetic */ SystemForegroundService g;

    public bs(SystemForegroundService systemForegroundService, int i) {
        this.g = systemForegroundService;
        this.f = i;
    }

    public void run() {
        this.g.j.cancel(this.f);
    }
}
