package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.NearbyStopsActivity;
import app.zophop.ui.fragments.NearbyStopsScreenMapFragment;
import defpackage.e44;
import java.util.Objects;

/* renamed from: f54  reason: default package */
public abstract class f54 extends rn3 implements e54 {
    public f54() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ue0 ue0 = (ue0) ((e44.i) this).f;
            NearbyStopsActivity nearbyStopsActivity = ue0.f3490a;
            if (nearbyStopsActivity.E) {
                Toast.makeText(nearbyStopsActivity.getApplicationContext(), ue0.f3490a.getString(R.string.next_departure_details), 1).show();
                ue0.f3490a.E = false;
            }
            NearbyStopsActivity nearbyStopsActivity2 = ue0.f3490a;
            NearbyStopsScreenMapFragment nearbyStopsScreenMapFragment = nearbyStopsActivity2.L;
            if (nearbyStopsScreenMapFragment != null) {
                nearbyStopsScreenMapFragment.i.a(nearbyStopsActivity2.n0());
            }
        } else if (i != 2) {
            return false;
        } else {
            Objects.requireNonNull((ue0) ((e44.i) this).f);
        }
        parcel2.writeNoException();
        return true;
    }
}
