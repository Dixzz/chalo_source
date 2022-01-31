package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: ye4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ye4 implements Runnable {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ re4 g;

    public ye4(re4 re4, zzn zzn) {
        this.g = re4;
        this.f = zzn;
    }

    public final void run() {
        re4 re4 = this.g;
        ja4 ja4 = re4.d;
        if (ja4 == null) {
            re4.g().f.a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            ja4.N1(this.f);
            this.g.p().y();
            this.g.v(ja4, null, this.f);
            this.g.E();
        } catch (RemoteException e) {
            this.g.g().f.b("Failed to send app launch to the service", e);
        }
    }
}
