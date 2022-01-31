package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzf implements Parcelable.Creator<zzg> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzg createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzg(i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzg[] newArray(int i) {
        return new zzg[i];
    }
}
