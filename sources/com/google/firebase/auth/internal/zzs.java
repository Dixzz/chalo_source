package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzs implements Parcelable.Creator<zzr> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzr createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzx zzx = null;
        zzp zzp = null;
        zze zze = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                zzx = (zzx) gj1.w(parcel, readInt, zzx.CREATOR);
            } else if (c == 2) {
                zzp = (zzp) gj1.w(parcel, readInt, zzp.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                zze = (zze) gj1.w(parcel, readInt, zze.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzr(zzx, zzp, zze);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
