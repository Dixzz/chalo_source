package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: ve4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ve4 implements Runnable {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ g24 g;
    public final /* synthetic */ re4 h;

    public ve4(re4 re4, zzn zzn, g24 g24) {
        this.h = re4;
        this.f = zzn;
        this.g = g24;
    }

    public final void run() {
        try {
            if (!uy3.a() || !this.h.f3331a.g.l(q64.H0) || this.h.i().x().k()) {
                re4 re4 = this.h;
                ja4 ja4 = re4.d;
                if (ja4 == null) {
                    re4.g().f.a("Failed to get app instance id");
                    this.h.h().L(this.g, null);
                    return;
                }
                String O0 = ja4.O0(this.f);
                if (O0 != null) {
                    this.h.k().g.set(O0);
                    this.h.i().l.b(O0);
                }
                this.h.E();
                this.h.h().L(this.g, O0);
                return;
            }
            this.h.g().k.a("Analytics storage consent denied; will not get app instance id");
            this.h.k().g.set(null);
            this.h.i().l.b(null);
        } catch (RemoteException e) {
            this.h.g().f.b("Failed to get app instance id", e);
        } finally {
            this.h.h().L(this.g, null);
        }
    }
}
