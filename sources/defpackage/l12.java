package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zzc;

/* renamed from: l12  reason: default package */
public final class l12 implements Parcelable.Creator<zzc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzc createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        long j2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 2) {
                j2 = gj1.h0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                j = gj1.h0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzc(z, j, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
