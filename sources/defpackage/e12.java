package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

/* renamed from: e12  reason: default package */
public final class e12 implements Parcelable.Creator<SignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final SignInAccount createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = str;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 4) {
                str = gj1.x(parcel, readInt);
            } else if (c == 7) {
                googleSignInAccount = (GoogleSignInAccount) gj1.w(parcel, readInt, GoogleSignInAccount.CREATOR);
            } else if (c != '\b') {
                gj1.p0(parcel, readInt);
            } else {
                str2 = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
