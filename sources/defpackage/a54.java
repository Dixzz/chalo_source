package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* renamed from: a54  reason: default package */
public final class a54 extends kn3 implements n44 {
    public a54(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    @Override // defpackage.n44
    public final ic2 L0(LatLng latLng) throws RemoteException {
        Parcel C = C();
        sn3.c(C, latLng);
        return hj1.n(F(2, C));
    }

    @Override // defpackage.n44
    public final LatLng M2(ic2 ic2) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        Parcel F = F(1, C);
        LatLng latLng = (LatLng) sn3.a(F, LatLng.CREATOR);
        F.recycle();
        return latLng;
    }

    @Override // defpackage.n44
    public final VisibleRegion c1() throws RemoteException {
        Parcel F = F(3, C());
        VisibleRegion visibleRegion = (VisibleRegion) sn3.a(F, VisibleRegion.CREATOR);
        F.recycle();
        return visibleRegion;
    }
}
