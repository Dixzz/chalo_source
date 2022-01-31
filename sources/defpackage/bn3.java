package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import defpackage.h34;

/* renamed from: bn3  reason: default package */
public final class bn3 extends h34.a<LocationSettingsResult> {
    public final /* synthetic */ LocationSettingsRequest q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bn3(a32 a32, LocationSettingsRequest locationSettingsRequest) {
        super(a32);
        this.q = locationSettingsRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ f32 d(Status status) {
        return new LocationSettingsResult(status);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(sm3 sm3) throws RemoteException {
        sm3 sm32 = sm3;
        LocationSettingsRequest locationSettingsRequest = this.q;
        sm32.checkConnected();
        gj1.c(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        gj1.c(true, "listener can't be null.");
        ((jm3) sm32.getService()).F3(locationSettingsRequest, new wm3(this), null);
    }
}
