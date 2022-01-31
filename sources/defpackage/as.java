package defpackage;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

/* renamed from: as  reason: default package */
/* compiled from: SystemForegroundService */
public class as implements Runnable {
    public final /* synthetic */ int f;
    public final /* synthetic */ Notification g;
    public final /* synthetic */ SystemForegroundService h;

    public as(SystemForegroundService systemForegroundService, int i, Notification notification) {
        this.h = systemForegroundService;
        this.f = i;
        this.g = notification;
    }

    public void run() {
        this.h.j.notify(this.f, this.g);
    }
}
