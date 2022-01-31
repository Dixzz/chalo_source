package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: ow4  reason: default package */
public class ow4 implements IInterface {
    public final IBinder f;
    public final String g;

    public ow4(IBinder iBinder, String str) {
        this.f = iBinder;
        this.g = str;
    }

    public final Parcel C() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        return obtain;
    }

    public final void F(int i, Parcel parcel) throws RemoteException {
        try {
            this.f.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f;
    }
}
