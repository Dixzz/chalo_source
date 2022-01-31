package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: z44  reason: default package */
public final class z44 extends kn3 implements k44 {
    public z44(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    @Override // defpackage.k44
    public final ic2 G0(LatLng latLng) throws RemoteException {
        Parcel C = C();
        sn3.c(C, latLng);
        return hj1.n(F(8, C));
    }

    @Override // defpackage.k44
    public final ic2 Q(LatLngBounds latLngBounds, int i) throws RemoteException {
        Parcel C = C();
        sn3.c(C, latLngBounds);
        C.writeInt(i);
        return hj1.n(F(10, C));
    }

    @Override // defpackage.k44
    public final ic2 h3(LatLng latLng, float f) throws RemoteException {
        Parcel C = C();
        sn3.c(C, latLng);
        C.writeFloat(f);
        return hj1.n(F(9, C));
    }

    @Override // defpackage.k44
    public final ic2 j2(CameraPosition cameraPosition) throws RemoteException {
        Parcel C = C();
        sn3.c(C, cameraPosition);
        return hj1.n(F(7, C));
    }
}
