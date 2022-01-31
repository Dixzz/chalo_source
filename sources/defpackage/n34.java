package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzae;
import java.util.ArrayList;

/* renamed from: n34  reason: default package */
public final class n34 implements Parcelable.Creator<LocationSettingsRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LocationSettingsRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        boolean z = false;
        ArrayList arrayList = null;
        zzae zzae = null;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                arrayList = gj1.B(parcel, readInt, LocationRequest.CREATOR);
            } else if (c == 2) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 3) {
                z2 = gj1.Z(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                zzae = (zzae) gj1.w(parcel, readInt, zzae.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new LocationSettingsRequest(arrayList, z, z2, zzae);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
