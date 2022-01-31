package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: xo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class xo3 extends oo3.b {
    public final /* synthetic */ oo3 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xo3(oo3 oo3) {
        super(true);
        this.j = oo3;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.j.h.resetAnalyticsData(this.f);
    }
}
