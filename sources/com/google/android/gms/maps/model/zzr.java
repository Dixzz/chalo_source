package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzr implements Parcelable.Creator<Tile> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Tile createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 3) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                bArr = gj1.t(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Tile(i, i2, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i) {
        return new Tile[i];
    }
}
