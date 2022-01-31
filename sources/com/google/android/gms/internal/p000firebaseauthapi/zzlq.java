package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzlq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlq> CREATOR = new fy2();
    public final PhoneAuthCredential f;
    public final String g;
    public final String h;

    public zzlq(PhoneAuthCredential phoneAuthCredential, String str, String str2) {
        this.f = phoneAuthCredential;
        this.g = str;
        this.h = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
