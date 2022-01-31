package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: pp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class pp3 extends oo3.b {
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ oo3 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public pp3(oo3 oo3, Bundle bundle) {
        super(true);
        this.k = oo3;
        this.j = bundle;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.k.h.setDefaultEventParameters(this.j);
    }
}
