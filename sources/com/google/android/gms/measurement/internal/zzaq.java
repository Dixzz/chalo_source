package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new r64();
    public final String f;
    public final zzap g;
    public final String h;
    public final long i;

    public zzaq(String str, zzap zzap, String str2, long j) {
        this.f = str;
        this.g = zzap;
        this.h = str2;
        this.i = j;
    }

    public final String toString() {
        String str = this.h;
        String str2 = this.f;
        String valueOf = String.valueOf(this.g);
        StringBuilder sb = new StringBuilder(valueOf.length() + hj1.g0(str2, hj1.g0(str, 21)));
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return hj1.a0(sb, ",params=", valueOf);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.A0(parcel, 3, this.g, i2, false);
        gj1.B0(parcel, 4, this.h, false);
        long j = this.i;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        gj1.H1(parcel, o1);
    }

    public zzaq(zzaq zzaq, long j) {
        Objects.requireNonNull(zzaq, "null reference");
        this.f = zzaq.f;
        this.g = zzaq.g;
        this.h = zzaq.h;
        this.i = j;
    }
}
