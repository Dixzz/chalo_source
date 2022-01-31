package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

/* renamed from: xn3  reason: default package */
public interface xn3 extends IInterface {
    boolean A0(xn3 xn3) throws RemoteException;

    void B(List<PatternItem> list) throws RemoteException;

    List<PatternItem> E() throws RemoteException;

    void G(int i) throws RemoteException;

    void H(float f) throws RemoteException;

    float J() throws RemoteException;

    double X2() throws RemoteException;

    void a(float f) throws RemoteException;

    int b() throws RemoteException;

    ic2 c() throws RemoteException;

    float d() throws RemoteException;

    void e(ic2 ic2) throws RemoteException;

    boolean g() throws RemoteException;

    void g3(double d) throws RemoteException;

    String getId() throws RemoteException;

    void i(boolean z) throws RemoteException;

    boolean isVisible() throws RemoteException;

    void l3(LatLng latLng) throws RemoteException;

    int o() throws RemoteException;

    int p() throws RemoteException;

    void q(int i) throws RemoteException;

    LatLng q0() throws RemoteException;

    void remove() throws RemoteException;

    void setVisible(boolean z) throws RemoteException;
}
