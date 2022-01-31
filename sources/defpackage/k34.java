package defpackage;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationResult;
import java.util.List;

/* renamed from: k34  reason: default package */
public final class k34 implements Parcelable.Creator<LocationResult> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LocationResult createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        List<Location> list = LocationResult.g;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                list = gj1.B(parcel, readInt, Location.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new LocationResult(list);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}
