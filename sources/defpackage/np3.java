package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: np3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class np3 extends oo3.b {
    public final /* synthetic */ d24 j;
    public final /* synthetic */ int k;
    public final /* synthetic */ oo3 l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public np3(oo3 oo3, d24 d24, int i) {
        super(true);
        this.l = oo3;
        this.j = d24;
        this.k = i;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.l.h.getTestFlag(this.j, this.k);
    }

    @Override // defpackage.oo3.b
    public final void b() {
        this.j.zza(null);
    }
}
