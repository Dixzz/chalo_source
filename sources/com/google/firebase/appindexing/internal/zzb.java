package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzb implements Parcelable.Creator<zza> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zza createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzc zzc = null;
        String str5 = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    str = gj1.x(parcel, readInt);
                    break;
                case 2:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 3:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    zzc = (zzc) gj1.w(parcel, readInt, zzc.CREATOR);
                    break;
                case 6:
                    str5 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    bundle = gj1.s(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zza(str, str2, str3, str4, zzc, str5, bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
