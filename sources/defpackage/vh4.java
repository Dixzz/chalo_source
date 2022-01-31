package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.zzh;

/* renamed from: vh4  reason: default package */
public final class vh4 implements Parcelable.Creator<zzh> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzh createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                z = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzh(i, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
