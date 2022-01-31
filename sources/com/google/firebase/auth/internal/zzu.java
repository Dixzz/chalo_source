package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzu implements Parcelable.Creator<zzt> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzt createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
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
                    str5 = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    str6 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\b':
                    str7 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzt(str, str2, str3, str4, str5, str6, z, str7);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
