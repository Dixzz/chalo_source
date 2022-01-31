package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import com.google.firebase.auth.zze;
import java.util.ArrayList;

/* renamed from: gz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gz2 implements Parcelable.Creator<zznq> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zznq createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        ArrayList arrayList = null;
        zze zze = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                arrayList = gj1.B(parcel, readInt, zzwk.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                zze = (zze) gj1.w(parcel, readInt, zze.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zznq(str, arrayList, zze);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zznq[] newArray(int i) {
        return new zznq[i];
    }
}
