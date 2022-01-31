package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzaa implements Parcelable.Creator<zzz> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzz createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                j = gj1.h0(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                j2 = gj1.h0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzz(j, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
