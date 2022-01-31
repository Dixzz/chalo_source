package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.GoogleMapOptions;
import java.util.Arrays;

public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zze();
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zzdh = Double.POSITIVE_INFINITY;
        private double zzdi = Double.NEGATIVE_INFINITY;
        private double zzdj = Double.NaN;
        private double zzdk = Double.NaN;

        public final LatLngBounds build() {
            gj1.o(!Double.isNaN(this.zzdj), "no included points");
            return new LatLngBounds(new LatLng(this.zzdh, this.zzdj), new LatLng(this.zzdi, this.zzdk));
        }

        public final Builder include(LatLng latLng) {
            this.zzdh = Math.min(this.zzdh, latLng.latitude);
            this.zzdi = Math.max(this.zzdi, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.zzdj)) {
                this.zzdj = d;
            } else {
                double d2 = this.zzdj;
                double d3 = this.zzdk;
                boolean z = false;
                if (d2 > d3 ? d2 <= d || d <= d3 : d2 <= d && d <= d3) {
                    z = true;
                }
                if (!z) {
                    if (LatLngBounds.zza(d2, d) < LatLngBounds.zzb(this.zzdk, d)) {
                        this.zzdj = d;
                    }
                }
                return this;
            }
            this.zzdk = d;
            return this;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        gj1.l(latLng, "null southwest");
        gj1.l(latLng2, "null northeast");
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        gj1.e(d >= d2, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d2), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.m1(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public static double zza(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private final boolean zza(double d) {
        double d2 = this.southwest.longitude;
        double d3 = this.northeast.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    /* access modifiers changed from: private */
    public static double zzb(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        double d = latLng.latitude;
        return ((this.southwest.latitude > d ? 1 : (this.southwest.latitude == d ? 0 : -1)) <= 0 && (d > this.northeast.latitude ? 1 : (d == this.northeast.latitude ? 0 : -1)) <= 0) && zza(latLng.longitude);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final LatLng getCenter() {
        LatLng latLng = this.southwest;
        double d = latLng.latitude;
        LatLng latLng2 = this.northeast;
        double d2 = (d + latLng2.latitude) / 2.0d;
        double d3 = latLng2.longitude;
        double d4 = latLng.longitude;
        if (d4 > d3) {
            d3 += 360.0d;
        }
        return new LatLng(d2, (d3 + d4) / 2.0d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!zza(d3)) {
            if (zza(d2, d3) < zzb(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public final String toString() {
        g82 g82 = new g82(this);
        g82.a("southwest", this.southwest);
        g82.a("northeast", this.northeast);
        return g82.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 2, this.southwest, i, false);
        gj1.A0(parcel, 3, this.northeast, i, false);
        gj1.H1(parcel, o1);
    }
}
