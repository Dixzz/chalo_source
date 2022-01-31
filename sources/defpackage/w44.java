package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: w44  reason: default package */
public abstract class w44 extends rn3 implements v44 {
    public w44() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        l44 l44;
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            l44 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (queryLocalInterface instanceof l44) {
                l44 = (l44) queryLocalInterface;
            } else {
                l44 = new i54(readStrongBinder);
            }
        }
        L2(l44);
        parcel2.writeNoException();
        return true;
    }
}
