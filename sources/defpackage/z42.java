package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.a32;

/* renamed from: z42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class z42 implements a32.c {
    public final /* synthetic */ c42 f;

    public z42(c42 c42) {
        this.f = c42;
    }

    @Override // defpackage.w32
    public final void F(ConnectionResult connectionResult) {
        this.f.setResult(new Status(8, null));
    }
}
