package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzh implements Parcelable.Creator<MarkerOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final MarkerOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    latLng = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    str = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    iBinder = gj1.f0(parcel, readInt);
                    break;
                case 6:
                    f = gj1.d0(parcel, readInt);
                    break;
                case 7:
                    f2 = gj1.d0(parcel, readInt);
                    break;
                case '\b':
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\t':
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\n':
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case 11:
                    f3 = gj1.d0(parcel, readInt);
                    break;
                case '\f':
                    f4 = gj1.d0(parcel, readInt);
                    break;
                case '\r':
                    f5 = gj1.d0(parcel, readInt);
                    break;
                case 14:
                    f6 = gj1.d0(parcel, readInt);
                    break;
                case 15:
                    f7 = gj1.d0(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new MarkerOptions(latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6, f7);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
