package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: kp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class kp3 extends oo3.b {
    public final /* synthetic */ String j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ oo3 l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kp3(oo3 oo3, String str, Object obj) {
        super(false);
        this.l = oo3;
        this.j = str;
        this.k = obj;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.l.h.logHealthData(5, this.j, new kc2(this.k), new kc2(null), new kc2(null));
    }
}
