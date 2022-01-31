package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new n34();
    public final List<LocationRequest> f;
    public final boolean g;
    public final boolean h;
    public zzae i;

    public LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, zzae zzae) {
        this.f = list;
        this.g = z;
        this.h = z2;
        this.i = zzae;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 1, Collections.unmodifiableList(this.f), false);
        boolean z = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.A0(parcel, 5, this.i, i2, false);
        gj1.H1(parcel, o1);
    }
}
