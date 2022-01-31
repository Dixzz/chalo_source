package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: j24  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class j24 extends mq3 implements g24 {
    public j24() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // defpackage.mq3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((d24) this).zza((Bundle) hp3.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
