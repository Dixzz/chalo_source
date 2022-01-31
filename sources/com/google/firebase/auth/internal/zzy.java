package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.zze;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzy implements Parcelable.Creator<zzx> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzx createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzwg zzwg = null;
        zzt zzt = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Boolean bool = null;
        zzz zzz = null;
        zze zze = null;
        zzbb zzbb = null;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    zzwg = (zzwg) gj1.w(parcel, readInt, zzwg.CREATOR);
                    break;
                case 2:
                    zzt = (zzt) gj1.w(parcel, readInt, zzt.CREATOR);
                    break;
                case 3:
                    str = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    arrayList = gj1.B(parcel, readInt, zzt.CREATOR);
                    break;
                case 6:
                    arrayList2 = gj1.z(parcel, readInt);
                    break;
                case 7:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    bool = gj1.a0(parcel, readInt);
                    break;
                case '\t':
                    zzz = (zzz) gj1.w(parcel, readInt, zzz.CREATOR);
                    break;
                case '\n':
                    z = gj1.Z(parcel, readInt);
                    break;
                case 11:
                    zze = (zze) gj1.w(parcel, readInt, zze.CREATOR);
                    break;
                case '\f':
                    zzbb = (zzbb) gj1.w(parcel, readInt, zzbb.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzx(zzwg, zzt, str, str2, arrayList, arrayList2, str3, bool, zzz, z, zze, zzbb);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzx[] newArray(int i) {
        return new zzx[i];
    }
}
