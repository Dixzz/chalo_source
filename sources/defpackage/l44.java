package defpackage;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/* renamed from: l44  reason: default package */
public interface l44 extends IInterface {
    n44 B2() throws RemoteException;

    do3 D3(MarkerOptions markerOptions) throws RemoteException;

    Location H3() throws RemoteException;

    void I2(ic2 ic2) throws RemoteException;

    void P0(ic2 ic2) throws RemoteException;

    CameraPosition Q0() throws RemoteException;

    boolean T0(MapStyleOptions mapStyleOptions) throws RemoteException;

    void T2(r44 r44) throws RemoteException;

    ho3 U2(PolylineOptions polylineOptions) throws RemoteException;

    o44 c2() throws RemoteException;

    void d1(p44 p44) throws RemoteException;

    void d3(boolean z) throws RemoteException;

    void e3(j54 j54) throws RemoteException;

    void k3(x44 x44) throws RemoteException;

    void l0(m54 m54) throws RemoteException;

    void u0(t44 t44) throws RemoteException;

    void u1(ic2 ic2, int i, e54 e54) throws RemoteException;

    void z0(int i, int i2, int i3, int i4) throws RemoteException;

    void z2(o54 o54) throws RemoteException;
}
