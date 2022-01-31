package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzmy;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: xy2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class xy2 implements Parcelable.Creator<zzmy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzmy createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        PhoneAuthCredential phoneAuthCredential = null;
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                phoneAuthCredential = (PhoneAuthCredential) gj1.w(parcel, readInt, PhoneAuthCredential.CREATOR);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzmy(phoneAuthCredential, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmy[] newArray(int i) {
        return new zzmy[i];
    }
}
