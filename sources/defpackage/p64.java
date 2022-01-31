package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzap;

/* renamed from: p64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class p64 implements Parcelable.Creator<zzap> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzap createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                gj1.p0(parcel, readInt);
            } else {
                bundle = gj1.s(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzap(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzap[] newArray(int i) {
        return new zzap[i];
    }
}
