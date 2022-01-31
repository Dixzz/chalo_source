package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new j34();
    public int f;
    public long g;
    public long h;
    public boolean i;
    public long j;
    public int k;
    public float l;
    public long m;

    public LocationRequest() {
        this.f = 102;
        this.g = 3600000;
        this.h = 600000;
        this.i = false;
        this.j = Long.MAX_VALUE;
        this.k = Integer.MAX_VALUE;
        this.l = 0.0f;
        this.m = 0;
    }

    public LocationRequest(int i2, long j2, long j3, boolean z, long j4, int i3, float f2, long j5) {
        this.f = i2;
        this.g = j2;
        this.h = j3;
        this.i = z;
        this.j = j4;
        this.k = i3;
        this.l = f2;
        this.m = j5;
    }

    public static void n1(long j2) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("invalid interval: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        if (this.f == locationRequest.f) {
            long j2 = this.g;
            long j3 = locationRequest.g;
            if (j2 == j3 && this.h == locationRequest.h && this.i == locationRequest.i && this.j == locationRequest.j && this.k == locationRequest.k && this.l == locationRequest.l) {
                long j4 = this.m;
                if (j4 >= j2) {
                    j2 = j4;
                }
                long j5 = locationRequest.m;
                if (j5 >= j3) {
                    j3 = j5;
                }
                if (j2 == j3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f), Long.valueOf(this.g), Float.valueOf(this.l), Long.valueOf(this.m)});
    }

    public final LocationRequest l1(long j2) {
        n1(j2);
        this.g = j2;
        if (!this.i) {
            this.h = (long) (((double) j2) / 6.0d);
        }
        return this;
    }

    public final LocationRequest m1(int i2) {
        if (i2 == 100 || i2 == 102 || i2 == 104 || i2 == 105) {
            this.f = i2;
            return this;
        }
        throw new IllegalArgumentException(hj1.v(28, "invalid quality: ", i2));
    }

    public final String toString() {
        StringBuilder i0 = hj1.i0("Request[");
        int i2 = this.f;
        i0.append(i2 != 100 ? i2 != 102 ? i2 != 104 ? i2 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f != 105) {
            i0.append(" requested=");
            i0.append(this.g);
            i0.append("ms");
        }
        i0.append(" fastest=");
        i0.append(this.h);
        i0.append("ms");
        if (this.m > this.g) {
            i0.append(" maxWait=");
            i0.append(this.m);
            i0.append("ms");
        }
        if (this.l > 0.0f) {
            i0.append(" smallestDisplacement=");
            i0.append(this.l);
            i0.append("m");
        }
        long j2 = this.j;
        if (j2 != Long.MAX_VALUE) {
            i0.append(" expireIn=");
            i0.append(j2 - SystemClock.elapsedRealtime());
            i0.append("ms");
        }
        if (this.k != Integer.MAX_VALUE) {
            i0.append(" num=");
            i0.append(this.k);
        }
        i0.append(']');
        return i0.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        long j2 = this.g;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        long j3 = this.h;
        parcel.writeInt(524291);
        parcel.writeLong(j3);
        boolean z = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        long j4 = this.j;
        parcel.writeInt(524293);
        parcel.writeLong(j4);
        int i4 = this.k;
        parcel.writeInt(262150);
        parcel.writeInt(i4);
        float f2 = this.l;
        parcel.writeInt(262151);
        parcel.writeFloat(f2);
        long j5 = this.m;
        parcel.writeInt(524296);
        parcel.writeLong(j5);
        gj1.H1(parcel, o1);
    }
}
