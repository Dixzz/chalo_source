package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;

/* renamed from: u73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class u73 implements Parcelable.Creator<zzwr> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzwr createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzwk zzwk = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                str2 = gj1.x(parcel, readInt);
            } else if (c == 4) {
                str3 = gj1.x(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                zzwk = (zzwk) gj1.w(parcel, readInt, zzwk.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzwr(str, str2, str3, zzwk);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzwr[] newArray(int i) {
        return new zzwr[i];
    }
}
