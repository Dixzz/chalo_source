package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzvz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvz> CREATOR = new j73();
    public String f;
    public String g;
    public boolean h;
    public String i;
    public String j;
    public zzwo k;
    public String l;
    public String m;
    public long n;
    public long o;
    public boolean p;
    public zze q;
    public List<zzwk> r;

    public zzvz() {
        this.k = new zzwo();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        boolean z = this.h;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 5, this.i, false);
        gj1.B0(parcel, 6, this.j, false);
        gj1.A0(parcel, 7, this.k, i2, false);
        gj1.B0(parcel, 8, this.l, false);
        gj1.B0(parcel, 9, this.m, false);
        long j2 = this.n;
        parcel.writeInt(524298);
        parcel.writeLong(j2);
        long j3 = this.o;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        boolean z2 = this.p;
        parcel.writeInt(262156);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.A0(parcel, 13, this.q, i2, false);
        gj1.F0(parcel, 14, this.r, false);
        gj1.H1(parcel, o1);
    }

    public zzvz(String str, String str2, boolean z, String str3, String str4, zzwo zzwo, String str5, String str6, long j2, long j3, boolean z2, zze zze, List<zzwk> list) {
        zzwo zzwo2;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = str3;
        this.j = str4;
        if (zzwo == null) {
            zzwo2 = new zzwo();
        } else {
            List<zzwm> list2 = zzwo.f;
            zzwo zzwo3 = new zzwo();
            if (list2 != null) {
                zzwo3.f.addAll(list2);
            }
            zzwo2 = zzwo3;
        }
        this.k = zzwo2;
        this.l = str5;
        this.m = str6;
        this.n = j2;
        this.o = j3;
        this.p = z2;
        this.q = zze;
        this.r = list == null ? new ArrayList<>() : list;
    }
}
