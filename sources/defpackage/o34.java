package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;

/* renamed from: o34  reason: default package */
public final class o34 implements Parcelable.Creator<LocationSettingsResult> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LocationSettingsResult createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                status = (Status) gj1.w(parcel, readInt, Status.CREATOR);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                locationSettingsStates = (LocationSettingsStates) gj1.w(parcel, readInt, LocationSettingsStates.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
