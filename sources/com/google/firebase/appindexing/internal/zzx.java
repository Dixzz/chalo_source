package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzx implements Parcelable.Creator<zzy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzy createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Thing[] thingArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        zza zza = null;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    thingArr = (Thing[]) gj1.A(parcel, readInt, Thing.CREATOR);
                    break;
                case 3:
                    strArr = gj1.y(parcel, readInt);
                    break;
                case 4:
                default:
                    gj1.p0(parcel, readInt);
                    break;
                case 5:
                    strArr2 = gj1.y(parcel, readInt);
                    break;
                case 6:
                    zza = (zza) gj1.w(parcel, readInt, zza.CREATOR);
                    break;
                case 7:
                    str = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    str2 = gj1.x(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzy(i, thingArr, strArr, strArr2, zza, str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy[] newArray(int i) {
        return new zzy[i];
    }
}
