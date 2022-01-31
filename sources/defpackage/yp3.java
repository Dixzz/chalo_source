package defpackage;

import android.app.Activity;
import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: yp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class yp3 extends oo3.b {
    public final /* synthetic */ Activity j;
    public final /* synthetic */ oo3.c k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yp3(oo3.c cVar, Activity activity) {
        super(true);
        this.k = cVar;
        this.j = activity;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        oo3.this.h.onActivityResumed(new kc2(this.j), this.g);
    }
}
