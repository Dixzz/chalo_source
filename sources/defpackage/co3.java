package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: co3  reason: default package */
public final class co3 extends kn3 implements ao3 {
    public co3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    @Override // defpackage.ao3
    public final boolean N0(ao3 ao3) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ao3);
        Parcel F = F(4, C);
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.ao3
    public final String U() throws RemoteException {
        Parcel F = F(2, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }

    @Override // defpackage.ao3
    public final int b() throws RemoteException {
        Parcel F = F(5, C());
        int readInt = F.readInt();
        F.recycle();
        return readInt;
    }

    @Override // defpackage.ao3
    public final void b2() throws RemoteException {
        L(3, C());
    }

    @Override // defpackage.ao3
    public final String getName() throws RemoteException {
        Parcel F = F(1, C());
        String readString = F.readString();
        F.recycle();
        return readString;
    }
}
