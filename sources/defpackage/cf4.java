package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: cf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class cf4 implements Runnable {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ re4 g;

    public cf4(re4 re4, zzn zzn) {
        this.g = re4;
        this.f = zzn;
    }

    public final void run() {
        re4 re4 = this.g;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            ja4.q2(this.f);
            this.g.E();
        } catch (RemoteException e) {
            this.g.g().f.b("Failed to send measurementEnabled to the service", e);
        }
    }
}
