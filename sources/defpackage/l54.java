package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;

/* renamed from: l54  reason: default package */
public final class l54 extends kn3 implements m44 {
    public l54(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
    }

    @Override // defpackage.m44
    public final void I() throws RemoteException {
        L(7, C());
    }

    @Override // defpackage.m44
    public final void K(Bundle bundle) throws RemoteException {
        Parcel C = C();
        sn3.c(C, bundle);
        L(3, C);
    }

    @Override // defpackage.m44
    public final void Q2(v44 v44) throws RemoteException {
        Parcel C = C();
        sn3.b(C, v44);
        L(12, C);
    }

    @Override // defpackage.m44
    public final void S0(ic2 ic2, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        sn3.c(C, googleMapOptions);
        sn3.c(C, bundle);
        L(2, C);
    }

    @Override // defpackage.m44
    public final ic2 Z0(ic2 ic2, ic2 ic22, Bundle bundle) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        sn3.b(C, ic22);
        sn3.c(C, bundle);
        return hj1.n(F(4, C));
    }

    @Override // defpackage.m44
    public final void l() throws RemoteException {
        L(8, C());
    }

    @Override // defpackage.m44
    public final void m() throws RemoteException {
        L(16, C());
    }

    @Override // defpackage.m44
    public final void n() throws RemoteException {
        L(15, C());
    }

    @Override // defpackage.m44
    public final void onLowMemory() throws RemoteException {
        L(9, C());
    }

    @Override // defpackage.m44
    public final void u() throws RemoteException {
        L(5, C());
    }

    @Override // defpackage.m44
    public final void w() throws RemoteException {
        L(6, C());
    }

    @Override // defpackage.m44
    public final void z(Bundle bundle) throws RemoteException {
        Parcel C = C();
        sn3.c(C, bundle);
        Parcel F = F(10, C);
        if (F.readInt() != 0) {
            bundle.readFromParcel(F);
        }
        F.recycle();
    }
}
