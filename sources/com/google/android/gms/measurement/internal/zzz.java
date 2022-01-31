package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new jh4();
    public String f;
    public String g;
    public zzku h;
    public long i;
    public boolean j;
    public String k;
    public zzaq l;
    public long m;
    public zzaq n;
    public long o;
    public zzaq p;

    public zzz(zzz zzz) {
        this.f = zzz.f;
        this.g = zzz.g;
        this.h = zzz.h;
        this.i = zzz.i;
        this.j = zzz.j;
        this.k = zzz.k;
        this.l = zzz.l;
        this.m = zzz.m;
        this.n = zzz.n;
        this.o = zzz.o;
        this.p = zzz.p;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        gj1.A0(parcel, 4, this.h, i2, false);
        long j2 = this.i;
        parcel.writeInt(524293);
        parcel.writeLong(j2);
        boolean z = this.j;
        parcel.writeInt(262150);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 7, this.k, false);
        gj1.A0(parcel, 8, this.l, i2, false);
        long j3 = this.m;
        parcel.writeInt(524297);
        parcel.writeLong(j3);
        gj1.A0(parcel, 10, this.n, i2, false);
        long j4 = this.o;
        parcel.writeInt(524299);
        parcel.writeLong(j4);
        gj1.A0(parcel, 12, this.p, i2, false);
        gj1.H1(parcel, o1);
    }

    public zzz(String str, String str2, zzku zzku, long j2, boolean z, String str3, zzaq zzaq, long j3, zzaq zzaq2, long j4, zzaq zzaq3) {
        this.f = str;
        this.g = str2;
        this.h = zzku;
        this.i = j2;
        this.j = z;
        this.k = str3;
        this.l = zzaq;
        this.m = j3;
        this.n = zzaq2;
        this.o = j4;
        this.p = zzaq3;
    }
}
