package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: kl2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class kl2 implements IInterface {
    public final IBinder f;
    public final String g;

    public kl2(IBinder iBinder, String str) {
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

    public final void F(int i, Parcel parcel) throws RemoteException {
        try {
            this.f.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel L() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f;
    }
}
