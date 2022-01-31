package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwm;

/* renamed from: r73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class r73 implements Parcelable.Creator<zzwm> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzwm createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
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
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzwm(str, str2, str3, str4, str5, str6, str7);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzwm[] newArray(int i) {
        return new zzwm[i];
    }
}
