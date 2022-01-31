package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzq;

/* renamed from: dc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class dc2 implements Parcelable.Creator<zzq> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzq createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        boolean z = false;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzq(z, str, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzq[] newArray(int i) {
        return new zzq[i];
    }
}
