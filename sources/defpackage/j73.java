package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import com.google.android.gms.internal.p000firebaseauthapi.zzwo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;

/* renamed from: j73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class j73 implements Parcelable.Creator<zzvz> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzvz createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzwo zzwo = null;
        String str5 = null;
        String str6 = null;
        zze zze = null;
        ArrayList arrayList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 4:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 5:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    zzwo = (zzwo) gj1.w(parcel, readInt, zzwo.CREATOR);
                    break;
                case '\b':
                    str5 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    str6 = gj1.x(parcel, readInt);
                    break;
                case '\n':
                    j = gj1.h0(parcel, readInt);
                    break;
                case 11:
                    j2 = gj1.h0(parcel, readInt);
                    break;
                case '\f':
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\r':
                    zze = (zze) gj1.w(parcel, readInt, zze.CREATOR);
                    break;
                case 14:
                    arrayList = gj1.B(parcel, readInt, zzwk.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzvz(str, str2, z, str3, str4, zzwo, str5, str6, j, j2, z2, zze, arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzvz[] newArray(int i) {
        return new zzvz[i];
    }
}
