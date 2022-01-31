package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzf implements Parcelable.Creator<LatLng> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final LatLng createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                d = gj1.c0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                d2 = gj1.c0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new LatLng(d, d2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
