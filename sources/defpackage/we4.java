package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: we4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class we4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ zzn g;
    public final /* synthetic */ re4 h;

    public we4(re4 re4, AtomicReference atomicReference, zzn zzn) {
        this.h = re4;
        this.f = atomicReference;
        this.g = zzn;
    }

    public final void run() {
        synchronized (this.f) {
            try {
                if (!uy3.a() || !this.h.f3331a.g.l(q64.H0) || this.h.i().x().k()) {
                    re4 re4 = this.h;
                    ja4 ja4 = re4.d;
                    if (ja4 == null) {
                        re4.g().f.a("Failed to get app instance id");
                        this.f.notify();
                        return;
                    }
                    this.f.set(ja4.O0(this.g));
                    String str = (String) this.f.get();
                    if (str != null) {
                        this.h.k().g.set(str);
                        this.h.i().l.b(str);
                    }
                    this.h.E();
                    this.f.notify();
                    return;
                }
                this.h.g().k.a("Analytics storage consent denied; will not get app instance id");
                this.h.k().g.set(null);
                this.h.i().l.b(null);
                this.f.set(null);
            } catch (RemoteException e) {
                this.h.g().f.b("Failed to get app instance id", e);
            } finally {
                this.f.notify();
            }
        }
    }
}
