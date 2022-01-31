package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a32;

/* renamed from: a72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class a72 implements a32.b, a32.c {
    public final x22<?> f;
    public final boolean g;
    public b72 h;

    public a72(x22<?> x22, boolean z) {
        this.f = x22;
        this.g = z;
    }

    @Override // defpackage.n32
    public final void C(int i) {
        a().C(i);
    }

    @Override // defpackage.w32
    public final void F(ConnectionResult connectionResult) {
        a().C1(connectionResult, this.f, this.g);
    }

    @Override // defpackage.n32
    public final void L(Bundle bundle) {
        a().L(bundle);
    }

    public final b72 a() {
        gj1.l(this.h, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.h;
    }
}
