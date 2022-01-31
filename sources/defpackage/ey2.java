package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzlo;

/* renamed from: ey2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ey2 implements Parcelable.Creator<zzlo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzlo createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzlo(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzlo[] newArray(int i) {
        return new zzlo[i];
    }
}
