package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
    private int fillColor = 0;
    private int strokeColor = -16777216;
    private LatLng zzcp = null;
    private double zzcq = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private float zzcr = 10.0f;
    private float zzcs = 0.0f;
    private boolean zzct = true;
    private boolean zzcu = false;
    private List<PatternItem> zzcv = null;

    public CircleOptions() {
    }

    public final CircleOptions center(LatLng latLng) {
        this.zzcp = latLng;
        return this;
    }

    public final CircleOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final CircleOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.zzcp;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final double getRadius() {
        return this.zzcq;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final List<PatternItem> getStrokePattern() {
        return this.zzcv;
    }

    public final float getStrokeWidth() {
        return this.zzcr;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isClickable() {
        return this.zzcu;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final CircleOptions radius(double d) {
        this.zzcq = d;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final CircleOptions strokePattern(List<PatternItem> list) {
        this.zzcv = list;
        return this;
    }

    public final CircleOptions strokeWidth(float f) {
        this.zzcr = f;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 2, getCenter(), i, false);
        double radius = getRadius();
        parcel.writeInt(524291);
        parcel.writeDouble(radius);
        float strokeWidth = getStrokeWidth();
        parcel.writeInt(262148);
        parcel.writeFloat(strokeWidth);
        int strokeColor2 = getStrokeColor();
        parcel.writeInt(262149);
        parcel.writeInt(strokeColor2);
        int fillColor2 = getFillColor();
        parcel.writeInt(262150);
        parcel.writeInt(fillColor2);
        float zIndex = getZIndex();
        parcel.writeInt(262151);
        parcel.writeFloat(zIndex);
        boolean isVisible = isVisible();
        parcel.writeInt(262152);
        parcel.writeInt(isVisible ? 1 : 0);
        boolean isClickable = isClickable();
        parcel.writeInt(262153);
        parcel.writeInt(isClickable ? 1 : 0);
        gj1.F0(parcel, 10, getStrokePattern(), false);
        gj1.H1(parcel, o1);
    }

    public final CircleOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public CircleOptions(LatLng latLng, double d, float f, int i, int i2, float f2, boolean z, boolean z2, List<PatternItem> list) {
        this.zzcp = latLng;
        this.zzcq = d;
        this.zzcr = f;
        this.strokeColor = i;
        this.fillColor = i2;
        this.zzcs = f2;
        this.zzct = z;
        this.zzcu = z2;
        this.zzcv = list;
    }
}
