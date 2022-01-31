package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzmc;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: my2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class my2 implements Parcelable.Creator<zzmc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzmc createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        PhoneAuthCredential phoneAuthCredential = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                phoneAuthCredential = (PhoneAuthCredential) gj1.w(parcel, readInt, PhoneAuthCredential.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzmc(str, phoneAuthCredential);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmc[] newArray(int i) {
        return new zzmc[i];
    }
}
