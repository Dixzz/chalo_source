package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzaa implements Parcelable.Creator<GoogleAuthCredential> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleAuthCredential createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str2 = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new GoogleAuthCredential(str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleAuthCredential[] newArray(int i) {
        return new GoogleAuthCredential[i];
    }
}
