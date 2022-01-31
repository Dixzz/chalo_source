package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzv implements Parcelable.Creator<zzc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzc createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 3:
                    str = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    bArr = gj1.t(parcel, readInt);
                    break;
                case 6:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzc(i, z, str, str2, bArr, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
