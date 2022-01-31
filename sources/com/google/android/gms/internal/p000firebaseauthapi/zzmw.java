package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.EmailAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzmw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmw> CREATOR = new wy2();
    public final EmailAuthCredential f;

    public zzmw(EmailAuthCredential emailAuthCredential) {
        this.f = emailAuthCredential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.H1(parcel, o1);
    }
}
