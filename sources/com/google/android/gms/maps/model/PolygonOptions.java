package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzk();
    private int fillColor;
    private int strokeColor;
    private float zzcr;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    private List<PatternItem> zzcv;
    private final List<LatLng> zzdx;
    private final List<List<LatLng>> zzdy;
    private boolean zzdz;
    private int zzea;

    public PolygonOptions() {
        this.zzcr = 10.0f;
        this.strokeColor = -16777216;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzea = 0;
        this.zzcv = null;
        this.zzdx = new ArrayList();
        this.zzdy = new ArrayList();
    }

    public final PolygonOptions add(LatLng latLng) {
        this.zzdx.add(latLng);
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.zzdx.add(latLng);
        }
        return this;
    }

    public final PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : iterable) {
            arrayList.add(latLng);
        }
        this.zzdy.add(arrayList);
        return this;
    }

    public final PolygonOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean z) {
        this.zzdz = z;
        return this;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<List<LatLng>> getHoles() {
        return this.zzdy;
    }

    public final List<LatLng> getPoints() {
        return this.zzdx;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeJointType() {
        return this.zzea;
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

    public final boolean isGeodesic() {
        return this.zzdz;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final PolygonOptions strokeJointType(int i) {
        this.zzea = i;
        return this;
    }

    public final PolygonOptions strokePattern(List<PatternItem> list) {
        this.zzcv = list;
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        this.zzcr = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 2, getPoints(), false);
        List<List<LatLng>> list = this.zzdy;
        if (list != null) {
            int o12 = gj1.o1(parcel, 3);
            parcel.writeList(list);
            gj1.H1(parcel, o12);
        }
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
        boolean isGeodesic = isGeodesic();
        parcel.writeInt(262153);
        parcel.writeInt(isGeodesic ? 1 : 0);
        boolean isClickable = isClickable();
        parcel.writeInt(262154);
        parcel.writeInt(isClickable ? 1 : 0);
        int strokeJointType = getStrokeJointType();
        parcel.writeInt(262155);
        parcel.writeInt(strokeJointType);
        gj1.F0(parcel, 12, getStrokePattern(), false);
        gj1.H1(parcel, o1);
    }

    public final PolygonOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.zzdx.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions(List<LatLng> list, List list2, float f, int i, int i2, float f2, boolean z, boolean z2, boolean z3, int i3, List<PatternItem> list3) {
        this.zzcr = 10.0f;
        this.strokeColor = -16777216;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzea = 0;
        this.zzcv = null;
        this.zzdx = list;
        this.zzdy = list2;
        this.zzcr = f;
        this.strokeColor = i;
        this.fillColor = i2;
        this.zzcs = f2;
        this.zzct = z;
        this.zzdz = z2;
        this.zzcu = z3;
        this.zzea = i3;
        this.zzcv = list3;
    }
}
