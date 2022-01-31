package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzma;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;

/* renamed from: ly2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ly2 implements Parcelable.Creator<zzma> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzma createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        zzxg zzxg = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                zzxg = (zzxg) gj1.w(parcel, readInt, zzxg.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzma(str, zzxg);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzma[] newArray(int i) {
        return new zzma[i];
    }
}
