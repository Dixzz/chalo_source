package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;

/* renamed from: r64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class r64 implements Parcelable.Creator<zzaq> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzaq createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        zzap zzap = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                zzap = (zzap) gj1.w(parcel, readInt, zzap.CREATOR);
            } else if (c == 4) {
                str2 = gj1.x(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                j = gj1.h0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzaq(str, zzap, str2, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}
