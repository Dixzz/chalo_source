package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.ic2;

public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzh();
    private float alpha = 1.0f;
    private LatLng position;
    private float zzcs;
    private boolean zzct = true;
    private float zzdb = 0.5f;
    private float zzdc = 1.0f;
    private String zzdn;
    private String zzdo;
    private BitmapDescriptor zzdp;
    private boolean zzdq;
    private boolean zzdr = false;
    private float zzds = 0.0f;
    private float zzdt = 0.5f;
    private float zzdu = 0.0f;

    public MarkerOptions() {
    }

    public final MarkerOptions alpha(float f) {
        this.alpha = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f2) {
        this.zzdb = f;
        this.zzdc = f2;
        return this;
    }

    public final MarkerOptions draggable(boolean z) {
        this.zzdq = z;
        return this;
    }

    public final MarkerOptions flat(boolean z) {
        this.zzdr = z;
        return this;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAnchorU() {
        return this.zzdb;
    }

    public final float getAnchorV() {
        return this.zzdc;
    }

    public final BitmapDescriptor getIcon() {
        return this.zzdp;
    }

    public final float getInfoWindowAnchorU() {
        return this.zzdt;
    }

    public final float getInfoWindowAnchorV() {
        return this.zzdu;
    }

    public final LatLng getPosition() {
        return this.position;
    }

    public final float getRotation() {
        return this.zzds;
    }

    public final String getSnippet() {
        return this.zzdo;
    }

    public final String getTitle() {
        return this.zzdn;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.zzdp = bitmapDescriptor;
        return this;
    }

    public final MarkerOptions infoWindowAnchor(float f, float f2) {
        this.zzdt = f;
        this.zzdu = f2;
        return this;
    }

    public final boolean isDraggable() {
        return this.zzdq;
    }

    public final boolean isFlat() {
        return this.zzdr;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.position = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    public final MarkerOptions rotation(float f) {
        this.zzds = f;
        return this;
    }

    public final MarkerOptions snippet(String str) {
        this.zzdo = str;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.zzdn = str;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 2, getPosition(), i, false);
        gj1.B0(parcel, 3, getTitle(), false);
        gj1.B0(parcel, 4, getSnippet(), false);
        BitmapDescriptor bitmapDescriptor = this.zzdp;
        if (bitmapDescriptor == null) {
            iBinder = null;
        } else {
            iBinder = bitmapDescriptor.zzb().asBinder();
        }
        gj1.x0(parcel, 5, iBinder, false);
        float anchorU = getAnchorU();
        parcel.writeInt(262150);
        parcel.writeFloat(anchorU);
        float anchorV = getAnchorV();
        parcel.writeInt(262151);
        parcel.writeFloat(anchorV);
        boolean isDraggable = isDraggable();
        parcel.writeInt(262152);
        parcel.writeInt(isDraggable ? 1 : 0);
        boolean isVisible = isVisible();
        parcel.writeInt(262153);
        parcel.writeInt(isVisible ? 1 : 0);
        boolean isFlat = isFlat();
        parcel.writeInt(262154);
        parcel.writeInt(isFlat ? 1 : 0);
        float rotation = getRotation();
        parcel.writeInt(262155);
        parcel.writeFloat(rotation);
        float infoWindowAnchorU = getInfoWindowAnchorU();
        parcel.writeInt(262156);
        parcel.writeFloat(infoWindowAnchorU);
        float infoWindowAnchorV = getInfoWindowAnchorV();
        parcel.writeInt(262157);
        parcel.writeFloat(infoWindowAnchorV);
        float alpha2 = getAlpha();
        parcel.writeInt(262158);
        parcel.writeFloat(alpha2);
        float zIndex = getZIndex();
        parcel.writeInt(262159);
        parcel.writeFloat(zIndex);
        gj1.H1(parcel, o1);
    }

    public final MarkerOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.position = latLng;
        this.zzdn = str;
        this.zzdo = str2;
        if (iBinder == null) {
            this.zzdp = null;
        } else {
            this.zzdp = new BitmapDescriptor(ic2.a.F(iBinder));
        }
        this.zzdb = f;
        this.zzdc = f2;
        this.zzdq = z;
        this.zzct = z2;
        this.zzdr = z3;
        this.zzds = f3;
        this.zzdt = f4;
        this.zzdu = f5;
        this.alpha = f6;
        this.zzcs = f7;
    }
}
