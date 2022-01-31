package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zai;

/* renamed from: hi4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class hi4 implements Parcelable.Creator<zai> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zai createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        zat zat = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                zat = (zat) gj1.w(parcel, readInt, zat.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zai(i, zat);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zai[] newArray(int i) {
        return new zai[i];
    }
}
