package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.zzaj;
import com.google.firebase.appindexing.Indexable;

/* renamed from: i34  reason: default package */
public final class i34 implements Parcelable.Creator<LocationAvailability> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LocationAvailability createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        zzaj[] zzajArr = null;
        int i = Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                i3 = gj1.g0(parcel, readInt);
            } else if (c == 3) {
                j = gj1.h0(parcel, readInt);
            } else if (c == 4) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                zzajArr = (zzaj[]) gj1.A(parcel, readInt, zzaj.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new LocationAvailability(i, i2, i3, j, zzajArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
