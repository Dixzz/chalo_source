package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzv implements Parcelable.Creator<VisibleRegion> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final VisibleRegion createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                latLng = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            } else if (c == 3) {
                latLng2 = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            } else if (c == 4) {
                latLng3 = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            } else if (c == 5) {
                latLng4 = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            } else if (c != 6) {
                gj1.p0(parcel, readInt);
            } else {
                latLngBounds = (LatLngBounds) gj1.w(parcel, readInt, LatLngBounds.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
