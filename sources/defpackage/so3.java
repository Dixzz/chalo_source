package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: so3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class so3 extends oo3.b {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ d24 l;
    public final /* synthetic */ oo3 m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public so3(oo3 oo3, String str, String str2, d24 d24) {
        super(true);
        this.m = oo3;
        this.j = str;
        this.k = str2;
        this.l = d24;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.m.h.getConditionalUserProperties(this.j, this.k, this.l);
    }

    @Override // defpackage.oo3.b
    public final void b() {
        this.l.zza(null);
    }
}
