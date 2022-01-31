package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* renamed from: e72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class e72 implements x52 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f72 f937a;

    public /* synthetic */ e72(f72 f72) {
        this.f937a = f72;
    }

    @Override // defpackage.x52
    public final void a(Bundle bundle) {
        this.f937a.r.lock();
        try {
            f72 f72 = this.f937a;
            f72.p = ConnectionResult.j;
            f72.p(f72);
        } finally {
            this.f937a.r.unlock();
        }
    }

    @Override // defpackage.x52
    public final void b(ConnectionResult connectionResult) {
        this.f937a.r.lock();
        try {
            f72 f72 = this.f937a;
            f72.p = connectionResult;
            f72.p(f72);
        } finally {
            this.f937a.r.unlock();
        }
    }

    @Override // defpackage.x52
    public final void c(int i, boolean z) {
        Lock lock;
        this.f937a.r.lock();
        try {
            f72 f72 = this.f937a;
            if (f72.q) {
                f72.q = false;
                f72.g.c(i, z);
                f72.p = null;
                f72.o = null;
                lock = this.f937a.r;
            } else {
                f72.q = true;
                f72.i.C(i);
                lock = this.f937a.r;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f937a.r.unlock();
            throw th;
        }
    }
}
