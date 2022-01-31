package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LocationSettingsResult extends AbstractSafeParcelable implements f32 {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new o34();
    public final Status f;
    public final LocationSettingsStates g;

    public LocationSettingsResult(Status status) {
        this.f = status;
        this.g = null;
    }

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f = status;
        this.g = locationSettingsStates;
    }

    @Override // defpackage.f32
    public final Status M0() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.A0(parcel, 2, this.g, i, false);
        gj1.H1(parcel, o1);
    }
}
