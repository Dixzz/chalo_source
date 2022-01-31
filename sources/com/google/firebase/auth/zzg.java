package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzg implements Parcelable.Creator<EmailAuthCredential> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final EmailAuthCredential createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                str2 = gj1.x(parcel, readInt);
            } else if (c == 3) {
                str3 = gj1.x(parcel, readInt);
            } else if (c == 4) {
                str4 = gj1.x(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                z = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new EmailAuthCredential(str, str2, str3, str4, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ EmailAuthCredential[] newArray(int i) {
        return new EmailAuthCredential[i];
    }
}
