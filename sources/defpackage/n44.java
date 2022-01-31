package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* renamed from: n44  reason: default package */
public interface n44 extends IInterface {
    ic2 L0(LatLng latLng) throws RemoteException;

    LatLng M2(ic2 ic2) throws RemoteException;

    VisibleRegion c1() throws RemoteException;
}
