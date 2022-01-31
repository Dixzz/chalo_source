package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new i34();
    @Deprecated
    public int f;
    @Deprecated
    public int g;
    public long h;
    public int i;
    public zzaj[] j;

    public LocationAvailability(int i2, int i3, int i4, long j2, zzaj[] zzajArr) {
        this.i = i2;
        this.f = i3;
        this.g = i4;
        this.h = j2;
        this.j = zzajArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            return this.f == locationAvailability.f && this.g == locationAvailability.g && this.h == locationAvailability.h && this.i == locationAvailability.i && Arrays.equals(this.j, locationAvailability.j);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.i), Integer.valueOf(this.f), Integer.valueOf(this.g), Long.valueOf(this.h), this.j});
    }

    public final String toString() {
        boolean z = this.i < 1000;
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(z);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        int i4 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i4);
        long j2 = this.h;
        parcel.writeInt(524291);
        parcel.writeLong(j2);
        int i5 = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(i5);
        gj1.E0(parcel, 5, this.j, i2, false);
        gj1.H1(parcel, o1);
    }
}
