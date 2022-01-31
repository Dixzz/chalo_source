package defpackage;

import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: dj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class dj4 implements cj4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f846a = new Object();
    public final int b;
    public final wj4<Void> c;
    @GuardedBy("mLock")
    public int d;
    @GuardedBy("mLock")
    public int e;
    @GuardedBy("mLock")
    public int f;
    @GuardedBy("mLock")
    public Exception g;
    @GuardedBy("mLock")
    public boolean h;

    public dj4(int i, wj4<Void> wj4) {
        this.b = i;
        this.c = wj4;
    }

    @GuardedBy("mLock")
    public final void a() {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.f;
        int i4 = this.b;
        if (i + i2 + i3 != i4) {
            return;
        }
        if (this.g != null) {
            wj4<Void> wj4 = this.c;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i2);
            sb.append(" out of ");
            sb.append(i4);
            sb.append(" underlying tasks failed");
            wj4.u(new ExecutionException(sb.toString(), this.g));
        } else if (this.h) {
            this.c.v();
        } else {
            this.c.t(null);
        }
    }

    @Override // defpackage.si4
    public final void onCanceled() {
        synchronized (this.f846a) {
            this.f++;
            this.h = true;
            a();
        }
    }

    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        synchronized (this.f846a) {
            this.e++;
            this.g = exc;
            a();
        }
    }

    @Override // defpackage.vi4
    public final void onSuccess(Object obj) {
        synchronized (this.f846a) {
            this.d++;
            a();
        }
    }
}
