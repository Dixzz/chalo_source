package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new q34();
    public final int f;
    public final int g;
    public final long h;
    public final long i;

    public zzaj(int i2, int i3, long j, long j2) {
        this.f = i2;
        this.g = i3;
        this.h = j;
        this.i = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaj.class == obj.getClass()) {
            zzaj zzaj = (zzaj) obj;
            return this.f == zzaj.f && this.g == zzaj.g && this.h == zzaj.h && this.i == zzaj.i;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Integer.valueOf(this.f), Long.valueOf(this.i), Long.valueOf(this.h)});
    }

    public final String toString() {
        return "NetworkLocationStatus:" + " Wifi status: " + this.f + " Cell status: " + this.g + " elapsed time NS: " + this.i + " system time ms: " + this.h;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        int i4 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i4);
        long j = this.h;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        long j2 = this.i;
        parcel.writeInt(524292);
        parcel.writeLong(j2);
        gj1.H1(parcel, o1);
    }
}
