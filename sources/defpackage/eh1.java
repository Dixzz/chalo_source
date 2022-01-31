package defpackage;

import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import defpackage.e44;
import java.util.Objects;

/* renamed from: eh1  reason: default package */
/* compiled from: MapUtils */
public class eh1 implements e44.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e44 f973a;
    public final /* synthetic */ LatLng b;
    public final /* synthetic */ float c;

    public eh1(e44 e44, LatLng latLng, float f) {
        this.f973a = e44;
        this.b = latLng;
        this.c = f;
    }

    @Override // defpackage.e44.g
    public void a() {
        e44 e44 = this.f973a;
        try {
            ic2 j2 = hd3.Z3().j2(CameraPosition.fromLatLngZoom(this.b, this.c));
            Objects.requireNonNull(j2, "null reference");
            try {
                e44.f924a.P0(j2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
