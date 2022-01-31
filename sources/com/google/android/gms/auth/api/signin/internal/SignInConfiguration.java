package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new y02();
    public final String f;
    public GoogleSignInOptions g;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        gj1.j(str);
        this.f = str;
        this.g = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f.equals(signInConfiguration.f)) {
            GoogleSignInOptions googleSignInOptions = this.g;
            if (googleSignInOptions == null) {
                if (signInConfiguration.g == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        String str = this.f;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        GoogleSignInOptions googleSignInOptions = this.g;
        int i3 = (i + 31) * 31;
        if (googleSignInOptions != null) {
            i2 = googleSignInOptions.hashCode();
        }
        return i3 + i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.A0(parcel, 5, this.g, i, false);
        gj1.H1(parcel, o1);
    }
}
