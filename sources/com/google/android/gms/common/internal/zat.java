package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new s92();
    public final int f;
    public final Account g;
    public final int h;
    public final GoogleSignInAccount i;

    public zat(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f = i2;
        this.g = account;
        this.h = i3;
        this.i = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.A0(parcel, 2, this.g, i2, false);
        int i4 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        gj1.A0(parcel, 4, this.i, i2, false);
        gj1.H1(parcel, o1);
    }

    public zat(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f = 2;
        this.g = account;
        this.h = i2;
        this.i = googleSignInAccount;
    }
}
