package defpackage;

import java.util.concurrent.ScheduledFuture;

/* renamed from: l22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class l22 implements ti4 {
    public final o12 f;
    public final String g;
    public final ScheduledFuture h;

    public l22(o12 o12, String str, ScheduledFuture scheduledFuture) {
        this.f = o12;
        this.g = str;
        this.h = scheduledFuture;
    }

    @Override // defpackage.ti4
    public final void onComplete(yi4 yi4) {
        o12 o12 = this.f;
        String str = this.g;
        ScheduledFuture scheduledFuture = this.h;
        synchronized (o12.f2632a) {
            o12.f2632a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
