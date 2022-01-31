package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zze implements Parcelable.Creator<LatLngBounds> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LatLngBounds createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                latLng = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                latLng2 = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new LatLngBounds(latLng, latLng2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
