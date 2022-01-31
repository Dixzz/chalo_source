package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzk;
import com.google.android.gms.internal.icing.zzt;

/* renamed from: pl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class pl3 implements Parcelable.Creator<zzk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzk createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        zzt zzt = null;
        byte[] bArr = null;
        int i = -1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                zzt = (zzt) gj1.w(parcel, readInt, zzt.CREATOR);
            } else if (c == 4) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                bArr = gj1.t(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzk(str, zzt, i, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
