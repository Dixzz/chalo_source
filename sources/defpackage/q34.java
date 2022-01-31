package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzaj;

/* renamed from: q34  reason: default package */
public final class q34 implements Parcelable.Creator<zzaj> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzaj createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = -1;
        long j2 = -1;
        int i = 1;
        int i2 = 1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c == 3) {
                j = gj1.h0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                j2 = gj1.h0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzaj(i, i2, j, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaj[] newArray(int i) {
        return new zzaj[i];
    }
}
