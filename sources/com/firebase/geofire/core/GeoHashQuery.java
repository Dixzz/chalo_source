package com.firebase.geofire.core;

import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.util.Base32Utils;
import com.firebase.geofire.util.GeoUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GeoHashQuery {
    private final String endValue;
    private final String startValue;

    public static class Utils {
        private Utils() {
        }

        public static int bitsForBoundingBox(GeoLocation geoLocation, double d) {
            double distanceToLatitudeDegrees = GeoUtils.distanceToLatitudeDegrees(d);
            return Math.min(((int) Math.floor(bitsLatitude(d))) * 2, Math.min((((int) Math.floor(bitsLongitude(d, Math.min(90.0d, geoLocation.latitude + distanceToLatitudeDegrees)))) * 2) - 1, (((int) Math.floor(bitsLongitude(d, Math.max(-90.0d, geoLocation.latitude - distanceToLatitudeDegrees)))) * 2) - 1));
        }

        public static double bitsLatitude(double d) {
            return Math.min(Math.log(2.000393E7d / d) / Math.log(2.0d), 110.0d);
        }

        public static double bitsLongitude(double d, double d2) {
            double distanceToLongitudeDegrees = GeoUtils.distanceToLongitudeDegrees(d, d2);
            if (Math.abs(distanceToLongitudeDegrees) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return Math.max(1.0d, Math.log(360.0d / distanceToLongitudeDegrees) / Math.log(2.0d));
            }
            return 1.0d;
        }
    }

    public GeoHashQuery(String str, String str2) {
        this.startValue = str;
        this.endValue = str2;
    }

    private boolean isPrefix(GeoHashQuery geoHashQuery) {
        return geoHashQuery.endValue.compareTo(this.startValue) >= 0 && geoHashQuery.startValue.compareTo(this.startValue) < 0 && geoHashQuery.endValue.compareTo(this.endValue) < 0;
    }

    private boolean isSuperQuery(GeoHashQuery geoHashQuery) {
        if (geoHashQuery.startValue.compareTo(this.startValue) > 0 || geoHashQuery.endValue.compareTo(this.endValue) < 0) {
            return false;
        }
        return true;
    }

    public static Set<GeoHashQuery> queriesAtLocation(GeoLocation geoLocation, double d) {
        boolean z;
        int max = Math.max(1, Utils.bitsForBoundingBox(geoLocation, d));
        int ceil = (int) Math.ceil((double) (max / 5));
        double d2 = geoLocation.latitude;
        double d3 = geoLocation.longitude;
        double d4 = d / 110574.0d;
        double min = Math.min(90.0d, d2 + d4);
        double max2 = Math.max(-90.0d, d2 - d4);
        double max3 = Math.max(GeoUtils.distanceToLongitudeDegrees(d, min), GeoUtils.distanceToLongitudeDegrees(d, max2));
        HashSet hashSet = new HashSet();
        GeoHash geoHash = new GeoHash(d2, d3, ceil);
        double d5 = d3 - max3;
        GeoHash geoHash2 = new GeoHash(d2, GeoUtils.wrapLongitude(d5), ceil);
        double d6 = d3 + max3;
        GeoHash geoHash3 = new GeoHash(d2, GeoUtils.wrapLongitude(d6), ceil);
        GeoHash geoHash4 = new GeoHash(min, d3, ceil);
        GeoHash geoHash5 = new GeoHash(min, GeoUtils.wrapLongitude(d5), ceil);
        GeoHash geoHash6 = new GeoHash(min, GeoUtils.wrapLongitude(d6), ceil);
        GeoHash geoHash7 = new GeoHash(max2, d3, ceil);
        GeoHash geoHash8 = new GeoHash(max2, GeoUtils.wrapLongitude(d5), ceil);
        GeoHash geoHash9 = new GeoHash(max2, GeoUtils.wrapLongitude(d6), ceil);
        hashSet.add(queryForGeoHash(geoHash, max));
        hashSet.add(queryForGeoHash(geoHash3, max));
        hashSet.add(queryForGeoHash(geoHash2, max));
        hashSet.add(queryForGeoHash(geoHash4, max));
        hashSet.add(queryForGeoHash(geoHash6, max));
        hashSet.add(queryForGeoHash(geoHash5, max));
        hashSet.add(queryForGeoHash(geoHash7, max));
        hashSet.add(queryForGeoHash(geoHash9, max));
        hashSet.add(queryForGeoHash(geoHash8, max));
        do {
            Iterator it = hashSet.iterator();
            GeoHashQuery geoHashQuery = null;
            GeoHashQuery geoHashQuery2 = null;
            while (it.hasNext()) {
                GeoHashQuery geoHashQuery3 = (GeoHashQuery) it.next();
                Iterator it2 = hashSet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        GeoHashQuery geoHashQuery4 = (GeoHashQuery) it2.next();
                        if (geoHashQuery3 != geoHashQuery4 && geoHashQuery3.canJoinWith(geoHashQuery4)) {
                            geoHashQuery = geoHashQuery3;
                            geoHashQuery2 = geoHashQuery4;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (geoHashQuery == null || geoHashQuery2 == null) {
                z = false;
                continue;
            } else {
                hashSet.remove(geoHashQuery);
                hashSet.remove(geoHashQuery2);
                hashSet.add(geoHashQuery.joinWith(geoHashQuery2));
                z = true;
                continue;
            }
        } while (z);
        return hashSet;
    }

    public static GeoHashQuery queryForGeoHash(GeoHash geoHash, int i) {
        String str;
        String geoHashString = geoHash.getGeoHashString();
        int ceil = (int) Math.ceil(((double) i) / 5.0d);
        if (geoHashString.length() < ceil) {
            return new GeoHashQuery(geoHashString, hj1.S(geoHashString, "~"));
        }
        String substring = geoHashString.substring(0, ceil);
        String substring2 = substring.substring(0, substring.length() - 1);
        int base32CharToValue = Base32Utils.base32CharToValue(substring.charAt(substring.length() - 1));
        int length = 5 - (i - (substring2.length() * 5));
        int i2 = (base32CharToValue >> length) << length;
        int i3 = (1 << length) + i2;
        StringBuilder i0 = hj1.i0(substring2);
        i0.append(Base32Utils.valueToBase32Char(i2));
        String sb = i0.toString();
        if (i3 > 31) {
            str = hj1.S(substring2, "~");
        } else {
            StringBuilder i02 = hj1.i0(substring2);
            i02.append(Base32Utils.valueToBase32Char(i3));
            str = i02.toString();
        }
        return new GeoHashQuery(sb, str);
    }

    public boolean canJoinWith(GeoHashQuery geoHashQuery) {
        return isPrefix(geoHashQuery) || geoHashQuery.isPrefix(this) || isSuperQuery(geoHashQuery) || geoHashQuery.isSuperQuery(this);
    }

    public boolean containsGeoHash(GeoHash geoHash) {
        String geoHashString = geoHash.getGeoHashString();
        return this.startValue.compareTo(geoHashString) <= 0 && this.endValue.compareTo(geoHashString) > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeoHashQuery geoHashQuery = (GeoHashQuery) obj;
        return this.endValue.equals(geoHashQuery.endValue) && this.startValue.equals(geoHashQuery.startValue);
    }

    public String getEndValue() {
        return this.endValue;
    }

    public String getStartValue() {
        return this.startValue;
    }

    public int hashCode() {
        return this.endValue.hashCode() + (this.startValue.hashCode() * 31);
    }

    public GeoHashQuery joinWith(GeoHashQuery geoHashQuery) {
        if (geoHashQuery.isPrefix(this)) {
            return new GeoHashQuery(this.startValue, geoHashQuery.endValue);
        }
        if (isPrefix(geoHashQuery)) {
            return new GeoHashQuery(geoHashQuery.startValue, this.endValue);
        }
        if (isSuperQuery(geoHashQuery)) {
            return geoHashQuery;
        }
        if (geoHashQuery.isSuperQuery(this)) {
            return this;
        }
        throw new IllegalArgumentException("Can't join these 2 queries: " + this + ", " + geoHashQuery);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("GeoHashQuery{startValue='");
        hj1.U0(i0, this.startValue, '\'', ", endValue='");
        i0.append(this.endValue);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
