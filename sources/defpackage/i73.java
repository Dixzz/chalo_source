package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzvx;
import com.google.android.gms.internal.p000firebaseauthapi.zzwb;

/* renamed from: i73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class i73 implements Parcelable.Creator<zzvx> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzvx createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzwb zzwb = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                gj1.p0(parcel, readInt);
            } else {
                zzwb = (zzwb) gj1.w(parcel, readInt, zzwb.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzvx(zzwb);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzvx[] newArray(int i) {
        return new zzvx[i];
    }
}
