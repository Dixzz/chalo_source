package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: yn3  reason: default package */
public interface yn3 extends IInterface {
    float A() throws RemoteException;

    void D1(float f) throws RemoteException;

    void H0(LatLngBounds latLngBounds) throws RemoteException;

    LatLng M() throws RemoteException;

    void T(ic2 ic2) throws RemoteException;

    LatLngBounds Y() throws RemoteException;

    void a(float f) throws RemoteException;

    int b() throws RemoteException;

    ic2 c() throws RemoteException;

    float d() throws RemoteException;

    boolean d2(yn3 yn3) throws RemoteException;

    void e(ic2 ic2) throws RemoteException;

    float f3() throws RemoteException;

    boolean g() throws RemoteException;

    float getHeight() throws RemoteException;

    String getId() throws RemoteException;

    void i(boolean z) throws RemoteException;

    boolean isVisible() throws RemoteException;

    float k() throws RemoteException;

    void l2(float f, float f2) throws RemoteException;

    void n1(float f) throws RemoteException;

    void r(float f) throws RemoteException;

    void remove() throws RemoteException;

    void s(LatLng latLng) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;
}
