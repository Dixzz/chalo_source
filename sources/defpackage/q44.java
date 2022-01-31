package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Marker;

/* renamed from: q44  reason: default package */
public abstract class q44 extends rn3 implements p44 {
    public q44() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((u54) this).f.a(new Marker(eo3.C(parcel.readStrongBinder())));
        parcel2.writeNoException();
        return true;
    }
}
