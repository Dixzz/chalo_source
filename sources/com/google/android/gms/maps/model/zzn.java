package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzn implements Parcelable.Creator<StreetViewPanoramaLink> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                f = gj1.d0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new StreetViewPanoramaLink(str, f);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLink[] newArray(int i) {
        return new StreetViewPanoramaLink[i];
    }
}
