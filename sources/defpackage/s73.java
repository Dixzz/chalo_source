package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwm;
import com.google.android.gms.internal.p000firebaseauthapi.zzwo;
import java.util.ArrayList;

/* renamed from: s73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class s73 implements Parcelable.Creator<zzwo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzwo createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                gj1.p0(parcel, readInt);
            } else {
                arrayList = gj1.B(parcel, readInt, zzwm.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzwo(arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzwo[] newArray(int i) {
        return new zzwo[i];
    }
}
