package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzku extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzku> CREATOR = new tg4();
    public final int f;
    public final String g;
    public final long h;
    public final Long i;
    public final String j;
    public final String k;
    public final Double l;

    public zzku(vg4 vg4) {
        this(vg4.c, vg4.d, vg4.e, vg4.b);
    }

    public final Object l1() {
        Long l2 = this.i;
        if (l2 != null) {
            return l2;
        }
        Double d = this.l;
        if (d != null) {
            return d;
        }
        String str = this.j;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.B0(parcel, 2, this.g, false);
        long j2 = this.h;
        parcel.writeInt(524291);
        parcel.writeLong(j2);
        gj1.z0(parcel, 4, this.i, false);
        gj1.w0(parcel, 5, null, false);
        gj1.B0(parcel, 6, this.j, false);
        gj1.B0(parcel, 7, this.k, false);
        Double d = this.l;
        if (d != null) {
            parcel.writeInt(524296);
            parcel.writeDouble(d.doubleValue());
        }
        gj1.H1(parcel, o1);
    }

    public zzku(String str, long j2, Object obj, String str2) {
        gj1.j(str);
        this.f = 2;
        this.g = str;
        this.h = j2;
        this.k = str2;
        if (obj == null) {
            this.i = null;
            this.l = null;
            this.j = null;
        } else if (obj instanceof Long) {
            this.i = (Long) obj;
            this.l = null;
            this.j = null;
        } else if (obj instanceof String) {
            this.i = null;
            this.l = null;
            this.j = (String) obj;
        } else if (obj instanceof Double) {
            this.i = null;
            this.l = (Double) obj;
            this.j = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public zzku(int i2, String str, long j2, Long l2, Float f2, String str2, String str3, Double d) {
        this.f = i2;
        this.g = str;
        this.h = j2;
        this.i = l2;
        if (i2 == 1) {
            this.l = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.l = d;
        }
        this.j = str2;
        this.k = str3;
    }
}
