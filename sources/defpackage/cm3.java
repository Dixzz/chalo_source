package defpackage;

import android.os.RemoteException;
import com.google.android.gms.location.zzal;

/* renamed from: cm3  reason: default package */
public final class cm3 extends dm3 {
    public final /* synthetic */ zzal q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cm3(a32 a32, zzal zzal) {
        super(a32);
        this.q = zzal;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(sm3 sm3) throws RemoteException {
        sm3 sm32 = sm3;
        zzal zzal = this.q;
        sm32.checkConnected();
        gj1.l(zzal, "removeGeofencingRequest can't be null.");
        gj1.l(this, "ResultHolder not provided.");
        ((jm3) sm32.getService()).U1(zzal, new vm3(this));
    }
}
