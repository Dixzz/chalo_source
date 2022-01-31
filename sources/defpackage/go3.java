package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

/* renamed from: go3  reason: default package */
public interface go3 extends IInterface {
    boolean A3(go3 go3) throws RemoteException;

    void B(List<PatternItem> list) throws RemoteException;

    int B1() throws RemoteException;

    boolean D() throws RemoteException;

    List<PatternItem> E() throws RemoteException;

    void G(int i) throws RemoteException;

    void H(float f) throws RemoteException;

    float J() throws RemoteException;

    void N(int i) throws RemoteException;

    void a(float f) throws RemoteException;

    List a1() throws RemoteException;

    int b() throws RemoteException;

    ic2 c() throws RemoteException;

    float d() throws RemoteException;

    void e(ic2 ic2) throws RemoteException;

    boolean g() throws RemoteException;

    String getId() throws RemoteException;

    void i(boolean z) throws RemoteException;

    boolean isVisible() throws RemoteException;

    int o() throws RemoteException;

    int p() throws RemoteException;

    void q(int i) throws RemoteException;

    void remove() throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    List<LatLng> t() throws RemoteException;

    void v(boolean z) throws RemoteException;

    void w0(List list) throws RemoteException;

    void y(List<LatLng> list) throws RemoteException;
}
