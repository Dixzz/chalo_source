package com.firebase.geofire;

import java.util.Map;

public final class GeoLocation {
    public final double latitude;
    public final double longitude;
    public final Map map;

    public GeoLocation(double d, double d2, Map<String, Object> map2) {
        if (coordinatesValid(d, d2)) {
            this.latitude = d;
            this.longitude = d2;
            this.map = map2;
            return;
        }
        throw new IllegalArgumentException("Not a valid geo location: " + d + ", " + d2);
    }

    public static boolean coordinatesValid(double d, double d2) {
        return d >= -90.0d && d <= 90.0d && d2 >= -180.0d && d2 <= 180.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeoLocation.class != obj.getClass()) {
            return false;
        }
        GeoLocation geoLocation = (GeoLocation) obj;
        return Double.compare(geoLocation.latitude, this.latitude) == 0 && Double.compare(geoLocation.longitude, this.longitude) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("GeoLocation(");
        i0.append(this.latitude);
        i0.append(", ");
        return hj1.U(i0, this.longitude, ")");
    }
}
