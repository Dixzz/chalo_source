package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: bf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class bf4 implements Runnable {
    public final /* synthetic */ Bundle f;
    public final /* synthetic */ zzn g;
    public final /* synthetic */ re4 h;

    public bf4(re4 re4, Bundle bundle, zzn zzn) {
        this.h = re4;
        this.f = bundle;
        this.g = zzn;
    }

    public final void run() {
        re4 re4 = this.h;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Failed to send default event parameters to service");
            return;
        }
        try {
            ja4.P2(this.f, this.g);
        } catch (RemoteException e) {
            this.h.g().f.b("Failed to send default event parameters to service", e);
        }
    }
}
