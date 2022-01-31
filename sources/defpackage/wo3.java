package defpackage;

import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: wo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class wo3 extends oo3.b {
    public final /* synthetic */ Boolean j;
    public final /* synthetic */ oo3 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wo3(oo3 oo3, Boolean bool) {
        super(true);
        this.k = oo3;
        this.j = bool;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        if (this.j != null) {
            this.k.h.setMeasurementEnabled(this.j.booleanValue(), this.f);
        } else {
            this.k.h.clearMeasurementEnabled(this.f);
        }
    }
}
