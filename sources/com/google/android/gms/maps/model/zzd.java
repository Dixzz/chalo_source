package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzd implements Parcelable.Creator<GroundOverlayOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GroundOverlayOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        IBinder iBinder = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    iBinder = gj1.f0(parcel, readInt);
                    break;
                case 3:
                    latLng = (LatLng) gj1.w(parcel, readInt, LatLng.CREATOR);
                    break;
                case 4:
                    f = gj1.d0(parcel, readInt);
                    break;
                case 5:
                    f2 = gj1.d0(parcel, readInt);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) gj1.w(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = gj1.d0(parcel, readInt);
                    break;
                case '\b':
                    f4 = gj1.d0(parcel, readInt);
                    break;
                case '\t':
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\n':
                    f5 = gj1.d0(parcel, readInt);
                    break;
                case 11:
                    f6 = gj1.d0(parcel, readInt);
                    break;
                case '\f':
                    f7 = gj1.d0(parcel, readInt);
                    break;
                case '\r':
                    z2 = gj1.Z(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new GroundOverlayOptions(iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
