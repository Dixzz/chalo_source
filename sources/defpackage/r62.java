package defpackage;

import com.google.android.gms.common.ConnectionResult;
import defpackage.a32;

/* renamed from: r62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class r62 implements a32.c {
    public final int f;
    public final a32 g;
    public final a32.c h;
    public final /* synthetic */ s62 i;

    public r62(s62 s62, int i2, a32 a32, a32.c cVar) {
        this.i = s62;
        this.f = i2;
        this.g = a32;
        this.h = cVar;
    }

    @Override // defpackage.w32
    public final void F(ConnectionResult connectionResult) {
        String.valueOf(connectionResult).length();
        this.i.n(connectionResult, this.f);
    }
}
