package defpackage;

import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: u44  reason: default package */
public abstract class u44 extends rn3 implements t44 {
    public u44() {
        super("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((x54) this).f.a();
        parcel2.writeNoException();
        return true;
    }
}
