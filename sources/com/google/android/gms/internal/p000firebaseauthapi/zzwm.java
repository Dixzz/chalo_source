package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwm> CREATOR = new r73();
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public zzwm() {
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        gj1.B0(parcel, 4, this.h, false);
        gj1.B0(parcel, 5, this.i, false);
        gj1.B0(parcel, 6, this.j, false);
        gj1.B0(parcel, 7, this.k, false);
        gj1.B0(parcel, 8, this.l, false);
        gj1.H1(parcel, o1);
    }

    public zzwm(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = str7;
    }
}
