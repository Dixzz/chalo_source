package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Marker;

/* renamed from: k54  reason: default package */
public abstract class k54 extends rn3 implements j54 {
    public k54() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            kc2 kc2 = new kc2(((w54) this).f.d(new Marker(eo3.C(parcel.readStrongBinder()))));
            parcel2.writeNoException();
            sn3.b(parcel2, kc2);
        } else if (i != 2) {
            return false;
        } else {
            kc2 kc22 = new kc2(((w54) this).f.b(new Marker(eo3.C(parcel.readStrongBinder()))));
            parcel2.writeNoException();
            sn3.b(parcel2, kc22);
        }
        return true;
    }
}
