package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzc implements Parcelable.Creator<CircleOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final CircleOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        LatLng latLng = null;
        ArrayList arrayList = null;
        double d = 0.0d;
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    latLng = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    d = gj1.c0(parcel, readInt);
                    break;
                case 4:
                    f = gj1.d0(parcel, readInt);
                    break;
                case 5:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 6:
                    i2 = gj1.g0(parcel, readInt);
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
                    arrayList = gj1.B(parcel, readInt, PatternItem.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new CircleOptions(latLng, d, f, i, i2, f2, z, z2, arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
