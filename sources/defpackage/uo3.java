package defpackage;

import android.app.Activity;
import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: uo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class uo3 extends oo3.b {
    public final /* synthetic */ Activity j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ oo3 m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uo3(oo3 oo3, Activity activity, String str, String str2) {
        super(true);
        this.m = oo3;
        this.j = activity;
        this.k = str;
        this.l = str2;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        this.m.h.setCurrentScreen(new kc2(this.j), this.k, this.l, this.f);
    }
}
