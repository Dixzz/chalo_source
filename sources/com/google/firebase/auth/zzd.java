package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzd implements Parcelable.Creator<PhoneAuthProvider.ForceResendingToken> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PhoneAuthProvider.ForceResendingToken createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        while (parcel.dataPosition() < r0) {
            gj1.p0(parcel, parcel.readInt());
        }
        gj1.F(parcel, r0);
        return new PhoneAuthProvider.ForceResendingToken();
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PhoneAuthProvider.ForceResendingToken[] newArray(int i) {
        return new PhoneAuthProvider.ForceResendingToken[i];
    }
}
