package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new th4();
    public final long f;
    public final HarmfulAppsData[] g;
    public final int h;
    public final boolean i;

    public zzd(long j, HarmfulAppsData[] harmfulAppsDataArr, int i2, boolean z) {
        this.f = j;
        this.g = harmfulAppsDataArr;
        this.i = z;
        if (z) {
            this.h = i2;
        } else {
            this.h = -1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        long j = this.f;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        gj1.E0(parcel, 3, this.g, i2, false);
        int i3 = this.h;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        boolean z = this.i;
        parcel.writeInt(262149);
        parcel.writeInt(z ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
