package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Marker;

/* renamed from: s44  reason: default package */
public abstract class s44 extends rn3 implements r44 {
    public s44() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((v54) this).f.c(new Marker(eo3.C(parcel.readStrongBinder())));
        parcel2.writeNoException();
        return true;
    }
}
