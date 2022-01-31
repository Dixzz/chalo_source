package com.firebase.geofire.util;

import com.firebase.geofire.GeoLocation;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class GeoUtils {
    private GeoUtils() {
    }

    public static double distance(GeoLocation geoLocation, GeoLocation geoLocation2) {
        return distance(geoLocation.latitude, geoLocation.longitude, geoLocation2.latitude, geoLocation2.longitude);
    }

    public static double distanceToLatitudeDegrees(double d) {
        return d / 110574.0d;
    }

    public static double distanceToLongitudeDegrees(double d, double d2) {
        double radians = Math.toRadians(d2);
        double sqrt = (1.0d / Math.sqrt(1.0d - (Math.sin(radians) * (Math.sin(radians) * 0.00669447819799d)))) * (((Math.cos(radians) * 6378137.0d) * 3.141592653589793d) / 180.0d);
        if (sqrt >= 1.0E-12d) {
            return Math.min(360.0d, d / sqrt);
        }
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 360.0d;
        }
        return d;
    }

    public static double wrapLongitude(double d) {
        if (d >= -180.0d && d <= 180.0d) {
            return d;
        }
        double d2 = d + 180.0d;
        return d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (d2 % 360.0d) - 180.0d : 180.0d - ((-d2) % 360.0d);
    }

    public static double distance(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d - d3);
        double radians2 = Math.toRadians(d2 - d4);
        double d5 = radians / 2.0d;
        double sin = Math.sin(d5);
        double cos = Math.cos(Math.toRadians(d3)) * Math.cos(Math.toRadians(d));
        double d6 = radians2 / 2.0d;
        double sin2 = (Math.sin(d6) * Math.sin(d6) * cos) + (Math.sin(d5) * sin);
        return Math.atan2(Math.sqrt(sin2), Math.sqrt(1.0d - sin2)) * 1.27359893E7d;
    }
}
