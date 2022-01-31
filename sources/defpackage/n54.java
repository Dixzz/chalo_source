package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;

/* renamed from: n54  reason: default package */
public abstract class n54 extends rn3 implements m54 {
    public n54() {
        super("com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((y54) this).f.a((CameraPosition) sn3.a(parcel, CameraPosition.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
