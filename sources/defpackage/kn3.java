package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: kn3  reason: default package */
public class kn3 implements IInterface {
    public final IBinder f;
    public final String g;

    public kn3(IBinder iBinder, String str) {
        this.f = iBinder;
        this.g = str;
    }

    public final Parcel C() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        return obtain;
    }

    public final Parcel F(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    public final void L(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f;
    }
}
