package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzah implements Parcelable.Creator<UserProfileChangeRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final UserProfileChangeRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        boolean z = false;
        String str = null;
        String str2 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                str2 = gj1.x(parcel, readInt);
            } else if (c == 4) {
                z = gj1.Z(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                z2 = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new UserProfileChangeRequest(str, str2, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ UserProfileChangeRequest[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }
}
