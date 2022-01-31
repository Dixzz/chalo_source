package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzna  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzna extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzna> CREATOR = new yy2();
    public final String f;
    public final String g;
    public final String h;
    public final long i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final String m;
    public final boolean n;

    public zzna(String str, String str2, String str3, long j2, boolean z, boolean z2, String str4, String str5, boolean z3) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = j2;
        this.j = z;
        this.k = z2;
        this.l = str4;
        this.m = str5;
        this.n = z3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.B0(parcel, 3, this.h, false);
        long j2 = this.i;
        parcel.writeInt(524292);
        parcel.writeLong(j2);
        boolean z = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.k;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 7, this.l, false);
        gj1.B0(parcel, 8, this.m, false);
        boolean z3 = this.n;
        parcel.writeInt(262153);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
