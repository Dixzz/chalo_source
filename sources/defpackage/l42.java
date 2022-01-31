package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: l42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class l42 implements Runnable {
    public final /* synthetic */ v42 f;

    public l42(v42 v42) {
        this.f = v42;
    }

    public final void run() {
        v42 v42 = this.f;
        r22 r22 = v42.d;
        Context context = v42.c;
        Objects.requireNonNull(r22);
        u22.cancelAvailabilityErrorNotifications(context);
    }
}
