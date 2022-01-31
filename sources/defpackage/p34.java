package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationSettingsStates;

/* renamed from: p34  reason: default package */
public final class p34 implements Parcelable.Creator<LocationSettingsStates> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LocationSettingsStates createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 2:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 3:
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case 4:
                    z4 = gj1.Z(parcel, readInt);
                    break;
                case 5:
                    z5 = gj1.Z(parcel, readInt);
                    break;
                case 6:
                    z6 = gj1.Z(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new LocationSettingsStates(z, z2, z3, z4, z5, z6);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsStates[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
