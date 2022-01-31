package defpackage;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.location.GeofencingRequest;

/* renamed from: bm3  reason: default package */
public final class bm3 extends dm3 {
    public final /* synthetic */ GeofencingRequest q;
    public final /* synthetic */ PendingIntent r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bm3(a32 a32, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        super(a32);
        this.q = geofencingRequest;
        this.r = pendingIntent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(sm3 sm3) throws RemoteException {
        sm3 sm32 = sm3;
        GeofencingRequest geofencingRequest = this.q;
        PendingIntent pendingIntent = this.r;
        sm32.checkConnected();
        gj1.l(geofencingRequest, "geofencingRequest can't be null.");
        gj1.l(pendingIntent, "PendingIntent must be specified.");
        gj1.l(this, "ResultHolder not provided.");
        ((jm3) sm32.getService()).C3(geofencingRequest, pendingIntent, new um3(this));
    }
}
