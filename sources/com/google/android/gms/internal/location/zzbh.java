package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.appindexing.Indexable;
import java.util.Locale;

public final class zzbh extends AbstractSafeParcelable implements c34 {
    public static final Parcelable.Creator<zzbh> CREATOR = new zm3();
    public final String f;
    public final long g;
    public final short h;
    public final double i;
    public final double j;
    public final float k;
    public final int l;
    public final int m;
    public final int n;

    public zzbh(String str, int i2, short s, double d, double d2, float f2, long j2, int i3, int i4) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        } else if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        } else if (d > 90.0d || d < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d2 > 180.0d || d2 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d2);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            int i5 = i2 & 7;
            if (i5 != 0) {
                this.h = s;
                this.f = str;
                this.i = d;
                this.j = d2;
                this.k = f2;
                this.g = j2;
                this.l = i5;
                this.m = i3;
                this.n = i4;
                return;
            }
            throw new IllegalArgumentException(hj1.v(46, "No supported transition specified: ", i2));
        }
    }

    @Override // defpackage.c34
    public final String e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbh)) {
            return false;
        }
        zzbh zzbh = (zzbh) obj;
        return this.k == zzbh.k && this.i == zzbh.i && this.j == zzbh.j && this.h == zzbh.h;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.i);
        long doubleToLongBits2 = Double.doubleToLongBits(this.j);
        return ((((Float.floatToIntBits(this.k) + ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31)) * 31) + this.h) * 31) + this.l;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.h != 1 ? null : "CIRCLE";
        objArr[1] = this.f.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.l);
        objArr[3] = Double.valueOf(this.i);
        objArr[4] = Double.valueOf(this.j);
        objArr[5] = Float.valueOf(this.k);
        objArr[6] = Integer.valueOf(this.m / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
        objArr[7] = Integer.valueOf(this.n);
        objArr[8] = Long.valueOf(this.g);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        long j2 = this.g;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        short s = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(s);
        double d = this.i;
        parcel.writeInt(524292);
        parcel.writeDouble(d);
        double d2 = this.j;
        parcel.writeInt(524293);
        parcel.writeDouble(d2);
        float f2 = this.k;
        parcel.writeInt(262150);
        parcel.writeFloat(f2);
        int i3 = this.l;
        parcel.writeInt(262151);
        parcel.writeInt(i3);
        int i4 = this.m;
        parcel.writeInt(262152);
        parcel.writeInt(i4);
        int i5 = this.n;
        parcel.writeInt(262153);
        parcel.writeInt(i5);
        gj1.H1(parcel, o1);
    }
}
