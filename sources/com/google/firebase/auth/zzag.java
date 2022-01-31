package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzag implements Parcelable.Creator<TwitterAuthCredential> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TwitterAuthCredential createFromParcel(Parcel parcel) {
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
        return new TwitterAuthCredential(str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ TwitterAuthCredential[] newArray(int i) {
        return new TwitterAuthCredential[i];
    }
}
