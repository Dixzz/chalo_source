package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzo implements Parcelable.Creator<StreetViewPanoramaLocation> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        LatLng latLng = null;
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) gj1.A(parcel, readInt, StreetViewPanoramaLink.CREATOR);
            } else if (c == 3) {
                latLng = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new StreetViewPanoramaLocation(streetViewPanoramaLinkArr, latLng, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
