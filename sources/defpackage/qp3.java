package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: qp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class qp3 extends oo3.b {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ oo3 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qp3(oo3 oo3, boolean z) {
        super(true);
        this.k = oo3;
        this.j = z;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.k.h.setDataCollectionEnabled(this.j);
    }
}
