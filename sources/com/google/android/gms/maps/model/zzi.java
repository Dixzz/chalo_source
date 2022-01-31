package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzi implements Parcelable.Creator<PatternItem> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PatternItem createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        Float f = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                f = gj1.e0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new PatternItem(i, f);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PatternItem[] newArray(int i) {
        return new PatternItem[i];
    }
}
