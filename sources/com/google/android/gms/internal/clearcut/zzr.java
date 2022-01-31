package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Objects;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new cl2();
    public final String f;
    public final int g;
    public final int h;
    public final String i;
    public final String j;
    public final boolean k;
    public final String l;
    public final boolean m;
    public final int n;

    public zzr(String str, int i2, int i3, String str2, String str3, String str4, boolean z, ik2 ik2) {
        Objects.requireNonNull(str, "null reference");
        this.f = str;
        this.g = i2;
        this.h = i3;
        this.l = str2;
        this.i = str3;
        this.j = null;
        this.k = !z;
        this.m = z;
        this.n = ik2.zzc();
    }

    public zzr(String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f = str;
        this.g = i2;
        this.h = i3;
        this.i = str2;
        this.j = str3;
        this.k = z;
        this.l = str4;
        this.m = z2;
        this.n = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzr) {
            zzr zzr = (zzr) obj;
            return gj1.G(this.f, zzr.f) && this.g == zzr.g && this.h == zzr.h && gj1.G(this.l, zzr.l) && gj1.G(this.i, zzr.i) && gj1.G(this.j, zzr.j) && this.k == zzr.k && this.m == zzr.m && this.n == zzr.n;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, Integer.valueOf(this.g), Integer.valueOf(this.h), this.l, this.i, this.j, Boolean.valueOf(this.k), Boolean.valueOf(this.m), Integer.valueOf(this.n)});
    }

    public final String toString() {
        StringBuilder k0 = hj1.k0("PlayLoggerContext[", "package=");
        hj1.U0(k0, this.f, ',', "packageVersionCode=");
        k0.append(this.g);
        k0.append(',');
        k0.append("logSource=");
        k0.append(this.h);
        k0.append(',');
        k0.append("logSourceName=");
        hj1.U0(k0, this.l, ',', "uploadAccount=");
        hj1.U0(k0, this.i, ',', "loggingId=");
        hj1.U0(k0, this.j, ',', "logAndroidId=");
        k0.append(this.k);
        k0.append(',');
        k0.append("isAnonymous=");
        k0.append(this.m);
        k0.append(',');
        k0.append("qosTier=");
        return hj1.X(k0, this.n, "]");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        int i3 = this.g;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        int i4 = this.h;
        parcel.writeInt(262148);
        parcel.writeInt(i4);
        gj1.B0(parcel, 5, this.i, false);
        gj1.B0(parcel, 6, this.j, false);
        boolean z = this.k;
        parcel.writeInt(262151);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 8, this.l, false);
        boolean z2 = this.m;
        parcel.writeInt(262153);
        parcel.writeInt(z2 ? 1 : 0);
        int i5 = this.n;
        parcel.writeInt(262154);
        parcel.writeInt(i5);
        gj1.H1(parcel, o1);
    }
}
