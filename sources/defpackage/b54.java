package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: b54  reason: default package */
public final class b54 extends kn3 implements o44 {
    public b54(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // defpackage.o44
    public final void A1(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(1, C);
    }

    @Override // defpackage.o44
    public final void G1(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(7, C);
    }

    @Override // defpackage.o44
    public final void g2(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(18, C);
    }

    @Override // defpackage.o44
    public final void j0(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(3, C);
    }

    @Override // defpackage.o44
    public final void k0(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(2, C);
    }

    @Override // defpackage.o44
    public final void m2(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(8, C);
    }
}
