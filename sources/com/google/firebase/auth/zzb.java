package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzb implements Parcelable.Creator<ActionCodeSettings> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ActionCodeSettings createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
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
                    z = gj1.Z(parcel, readInt);
                    break;
                case 6:
                    str5 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\b':
                    str6 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    i = gj1.g0(parcel, readInt);
                    break;
                case '\n':
                    str7 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new ActionCodeSettings(str, str2, str3, str4, z, str5, z2, str6, i, str7);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActionCodeSettings[] newArray(int i) {
        return new ActionCodeSettings[i];
    }
}
