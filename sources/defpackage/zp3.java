package defpackage;

import android.app.Activity;
import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: zp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class zp3 extends oo3.b {
    public final /* synthetic */ Activity j;
    public final /* synthetic */ d24 k;
    public final /* synthetic */ oo3.c l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zp3(oo3.c cVar, Activity activity, d24 d24) {
        super(true);
        this.l = cVar;
        this.j = activity;
        this.k = d24;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        oo3.this.h.onActivitySaveInstanceState(new kc2(this.j), this.k, this.g);
    }
}
