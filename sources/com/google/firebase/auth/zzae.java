package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzae implements Parcelable.Creator<PhoneMultiFactorInfo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PhoneMultiFactorInfo createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                str2 = gj1.x(parcel, readInt);
            } else if (c == 3) {
                j = gj1.h0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                str3 = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new PhoneMultiFactorInfo(str, str2, j, str3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PhoneMultiFactorInfo[] newArray(int i) {
        return new PhoneMultiFactorInfo[i];
    }
}
