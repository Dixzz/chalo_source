package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzmi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmi> CREATOR = new py2();
    public final String f;
    public final ActionCodeSettings g;
    public final String h;

    public zzmi(String str, ActionCodeSettings actionCodeSettings, String str2) {
        this.f = str;
        this.g = actionCodeSettings;
        this.h = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.A0(parcel, 2, this.g, i, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
