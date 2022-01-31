package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new vh4();
    public final int f;
    public final boolean g;

    public zzh(int i, boolean z) {
        this.f = i;
        this.g = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        boolean z = this.g;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
