package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class PointOfInterest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzj();
    public final LatLng latLng;
    public final String name;
    public final String placeId;

    public PointOfInterest(LatLng latLng2, String str, String str2) {
        this.latLng = latLng2;
        this.placeId = str;
        this.name = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 2, this.latLng, i, false);
        gj1.B0(parcel, 3, this.placeId, false);
        gj1.B0(parcel, 4, this.name, false);
        gj1.H1(parcel, o1);
    }
}
