package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zat;

/* renamed from: s92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class s92 implements Parcelable.Creator<zat> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zat createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                account = (Account) gj1.w(parcel, readInt, Account.CREATOR);
            } else if (c == 3) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) gj1.w(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zat(i, account, i2, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zat[] newArray(int i) {
        return new zat[i];
    }
}
