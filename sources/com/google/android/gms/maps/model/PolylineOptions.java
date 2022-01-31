package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzl();
    private int color;
    private float width;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    private final List<LatLng> zzdx;
    private boolean zzdz;
    private Cap zzec;
    private Cap zzed;
    private int zzee;
    private List<PatternItem> zzef;

    public PolylineOptions() {
        this.width = 10.0f;
        this.color = -16777216;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzec = new ButtCap();
        this.zzed = new ButtCap();
        this.zzee = 0;
        this.zzef = null;
        this.zzdx = new ArrayList();
    }

    public final PolylineOptions add(LatLng latLng) {
        this.zzdx.add(latLng);
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.zzdx.add(latLng);
        }
        return this;
    }

    public final PolylineOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final PolylineOptions color(int i) {
        this.color = i;
        return this;
    }

    public final PolylineOptions endCap(Cap cap) {
        gj1.l(cap, "endCap must not be null");
        this.zzed = cap;
        return this;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.zzdz = z;
        return this;
    }

    public final int getColor() {
        return this.color;
    }

    public final Cap getEndCap() {
        return this.zzed;
    }

    public final int getJointType() {
        return this.zzee;
    }

    public final List<PatternItem> getPattern() {
        return this.zzef;
    }

    public final List<LatLng> getPoints() {
        return this.zzdx;
    }

    public final Cap getStartCap() {
        return this.zzec;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isClickable() {
        return this.zzcu;
    }

    public final boolean isGeodesic() {
        return this.zzdz;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final PolylineOptions jointType(int i) {
        this.zzee = i;
        return this;
    }

    public final PolylineOptions pattern(List<PatternItem> list) {
        this.zzef = list;
        return this;
    }

    public final PolylineOptions startCap(Cap cap) {
        gj1.l(cap, "startCap must not be null");
        this.zzec = cap;
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final PolylineOptions width(float f) {
        this.width = f;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 2, getPoints(), false);
        float width2 = getWidth();
        parcel.writeInt(262147);
        parcel.writeFloat(width2);
        int color2 = getColor();
        parcel.writeInt(262148);
        parcel.writeInt(color2);
        float zIndex = getZIndex();
        parcel.writeInt(262149);
        parcel.writeFloat(zIndex);
        boolean isVisible = isVisible();
        parcel.writeInt(262150);
        parcel.writeInt(isVisible ? 1 : 0);
        boolean isGeodesic = isGeodesic();
        parcel.writeInt(262151);
        parcel.writeInt(isGeodesic ? 1 : 0);
        boolean isClickable = isClickable();
        parcel.writeInt(262152);
        parcel.writeInt(isClickable ? 1 : 0);
        gj1.A0(parcel, 9, getStartCap(), i, false);
        gj1.A0(parcel, 10, getEndCap(), i, false);
        int jointType = getJointType();
        parcel.writeInt(262155);
        parcel.writeInt(jointType);
        gj1.F0(parcel, 12, getPattern(), false);
        gj1.H1(parcel, o1);
    }

    public final PolylineOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        this.zzdx.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions(List list, float f, int i, float f2, boolean z, boolean z2, boolean z3, Cap cap, Cap cap2, int i2, List<PatternItem> list2) {
        this.width = 10.0f;
        this.color = -16777216;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzec = new ButtCap();
        this.zzed = new ButtCap();
        this.zzee = 0;
        this.zzef = null;
        this.zzdx = list;
        this.width = f;
        this.color = i;
        this.zzcs = f2;
        this.zzct = z;
        this.zzdz = z2;
        this.zzcu = z3;
        if (cap != null) {
            this.zzec = cap;
        }
        if (cap2 != null) {
            this.zzed = cap2;
        }
        this.zzee = i2;
        this.zzef = list2;
    }
}
