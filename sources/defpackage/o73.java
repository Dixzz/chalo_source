package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;

/* renamed from: o73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class o73 implements Parcelable.Creator<zzwg> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzwg createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        Long l = null;
        String str3 = null;
        Long l2 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                str2 = gj1.x(parcel, readInt);
            } else if (c == 4) {
                l = gj1.i0(parcel, readInt);
            } else if (c == 5) {
                str3 = gj1.x(parcel, readInt);
            } else if (c != 6) {
                gj1.p0(parcel, readInt);
            } else {
                l2 = gj1.i0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzwg(str, str2, l, str3, l2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzwg[] newArray(int i) {
        return new zzwg[i];
    }
}
