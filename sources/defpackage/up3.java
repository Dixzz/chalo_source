package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: up3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class up3 extends oo3.b {
    public final /* synthetic */ Long j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ Bundle m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ boolean o;
    public final /* synthetic */ oo3 p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public up3(oo3 oo3, Long l2, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(true);
        this.p = oo3;
        this.j = l2;
        this.k = str;
        this.l = str2;
        this.m = bundle;
        this.n = z;
        this.o = z2;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        Long l2 = this.j;
        this.p.h.logEvent(this.k, this.l, this.m, this.n, this.o, l2 == null ? this.f : l2.longValue());
    }
}
