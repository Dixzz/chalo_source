package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: rp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class rp3 extends oo3.b {
    public final /* synthetic */ oo3.d j;
    public final /* synthetic */ oo3 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rp3(oo3 oo3, oo3.d dVar) {
        super(true);
        this.k = oo3;
        this.j = dVar;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.k.h.unregisterOnMeasurementEventListener(this.j);
    }
}
