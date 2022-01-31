package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* renamed from: d72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class d72 implements x52 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f72 f803a;

    public /* synthetic */ d72(f72 f72) {
        this.f803a = f72;
    }

    @Override // defpackage.x52
    public final void a(Bundle bundle) {
        this.f803a.r.lock();
        try {
            f72 f72 = this.f803a;
            Bundle bundle2 = f72.n;
            if (bundle2 == null) {
                f72.n = bundle;
            } else if (bundle != null) {
                bundle2.putAll(bundle);
            }
            f72 f722 = this.f803a;
            f722.o = ConnectionResult.j;
            f72.p(f722);
        } finally {
            this.f803a.r.unlock();
        }
    }

    @Override // defpackage.x52
    public final void b(ConnectionResult connectionResult) {
        this.f803a.r.lock();
        try {
            f72 f72 = this.f803a;
            f72.o = connectionResult;
            f72.p(f72);
        } finally {
            this.f803a.r.unlock();
        }
    }

    @Override // defpackage.x52
    public final void c(int i, boolean z) {
        Lock lock;
        ConnectionResult connectionResult;
        this.f803a.r.lock();
        try {
            f72 f72 = this.f803a;
            if (!f72.q && (connectionResult = f72.p) != null) {
                if (connectionResult.m1()) {
                    f72 f722 = this.f803a;
                    f722.q = true;
                    f722.j.C(i);
                    lock = this.f803a.r;
                    lock.unlock();
                }
            }
            f72 f723 = this.f803a;
            f723.q = false;
            f723.g.c(i, z);
            f723.p = null;
            f723.o = null;
            lock = this.f803a.r;
            lock.unlock();
        } catch (Throwable th) {
            this.f803a.r.unlock();
            throw th;
        }
    }
}
