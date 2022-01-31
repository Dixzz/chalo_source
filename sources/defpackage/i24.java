package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: i24  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class i24 extends io3 implements g24 {
    public i24(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // defpackage.g24
    public final void zza(Bundle bundle) throws RemoteException {
        Parcel C = C();
        hp3.c(C, bundle);
        L(1, C);
    }
}
