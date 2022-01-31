package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new s34();
    public boolean f;
    public long g;
    public float h;
    public long i;
    public int j;

    public zzj() {
        this.f = true;
        this.g = 50;
        this.h = 0.0f;
        this.i = Long.MAX_VALUE;
        this.j = Integer.MAX_VALUE;
    }

    public zzj(boolean z, long j2, float f2, long j3, int i2) {
        this.f = z;
        this.g = j2;
        this.h = f2;
        this.i = j3;
        this.j = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        return this.f == zzj.f && this.g == zzj.g && Float.compare(this.h, zzj.h) == 0 && this.i == zzj.i && this.j == zzj.j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f), Long.valueOf(this.g), Float.valueOf(this.h), Long.valueOf(this.i), Integer.valueOf(this.j)});
    }

    public final String toString() {
        StringBuilder i0 = hj1.i0("DeviceOrientationRequest[mShouldUseMag=");
        i0.append(this.f);
        i0.append(" mMinimumSamplingPeriodMs=");
        i0.append(this.g);
        i0.append(" mSmallestAngleChangeRadians=");
        i0.append(this.h);
        long j2 = this.i;
        if (j2 != Long.MAX_VALUE) {
            i0.append(" expireIn=");
            i0.append(j2 - SystemClock.elapsedRealtime());
            i0.append("ms");
        }
        if (this.j != Integer.MAX_VALUE) {
            i0.append(" num=");
            i0.append(this.j);
        }
        i0.append(']');
        return i0.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        long j2 = this.g;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        float f2 = this.h;
        parcel.writeInt(262147);
        parcel.writeFloat(f2);
        long j3 = this.i;
        parcel.writeInt(524292);
        parcel.writeLong(j3);
        int i3 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        gj1.H1(parcel, o1);
    }
}
