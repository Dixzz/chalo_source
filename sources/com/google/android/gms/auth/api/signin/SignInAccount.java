package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new e12();
    @Deprecated
    public String f;
    public GoogleSignInAccount g;
    @Deprecated
    public String h;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.g = googleSignInAccount;
        gj1.i(str, "8.3 and 8.4 SDKs require non-null email");
        this.f = str;
        gj1.i(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.h = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 4, this.f, false);
        gj1.A0(parcel, 7, this.g, i, false);
        gj1.B0(parcel, 8, this.h, false);
        gj1.H1(parcel, o1);
    }
}
