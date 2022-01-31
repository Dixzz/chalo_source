package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new p34();
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = z6;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.k;
        parcel.writeInt(262150);
        parcel.writeInt(z6 ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
