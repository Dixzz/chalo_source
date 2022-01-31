package defpackage;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import defpackage.w72;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* renamed from: m42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class m42 implements w72.c {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<v42> f2326a;
    public final x22<?> b;
    public final boolean c;

    public m42(v42 v42, x22<?> x22, boolean z) {
        this.f2326a = new WeakReference<>(v42);
        this.b = x22;
        this.c = z;
    }

    @Override // defpackage.w72.c
    public final void a(ConnectionResult connectionResult) {
        Lock lock;
        v42 v42 = this.f2326a.get();
        if (v42 != null) {
            gj1.o(Looper.myLooper() == v42.f3596a.s.g, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            v42.b.lock();
            try {
                if (!v42.p(0)) {
                    lock = v42.b;
                } else {
                    if (!connectionResult.m1()) {
                        v42.k(connectionResult, this.b, this.c);
                    }
                    if (v42.q()) {
                        v42.i();
                    }
                    lock = v42.b;
                }
                lock.unlock();
            } catch (Throwable th) {
                v42.b.unlock();
                throw th;
            }
        }
    }
}
