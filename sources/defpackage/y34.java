package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* renamed from: y34  reason: default package */
public abstract class y34 extends tm3 implements x34 {
    public static final /* synthetic */ int f = 0;

    @Override // defpackage.tm3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            LocationResult locationResult = (LocationResult) cn3.a(parcel, LocationResult.CREATOR);
            throw null;
        } else if (i != 2) {
            return false;
        } else {
            LocationAvailability locationAvailability = (LocationAvailability) cn3.a(parcel, LocationAvailability.CREATOR);
            throw null;
        }
    }
}
