package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: gl2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class gl2 implements IInterface {
    public final IBinder f;
    public final String g;

    public gl2(IBinder iBinder, String str) {
        this.f = iBinder;
        this.g = str;
    }

    public final Parcel C(int i, Parcel parcel) throws RemoteException {
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

    public final Parcel F() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f;
    }
}
