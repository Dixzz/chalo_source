package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: jo3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class jo3 extends mq3 implements ko3 {
    public jo3() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // defpackage.mq3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            a2(parcel.readString(), parcel.readString(), (Bundle) hp3.a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else if (i != 2) {
            return false;
        } else {
            int zza = zza();
            parcel2.writeNoException();
            parcel2.writeInt(zza);
        }
        return true;
    }
}
