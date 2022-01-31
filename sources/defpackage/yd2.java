package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: yd2  reason: default package */
public class yd2 implements IInterface {
    public final IBinder f;
    public final String g;

    public yd2(IBinder iBinder, String str) {
        this.f = iBinder;
        this.g = str;
    }

    public final void C(int i, Parcel parcel) throws RemoteException {
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
