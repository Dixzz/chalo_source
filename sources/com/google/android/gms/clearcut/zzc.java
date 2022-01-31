package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new l12();
    public final boolean f;
    public final long g;
    public final long h;

    public zzc(boolean z, long j, long j2) {
        this.f = z;
        this.g = j;
        this.h = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzc = (zzc) obj;
            return this.f == zzc.f && this.g == zzc.g && this.h == zzc.h;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h)});
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.f + ",collectForDebugStartTimeMillis: " + this.g + ",collectForDebugExpiryTimeMillis: " + this.h + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        long j = this.h;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        long j2 = this.g;
        parcel.writeInt(524291);
        parcel.writeLong(j2);
        gj1.H1(parcel, o1);
    }
}
