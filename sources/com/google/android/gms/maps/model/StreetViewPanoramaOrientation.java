package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new zzp();
    public final float bearing;
    public final float tilt;

    public static final class Builder {
        public float bearing;
        public float tilt;

        public Builder() {
        }

        public final Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public final StreetViewPanoramaOrientation build() {
            return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
        }

        public final Builder tilt(float f) {
            this.tilt = f;
            return this;
        }

        public Builder(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            gj1.l(streetViewPanoramaOrientation, "StreetViewPanoramaOrientation");
            this.bearing = streetViewPanoramaOrientation.bearing;
            this.tilt = streetViewPanoramaOrientation.tilt;
        }
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        boolean z = -90.0f <= f && f <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f);
        gj1.c(z, sb.toString());
        this.tilt = f + 0.0f;
        this.bearing = (((double) f2) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaOrientation.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaOrientation.bearing);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
    }

    public String toString() {
        g82 g82 = new g82(this);
        g82.a("tilt", Float.valueOf(this.tilt));
        g82.a("bearing", Float.valueOf(this.bearing));
        return g82.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        float f = this.tilt;
        parcel.writeInt(262146);
        parcel.writeFloat(f);
        float f2 = this.bearing;
        parcel.writeInt(262147);
        parcel.writeFloat(f2);
        gj1.H1(parcel, o1);
    }

    public static Builder builder(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        return new Builder(streetViewPanoramaOrientation);
    }
}
