package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: lp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class lp3 extends oo3.b {
    public final /* synthetic */ String j;
    public final /* synthetic */ d24 k;
    public final /* synthetic */ oo3 l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lp3(oo3 oo3, String str, d24 d24) {
        super(true);
        this.l = oo3;
        this.j = str;
        this.k = d24;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.l.h.getMaxUserProperties(this.j, this.k);
    }

    @Override // defpackage.oo3.b
    public final void b() {
        this.k.zza(null);
    }
}
