package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zznk;
import com.google.firebase.auth.UserProfileChangeRequest;

/* renamed from: dz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class dz2 implements Parcelable.Creator<zznk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zznk createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        UserProfileChangeRequest userProfileChangeRequest = null;
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                userProfileChangeRequest = (UserProfileChangeRequest) gj1.w(parcel, readInt, UserProfileChangeRequest.CREATOR);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zznk(userProfileChangeRequest, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zznk[] newArray(int i) {
        return new zznk[i];
    }
}
