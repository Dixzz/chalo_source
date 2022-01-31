package defpackage;

import android.os.Handler;
import android.os.Looper;

/* renamed from: xf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class xf4 extends bc4 {
    public Handler c;
    public final gg4 d = new gg4(this);
    public final eg4 e = new eg4(this);
    public final yf4 f = new yf4(this);

    public xf4(vb4 vb4) {
        super(vb4);
    }

    @Override // defpackage.bc4
    public final boolean u() {
        return false;
    }

    public final boolean v(boolean z, boolean z2, long j) {
        return this.e.a(z, z2, j);
    }

    public final void w() {
        b();
        if (this.c == null) {
            this.c = new c24(Looper.getMainLooper());
        }
    }
}
