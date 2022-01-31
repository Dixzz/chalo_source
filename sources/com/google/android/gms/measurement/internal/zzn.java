package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new ah4();
    public final String A;
    public final String B;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final long j;
    public final long k;
    public final String l;
    public final boolean m;
    public final boolean n;
    public final long o;
    public final String p;
    public final long q;
    public final long r;
    public final int s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final String w;
    public final Boolean x;
    public final long y;
    public final List<String> z;

    public zzn(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z2, boolean z3, String str6, long j5, long j6, int i2, boolean z4, boolean z5, boolean z6, String str7, Boolean bool, long j7, List<String> list, String str8, String str9) {
        gj1.j(str);
        this.f = str;
        this.g = TextUtils.isEmpty(str2) ? null : str2;
        this.h = str3;
        this.o = j2;
        this.i = str4;
        this.j = j3;
        this.k = j4;
        this.l = str5;
        this.m = z2;
        this.n = z3;
        this.p = str6;
        this.q = j5;
        this.r = j6;
        this.s = i2;
        this.t = z4;
        this.u = z5;
        this.v = z6;
        this.w = str7;
        this.x = bool;
        this.y = j7;
        this.z = list;
        this.A = str8;
        this.B = str9;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        gj1.B0(parcel, 4, this.h, false);
        gj1.B0(parcel, 5, this.i, false);
        long j2 = this.j;
        parcel.writeInt(524294);
        parcel.writeLong(j2);
        long j3 = this.k;
        parcel.writeInt(524295);
        parcel.writeLong(j3);
        gj1.B0(parcel, 8, this.l, false);
        boolean z2 = this.m;
        parcel.writeInt(262153);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.n;
        parcel.writeInt(262154);
        parcel.writeInt(z3 ? 1 : 0);
        long j4 = this.o;
        parcel.writeInt(524299);
        parcel.writeLong(j4);
        gj1.B0(parcel, 12, this.p, false);
        long j5 = this.q;
        parcel.writeInt(524301);
        parcel.writeLong(j5);
        long j6 = this.r;
        parcel.writeInt(524302);
        parcel.writeLong(j6);
        int i3 = this.s;
        parcel.writeInt(262159);
        parcel.writeInt(i3);
        boolean z4 = this.t;
        parcel.writeInt(262160);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.u;
        parcel.writeInt(262161);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.v;
        parcel.writeInt(262162);
        parcel.writeInt(z6 ? 1 : 0);
        gj1.B0(parcel, 19, this.w, false);
        gj1.s0(parcel, 21, this.x, false);
        long j7 = this.y;
        parcel.writeInt(524310);
        parcel.writeLong(j7);
        gj1.D0(parcel, 23, this.z, false);
        gj1.B0(parcel, 24, this.A, false);
        gj1.B0(parcel, 25, this.B, false);
        gj1.H1(parcel, o1);
    }

    public zzn(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z2, boolean z3, long j4, String str6, long j5, long j6, int i2, boolean z4, boolean z5, boolean z6, String str7, Boolean bool, long j7, List<String> list, String str8, String str9) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.o = j4;
        this.i = str4;
        this.j = j2;
        this.k = j3;
        this.l = str5;
        this.m = z2;
        this.n = z3;
        this.p = str6;
        this.q = j5;
        this.r = j6;
        this.s = i2;
        this.t = z4;
        this.u = z5;
        this.v = z6;
        this.w = str7;
        this.x = bool;
        this.y = j7;
        this.z = list;
        this.A = str8;
        this.B = str9;
    }
}
