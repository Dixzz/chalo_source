package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzai;

/* renamed from: ca2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ca2 implements Parcelable.Creator<zzai> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzai createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzai(i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzai[] newArray(int i) {
        return new zzai[i];
    }
}
