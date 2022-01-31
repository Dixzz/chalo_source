package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: u24  reason: default package */
public final class u24 implements t24, IInterface {
    public final IBinder f;
    public final String g = "com.google.android.gms.safetynet.internal.ISafetyNetService";

    public u24(IBinder iBinder) {
        this.f = iBinder;
    }

    @Override // defpackage.t24
    public final void C0(r24 r24, byte[] bArr, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        int i = o24.f2636a;
        obtain.writeStrongBinder(r24 == null ? null : (n24) r24);
        obtain.writeByteArray(bArr);
        obtain.writeString(str);
        Parcel obtain2 = Parcel.obtain();
        try {
            this.f.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f;
    }
}
