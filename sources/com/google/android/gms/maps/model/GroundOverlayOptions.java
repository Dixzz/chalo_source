package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.ic2;

public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzd();
    public static final float NO_DIMENSION = -1.0f;
    private float bearing;
    private float height;
    private float width;
    private float zzcs;
    private boolean zzct = true;
    private boolean zzcu = false;
    private BitmapDescriptor zzcx;
    private LatLng zzcy;
    private LatLngBounds zzcz;
    private float zzda = 0.0f;
    private float zzdb = 0.5f;
    private float zzdc = 0.5f;

    public GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.zzcx = new BitmapDescriptor(ic2.a.F(iBinder));
        this.zzcy = latLng;
        this.width = f;
        this.height = f2;
        this.zzcz = latLngBounds;
        this.bearing = f3;
        this.zzcs = f4;
        this.zzct = z;
        this.zzda = f5;
        this.zzdb = f6;
        this.zzdc = f7;
        this.zzcu = z2;
    }

    private final GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzcy = latLng;
        this.width = f;
        this.height = f2;
        return this;
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        this.zzdb = f;
        this.zzdc = f2;
        return this;
    }

    public final GroundOverlayOptions bearing(float f) {
        this.bearing = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public final GroundOverlayOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final float getAnchorU() {
        return this.zzdb;
    }

    public final float getAnchorV() {
        return this.zzdc;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public final LatLngBounds getBounds() {
        return this.zzcz;
    }

    public final float getHeight() {
        return this.height;
    }

    public final BitmapDescriptor getImage() {
        return this.zzcx;
    }

    public final LatLng getLocation() {
        return this.zzcy;
    }

    public final float getTransparency() {
        return this.zzda;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        gj1.l(bitmapDescriptor, "imageDescriptor must not be null");
        this.zzcx = bitmapDescriptor;
        return this;
    }

    public final boolean isClickable() {
        return this.zzcu;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        gj1.o(this.zzcz == null, "Position has already been set using positionFromBounds");
        gj1.c(latLng != null, "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        gj1.c(z, "Width must be non-negative");
        return zza(latLng, f, -1.0f);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        LatLng latLng = this.zzcy;
        boolean z = latLng == null;
        String valueOf = String.valueOf(latLng);
        StringBuilder sb = new StringBuilder(valueOf.length() + 46);
        sb.append("Position has already been set using position: ");
        sb.append(valueOf);
        gj1.o(z, sb.toString());
        this.zzcz = latLngBounds;
        return this;
    }

    public final GroundOverlayOptions transparency(float f) {
        gj1.c(f >= 0.0f && f <= 1.0f, "Transparency must be in the range [0..1]");
        this.zzda = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.x0(parcel, 2, this.zzcx.zzb().asBinder(), false);
        gj1.A0(parcel, 3, getLocation(), i, false);
        float width2 = getWidth();
        parcel.writeInt(262148);
        parcel.writeFloat(width2);
        float height2 = getHeight();
        parcel.writeInt(262149);
        parcel.writeFloat(height2);
        gj1.A0(parcel, 6, getBounds(), i, false);
        float bearing2 = getBearing();
        parcel.writeInt(262151);
        parcel.writeFloat(bearing2);
        float zIndex = getZIndex();
        parcel.writeInt(262152);
        parcel.writeFloat(zIndex);
        boolean isVisible = isVisible();
        parcel.writeInt(262153);
        parcel.writeInt(isVisible ? 1 : 0);
        float transparency = getTransparency();
        parcel.writeInt(262154);
        parcel.writeFloat(transparency);
        float anchorU = getAnchorU();
        parcel.writeInt(262155);
        parcel.writeFloat(anchorU);
        float anchorV = getAnchorV();
        parcel.writeInt(262156);
        parcel.writeFloat(anchorV);
        boolean isClickable = isClickable();
        parcel.writeInt(262157);
        parcel.writeInt(isClickable ? 1 : 0);
        gj1.H1(parcel, o1);
    }

    public final GroundOverlayOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        gj1.o(this.zzcz == null, "Position has already been set using positionFromBounds");
        gj1.c(latLng != null, "Location must be specified");
        gj1.c(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        gj1.c(z, "Height must be non-negative");
        return zza(latLng, f, f2);
    }

    public GroundOverlayOptions() {
    }
}
