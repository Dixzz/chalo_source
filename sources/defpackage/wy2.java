package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzmw;
import com.google.firebase.auth.EmailAuthCredential;

/* renamed from: wy2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class wy2 implements Parcelable.Creator<zzmw> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzmw createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        EmailAuthCredential emailAuthCredential = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                emailAuthCredential = (EmailAuthCredential) gj1.w(parcel, readInt, EmailAuthCredential.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzmw(emailAuthCredential);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzmw[] newArray(int i) {
        return new zzmw[i];
    }
}
