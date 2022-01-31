package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: kd2  reason: default package */
public final class kd2 implements id2, IInterface {
    public final IBinder f;
    public final String g = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public kd2(IBinder iBinder) {
        this.f = iBinder;
    }

    public final Parcel C() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        return obtain;
    }

    public final Parcel F(int i, Parcel parcel) {
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

    @Override // defpackage.id2
    public final boolean W0(boolean z) throws RemoteException {
        Parcel C = C();
        int i = hd2.f1359a;
        boolean z2 = true;
        C.writeInt(1);
        Parcel F = F(2, C);
        if (F.readInt() == 0) {
            z2 = false;
        }
        F.recycle();
        return z2;
    }

    public IBinder asBinder() {
        return this.f;
    }

    @Override // defpackage.id2
    public final String getId() throws RemoteException {
        Parcel F = F(1, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }

    @Override // defpackage.id2
    public final boolean zzc() throws RemoteException {
        Parcel F = F(6, C());
        int i = hd2.f1359a;
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }
}
