package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.appindexing.internal.Thing;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzw implements Parcelable.Creator<Thing.zza> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Thing.zza createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        Bundle bundle = null;
        boolean z = false;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 3) {
                str = gj1.x(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                bundle = gj1.s(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Thing.zza(z, i, str, bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Thing.zza[] newArray(int i) {
        return new Thing.zza[i];
    }
}
