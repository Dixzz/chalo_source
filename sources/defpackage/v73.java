package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwt;

/* renamed from: v73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class v73 implements Parcelable.Creator<zzwt> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzwt createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        long j = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    str = gj1.x(parcel, readInt);
                    break;
                case 2:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 3:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 4:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\b':
                    str5 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzwt(str, j, z, str2, str3, str4, z2, str5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzwt[] newArray(int i) {
        return new zzwt[i];
    }
}
