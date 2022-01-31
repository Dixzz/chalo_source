package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: hl2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class hl2 extends Binder implements IInterface {
    public hl2(String str) {
        attachInterface(this, str);
    }

    public boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
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
        return C(i, parcel, parcel2, i2);
    }
}
