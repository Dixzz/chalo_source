package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

/* renamed from: ho3  reason: default package */
public interface ho3 extends IInterface {
    boolean D() throws RemoteException;

    void K0(Cap cap) throws RemoteException;

    void V2(Cap cap) throws RemoteException;

    boolean Y0(ho3 ho3) throws RemoteException;

    void a(float f) throws RemoteException;

    int b() throws RemoteException;

    ic2 c() throws RemoteException;

    float d() throws RemoteException;

    void e(ic2 ic2) throws RemoteException;

    List<PatternItem> e1() throws RemoteException;

    boolean g() throws RemoteException;

    String getId() throws RemoteException;

    void i(boolean z) throws RemoteException;

    void i0(List<PatternItem> list) throws RemoteException;

    boolean isVisible() throws RemoteException;

    float k() throws RemoteException;

    void k1(int i) throws RemoteException;

    int m3() throws RemoteException;

    void n2(int i) throws RemoteException;

    void remove() throws RemoteException;

    void s2(float f) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    List<LatLng> t() throws RemoteException;

    Cap u3() throws RemoteException;

    void v(boolean z) throws RemoteException;

    Cap v0() throws RemoteException;

    void y(List<LatLng> list) throws RemoteException;

    int y1() throws RemoteException;
}
