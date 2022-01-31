package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: jp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class jp3 extends oo3.b {
    public final /* synthetic */ d24 j;
    public final /* synthetic */ oo3 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jp3(oo3 oo3, d24 d24) {
        super(true);
        this.k = oo3;
        this.j = d24;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.k.h.getCurrentScreenClass(this.j);
    }

    @Override // defpackage.oo3.b
    public final void b() {
        this.j.zza(null);
    }
}
