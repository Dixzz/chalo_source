package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;

/* renamed from: h83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class h83 implements Parcelable.Creator<zzxg> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzxg createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
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
                    str3 = gj1.x(parcel, readInt);
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
                case '\b':
                    str7 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    str8 = gj1.x(parcel, readInt);
                    break;
                case '\n':
                    z = gj1.Z(parcel, readInt);
                    break;
                case 11:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\f':
                    str9 = gj1.x(parcel, readInt);
                    break;
                case '\r':
                    str10 = gj1.x(parcel, readInt);
                    break;
                case 14:
                    str11 = gj1.x(parcel, readInt);
                    break;
                case 15:
                    str12 = gj1.x(parcel, readInt);
                    break;
                case 16:
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case 17:
                    str13 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzxg(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11, str12, z3, str13);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzxg[] newArray(int i) {
        return new zzxg[i];
    }
}
