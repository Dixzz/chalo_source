package defpackage;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/* renamed from: i54  reason: default package */
public final class i54 extends kn3 implements l44 {
    public i54(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // defpackage.l44
    public final n44 B2() throws RemoteException {
        n44 n44;
        Parcel F = F(26, C());
        IBinder readStrongBinder = F.readStrongBinder();
        if (readStrongBinder == null) {
            n44 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (queryLocalInterface instanceof n44) {
                n44 = (n44) queryLocalInterface;
            } else {
                n44 = new a54(readStrongBinder);
            }
        }
        F.recycle();
        return n44;
    }

    @Override // defpackage.l44
    public final do3 D3(MarkerOptions markerOptions) throws RemoteException {
        Parcel C = C();
        sn3.c(C, markerOptions);
        Parcel F = F(11, C);
        do3 C2 = eo3.C(F.readStrongBinder());
        F.recycle();
        return C2;
    }

    @Override // defpackage.l44
    public final Location H3() throws RemoteException {
        Parcel F = F(23, C());
        Location location = (Location) sn3.a(F, Location.CREATOR);
        F.recycle();
        return location;
    }

    @Override // defpackage.l44
    public final void I2(ic2 ic2) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        L(5, C);
    }

    @Override // defpackage.l44
    public final void P0(ic2 ic2) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        L(4, C);
    }

    @Override // defpackage.l44
    public final CameraPosition Q0() throws RemoteException {
        Parcel F = F(1, C());
        CameraPosition cameraPosition = (CameraPosition) sn3.a(F, CameraPosition.CREATOR);
        F.recycle();
        return cameraPosition;
    }

    @Override // defpackage.l44
    public final boolean T0(MapStyleOptions mapStyleOptions) throws RemoteException {
        Parcel C = C();
        sn3.c(C, mapStyleOptions);
        Parcel F = F(91, C);
        boolean z = F.readInt() != 0;
        F.recycle();
        return z;
    }

    @Override // defpackage.l44
    public final void T2(r44 r44) throws RemoteException {
        Parcel C = C();
        sn3.b(C, r44);
        L(86, C);
    }

    @Override // defpackage.l44
    public final ho3 U2(PolylineOptions polylineOptions) throws RemoteException {
        ho3 ho3;
        Parcel C = C();
        sn3.c(C, polylineOptions);
        Parcel F = F(9, C);
        IBinder readStrongBinder = F.readStrongBinder();
        int i = ln3.f;
        if (readStrongBinder == null) {
            ho3 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            if (queryLocalInterface instanceof ho3) {
                ho3 = (ho3) queryLocalInterface;
            } else {
                ho3 = new mn3(readStrongBinder);
            }
        }
        F.recycle();
        return ho3;
    }

    @Override // defpackage.l44
    public final o44 c2() throws RemoteException {
        o44 o44;
        Parcel F = F(25, C());
        IBinder readStrongBinder = F.readStrongBinder();
        if (readStrongBinder == null) {
            o44 = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            if (queryLocalInterface instanceof o44) {
                o44 = (o44) queryLocalInterface;
            } else {
                o44 = new b54(readStrongBinder);
            }
        }
        F.recycle();
        return o44;
    }

    @Override // defpackage.l44
    public final void d1(p44 p44) throws RemoteException {
        Parcel C = C();
        sn3.b(C, p44);
        L(32, C);
    }

    @Override // defpackage.l44
    public final void d3(boolean z) throws RemoteException {
        Parcel C = C();
        int i = sn3.f3230a;
        C.writeInt(z ? 1 : 0);
        L(22, C);
    }

    @Override // defpackage.l44
    public final void e3(j54 j54) throws RemoteException {
        Parcel C = C();
        sn3.b(C, j54);
        L(33, C);
    }

    @Override // defpackage.l44
    public final void k3(x44 x44) throws RemoteException {
        Parcel C = C();
        sn3.b(C, x44);
        L(30, C);
    }

    @Override // defpackage.l44
    public final void l0(m54 m54) throws RemoteException {
        Parcel C = C();
        sn3.b(C, m54);
        L(27, C);
    }

    @Override // defpackage.l44
    public final void u0(t44 t44) throws RemoteException {
        Parcel C = C();
        sn3.b(C, t44);
        L(42, C);
    }

    @Override // defpackage.l44
    public final void u1(ic2 ic2, int i, e54 e54) throws RemoteException {
        Parcel C = C();
        sn3.b(C, ic2);
        C.writeInt(i);
        sn3.b(C, e54);
        L(7, C);
    }

    @Override // defpackage.l44
    public final void z0(int i, int i2, int i3, int i4) throws RemoteException {
        Parcel C = C();
        C.writeInt(i);
        C.writeInt(i2);
        C.writeInt(i3);
        C.writeInt(i4);
        L(39, C);
    }

    @Override // defpackage.l44
    public final void z2(o54 o54) throws RemoteException {
        Parcel C = C();
        sn3.b(C, o54);
        L(97, C);
    }
}
