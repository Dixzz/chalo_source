package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwb;
import java.util.ArrayList;

/* renamed from: k73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class k73 implements Parcelable.Creator<zzwb> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzwb createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                gj1.p0(parcel, readInt);
            } else {
                arrayList = gj1.B(parcel, readInt, zzvz.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzwb(arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzwb[] newArray(int i) {
        return new zzwb[i];
    }
}
