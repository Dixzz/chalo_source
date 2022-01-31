package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxk;

/* renamed from: k83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class k83 implements Parcelable.Creator<zzxk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzxk createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                str2 = gj1.x(parcel, readInt);
            } else if (c == 4) {
                j = gj1.h0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                z = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzxk(str, str2, j, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzxk[] newArray(int i) {
        return new zzxk[i];
    }
}
