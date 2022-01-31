package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: k44  reason: default package */
public interface k44 extends IInterface {
    ic2 G0(LatLng latLng) throws RemoteException;

    ic2 Q(LatLngBounds latLngBounds, int i) throws RemoteException;

    ic2 h3(LatLng latLng, float f) throws RemoteException;

    ic2 j2(CameraPosition cameraPosition) throws RemoteException;
}
