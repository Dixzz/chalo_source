package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: r12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class r12 implements Runnable {
    public final n12 f;
    public final Intent g;
    public final Context h;
    public final boolean i;
    public final BroadcastReceiver.PendingResult j;

    public r12(n12 n12, Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.f = n12;
        this.g = intent;
        this.h = context;
        this.i = z;
        this.j = pendingResult;
    }

    public final void run() {
        this.f.zza(this.g, this.h, this.i, this.j);
    }
}
