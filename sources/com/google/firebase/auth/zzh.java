package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzh implements Parcelable.Creator<FacebookAuthCredential> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final FacebookAuthCredential createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new FacebookAuthCredential(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ FacebookAuthCredential[] newArray(int i) {
        return new FacebookAuthCredential[i];
    }
}
