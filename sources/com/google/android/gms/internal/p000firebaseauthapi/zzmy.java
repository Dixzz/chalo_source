package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzmy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmy> CREATOR = new xy2();
    public final PhoneAuthCredential f;
    public final String g;

    public zzmy(PhoneAuthCredential phoneAuthCredential, String str) {
        this.f = phoneAuthCredential;
        this.g = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }
}
