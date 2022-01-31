package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: od2  reason: default package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
public final class od2 implements pd2, IInterface {
    public final IBinder f;
    public final String g = "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";

    public od2(IBinder iBinder) {
        this.f = iBinder;
    }

    public final void C(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    @Override // defpackage.pd2
    public final void W1(rd2 rd2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        int i = nd2.f2541a;
        obtain.writeStrongBinder((ld2) rd2);
        C(1, obtain);
    }

    public IBinder asBinder() {
        return this.f;
    }

    @Override // defpackage.pd2
    public final void m1(String str, rd2 rd2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        obtain.writeString(str);
        int i = nd2.f2541a;
        obtain.writeStrongBinder((ld2) rd2);
        C(2, obtain);
    }
}
