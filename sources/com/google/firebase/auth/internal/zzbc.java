package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbc implements Parcelable.Creator<zzbb> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzbb createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                arrayList = gj1.B(parcel, readInt, PhoneMultiFactorInfo.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzbb(arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbb[] newArray(int i) {
        return new zzbb[i];
    }
}
