package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzne  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzne extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzne> CREATOR = new az2();
    public final String f;
    public final String g;

    public zzne(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }
}
