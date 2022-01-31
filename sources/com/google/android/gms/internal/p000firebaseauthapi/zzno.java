package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzno  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzno extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzno> CREATOR = new fz2();
    public final Status f;
    public final zze g;
    public final String h;
    public final String i;

    public zzno(Status status, zze zze, String str, String str2) {
        this.f = status;
        this.g = zze;
        this.h = str;
        this.i = str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i2, false);
        gj1.A0(parcel, 2, this.g, i2, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.B0(parcel, 4, this.i, false);
        gj1.H1(parcel, o1);
    }
}
