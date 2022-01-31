package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new q54();
    public Boolean f;
    public Boolean g;
    public int h = -1;
    public CameraPosition i;
    public Boolean j;
    public Boolean k;
    public Boolean l;
    public Boolean m;
    public Boolean n;
    public Boolean o;
    public Boolean p;
    public Boolean q;
    public Boolean r;
    public Float s = null;
    public Float t = null;
    public LatLngBounds u = null;
    public Boolean v;

    public GoogleMapOptions(byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f2, Float f3, LatLngBounds latLngBounds, byte b12) {
        this.f = hd3.y3(b);
        this.g = hd3.y3(b2);
        this.h = i2;
        this.i = cameraPosition;
        this.j = hd3.y3(b3);
        this.k = hd3.y3(b4);
        this.l = hd3.y3(b5);
        this.m = hd3.y3(b6);
        this.n = hd3.y3(b7);
        this.o = hd3.y3(b8);
        this.p = hd3.y3(b9);
        this.q = hd3.y3(b10);
        this.r = hd3.y3(b11);
        this.s = f2;
        this.t = f3;
        this.u = latLngBounds;
        this.v = hd3.y3(b12);
    }

    public static GoogleMapOptions l1(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i2 = R.styleable.MapAttrs_mapType;
        if (obtainAttributes.hasValue(i2)) {
            googleMapOptions.h = obtainAttributes.getInt(i2, -1);
        }
        int i3 = R.styleable.MapAttrs_zOrderOnTop;
        if (obtainAttributes.hasValue(i3)) {
            googleMapOptions.f = Boolean.valueOf(obtainAttributes.getBoolean(i3, false));
        }
        int i4 = R.styleable.MapAttrs_useViewLifecycle;
        if (obtainAttributes.hasValue(i4)) {
            googleMapOptions.g = Boolean.valueOf(obtainAttributes.getBoolean(i4, false));
        }
        int i5 = R.styleable.MapAttrs_uiCompass;
        if (obtainAttributes.hasValue(i5)) {
            googleMapOptions.k = Boolean.valueOf(obtainAttributes.getBoolean(i5, true));
        }
        int i6 = R.styleable.MapAttrs_uiRotateGestures;
        if (obtainAttributes.hasValue(i6)) {
            googleMapOptions.o = Boolean.valueOf(obtainAttributes.getBoolean(i6, true));
        }
        int i7 = R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
        if (obtainAttributes.hasValue(i7)) {
            googleMapOptions.v = Boolean.valueOf(obtainAttributes.getBoolean(i7, true));
        }
        int i8 = R.styleable.MapAttrs_uiScrollGestures;
        if (obtainAttributes.hasValue(i8)) {
            googleMapOptions.l = Boolean.valueOf(obtainAttributes.getBoolean(i8, true));
        }
        int i9 = R.styleable.MapAttrs_uiTiltGestures;
        if (obtainAttributes.hasValue(i9)) {
            googleMapOptions.n = Boolean.valueOf(obtainAttributes.getBoolean(i9, true));
        }
        int i10 = R.styleable.MapAttrs_uiZoomGestures;
        if (obtainAttributes.hasValue(i10)) {
            googleMapOptions.m = Boolean.valueOf(obtainAttributes.getBoolean(i10, true));
        }
        int i11 = R.styleable.MapAttrs_uiZoomControls;
        if (obtainAttributes.hasValue(i11)) {
            googleMapOptions.j = Boolean.valueOf(obtainAttributes.getBoolean(i11, true));
        }
        int i12 = R.styleable.MapAttrs_liteMode;
        if (obtainAttributes.hasValue(i12)) {
            googleMapOptions.p = Boolean.valueOf(obtainAttributes.getBoolean(i12, false));
        }
        int i13 = R.styleable.MapAttrs_uiMapToolbar;
        if (obtainAttributes.hasValue(i13)) {
            googleMapOptions.q = Boolean.valueOf(obtainAttributes.getBoolean(i13, true));
        }
        int i14 = R.styleable.MapAttrs_ambientEnabled;
        if (obtainAttributes.hasValue(i14)) {
            googleMapOptions.r = Boolean.valueOf(obtainAttributes.getBoolean(i14, false));
        }
        int i15 = R.styleable.MapAttrs_cameraMinZoomPreference;
        if (obtainAttributes.hasValue(i15)) {
            googleMapOptions.s = Float.valueOf(obtainAttributes.getFloat(i15, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(i15)) {
            googleMapOptions.t = Float.valueOf(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.u = m1(context, attributeSet);
        googleMapOptions.i = n1(context, attributeSet);
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds m1(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i2 = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        Float valueOf = obtainAttributes.hasValue(i2) ? Float.valueOf(obtainAttributes.getFloat(i2, 0.0f)) : null;
        int i3 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        Float valueOf2 = obtainAttributes.hasValue(i3) ? Float.valueOf(obtainAttributes.getFloat(i3, 0.0f)) : null;
        int i4 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        Float valueOf3 = obtainAttributes.hasValue(i4) ? Float.valueOf(obtainAttributes.getFloat(i4, 0.0f)) : null;
        int i5 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        Float valueOf4 = obtainAttributes.hasValue(i5) ? Float.valueOf(obtainAttributes.getFloat(i5, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static CameraPosition n1(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i2 = R.styleable.MapAttrs_cameraTargetLat;
        float f2 = obtainAttributes.hasValue(i2) ? obtainAttributes.getFloat(i2, 0.0f) : 0.0f;
        int i3 = R.styleable.MapAttrs_cameraTargetLng;
        LatLng latLng = new LatLng((double) f2, (double) (obtainAttributes.hasValue(i3) ? obtainAttributes.getFloat(i3, 0.0f) : 0.0f));
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        int i4 = R.styleable.MapAttrs_cameraZoom;
        if (obtainAttributes.hasValue(i4)) {
            builder.zoom(obtainAttributes.getFloat(i4, 0.0f));
        }
        int i5 = R.styleable.MapAttrs_cameraBearing;
        if (obtainAttributes.hasValue(i5)) {
            builder.bearing(obtainAttributes.getFloat(i5, 0.0f));
        }
        int i6 = R.styleable.MapAttrs_cameraTilt;
        if (obtainAttributes.hasValue(i6)) {
            builder.tilt(obtainAttributes.getFloat(i6, 0.0f));
        }
        obtainAttributes.recycle();
        return builder.build();
    }

    public final String toString() {
        g82 g82 = new g82(this);
        g82.a("MapType", Integer.valueOf(this.h));
        g82.a("LiteMode", this.p);
        g82.a("Camera", this.i);
        g82.a("CompassEnabled", this.k);
        g82.a("ZoomControlsEnabled", this.j);
        g82.a("ScrollGesturesEnabled", this.l);
        g82.a("ZoomGesturesEnabled", this.m);
        g82.a("TiltGesturesEnabled", this.n);
        g82.a("RotateGesturesEnabled", this.o);
        g82.a("ScrollGesturesEnabledDuringRotateOrZoom", this.v);
        g82.a("MapToolbarEnabled", this.q);
        g82.a("AmbientEnabled", this.r);
        g82.a("MinZoomPreference", this.s);
        g82.a("MaxZoomPreference", this.t);
        g82.a("LatLngBoundsForCameraTarget", this.u);
        g82.a("ZOrderOnTop", this.f);
        g82.a("UseViewLifecycleInFragment", this.g);
        return g82.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        byte k3 = hd3.k3(this.f);
        parcel.writeInt(262146);
        parcel.writeInt(k3);
        byte k32 = hd3.k3(this.g);
        parcel.writeInt(262147);
        parcel.writeInt(k32);
        int i3 = this.h;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        gj1.A0(parcel, 5, this.i, i2, false);
        byte k33 = hd3.k3(this.j);
        parcel.writeInt(262150);
        parcel.writeInt(k33);
        byte k34 = hd3.k3(this.k);
        parcel.writeInt(262151);
        parcel.writeInt(k34);
        byte k35 = hd3.k3(this.l);
        parcel.writeInt(262152);
        parcel.writeInt(k35);
        byte k36 = hd3.k3(this.m);
        parcel.writeInt(262153);
        parcel.writeInt(k36);
        byte k37 = hd3.k3(this.n);
        parcel.writeInt(262154);
        parcel.writeInt(k37);
        byte k38 = hd3.k3(this.o);
        parcel.writeInt(262155);
        parcel.writeInt(k38);
        byte k39 = hd3.k3(this.p);
        parcel.writeInt(262156);
        parcel.writeInt(k39);
        byte k310 = hd3.k3(this.q);
        parcel.writeInt(262158);
        parcel.writeInt(k310);
        byte k311 = hd3.k3(this.r);
        parcel.writeInt(262159);
        parcel.writeInt(k311);
        gj1.w0(parcel, 16, this.s, false);
        gj1.w0(parcel, 17, this.t, false);
        gj1.A0(parcel, 18, this.u, i2, false);
        byte k312 = hd3.k3(this.v);
        parcel.writeInt(262163);
        parcel.writeInt(k312);
        gj1.H1(parcel, o1);
    }

    public GoogleMapOptions() {
    }
}
