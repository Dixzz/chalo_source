package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Marker;

/* renamed from: y44  reason: default package */
public abstract class y44 extends rn3 implements x44 {
    public y44() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        boolean a2 = ((t54) this).f.a(new Marker(eo3.C(parcel.readStrongBinder())));
        parcel2.writeNoException();
        int i3 = sn3.f3230a;
        parcel2.writeInt(a2 ? 1 : 0);
        return true;
    }
}
