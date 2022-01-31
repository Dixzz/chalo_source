package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a32;
import java.util.Objects;

/* renamed from: t42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class t42 implements a32.b, a32.c {
    public final /* synthetic */ v42 f;

    public /* synthetic */ t42(v42 v42) {
        this.f = v42;
    }

    @Override // defpackage.n32
    public final void C(int i) {
    }

    @Override // defpackage.w32
    public final void F(ConnectionResult connectionResult) {
        this.f.b.lock();
        try {
            if (this.f.l && !connectionResult.l1()) {
                this.f.l();
                this.f.i();
            } else {
                this.f.m(connectionResult);
            }
        } finally {
            this.f.b.unlock();
        }
    }

    @Override // defpackage.n32
    public final void L(Bundle bundle) {
        Objects.requireNonNull(this.f.r, "null reference");
        ni4 ni4 = this.f.k;
        Objects.requireNonNull(ni4, "null reference");
        ni4.e(new s42(this.f));
    }
}
