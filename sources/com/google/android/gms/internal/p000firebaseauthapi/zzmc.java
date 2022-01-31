package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzmc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmc> CREATOR = new my2();
    public final String f;
    public final PhoneAuthCredential g;

    public zzmc(String str, PhoneAuthCredential phoneAuthCredential) {
        this.f = str;
        this.g = phoneAuthCredential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.A0(parcel, 2, this.g, i, false);
        gj1.H1(parcel, o1);
    }
}
