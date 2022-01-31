package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zznc;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* renamed from: zy2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zy2 implements Parcelable.Creator<zznc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zznc createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        PhoneMultiFactorInfo phoneMultiFactorInfo = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    phoneMultiFactorInfo = (PhoneMultiFactorInfo) gj1.w(parcel, readInt, PhoneMultiFactorInfo.CREATOR);
                    break;
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 4:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 5:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 6:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 7:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    str4 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    z3 = gj1.Z(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zznc(phoneMultiFactorInfo, str, str2, j, z, z2, str3, str4, z3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zznc[] newArray(int i) {
        return new zznc[i];
    }
}
