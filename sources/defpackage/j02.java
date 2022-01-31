package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;

/* renamed from: j02  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class j02 implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                bundle = gj1.s(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new GoogleSignInOptionsExtensionParcelable(i, i2, bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInOptionsExtensionParcelable[] newArray(int i) {
        return new GoogleSignInOptionsExtensionParcelable[i];
    }
}
