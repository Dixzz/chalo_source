package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.appindexing.internal.Thing;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzae implements Parcelable.Creator<Thing> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Thing createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Bundle bundle = null;
        Thing.zza zza = null;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                bundle = gj1.s(parcel, readInt);
            } else if (c == 2) {
                zza = (Thing.zza) gj1.w(parcel, readInt, Thing.zza.CREATOR);
            } else if (c == 3) {
                str = gj1.x(parcel, readInt);
            } else if (c == 4) {
                str2 = gj1.x(parcel, readInt);
            } else if (c != 1000) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Thing(i, bundle, zza, str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Thing[] newArray(int i) {
        return new Thing[i];
    }
}
