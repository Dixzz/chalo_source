package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzm;

/* renamed from: ql3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ql3 implements Parcelable.Creator<zzm> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzm createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                bundle = gj1.s(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzm(i, bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i) {
        return new zzm[i];
    }
}
