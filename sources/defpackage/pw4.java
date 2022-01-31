package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: pw4  reason: default package */
public class pw4 extends Binder implements IInterface {
    public pw4(String str) {
        attachInterface(this, str);
    }

    public boolean C(int i, Parcel parcel) throws RemoteException {
        throw null;
    }

    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return C(i, parcel);
    }
}
