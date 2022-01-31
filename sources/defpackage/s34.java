package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzj;

/* renamed from: s34  reason: default package */
public final class s34 implements Parcelable.Creator<zzj> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzj createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 50;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        float f = 0.0f;
        int i = Integer.MAX_VALUE;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 2) {
                j = gj1.h0(parcel, readInt);
            } else if (c == 3) {
                f = gj1.d0(parcel, readInt);
            } else if (c == 4) {
                j2 = gj1.h0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzj(z, j, f, j2, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
