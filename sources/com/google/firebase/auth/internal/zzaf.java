package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzaf implements Parcelable.Creator<zzae> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzae createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        zzag zzag = null;
        String str = null;
        zze zze = null;
        zzx zzx = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                arrayList = gj1.B(parcel, readInt, PhoneMultiFactorInfo.CREATOR);
            } else if (c == 2) {
                zzag = (zzag) gj1.w(parcel, readInt, zzag.CREATOR);
            } else if (c == 3) {
                str = gj1.x(parcel, readInt);
            } else if (c == 4) {
                zze = (zze) gj1.w(parcel, readInt, zze.CREATOR);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                zzx = (zzx) gj1.w(parcel, readInt, zzx.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzae(arrayList, zzag, str, zze, zzx);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzae[] newArray(int i) {
        return new zzae[i];
    }
}
