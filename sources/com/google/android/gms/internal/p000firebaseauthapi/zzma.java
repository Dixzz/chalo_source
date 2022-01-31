package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzma extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzma> CREATOR = new ly2();
    public final String f;
    public final zzxg g;

    public zzma(String str, zzxg zzxg) {
        this.f = str;
        this.g = zzxg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.A0(parcel, 2, this.g, i, false);
        gj1.H1(parcel, o1);
    }
}
