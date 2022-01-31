package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zznm;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: ez2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ez2 implements Parcelable.Creator<zznm> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zznm createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        ActionCodeSettings actionCodeSettings = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                str2 = gj1.x(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                actionCodeSettings = (ActionCodeSettings) gj1.w(parcel, readInt, ActionCodeSettings.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zznm(str, str2, actionCodeSettings);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zznm[] newArray(int i) {
        return new zznm[i];
    }
}
