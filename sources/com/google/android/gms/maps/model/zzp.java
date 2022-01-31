package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzp implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        float f = 0.0f;
        float f2 = 0.0f;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                f = gj1.d0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                f2 = gj1.d0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new StreetViewPanoramaOrientation(f, f2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOrientation[] newArray(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
