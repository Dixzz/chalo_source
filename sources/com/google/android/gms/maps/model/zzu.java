package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzu implements Parcelable.Creator<TileOverlayOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TileOverlayOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        IBinder iBinder = null;
        boolean z = false;
        float f = 0.0f;
        boolean z2 = true;
        float f2 = 0.0f;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                iBinder = gj1.f0(parcel, readInt);
            } else if (c == 3) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 4) {
                f = gj1.d0(parcel, readInt);
            } else if (c == 5) {
                z2 = gj1.Z(parcel, readInt);
            } else if (c != 6) {
                gj1.p0(parcel, readInt);
            } else {
                f2 = gj1.d0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new TileOverlayOptions(iBinder, z, f, z2, f2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
