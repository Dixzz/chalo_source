package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzmk;
import com.google.android.gms.internal.p000firebaseauthapi.zzwt;

/* renamed from: qy2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class qy2 implements Parcelable.Creator<zzmk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzmk createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzwt zzwt = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                zzwt = (zzwt) gj1.w(parcel, readInt, zzwt.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzmk(zzwt);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmk[] newArray(int i) {
        return new zzmk[i];
    }
}
