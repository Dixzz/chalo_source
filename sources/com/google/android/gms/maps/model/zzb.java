package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzb implements Parcelable.Creator<Cap> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Cap createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        IBinder iBinder = null;
        Float f = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 3) {
                iBinder = gj1.f0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                f = gj1.e0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Cap(i, iBinder, f);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Cap[] newArray(int i) {
        return new Cap[i];
    }
}
