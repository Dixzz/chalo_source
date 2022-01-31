package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;

/* renamed from: j34  reason: default package */
public final class j34 implements Parcelable.Creator<LocationRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LocationRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i = 102;
        boolean z = false;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 3:
                    j2 = gj1.h0(parcel, readInt);
                    break;
                case 4:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 5:
                    j3 = gj1.h0(parcel, readInt);
                    break;
                case 6:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case 7:
                    f = gj1.d0(parcel, readInt);
                    break;
                case '\b':
                    j4 = gj1.h0(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new LocationRequest(i, j, j2, z, j3, i2, f, j4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
