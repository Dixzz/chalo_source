package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.zak;
import defpackage.a32;
import defpackage.x22;
import java.util.Set;

/* renamed from: i62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class i62 extends ci4 implements a32.b, a32.c {
    public static final x22.a<? extends ni4, zh4> m = mi4.c;
    public final Context f;
    public final Handler g;
    public final x22.a<? extends ni4, zh4> h;
    public final Set<Scope> i;
    public final x72 j;
    public ni4 k;
    public h62 l;

    public i62(Context context, Handler handler, x72 x72) {
        x22.a<? extends ni4, zh4> aVar = m;
        this.f = context;
        this.g = handler;
        gj1.l(x72, "ClientSettings must not be null");
        this.j = x72;
        this.i = x72.b;
        this.h = aVar;
    }

    @Override // defpackage.n32
    public final void C(int i2) {
        this.k.disconnect();
    }

    @Override // defpackage.w32
    public final void F(ConnectionResult connectionResult) {
        ((s52) this.l).b(connectionResult);
    }

    @Override // defpackage.n32
    public final void L(Bundle bundle) {
        this.k.e(this);
    }

    @Override // defpackage.ei4
    public final void x0(zak zak) {
        this.g.post(new g62(this, zak));
    }
}
