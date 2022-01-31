package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzm implements Parcelable.Creator<StreetViewPanoramaCamera> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                f = gj1.d0(parcel, readInt);
            } else if (c == 3) {
                f2 = gj1.d0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                f3 = gj1.d0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new StreetViewPanoramaCamera(f, f2, f3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
