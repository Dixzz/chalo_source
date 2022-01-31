package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;

/* renamed from: jh4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class jh4 implements Parcelable.Creator<zzz> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzz createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzku zzku = null;
        String str3 = null;
        zzaq zzaq = null;
        zzaq zzaq2 = null;
        zzaq zzaq3 = null;
        boolean z = false;
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
                    zzku = (zzku) gj1.w(parcel, readInt, zzku.CREATOR);
                    break;
                case 5:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 6:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 7:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    zzaq = (zzaq) gj1.w(parcel, readInt, zzaq.CREATOR);
                    break;
                case '\t':
                    j2 = gj1.h0(parcel, readInt);
                    break;
                case '\n':
                    zzaq2 = (zzaq) gj1.w(parcel, readInt, zzaq.CREATOR);
                    break;
                case 11:
                    j3 = gj1.h0(parcel, readInt);
                    break;
                case '\f':
                    zzaq3 = (zzaq) gj1.w(parcel, readInt, zzaq.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzz(str, str2, zzku, j, z, str3, zzaq, j2, zzaq2, j3, zzaq3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
