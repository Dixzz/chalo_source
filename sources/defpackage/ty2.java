package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzmq;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;

/* renamed from: ty2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ty2 implements Parcelable.Creator<zzmq> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzmq createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzxg zzxg = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                zzxg = (zzxg) gj1.w(parcel, readInt, zzxg.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzmq(zzxg);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmq[] newArray(int i) {
        return new zzmq[i];
    }
}
