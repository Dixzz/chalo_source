package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzf implements Parcelable.Creator<zze> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zze createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzxg zzxg = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
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
                    zzxg = (zzxg) gj1.w(parcel, readInt, zzxg.CREATOR);
                    break;
                case 5:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    str5 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    str6 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zze(str, str2, str3, zzxg, str4, str5, str6);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zze[] newArray(int i) {
        return new zze[i];
    }
}
