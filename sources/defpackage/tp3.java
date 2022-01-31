package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: tp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class tp3 extends oo3.b {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ oo3 n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tp3(oo3 oo3, String str, String str2, Object obj, boolean z) {
        super(true);
        this.n = oo3;
        this.j = str;
        this.k = str2;
        this.l = obj;
        this.m = z;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.n.h.setUserProperty(this.j, this.k, new kc2(this.l), this.m, this.f);
    }
}
