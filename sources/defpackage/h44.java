package defpackage;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: h44  reason: default package */
public final class h44 {

    /* renamed from: a  reason: collision with root package name */
    public final n44 f1339a;

    public h44(n44 n44) {
        this.f1339a = n44;
    }

    public final Point a(LatLng latLng) {
        try {
            return (Point) kc2.L(this.f1339a.L0(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
